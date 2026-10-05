package com.qa.automation.pages.saucedemo;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By checkoutButton = By.id("checkout");
    private final By cartItems = By.cssSelector(".inventory_item_name");
    private final By cartRows = By.cssSelector(".cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasItem(String itemName) {
        waitForVisible(cartRows);
        return driver.findElements(cartItems).stream().anyMatch(item -> item.getText().equals(itemName));
    }

    public void removeItem(String itemName) {
        By removeButton = By.xpath("//div[@class='inventory_item_name' and normalize-space()='" + itemName
                + "']/ancestor::div[contains(@class,'cart_item')]//button");
        click(removeButton);
    }

    public void checkout() {
        click(checkoutButton);
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }
}
