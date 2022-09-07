package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    public WebDriver        driver;
    public WebDriverWait    wait;
    public Actions          actions;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver =   driver;
        wait =          new WebDriverWait(driver, Duration.ofSeconds(5L));
        actions =       new Actions(driver);
    }

    public void waitToBeVisibleAndClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element).perform();
        }  catch (Exception e) {
            System.out.println("Exception fired at waitToBeVisibleAndClickable method for" + element.getText() +
                    "\nvalue: " + element);
        }
    }

    public void click(WebElement element) {
        waitToBeVisibleAndClickable(element);
        try {
            actions.moveToElement(element).perform();
            element.click();
        } catch (Exception e){
            System.out.println("NoSuchElementException fired from click method at element: " + element.getText() +
                    "\nvalue: " + element);
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            actions.moveToElement(element).perform();
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("No such element exception fired from isDisplayed method for" + element.getText() +
                    "\n value: " + element);
            return false;
        }
    }

    public boolean isDisplayedAndClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element).perform();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("No such element exception fired from isDisplayed method for" + element.getText() +
                    "\nvalue: " + element);
            return false;
        }
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
