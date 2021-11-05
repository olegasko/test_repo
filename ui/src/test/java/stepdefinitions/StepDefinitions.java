package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.HowWeDoItPage;
import pages.InvestorsPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    MainPage page = new MainPage();
    InvestorsPage investorsPage = new InvestorsPage();
    HowWeDoItPage howWeDoItPage = new HowWeDoItPage();

    @Given("user is on the EPAM main page")
    public void userIsOnTheEpamMainPage() {
        open("epam.com");
    }


    @When("user clicks on location menu button")
    public void userClicksOnLocationMenuButton() {
        page.openLocationMenu();
    }

    @Then("location menu is open")
    public void locationMenuIsOpen() {
        assertThat(page.isLocationMenuVisible())
                .as("Menu is not visible")
                .isTrue();
    }

    @Then("activate Location {string} & {string}")
    public void activateLocation(String region, String lang) {
        page.activateLocation(region, lang);
    }

    @Then("Location is {string}")
    public void locationIsCorrect(String location) {
        assertThat(page.isLocationCorrect(location))
                .as("Location is not " + location)
                .isTrue();
    }

    @When("user clicks on the link 'Investors' on footer")
    public void userClicksOnTheLinkInvestorsOnFooter() {
        page.openInvestorsPage();
    }

    @Then("user can see {string} page")
    public void userCanSeeTheRequestedPage(String Url) {
        assertThat(CommonPage.isUrlCorrect(Url))
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
    public void theListOfLinksHasCorrectOrder(DataTable listOfLinks) {
        assertThat(investorsPage.isListOfLinksHasCorrectOrder(listOfLinks.transpose().asList()))
                .as("The list of links has wrong order")
                .isTrue();
    }

    @When("user click on link {string} in header")
    public void userClickOnLinkInHeader(String linkName){
      page.clickOnLink(linkName);
    }

   @Then("user on the page {string}")
    public  void userOnThePage(String pageName){
       assertThat(page.getPageName())
               .as("The page is not correct")
               .isEqualTo(pageName);
    }

    @Then("user can see blocks {string}")
    public void userCanSeeBlocks(String sectionName) {
        assertThat(howWeDoItPage.listOfSections())
                .as("The blocks don't exist")
                .contains(sectionName);
    }

    @Then("blocks has correct order")
    public void blocksHasCorrectOrder(DataTable ListOfBlocks) {
        assertThat(howWeDoItPage.listOfBlocks())
                .as("The list of blocks has wrong order")
                .containsSequence(ListOfBlocks.transpose().asList());
    }
}
