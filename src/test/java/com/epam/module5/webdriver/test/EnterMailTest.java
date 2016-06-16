package com.epam.module5.webdriver.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EnterMailTest extends BaseTest{

    @Test(groups = "enter")
    @Parameters({"login", "password"})
    public void testLogin(String login, String password) {
        steps.loginMailRu(login, password);
        Assert.assertTrue(steps.isPageContains("Входящие"), "It's not a Main Page");
        Assert.assertTrue(steps.isEmailValid(expectedUser), "Current users' email isn't the same as expected");
    }
}
