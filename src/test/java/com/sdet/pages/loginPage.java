package com.sdet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
            By.xpath("//button[text()='Log in']");

    public loginPage(WebDriver driver)
    {
        this.driver = driver;
}

public void openApplication()
{

    driver.get("https://www.demoblaze.com");
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--start-maximized");
//    WebDriver driver = new ChromeDriver();
//    driver.manage().window().maximize();
}

public void clickLogin()
{
//    driver.findElement(By.id("login2")).click();
    driver.findElement(loginLink).click();
}

public void enterUsername(String usernameValue) throws InterruptedException {
//    driver.findElement(By.id("loginusername")).sendKeys();
    Thread.sleep(5000);
    driver.findElement(username).sendKeys(usernameValue);
    Thread.sleep(5000);

}


public void enterPassword(String passwordValue) throws InterruptedException {

//    driver.findElement(By.id("loginpassword")).sendKeys();
    Thread.sleep(5000);
    driver.findElement(password).sendKeys(passwordValue);
    Thread.sleep(5000);
}

public void clickLoginButton() throws InterruptedException {
//    driver.findElement(By.id("//button[text()='Log in']")).click();
    Thread.sleep(5000);
    driver.findElement(loginButton).click();
    Thread.sleep(5000);
}

    public void verifyUsernameDisplayed(String userName)
    {
        // Handle any alert that might appear
        handleAlert();

        // Wait for the username to appear on the page after successful login
        // On demoBlaze, the username typically appears in the top-right corner
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

        // Use text containing the username to verify login success
        // Correct XPath for demoBlaze - username appears in navbar after login
        By usernameDisplayedLocator = By.xpath("//button[contains(text(), '" + userName + "')]");

        try {
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(usernameDisplayedLocator));
            System.out.println("Username '" + userName + "' is successfully displayed on the page");
        } catch (org.openqa.selenium.TimeoutException e) {
            throw new AssertionError("Username '" + userName + "' was not displayed within the timeout period", e);
        }
    }

    public void handleAlert() {
        try {
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            // No alert present, continue
        }
    }
}
