package br.com.frontend.automation.page;

import br.com.frontend.automation.locator.ItemDetailLocator;
import br.com.frontend.automation.util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailPage {

    private PageUtil pageUtil;

    public ItemDetailPage(WebDriver driver, WebDriverWait wait) {

        pageUtil = new PageUtil(driver, wait);
    }

    public void selectItemQuantity(int quantity) {

        WebElement dropDownElement = pageUtil.findElementBy(By.xpath(ItemDetailLocator.SELECT_QUANTITY));
        Select dropDownSelect = pageUtil.getDropDownElement(dropDownElement);
        pageUtil.selectDropDownElementByValue(dropDownSelect, String.valueOf(quantity));
    }

    public void clickAddCartButton() {

        WebElement addCartoButton = pageUtil.findElementBy(By.xpath(ItemDetailLocator.ADD_CART_INPUT_BUTTON));
        pageUtil.clickElement(addCartoButton);
    }
}
