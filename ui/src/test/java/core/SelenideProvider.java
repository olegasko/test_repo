package core;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import lombok.NoArgsConstructor;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.util.Optional;
import java.util.logging.Level;

@NoArgsConstructor
public class SelenideProvider {

    public static void init() {
        Configuration.baseUrl = "http://";
        Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        Configuration.reportsFolder = "target/selenide-screenshots";
        Configuration.browserCapabilities = getCapabilities();
    }

    public static void closeWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }

    public static Optional<SessionId> getDriverSessionId() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            return Optional.of(((RemoteWebDriver)WebDriverRunner.getWebDriver()).getSessionId());
        }
        return Optional.empty();
    }

    private static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        caps.setVersion("79.0");
        return caps;
    }
}
