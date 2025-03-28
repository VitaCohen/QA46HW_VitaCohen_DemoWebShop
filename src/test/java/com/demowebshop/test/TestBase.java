package com.demowebshop.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }


    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    @Test
    public boolean isElementPresents(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    protected void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void fillRegisterLoginForm(User user) {
        type(By.name("FirstName"), user.getName());
        //enter last name
        type(By.name("LastName"), user.getLastName());
        // enter email
        type(By.name("Email"), user.getEmail());
        // enter password
        type(By.name("Password"), user.getPassword());
        // enter confirm password
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresents(By.cssSelector("[href='/logout']"));
    }
}
