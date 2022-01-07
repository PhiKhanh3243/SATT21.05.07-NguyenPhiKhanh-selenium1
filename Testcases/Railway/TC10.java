package Railway;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

import java.util.concurrent.TimeUnit;

public class TC10 extends TestBase {
    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10() {
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegister();
        RegisterPage registerPage = new RegisterPage();
        Constant.WEBDRIVER.manage().window().maximize();
        registerPage.register(Constant.USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);
        String actualMsg = registerPage.getRegisterMessageError();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg, expectedMsg, "Message is not displayed as expected");
    }
}
