package core;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;

import static com.codeborne.selenide.Selenide.screenshot;
import static core.SelenideProvider.deleteSelenoidVideo;
import static core.SelenideProvider.getDriverSessionId;
import static core.SelenideProvider.getSelenoidVideo;

@TestPropertySource(value = {"classpath:config.properties"})
public class AllureAttachments {

    @Value("${selenoid.url}")
    private static String selenoidUiUrl;

    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                String screenshot = screenshot("screenshot_" + Instant.now().toEpochMilli());
                File file = new File(screenshot);
                InputStream stream = new FileInputStream(file);
                Allure.addAttachment("Screenshot", stream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void attachAllureVideo(Scenario scenario) {
        if(scenario.isFailed()) {
            try {
                String sessionId = getDriverSessionId().toString();
                URL videoUrl = new URL(selenoidUiUrl + "/video/" + sessionId + ".mp4");
                InputStream is = getSelenoidVideo(videoUrl);
                Allure.addAttachment("Video", "video/mp4", is, "mp4");
                deleteSelenoidVideo(videoUrl);
            } catch (Exception e) {
                //log.info("attache allure video");
                e.printStackTrace();
            }
        }
    }
}
