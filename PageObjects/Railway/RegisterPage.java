package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends GeneralPage{
    //Locators

    private final By loc_txtEmail = By.id("email");

    private final By loc_txtPassword = By.id("password");

    private final By loc_txtConfirmPassword = By.id("confirmPassword");

    private final By loc_txtPID = By.id("pid");

    private final By loc_btnRegister = By.xpath("//p[@class='form-actions']//input[@value='Register']");

    private final By loc_lblRegisterSuccess = By.xpath("//div[@id='content']");

    private final By loc_lblregisterMessageError = By.xpath("//p[@class='message error']");

    private final By loc_lblPasswordErrorMessage = By.xpath("//li//label[@for='password' and @class='validation-error']");

    private final By loc_lblConfirmPasswordErrorMessage = By.xpath("//li//label[@for='confirmPassword' and @class='validation-error']");

    private final By loc_lblPIDErrorMessage = By.xpath("//li//label[@for='pid' and @class='validation-error']");

    // Elements
    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(loc_txtEmail);
    }

    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(loc_txtPassword);
    }

    public WebElement getTxtConfirmPassword(){return Constant.WEBDRIVER.findElement(loc_txtConfirmPassword);}

    public WebElement getTxtPID(){
        return Constant.WEBDRIVER.findElement(loc_txtPID);
    }

    public WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(loc_btnRegister);
    }

    public WebElement getLblRegisterSuccess(){
        return Constant.WEBDRIVER.findElement(loc_lblRegisterSuccess);
    }

    public WebElement getLblregisterMessageError(){return Constant.WEBDRIVER.findElement(loc_lblregisterMessageError);}

    public WebElement getlblPasswordErrorMessage(){return Constant.WEBDRIVER.findElement(loc_lblPasswordErrorMessage);}

    public WebElement getlblConfirmPasswordErrorMessage(){return Constant.WEBDRIVER.findElement(loc_lblConfirmPasswordErrorMessage);}

    public WebElement getlblPIDErrorMessage(){return Constant.WEBDRIVER.findElement(loc_lblPIDErrorMessage);}

    //methods

    public void register (String email, String password,String confirmpassword, String pid){
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmpassword);
        this.getTxtPID().sendKeys(pid);
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getBtnRegister()));
        element.click();
    }
    public String getRegisterMessage(){
        return this.getLblRegisterSuccess().getText();
    }
    public String getRegisterMessageError(){
        return this.getLblregisterMessageError().getText();
    }
    public String getPasswordErrorMessage(){
        return getlblPasswordErrorMessage().getText();
    }
    public String getConfirmPasswordErrorMessage(){
        return getlblConfirmPasswordErrorMessage().getText();
    }
    public String getPIDErrorMessage(){
        return getlblPIDErrorMessage().getText();
    }
}
