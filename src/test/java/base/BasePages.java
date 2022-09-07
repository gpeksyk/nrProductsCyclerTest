package base;

import org.testng.annotations.BeforeMethod;
import pages.*;

public class BasePages extends BaseTest {
    public HomePage homePage;
    public MenuPage menuPage;
    public CategoryPage categoryPage;
    public ProductDescriptionPage productDescriptionPage;
    public YouTubeFramePage youTubeFramePage;

    @BeforeMethod
    public void testSetup() {
        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
        categoryPage = new CategoryPage(driver);
        productDescriptionPage = new ProductDescriptionPage(driver);
        youTubeFramePage = new YouTubeFramePage(driver);
    }
}
