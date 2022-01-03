package Railway;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
public class TC14 extends TestBase{
    @Test
    public void TC14(){
        System.out.println("TC14 - User can book many tickets at a time");
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookticket();

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.bookTicket("1/7/2022","Nha Trang","Sài Gòn","Soft seat with air conditioner","5");

        Assert.assertEquals(bookTicketPage.getLblSuccessMessage(),"Ticket Booked Successfully!","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getDepartFromSuccessMessage(),"Nha Trang","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getArriveAtSuccessMessage(),"Sài Gòn","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getSeatTypeSuccessMessage(),"Soft seat with air conditioner","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTicketAmountSuccessMessage(),"5","Welcome message is not displayed as expected");

    }
}
