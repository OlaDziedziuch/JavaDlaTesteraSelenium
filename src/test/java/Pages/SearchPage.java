package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePageObject {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(className = "button-search")
    WebElement searchButton;


    public void enterSearch(String search) {
        searchField.sendKeys(search);
    }

    public void clickOnSearch() {
        searchButton.click();
    }



}
