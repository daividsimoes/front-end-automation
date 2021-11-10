package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.MainPageLocator;
import br.com.frontend.automation.util.PageUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final String MAIN_PAGE = "https://www.amazon.com/";
    private PageUtil pageUtil;

    @FindBy(xpath = MainPageLocator.SEARCH_INPUT)
    private WebElement searchInputElement;

    @FindBy(xpath = MainPageLocator.SEARCH_SUBMIT_BUTTON)
    private WebElement searchButtonElement;

    @FindBy(xpath = MainPageLocator.CART_MENU)
    private WebElement countCart;

    public MainPage(WebDriver driver, WebDriverWait wait) {

        PageFactory.initElements(driver, this);
        pageUtil = new PageUtil(driver, wait);
    }

    public void openAmazonPage() {

        pageUtil.openPage(MAIN_PAGE);
    }

    public void addSearchText(String text) {

//        searchInputElement = pageUtil.findElementBy(By.xpath(MainPageLocator.SEARCH_INPUT));
        pageUtil.addText(searchInputElement, text);
    }

    //FIXME NEED ADD A CHECK TO VALIDADE IF PAGE WAS LOADED
    public void clickSearchButton() {

//        searchButtonElement = pageUtil.findElementBy(By.xpath(MainPageLocator.SEARCH_SUBMIT_BUTTON));
        pageUtil.waitUntilElementIsClickable(searchButtonElement);
        pageUtil.clickElement(searchButtonElement);
    }

    //FIXME NEED ADD A CHECK TO VALIDADE IF PAGE WAS LOADED
    public void openCart() {

//        countCart = pageUtil.findElementBy(By.xpath(MainPageLocator.CART_MENU));
        pageUtil.clickElement(countCart);
    }
}
