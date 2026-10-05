package com.qa.automation.pages.playground;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjaxPage extends BasePage {
    private final By triggerButton = By.id("ajaxButton");
    private final By successText = By.cssSelector("#content p.bg-success");
    private final WebDriverWait ajaxWait;

    public AjaxPage(WebDriver driver) {
        super(driver);
        this.ajaxWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickTriggerButton() {
        click(triggerButton);
    }

    public boolean isSuccessTextVisible() {
        return ajaxWait.until(ExpectedConditions.visibilityOfElementLocated(successText)).isDisplayed();
    }

    public String getSuccessText() {
        return ajaxWait.until(ExpectedConditions.visibilityOfElementLocated(successText)).getText();
    }
}
