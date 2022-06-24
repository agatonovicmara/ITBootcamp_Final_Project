package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMyProfileLink() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[contains(@class, 'btnProfile')]"));
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.xpath("//div[contains(@class, 'layout wrap')]//input[@name='email']"));
    }

    public WebElement getNameInput() {
        return driver.findElement(By.xpath("//div[contains(@class, 'flex xs12 md6')]//input[@name='name']"));
    }

    public WebElement getCityInput() {
        return driver.findElement(By.xpath("//div[contains(@class, 'flex xs12 md4')]//input[@name='city']"));
    }

    public WebElement getPhoneInput() {
        return driver.findElement(By.xpath("//div[contains(@class, 'flex xs12 md4')]//input[@name='phone']"));
    }

    public WebElement getCountryInput() {
        return driver.findElement(By.xpath("//div[contains(@class, 'flex xs12 md4')]//input[@name='country']"));
    }

    public WebElement getURLTwitterInput() {
        return driver.findElement(By.xpath("//div[contains(@class, 'flex xs12 md6')]//input[@name='urlTwitter']"));
    }

    public WebElement getURLGitHubInput() {
        return driver.findElement(By.xpath("//div[contains(@class, 'flex xs12 md6')]//input[@name='urlGitHub']"));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'secondary btnSave')]"));

    }

    public void waitUntilProfileAppearsInUrl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/profile"));
    }

    public void waitForTheTextToBeSavedSuccessfuly() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//div[contains(@class, 'v-snack__wrapper v-sheet theme--dark success')]/div"),
                "saved successfuly"));


    }
    public void waitForTheEmailToBeAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(
                By.xpath("//div[contains(@class, 'flex xs12 md6')]//input[@name='email']"),
                "value",
                "admin@admin.com"));


    }
    public void waitForTheEmailTypeToBeEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(
                By.xpath("//div[contains(@class, 'flex xs12 md6')]//input[@name='email']"),
                "type",
                "email"));}
    public void waitForTheTwitterFieldToBeEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'flex xs12 md6')]//input[@name='urlTwitter']"),
                ""));
    }
    public void waitForTheNameFieldToBeEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'flex xs12 md6')]//input[@name='name']"),
                ""));
    }
    public void waitForTheCityFieldToBeEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'flex xs12 md4')]//input[@name='city']"),
                ""));
    }
    public void waitForTheCountryFieldToBeEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'flex xs12 md4')]//input[@name='country']"),
                ""));
    }
    public void waitForTheGitHubFieldToBeEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'flex xs12 md6')]//input[@name='urlGitHub']"),
                ""));
    }
    public void waitForThePhoneFieldToBeEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'flex xs12 md4')]//input[@name='phone']"),
                ""));
    }
}
