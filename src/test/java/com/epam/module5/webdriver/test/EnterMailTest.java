package com.epam.module5.webdriver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EnterMailTest extends BaseTest{


    @Test(groups = "enter")
    @Parameters({"password", "login"})
    public void testLoginPass(String password, String login) {
        driver.get("https://mail.ru/");
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='mailbox__login']"));
        loginInput.sendKeys(login);
        WebElement passInput = driver.findElement(By.xpath("//input[@id='mailbox__password']"));
        passInput.sendKeys(password);
        WebElement LoginPassButton = driver.findElement(By.xpath("//input[@id='mailbox__auth__button']"));
        LoginPassButton.click();
        System.out.println("Page title is: " + driver.getTitle());
    }
}
