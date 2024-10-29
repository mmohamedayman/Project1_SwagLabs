package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class About {
    private WebDriver driver;

    // Constructor to initialize driver
    public About(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement SuccessAboutLoc() {
        return driver.findElement(By.cssSelector("img[alt=\"search\"]"));
    }

}
