package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindAll( @FindBy(css = "#box_menu .innerbox .standard li a[href]") )
    private List<WebElement> menuCategoriesList;

    public final List<String> menuCategoriesURLs = Collections.unmodifiableList(
        new ArrayList<String>() {{
            for (WebElement element:menuCategoriesList) {
                add(element.getAttribute("href"));
            }
        }});

    public void waitForMenuCategoriesToLoad() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(
                "#box_menu .innerbox .standard li")));
    }

    public CategoryPage goToMenuCategoryByStringUrl(String categoryUrl) {
        driver.get(categoryUrl);
        return new CategoryPage(driver);
    }
}
