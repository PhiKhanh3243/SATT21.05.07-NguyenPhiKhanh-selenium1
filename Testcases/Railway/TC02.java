package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
public class TC02 extends TestBase{
    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }
}
