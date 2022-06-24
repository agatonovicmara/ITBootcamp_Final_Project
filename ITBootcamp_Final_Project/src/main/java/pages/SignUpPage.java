package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameInput() {
        return driver.findElement(By.name("name"));
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getConfirmPasswordlInput() {
        return driver.findElement(By.name("confirmPassword"));
    }

    public WebElement getSignMeUpButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    public void waitForTheTextToBeEmailAlreadyExists(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@role='status']/ul/li"), "E-mail already exists") );
    }

    public void waitForTheTextToBeIMPORTANT(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'dlgVerifyAccount')]"), "IMPORTANT: Verify your account") );
    }
}
