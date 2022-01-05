package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralPage {
    // Locators
    private final By loc_tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");

    private final By loc_tabLogout = By.xpath("//a[@href='/Account/Logout']");

    private final By loc_lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    private final By loc_lblErrorMessage = By.xpath("//p[@class='message error LoginForm']");

    private final By loc_tabBookticket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");

    private final By loc_tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");

    private final By loc_tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");

    private final By loc_tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");

    private final By loc_tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");

    private final By loc_lnkCheckPrice = setLocCheckPrice("Đà Nẵng", "Sài Gòn");

    // Elements
    protected WebElement getTablogin() {
        return Constant.WEBDRIVER.findElement(loc_tabLogin);
    }

    protected WebElement getTablogout() {
        return Constant.WEBDRIVER.findElement(loc_tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(loc_lblWelcomeMessage);
    }

    protected WebElement getLblErrorMessage() {
        return Constant.WEBDRIVER.findElement(loc_lblErrorMessage);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(loc_tabBookticket);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(loc_tabContact);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(loc_tabRegister);
    }

    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(loc_tabTimeTable);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(loc_tabMyTicket);
    }


    // methods

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessage() {
        return this.getLblErrorMessage().getText();
    }

    public void gotoLoginPage() {
        this.getTablogin().click();
    }

    public void gotoBookticket() {
        this.getTabBookTicket().click();
    }

    public void gotoLogout() {
        this.getTablogout().click();
    }

    public void gotoRegister() {
        this.getTabRegister().click();
    }

    public void gotoTimeTable() {
        this.getTabTimeTable().click();
    }

    public void gotoMyTicket() {
        this.getTabMyTicket().click();
    }

    public boolean tabLogoutIsDisplays() {
        try {
            boolean isDisplayed = this.getTablogout().isDisplayed();
            return isDisplayed;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public By setLocCheckPrice(String Depart, String Arrive) {
        return By.xpath("//td[text()='" + Depart + "']/following-sibling::td[text()='" + Arrive + "']/..//a[contains(@href, 'TicketPricePage.cshtml?id1=1&id2=2')]");
    }


}
