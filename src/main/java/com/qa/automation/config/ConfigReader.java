package com.qa.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        this.properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        String filePath = System.getProperty("config.file", "src/main/resources/config.properties");

        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read configuration file: " + filePath, e);
        }
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }

    public String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }

    public String getBaseUrl() {
        return getString("base.url");
    }

    public String getBrowser() {
        return getString("browser", "chrome");
    }
}
