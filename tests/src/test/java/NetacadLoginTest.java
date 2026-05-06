import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NetacadLoginTest extends BaseTest {

    @Test
    public void testUserCanNavigateToLogin() {
        driver.get("https://www.netacad.com/portal/learning");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("your-email@example.com");
        loginPage.clickNext();

        // Grade 5 Tip: Instead of a generic message, check if the 
        // password field appeared or the URL changed.
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("login"), "The URL should contain 'login' after entering email");
    }
}