package com.qa.tests.saucedemo;

import com.qa.automation.base.BaseTest;
import com.qa.automation.pages.saucedemo.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoLoginTest extends BaseTest {

    @DataProvider(name = "validUsers")
    public Object[][] validUsers() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", true},
                {"performance_glitch_user", "secret_sauce", true}
        };
    }

    @Test(dataProvider = "validUsers")
    public void loginWithDifferentRoles(String username, String password, boolean expectedSuccess) {
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);

        if (expectedSuccess) {
            Assert.assertTrue(loginPage.isInventoryPageDisplayed(),
                    "Expected inventory page after successful login for user: " + username);
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed(),
                    "Expected error message for locked user: " + username);
        }
    }
}
