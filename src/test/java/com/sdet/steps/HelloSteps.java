package com.sdet.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HelloSteps {

    @Given("I open my application")
    public void iOpenMyApplication() {

        System.out.println("Application opened");

    }

    @When("I perform an action")
    public void iPerformAnAction() {

        System.out.println("Action performed");

    }

    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {

        System.out.println("Success message displayed");

    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.out.println("Navigating to login page");
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        System.out.println("Entering valid credentials");
        System.out.println("Username: testuser");
        System.out.println("Password: password123");
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        System.out.println("Clicking login button");
    }

    @Then("I should see the home page")
    public void iShouldSeeTheHomePage() {
        System.out.println("Home page displayed successfully");
    }



}