package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC01 extends TestBase {
    @Test (description = "TC01 - User can log in into Railway with valid username and password")
    public void TC01() {
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
