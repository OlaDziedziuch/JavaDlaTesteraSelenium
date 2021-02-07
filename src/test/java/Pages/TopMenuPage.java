package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



// wyszukiwanie - blouse - oijawi sie jeden element ktoey istnieje i spradzenie tytuli uveny
// sigin - nowe onto - formularz jako dwa obiekty


public class TopMenuPage extends BasePageObject {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(className = "login")
    WebElement signInLink;

    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }




}
