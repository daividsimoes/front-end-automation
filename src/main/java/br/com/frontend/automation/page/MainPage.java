package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.CartLocator;
import br.com.frontend.automation.locator.MainPageLocator;
import br.com.frontend.automation.locator.SearchPageLocator;
import br.com.frontend.automation.util.PageUtil;
import io.cucumber.java.Scenario;
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

    @FindBy(css = SearchPageLocator.ITEM_GRID)
    private WebElement itemGrid;

    @FindBy(xpath = CartLocator.ITEM_INFORMATION)
    private WebElement itemInformation;

    @FindBy(id = CartLocator.BUY_BOX)
    private WebElement buyBox;

    public MainPage(WebDriver driver, WebDriverWait wait)  {

        PageFactory.initElements(driver, this);
        pageUtil = new PageUtil(driver, wait);
    }

    public void openAmazonPage() {

        pageUtil.openPage(MAIN_PAGE);
    }

    public void addSearchText(String text) {

        pageUtil.addText(searchInputElement, text);
    }

    public void clickSearchButton() {

        pageUtil.waitUntilElementIsClickable(searchButtonElement);
        pageUtil.clickElement(searchButtonElement);
        pageUtil.waitUntilAllElementsVisible(itemGrid);
    }

    public void openCart() {

        pageUtil.clickElement(countCart);
        pageUtil.waitUntilAllElementsVisible(itemInformation, buyBox);
    }
}
