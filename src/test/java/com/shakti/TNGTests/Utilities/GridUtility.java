package com.shakti.TNGTests.Utilities;

import com.shakti.GridFrame.Browsers.BrowserType;
import com.shakti.GridFrame.GridDriver.Driver;
import com.shakti.GridFrame.GridLogger.Log;
import com.shakti.GridFrame.Pages.LoginPage;
import com.shakti.GridFrame.Pages.Page;
import com.shakti.GridFrame.Pages.PageType;

/**
 * Created by stokas on 12-01-2016.
 */
public class GridUtility {

    //To start Local Driver
    public static void StartLocalDriver(String browser){

        try {
            switch (browser) {

                case "Firefox":
                    Driver.InitializeLocalDriver(BrowserType.Firefox);
                    break;

                case "Chrome":
                    Driver.InitializeLocalDriver(BrowserType.Chrome);
                    break;

                case "Edge":
                    Driver.InitializeLocalDriver(BrowserType.Edge);
                    break;

                default:
                    throw new IllegalArgumentException("No such Browser is supported by this application.");
            }
        }catch (Exception e){
            Log.fatal(e.getMessage());
        }
    }

    //To start Driver based on requirement (Local or Grid)
    public static void StartDriver(String gridFlag, String browser){

        switch (gridFlag){

            case "ON":
                StartGridDriver(browser);
                break;

            case "OFF":
                StartLocalDriver(browser);
                break;
        }

    }

    //To start Grid Driver
    public static void StartGridDriver(String browser){

        try {
            switch (browser) {

                case "Firefox":
                    Driver.InitializeGridDriver(BrowserType.Firefox);
                    break;

                case "Chrome":
                    Driver.InitializeGridDriver(BrowserType.Chrome);
                    break;

                default:
                    throw new IllegalArgumentException("No such Browser is supported by Grid in this application.");
            }
        }catch (Exception e){
            Log.fatal(e.getMessage());
        }
    }

    //To navigate driver to Login Page
    public static void UserLogin(String credentials){

        Page.GetPage(PageType.LoginPage); //Fetching Login Page

        LoginPage.GoTo();

        Log.info("Start Entering UserName and Password");
        //LoginPage.LoginAs("shaz1985").WithPassword("13jxesD7&RayJpiHN1").Login();
        LoginPage.LoginAs(credentials.split("\\#")[0]).WithPassword(credentials.split("\\#")[1]).Login();

    }

}
