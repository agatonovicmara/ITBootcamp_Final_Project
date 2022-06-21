package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    public void waitForDialogEditToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }
    public void waitForDialogDeleteToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("warning")));
    }
    public WebElement getSaveButtonFromEditDialogue(){
        return driver.findElement(By.className("btnSave"));
    }
    public WebElement getDeleteButtonFromDeleteDialogue(){
        return driver.findElement(By.xpath("//button[contains(@class, 'v-btn v-btn--flat v-btn--text theme--light v-size--default red--text text--lighten3')]"));
    }
    public void waitForNumOfRowsToBe(int rowNum){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rowNum));
    }
    public WebElement cellInRow(int rowIndex, int cellIndex){
      return driver.findElement(By.xpath("//tbody/tr["+rowIndex+"]/td["+cellIndex+"]"));

    }
    public WebElement getEditButton(int rowNum){
        return driver.findElements(By.id("edit")).get(rowNum);
    }
    public WebElement getDeleteButton(int rowNum){
        return driver.findElements(By.id("delete")).get(rowNum);
    }


}
