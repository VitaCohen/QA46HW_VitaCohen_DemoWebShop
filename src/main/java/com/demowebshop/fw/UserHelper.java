package com.demowebshop.fw;

import com.demowebshop.fw.BaseHelper;
import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
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

    public boolean isRegisterLinkPresents() {
        return isElementPresents(By.cssSelector("[href='/register']"));
    }

    public void clikOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }
}
