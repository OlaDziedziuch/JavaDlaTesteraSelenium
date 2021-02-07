package Tests;

import Enums.*;
import Model.Address;
import Model.PersonalInformation;
import Pages.*;
import Utils.PageTitleUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;


public class CreateAccountTest extends BaseTest {

    protected CreateAccountPage createAccountPage;
    protected TopMenuPage topMenuPage;
    protected CreateAccountFormPage createAccountFormPage;
    protected MyAccountPage myAccountPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        createAccountPage = new CreateAccountPage(driver);
        topMenuPage = new TopMenuPage(driver);
        createAccountFormPage = new CreateAccountFormPage(driver);
        myAccountPage = new MyAccountPage(driver);

    }

    @Test
    @Order(1)
    public void shouldNotAllowCreateAnAccountWithEmptyEmailField() {
        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail(" ");
        createAccountPage.clickOnCreateAnAccountButton();

        assertThat(createAccountPage.isRedBoxAlertIsDisplayed()).isTrue();
    }

    @Test
    @Order(2)
    public void shouldAllowToCreateAnAccount() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail("bartek@wp.pl");
        createAccountPage.clickOnCreateAnAccountButton();

        assertThat(createAccountFormPage.isAccountFormVisible()).isTrue();
    }

    @Test
    @Order(3)
    public void shouldSendCreateAccountFormWithAllFieldsCompleted() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail("grzegorz@wp.pl");
        createAccountPage.clickOnCreateAnAccountButton();

        createAccountFormPage.clickOnGenderMrsRadio();
        createAccountFormPage.checkNewsletterOption();
        createAccountFormPage.checkSpecialOffersFromPartnersOption();

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setFirstName("Jane");
        personalInformation.setLastName("Cook");
        personalInformation.setPassword("password");
        personalInformation.setDay(DayOfBirth.EIGHT);
        personalInformation.setMonth(MonthOfBirth.APRIL);
        personalInformation.setYear(YearOfBirth.P1906);
        createAccountFormPage.sendPI(personalInformation);

        Address address = new Address();
        address.setFirstName("Carla");
        address.setLastName("Carlos");
        address.setCompany("IBM");
        address.setAddress1("123 st");
        address.setAddress2("New Jersey");
        address.setCity("New Jersey");
        address.setState(State.NEW_JERSEY);
        address.setPostalCode("00000");
        address.setCountry(Country.UNITED_STATES);
        address.setAdditionalInformation("I love you");
        address.setHomePhone("123456");
        address.setMobilePhone("87654131");
        address.setAssignAnAddressAliasForFutureReference("My address");
        createAccountFormPage.sendAddress(address);
        createAccountFormPage.sendRegisterForm();

        assertThat(myAccountPage.isMyAccountIsDisplayed()).isTrue();
    }

    @Test
    @Order(4)
    public void shouldNotAllowSendFormWithEmptyPasswordField() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail("janek@wp.pl");
        createAccountPage.clickOnCreateAnAccountButton();

        createAccountFormPage.clickOnGenderMrsRadio();
        createAccountFormPage.checkNewsletterOption();
        createAccountFormPage.checkSpecialOffersFromPartnersOption();

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setFirstName("John");
        personalInformation.setLastName("Lane");
        personalInformation.setPassword("  ");

        personalInformation.setDay(DayOfBirth.FIFTEEN);
        personalInformation.setMonth(MonthOfBirth.SEPTEMBER);
        personalInformation.setYear(YearOfBirth.P1989);
        createAccountFormPage.sendPI(personalInformation);

        Address address = new Address();
        address.setFirstName("John");
        address.setLastName("Lane");
        address.setCompany("Google Inc.");
        address.setAddress1("23456 st");
        address.setAddress2("Washington");
        address.setCity("Washington");
        address.setState(State.WASHINGTON);
        address.setPostalCode("00000");
        address.setCountry(Country.UNITED_STATES);
        address.setAdditionalInformation("I like you");
        address.setHomePhone("123456");
        address.setMobilePhone("87654131");
        address.setAssignAnAddressAliasForFutureReference(" ");
        createAccountFormPage.sendAddress(address);
        createAccountFormPage.sendRegisterForm();

        assertThat(createAccountFormPage.isRedBoxAlertIsDisplayed()).isTrue();
    }

    @Test
    @Order(5)
    public void shouldNotAllowSendFormWithTooShortPostalCodeField() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail("jarek@wp.pl");
        createAccountPage.clickOnCreateAnAccountButton();
        createAccountFormPage.clickOnGenderMrRadio();

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setFirstName("John");
        personalInformation.setLastName("Lane");
        personalInformation.setPassword("password123");

        personalInformation.setDay(DayOfBirth.FIFTEEN);
        personalInformation.setMonth(MonthOfBirth.SEPTEMBER);
        personalInformation.setYear(YearOfBirth.P1989);
        createAccountFormPage.sendPI(personalInformation);

        Address address = new Address();
        address.setFirstName("John");
        address.setLastName("Lane");
        address.setCompany("Google Inc.");
        address.setAddress1("23456 st");
        address.setAddress2("Washington");
        address.setCity("Washington");
        address.setState(State.WASHINGTON);
        address.setPostalCode("123");
        address.setCountry(Country.UNITED_STATES);
        address.setAdditionalInformation("I hate you");
        address.setHomePhone("123456");
        address.setMobilePhone("87654131");
        address.setAssignAnAddressAliasForFutureReference("Yes");
        createAccountFormPage.sendAddress(address);
        createAccountFormPage.sendRegisterForm();

        assertThat(createAccountFormPage.isRedBoxAlertIsDisplayed()).isTrue();
    }

    @Test
    @Order(6)
    public void shouldNotAllowSendFormWithNoChosenStateSelect() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail("karol@wp.pl");
        createAccountPage.clickOnCreateAnAccountButton();
        createAccountFormPage.clickOnGenderMrRadio();

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setFirstName("Jerry");
        personalInformation.setLastName("Tom");
        personalInformation.setPassword("password123");

        personalInformation.setDay(DayOfBirth.FIFTEEN);
        personalInformation.setMonth(MonthOfBirth.SEPTEMBER);
        personalInformation.setYear(YearOfBirth.P1989);
        createAccountFormPage.sendPI(personalInformation);

        Address address = new Address();
        address.setFirstName("John");
        address.setLastName("Lane");
        address.setCompany("Google Inc.");
        address.setAddress1("23456 st");
        address.setAddress2("Washington");
        address.setCity("Washington");
        address.setState(State.NONE);
        address.setPostalCode("12345");
        address.setCountry(Country.UNITED_STATES);
        address.setAdditionalInformation("OK. It wasn't me");
        address.setHomePhone("123456");
        address.setMobilePhone("87654131");
        address.setAssignAnAddressAliasForFutureReference(" ");
        createAccountFormPage.sendAddress(address);
        createAccountFormPage.sendRegisterForm();

        assertThat(createAccountFormPage.isRedBoxAlertIsDisplayed()).isTrue();

    }

}
