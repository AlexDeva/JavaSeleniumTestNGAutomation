package com.qa.automation.pages.saucedemo;

import com.qa.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {
    private final By title = By.cssSelector(".title");
    private final By cartLink = By.cssSelector(".shopping_cart_link");
    private final By sortDropdown = By.cssSelector(".product_sort_container");
    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By itemNames = By.cssSelector(".inventory_item_name");
    private final By itemPrices = By.cssSelector(".inventory_item_price");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(title);
    }

    public void sortProductsBy(String optionText) {
        selectDropdownByVisibleText(sortDropdown, optionText);
    }

    public void addItem(String itemName) {
        By itemButton = By.xpath("//div[normalize-space()=\"" + itemName + "\"]/ancestor::div[contains(@class,'inventory_item')]//button");
        click(itemButton);
    }

    public void openCart() {
        click(cartLink);
    }

    public List<WebElement> getInventoryItems() {
        return driver.findElements(inventoryItems);
    }

    public List<String> getItemNames() {
        List<String> names = new java.util.ArrayList<>();
        for (WebElement element : driver.findElements(itemNames)) {
            names.add(element.getText());
        }
        return names;
    }

    public List<Double> getItemPrices() {
        List<Double> prices = new java.util.ArrayList<>();
        for (WebElement element : driver.findElements(itemPrices)) {
            prices.add(Double.parseDouble(element.getText().replace("$", "")));
        }
        return prices;
    }
}
