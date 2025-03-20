package com.demowebshop.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {

        //click on Register link
        click(By.cssSelector("[href='/register']"));

        // gender(male or female)


        // enter name
        type(By.name("FirstName"), "Viky");

        //enter last name
        type(By.name("LastName"), "Vays");

        // enter email
        type(By.name("Email"), "vik444@gmail.com");


        // enter password
        type(By.name("Password"), "123456Aa!");

        // enter confirm password
        type(By.name("ConfirmPassword"), "123456Aa!");

        // click on Registration button
        click(By.name("register-button"));


        // verify SignOut button is displayed
        Assert.assertTrue(isElementPresents(By.cssSelector("[href='/logout']")));


    }


}
