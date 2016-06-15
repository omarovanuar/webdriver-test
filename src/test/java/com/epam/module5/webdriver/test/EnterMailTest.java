package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.LoginPage;
import com.epam.module5.webdriver.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EnterMailTest extends BaseTest{

    @Test(groups = "enter")
    @Parameters({"password", "login"})
    public void testLogin(String password, String login) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        MailPage mailPage = loginPage.login(login, password);
        Assert.assertTrue(mailPage.getDriver().getTitle().contains("Входящие"));
    }
}
