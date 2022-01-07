import Railway.*;
import Railway.TestBase;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC702 extends TestBase {
    @Test(description = "FTTC702 - User can book tickets at a time")
    public void FTTC702(){
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.Constant.USERNAME, Constant.Constant.PASSWORD);

        BookTicketPage bookTicketPage = new BookTicketPage();
        loginPage.gotoBookticket();
        bookTicketPage.bookTicket("1/12/2022", "Nha Trang", "Huế", "Soft seat", "1");
        loginPage.gotoBookticket();
        bookTicketPage.bookTicket("1/13/2022", "Nha Trang", "Huế", "Soft seat", "1");
        loginPage.gotoBookticket();
        bookTicketPage.bookTicket("1/14/2022", "Nha Trang", "Huế", "Soft seat", "1");
        loginPage.gotoBookticket();
        bookTicketPage.bookTicket("1/15/2022", "Nha Trang", "Huế", "Soft seat", "1");
        loginPage.gotoBookticket();
        bookTicketPage.bookTicket("1/16/2022", "Nha Trang", "Huế", "Soft seat", "1");
        loginPage.gotoBookticket();
        bookTicketPage.bookTicket("1/17/2022", "Nha Trang", "Huế", "Soft seat", "1");
        loginPage.gotoMyTicket();


        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.ApplyFilter("1/13/2022","Huế");
        Assert.assertTrue(myTicketPage.tableRowCount() == myTicketPage.tableRowCountWithInfo("Huế","1/13/2022"));

    }
}
