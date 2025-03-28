package com.demowebshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {

        //click on Register link
        clickOnRegisterLink();
        // gender(male or female)
        // enter name
        fillRegisterLoginForm(new User().setName("Viky").setLastName("Vays")
                .setEmail("vik11312@gmail.com").setPassword("123456Aa!"));
        // click on Registration button
        clickOnRegistrationButton();
        // verify SignOut button is displayed
        Assert.assertTrue(isSignOutButtonPresent());


    }


}
