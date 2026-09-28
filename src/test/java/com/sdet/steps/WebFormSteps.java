package com.sdet.steps;

import com.sdet.pages.WebFormPage;
import com.sdet.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebFormSteps {

    private WebFormPage webFormPage;


    @Given("I open the Selenium web form")
    public void iOpenTheSeleniumWebForm() {

        DriverFactory.initializeDriver();

        webFormPage =
                new WebFormPage(DriverFactory.getDriver());

        webFormPage.openPage();
    }


    @When("I enter {string} in the text box")
    public void iEnterTextInTheTextBox(String text) {

        webFormPage.enterText(text);
    }


    @When("I click the Submit button")
    public void iClickTheSubmitButton() {

        webFormPage.clickSubmit();
    }


    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedMessage) {

        String actualMessage =
                webFormPage.getMessage();

        assertEquals(expectedMessage, actualMessage);

        DriverFactory.quitDriver();
    }
}