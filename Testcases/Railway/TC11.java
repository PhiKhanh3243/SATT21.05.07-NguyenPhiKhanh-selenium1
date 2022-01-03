package Railway;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
import java.util.concurrent.TimeUnit;
public class TC11 extends TestBase{
    @Test
    public void TC11()
    {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegister();
        RegisterPage registerPage = new RegisterPage();
        Constant.WEBDRIVER.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor)Constant.WEBDRIVER;
        jse.executeScript("scroll(0, 250)");

        registerPage.register(Constant.USERNAME, "","", "");
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);

        String actualMsgPassword = registerPage.getRegisterMessageError();
        String expectedMsgPassword = "There're errors in the form. Please correct the errors and try again.";

        String actualMsgCPassword = registerPage.getPasswordErrorMessage();
        String expectedMsgCPassword = "Invalid password length.";

        String actualMsgPID = registerPage.getPIDErrorMessage();
        String expectedMsgPID = "Invalid ID length.";


        Assert.assertEquals(actualMsgPassword,expectedMsgPassword,"Error message is not displayed as expected");
        Assert.assertEquals(actualMsgCPassword,expectedMsgCPassword,"Error message is not displayed as expected");
        Assert.assertEquals(actualMsgPID,expectedMsgPID,"Error message is not displayed as expected");

    }
}
