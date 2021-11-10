package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.MainPageLocator;
import br.com.frontend.automation.util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final String MAIN_PAGE = "https://www.amazon.com/";
    private PageUtil pageUtil;

    public MainPage(WebDriver driver, WebDriverWait wait) {

        pageUtil = new PageUtil(driver, wait);
    }

    public void openAmazonPage() {

        pageUtil.openPage(MAIN_PAGE);
    }

    public void addSearchText(String text) {

        WebElement searchInputElement = pageUtil.findElementBy(By.xpath(MainPageLocator.SEARCH_INPUT));
        pageUtil.addText(searchInputElement, text);
    }

    public void clickSearchButton() {

        WebElement searchButtonElement = pageUtil.findElementBy(By.xpath(MainPageLocator.SEARCH_SUBMIT_BUTTON));
        pageUtil.waitUntilElementIsClickable(searchButtonElement);
        pageUtil.clickElement(searchButtonElement);
        pageUtil.waitUntilPageIsLoaded();
    }

    public void openCart() {

        WebElement countCart = pageUtil.findElementBy(By.xpath(MainPageLocator.CART_MENU));
        pageUtil.clickElement(countCart);
    }

    public void validateCartItemCount(int count) {



    }
}
