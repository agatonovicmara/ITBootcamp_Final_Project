package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForTheEditCityDialogue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'v-input v-input--is-label-active v-input--is-dirty theme--light v-text-field v-text-field--is-booted')]/div/div/div/input")));
    }

    public WebElement getTextInputEditCityDialogue() {
        return driver.findElement(By.xpath("//input[@name='name']"));
    }

    public WebElement getSaveCityButtonEditDialogue() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave v-btn v-btn--flat v-btn--text theme--light v-size--default green--text text--lighten3')]"));
    }

//    //public WebElement getErrorPopUp() {
//        return driver.findElement(By.xpath("//div[@role='status']/ul/li"));
//    }

    public void waitForThePopUpDialogue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-snack__content")));
    }
//
//    public WebElement getSuccessDialogue() {
//        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack__wrapper v-sheet theme--dark success')]/div"));
//    }
//
//    public WebElement getVerifyYourAccountText() {
//        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]"));
//    }

    public WebElement getCloseDialogueButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnClose ')]"));
    }
    public void waitForTheCloseButtonToBeClickable(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btnClose')]/span")));
    }
}
