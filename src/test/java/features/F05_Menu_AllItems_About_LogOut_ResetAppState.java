package features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.About;
import pages.P02_HomePageLocators;

public class F05_Menu_AllItems_About_LogOut_ResetAppState {
    public static WebDriver driver;
    pages.Menu loc1;
    About loc2;
    P02_HomePageLocators loc3;

    SoftAssert s = new SoftAssert();

    @BeforeMethod
    void OpenChrome() {
        driver = new ChromeDriver();  // Initialize the driver
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Pass the driver instance to the page objects after initializing the driver
        loc1 = new pages.Menu(driver);
        loc2 = new About(driver);
        loc3 = new P02_HomePageLocators(driver);

    }

    @Test(testName = "Logout",dataProvider = "ValidInput",priority = 0 )
    void LogOut(String UserName , String PassWord) throws InterruptedException {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc1.GetMenuLoc().click();
        loc1.WaitForTheMenu();
        Thread.sleep(1000);
        loc1.LogOut();
        boolean c2 = loc1.GetLoginButtonLoc().isDisplayed();
        s.assertTrue(c2,"Errrror in Loggin out !");

        s.assertAll();
    }
    @Test(testName = "Logout then login again to verify thar the selected items still the same",dataProvider = "ValidInput",priority = 0 )
    void Logout_then_login_again(String UserName , String PassWord) throws InterruptedException {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc3.ClickAllItems();
        loc3.RemoveRandomItemLoc().click();
        boolean c1 = loc3.GetNumOfItems().getText().equals("5");
        s.assertTrue(c1);
        loc1.GetMenuLoc().click();
        loc1.WaitForTheMenu();
        Thread.sleep(1000);
        loc1.LogOut();
        boolean c2 = loc1.GetLoginButtonLoc().isDisplayed();
        s.assertTrue(c2,"Errrror in Loggin out !");
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        boolean c3 = loc3.GetNumOfItems().getText().equals("5");
        s.assertTrue(c3);



        s.assertAll();
    }
    @Test(testName = "AllItems",dataProvider = "ValidInput",priority = 1 )
    void AllItems(String UserName , String PassWord) throws InterruptedException {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc1.GetMenuLoc().click();
        loc1.WaitForTheMenu();
        Thread.sleep(1000);
        loc1.AllItems();
       boolean c3 = loc1.SuccessLoginLoc().isDisplayed();
        s.assertTrue(c3,"Go To a wrong Page!");

       s.assertAll();
    }
    @Test(testName = "About",dataProvider = "ValidInput",priority = 2 )
    void About(String UserName , String PassWord) throws InterruptedException {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc1.GetMenuLoc().click();
        loc1.WaitForTheMenu();
        Thread.sleep(1000);
        loc1.About();
        boolean c3 = loc2.SuccessAboutLoc().isDisplayed();
        s.assertTrue(c3,"Go To a wrong Page!");
        s.assertAll();
    }
    @Test(testName = "ResetAppState",dataProvider = "ValidInput",priority = 3 )
    void ResetAppState(String UserName , String PassWord) throws InterruptedException {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc1.GetMenuLoc().click();
        loc1.WaitForTheMenu();
        Thread.sleep(1000);
        loc1.ResetAppStats();
        boolean c3 = loc1.SuccessLoginLoc().isDisplayed();
        s.assertTrue(c3,"Go To a wrong Page!");
        s.assertAll();
    }


@AfterMethod
    void ExitChrome() throws InterruptedException {
    Thread.sleep(1000);
    driver.quit();
}

    @org.testng.annotations.DataProvider(name = "ValidInput")
    String [][] GiveValiddata (){

        String Vdata[][] ={ {"standard_user","secret_sauce"},
                // {"performance_glitch_user","secret_sauce"},
                //{"error_user","secret_sauce"},
                //{"visual_user","secret_sauce"},

        };
        return Vdata;
    }









}
