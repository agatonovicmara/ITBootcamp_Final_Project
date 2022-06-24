package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a"));
    }

    public WebElement getLoginLink() {
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }

    public WebElement getSignUpLink() {
        return driver.findElement(By.xpath("//a[@href='/signup']"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));
    }

    public WebElement getCitiesButton() {
        return driver.findElement(By.xpath("//a[@href='/admin/cities']"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));
    }

//    @FindBy (className = "btnLogout") WebElement LogoutButton;

    public WebElement getLanguagesButton() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnButton() {
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement getEsButton() {
        return driver.findElement(By.className("btnES"));
    }

    public WebElement getFrButton() {
        return driver.findElement(By.className("btnFR"));
    }

    public WebElement getCnButton() {
        return driver.findElement(By.className("btnCN"));
    }

    public WebElement getLocale() {
        return driver.findElement(By.tagName("h1"));
    }

}
