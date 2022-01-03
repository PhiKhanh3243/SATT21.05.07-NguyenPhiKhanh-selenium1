package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
public class TC17 extends TestBase{
    @Test
    public void TC17(){
        System.out.println("TC17 - User can book many tickets at a time");
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookticket();

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.bookTicket("1/7/2022","Nha Trang","Sài Gòn","Soft seat with air conditioner","10");

        loginPage.gotoBookticket();
        bookTicketPage.bookTicket("1/7/2022","Nha Trang","Sài Gòn","Soft seat with air conditioner","1");
        Assert.assertEquals(bookTicketPage.getBookTicketErrorMsg(),"There're errors in the form. Please correct the errors and try again.","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTicketAmountErrorMsg(),"You have booked 10 tickets. You can book no more.","Welcome message is not displayed as expected");
    }
}
