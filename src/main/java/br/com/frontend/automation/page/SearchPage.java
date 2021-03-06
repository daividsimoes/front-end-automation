package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.ItemDetailLocator;
import br.com.frontend.automation.locator.SearchPageLocator;
import br.com.frontend.automation.util.PageUtil;
import br.com.frontend.automation.util.StringUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class SearchPage {

    private PageUtil pageUtil;
    private String jsCommandTextContent = "return document.querySelector(\"{0}\").textContent";

    @FindBy(css = SearchPageLocator.SEARCHED_FIRST_ELEMENT)
    private WebElement searchedElement;

    @FindBy(css = ItemDetailLocator.BOX_ITEM_INFORMATION)
    private WebElement boxItemInformation;

    public SearchPage(WebDriver driver, WebDriverWait wait) {

        PageFactory.initElements(driver, this);
        pageUtil = new PageUtil(driver, wait);
    }

    public void clickFirstSearchedItem() {

        pageUtil.clickElement(searchedElement);
        pageUtil.waitUntilAllElementsVisible(boxItemInformation);
    }

    public BigDecimal getFirstItemPrice() {

        String formattedJsCommand = StringUtil.normalizeText(
                jsCommandTextContent, SearchPageLocator.FIRST_ITEM_PRICE
        );

        return StringUtil.normalizePriceValue(
                pageUtil.executeJsCommand(formattedJsCommand).toString()
        );
    }
}
