package com.epam.module5.webdriver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test(groups = "logout", dependsOnGroups = "send-letter")
    public void testLogout() {
        WebElement logoutLink = driver.findElement(By.xpath("//a[@id='PH_logoutLink']"));
        logoutLink.click();
        System.out.println("Page title is: " + driver.getTitle());
    }
}
