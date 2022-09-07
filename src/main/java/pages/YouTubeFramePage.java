package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouTubeFramePage extends BasePage {
    public YouTubeFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.ytp-error .ytp-error-icon-container")
    private WebElement privateVideoError;

    @FindBy(css = "#player .ytp-cued-thumbnail-overlay > button ")
    private WebElement youTubeFramePlayButton;

    public ProductDescriptionPage switchBackToProductPage() {
        switchToDefaultContent();
        return new ProductDescriptionPage(driver);
    }

    public boolean isVideoButtonClickable() {
        try {
            return isDisplayedAndClickable(youTubeFramePlayButton);
        } catch (Exception e) {
            return false;
        }
    }
}
