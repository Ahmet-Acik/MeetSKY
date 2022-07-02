package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy (xpath = "//input[@id='submit-form']")
    public WebElement loginClick;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement togglePassword;

    @FindBy(xpath = "//a[@id='lost-password']")
    public WebElement forgotPasswordLink;

}
