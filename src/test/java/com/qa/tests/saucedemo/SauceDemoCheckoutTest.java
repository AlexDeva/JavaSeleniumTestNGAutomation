package com.qa.tests.saucedemo;

import com.qa.automation.base.BaseTest;
import com.qa.automation.pages.saucedemo.CartPage;
import com.qa.automation.pages.saucedemo.CheckoutPage;
import com.qa.automation.pages.saucedemo.InventoryPage;
import com.qa.automation.pages.saucedemo.SauceLoginPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoCheckoutTest extends BaseTest {

    @Test
    public void productsCanBeSortedByPrice() {
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProductsBy("Price (low to high)");
        List<Double> actualPrices = inventoryPage.getItemPrices();
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);
        Assert.assertEquals(actualPrices, expectedPrices,
                "Products should be ordered from lowest to highest price.");

        inventoryPage.sortProductsBy("Price (high to low)");
        actualPrices = inventoryPage.getItemPrices();
        expectedPrices.sort(Collections.reverseOrder());
        Assert.assertEquals(actualPrices, expectedPrices,
                "Products should be ordered from highest to lowest price.");
    }

    @Test
    public void cartSupportsAddingAndRemovingProducts() {
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItem("Sauce Labs Backpack");
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.hasItem("Sauce Labs Backpack"),
                "The added backpack should appear in the cart.");
        cartPage.removeItem("Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getCartItemCount(), 0,
                "The cart should be empty after removing its only product.");
    }

    @Test
    public void checkoutRequiresCustomerInformation() {
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItem("Sauce Labs Backpack");
        inventoryPage.openCart();
        new CartPage(driver).checkout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.continueWithoutCustomerDetails();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required",
                "Checkout should require a first name before continuing.");
    }

    @Test
    public void validateCheckoutFlow() {
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products",
                "Inventory page title should be visible for logged in user.");

        inventoryPage.sortProductsBy("Price (low to high)");
        inventoryPage.addItem("Sauce Labs Backpack");
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.hasItem("Sauce Labs Backpack"),
                "Backpack should be present in the cart before checkout.");
        Assert.assertTrue(cartPage.getCartItemCount() >= 1,
                "Cart should contain at least one product.");

        cartPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(checkoutPage.getPageTitleText(), "Checkout: Your Information",
                "The user should be on the customer information step.");

        checkoutPage.enterCustomerDetails("John", "Doe", "12345");
        Assert.assertEquals(checkoutPage.getPageTitleText(), "Checkout: Overview",
                "The checkout overview page should be presented after entering customer details.");

        checkoutPage.finishCheckout();
        Assert.assertTrue(checkoutPage.isOrderComplete(),
                "The order completion message should be displayed after finishing checkout.");
    }
}
