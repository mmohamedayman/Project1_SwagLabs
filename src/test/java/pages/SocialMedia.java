package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class SocialMedia {
    private WebDriver driver;

    // Constructor to initialize driver
    public SocialMedia(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement GetXloc() {
        return driver.findElement(By.cssSelector("a[data-test=\"social-twitter\"]"));

    }
    public WebElement GetFBloc() {
        return driver.findElement(By.cssSelector("a[data-test=\"social-facebook\"]"));

    }
    public WebElement GetLIloc() {
        return driver.findElement(By.cssSelector("a[data-test=\"social-linkedin\"]"));

    }
    public WebElement Assertion_x (){
        return driver.findElement(By.cssSelector("a[href=\"/settings\"]"));
    }
    public void WaitForX() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=\"/settings\"]")));
    }
    public void WaitForFacebook() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login_popup_cta_form\"]/div/div[5]/div/div/div[1]")));
    }
    public void WaitForLinkedIn() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"base-contextual-sign-in-modal\"]/div/section/div/div/p[1]/a")));
    }
    public String GetCurrentUrl() {
        return Objects.requireNonNull(driver.getCurrentUrl());


    }




}
