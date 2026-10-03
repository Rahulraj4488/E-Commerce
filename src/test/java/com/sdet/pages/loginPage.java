package com.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By loginLink =
            By.id("login2");

    private By username =
            By.id("loginusername");

    private By password =
            By.id("loginpassword");

    private By loginButton =
            By.id("//button[text()='Log in']");

    public void LoginPage(WebDriver driver)
    {
        this.driver = driver;
}

public void openApplication()
{
    driver.get("https://www.demoblaze.com/");
}

public void clickLogin()
{
    driver.findElement(By.id("login2")).click();
    driver.findElement(loginLink).click();
}

public void enterUsername(String usernameValue)
{
    driver.findElement(By.id("loginusername")).sendKeys();
    driver.findElement(username).sendKeys();

}


public void enterPassword(String passwordValue)
{

    driver.findElement(By.id("loginpassword")).sendKeys();
    driver.findElement(password).sendKeys();
}

public void clickLoginButton()
{
    driver.findElement(By.id("//button[text()='Log in']")).click();
    driver.findElement(loginButton).click();
}
}
