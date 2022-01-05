package Railway;

import com.google.gson.JsonObject;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Constant.Constant;
import Utilities.Utilities;
public class TC14 extends TestBase{
    @Test(description = "TC14 - User can book many tickets at a time",dataProvider = "data-provider")
    public void TC14(String departDate, String departFrom, String arriveAt, String seatType,String ticketAmount){
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookticket();

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.bookTicket(departDate,departFrom,arriveAt,seatType,ticketAmount);

        Assert.assertEquals(bookTicketPage.getLblSuccessMessage(),"Ticket Booked Successfully!","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getDepartFromSuccessMessage(),"Nha Trang","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getArriveAtSuccessMessage(),"Sài Gòn","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getSeatTypeSuccessMessage(),"Soft seat with air conditioner","Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTicketAmountSuccessMessage(),"5","Welcome message is not displayed as expected");

    }
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getDataPath();
        JsonObject jsonObject = Common.JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate = dataTC14.get("departDate").getAsString();
        String departFrom= dataTC14.get("departFrom").getAsString();
        String arriveAt = dataTC14.get("arriveAt").getAsString();
        String seatType = dataTC14.get("seatType").getAsString();
        String ticketAmount = dataTC14.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departDate, departFrom, arriveAt,seatType,ticketAmount}
        };

        return object;
    }
}
