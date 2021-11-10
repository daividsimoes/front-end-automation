package br.com.frontend.automation.locator;

public class CartLocator {

    //ID AND XPATH
    public static final String ITEM_INFORMATION = "//div[contains(@class, 'a-row sc-list-item')]/div[contains(@class, 'sc-list-item-content')]";
    public static final String BUY_BOX = "sc-buy-box";
    public static final String SUB_TOTAL_ITEMS = "sc-subtotal-label-buybox";
    public static final String SUB_TOTAL_AMOUNT = "sc-subtotal-amount-buybox";
    public static final String SELECT_QUANTITY = "quantity";
}
