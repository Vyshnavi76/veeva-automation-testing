package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	// to store configuration values
    static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // to fetch the configuration value
    public static String get(String key) {

        String value = System.getProperty(key);

        // to read from config.properties file
        if (value == null) {
            value = prop.getProperty(key);
        }

        return value;
    }
}