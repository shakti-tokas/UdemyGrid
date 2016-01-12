package com.shakti.GridFrame.Browsers;

import com.shakti.GridFrame.GridLogger.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by stokas on 09-01-2016.
 */
public class GoogleChrome {
    private static final String chromePath = "E:\\GitHub\\UdemyGrid\\src\\main\\resources\\Ext_WebDrivers\\chromedriver.exe";

    private static final String chromeNode = "";

    public static ChromeDriver InitializeChrome(){

        Log.info("Initializing the Chrome Driver");
        System.setProperty("webdriver.chrome.driver", chromePath);
        return new ChromeDriver();
    }

    public static RemoteWebDriver InitializeGridChrome() throws MalformedURLException {

        DesiredCapabilities chromeCap = DesiredCapabilities.chrome();
        chromeCap.setBrowserName("chrome");

        return new RemoteWebDriver(new URL(chromeNode), chromeCap);
    }
}

