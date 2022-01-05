package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
public class TC04 extends TestBase{
    @Test(description = "TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab")
    public void TC04(){
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoBookticket();
        LoginPage loginPage = new LoginPage();
        String actualMsg = loginPage.getTitleLoginPage();
        String expectedMsg ="Login Page";
        Assert.assertEquals(actualMsg,expectedMsg,"Login page does not display when un-logged User clicks on 'Book ticket' tab");
    }
}
