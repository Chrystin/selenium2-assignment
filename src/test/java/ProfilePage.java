import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends PageBase {
    // Requirement: textarea (1 pt)
    private By bioField = By.xpath("//textarea[@name='biography']");
    private By saveBtn = By.id("save-profile");

    public ProfilePage(WebDriver driver) { super(driver); }

    public void updateBio(String bioText) {
        // Requirement: form_with_user (3 pts - action done while logged in)
        driver.findElement(bioField).clear();
        driver.findElement(bioField).sendKeys(bioText);
        driver.findElement(saveBtn).click();
    }
}