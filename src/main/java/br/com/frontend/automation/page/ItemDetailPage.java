package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.ItemDetailLocator;
import br.com.frontend.automation.util.PageUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailPage {

    private PageUtil pageUtil;

    @FindBy(css = ItemDetailLocator.SELECT_QUANTITY)
    private WebElement dropDownElement;

    @FindBy(css = ItemDetailLocator.ADD_CART_INPUT_BUTTON)
    private WebElement addCartoButton;

    public ItemDetailPage(WebDriver driver, WebDriverWait wait) {

        PageFactory.initElements(driver, this);
        pageUtil = new PageUtil(driver, wait);
    }

    public void selectItemQuantity(int quantity) {

        Select dropDownSelect = pageUtil.getDropDownElement(dropDownElement);
        pageUtil.selectDropDownElementByValue(dropDownSelect, String.valueOf(quantity));
    }

    public void clickAddCartButton() {

        pageUtil.clickElement(addCartoButton);
    }
}
