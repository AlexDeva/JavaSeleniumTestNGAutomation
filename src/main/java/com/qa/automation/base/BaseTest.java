package com.qa.automation.base;

import com.qa.automation.config.ConfigReader;
import com.qa.automation.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected final ConfigReader configReader = new ConfigReader();

    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser", configReader.getBrowser());
        driver = createDriver(browser);
        DriverManager.setDriver(driver);

        driver.get(configReader.getBaseUrl());

        if (configReader.getBoolean("maximize.window")) {
            driver.manage().window().maximize();
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    private WebDriver createDriver(String browserName) {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless",
                String.valueOf(configReader.getBoolean("headless"))));

        switch (browserName.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }
                return new FirefoxDriver(firefoxOptions);
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }
                return new EdgeDriver(edgeOptions);
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }
                return new ChromeDriver(chromeOptions);
        }
    }
}
