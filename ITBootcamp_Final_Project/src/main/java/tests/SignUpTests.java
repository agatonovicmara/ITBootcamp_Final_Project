package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest{


    //Test 1
    @Test (priority = 10)

    public void visitTheSignupPage(){
        navPage.getSignUpLink().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "Error, the URL does not contain /signup.");
    }


    //Test 2
    @Test (priority = 20)

    public void checkInputTypes(){
        navPage.getSignUpLink().click();
        Assert.assertEquals(
                signUp.getEmailInput().getAttribute("type"),
                "email",
                "Error, expected type is email.");
        Assert.assertEquals(
                signUp.getPasswordInput().getAttribute("type"),
                "password",
                "Error, expected type is password.");
        Assert.assertEquals(
                signUp.getConfirmPasswordlInput().getAttribute("type"),
                "password",
                "Error, type should be password."
        );
    }

    //Test 3
    @Test (priority = 30)

    public void displaysErrorsWhenUserAlreadyExists() throws InterruptedException {
        navPage.getSignUpLink().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "Error, the URL does not contain /signup.");
        signUp.getNameInput().sendKeys("Another User");
        signUp.getEmailInput().sendKeys("admin@admin.com");
        signUp.getPasswordInput().sendKeys("12345");
        signUp.getConfirmPasswordlInput().sendKeys("12345");
        signUp.getSignMeUpButton().click();
        messagePopUp.waitForThePopUpToBeVisible();
        Thread.sleep(3000);
        Assert.assertEquals(messagePopUp.getErrorPopUp().getText(),
                "E-mail already exists",
                "Error - message should be 'E-mail already exists'");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "Error, the URL does not contain /signup.");
    }

    //Test 4
    @Test (priority = 40)

    public void signup(){
        navPage.getSignUpLink().click();
        signUp.getNameInput().sendKeys("Marija Mitrovic");
        signUp.getEmailInput().sendKeys("marija.mitrovic@itbootcamp.rs");
        signUp.getPasswordInput().sendKeys("12345");
        signUp.getConfirmPasswordlInput().sendKeys("12345");
        signUp.getSignMeUpButton().click();
        driver.get(baseUrl + "/home");
        Assert.assertEquals(
                messagePopUp.getVerifyYourAccountText().getText(),
                "IMPORTANT: Verify your account",
                "Error- text should be 'IMPORTANT: Verify your account'");
        messagePopUp.getCloseVerifyDialogueButton().click();
        navPage.getLogoutButton().click();
    }



}
