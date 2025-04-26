package com.demowebshop.test;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import com.demowebshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        app.getUser().fillRegisterLoginForm(new User().setName(UserData.NAME).setLastName(UserData.LASTNAME)
                .setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        // verify SignOut button is displayed
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }


    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderTest(String name, String lastName,
                                                                String email, String password) {

        //click on Register link
        app.getUser().clickOnRegisterLink();
        // gender(male or female)
        // enter name
        app.getUser().fillRegisterLoginForm(new User()
                .setName(name).setLastName(lastName)
                .setEmail(email).setPassword(password));
        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        // verify SignOut button is displayed
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test(dataProvider = "addNewUserWithCsv", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithCsvTest(User user) {

        //click on Register link
        app.getUser().clickOnRegisterLink();
        // gender(male or female)
        // enter name
        app.getUser().fillRegisterLoginForm(user);
        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        // verify SignOut button is displayed
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }


}
