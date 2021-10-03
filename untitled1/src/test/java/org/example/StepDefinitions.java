package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private String today;
    private String actualAnswer;

    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;
    }
    @When("I ask whether it's Friday yet")
    public void I_ask_whether_it_s_Friday_yet() {
        this.actualAnswer = WeekAnalyzer.isItFridayToday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        assertEquals("Nope", actualAnswer);
    }



}
