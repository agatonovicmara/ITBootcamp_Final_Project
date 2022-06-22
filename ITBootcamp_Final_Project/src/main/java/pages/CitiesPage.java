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

    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getNewItemDialogueInputName() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    public void waitForDialogNewItemEditToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }

    public void waitForDialogDeleteToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("warning")));
    }

    public WebElement getSaveButtonFromEditDialogue() {
        return driver.findElement(By.className("btnSave"));
    }

    public WebElement getDeleteButtonFromDeleteDialogue() {
        return driver.findElement(By.xpath("//span[contains(text(), ' Delete')]"));
    }

    public void waitForNumOfRowsToBe(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rowNum));
    }

    public WebElement getcellInRow(int rowIndex, int cellIndex) {
        return driver.findElement(By.xpath("//tbody/tr[" + rowIndex + "]/td[" + (cellIndex - 1) + "]"));

    }

    public WebElement getEditButton(int rowNum) {
        return driver.findElements(By.id("edit")).get(rowNum);
    }

    public WebElement getDeleteButton(int rowNum) {
        return driver.findElements(By.id("delete")).get(rowNum);
    }


}
