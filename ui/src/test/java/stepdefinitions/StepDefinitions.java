package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    MainPage page = new MainPage();

    @Given("user is on the EPAM main page")
    public void userIsOnTheEpamMainPage() {
        open("epam.com");
    }

    @When("user clicks on menu button")
    public void userClicksOnMenuButton() {
        page.openLocationMenu();
    }

    @Then("menu is open")
    public void MenuIsOpen() {
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


    @Given("user is on the {string}")
    public void userIsOnThePage(String page) {
    }

    @When("user clicks on the link {string} on footer")
    public void userClicksOnTheLinkOnFooter(String linkOnFooter) {
    }

    @Then("user can see {string} page")
    public void userCanSeeThePage() {
    }

    @Then("user can see the <List Of Links> on this page")
    public void userCanSeeTheListOfLinks() {
    }

    @Then("the <List Of Links> has correct order")
    public void theListOfLinksHasCorrectOrder() {
    }
}
