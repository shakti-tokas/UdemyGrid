package com.shakti.GridFrame.Pages;

import com.shakti.GridFrame.GridDriver.Driver;
import com.shakti.GridFrame.GridLogger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by stokas on 09-01-2016.
 */
public class HomePage {
    /*
    private static By logo = By.cssSelector("a img.udemy-logo");
    private static By userLogo = By.cssSelector("div div a[class='white-link fxac'] span img");
    private static By userTitleLocation = By.cssSelector("div div.dropdown-menu div.header div.r span[class='title']");

    private static WebElement userTitle = Driver.Instance.findElement(userTitleLocation);
    */
    private static WebDriver homePageDriver;

    @FindBy(css = "a img.udemy-logo")
    private static WebElement logo;

    @FindBy(css = "div div a[class='white-link fxac'] span img")
    private static WebElement userLogo;

    @FindBy(css = "div div.dropdown-menu div.header div.r span[class='title']")
    private static WebElement userTitle;

    private static WebDriverWait waitHomePage = new WebDriverWait(Driver.Instance,15);

    public HomePage(WebDriver driver){
        homePageDriver = driver;

        //Initializing all elements.
        PageFactory.initElements(homePageDriver, this);
    }

    public static boolean IsLogoDisplayed(){
        waitHomePage.until(ExpectedConditions.visibilityOf(logo));
        Log.info("Searching for Logo.");
        return logo.isDisplayed();
    }

    public static boolean IsUserDisplayed(String userName) {

        try {
            waitHomePage.until(ExpectedConditions.visibilityOf(userLogo));
            Log.info("Searching for User Section.");
            userLogo.click();

            Log.info("Searching for User Name "+ userName);

            if (userTitle.isDisplayed()) {

                String uTitle = userTitle.getText();
                Log.info("User Name Displayed is "+ uTitle);

                if (userName.equals(uTitle)) {
                    return true;
                } else {
                    Log.info("Invalid UserName");
                    return false;
                }
            } else {
                Log.info("User Not Found.");
                return false;
            }

        } catch(Exception e){
            Log.error("No User Element Found.");
            Log.error(e.toString());
            return false;
        }
    }
}
