package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class P02_HomePageLocators {
    private WebDriver driver;

    // Constructor to initialize driver
    public P02_HomePageLocators(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement SuccessLoginLoc() {
        return driver.findElement(By.className("title"));
    }
    public void WaitForTheGlitch() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
    }
    public WebElement GetMenuLoc() {
        return driver.findElement(By.id("react-burger-menu-btn"));

    }
    public void LogOut() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[@class='bm-item menu-item'])[3]")));
    }
    public WebElement AddRandomItemLoc() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    }
    public WebElement RemoveRandomItemLoc() {
        return driver.findElement(By.id("remove-sauce-labs-bike-light"));
    }
    public void WaitForRemove() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-bike-light")));
    }


    public void ClickAllItems() {
        List<WebElement> items = driver.findElements(By.className("btn_inventory"));

        for (WebElement item : items) {
            item.click();
        }
    }
    public void DeleteAllItems() {
        List<WebElement> items = driver.findElements(By.className("btn_secondary"));

        for (WebElement item : items) {
            item.click();
        }
    }

    public WebElement GetNumOfItems() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }
    public WebElement GetCartLoc() {
        return driver.findElement(By.className("shopping_cart_link"));
    }
    public WebElement GetAddToCartButton() {
        return driver.findElement(By.className("btn_primary"));
    }

    public void GoToTab(int tab) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));

    }
    public void GetDropDownFilter(int index) {
        Select sel = new Select( driver.findElement(By.className("product_sort_container")));
         sel.selectByIndex(index);

    }



    }




