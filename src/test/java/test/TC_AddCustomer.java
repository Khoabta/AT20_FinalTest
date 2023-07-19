package test;

import core.BaseTest;
import org.testng.annotations.*;
import page.Actions.AddCustomerActions;
import page.UI.ReadDataFromExcel;

import java.io.IOException;

public class TC_AddCustomer extends BaseTest {
    public AddCustomerActions addCustomerActions;

    @BeforeClass
    public void callDriver() throws IOException {
        addCustomerActions = new AddCustomerActions(driver, wait);
        String path = System.getProperty("user.dir");
        ReadDataFromExcel.setExcelFile(path + "/testdata/AddCustomer.xlsx", "Sheet1");
    }

    @BeforeMethod
    //After test case, browser will refresh URL again to start a new test case
    public void refreshIndexPage(){
        driver.get(BaseURL);
    }

    //@Test
    public void switchToAddCustomerPage() throws InterruptedException {
        addCustomerActions.clickToAddCustomer();
    }

    @Test
    //Empty All Field
    public void TC01(){
        String testCase = "TC01";
        addCustomerActions.clickToAddCustomer();
        addCustomerActions.clickToSubMit();
        addCustomerActions.closeAlert();
    }

    @Test
    //Full Information - Adding Customer successfull
    public void TC02() throws InterruptedException, IOException {
        String testCase = "TC02";
        addCustomerActions.clickToAddCustomer();
        addCustomerActions.clickBackGroundCheck(testCase);
        addCustomerActions.readData(testCase);
        addCustomerActions.clickToSubMit();
        addCustomerActions.assertMessage(testCase);
    }

    @Test
    //Empty FirstName
    public void TC03() throws InterruptedException {
        String testCase = "TC03";
        addCustomerActions.clickToAddCustomer();
        addCustomerActions.clickBackGroundCheck(testCase);
        addCustomerActions.readData(testCase);
        addCustomerActions.clickToSubMit();
        addCustomerActions.closeAlert();
        addCustomerActions.assertMessage(testCase);
    }

    @Test
    //Input FirstName with special characters
    public void TC04() throws InterruptedException {
        String testCase = "TC04";
        addCustomerActions.clickToAddCustomer();
        addCustomerActions.clickBackGroundCheck(testCase);
        addCustomerActions.readData(testCase);
        addCustomerActions.clickToSubMit();
        addCustomerActions.closeAlert();
        addCustomerActions.assertMessage(testCase);
    }

    @Test
    //Empty LastName
    public void TC05() throws InterruptedException {
        String testCase = "TC05";
        addCustomerActions.clickToAddCustomer();
        addCustomerActions.clickBackGroundCheck(testCase);
        addCustomerActions.readData(testCase);
        addCustomerActions.clickToSubMit();
        addCustomerActions.closeAlert();
        addCustomerActions.assertMessage(testCase);
    }

    @Test
    //Input an invalid email
    public void TC08() throws InterruptedException {
        String testCase = "TC08";
        addCustomerActions.clickToAddCustomer();
        addCustomerActions.clickBackGroundCheck(testCase);
        addCustomerActions.readData(testCase);
        addCustomerActions.clickToSubMit();
        addCustomerActions.assertMessage(testCase);
    }

    @Test
    //Input an email with @ character before @domain name
    public void TC09() throws InterruptedException {
        String testCase = "TC09";
        addCustomerActions.clickToAddCustomer();
        addCustomerActions.clickBackGroundCheck(testCase);
        addCustomerActions.readData(testCase);
        addCustomerActions.clickToSubMit();
        addCustomerActions.assertMessage(testCase);
    }

    @Test
    //Input an email with other special character before @domain name (not @ character)
    public void TC10() throws InterruptedException {
        String testCase = "TC10";
        addCustomerActions.clickToAddCustomer();
        addCustomerActions.clickBackGroundCheck(testCase);
        addCustomerActions.readData(testCase);
        addCustomerActions.clickToSubMit();
        addCustomerActions.assertMessage(testCase);
    }
}
