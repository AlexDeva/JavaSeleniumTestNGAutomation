package com.qa.automation.pages.playground;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicIdPage extends BasePage {
    private final By dynamicButton = By.xpath("//button[normalize-space()='Button with Dynamic ID']");

    public DynamicIdPage(WebDriver driver) {
        super(driver);
    }

    public void clickDynamicButton() {
        click(dynamicButton);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
