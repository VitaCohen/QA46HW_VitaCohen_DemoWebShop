package com.demowebshop.fw;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
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
    public String takeScreenshot(){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }


}


