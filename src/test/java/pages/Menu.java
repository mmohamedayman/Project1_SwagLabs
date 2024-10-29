package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Menu {
    private WebDriver driver;

    // Constructor to initialize driver
    public Menu(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement GetUserNameLoc() {
        return driver.findElement(By.id("user-name"));
    }
    public WebElement GetPassWordLoc() {
        return driver.findElement(By.id("password"));
    }
    public WebElement GetLoginButtonLoc() {
        return driver.findElement(By.id("login-button"));
    }
    public WebElement GetFailToLoginLoc() {
        return driver.findElement(By.className("error-message-container"));
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
    public void AllItems() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[@class='bm-item menu-item'])[1]")));
    }
    public void About() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[@class='bm-item menu-item'])[2]")));
    }
    public void ResetAppStats() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[@class='bm-item menu-item'])[4]")));
    }
    public void WaitForTheMenu() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bm-item")));
    }


}
