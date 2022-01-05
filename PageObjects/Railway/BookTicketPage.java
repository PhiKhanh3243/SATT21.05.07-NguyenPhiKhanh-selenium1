package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constant.Constant;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookTicketPage extends GeneralPage {
    // Locators
    private final By loc_departDate = By.xpath("//li//select[@name='Date']");

    private final By loc_departFrom = By.xpath("//li//select[@name='DepartStation']");

    private final By loc_arriveAt = By.xpath("//select[@name='ArriveStation']");

    private final By loc_seatType = By.xpath("//li//select[@name='SeatType']");

    private final By loc_ticketAmount = By.xpath("//li//select[@name='TicketAmount']");

    private final By loc_departDateSuccess = By.xpath("//tr[@class='OddRow']//td[4]");

    private final By loc_departFromSuccess = By.xpath("//tr[@class='OddRow']//td[1]");

    private final By loc_arriveAtSuccess = By.xpath("//tr[@class='OddRow']//td[2]");

    private final By loc_seatTypeSuccess = By.xpath("//tr[@class='OddRow']//td[3]");

    private final By loc_ticketAmountSuccess = By.xpath("//tr[@class='OddRow']//td[7]");

    private final By loc_btnBookTicket = By.xpath("//input[@value='Book ticket']");

    private final By loc_lblSuccessMessage = By.xpath("//h1[@align ='center']");

    private final By loc_lblBookTicketErrorMsg = By.xpath("//p[@class='message error']");

    private final By loc_TicketAmountErrorMsg = By.xpath("//select[@name='TicketAmount']/../label[@class='validation-error']");

    // Elements
    public WebElement getDepartDate() {
        return Constant.WEBDRIVER.findElement(loc_departDate);
    }

    public WebElement getDepartFrom() {
        return Constant.WEBDRIVER.findElement(loc_departFrom);
    }

    public WebElement getArriveAt() {
        return Constant.WEBDRIVER.findElement(loc_arriveAt);
    }

    public WebElement getSeatType() {
        return Constant.WEBDRIVER.findElement(loc_seatType);
    }

    public WebElement getTicketAmount() {
        return Constant.WEBDRIVER.findElement(loc_ticketAmount);
    }


    public WebElement getLoc_BtnBookTicket() {
        return Constant.WEBDRIVER.findElement(loc_btnBookTicket);
    }

    public WebElement getLoc_LblSuccess() {
        return Constant.WEBDRIVER.findElement(loc_lblSuccessMessage);
    }

    public WebElement getLoc_DepartDateSuccess() {
        return Constant.WEBDRIVER.findElement(loc_departDateSuccess);
    }

    public WebElement getLoc_DepartFromSuccess() {
        return Constant.WEBDRIVER.findElement(loc_departFromSuccess);
    }

    public WebElement getLoc_ArriveAtSuccess() {
        return Constant.WEBDRIVER.findElement(loc_arriveAtSuccess);
    }

    public WebElement getLoc_SeatTypeSuccess() {
        return Constant.WEBDRIVER.findElement(loc_seatTypeSuccess);
    }

    public WebElement getLoc_TicketAmountSuccess() {
        return Constant.WEBDRIVER.findElement(loc_ticketAmountSuccess);
    }

    public WebElement getLoc_BookTicketErrorMsg() {
        return Constant.WEBDRIVER.findElement(loc_lblBookTicketErrorMsg);
    }

    public WebElement getLoc_TicketAmountErrorMsg() {
        return Constant.WEBDRIVER.findElement(loc_TicketAmountErrorMsg);
    }

    // Method
    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {

        Select selectDepartDate = new Select(this.getDepartDate());
        selectDepartDate.selectByVisibleText(departDate);

        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Select selectDepartFrom = new Select(this.getDepartFrom());
        selectDepartFrom.selectByVisibleText(departFrom);

        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Select selectSeatType = new Select(this.getSeatType());
        selectSeatType.selectByVisibleText(seatType);

        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Select selectTicketAmount = new Select(this.getTicketAmount());
        selectTicketAmount.selectByVisibleText(ticketAmount);

        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        try {
            Select selectArriveAt = new Select(this.getArriveAt());
            selectArriveAt.selectByVisibleText(arriveAt);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            Select selectArriveAt = new Select(this.getArriveAt());
            selectArriveAt.selectByVisibleText(arriveAt);
        }
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        Constant.WEBDRIVER.manage().window().maximize();
        jse.executeScript("scroll(0, 250)");
        this.getLoc_BtnBookTicket().click();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public String getLblSuccessMessage() {
        return getLoc_LblSuccess().getText();
    }

    public String getDepartDateSuccessMessage() {
        return getLoc_DepartDateSuccess().getText();
    }

    public String getDepartFromSuccessMessage() {
        return getLoc_DepartFromSuccess().getText();
    }

    public String getArriveAtSuccessMessage() {
        return getLoc_ArriveAtSuccess().getText();
    }

    public String getSeatTypeSuccessMessage() {
        return getLoc_SeatTypeSuccess().getText();
    }

    public String getTicketAmountSuccessMessage() {
        return getLoc_TicketAmountSuccess().getText();
    }

    public String getBookTicketErrorMsg() {
        return getLoc_BookTicketErrorMsg().getText();
    }

    public String getTicketAmountErrorMsg() {
        return getLoc_TicketAmountErrorMsg().getText();
    }
}
