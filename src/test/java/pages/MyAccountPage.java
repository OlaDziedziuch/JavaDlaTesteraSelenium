package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePageObject {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "my-account")
    WebElement myAccount;

    public boolean isMyAccountIsDisplayed() {
        return isDisplayMyAccount(myAccount);
    }

    public boolean isDisplayMyAccount(WebElement myAccount) {
        wait.until(ExpectedConditions.visibilityOf(myAccount));

        boolean isDisplayed = false;
        try {
            isDisplayed = myAccount.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;
    }
}
