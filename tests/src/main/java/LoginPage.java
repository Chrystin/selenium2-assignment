import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators - Using 'private' follows Grade 4/5 encapsulation standards
    private By emailField = By.id("id-for-email"); // Inspect Netacad for the real ID
    private By nextButton = By.id("next-btn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }
}