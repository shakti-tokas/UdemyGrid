package com.shakti.GridFrame.Pages;

import com.shakti.GridFrame.GridDriver.Driver;
import com.shakti.GridFrame.GridLogger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by stokas on 09-01-2016.
 */
public class LoginPage {

    /*
    private static By loginLink = By.linkText("Login");
    private static By loginForm = By.id("login-form");
    private static By userId = By.id("id_email");
    private static By passId = By.id("id_password");
    private static By loginButton = By.id("submit-id-submit");
    */

    private static WebDriver loginPageDriver;

    @FindBy(linkText = "Login")
    private static WebElement loginLink;

    @FindBy(id = "id_email")
    private static WebElement userId;

    @FindBy(id = "id_password")
    private static WebElement passId;

    @FindBy(id = "submit-id-submit")
    private static WebElement loginButton;

    public LoginPage(WebDriver driver){
        loginPageDriver = driver;

        //Initializing all elements.
        PageFactory.initElements(loginPageDriver, this);
    }

    public static void GoTo(){

        loginPageDriver.get(Driver.getBaseAddress());
        //Driver.Instance.get(Driver.getBaseAddress());
        Log.info("Navigated to Udemy Login Page");

        WebDriverWait wait = new WebDriverWait(Driver.Instance,5);

        wait.until(ExpectedConditions.visibilityOf(loginLink));
        //loginPageDriver.switchTo().window(loginPageDriver.getWindowHandle());
        loginLink.sendKeys(Keys.CONTROL);
        loginLink.click();

        Log.info("Waiting until login pane start displaying.");
        wait.until(ExpectedConditions.visibilityOf(userId));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(userId));
    }

    public static LoginCommand LoginAs(String userName) {
        // TODO Auto-generated method stub
        return new LoginCommand(userName);
    }

    public static class LoginCommand {
        private String userName;
        private String password;

        public LoginCommand(String userName){
            this.userName = userName;
        }

        public LoginCommand WithPassword(String password){
            this.password = password;
            return this;
        }

        public void Login() {
            // TODO Auto-generated method stub
            // Find and send UserName
            userId.sendKeys(userName);
            Log.info("UserName Entered");

            //Find and send Password
            passId.sendKeys(password);
            Log.info("Password Entered");

            //Find login button and send to press it
            loginButton.click();
            Log.info("Login Clicked");

        }

    }

}
