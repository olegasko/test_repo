package stepdefinitions;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import static com.jayway.restassured.RestAssured.given;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
@CucumberContextConfiguration
@ContextConfiguration(classes = Config.class)
public class StepDefinitions {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;


    @BeforeClass
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("petstore.swagger.io/v2").
                build();
    }

    @BeforeClass
    public static void createResponseSpecification() {

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Given("pet is created")
    public void petIsCreated() {
    }

    @When("I update a pet")
    public void iUpdateAPet() {
    }

    @Then("I get updated pet")
    public void iGetUpdatedPet() {
        given().
                spec(requestSpec).
                when().
                get("/pet/1").
                then().
                assertThat().
                statusCode(200);
    }

    @And("The status code is {string}")
    public void checkPlaceNameInResponseBody_expectBeverlyHills_withRequestSpec() {

    }

    @Given("get request")
    public void getRequest() {
    }

    @Then("status code is {string}")
    public void statusCodeIs(int arg0) {
        given().
                spec(requestSpec).
                when().
                get("/pet/1").
                then().
                assertThat().
                statusCode(200);
    }
}
