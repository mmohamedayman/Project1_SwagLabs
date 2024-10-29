package pages;

import features.F01_login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_LoginPageLocators {
    private WebDriver driver;

    // Constructor to initialize driver
    public P01_LoginPageLocators(WebDriver driver) {
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

}
