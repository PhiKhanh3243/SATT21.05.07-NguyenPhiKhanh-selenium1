package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    private final By loc_titleHomePage = By.xpath("//div//h1[@align='center' and text()='Welcome to Safe Railway']");

    public WebElement getLoc_TitleHomePage() {
        return Constant.WEBDRIVER.findElement(loc_titleHomePage);
    }

    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public String getTitleHomePage(){
        return getLoc_TitleHomePage().getText();
    }
}
