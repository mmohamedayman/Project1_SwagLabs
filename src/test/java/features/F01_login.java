package features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_LoginPageLocators;
import pages.P02_HomePageLocators;

public class F01_login {
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
@Test(testName = "ValidInput",dataProvider = "ValidInput",priority = 0 )
    void ValidInput(String UserName , String PassWord){
    loc1.GetUserNameLoc().sendKeys(UserName);
    loc1.GetPassWordLoc().sendKeys(PassWord);
    loc1.GetLoginButtonLoc().click();
    if (UserName.equals("performance_glitch_user")){
        loc2.WaitForTheGlitch();
    }
    boolean c1 = loc2.SuccessLoginLoc().isDisplayed();
    s.assertTrue(c1,"Valid Input Failed!");
//    loc2.GetMenuLoc().click();
//    loc2.WaitForTheMenu();
//    loc2.LogOut();
    s.assertAll();
}
@Test(testName = "InvalidInput",dataProvider = "InvalidInput",priority = 1)
public void InvalidInput (String UserName , String PassWord) {
    loc1.GetUserNameLoc().sendKeys(UserName);
    loc1.GetPassWordLoc().sendKeys(PassWord);
    loc1.GetLoginButtonLoc().click();
    if (loc1.GetUserNameLoc().getText().equals("") || loc1.GetUserNameLoc().getText().equals("   ") ) {

        boolean c2 = loc1.GetFailToLoginLoc().getText().equals("Epic sadface: Username is required");
        s.assertTrue(c2, "Error msg didn`t appear");

    }
    else if (loc1.GetPassWordLoc().getText().equals("") || loc1.GetPassWordLoc().getText().equals("   ") ) {
        boolean c2 = loc1.GetFailToLoginLoc().getText().equals("Epic sadface: Password is required");
        s.assertTrue(c2, "Error msg didn`t appear");


    }
    else if (UserName.equals("locked_out_user") ) {
        boolean c2 = loc1.GetFailToLoginLoc().getText().equals("Epic sadface: Sorry, this user has been locked out.");
        s.assertTrue(c2, "Error msg didn`t appear");


    }

    else {
        boolean c2 = loc1.GetFailToLoginLoc().getText().equals("Epic sadface: Username and password do not match any user in this service");
        s.assertTrue(c2, "Error msg didn`t appear");
        s.assertAll();

    }
}

@AfterMethod
    void ExitChrome() throws InterruptedException {
    Thread.sleep(1000);
    driver.quit();
}

@org.testng.annotations.DataProvider(name = "ValidInput")
String [][] GiveValiddata (){

    String Vdata[][] ={ {"standard_user","secret_sauce"},
            {"problem_user","secret_sauce"},
            {"performance_glitch_user","secret_sauce"},
            {"error_user","secret_sauce"},
            {"visual_user","secret_sauce"},

    };
    return Vdata;
}
@org.testng.annotations.DataProvider(name = "InvalidInput")
String [][] GiveInvaliddata (){

    String InvData[][] ={
            {"locked_out_user","secret_sauce"},
            {"","secret_sauce"},
            {"   ","secret_sauce"},
            {"",""},
            {"standard_user",""},
            {"standard_user","   "},
            {"standard_user","1234"},
            {"MohamedAyman","secret_sauce"},
            {"1234","1234"},
    };

    return InvData;
}








}
