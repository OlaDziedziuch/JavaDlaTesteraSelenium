package Tests;

import Pages.PopularItemsPage;
import Utils.PageTitleUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
    }



    @Test
    public void shouldSeePopularItemsOnHomePage() {

        List<String> productNames = popularItemsPage.getProductNames();

       /* List<WebElement> productNamesByXPath = driver.findElements
                (By.xpath(("//*[@id='homefeatured']//*[@class='product-name']")));*/

       /* for (WebElement productName : productNamesByXPath) {
            System.out.println(productName.getText());
        }

        for (WebElement productName : productNamesByCss) {
            System.out.println(productName.getText());
        }*/

        List<String> productWithEmptyName = productNames.stream()
                .filter(String::isEmpty)
                .collect(Collectors.toList());

        Assertions.assertThat(productWithEmptyName).isEmpty();
    }


}
