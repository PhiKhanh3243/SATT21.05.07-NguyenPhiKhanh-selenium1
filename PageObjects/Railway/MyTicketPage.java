package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTicketPage extends GeneralPage{
    //Locators

    //dynamic locator
    String linkCancelTicket = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";

    //Elements
    protected WebElement getBtnCancel(String noID,String depart, String arrive){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCancelTicket,noID,depart, arrive)));
    };
    //Methods
    public void cancelTicket(String noID,String depart,String arrive){
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getBtnCancel(noID,depart,arrive)));
        this.getBtnCancel(noID,depart,arrive).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
    public boolean isDisplayedBtnCancel(String noID,String depart,String arrive){
        try {
            return this.getBtnCancel(noID, depart, arrive).isDisplayed();
        }catch(NoSuchElementException ex){
            return false;
        }
    }
}
