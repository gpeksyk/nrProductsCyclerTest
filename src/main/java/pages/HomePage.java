package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className ="js__accept-all-consents")
    private WebElement consentCookiesBtn;

    public void consentCookies() {
        consentCookiesBtn.click();
    }
}
