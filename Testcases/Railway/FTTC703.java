import Railway.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FTTC703 extends Railway.TestBase {
    @Test(description = "FTTC703 - User can book ticket with known price ")
    public void FTTC702(){
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.Constant.USERNAME, Constant.Constant.PASSWORD);

        loginPage.gotoTicketPrice();
        TicketPricePage ticketPricePage = new TicketPricePage();
        ticketPricePage.CheckPrice();

        ticketPricePage.BookHardSeat();

        BookTicketPage bookTicketPage = new BookTicketPage();

        bookTicketPage.bookTicketWithAmount( "2");


        Assert.assertEquals(bookTicketPage.getLblSuccessMessage(),"Ticket Booked Successfully!","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getDepartFromSuccessMessage(),"Huế","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getArriveAtSuccessMessage(),"Quảng Ngãi","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getSeatTypeSuccessMessage(),"Hard seat","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTicketAmountSuccessMessage(),"2","Welcome message is not displayed as expected");


    }
}
