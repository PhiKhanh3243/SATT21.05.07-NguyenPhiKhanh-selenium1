package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC03 extends TestBase {
    @Test (description = "TC03 - User cannot log into Railway with invalid password")
    public void TC03() {
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, "12345");
        String actualMsg = homePage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}
