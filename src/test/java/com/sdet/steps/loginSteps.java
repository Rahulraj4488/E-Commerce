package com.sdet.steps;

import com.sdet.api.UserApi;
import com.sdet.pages.LoginPage;
import com.sdet.utils.DriverFactory;
import com.sdet.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    private LoginPage loginPage;


    @Given("I create a test customer using API")
    public void createTestCustomerUsingAPI() {

        UserApi userApi = new UserApi();

        // TODO:
        // call createUser()
    }


    @When("I login to the application using the test customer")
    public void loginUsingTestCustomer() {

        DriverFactory.initializeDriver();

        loginPage =
                new LoginPage(DriverFactory.getDriver());

        // TODO:
        // 1. Open application
        // 2. Click Login
        // 3. Enter TestContext.username
        // 4. Enter TestContext.password
        // 5. Click Login
    }


    @Then("I should see the customer logged in")
    public void verifyCustomerLoggedIn() {

        // TODO
        // verify username appears on page

        DriverFactory.quitDriver();
    }
}