package com.qa.tests;

import com.qa.automation.base.BaseTest;
import com.qa.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"validuser", "validpass", true},
                {"invaliduser", "wrongpass", false},
                {"", "", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginValidation(String username, String password, boolean shouldPass) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (shouldPass) {
            Assert.assertTrue(loginPage.isDashboardVisible(),
                    "Dashboard should be visible after successful login.");
        } else {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                    "Error message should be displayed for invalid login credentials.");
        }
    }
}
