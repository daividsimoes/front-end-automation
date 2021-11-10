package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.CartLocator;
import br.com.frontend.automation.util.PageUtil;
import br.com.frontend.automation.util.StringUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class CartPage {

    private PageUtil pageUtil;


    @FindBy(id = CartLocator.SELECT_QUANTITY)
    private WebElement dropDownElement;

    @FindBy(id = CartLocator.SUB_TOTAL_ITEMS)
    private WebElement subTotalItem;

    @FindBy(id = CartLocator.SUB_TOTAL_AMOUNT)
    private WebElement subTotalAmount;

    public CartPage(WebDriver driver, WebDriverWait wait) {

        PageFactory.initElements(driver, this);
        pageUtil = new PageUtil(driver, wait);
    }

    public String getCartItemsText() {

        return subTotalItem.getText();
    }

    public BigDecimal getCartAmount() {

        return StringUtil.normalizePriceValue(subTotalAmount.getText());
    }

    public void selectItemQuantity(int quantity) {

//        dropDownElement = pageUtil.findElementBy(By.id(CartLocator.SELECT_QUANTITY));
        Select dropDownSelect = pageUtil.getDropDownElement(dropDownElement);
        pageUtil.selectDropDownElementByValue(dropDownSelect, String.valueOf(quantity));
    }
}
