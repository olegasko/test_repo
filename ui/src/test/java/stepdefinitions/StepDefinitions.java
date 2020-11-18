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
    public void givenExample() {
        open("epam.com");
    }

    @When("click on Menu button")
    public void whenExample() {
        page.openLocationMenu();
    }

    @Then("menu is open")
    public void thenExample() {
        assertThat(page.isMenuVisible())
                .as("Menu is not visible")
                .isTrue();
    }
}
