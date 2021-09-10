package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    MainPage page = new MainPage();

    @Given("on the EPAM main page")
    public void givenExample() {
        open("epam.com");
    }

    @When("click on Menu button")
    public void whenExample() {
        page.openLocationMenu();
    }

    @Then("menu is open")
    public void whenMenuIsOpen() {
        assertThat(page.isMenuVisible())
                .as("Menu is not visible")
                .isTrue();
    }

    //TODO assertion should be in separate 'then' step
    @Then("activate Location 'Global (EN)'")
    public void activateLocationGlobalEN() {
        page.activateLocationGlobalEN();
        assertThat(page.isLocationGlobalEN())
                .as("Location is not Global (EN)")
                .isTrue();
    }

    @Then("activate Location 'Україна (UA)'")
    public void activateLocationUkraineUA() {
        page.activateLocationUkraineUA();
        assertThat(page.isLocationUkraineUA())
                .as("Location is not Україна (UA)")
                .isTrue();
    }
}
