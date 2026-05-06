import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageBase {
    // Basic Task: complex_xpath (using the exact ID you provided)
    private By loginButton = By.id("netacad-login-button");
    private By rejectAllBtn = By.id("onetrust-reject-all-handler");
    private By overlay = By.className("onetrust-pc-dark-filter");

    public MainPage(WebDriver driver) { super(driver); }

    public void denyCookies() {
        try {
            WebElement reject = wait.until(ExpectedConditions.elementToBeClickable(rejectAllBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reject);
            
            // Wait until the dark overlay is GONE before trying to click Login
            wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
            
            // Small pause for the banner's "closing" animation
            Thread.sleep(800); 
        } catch (Exception e) {
            System.out.println("Cookie banner handling skipped.");
        }
    }

    public void clickLogin() {
        try {
            // Wait for the specific button you found
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            
            // Try standard click
            btn.click();
        } catch (Exception e) {
            // Advanced Task: javascript_executor
            // Fallback: If standard click is intercepted, force it with JS
            WebElement btn = driver.findElement(loginButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }
}