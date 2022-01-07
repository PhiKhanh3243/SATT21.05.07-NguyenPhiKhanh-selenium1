package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage{
    //locator
    private final By loc_btnTicketPriceHUE_QN = By.xpath("//a[@href='TicketPricePage.cshtml?id1=5&id2=6']");

    private final By loc_btnBookHardSeat = By.xpath("//a[@href='BookTicketPage.cshtml?id1=5&id2=6&id3=1']");
    //elements

    protected WebElement getBtnTicketPrice() {
        return Constant.Constant.WEBDRIVER.findElement(loc_btnTicketPriceHUE_QN);
    }

    protected WebElement getBtnBookHardSeat() {
        return Constant.Constant.WEBDRIVER.findElement(loc_btnBookHardSeat);
    }


    //methods

    public void CheckPrice() {

        JavascriptExecutor jse = (JavascriptExecutor) Constant.Constant.WEBDRIVER;
        jse.executeScript("arguments[0].scrollIntoView();",getBtnTicketPrice());
        this.getBtnTicketPrice().click();
    }

    public void BookHardSeat() {
        JavascriptExecutor jse = (JavascriptExecutor) Constant.Constant.WEBDRIVER;
        jse.executeScript("arguments[0].scrollIntoView();",getBtnBookHardSeat());
        this.getBtnBookHardSeat().click();
    }


}
