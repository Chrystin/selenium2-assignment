import org.openqa.selenium.WebDriver;

public class AboutPage extends PageBase {
    public AboutPage(WebDriver driver) { 
        super(driver); 
    }
    
    public String getHeroText() {
        return driver.findElement(org.openqa.selenium.By.tagName("h1")).getText();
    }
}