package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {


    @Test(priority = 10)
    public void visitTheLoginPage() {

        navPage.getLanguagesButton().click();
        navPage.getEnButton().click();
        navPage.getLoginLink().click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Error, the URL does not contain /login.");
    }


    @Test(priority = 20)
    public void checkInputTypes() {

        navPage.getLoginLink().click();

        Assert.assertEquals(
                login.getEmailInput().getAttribute("type"),
                "email",
                "Error, expected type is email.");

        Assert.assertEquals(
                login.getPasswordInput().getAttribute("type"),
                "password",
                "Error, expected type is password.");

    }

    @Test(priority = 30)

    public void displayErrorWhenUserDoesNOtExist() {

        navPage.getLoginLink().click();

        login.getEmailInput().sendKeys("non-existing-user@gmal.com");
        login.getPasswordInput().sendKeys("password123");
        login.getLoginButton().click();

        messagePopUp.waitForThePopUpDialogue();

        login.waitForTheTextToBeUserDoesNotExists();


        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Error, the URL should contain /login.");
    }

    @Test(priority = 40)

    public void displayErrorWhenPasswordIsWrong() {
        navPage.getLoginLink().click();

        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("password123");
        login.getLoginButton().click();

        messagePopUp.waitForThePopUpDialogue();

        login.waitForTheTextToBeWrongPassword();

    }

    @Test(priority = 50)

    public void login() {
        navPage.getLoginLink().click();

        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("12345");
        login.getLoginButton().click();

        login.waitUntilHomeAppearsInUrl();
    }


        @Test(priority = 60)

        public void logout() {

            Assert.assertTrue(
                    navPage.getLogoutButton().isDisplayed(),
                    "Error, logout button not visible");
            navPage.getLogoutButton().click();

        }


    }

