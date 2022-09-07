package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class BaseTest {
    public WebDriver driver;

    @BeforeSuite
    public void setUpDriver() {
        System.out.println("\n Setting up Chrome driver...");
        System.out.println("===============================");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://neorobot.pl/");
    }

    @AfterSuite
    public void tearDownDriver() {
        driver.manage().deleteAllCookies();
        System.out.println("===============================");
        System.out.println(" Tearing down the driver...\n");
        driver.quit();
    }
}
