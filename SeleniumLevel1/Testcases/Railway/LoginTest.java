package Railway;

import Constant.Constant;
import Utilities.Utilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().setSize(new Dimension(1080,720));
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void TC01(){
        System.out.println("TC01 - User can log in into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome "
                + Constant.USERNAME;
        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");
    }
    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.loginBlankUsername(Constant.PASSWORD).getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }
    @Test
    public void TC03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.loginInvalidPassword(Constant.USERNAME).getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }
    @Test
    public void TC04(){
        System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoBookticket();
        String actualMsg = Constant.WEBDRIVER.getCurrentUrl();
        String expectedMsg ="http://www.railway.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
        Assert.assertEquals(actualMsg,expectedMsg,"Login page does not display when un-logged User clicks on 'Book ticket' tab");
    }
    @Test
    public void TC05(){
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        for(int i = 0; i <= 3; i++){
            loginPage.loginInvalidPassword(Constant.USERNAME);
        }
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }
}
