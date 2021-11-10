package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.SearchPageLocator;
import br.com.frontend.automation.util.StringUtil;
import br.com.frontend.automation.util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class SearchPage {

    private PageUtil pageUtil;
    private String jsCommandTextContent = "return document.querySelector(\"{0}\").textContent";

    public SearchPage(WebDriver driver, WebDriverWait wait) {

        pageUtil = new PageUtil(driver, wait);
    }

    public void clickFirstSearchedItem() {

        WebElement searchedElement = pageUtil.findElementBy(By.cssSelector(SearchPageLocator.SEARCHED_FIRST_ELEMENT));
        pageUtil.clickElement(searchedElement);
        pageUtil.waitUntilPageIsLoaded();
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
