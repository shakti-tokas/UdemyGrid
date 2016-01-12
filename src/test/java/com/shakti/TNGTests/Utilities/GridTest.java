package com.shakti.TNGTests.Utilities;

import com.shakti.GridFrame.GridDriver.Driver;
import com.shakti.GridFrame.GridLogger.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * Created by stokas on 09-01-2016.
 */
public class GridTest extends GridUtility{

    @BeforeSuite
    public static void initSuite(){
        Log.Initialize();
    }

    @Parameters({"siteURL","browser","credentials","gridFlag"})
    @BeforeClass
    public static void initTestClass(String siteURL, String browser, String credentials, String gridFlag){

        Log.info("Initializing the "+ browser +" Browser");
        //InitializeDriver(browser);
        StartDriver(gridFlag, browser);

        Driver.setBaseAddress(siteURL);

        Log.info("Navigating to Login Page");
        UserLogin(credentials);
        /*
        Page.GetPage(PageType.LoginPage); //Fetching Login Page

        LoginPage.GoTo();

        Log.info("Start Entering UserName and Password");
        //LoginPage.LoginAs("shaz1985").WithPassword("13jxesD7&RayJpiHN1").Login();
        LoginPage.LoginAs(credentials.split("\\#")[0]).WithPassword(credentials.split("\\#")[1]).Login();*/
    }

    @Parameters("browser")
    @AfterClass
    public static void cleanupTestClass(String browser){
        Log.info("Closing the "+ browser +" Browser. Bye!!");
        Driver.Close();
    }

}
