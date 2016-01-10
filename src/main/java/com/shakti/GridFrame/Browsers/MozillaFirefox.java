package com.shakti.GridFrame.Browsers;

import com.shakti.GridFrame.GridLogger.Log;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Created by stokas on 09-01-2016.
 */
public class MozillaFirefox {

    private static final String profilePath = "C:\\Users\\stokas\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\";
    private static final String foxProfile = "gq9ow771.testNGUser";

    public static FirefoxDriver InitializeFirefox(){

        FirefoxProfile instanceProfile = new FirefoxProfile(new File(profilePath+foxProfile));
        Log.info("Profile Fetched");
        //instanceProfile.setPreference("browser.startup.homepage", "about:home");
        Log.info("Initializing the Firefox Driver");
        return new FirefoxDriver(instanceProfile);
    }
}
