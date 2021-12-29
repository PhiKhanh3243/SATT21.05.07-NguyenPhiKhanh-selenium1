package Railway;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
import java.util.concurrent.TimeUnit;

public class TC10 extends TestBase{
    @Test
    public void TC10()
    {
        System.out.println("TC10 - User can't create account with an already in-use email");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegister();
        RegisterPage registerPage = new RegisterPage();
        Constant.WEBDRIVER.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor)Constant.WEBDRIVER;
        jse.executeScript("scroll(0, 250)");

        registerPage.register(Constant.USERNAME, Constant.PASSWORD,Constant.PASSWORD, Constant.PID);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        String actualMsg = registerPage.getRegisterMessageError();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }
}
