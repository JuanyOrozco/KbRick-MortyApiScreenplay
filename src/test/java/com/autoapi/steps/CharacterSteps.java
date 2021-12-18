package com.autoapi.steps;

import com.autoapi.apiresources.ApiUtils;
import com.autoapi.questions.*;
import com.autoapi.tasks.getCharacter;
import com.autoapi.tasks.getCharacterByName;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CharacterSteps {

    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor Juana;

    ApiUtils helper = new ApiUtils();
    private String charName;

    @Before
    public void configureBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://rickandmortyapi.com/api");
        Juana = Actor.named("Juana Orozco").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Given("Juana is a fan of Rick & Morty")
    public void juanaIsAFanOfRickMorty() {
    }

    @When("she requests to get all the characters")
    public void sheRequestsToGetAllTheCharacters() {
        Juana.attemptsTo(new getCharacter());
    }

    @Then("she should see that the response is successful")
    public void sheShouldSeeThatTheResponseIsSuccessful() {
        Juana.should(seeThat("The ", ResponseCode.was(), equalTo(200))
        );
    }

    @Then("she should see that the number of characters is {int}")
    public void sheShouldSeeThatTheNumberOfCharactersIs(int charNumber) {
        Juana.should(seeThat("The character number ", new GetAllCharacterResponse(), equalTo(charNumber))
        );



    }

    @When("she requests to get the character named {string}{string}")
    public void sheRequestsToGetTheCharacterNamed(String name, String lastName) {
        int characterId = helper.getCharId(name);
        charName = name.concat(" "+lastName);
        Juana.attemptsTo(new getCharacterByName(characterId));
    }

    @Then("she should see the full name of the character requested")
    public void sheShouldSeeTheFullNameOfTheCharacterRequested() {
        Juana.should(seeThat("The character number ", new GetCharacterName(), equalTo(charName))
        );
    }

    @Then("she should see that the content type header is a Json format")
    public void sheShouldSeeThatTheContentTypeHeaderIsAJsonFormat() {
        Juana.should(seeThat("The character number ", new GetResponseHeader(), equalTo("application/json; charset=utf-8"))
        );
    }


    @Then("she should see the location of the character requested is {string}")
    public void sheShouldSeeTheLocationOfTheCharacterRequestedIs(String location) {
        Juana.should(seeThat("The character number ", new GetCharacterLocationName(), equalTo(location))
        );
    }

}
