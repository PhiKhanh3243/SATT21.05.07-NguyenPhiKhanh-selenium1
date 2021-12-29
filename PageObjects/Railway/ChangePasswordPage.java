package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;
public class ChangePasswordPage extends GeneralPage{
    //locators

    private final By loc_txtCurrentPassword = By.id("currentPassword");

    private final By loc_txtNewPassword = By.id("newPassword");

    private final By loc_txtConfirmPassword = By.id("confirmPassword");

    private final By loc_btnChangePassword = By.xpath("//input[@value='Change Password']");

    private final By loc_lblChangepasswordErrorMessage = By.xpath("//p[@class='message error']");


    //elements

    public WebElement gettxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(loc_txtCurrentPassword);
    }

    public WebElement gettxtNewPassword(){return Constant.WEBDRIVER.findElement(loc_txtNewPassword);}

    public WebElement gettxtconfirmPassword(){return Constant.WEBDRIVER.findElement(loc_txtConfirmPassword);}

    public WebElement getbtnChangePassword(){return Constant.WEBDRIVER.findElement(loc_btnChangePassword);}

    public WebElement getlblChangepasswordErrorMessage(){return Constant.WEBDRIVER.findElement(loc_lblChangepasswordErrorMessage);}

    //methods

    public void changePassword(String password, String newpassword, String confirmpassword){
        this.gettxtCurrentPassword().sendKeys(password);
        this.gettxtNewPassword().sendKeys(newpassword);
        this.gettxtconfirmPassword().sendKeys(confirmpassword);
        this.getbtnChangePassword().click();
    }

    public String getChangepaswwordErrorMessage(){
        return getlblChangepasswordErrorMessage().getText();
    }

}

