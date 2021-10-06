package com.restAPI.cucumberTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerErrorException;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class MyStepdefs {

    @Autowired
    HttpClient client;

    @Given("Get API request to Default User resource")
    public void requestAPI(){
        assertThat(client.testJs().getStatusCode()).isEqualTo(INTERNAL_SERVER_ERROR);
        }

    @When("User wit id {string} sees greeting {string}")
    public void userWitIdSeesGreetingHello(String arg0, String arg1) {
        assertThat(client.resourceToUser(arg0).contains(arg1)).isTrue();
    }

    @Then("Count visitors were increased")
    public void countVisitorsWereIncreased() throws JSONException {
        String str = Objects.requireNonNull(client.testJs().getBody()).replace("[","").replace("]", "");
        JSONObject json = new JSONObject(str);
        assertThat(client.testJs().getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(json.getString("userId")).isEqualTo("4");
        assertThat(json.getString("count")).isEqualTo("2");
        assertThat(json.getString("firstName")).isEqualTo("Tom");
        assertThat(json.getString("lastName")).isEqualTo("Ryan");
    }

    @Then("Count visit user {string} {string} with id {string} were increased")
    public void countVisitUserWithIdWereIncreased(String arg0, String arg1, String arg2) throws JSONException {
        JSONObject json = new JSONObject(Objects.requireNonNull(client.testJs().getBody()).replace("[","").replace("]", ""));
        assertThat(client.testJs().getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(json.getString("userId")).isEqualTo(arg2);
        assertThat(json.getString("count")).isEqualTo("2");
        assertThat(json.getString("firstName")).isEqualTo(arg0);
        assertThat(json.getString("lastName")).isEqualTo(arg1);
        System.out.println("User "
                + json.getString("userId")
                    + " visited "
                        + json.getString("count")
                            + " time");
    }

    @Then("Error 500")
    public void error500() throws ServerErrorException {
        assertThat(client.statusServerError()).isEqualTo(INTERNAL_SERVER_ERROR);
    }
}
