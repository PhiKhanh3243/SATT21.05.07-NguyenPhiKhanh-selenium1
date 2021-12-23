package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }
    public WebElement gettxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getbtnLogin(){
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }
    public WebElement getlblLoginErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public HomePage login(String username, String pasword){
        this.getTxtUsername().sendKeys(username);
        this.gettxtPassword().sendKeys(pasword);
        this.getbtnLogin().click();
        return new HomePage();
    }
    public HomePage loginBlankUsername( String pasword){
        this.getTxtUsername().sendKeys("");
        this.gettxtPassword().sendKeys(pasword);
        this.getbtnLogin().click();
        return new HomePage();
    }
    public HomePage loginInvalidPassword(String username){
        this.getTxtUsername().sendKeys(username);
        this.gettxtPassword().sendKeys("eqwrtqas");
        this.getbtnLogin().click();
        return new HomePage();
    }
}

