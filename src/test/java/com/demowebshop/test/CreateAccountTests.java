package com.demowebshop.test;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isRegisterLinkPresents()) {
            app.getUser().clikOnLogOutButton();
        }
    }

        @Test
        public void newUserRegistrationPositiveTest() {

            //click on Register link
            app.getUser().clickOnRegisterLink();
            // gender(male or female)
            // enter name
            app.getUser().fillRegisterLoginForm(new User().setName("Viky").setLastName("Vays")
                    .setEmail("vik1498@gmail.com").setPassword("13456Aa!"));
            // click on Registration button
            app.getUser().clickOnRegistrationButton();
            // verify SignOut button is displayed
            Assert.assertTrue(app.getUser().isSignOutButtonPresent());
        }


    }
