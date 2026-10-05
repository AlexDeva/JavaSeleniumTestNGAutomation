package com.qa.automation.pages.saucedemo;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLoginPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public SauceLoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorMessage).size() > 0 && driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isInventoryPageDisplayed() {
        return driver.getCurrentUrl().contains("/inventory.html");
    }
}
