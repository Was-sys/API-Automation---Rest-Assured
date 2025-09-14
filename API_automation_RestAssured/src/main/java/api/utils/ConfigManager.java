package api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties = new Properties();

    static {
        loadConfig();
    }

    private static void loadConfig() {
        String fileName = "src/main/resources/config.properties";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            properties.load(fis);
            System.out.println("✅ Loaded config from " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load config file: " + fileName, e);
        }
    }

    // 👉 This must be OUTSIDE of loadConfig()
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
