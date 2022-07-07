package com.meetsky.step_definitions;

import com.meetsky.pages.LogInPage;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMeetSykSO {

    LogInPage logInPage = new LogInPage();


    @Given("User goes to login page")
    public void user_goes_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login_url"));
    }

    @When("user enters {string} username")
    public void user_enters_username(String string) {
        logInPage.usernameInput.sendKeys(string);
    }

    @When("user enters {string} password")
    public void user_enters_password(String string) {
        logInPage.passwordInput.sendKeys(string);
    }

    @When("user clicks to Log in button")
    public void user_clicks_to_log_in_button() {
        logInPage.loginClick.click();
    }

    @Then("user can login")
    public void user_can_login() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigurationReader.getProperty("loginTitle")));
    }

    @When("user can see dots in the password input")
    public void user_can_see_dots_in_the_password_input() {
        Assert.assertEquals("text", logInPage.usernameInput.getAttribute("type"));
    }

    @When("user Clicks to the eye symbol")
    public void user_clicks_to_the_eye_symbol() {
        logInPage.togglePassword.click();
    }

    @Then("user can see the password")
    public void user_can_see_the_password() {
        Assert.assertEquals("text", logInPage.passwordInput.getAttribute("type"));
    }

    @When("user click to Forgot password link")
    public void user_click_to_forgot_password_link() {
        logInPage.forgotPasswordLink.click();
    }

    @Then("user can see Reset Password button")
    public void user_can_see_reset_password_button() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.id("reset-password-submit"))));
        Assert.assertTrue(Driver.getDriver().findElement(By.id("reset-password-submit")).isDisplayed());
    }

    @Then("Username or email placeholder is visible for username box")
    public void placeholder_is_visible_for_username_box(String string) {
        Assert.assertEquals(string, logInPage.usernameInput.getAttribute("placeholder"));
    }

    @Then("{string} placeholder is visible for password box")
    public void placeholder_is_visible_for_password_box(String string) {
        Assert.assertEquals(string, logInPage.passwordInput.getAttribute("placeholder"));
    }

//    @Then("user can not login as blank and see Please fill in this field.")
//    public void userCanNotLoginAsBlankAndSeePleaseFillInThisField() {
//
////        WebElement txt = new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable((WebElement) By.id("user")));
////        Assert.assertEquals(ConfigurationReader.getProperty("emptyMessage"), txt.getAttribute("validationMessage"));
//        String aro = "";
//        String arg1 = "";
//
//        String message = Driver.getDriver().findElement(By.id("user")).getAttribute("validationMessage");
//        Assert.assertEquals(ConfigurationReader.getProperty("emptyMessage"), message);
//
//    }

    @Then("user can not login and see Wrong username or password.")
    public void userCanNotLoginAndSeeWrongUsernameOrPassword() {
        String aErrorMessage = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'Wrong username or password.')]")).getText();
        Assert.assertEquals(ConfigurationReader.getProperty("invalidMessage"), aErrorMessage);
    }

    @Then("User can see {string} and {string} placeholder is visible")
    public void userCanSeeAndPlaceholderIsVisible(String arg0, String arg1) {
        Assert.assertEquals(arg0, logInPage.usernameInput.getAttribute("placeholder"));
        Assert.assertEquals(arg1, logInPage.passwordInput.getAttribute("placeholder"));
    }

    @Then("user can not login as {string} and or {string} blank and see Please fill in this field.")
    public void userCanNotLoginAsAndOrBlankAndSeePleaseFillInThisField(String arg0, String arg1) {
        String message;
        if (arg0.isEmpty()) {
            message = Driver.getDriver().findElement(By.id("user")).getAttribute("validationMessage");
        } else {
            message = Driver.getDriver().findElement(By.id("password")).getAttribute("validationMessage");
        }
        Assert.assertEquals(ConfigurationReader.getProperty("emptyMessage"), message);
    }


//    @Then("user can not login as {string} and or {string} blank and or with invalid credentials see error message.")
//    public void userCanNotLoginAsAndOrBlankAndOrWithInvalidCredentialsAndSeeErrorMessage(String arg0, String arg1) {
//
//        String message;
//        if (arg0.isEmpty()) {
//            message = Driver.getDriver().findElement(By.id("user")).getAttribute("validationMessage");
//            Assert.assertEquals(ConfigurationReader.getProperty("emptyMessage"), message);
//        } else if ((arg0.isEmpty() && (arg1.isEmpty())) || arg1.isEmpty()) {
//            message = Driver.getDriver().findElement(By.id("password")).getAttribute("validationMessage");
//            Assert.assertEquals(ConfigurationReader.getProperty("emptyMessage"), message);
//        } else if (((!arg0.isEmpty() && !arg0.equals(ConfigurationReader.getProperty("user_name")))
//                && (!arg1.isEmpty() && !arg0.equals(ConfigurationReader.getProperty("password"))))
//                || (((!arg0.isEmpty() && arg0.equals(ConfigurationReader.getProperty("user_name")))
//                || (!arg1.isEmpty() && arg0.equals(ConfigurationReader.getProperty("password")))))
//                || (((!arg0.isEmpty() && !arg0.equals(ConfigurationReader.getProperty("user_name")))
//                || (!arg1.isEmpty() && !arg0.equals(ConfigurationReader.getProperty("password")))))
//        ) {
//            String aErrorMessage = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'Wrong username or password.')]")).getText();
//            Assert.assertEquals(ConfigurationReader.getProperty("invalidMessage"), aErrorMessage);
//        }
//
//    }

}
