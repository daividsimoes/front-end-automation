package br.com.frontend.automation.test.step;

import br.com.frontend.automation.CucumberReport;
import br.com.frontend.automation.driver.ChromeWebDriver;
import br.com.frontend.automation.driver.DriverWait;
import br.com.frontend.automation.enums.GherkinKey;
import br.com.frontend.automation.enums.Message;
import br.com.frontend.automation.page.CartPage;
import br.com.frontend.automation.page.ItemDetailPage;
import br.com.frontend.automation.page.MainPage;
import br.com.frontend.automation.page.SearchPage;
import br.com.frontend.automation.util.StringUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AmazonStepDefinition {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private SearchPage searchPage;
    private ItemDetailPage itemDetailPage;
    private CartPage cartPage;

    private int itemCount;
    private BigDecimal price;

    private CucumberReport report;
    private Scenario scenario;

    @Before
    public void setUp(Scenario testScenario) {

        driver = new ChromeWebDriver().webDriver();
        wait = new DriverWait(driver).webDriverWait();
        mainPage = new MainPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        itemDetailPage = new ItemDetailPage(driver, wait);
        cartPage = new CartPage(driver, wait);

        scenario = testScenario;
        report = new CucumberReport(scenario.getName());
    }

    @After
    public void tearDown(Scenario testScenario) {

        scenario = testScenario;
        report = new CucumberReport(scenario);

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Given("I perform a search for {string}")
    public void i_perform_a_search_for(String search) {

        mainPage.openAmazonPage();
        mainPage.addSearchText(search);
        mainPage.clickSearchButton();

        CucumberReport.report("I perform a search for 'hats for men'");
    }

    @Given("I add the first hat appearing to Cart twice")
    public void i_add_the_first_hat_appearing_to_Cart_twice() {

        itemCount = 2;
        price = searchPage.getFirstItemPrice();
        searchPage.clickFirstSearchedItem();
        itemDetailPage.selectItemQuantity(itemCount);
        itemDetailPage.clickAddCartButton();

        CucumberReport.report("I add the first hat appearing to Cart twice");
    }

    @When("I open the cart")
    public void i_open_the_cart() {

        mainPage.openCart();

        CucumberReport.report("I open the cart");
    }

    @Then("total price and quantity should be correct")
    public void total_price_and_quantity_should_be_correct() {

        String cartItemsText = cartPage.getCartItemsText();
        BigDecimal cartAmount = cartPage.getCartAmount();
        String formattedMessage = StringUtil.normalizeText(Message.CART_SUB_ITEMS.getMessage(), itemCount);

        assertEquals(formattedMessage, cartItemsText);
        assertEquals(price.multiply(new BigDecimal(itemCount)), cartAmount);

        CucumberReport.report("total price and quantity should be correct");
    }

    @Then("total price and quantity should be changed")
    public void total_price_and_quantity_should_be_changed() {

        String cartItemsText = cartPage.getCartItemsText();
        BigDecimal cartAmount = cartPage.getCartAmount();

        assertEquals(Message.CART_SUB_ITEM.getMessage(), cartItemsText);
        assertEquals(price.multiply(new BigDecimal(itemCount)), cartAmount);

        CucumberReport.report("total price and quantity should be changed");
    }

    @But("if I reduce the quantity to {int} item in the Cart")
    public void if_I_reduce_the_quantity_to_item_in_the_Cart(int quantity) {

        itemCount = quantity;
        cartPage.selectItemQuantity(itemCount);

        String reportMessage = StringUtil.normalizeText("if I reduce the quantity to {0} item in the Cart",
                itemCount);
        CucumberReport.report(reportMessage);
    }
}
