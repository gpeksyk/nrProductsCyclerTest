package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class ProductDescriptionPage extends BasePage {
    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @FindAll( @FindBy(css = ".video-responsive iframe") )
    private List<WebElement> youTubeIFramesList;

    public boolean isYouTubeFrameDisplayed() {
        try {
            return isDisplayed(youTubeIFramesList.get(0));
        } catch (Exception e) {
            return false;
        }
    }

    public CategoryPage getBackToPreviousPage() {
        driver.navigate().back();
        return new CategoryPage(driver);
    }

    public YouTubeFramePage switchToYTFrameByIndex(int index) {
        actions.moveToElement(youTubeIFramesList.get(index)).perform();
        switchToFrame(youTubeIFramesList.get(index));
        return new YouTubeFramePage(driver);
    }

    public int getYouTubeFramesCount() {
        return youTubeIFramesList.size();
    }
}
