package features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPageLocators;
import pages.P02_HomePageLocators;

public class F02_Cart {

    public static WebDriver driver;
    P01_LoginPageLocators loc1;
    P02_HomePageLocators loc2;
    SoftAssert s = new SoftAssert();

    @BeforeMethod
    void OpenChrome() {
        driver = new ChromeDriver();  // Initialize the driver
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Pass the driver instance to the page objects after initializing the driver
        loc1 = new P01_LoginPageLocators(driver);
        loc2 = new P02_HomePageLocators(driver);
    }

    @Test(testName = "AddAllItems", dataProvider = "ValidInput", priority = 0)
    void AddAllItems(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.ClickAllItems();
        boolean c1 = loc2.GetNumOfItems().getText().equals("6");
        s.assertTrue(c1);
        s.assertAll();

    }
    @Test(testName = "DeleteAllItems", dataProvider = "ValidInput", priority = 1)
    void DeleteAllItems(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.ClickAllItems();
        loc2.DeleteAllItems();
        boolean c1 = loc2.GetAddToCartButton().getText().contains("cart");
        s.assertTrue(c1);
        s.assertAll();

    }
    @Test(testName = "AddRandomItem", dataProvider = "ValidInput", priority = 1)
    void AddRandomItem(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.AddRandomItemLoc().click();
        boolean c1 = loc2.GetNumOfItems().getText().equals("1");
        s.assertTrue(c1);
        s.assertAll();

    }
    @Test(testName = "RemoveRandomItem", dataProvider = "ValidInput", priority = 1)
    void RemoveRandomItem(String UserName, String PassWord)  {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.AddRandomItemLoc().click();
        loc2.WaitForRemove();
        loc2.RemoveRandomItemLoc().click();
        boolean c1 = loc2.AddRandomItemLoc().getText().contains("cart");
        s.assertTrue(c1);
        s.assertAll();

    }

    @AfterMethod
    void ExitChrome() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @org.testng.annotations.DataProvider(name = "ValidInput")
    String [][] GiveValiddata() {
        String Vdata[][] = {
                {"standard_user", "secret_sauce"},
                // {"problem_user", "secret_sauce"},
                // {"performance_glitch_user", "secret_sauce"},
                // {"error_user", "secret_sauce"},
                // {"visual_user", "secret_sauce"},
        };
        return Vdata;
    }
}