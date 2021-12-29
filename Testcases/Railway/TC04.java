package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
public class TC04 extends TestBase{
    @Test
    public void TC04(){
        System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoBookticket();
        String actualMsg = Constant.WEBDRIVER.getCurrentUrl();
        String expectedMsg ="http://www.railway.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
        Assert.assertEquals(actualMsg,expectedMsg,"Login page does not display when un-logged User clicks on 'Book ticket' tab");
    }
}
