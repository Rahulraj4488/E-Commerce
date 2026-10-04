package com.sdet.steps;

import com.sdet.api.UserApi;
import com.sdet.pages.loginPage;
import com.sdet.utils.DriverFactory;
import com.sdet.utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class loginSteps {
    private loginPage loginPageObj;
    @Given("I create a test customer using API")
    public void createTestCustomerUsingAPI() {
        UserApi userApi = new UserApi();
        userApi.createUser();
    }
    @When("I login to the application using the test customer")
    public void loginUsingTestCustomer() {
        DriverFactory.initializeDriver();
        loginPageObj = new loginPage(DriverFactory.getDriver());

        // TODO:
        // 1. Open application
        loginPageObj.openApplication();
        // 2. Click Login
        loginPageObj.clickLogin();
        // 3. Enter TestContext.username
        loginPageObj.enterUsername(TestContext.userName);
        // 4. Enter TestContext.password
        loginPageObj.enterPassword(TestContext.password);
        // 5. Click Login
        loginPageObj.clickLoginButton();
    }


    @Then("I should see the customer logged in")
    public void verifyCustomerLoggedIn() {

        // TODO
        // verify username appears on page
        if (loginPageObj == null) {
            throw new IllegalStateException("loginPage object is not initialized. Ensure loginUsingTestCustomer() is called first.");
        }
        loginPageObj.verifyUsernameDisplayed(TestContext.userName);
        DriverFactory.quitDriver();
    }
}