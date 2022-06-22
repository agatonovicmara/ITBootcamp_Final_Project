package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BasicTest{


    @Test (priority = 10)

    public void visitsAdminCitiesPageAndListCities (){
        navPage.getLoginLink().click();

        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("12345");
        login.getLoginButton().click();

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/admin/cities"),
                "ERROR - the route should contain '/admin/cities'");


    }

    @Test (priority = 20)

    public void  checksInputTypesForCreateEditNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        cities.getNewItemButton().click();
        cities.waitForDialogNewItemEditToBeVisible();
        Assert.assertEquals(
                cities.getNewItemDialogueInputName().getAttribute("type"),
                "text",
                "ERROR - expected type is text.");
    }

    @Test (priority = 30)

    public void createNewCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        cities.getNewItemButton().click();
        cities.waitForDialogNewItemEditToBeVisible();
        cities.getNewItemDialogueInputName().sendKeys("Smederevska Palanka");
        cities.getSaveButtonFromEditDialogue().click();

        messagePopUp.waitForThePopUpDialogue();
        Thread.sleep(4000);

               Assert.assertTrue(
                messagePopUp.getSuccessDialogue().getText().contains("Saved successfully"),
                "ERROR - text should contain 'Saved successfully'");

            }

    @Test (priority = 40)
    public void editCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        cities.getSearchInput().sendKeys("Smederevska Palanka");
        cities.waitForNumOfRowsToBe(1);
        cities.getEditButton(0).click();

        messagePopUp.waitForTheEditCityDialogue();
        String s = Keys.chord(Keys.CONTROL, "a");
        messagePopUp.getTextInputEditCityDialogue().sendKeys(s);
        messagePopUp.getTextInputEditCityDialogue().sendKeys("GRAD");
        messagePopUp.getSaveCityButtonEditDialogue().click();
        Thread.sleep(4000);
        messagePopUp.waitForThePopUpDialogue();

        Assert.assertTrue(
                messagePopUp.getSuccessDialogue().getText().contains("Saved successfully"),
                "ERROR - text should contain 'Saved successfully'");


    }

   @Test (priority = 50)

    public void searchCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        cities.getSearchInput().sendKeys("GRAD");
        cities.waitForNumOfRowsToBe(1);

        Assert.assertEquals(
                cities.getcellInRow(1, 3).getText(),
                "GRAD",
                "ERROR - text should contain 'GRAD'");

    }

    @Test (priority = 60)

    public void deleteCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        cities.getSearchInput().sendKeys("GRAD");
        cities.waitForNumOfRowsToBe(1);

        Assert.assertEquals(cities.getcellInRow(1, 3).getText(),
                "GRAD",
                "ERROR - text should contain 'GRAD'."
        );

        cities.getDeleteButton(0).click();
        cities.waitForDialogDeleteToBeVisible();
        cities.getDeleteButtonFromDeleteDialogue().click();
        messagePopUp.waitForThePopUpDialogue();
        Thread.sleep(4000);

        Assert.assertTrue(
                messagePopUp.getSuccessDialogue().getText().contains("Deleted successfully"),
        "ERROR - message should be 'Deleted successfully'");
    }



}
