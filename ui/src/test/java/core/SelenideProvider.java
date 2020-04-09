package core;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import lombok.NoArgsConstructor;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class SelenideProvider {

    public static void init() {
        Configuration.baseUrl = "http://";
        Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        Configuration.reportsFolder = "target/selenide-screenshots";
        Configuration.browserCapabilities = getCapabilities();
        Configuration.remote = "http://test:test-password@localhost:4444/wd/hub";
        Configuration.driverManagerEnabled = false;
    }

    public static void closeWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }

    public static SessionId getDriverSessionId() {
            return ((RemoteWebDriver)WebDriverRunner.getWebDriver()).getSessionId();
    }

    private static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        caps.setCapability("enableVNC", true);
        caps.setCapability("enableVideo", true);
        caps.setVersion("80.0");
        return caps;
    }

    public static InputStream getSelenoidVideo(URL url) {
        int lastSize = 0;
        int exit = 1;
        for (int i = 0; i < 20; i++) {
            try {
                int size = Integer.parseInt(url.openConnection().getHeaderField("Content-Length"));
                if (size > lastSize) {
                    lastSize = size;
                    Thread.sleep(1000);
                } else if (size == lastSize) {
                    exit--;
                    Thread.sleep(500);
                }
                if (exit < 0) {
                    //log.info("video ok!");
                    return url.openStream();
                }
            } catch (Exception e) {
                //log.info("getSelenoidVideo: " + e.getMessage());
            }
        }
        return null;
    }

    public static void deleteSelenoidVideo(URL url) {
        try {
            HttpURLConnection deleteConn = (HttpURLConnection) url.openConnection();
            deleteConn.setDoOutput(true);
            deleteConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            deleteConn.setRequestMethod("DELETE");
            deleteConn.connect();
            //log.info("delete selenoid video" + "\n" + deleteConn.getResponseCode()+ "\n" + deleteConn.getResponseMessage());
            deleteConn.disconnect();
        } catch (IOException e) {
            //log.info("delete selenoid video");
            e.printStackTrace();
        }
    }
}
