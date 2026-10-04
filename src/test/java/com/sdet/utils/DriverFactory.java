package com.sdet.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver driver;

    public static void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//       WebDriver driver = new ChromeDriver();
        DriverFactory.driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}