package tests;

import pages.ProductMenuPage;
import pages.SearchPage;
import pages.WomenProductPage;
import utils.PageTitleUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WomenProductTest extends BaseTest {

    protected ProductMenuPage productMenuPage;
    protected WomenProductPage womenProductPage;
    protected SearchPage searchPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        productMenuPage = new ProductMenuPage(driver);
        womenProductPage = new WomenProductPage(driver);
        searchPage = new SearchPage(driver);
    }

    /* Test scenario:
     1. Create setUp driver.
     2. Click on "Women" link.
     3. Take all product prices and save it in a list - "productPrices".
     4. Create a new list from previous list and filter prices above 0E - "productPriceAbove0Euro"
     5. Check an assertion if  "productPriceAbove0Euro" list is empty.
     */

    @Test
    public void shouldDisplayAllProductsWithPriceAbove0Euro() {

        productMenuPage.clickOnWomenLink();
        List<String> productPrices = womenProductPage.getProductPrice();
        List<String> productPriceAbove0Euro = productPrices.stream()
                .filter(el -> el.equals("$00.00"))
                .collect(Collectors.toList());

        Assertions.assertThat((productPriceAbove0Euro).isEmpty()).isTrue();

    }

     /* Test scenario:
     1. Create setUp driver.
     2. Enter "blouse" on search field.
     3. Click on search button.
     4. Check the result for the product name - "Blouse.
     5. Check the result for the product price - "$27.00".
     6. Check an assertion isBlouseCount is displayed.
     */

    @Test
    public void shouldReturnResultsForSearchBlouse() {

        searchPage.enterSearch("blouse");
        searchPage.clickOnSearch();
        womenProductPage.shouldReturnProductName().equals("Blouse");
        womenProductPage.shouldReturnProductPrice().equals("$27.00");

        Assertions.assertThat(womenProductPage.isBlouseCountIsDisplayed()).isTrue();
    }
}
