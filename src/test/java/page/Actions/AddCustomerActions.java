package page.Actions;

import core.BasePage;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.UI.AddCustomerUI;
import page.UI.ReadDataFromExcel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddCustomerActions extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public AddCustomerActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Click to drop list Menu at Index Page, then click on Add Customer option to switch to Add Customer Page
    public void clickToAddCustomer(){
        clickToElement(driver, AddCustomerUI.MENU_DROP_LIST);
        clickToElement(driver, AddCustomerUI.ADD_CUSTOMER);
    }

    public void clickToSubMit(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement btnSubmit = getElement(driver, AddCustomerUI.BTN_SUBMIT);
        executor.executeScript("arguments[0].click()", btnSubmit);
    }

    //Close System Alert when fields information are empty
    public void closeAlert(){
        driver.switchTo().alert().accept();
    }

    //Click on Radio Background Check
    public void clickBackGroundCheck(String testCase){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement radioDone = getElement(driver, AddCustomerUI.BTN_DONE);
        WebElement radioPending = getElement(driver, AddCustomerUI.BTN_PENDING);
        String radioOption = ReadDataFromExcel.getCellData(ReadDataFromExcel.getRowByTestCaseID(testCase), ReadDataFromExcel.getCol(AddCustomerUI.backGroundCheck));
        if(radioOption.equals("Done")){
            executor.executeScript("arguments[0].click()", radioDone);
        }
        else {
            executor.executeScript("arguments[0].click()", radioPending);
        }
    }

    public void clickToReset(){
        clickToElement(driver, AddCustomerUI.BTN_RESET);
    }

    //Read data from excel file, then sendkeys informations to webpage
    public void readData(String testCase){
        String firstName = ReadDataFromExcel.getCellData(ReadDataFromExcel.getRowByTestCaseID(testCase), ReadDataFromExcel.getCol(AddCustomerUI.colFName));
        sendKeysToElement(driver, AddCustomerUI.TXT_FIRSTNAME, firstName);
        String lastName = ReadDataFromExcel.getCellData(ReadDataFromExcel.getRowByTestCaseID(testCase), ReadDataFromExcel.getCol(AddCustomerUI.colLName));
        sendKeysToElement(driver, AddCustomerUI.TXT_LASTNAME, lastName);
        String email = ReadDataFromExcel.getCellData(ReadDataFromExcel.getRowByTestCaseID(testCase), ReadDataFromExcel.getCol(AddCustomerUI.colEmail));
        sendKeysToElement(driver, AddCustomerUI.TXT_EMAIL, email);
        String address = ReadDataFromExcel.getCellData(ReadDataFromExcel.getRowByTestCaseID(testCase), ReadDataFromExcel.getCol(AddCustomerUI.colAddress));
        sendKeysToElement(driver, AddCustomerUI.TXT_ADDRESS, address);
        String mobileNo = ReadDataFromExcel.getCellData(ReadDataFromExcel.getRowByTestCaseID(testCase), ReadDataFromExcel.getCol(AddCustomerUI.colMobileNo));
        sendKeysToElement(driver, AddCustomerUI.TXT_PHONENO, mobileNo);
    }

    //Verify Actual result and Expected result after run test case
    public void assertMessage(String testCase){
        String xpathMessage = ReadDataFromExcel.getCellData(ReadDataFromExcel.getRowByTestCaseID(testCase), ReadDataFromExcel.getCol(AddCustomerUI.colXpathMessage));
        String actualMessage = getTextOfElement(driver, xpathMessage);
        String expectedMessage = ReadDataFromExcel.getCellData(ReadDataFromExcel.getRowByTestCaseID(testCase), ReadDataFromExcel.getCol(AddCustomerUI.colExpectedMessage));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
