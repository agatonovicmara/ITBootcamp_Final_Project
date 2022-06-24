package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {


    @Test(priority = 10)

    public void visitTheSignupPage() {
        navPage.getSignUpLink().click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "ERROR - the URL should contain /signup.");
    }


    @Test(priority = 20)

    public void checkInputTypes() {

        navPage.getSignUpLink().click();

        Assert.assertEquals(
                signUp.getEmailInput().getAttribute("type"),
                "email",
                "ERROR - expected type is email.");

        Assert.assertEquals(
                signUp.getPasswordInput().getAttribute("type"),
                "password",
                "ERROR - expected type is password.");

        Assert.assertEquals(
                signUp.getConfirmPasswordlInput().getAttribute("type"),
                "password",
                "ERROR - expected type is password."
        );
    }


    @Test(priority = 30)

    public void displaysErrorsWhenUserAlreadyExists()  {
        navPage.getSignUpLink().click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "ERROR - the URL should contain /signup.");

        signUp.getNameInput().sendKeys("Another User");
        signUp.getEmailInput().sendKeys("admin@admin.com");

        signUp.getPasswordInput().sendKeys("12345");
        signUp.getConfirmPasswordlInput().sendKeys("12345");

        signUp.getSignMeUpButton().click();

        messagePopUp.waitForThePopUpDialogue();

        signUp.waitForTheTextToBeEmailAlreadyExists();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "ERROR - the URL should contain /signup.");
    }


    @Test(priority = 40)

    public void signup(){
        navPage.getSignUpLink().click();

        signUp.getNameInput().sendKeys("Marija Mitrovic");
        signUp.getEmailInput().sendKeys("marija.mitrovic@itbootcamp.rs");

        signUp.getPasswordInput().sendKeys("12345");
        signUp.getConfirmPasswordlInput().sendKeys("12345");

        signUp.getSignMeUpButton().click();

        driver.get(baseUrl + "/home");

        navPage.getLoginLink().click();
        login.getEmailInput().sendKeys("marija.mitrovic@itbootcamp.rs");
        login.getPasswordInput().sendKeys("12345");
        login.getLoginButton().click();

       signUp.waitForTheTextToBeIMPORTANT();

        messagePopUp.waitForTheCloseButtonToBeClickable();

        messagePopUp.getCloseDialogueButton().click();
        navPage.getLogoutButton().click();
    }


}
