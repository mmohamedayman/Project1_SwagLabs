package features;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPageLocators;
import pages.P02_HomePageLocators;
import pages.SocialMedia;
@Listeners({AllureTestNg.class})

public class F06_FilteredSearch {

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

    @Test(testName = "FilterByIndex0", dataProvider = "ValidInput", priority = 0)
    void FilterByIndex0(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.GetDropDownFilter(0);

//        boolean c1 = loc2.GetDropDownItem().getText().contains("Name(A to Z)");
//        s.assertTrue(c1);
//        s.assertAll();
    }
    @Test(testName = "FilterByIndex1", dataProvider = "ValidInput", priority = 1)
    void FilterByIndex1(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.GetDropDownFilter(1);
        //boolean c1 = driver.findElement(By.xpath("//*[@id=\"item_4_img_link\"]/img")).isDisplayed();

       // boolean c1 = loc2.GetDropDownItem().getText().equals("Name(Z to A)");
//        s.assertTrue(c1);
//        s.assertAll();
    }
    @Test(testName = "FilterByIndex2", dataProvider = "ValidInput", priority = 2)
    void FilterByIndex2(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.GetDropDownFilter(2);
//        boolean c1 = loc2.GetDropDownItem().getText().equals("Price (low to high)");
//        s.assertTrue(c1);
//        s.assertAll();
    }
    @Test(testName = "FilterByIndex3", dataProvider = "ValidInput", priority = 3)
    void FilterByIndex3(String UserName, String PassWord) {
        loc1.GetUserNameLoc().sendKeys(UserName);
        loc1.GetPassWordLoc().sendKeys(PassWord);
        loc1.GetLoginButtonLoc().click();
        loc2.GetDropDownFilter(3);
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
