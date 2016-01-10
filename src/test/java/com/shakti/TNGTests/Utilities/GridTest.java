package com.shakti.TNGTests.Utilities;

import com.shakti.GridFrame.Browsers.BrowserType;
import com.shakti.GridFrame.GridDriver.Driver;
import com.shakti.GridFrame.GridLogger.Log;
import com.shakti.GridFrame.Pages.LoginPage;
import com.shakti.GridFrame.Pages.Page;
import com.shakti.GridFrame.Pages.PageType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * Created by stokas on 09-01-2016.
 */
public class GridTest {

    @BeforeSuite
    public static void initSuite(){
        Log.Initialize();
    }

    @Parameters({"siteURL","browser","credentials"})
    @BeforeClass
    public static void initTestClass(String siteURL, String browser, String credentials){

        Log.info("Initializing the "+ browser +" Browser");
        InitializeDriver(browser);

        Driver.setBaseAddress(siteURL);

        Log.info("Navigating to Login Page");
        Page.GetPage(PageType.LoginPage); //Fetching Login Page

        LoginPage.GoTo();

        Log.info("Start Entering UserName and Password");
        //LoginPage.LoginAs("shaz1985").WithPassword("13jxesD7&RayJpiHN1").Login();
        LoginPage.LoginAs(credentials.split("\\#")[0]).WithPassword(credentials.split("\\#")[1]).Login();
    }

    @Parameters("browser")
    @AfterClass
    public static void cleanupTestClass(String browser){
        Log.info("Closing the "+ browser +" Browser. Bye!!");
        Driver.Close();
    }

    public static void InitializeDriver(String browser){

        try {
            switch (browser) {

                case "Firefox":
                    Driver.Initialize(BrowserType.Firefox);
                    break;

                case "Chrome":
                    Driver.Initialize(BrowserType.Chrome);
                    break;

                case "Edge":
                    Driver.Initialize(BrowserType.Edge);
                    break;

                default:
                    Log.fatal("No such Browser is supported by this application.");
                    throw new IllegalArgumentException();
            }
        }catch (Exception e){
            Log.fatal(e.getMessage());
        }
    }

}
