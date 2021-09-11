package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    MainPage page = new MainPage();

    @Given("on the EPAM main page")
    public void givenOnTheEpamMainPage() {
        open("epam.com");
    }

    @When("click on Menu button")
    public void whenClickOnMenuButton() {
        page.openLocationMenu();
    }

    @Then("menu is open")
    public void thenMenuIsOpen() {
        assertThat(page.isMenuVisible())
                .as("Menu is not visible")
                .isTrue();
    }

    @Then("activate Location {string} & {string}")
    public void activateLocation(String region, String lang) {
        page.activateLocation(region, lang);
    }

    @Then("Location is {string}")
    public void LocationIsCorrect(String location) {
        assertThat(page.isLocationCorrect(location))
                .as("Location is not " + location)
                .isTrue();
    }
}
