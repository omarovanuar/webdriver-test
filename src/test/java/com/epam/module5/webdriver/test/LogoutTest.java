package com.epam.module5.webdriver.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test(groups = "logout", dependsOnGroups = "send-letter")
    public void testLogout() {
        steps.logoutMailRu();
        Assert.assertTrue(steps.isPageContains("Mail.Ru: почта, поиск в интернете, новости, игры"), "It's not a Login Page");
    }
}
