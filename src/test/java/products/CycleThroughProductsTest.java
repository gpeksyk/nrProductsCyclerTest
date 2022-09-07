package products;

import base.BasePages;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CycleThroughProductsTest extends BasePages {

    SoftAssert softassert = new SoftAssert();

    @Test(priority = 0, description="Cycle through all products and check for youtube videos availability scenario")
    public void checkIfAllVideosAreDisplayedAndClickable() {

        homePage.consentCookies();
        menuPage.waitForMenuCategoriesToLoad();

        for (String categoryUrl: menuPage.menuCategoriesURLs) {

            menuPage.goToMenuCategoryByStringUrl(categoryUrl)
                    .waitForCategoryPageToLoadProducts();

            int categoryPageSize = categoryPage.getLastProductIndex();
            // For each product in the category page...
            for (int productIndex = 0; productIndex <= categoryPageSize; productIndex++) {
                // ...go to it's description page and check is there any YT video...
                categoryPage.goToProductDescriptionPageByIndex(productIndex);
                if (productDescriptionPage.isYouTubeFrameDisplayed()) {
                        int videosCount = productDescriptionPage.getYouTubeFramesCount();
                        // for each iframe with YT video found...
                        for (int frameIndex = 0; frameIndex < videosCount; frameIndex++) {
                            // switch to that frame and check is the video available to play.
                            productDescriptionPage.switchToYTFrameByIndex(frameIndex);
                            softassert.assertEquals(youTubeFramePage.isVideoButtonClickable(), true,
                                    "Video number " + (frameIndex+1) +
                                            " not playable in product page url: " + driver.getCurrentUrl());
                            youTubeFramePage.switchBackToProductPage();
                        }
                    }
                productDescriptionPage.getBackToPreviousPage().waitForCategoryPageToLoadProducts();
            }
        }
        // Check if all videos found were available to play.
        softassert.assertAll();
    }
}
