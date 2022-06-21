package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {


    //Test 1
    @Test(priority = 10)
    public void visitTheLoginPage() {
        navPage.getLanguagesButton().click();
        navPage.getEnButton().click();
        navPage.getLoginLink().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Error, the URL does not contain /login.");
    }



    //Test 2
    @Test (priority = 20)
    public void checkInputTypes(){
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

    //Test 3
    @Test (priority=30)

    public void displayErrorWhenUserDoesNOtExist(){
        navPage.getLoginLink().click();
        login.getEmailInput().sendKeys("non-existing-user@gmal.com");
        login.getPasswordInput().sendKeys("password123");
        login.getLoginButton().click();
        messagePopUp.waitForThePopUpToBeVisible();
        Assert.assertEquals(messagePopUp.getErrorPopUp().getText(),
                "User does not exists",
                "Error - message should be 'User does not exist'");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Error, the URL should contain /login.");
    }

    //Test 4
    @Test (priority = 40)

    public void displayErrorWhenPasswordIsWrong(){
        navPage.getLoginLink().click();
        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("password123");
        login.getLoginButton().click();
        messagePopUp.waitForThePopUpToBeVisible();
        Assert.assertEquals(messagePopUp.getErrorPopUp().getText(),
                "Wrong password",
                "Error - message should be 'Wrong password'");

    }

    @Test (priority = 50)

    public void login() throws InterruptedException {
        navPage.getLoginLink().click();
        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("12345");
        login.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/home"),
                "Error, the URL should contain /home.");
    }

    @Test (priority = 60)

    public void logout() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(
                navPage.getLogoutButton().isDisplayed(),
                "Error, logout button not visible");
        navPage.getLogoutButton().click();

    }


}
