package Pages;

import Model.Address;
import Model.PersonalInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.NoSuchElementException;


public class CreateAccountFormPage extends BasePageObject {

    public CreateAccountFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "authentication")
    WebElement createAccountFormPage;

    @FindBy(id = "uniform-id_gender1")
    WebElement genderMrRadio;

    @FindBy(id = "uniform-id_gender2")
    WebElement genderMrsRadio;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement dayOfBirth;

    @FindBy(id = "months")
    WebElement monthOfBirth;

    @FindBy(id = "years")
    WebElement yearOfBirth;

    @FindBy(id = "firstname")
    WebElement firstNameAddressField;

    @FindBy(id = "lastname")
    WebElement lastNameAddressField;

    @FindBy(id = "company")
    WebElement companyField;

    @FindBy(id = "address1")
    WebElement obligatoryAddressField;

    @FindBy(id = "address2")
    WebElement nonObligatoryAddressField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "id_state")
    WebElement stateSelect;

    @FindBy(id = "postcode")
    WebElement postalCodeField;

    @FindBy(id = "id_country")
    WebElement countrySelect;

    @FindBy(id = "other")
    WebElement additionalInfoBox;

    @FindBy(id = "phone")
    WebElement homePhoneField;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneField;

    @FindBy(id = "alias")
    WebElement addressAliasField;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(id = "newsletter")
    WebElement newsletterBox;

    @FindBy(id = "optin")
    WebElement specialOffersBox;

    @FindBy(className = "alert-danger")
    WebElement redBoxAlert;


    public boolean isAccountFormVisible() {
        return isAccountFormVisible(createAccountFormPage);

    }

    public boolean isAccountFormVisible(WebElement createAccountFormPage) {
        wait.until(ExpectedConditions.visibilityOf(createAccountFormPage));

        boolean isDisplayed = false;
        try {
            isDisplayed = createAccountFormPage.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;
    }

    public void clickOnGenderMrsRadio() {
        wait.until(ExpectedConditions.visibilityOf(genderMrsRadio));
        genderMrsRadio.click();
    }

    public void clickOnGenderMrRadio() {
        wait.until(ExpectedConditions.visibilityOf(genderMrRadio));
        genderMrRadio.click();
    }

    public void checkNewsletterOption() {
        newsletterBox.click();
    }

    public void checkSpecialOffersFromPartnersOption() {
        specialOffersBox.click();
    }

    public void sendPI(PersonalInformation personalInformation) {

        firstName.sendKeys(personalInformation.getFirstName());
        lastName.sendKeys(personalInformation.getLastName());
        password.sendKeys(personalInformation.getPassword());
        dayOfBirth.sendKeys(personalInformation.getDay().getValue());
        monthOfBirth.sendKeys(personalInformation.getMonth().getValue());
        yearOfBirth.sendKeys(personalInformation.getYear().getValue());
    }

    public void sendAddress(Address address) {

        firstNameAddressField.sendKeys(address.getFirstName());
        lastNameAddressField.sendKeys(address.getLastName());
        companyField.sendKeys(address.getCompany());
        obligatoryAddressField.sendKeys(address.getAddress1());
        nonObligatoryAddressField.sendKeys(address.getAddress2());
        cityField.sendKeys(address.getCity());
        stateSelect.sendKeys(address.getState().getValue());
        postalCodeField.sendKeys(address.getPostalCode());
        countrySelect.sendKeys(address.getCountry().getValue());
        additionalInfoBox.sendKeys(address.getAdditionalInformation());
        homePhoneField.sendKeys(address.getHomePhone());
        monthOfBirth.sendKeys(address.getMobilePhone());
        addressAliasField.sendKeys(address.getAssignAnAddressAliasForFutureReference());

    }

    public void sendRegisterForm() {
        registerButton.click();

    }

    public boolean isRedBoxAlertIsDisplayed() {
        return isBoxDisplayed(redBoxAlert);
    }

    public boolean isBoxDisplayed(WebElement redBoxAlert) {
        wait.until(ExpectedConditions.visibilityOf(redBoxAlert));

        boolean isDisplayed = false;
        try {
            isDisplayed = redBoxAlert.isDisplayed();
        } catch (NoSuchElementException e) {
        }

        return isDisplayed;
    }

}

