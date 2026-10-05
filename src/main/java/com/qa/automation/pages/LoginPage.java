package com.qa.automation.pages;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("loginButton");
    private final By errorMessage = By.cssSelector(".error-message");
    private final By dashboardHeader = By.cssSelector("h1.dashboard-title");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElements(errorMessage).size() > 0 && driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMessageText() {
        return getText(errorMessage);
    }

    public boolean isDashboardVisible() {
        return driver.findElements(dashboardHeader).size() > 0 && driver.findElement(dashboardHeader).isDisplayed();
    }
}
