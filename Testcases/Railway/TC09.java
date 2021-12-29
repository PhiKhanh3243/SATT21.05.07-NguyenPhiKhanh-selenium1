package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC09 extends TestBase{
    @Test
    public void TC09()
    {
        System.out.println("TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        loginPage.gotoChangePassword();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD,"a123:\"/{}!@$\\","b456:\"/{}!@$\\");
        String actualMsg = changePasswordPage.getChangepaswwordErrorMessage();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }
}
