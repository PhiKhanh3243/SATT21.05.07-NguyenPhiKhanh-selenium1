package Railway;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC16 extends TestBase {
    @Test (description = "TC16 - ")
    public void TC16() {
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Constant.WEBDRIVER.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("scroll(250, 0)");
        loginPage.gotoMyTicket();
        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.cancelTicket("1", "Nha Trang", "Sài Gòn");
        Assert.assertFalse(myTicketPage.isDisplayedBtnCancel("1", "Nha Trang", "Sài Gòn"));
    }
}
