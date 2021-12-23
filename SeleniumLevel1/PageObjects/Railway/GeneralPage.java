package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    // Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By tabBookticket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    // Elements
    protected WebElement getTablogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTablogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getlblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getlblErrorMessage(){
        return Constant.WEBDRIVER.findElement(lblErrorMessage);
    }
    protected WebElement gettabBookTicket(){return Constant.WEBDRIVER.findElement(tabBookticket);}
    // methods
    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }
    public String getErrorMessage(){
        return this.getlblErrorMessage().getText();
    }
    public LoginPage gotoLoginPage(){
        this.getTablogin().click();
        return new LoginPage();
    }
    public LoginPage gotoBookticket(){
        this.gettabBookTicket().click();
        return new LoginPage();
    }
}
