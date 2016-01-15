package com.shakti.GridFrame.Browsers;

import com.shakti.GridFrame.GridLogger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by stokas on 09-01-2016.
 */
public class MozillaFirefox {

    private static final String profilePath = "C:\\Users\\stokas\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\";
    private static final String foxProfile = "gq9ow771.testNGUser";

    private static final String foxNode = "http://192.168.0.104:5555/wd/hub";

    //protected static ThreadLocal<RemoteWebDriver> threadDriver = null;

    public static FirefoxDriver InitializeFirefox(){

        FirefoxProfile instanceProfile = new FirefoxProfile(new File(profilePath+foxProfile));
        Log.info("Profile Fetched");
        //instanceProfile.setPreference("browser.startup.homepage", "about:home");
        Log.info("Initializing the Firefox Driver");
        return new FirefoxDriver(instanceProfile);
    }

    public static RemoteWebDriver InitializeGridFirefox() throws MalformedURLException {

        DesiredCapabilities foxCap = DesiredCapabilities.firefox();
        foxCap.setBrowserName("firefox");
        Log.info("Initializing the Firefox Driver On GRID");

        return new RemoteWebDriver(new URL(foxNode), foxCap);
    }
}
