package Railway;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TC07 extends TestBase {
    @Test (description = "TC07 - User can create new account")
    public void TC07() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegister();
        RegisterPage registerPage = new RegisterPage();
        Constant.WEBDRIVER.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("scroll(0, 250)");
        String emailString = randomEmail(10);
        registerPage.register(emailString, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        String actualMsg = registerPage.getRegisterMessage();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    public String randomEmail(int amountOfChar) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = amountOfChar;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString + "@gmai.com";
    }
}