package com.shakti.GridFrame.Browsers;

import com.shakti.GridFrame.GridLogger.Log;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by stokas on 09-01-2016.
 */
public class GoogleChrome {
    private static final String chromePath = "E:\\GitHub\\UdemyGrid\\src\\main\\resources\\Ext_WebDrivers\\chromedriver.exe";

    public static ChromeDriver InitializeChrome(){

        Log.info("Initializing the Chrome Driver");
        System.setProperty("webdriver.chrome.driver", chromePath);
        return new ChromeDriver();
    }
}

