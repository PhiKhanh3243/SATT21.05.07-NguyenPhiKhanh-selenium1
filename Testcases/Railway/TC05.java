package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC05 extends TestBase {
    @Test (description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginLoop(Constant.USERNAME, "12345", 3);
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
