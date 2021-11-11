package br.com.frontend.automation.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageUtil(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void openPage(String url) {

        driver.get(url);
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);

        waitUntilPageIsLoaded();
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
    }

    public void waitUntilElementIsClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
    }

    public void waitUntilAllElementsVisible(WebElement... element){

        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
    }

    public void waitUntilTextNotBePresentInElement(WebElement element, String text) {

        waitUntilConditionNotBeValid(ExpectedConditions.textToBePresentInElement(element, text));
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
    }

    public void clickElement(WebElement element) {

        element.click();
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
    }

    public void addText(WebElement element, String text) {

        element.sendKeys(text);
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
    }

    public Select getDropDownElement(WebElement element) {

        Select select = new Select(element);
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);

        return select;
    }

    public void selectDropDownElementByValue(Select dropDown, String value) {

        dropDown.selectByValue(value);
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
    }

    public void waitUntilPageIsLoaded() {

        wait.until(webDriver ->
                executeJsCommand("return document.readyState")
                        .equals("complete")
        );
    }

    public Object executeJsCommand(String command) {
        return ((JavascriptExecutor) driver)
                .executeScript(command);
    }

    private void waitUntilConditionNotBeValid(ExpectedCondition<?> condition) {

        wait.until(ExpectedConditions.not(condition));
        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
    }

//    Changed to use PageFactory instead of this method
//    public WebElement findElementBy(By locator) {
//
//        WebElement element = driver.findElement(locator);
//        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
//
//        return element;
//    }
}
