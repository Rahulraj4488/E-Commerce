package com.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebFormPage {

    private WebDriver driver;

    private By textBox = By.name("my-text");

    private By submitButton = By.cssSelector("button");

    private By message = By.id("message");


    public WebFormPage(WebDriver driver) {

        this.driver = driver;
    }


    public void openPage() {

        driver.get(
                "https://www.selenium.dev/selenium/web/web-form.html"
        );
    }


    public void enterText(String text) {

        driver.findElement(textBox).sendKeys(text);
    }


    public void clickSubmit() {

        driver.findElement(submitButton).click();
    }


    public String getMessage() {

        return driver.findElement(message).getText();
    }
}