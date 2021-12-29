package Railway;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Constant.Constant;

public class TC06 extends TestBase{
    @Test
    public void TC06(){
        System.out.println("TC06 - User is redirected to Home page after logging out");
        HomePage homePage = new HomePage();
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();
        System.out.println("Step 2: Login with valid Email and Password");
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("Step 3: Click on Contact tab");
        loginPage.gotoContact();
        System.out.println("Step 4: Click on Logout tab");
        loginPage.gotoLogout();
        String actualMsg = Constant.WEBDRIVER.getCurrentUrl();
        String expectedMsg = "http://www.railway.somee.com/Page/HomePage.cshtml";
        SoftAssert sortAssert = new SoftAssert();
        sortAssert.assertFalse(homePage.tabLogoutIsDisplays());
        sortAssert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
        sortAssert.assertAll();
    }

}
