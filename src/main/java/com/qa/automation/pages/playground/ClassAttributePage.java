package com.qa.automation.pages.playground;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClassAttributePage extends BasePage {
    private final By primaryButton = By.cssSelector("button.btn-primary");

    public ClassAttributePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://uitestingplayground.com/classattr");
    }

    public void clickPrimaryButton() {
        click(primaryButton);
    }

    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}