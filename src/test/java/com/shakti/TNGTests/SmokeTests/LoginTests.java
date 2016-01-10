package com.shakti.TNGTests.SmokeTests;

import com.shakti.GridFrame.GridDriver.Driver;
import com.shakti.GridFrame.GridLogger.Log;
import com.shakti.GridFrame.Pages.HomePage;
import com.shakti.GridFrame.Pages.Page;
import com.shakti.GridFrame.Pages.PageType;
import com.shakti.TNGTests.Utilities.GridTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by stokas on 09-01-2016.
 */
public class LoginTests extends GridTest{

    @Parameters("userName")
    @Test
    public void User_Can_Login(String userName) {

        Log.startTestCase("User_Can_Login");

        Page.GetPage(PageType.HomePage); //Fetching Home Page.
        Assert.assertTrue(HomePage.IsLogoDisplayed());
        Log.info("Logo Found.");

        Assert.assertTrue(HomePage.IsUserDisplayed(userName), "Failed to Login.");
        Log.info("Login Successful.");

        Log.endTestCase("User_Can_Login");
    }

}
