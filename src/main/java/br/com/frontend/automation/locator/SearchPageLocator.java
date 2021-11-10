package br.com.frontend.automation.locator;

public class SearchPageLocator {

    //CSS SELECTOR
    public static final String ITEM_GRID = " span[data-component-type='s-search-results'] > div.s-main-slot.s-result-list.s-search-results";
    public static final String SEARCHED_FIRST_ELEMENT = "div[data-cel-widget='search_result_1']";
    public static final String FIRST_ITEM_PRICE = "div[data-cel-widget='search_result_1'] span.a-price:nth-child(1) > span.a-offscreen";
}