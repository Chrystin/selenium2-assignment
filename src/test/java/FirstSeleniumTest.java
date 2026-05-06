import org.junit.jupiter.api.*;

public class FirstSeleniumTest extends TestBase {

    @BeforeAll
    public static void init() {
        ConfigReader.loadConfig();
    }

    @BeforeEach
    public void setup() { startBrowser(); }

    @Test
    @DisplayName("Grade 5: Full Journey Test")
    public void testFullFlow() {
        driver.get(ConfigReader.get("baseUrl"));
        MainPage main = new MainPage(driver);
        main.denyCookies();
        main.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));

        // Basic: page_title
        Assertions.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @Test
    @DisplayName("Grade 5: History and Navigation")
    public void testNavigation() {
        // Advanced: history_test
        driver.get(ConfigReader.get("baseUrl"));
        driver.get(ConfigReader.get("baseUrl") + "courses/all-courses");
        driver.navigate().back();
        Assertions.assertEquals(ConfigReader.get("baseUrl"), driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown() { stopBrowser(); }
}