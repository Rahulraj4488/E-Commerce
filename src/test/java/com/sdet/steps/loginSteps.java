package com.sdet.steps;

import com.sdet.api.UserApi;
import com.sdet.pages.loginPage;
import com.sdet.utils.DriverFactory;
import com.sdet.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    private loginPage loginPage;


    @Given("I create a test customer using API")
    public void createTestCustomerUsingAPI() {

        UserApi userApi = new UserApi();
        userApi.createUser();
    }


    @When("I login to the application using the test customer")
    public void loginUsingTestCustomer() {

        DriverFactory.initializeDriver();

        loginPage =
                new loginPage(DriverFactory.getDriver());

        // TODO:
        // 1. Open application
        loginPage.openApplication();
        // 2. Click Login
        loginPage.clickLogin();
        // 3. Enter TestContext.username
        loginPage.enterUsername(TestContext.userName);
        // 4. Enter TestContext.password
        loginPage.enterPassword(TestContext.password);
        // 5. Click Login
        loginPage.clickLoginButton();
    }


    @Then("I should see the customer logged in")
    public void verifyCustomerLoggedIn() {

        // TODO
        // verify username appears on page
        loginPage.verifyUsernamediaplayed(TestContext.userName);

        DriverFactory.quitDriver();
    }
}