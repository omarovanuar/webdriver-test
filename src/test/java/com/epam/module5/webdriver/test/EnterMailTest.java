package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.LoginPage;
import com.epam.module5.webdriver.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EnterMailTest extends BaseTest{

    @Test(groups = "enter")
    @Parameters({"login", "password"})
    public void testLogin(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        MailPage mailPage = loginPage.login(login, password);
        Assert.assertTrue(mailPage.getTitle().contains("Входящие"), "It's not a Main Page");
        Assert.assertTrue(mailPage.getUserEmail().equals(expectedUser.getEmail()), "Current users' email isn't the same as expected");
    }
}
