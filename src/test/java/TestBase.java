import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class TestBase {
    protected ChromeDriver driver;

    public void startBrowser() {
      WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
    
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        // Ensure this is definitely commented out:
        // options.addArguments("--headless=new"); 

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
        // Add this to catch issues early
        System.out.println("Browser started successfully.");
    }

    public void stopBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}