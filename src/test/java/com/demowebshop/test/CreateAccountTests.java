package com.demowebshop.test;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //SoftAssert softAssert = new SoftAssert();

    @Test
    public void newUserRegistrationPositiveTest() {

        //click on Register link
        app.getUser().clickOnRegisterLink();
        // gender(male or female)
        // enter name
        app.getUser().fillRegisterLoginForm(new User().setName("Viky").setLastName("Vays")
                .setEmail("vik146@gmail.com").setPassword("13456Aa!"));
        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        // verify SignOut button is displayed
       Assert.assertTrue(app.getUser().isSignOutButtonPresent());
       //softAssert.assertTrue(isErrorMessagePresent());
       //softAssert.assertAll();


    }
//
//    public boolean isErrorMessagePresent() {
//        return isElementPresents(By.cssSelector(".validation-summary-errors"));
//    }


}
