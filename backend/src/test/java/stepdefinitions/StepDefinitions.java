package stepdefinitions;

import dataentities.Pet;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static api.PetApiCalls.petGet;
import static api.PetApiCalls.petPost;
import static api.PetApiCalls.petPut;

public class StepDefinitions {

    private String NAME;

    @Given("pet {string} with photo Urls is created")
    public void petIsCreated(String name, DataTable photoUrls) {
        NAME = name;
        petPost("/pet", null, new Pet(name, photoUrls.asList()));
    }

    @When("I update the pet")
    public void iUpdateAPet() {
        petPut("/pet", null, NAME);
    }

    @Then("I get updated pet")
    public void iGetUpdatedPet() {
        petGet("/pet", null, NAME);
    }

}
