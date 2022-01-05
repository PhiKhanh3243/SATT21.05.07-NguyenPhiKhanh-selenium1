package Railway;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC15 extends TestBase {
    @Test (description = "TC15 - Ticket price page displays with ticket details after clicking on check price link in Train timetable\" page")
    public void TC15() {
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        Constant.WEBDRIVER.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("scroll(250, 0)");
        loginPage.gotoTimeTable();
        TimeTablePage timeTablePage = new TimeTablePage();
        timeTablePage.CheckPrice("Đà Nẵng", "Sài Gòn");
        Assert.assertEquals("Ticket price from Đà Nẵng to Sài Gòn", timeTablePage.getTxtTableHeader(), "Welcome message is not displayed as expected");
        Assert.assertEquals("310000", timeTablePage.getTxtHSPrice(), "Welcome message is not displayed as expected");
        Assert.assertEquals("335000", timeTablePage.getTxtSSPrice(), "Welcome message is not displayed as expected");
        Assert.assertEquals("360000", timeTablePage.getTxtSSCPrice(), "Welcome message is not displayed as expected");
        Assert.assertEquals("410000", timeTablePage.getTxtHBPrice(), "Welcome message is not displayed as expected");
        Assert.assertEquals("460000", timeTablePage.getTxtSBPrice(), "Welcome message is not displayed as expected");
        Assert.assertEquals("510000", timeTablePage.getTxtSBCPrice(), "Welcome message is not displayed as expected");
    }
}
