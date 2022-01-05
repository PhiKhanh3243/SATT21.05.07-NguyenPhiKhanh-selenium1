package Railway;

import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC17 extends TestBase {
    @Test(description = "TC17 - User can book many tickets at a time",dataProvider = "data-provider")
    public void TC17(String departDate1, String departFrom1, String arriveAt1, String seatType1,String ticketAmount1,String departDate2, String departFrom2, String arriveAt2, String seatType2,String ticketAmount2) {
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookticket();

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.bookTicket(departDate1, departFrom1, arriveAt1, seatType1, ticketAmount1);

        loginPage.gotoBookticket();
        bookTicketPage.bookTicket(departDate2, departFrom2, arriveAt2, seatType2, ticketAmount2);
        Assert.assertEquals(bookTicketPage.getBookTicketErrorMsg(), "There're errors in the form. Please correct the errors and try again.", "Welcome message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTicketAmountErrorMsg(), "You have booked 10 tickets. You can book no more.", "Welcome message is not displayed as expected");
    }
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.Utilities.getDataPath();
        JsonObject jsonObject = Common.JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate1 = dataTC17.get("departDate1").getAsString();
        String departFrom1= dataTC17.get("departFrom1").getAsString();
        String arriveAt1 = dataTC17.get("arriveAt1").getAsString();
        String seatType1 = dataTC17.get("seatType1").getAsString();
        String ticketAmount1 = dataTC17.get("ticketAmount1").getAsString();
        String departDate2 = dataTC17.get("departDate2").getAsString();
        String departFrom2 = dataTC17.get("departFrom2").getAsString();
        String arriveAt2 = dataTC17.get("arriveAt2").getAsString();
        String seatType2 = dataTC17.get("seatType2").getAsString();
        String ticketAmount2 = dataTC17.get("ticketAmount2").getAsString();

        Object[][] object = new Object[][]{
                {departDate1, departFrom1, arriveAt1,seatType1,ticketAmount1,departDate2, departFrom2, arriveAt2,seatType2,ticketAmount2}
        };

        return object;
    }
}
