package stepdefinitions;

import core.SelenideProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static core.AllureAttachments.attachAllureVideo;
import static core.AllureAttachments.takeScreenshot;

public class Conditions {

    @Before
    public void beforeScenario() {
        SelenideProvider.init();
    }

    @After
    public void afterScenario(Scenario scenario) {
        takeScreenshot(scenario);
        attachAllureVideo();
        SelenideProvider.closeWebDriver();
    }
}
