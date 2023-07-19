package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriverWait wait;
    int TIME_UNIT = 30;
    public By getElementByXPath(String locator){
        return By.xpath(locator);
    }
    public WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(getElementByXPath(locator));
    }
    public void sendKeysToElement(WebDriver driver, String locator, String value){
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }
    public void clickToElement(WebDriver driver, String locator){
        getElement(driver, locator).click();
    }
    public void explicitWait(WebDriver driver, String locator){
        wait = new WebDriverWait(driver, TIME_UNIT);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        wait.until(ExpectedConditions.elementToBeClickable(getElement(driver, locator)));
    }
    public String getTextOfElement(WebDriver driver, String locator){
        return getElement(driver, locator).getText();
    }
    public boolean checkElementIsSelected(WebDriver driver, String locator){
        return getElement(driver, locator).isSelected();
    }

}
