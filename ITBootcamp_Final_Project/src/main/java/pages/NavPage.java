package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[2]"));
    }
    public WebElement getMyProfileLink(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[3]"));
    }
    public WebElement getLoginLink(){
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }
    public WebElement getSignUpLink(){
        return driver.findElement(By.xpath("//a[@href='/signup']"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesButton(){
        return driver.findElement(By.id("list-item-529"));
    }
    public WebElement getUsersButton(){
        return driver.findElement(By.id("list-item-532"));
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'hidden-sm-and-down btnLogout v-btn v-btn--flat v-btn--text theme--light v-size--default')]"));}
    public WebElement getLanguagesButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getEnButton(){
        return driver.findElement(By.className("btnEN"));
    }
    public WebElement getEsButton(){
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getFrButton(){
        return driver.findElement(By.className("btnFR"));
    }
    public WebElement getCnButton(){
        return driver.findElement(By.className("btnCN"));
    }

}
