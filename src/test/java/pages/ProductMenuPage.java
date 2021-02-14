package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductMenuPage extends BasePageObject {

    public ProductMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Women")
    WebElement WomenLink;

    public void clickOnWomenLink() {
        WomenLink.click();
    }
}
