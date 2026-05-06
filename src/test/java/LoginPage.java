import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {
    private By emailField = By.id("username");
    private By loginBtn = By.id("kc-login");
    private By passwordField = By.id("password");

    public LoginPage(WebDriver driver) { super(driver); }

    public void login(String email, String pass) {
        // Advanced: javascript_executor
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", emailInput);
        
        emailInput.sendKeys(email);
        driver.findElement(loginBtn).click();

        // Step 2: Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}