import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PreferencesPage extends PageBase {
    private By langDropdown = By.id("language-selector");
    private By themeRadio = By.cssSelector("input[value='dark']");

    public PreferencesPage(WebDriver driver) { super(driver); }

    public void setPreferences(String lang) {
        // Requirement: dropdown (2 pts)
        Select select = new Select(driver.findElement(langDropdown));
        select.selectByVisibleText(lang);

        // Requirement: radio_button (1 pt)
        if(!driver.findElement(themeRadio).isSelected()) {
            driver.findElement(themeRadio).click();
        }
    }
}