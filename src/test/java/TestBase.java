import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class TestBase {
    protected ChromeDriver driver;

    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        
        // Advanced: webdriver_config & headless_execution
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        // options.addArguments("--headless=new"); // Uncomment for headless

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void stopBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}