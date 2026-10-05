package com.qa.listeners;

import com.qa.automation.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        if (driver instanceof TakesScreenshot screenshotDriver) {
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
            String fileName = "failure_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";
            Path screenshotsDir = Paths.get(System.getProperty("user.dir"), "screenshots");
            try {
                Files.createDirectories(screenshotsDir);
                Path destination = screenshotsDir.resolve(fileName);
                Files.copy(screenshot.toPath(), destination);
                System.out.println("Screenshot saved: " + destination.toAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException("Unable to save screenshot", e);
            }
        }
    }
}
