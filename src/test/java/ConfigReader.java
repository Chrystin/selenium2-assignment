import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static void loadConfig() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (Exception e) {
            System.err.println("Error: config.properties not found!");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}