package features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckOut;
import pages.P01_LoginPageLocators;
import pages.P02_HomePageLocators;
import pages.SocialMedia;

public class F03_ContinueBuyingProcess {
    public static WebDriver driver;
    P01_LoginPageLocators loc1;
    P02_HomePageLocators loc2;
    SocialMedia loc3;
    CheckOut loc4;
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
        loc4 = new CheckOut(driver);
    }
    @Test(testName = "Buying with valid inputs", dataProvider = "ValidInput", priority = 0)
    void Buying_with_valid_inputs(String UserName, String PassWord,String FirstName, String LastNAme , String PostalCode) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.ClickAllItems();
        loc2.GetCartLoc().click();
        loc4.GetContinueShoppingLoc().click();
        loc2.GetCartLoc().click();
        boolean c1 = loc3.GetCurrentUrl().contains("cart");
        s.assertTrue(c1);
        loc4.GetCheckOutLoc().click();
        loc4.GetCancelLoc().click();
        loc4.GetCheckOutLoc().click();
        loc4.GetFirstNameLoc().sendKeys(FirstName);
        loc4.GetLastNameLoc().sendKeys(LastNAme);
        loc4.GetPostalCodeLoc().sendKeys(PostalCode);
        loc4.GetContinueBuyingLoc().click();
        boolean c2 = loc3.GetCurrentUrl().contains("checkout-step-two");
        s.assertTrue(c2);
        boolean c3 = loc4.GetItemTotalLoc().getText().equals("Item total: $129.94");
        s.assertTrue(c3);
        boolean c4 = loc4.GetTaxlLoc().getText().equals("Tax: $10.40");
        s.assertTrue(c4);
        boolean c5 = loc4.GetTotalPriceLoc().getText().equals("Total: $140.34");
        s.assertTrue(c5);
        loc4.GetFinishCheckoutlLoc().click();
        boolean c6 = loc4.GetThankyouForTheOrderLoc().isDisplayed();
        s.assertTrue(c6);
        loc4.GetBackLoc().click();
        boolean c7 = loc2.SuccessLoginLoc().isDisplayed();
        s.assertTrue(c7);
        s.assertAll();
    }
    @Test(testName = "Buying_with_Invalid_input_FirstName", dataProvider = "InValidInput_FirstName", priority = 1)
    void Buying_with_Invalid_input_FirstName(String UserName, String PassWord,String FirstName, String LastNAme , String PostalCode) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.ClickAllItems();
        loc2.GetCartLoc().click();
        boolean c1 = loc3.GetCurrentUrl().contains("cart");
        s.assertTrue(c1);
        loc4.GetCheckOutLoc().click();
        loc4.GetFirstNameLoc().sendKeys(FirstName);
        loc4.GetLastNameLoc().sendKeys(LastNAme);
        loc4.GetPostalCodeLoc().sendKeys(PostalCode);
        loc4.GetContinueBuyingLoc().click();
        boolean c2 = loc4.GetErrorMsgLoc().getText().contains("Error: First Name is required");
        s.assertTrue(c2);
        s.assertAll();
    }
    @Test(testName = "Buying_with_Invalid_input_LastName", dataProvider = "InValidInput_LastName", priority = 2)
    void Buying_with_Invalid_input_LastName(String UserName, String PassWord,String FirstName, String LastNAme , String PostalCode) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.ClickAllItems();
        loc2.GetCartLoc().click();
        boolean c1 = loc3.GetCurrentUrl().contains("cart");
        s.assertTrue(c1);
        loc4.GetCheckOutLoc().click();
        loc4.GetFirstNameLoc().sendKeys(FirstName);
        loc4.GetLastNameLoc().sendKeys(LastNAme);
        loc4.GetPostalCodeLoc().sendKeys(PostalCode);
        loc4.GetContinueBuyingLoc().click();
        boolean c2 = loc4.GetErrorMsgLoc().getText().contains("Error: Last Name is required");
        s.assertTrue(c2);
        s.assertAll();
    }
    @Test(testName = "Buying_with_Invalid_input_PostalCode", dataProvider = "InValidInput_PostalCode", priority = 3)
    void Buying_with_Invalid_input_PostalCode(String UserName, String PassWord,String FirstName, String LastNAme , String PostalCode) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.ClickAllItems();
        loc2.GetCartLoc().click();
        boolean c1 = loc3.GetCurrentUrl().contains("cart");
        s.assertTrue(c1);
        loc4.GetCheckOutLoc().click();
        loc4.GetFirstNameLoc().sendKeys(FirstName);
        loc4.GetLastNameLoc().sendKeys(LastNAme);
        loc4.GetPostalCodeLoc().sendKeys(PostalCode);
        loc4.GetContinueBuyingLoc().click();
        boolean c2 = loc4.GetErrorMsgLoc().getText().contains("Error: Postal Code is required");
        s.assertTrue(c2);
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
                {"standard_user", "secret_sauce","Mohamed","Ayman","1234"},
                // {"problem_user", "secret_sauce"},
                // {"performance_glitch_user", "secret_sauce"},
                // {"error_user", "secret_sauce"},
                // {"visual_user", "secret_sauce"},
        };
        return Vdata;
    }
    @org.testng.annotations.DataProvider(name = "InValidInput_FirstName")
        String [][] GiveInValiddata_FirstName() {
            String InVdata[][] = {
                    {"standard_user", "secret_sauce","","Ayman","1234"},
                    {"standard_user", "secret_sauce","   ","Ayman","1234"},
                    {"standard_user", "secret_sauce","1234","Ayman","1234"},
            };
            return InVdata;
        }
    @org.testng.annotations.DataProvider(name = "InValidInput_LastName")
    String [][] GiveInValiddata_LastName() {
        String InVdata[][] = {
                {"standard_user", "secret_sauce","Mohamed","","1234"},
                {"standard_user", "secret_sauce","Mohamed","   ","1234"},
                {"standard_user", "secret_sauce","Mohamed","1234","1234"},

        };
        return InVdata;
    }
    @org.testng.annotations.DataProvider(name = "InValidInput_PostalCode")
    String [][] GiveInValiddata_Postalcode() {
        String InVdata[][] = {
                {"standard_user", "secret_sauce","Mohamed","Ayman",""},
                {"standard_user", "secret_sauce","Mohamed","Ayman","  "},
                {"standard_user", "secret_sauce","Mohamed","Ayman","mohamed"},
        };
        return InVdata;
    }
}
