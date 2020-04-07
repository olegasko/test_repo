package core;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Instant;

import static com.codeborne.selenide.Selenide.screenshot;

public class AllureAttachments {

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
}
