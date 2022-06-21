package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'flex text-xs-center mt-5 mb-3')]/button"));
    }

}
