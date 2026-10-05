package com.qa.automation.pages.playground;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInputPage extends BasePage {
    private final By buttonNameInput = By.id("newButtonName");
    private final By updateButton = By.id("updatingButton");

    public TextInputPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://uitestingplayground.com/textinput");
    }

    public void renameButton(String name) {
        sendKeys(buttonNameInput, name);
        click(updateButton);
    }

    public String getButtonText() {
        return getText(updateButton);
    }
}