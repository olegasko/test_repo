package stepdefinitions;

import core.SelenideProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Conditions {

    @Before
    public void beforeScenario() {
        SelenideProvider.init();
    }

    @After
    public void afterScenario() {
        SelenideProvider.closeWebDriver();
    }
}
