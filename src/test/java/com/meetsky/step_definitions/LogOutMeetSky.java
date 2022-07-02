package com.meetsky.step_definitions;

import com.meetsky.pages.LogInPage;
import com.meetsky.pages.LogoutPage;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutMeetSky {

    LogoutPage logoutPage = new LogoutPage();
    LogInPage logInPage = new LogInPage();

    @Given("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        logoutPage.login();
    }

    @Given("User clicks to Expandable content button on top-right corner")
    public void userClicksToExpandableContentButtonOnTopRightCorner() {
        logoutPage.selectMenu.click();
    }

    @When("User Clicks Log out button")
    public void userClicksLogOutButton() {
        logoutPage.logoutButton.click();
    }

     @Then("User should be logged out successfully and can see the login page")
    public void userShouldBeLoggedOutSuccessfullyAndCanSeeTheLoginPage() {
        Assert.assertEquals(ConfigurationReader.getProperty("loginTitle"), Driver.getDriver().getTitle());
    }

    @And("User should not be able to go to home page again by clicking step back button")
    public void userShouldNotBeAbleToGoToHomePageAgainByClickingStepBackButton() {
        Driver.getDriver().navigate().back();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.titleIs(ConfigurationReader.getProperty("loginTitle")));
        String currentTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(currentTitle, ConfigurationReader.getProperty("loginTitle"));


    }


}
