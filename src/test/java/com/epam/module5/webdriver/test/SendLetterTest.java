package com.epam.module5.webdriver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SendLetterTest extends BaseTest{

    @Test(groups = "send-letter", dependsOnGroups = ("check-draft"))
    public void testSendLetter() {
        WebElement draftViewButton = driver.findElement(By.xpath("//div[@class='b-toolbar__btn b-toolbar__btn_false js-shortcut']"));
        draftViewButton.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(groups = "send-letter", dependsOnMethods = ("testSendLetter"), expectedExceptions = NoSuchElementException.class)
    public void testCheckDraft() throws InterruptedException {
        Thread.sleep(1000);
        WebElement draftViewLink = driver.findElement(By.xpath("//a[@href='/messages/drafts/']"));
        draftViewLink.click();
        driver.findElement(By.xpath("//a[@data-subject='WebDriverTest']"));
    }

    @Test(groups = "send-letter", dependsOnMethods = "testCheckDraft")
    public void testGoToSent() {
        WebElement sentLettersLink = driver.findElement(By.xpath("//a[@href='/messages/sent/']"));
        sentLettersLink.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(groups = "send-letter", dependsOnMethods = "testGoToSent")
    public void testCheckSentLetter() {
        WebElement sentLettersLink = driver.findElement(By.xpath("//a[@data-subject='WebDriverTest']"));
        sentLettersLink.click();
    }
}
