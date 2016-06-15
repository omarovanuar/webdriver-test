package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.LoginPage;
import com.epam.module5.webdriver.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test(groups = "logout", dependsOnGroups = "send-letter")
    public void testLogout() {
        MailPage mailPage = new MailPage(driver);
        LoginPage loginPage = mailPage.logout();
        Assert.assertTrue(loginPage.getDriver().getTitle().contains("Mail.Ru: почта, поиск в интернете, новости, игры"));
    }
}
