package com.qa.automation.pages.playground;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SampleAppPage extends BasePage {
    private final By usernameInput = By.name("UserName");
    private final By passwordInput = By.name("Password");
    private final By loginButton = By.id("login");
    private final By status = By.id("loginstatus");

    public SampleAppPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://uitestingplayground.com/sampleapp");
    }

    public void login(String username, String password) {
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    public String getStatus() {
        return getText(status);
    }

    public String getLoginButtonText() {
        return getText(loginButton);
    }

    public void logout() {
        click(loginButton);
    }
}