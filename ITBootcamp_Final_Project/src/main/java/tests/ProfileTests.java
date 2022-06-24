package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {

    @Test(priority = 10)

    public void visitTheProfilePage() {
        navPage.getLoginLink().click();
        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("12345");
        login.getLoginButton().click();

        profilePage.getMyProfileLink().click();
        profilePage.waitUntilProfileAppearsInUrl();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/profile"),
                "ERROR! URL should contain '/profile'");

        profilePage.waitForTheEmailToBeAdmin();

        navPage.getLogoutButton().click();


    }

    @Test(priority = 20)

    public void checkInputTypes() {
        navPage.getLoginLink().click();

        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("12345");
        login.getLoginButton().click();

        profilePage.getMyProfileLink().click();
        profilePage.waitForTheEmailTypeToBeEmail();

        Assert.assertEquals(
                profilePage.getNameInput().getAttribute("type"),
                "text",
                "ERROR, type should be text");

        Assert.assertEquals(
                profilePage.getCityInput().getAttribute("type"),
                "text",
                "ERROR, type should be 'text'");

        Assert.assertEquals(
                profilePage.getCountryInput().getAttribute("type"),
                "text",
                "ERROR, type should be 'text'");

        Assert.assertEquals(
                profilePage.getURLTwitterInput().getAttribute("type"),
                "url",
                "ERROR, type should be 'url'");

        Assert.assertEquals(
                profilePage.getURLGitHubInput().getAttribute("type"),
                "url",
                "ERROR, type should be 'url'");

        Assert.assertEquals(
                profilePage.getPhoneInput().getAttribute("type"),
                "tel",
                "ERROR, type should be 'tel'");

        navPage.getLogoutButton().click();

    }

    @Test(priority = 30)

    public void editProfile() {
        navPage.getLoginLink().click();

        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("12345");
        login.getLoginButton().click();

        profilePage.getMyProfileLink().click();

        String s = Keys.chord(Keys.CONTROL, "a");


        profilePage.getNameInput().sendKeys(s);

        profilePage.waitForTheNameFieldToBeEmpty();
        profilePage.getNameInput().sendKeys("Marija Mitrovic");

        profilePage.getCityInput().sendKeys(s);

        profilePage.waitForTheCityFieldToBeEmpty();
        profilePage.getCityInput().sendKeys("Malaga");

        profilePage.getCountryInput().sendKeys(s);

        profilePage.waitForTheCountryFieldToBeEmpty();
        profilePage.getCountryInput().sendKeys("Spain");

        profilePage.getPhoneInput().sendKeys(s);

        profilePage.waitForThePhoneFieldToBeEmpty();
        profilePage.getPhoneInput().sendKeys("+38161283223");

        profilePage.getURLTwitterInput().sendKeys(s);

        profilePage.waitForTheTwitterFieldToBeEmpty();
        profilePage.getURLTwitterInput().sendKeys("https://twitter.com/profile");

        profilePage.getURLGitHubInput().sendKeys(s);

        profilePage.waitForTheGitHubFieldToBeEmpty();
        profilePage.getURLGitHubInput().sendKeys("https://github.com/agatonovicmara");

        profilePage.getSaveButton().click();

        messagePopUp.waitForThePopUpDialogue();

        profilePage.waitForTheTextToBeSavedSuccessfuly();

    }


}
