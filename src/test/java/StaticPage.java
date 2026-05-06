import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StaticPage extends PageBase {
    private By footerLegalText = By.className("footer-links");

    public StaticPage(WebDriver driver) { super(driver); }

    public boolean isLegalTextPresent() {
        // Requirement: static_page_test (2 pts)
        return driver.findElement(footerLegalText).isDisplayed();
    }
}