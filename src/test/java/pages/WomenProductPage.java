package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WomenProductPage extends BasePageObject {

    public WomenProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-price")
    List<WebElement> productPrices;

    @FindBy(className = "product-count")
    WebElement productCount;

    @FindBy(className = "product-name")
    WebElement productName;

    @FindBy(linkText = "Blouse")
    WebElement productPrice;

    public List<String> getProductPrice() {
        return productPrices.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    public String shouldReturnProductName() {
        return productName.getText();
    }

    public String shouldReturnProductPrice() {
        return productPrice.getText();
    }

    public boolean isBlouseCountIsDisplayed() {
        return isProductCountIsDisplayed(productCount);
    }

    public boolean isProductCountIsDisplayed(WebElement productCount) {
        wait.until(ExpectedConditions.visibilityOf(productCount));

        boolean isDisplayed = false;
        try {
            isDisplayed = productCount.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;

    }
}






