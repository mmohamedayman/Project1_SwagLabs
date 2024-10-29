package features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPageLocators;
import pages.P02_HomePageLocators;
import pages.SocialMedia;

public class F04_SocialMediaItems {
    public static WebDriver driver;
    P01_LoginPageLocators loc1;
    P02_HomePageLocators loc2;
    SocialMedia loc3;
    SoftAssert s = new SoftAssert();


    @BeforeMethod
    void OpenChrome() {
        driver = new ChromeDriver();  // Initialize the driver
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Pass the driver instance to the page objects after initializing the driver
        loc1 = new P01_LoginPageLocators(driver);
        loc2 = new P02_HomePageLocators(driver);
        loc3 = new SocialMedia(driver);
    }

    @Test(testName = "SocialMedia_X", dataProvider = "ValidInput", priority = 0)
    void SocialMedia_X(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc3.GetXloc().click();
        loc2.GoToTab(1);
        loc3.WaitForX();
        boolean c2 = loc3.GetCurrentUrl().contains("x.com/saucelabs");
        s.assertTrue(c2);
        s.assertAll();

    }
        @Test(testName = "SocialMedia_FB", dataProvider = "ValidInput", priority = 1)
        void SocialMedia_FB(String UserName, String PassWord) {
            loc1.GetUserNameLoc().sendKeys(UserName);
            loc1.GetPassWordLoc().sendKeys(PassWord);
            loc1.GetLoginButtonLoc().click();
            loc3.GetFBloc().click();
            loc2.GoToTab(1);
            loc3.WaitForFacebook();
            boolean c2 = loc3.GetCurrentUrl().contains("facebook.com/saucelabs");
            s.assertTrue(c2);
            s.assertAll();


    }
    @Test(testName = "SocialMedia_LI", dataProvider = "ValidInput", priority = 2)
    void SocialMedia_Li(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc3.GetLIloc().click();
        loc2.GoToTab(1);
        loc3.WaitForLinkedIn();
        boolean c2 = loc3.GetCurrentUrl().contains("/sauce-labs/");
        s.assertTrue(c2);
        s.assertAll();


    }


    @AfterMethod
    void ExitChrome() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @org.testng.annotations.DataProvider(name = "ValidInput")
    String[][] GiveValiddata() {

        String Vdata[][] = {{"standard_user", "secret_sauce"},
//                {"problem_user", "secret_sauce"},
//                {"performance_glitch_user", "secret_sauce"},
//                {"error_user", "secret_sauce"},
//                {"visual_user", "secret_sauce"},

        };
        return Vdata;
    }
}