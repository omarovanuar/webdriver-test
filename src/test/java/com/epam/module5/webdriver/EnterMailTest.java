package com.epam.module5.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EnterMailTest {
    private static WebDriver driver;

    @Test
    public void testEnterMailRu() {
        driver.get("https://mail.ru/");
    }

    @Test(dependsOnMethods = ("testEnterMailRu"))
    public void testLoginPass() {
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='mailbox__login']"));
        loginInput.sendKeys("robbie.williams.92");
        WebElement passInput = driver.findElement(By.xpath("//input[@id='mailbox__password']"));
        passInput.sendKeys("123456789a");
        WebElement LoginPassButton = driver.findElement(By.xpath("//input[@id='mailbox__auth__button']"));
        LoginPassButton.click();
        System.out.println("Page title is: " + driver.getTitle());
    }
}
