package com.meetsky.pages;

import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {


    public LogoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    LogInPage logInPage = new LogInPage();


    @FindBy(xpath = "//header/div[2]/div[4]/div[1]/div[1]/img[1]")
    public WebElement selectMenu;

    @FindBy(xpath = "//header/div[2]/div[4]/nav[1]/ul[1]/li[4]")
   public WebElement logoutButton;


    public void login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login_url"));
        logInPage.usernameInput.sendKeys(ConfigurationReader.getProperty("user_name"));
        logInPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        logInPage.loginClick.click();
    }

}



