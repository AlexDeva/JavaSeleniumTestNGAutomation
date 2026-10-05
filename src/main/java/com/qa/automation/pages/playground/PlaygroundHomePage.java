package com.qa.automation.pages.playground;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaygroundHomePage extends BasePage {
    public PlaygroundHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://uitestingplayground.com/");
    }

    public void openDynamicIdPage() {
        driver.get("http://uitestingplayground.com/dynamicid");
    }

    public void openAjaxPage() {
        driver.get("http://uitestingplayground.com/ajax");
    }

    public void openHiddenLayersPage() {
        driver.get("http://uitestingplayground.com/hiddenlayers");
    }
}
