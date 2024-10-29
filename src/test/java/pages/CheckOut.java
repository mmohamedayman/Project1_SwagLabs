package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut {
    private WebDriver driver;

    // Constructor to initialize driver
    public CheckOut(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement GetContinueShoppingLoc() {
        return driver.findElement(By.id("continue-shopping"));
    }
    public WebElement GetCheckOutLoc() {
        return driver.findElement(By.id("checkout"));
    }
    public WebElement GetFirstNameLoc() {
        return driver.findElement(By.id("first-name"));
    }
    public WebElement GetLastNameLoc() {
        return driver.findElement(By.id("last-name"));
    }
    public WebElement GetPostalCodeLoc() {
        return driver.findElement(By.id("postal-code"));
    }
    public WebElement GetErrorMsgLoc() {
        return driver.findElement(By.cssSelector(" h3[data-test=\"error\"]"));
    }

    public WebElement GetContinueBuyingLoc() {
        return driver.findElement(By.id("continue"));
    }
    public WebElement GetCancelLoc() {
        return driver.findElement(By.id("cancel"));
    }
    public WebElement GetFinishCheckoutlLoc() {
        return driver.findElement(By.id("finish"));
    }
    public WebElement GetCancelCheckoutLoc() {
        return driver.findElement(By.id("cancel"));
    }
    public WebElement GetItemTotalLoc() {
        return driver.findElement(By.className("summary_subtotal_label"));
    }
    public WebElement GetTaxlLoc() {
        return driver.findElement(By.className("summary_tax_label"));
    }
    public WebElement GetTotalPriceLoc() {
        return driver.findElement(By.className("summary_total_label"));
    }
    public WebElement GetThankyouForTheOrderLoc() {
        return driver.findElement(By.className("complete-header"));
    }
    public WebElement GetBackLoc() {
        return driver.findElement(By.id("back-to-products"));
    }

}
