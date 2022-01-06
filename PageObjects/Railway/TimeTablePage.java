package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constant.Constant;

public class TimeTablePage extends GeneralPage {
    //Locators
    private final By loc_txtHSPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[1]");

    private final By loc_txtSSPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[2]");

    private final By loc_txtSSCPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[3]");

    private final By loc_txtHBPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[4]");

    private final By loc_txtSBPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[5]");

    private final By loc_txtSBCPrice = By.xpath("//th[contains(text(), 'Price (VND)')]/..//td[6]");

    private final By loc_txtTableHeader = By.xpath("//tr[@class='TableSmallHeader']//th");
    //Dynamic locators
    String linkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href, 'TicketPricePage.cshtml?id1=1&id2=2')]";


    //Elements
    protected WebElement getLnkCheckPrice(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCheckPrice, depart, arrive)));
    }

    protected WebElement getLoc_TxtTableHeader() {
        return Constant.WEBDRIVER.findElement(loc_txtTableHeader);
    }

    protected WebElement getLoc_TxtHSPrice() {
        return Constant.WEBDRIVER.findElement(loc_txtHSPrice);
    }

    protected WebElement getLoc_TxtSSPrice() {
        return Constant.WEBDRIVER.findElement(loc_txtSSPrice);
    }

    protected WebElement getLoc_TxtSSCPrice() {
        return Constant.WEBDRIVER.findElement(loc_txtSSCPrice);
    }

    protected WebElement getLoc_TxtHBPrice() {
        return Constant.WEBDRIVER.findElement(loc_txtHBPrice);
    }

    protected WebElement getLoc_TxtSBPrice() {
        return Constant.WEBDRIVER.findElement(loc_txtSBPrice);
    }

    protected WebElement getLoc_TxtSBCPrice() {
        return Constant.WEBDRIVER.findElement(loc_txtSBCPrice);
    }

    //Methods
    public void CheckPrice(String depart, String arrive) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("arguments[0].scrollIntoView();", getLnkCheckPrice(depart, arrive));
        this.getLnkCheckPrice(depart, arrive).click();
    }

    public String getTxtHSPrice() {
        return getLoc_TxtHSPrice().getText();
    }

    public String getTxtSSPrice() {
        return getLoc_TxtSSPrice().getText();
    }

    public String getTxtSSCPrice() {
        return getLoc_TxtSSCPrice().getText();
    }

    public String getTxtHBPrice() {
        return getLoc_TxtHBPrice().getText();
    }

    public String getTxtSBPrice() {
        return getLoc_TxtSBPrice().getText();
    }

    public String getTxtSBCPrice() {
        return getLoc_TxtSBCPrice().getText();
    }

    public String getTxtTableHeader() {
        return getLoc_TxtTableHeader().getText();
    }
}
