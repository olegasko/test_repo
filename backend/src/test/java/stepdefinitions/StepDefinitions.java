package stepdefinitions;

import com.jayway.restassured.http.ContentType;
import dataentities.Pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.jayway.restassured.RestAssured.given;

public class StepDefinitions {

    @Given("pet is created")
    public void petIsCreated() {

        Pet pet = new Pet();

        pet.setName("Шарик");
        pet.addPhotoUrl("https://google.com/search?q=%D0%A8%D0%B0%D1%80%D0%B8%D0%BA&tbm=isch");


        given().
                contentType(ContentType.JSON).
                body(pet).
                log().body().
        when().
                post("https://petstore.swagger.io/v2/pet").
        then().
                assertThat().
                statusCode(200).
                log().all();
    }

    @When("I update a pet")
    public void iUpdateAPet() {
    }

    @Then("I get updated pet")
    public void iGetUpdatedPet() {
    }

}
