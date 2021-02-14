package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends BasePageObject {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement emailBox;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;

    @FindBy(id = "create_account_error")
    WebElement redBoxAccountAlert;

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailBox));
        emailBox.sendKeys(email);
    }

    public void clickOnCreateAnAccountButton() {
        createAnAccountButton.click();
    }

    public boolean isRedBoxAlertIsDisplayed() {
        return isBoxDisplayed(redBoxAccountAlert);
    }

    public boolean isBoxDisplayed(WebElement redBoxAccountAlert) {
        wait.until(ExpectedConditions.visibilityOf(redBoxAccountAlert));

        boolean isDisplayed = false;
        try {
            isDisplayed = redBoxAccountAlert.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;
    }
}
