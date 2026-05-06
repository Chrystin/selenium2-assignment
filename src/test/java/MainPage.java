import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends PageBase {
    
    // 1. Locators
    private By loginButton = By.id("netacad-login-button");
    private By rejectAllBtn = By.id("onetrust-reject-all-handler");
    private By overlay = By.className("onetrust-pc-dark-filter");
    private By modalContent = By.className("modal__content");
    private By termsLabel = By.xpath("//label[contains(., 'I have read and agreed to the terms')]");
    private By acceptButton = By.xpath("//button[text()='Accept & Continue']");

    // 2. Constructor - THIS is where the cleanup belongs
    public MainPage(WebDriver driver) { 
        super(driver); 
        // Force a fresh session every time this page is initialized
        try {
            ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
            ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
            driver.manage().deleteAllCookies();
            System.out.println("Browser cache and cookies cleared for a fresh run.");
        } catch (Exception e) {
            System.out.println("Could not clear storage: " + e.getMessage());
        }
    }

    public void denyCookies() {
        try {
            WebElement reject = wait.until(ExpectedConditions.elementToBeClickable(rejectAllBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reject);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
            Thread.sleep(800); 
        } catch (Exception e) {
            System.out.println("Cookie banner skipped.");
        }
    }

    public void clickLogin() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            btn.click();
        } catch (Exception e) {
            WebElement btn = driver.findElement(loginButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }

    public void acceptTermsIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            System.out.println("Checking if Terms & Conditions modal is present...");
            
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(modalContent));
            System.out.println("Modal found! Clearing it now...");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                "var check = document.querySelector('input[type=\"checkbox\"]');" +
                "if(check) { check.checked = true; check.dispatchEvent(new Event('change')); }" +
                "var btn = Array.from(document.querySelectorAll('button')).find(b => b.textContent.includes('Accept'));" +
                "if(btn) { btn.disabled = false; btn.click(); }"
            );
        } catch (Exception e) {
            System.out.println("No modal appeared. Proceeding...");
        }
    }
}