package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.CartLocator;
import br.com.frontend.automation.locator.ItemDetailLocator;
import br.com.frontend.automation.util.StringUtil;
import br.com.frontend.automation.util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class CartPage {

    private PageUtil pageUtil;

    public CartPage(WebDriver driver, WebDriverWait wait) {

        pageUtil = new PageUtil(driver, wait);
    }

    public String getCartItemsText() {

        return pageUtil.findElementBy(By.id(CartLocator.SUB_TOTAL_ITEMS)).getText();
    }

    public BigDecimal getCartAmount() {

        return StringUtil.normalizePriceValue(
                pageUtil.findElementBy(By.id(CartLocator.SUB_TOTAL_AMOUNT)).getText()
        );
    }

    public void selectItemQuantity(int quantity) {

        WebElement dropDownElement = pageUtil.findElementBy(By.id(CartLocator.SELECT_QUANTITY));
        Select dropDownSelect = pageUtil.getDropDownElement(dropDownElement);
        pageUtil.selectDropDownElementByValue(dropDownSelect, String.valueOf(quantity));
    }
}
