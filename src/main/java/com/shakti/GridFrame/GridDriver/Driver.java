package com.shakti.GridFrame.GridDriver;

import com.shakti.GridFrame.Browsers.BrowserType;
import com.shakti.GridFrame.Browsers.GoogleChrome;
import com.shakti.GridFrame.Browsers.MicrosoftEdge;
import com.shakti.GridFrame.Browsers.MozillaFirefox;
import com.shakti.GridFrame.GridLogger.Log;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by stokas on 09-01-2016.
 */
public class Driver {

    public static WebDriver Instance;
    public static String BaseAddress;

    public static String getBaseAddress() {
        return BaseAddress;
    }

    public static void setBaseAddress(String baseAddress) {
        BaseAddress = baseAddress;
    }

    public static WebDriver getInstance() {
        return Instance;
    }

    public static void setInstance(WebDriver instance) {
        Instance = instance;
    }

    public static void InitializeLocalDriver(BrowserType browserType) {

        switch (browserType){

            case Firefox:
                Instance = MozillaFirefox.InitializeFirefox();
                turnOnWait();
                BrowserMaximize();
                break;

            case Chrome:
                Instance = GoogleChrome.InitializeChrome();
                turnOnWait();
                BrowserMaximize();
                break;

            case Edge:
                Instance = MicrosoftEdge.InitializeEdge();
                turnOnWait();
                //BrowserMaximize();
                //In current build browser maximize is not supported by Microsoft Egde.
                break;
        }
    }

    public static void InitializeGridDriver(BrowserType browserType) throws MalformedURLException {

        switch (browserType){

            case Firefox:
                Instance = MozillaFirefox.InitializeGridFirefox();
                turnOnWait();
                BrowserMaximize();
                break;

            case Chrome:
                Instance = GoogleChrome.InitializeGridChrome();
                turnOnWait();
                BrowserMaximize();
                break;
        }
    }

    public static void Close() {
        // TODO Auto-generated method stub
        Instance.close();
        Log.info("Driver closed.");
    }

    public static void turnOnWait() {
        // TODO Auto-generated method stub
        Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Driver Time-Out turned ON");
    }

    public static void turnOffWait() {
        // TODO Auto-generated method stub
        Instance.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        Log.info("Driver Time-Out turned OFF");
    }

    public static void BrowserMaximize() {
        // TODO Auto-generated method stub
        Instance.manage().window().maximize();
    }
}
