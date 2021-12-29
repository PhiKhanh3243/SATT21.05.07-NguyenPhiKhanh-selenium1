package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    // Locators
    private final By loc_tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");

    private final By loc_tabLogout = By.xpath("//a[@href='/Account/Logout']");

    private final By loc_lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    private final By loc_lblErrorMessage = By.xpath("//p[@class='message error LoginForm']");

    private final By loc_tabBookticket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");

    private final By loc_tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");

    private final By loc_tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    // Elements
    protected WebElement getTablogin(){
        return Constant.WEBDRIVER.findElement(loc_tabLogin);
    }

    protected WebElement getTablogout(){
        return Constant.WEBDRIVER.findElement(loc_tabLogout);
    }
    protected WebElement getlblWelcomeMessage(){return Constant.WEBDRIVER.findElement(loc_lblWelcomeMessage);}

    protected WebElement getlblErrorMessage(){return Constant.WEBDRIVER.findElement(loc_lblErrorMessage);}

    protected WebElement gettabBookTicket(){return Constant.WEBDRIVER.findElement(loc_tabBookticket);}

    protected WebElement gettabContact(){return Constant.WEBDRIVER.findElement(loc_tabContact);}

    protected WebElement gettabRegister(){return Constant.WEBDRIVER.findElement(loc_tabRegister);}

    // methods

    public String getWelcomeMessage(){return this.getlblWelcomeMessage().getText();}

    public String getErrorMessage(){return this.getlblErrorMessage().getText();}

    public void gotoLoginPage(){this.getTablogin().click();}

    public void gotoBookticket(){
        this.gettabBookTicket().click();
    }
    public void gotoLogout(){
        this.getTablogout().click();
    }

    public void gotoRegister(){
        this.gettabRegister().click();
    }

    public boolean tabLogoutIsDisplays(){
        try {
            this.getTablogout().isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

}
