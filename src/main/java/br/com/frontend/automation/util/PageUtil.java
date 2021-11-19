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

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        driver.get(url);

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        waitUntilPageIsLoaded();
    }

    public void waitUntilElementIsClickable(WebElement element) {

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilAllElementsVisible(WebElement... element){

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitUntilTextNotBePresentInElement(WebElement element, String text) {

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        waitUntilConditionNotBeValid(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void clickElement(WebElement element) {

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        element.click();
    }

    public void addText(WebElement element, String text) {

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        element.sendKeys(text);
    }

    public Select getDropDownElement(WebElement element) {

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        Select select = new Select(element);

        return select;
    }

    public void selectDropDownElementByValue(Select dropDown, String value) {

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        dropDown.selectByValue(value);
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

        ScreenShotReportUtil.takeScreenShotAndGetMethodName(driver);
        wait.until(ExpectedConditions.not(condition));

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
