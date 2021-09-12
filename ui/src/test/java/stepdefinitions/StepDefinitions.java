package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InvestorsPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    MainPage page = new MainPage();
    InvestorsPage investorsPage = new InvestorsPage();

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

    @When("user clicks on the link 'Investors' on footer")
    public void userClicksOnTheLinkInvestorsOnFooter() {
        page.openInvestorsPage();
    }

    @Then("user can see {string} page")
    public void userCanSeeThePage(String Url) {
        assertThat(investorsPage.isUrlCorrect(Url))
                .as("Url is not correct")
                .isTrue();
    }

    @Then("user can see list of links on this page")
    public void userCanSeeTheListOfLinks() {
        assertThat(investorsPage.isListOfLinksVisible())
                .as("The list of links is missing")
                .isTrue();
    }

    @Then("list has correct order")
    public void theListOfLinksHasCorrectOrder() {
    }
}
