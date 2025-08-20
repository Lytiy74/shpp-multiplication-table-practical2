package shpp.azaika.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties properties;
    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    private Config() {}

    static {
        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            Properties defaultProperties = initDefaultProperties();
            properties = new Properties(defaultProperties);
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            logger.warn("Unable to load config.properties, use default values ");
        }
    }

    private static Properties initDefaultProperties() {
        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("table.calculation.minValue","1");
        defaultProperties.setProperty("table.calculation.maxValue","10");
        defaultProperties.setProperty("table.calculation.increment","1");
        return defaultProperties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
