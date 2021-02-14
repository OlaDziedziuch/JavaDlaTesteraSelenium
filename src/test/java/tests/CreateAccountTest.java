package tests;

import com.github.javafaker.Faker;
import enums.*;
import model.Address;
import model.PersonalInformation;
import pages.*;
import utils.PageTitleUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;


public class CreateAccountTest extends BaseTest {

    protected CreateAccountPage createAccountPage;
    protected TopMenuPage topMenuPage;
    protected CreateAccountFormPage createAccountFormPage;
    protected MyAccountPage myAccountPage;

    Faker faker = new Faker();
    String fakeEmail = faker.name().firstName() + "@wp.pl";
    PersonalInformation personalInformation = new PersonalInformation();
    Address address = new Address();

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        createAccountPage = new CreateAccountPage(driver);
        topMenuPage = new TopMenuPage(driver);
        createAccountFormPage = new CreateAccountFormPage(driver);
        myAccountPage = new MyAccountPage(driver);

        personalInformation.setFirstName("Jane");
        personalInformation.setLastName("Cook");
        personalInformation.setPassword("password");
        personalInformation.setDay(DayOfBirth.EIGHT);
        personalInformation.setMonth(MonthOfBirth.APRIL);
        personalInformation.setYear(YearOfBirth.P1906);

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
        createAccountPage.enterEmail(fakeEmail);
        createAccountPage.clickOnCreateAnAccountButton();

        assertThat(createAccountFormPage.isAccountFormVisible()).isTrue();
    }

    @Test
    @Order(3)
    public void shouldSendCreateAccountFormWithAllFieldsCompleted() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail(fakeEmail);
        createAccountPage.clickOnCreateAnAccountButton();
        createAccountFormPage.clickOnGenderMrsRadio();
        createAccountFormPage.checkNewsletterOption();
        createAccountFormPage.checkSpecialOffersFromPartnersOption();
        createAccountFormPage.sendPersonalInformation(personalInformation);
        createAccountFormPage.sendAddress(address);
        createAccountFormPage.sendRegisterForm();

        assertThat(myAccountPage.isMyAccountIsDisplayed()).isTrue();
    }

    @Test
    @Order(4)
    public void shouldNotAllowSendFormWithEmptyPasswordField() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail(fakeEmail);
        createAccountPage.clickOnCreateAnAccountButton();
        createAccountFormPage.clickOnGenderMrsRadio();
        createAccountFormPage.checkNewsletterOption();
        createAccountFormPage.checkSpecialOffersFromPartnersOption();
        personalInformation.setPassword("  ");
        createAccountFormPage.sendAddress(address);
        createAccountFormPage.sendRegisterForm();

        assertThat(createAccountFormPage.isRedBoxAlertIsDisplayed()).isTrue();
    }

    @Test
    @Order(5)
    public void shouldNotAllowSendFormWithTooShortPostalCodeField() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail(fakeEmail);
        createAccountPage.clickOnCreateAnAccountButton();
        createAccountFormPage.clickOnGenderMrRadio();
        address.setPostalCode("123");
        createAccountFormPage.sendAddress(address);
        createAccountFormPage.sendRegisterForm();

        assertThat(createAccountFormPage.isRedBoxAlertIsDisplayed()).isTrue();
    }

    @Test
    @Order(6)
    public void shouldNotAllowSendFormWithNoChosenStateSelect() {

        topMenuPage.clickOnSignInLink();
        createAccountPage.enterEmail(fakeEmail);
        createAccountPage.clickOnCreateAnAccountButton();
        createAccountFormPage.clickOnGenderMrRadio();
        address.setState(State.NONE);
        createAccountFormPage.sendAddress(address);
        createAccountFormPage.sendRegisterForm();

        assertThat(createAccountFormPage.isRedBoxAlertIsDisplayed()).isTrue();
    }
}
