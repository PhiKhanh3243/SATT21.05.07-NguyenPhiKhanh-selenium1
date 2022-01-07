import Railway.BookTicketPage;
import Railway.HomePage;
import Railway.LoginPage;
import Railway.TestBase;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC701 extends TestBase {
    @Test(description = "FTTC701 - User can book tickets at a time",dataProvider = "data-provider")
    public void FTTC701(String departDate, String departFrom, String arriveAt, String seatType,String ticketAmount){
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.Constant.USERNAME, Constant.Constant.PASSWORD);
        loginPage.gotoBookticket();

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.bookTicket(departDate,departFrom,arriveAt,seatType,ticketAmount);

        Assert.assertEquals(bookTicketPage.getLblSuccessMessage(),"Ticket Booked Successfully!","Message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getDepartDateSuccessMessage(),"1/14/2022","Message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getDepartFromSuccessMessage(),"Nha Trang","Message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getArriveAtSuccessMessage(),"Huế","Message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getSeatTypeSuccessMessage(),"Soft seat","Message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTicketAmountSuccessMessage(),"2","Message is not displayed as expected");

    }
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.Utilities.getDataPath();
        JsonObject jsonObject = Common.JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC701 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate = dataFTTC701.get("departDate").getAsString();
        String departFrom= dataFTTC701.get("departFrom").getAsString();
        String arriveAt = dataFTTC701.get("arriveAt").getAsString();
        String seatType = dataFTTC701.get("seatType").getAsString();
        String ticketAmount = dataFTTC701.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departDate, departFrom, arriveAt,seatType,ticketAmount}
        };

        return object;
    }
}
