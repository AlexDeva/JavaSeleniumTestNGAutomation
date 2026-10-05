package com.qa.tests.playground;

import com.qa.automation.base.BaseTest;
import com.qa.automation.pages.playground.AjaxPage;
import com.qa.automation.pages.playground.ClassAttributePage;
import com.qa.automation.pages.playground.DynamicIdPage;
import com.qa.automation.pages.playground.PlaygroundHomePage;
import com.qa.automation.pages.playground.SampleAppPage;
import com.qa.automation.pages.playground.TextInputPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UiPlaygroundTest extends BaseTest {

    @Test
    public void dynamicIdButtonCanBeClicked() {
        PlaygroundHomePage homePage = new PlaygroundHomePage(driver);
        homePage.open();
        homePage.openDynamicIdPage();

        DynamicIdPage dynamicIdPage = new DynamicIdPage(driver);
        Assert.assertTrue(dynamicIdPage.getPageUrl().contains("dynamicid"),
                "Page URL should contain the dynamic ID route.");

        dynamicIdPage.clickDynamicButton();
        Assert.assertTrue(dynamicIdPage.getPageUrl().contains("dynamicid"),
                "Dynamic ID page should remain stable after clicking the primary button.");
    }

    @Test
    public void ajaxButtonLoadsData() {
        PlaygroundHomePage homePage = new PlaygroundHomePage(driver);
        homePage.open();
        homePage.openAjaxPage();

        AjaxPage ajaxPage = new AjaxPage(driver);
        ajaxPage.clickTriggerButton();

        Assert.assertTrue(ajaxPage.isSuccessTextVisible(),
                "The AJAX success message should appear after the request completes.");
        Assert.assertEquals(ajaxPage.getSuccessText(), "Data loaded with AJAX get request.",
            "The AJAX response should match the expected success text.");
        }

        @Test
        public void classAttributeButtonShowsConfirmationAlert() {
        ClassAttributePage page = new ClassAttributePage(driver);
        page.open();
        page.clickPrimaryButton();

        Assert.assertEquals(page.getAlertText(), "Primary button pressed",
            "The primary class-attribute button should display its confirmation alert.");
        page.acceptAlert();
        }

        @Test
        public void textInputChangesButtonLabel() {
        TextInputPage page = new TextInputPage(driver);
        page.open();
        page.renameButton("Run playground action");

        Assert.assertEquals(page.getButtonText(), "Run playground action",
            "The button label should update to the entered text.");
        }

        @Test
        public void sampleAppAcceptsValidCredentials() {
        SampleAppPage page = new SampleAppPage(driver);
        page.open();
        page.login("automation-user", "pwd");

        Assert.assertEquals(page.getStatus(), "Welcome, automation-user!",
            "The Sample App should welcome the authenticated username.");
    }
}
