package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    // Locators
    private final By loc_txtUsername = By.id("username");

    private final By loc_txtPassword = By.id("password");

    private final By loc_btnLogin = By.xpath("//input[@value='login']");

    private final By loc_tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    // Elements
    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(loc_txtUsername);
    }

    public WebElement gettxtPassword(){
        return Constant.WEBDRIVER.findElement(loc_txtPassword);
    }

    public WebElement getbtnLogin(){
        return Constant.WEBDRIVER.findElement(loc_btnLogin);
    }

    public WebElement gettabChangePassword(){
        return Constant.WEBDRIVER.findElement(loc_tabChangePassword);
    }

    // methods
    public void login(String username, String password){
        this.getTxtUsername().sendKeys(username);
        this.gettxtPassword().sendKeys(password);
        this.getbtnLogin().click();
    }
    public void loginLoop(String username, String password, int n){
        for(int i = 0; i <= n; i++){
            this.login(username,password);
        }
    }

    public void gotoContact(){this.gettabContact().click();}
    public void gotoChangePassword(){this.gettabChangePassword().click();}
}

