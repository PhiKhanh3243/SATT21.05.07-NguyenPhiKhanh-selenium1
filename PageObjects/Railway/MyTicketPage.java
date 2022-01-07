package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyTicketPage extends GeneralPage{
    //Locators
    private final By loc_tblMyTicket = By.xpath("//div//table[@class='MyTable']/tbody");

    private final By loc_arriveStationFilter = By.xpath("//td//select[@name='FilterArStation']");

    private final By loc_departDateFilter = By.xpath("//td//input[@name='FilterDpDate']");

    private final By loc_btnFilter = By.xpath("//input[@value='Apply Filter']");

    //dynamic locator
    String linkCancelTicket = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";

    //Elements
    protected WebElement getBtnCancel(String noID,String depart, String arrive){
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCancelTicket,noID,depart, arrive)));
    };
    protected WebElement getTblMyTicket(){
        return Constant.WEBDRIVER.findElement(loc_tblMyTicket);
    };

    protected WebElement getArriveStationFilter(){
        return Constant.WEBDRIVER.findElement(loc_arriveStationFilter);
    };

    protected WebElement getDepartDateFilter(){
        return Constant.WEBDRIVER.findElement(loc_departDateFilter);
    };

    protected WebElement getBtnFilter(){
        return Constant.WEBDRIVER.findElement(loc_btnFilter);
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
    public int tableRowCount(){
        WebElement TogetRows = Constant.WEBDRIVER.findElement(loc_tblMyTicket);
        List<WebElement> TotalOddRowsList = TogetRows.findElements(By.xpath("//div//table[@class='MyTable']/tbody/tr[contains(@class,'OddRow')]"));
        List<WebElement> TotalEvenRowsList = TogetRows.findElements(By.xpath("//div//table[@class='MyTable']/tbody/tr[contains(@class,'EvenRow')]"));
        System.out.println("Total number of Rows in the table are : "+ (TotalOddRowsList.size()+TotalEvenRowsList.size()));
        return TotalOddRowsList.size()+TotalEvenRowsList.size();
    }
    public int tableRowCountWithInfo(String arrive,String departDate){
        List<WebElement> TotalRowsList = Constant.WEBDRIVER.findElements(By.xpath("//td[text()='"+arrive+"']/following-sibling::td[text()='"+departDate+"']"));
        int count = 0;
        for (WebElement TotalRowsLists  : TotalRowsList){
            count++;
        }
        System.out.println("Total number of Rows in the table are : "+ count);
        return count;
    }
    public void ApplyFilter(String departDate,String arriveStation){
        Select selectArriveStation = new Select(this.getArriveStationFilter());
        selectArriveStation.selectByVisibleText(arriveStation);
        this.getDepartDateFilter().sendKeys(departDate);
        this.getBtnFilter().click();
    }

}
