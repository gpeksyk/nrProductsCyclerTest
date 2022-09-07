package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindAll( @FindBy(css = "#box_mainproducts .innerbox [data-product-id] .productname") )
    private List<WebElement> categorySpecyficProductsList;

    public ProductDescriptionPage goToProductDescriptionPageByIndex(int index) {
        try {
            click(this.categorySpecyficProductsList.get(index));
            return new ProductDescriptionPage(driver);
        } catch(Exception exception) {
            System.out.println("goToProductDescriptionPageByIndex of " + index +" fired this exception!");
            System.out.println("returning null.");
            return null;
        }
    }

    public int getLastProductIndex() {
        return categorySpecyficProductsList.size()-1;
    }

    public void waitForCategoryPageToLoadProducts() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(
                "#box_mainproducts .innerbox [data-product-id] .productname")));
    }
}
