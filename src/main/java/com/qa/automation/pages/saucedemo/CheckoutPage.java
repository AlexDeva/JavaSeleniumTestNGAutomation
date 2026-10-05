package com.qa.automation.pages.saucedemo;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By pageTitle = By.cssSelector(".title");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By confirmationHeader = By.cssSelector(".complete-header");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitleText() {
        return getText(pageTitle);
    }

    public void enterCustomerDetails(String firstName, String lastName, String postalCode) {
        sendKeys(firstNameInput, firstName);
        sendKeys(lastNameInput, lastName);
        sendKeys(postalCodeInput, postalCode);
        click(continueButton);
    }

    public void continueWithoutCustomerDetails() {
        click(continueButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public void finishCheckout() {
        click(finishButton);
    }

    public boolean isOrderComplete() {
        return waitForVisible(confirmationHeader).getText().contains("Thank you for your order!");
    }
}
