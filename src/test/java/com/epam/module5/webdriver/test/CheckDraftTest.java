package com.epam.module5.webdriver.test;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckDraftTest extends BaseTest{

    @Test(groups = "check-draft", dependsOnGroups = ("create"))
    public void testCheckDraftSaved() {
        boolean result = (new WebDriverWait(driver, 10)).until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                WebElement letterSavedMessage = webDriver.findElement(By.xpath("//div[@class='b-toolbar__message']"));
                return letterSavedMessage.isDisplayed();
            }
        });
        Assert.assertTrue(result);
    }

    @Test(groups = "check-draft", dependsOnMethods = ("testCheckDraftSaved"))
    public void testGoToDraft() {
        WebElement draftsViewLink = driver.findElement(By.xpath("//a[@href='/messages/drafts/']"));
        draftsViewLink.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(groups = "check-draft", dependsOnMethods = ("testGoToDraft"))
    public void testChooseDraft() {
        WebElement draftViewLink = driver.findElement(By.xpath("//a[@data-subject='WebDriverTest']"));
        draftViewLink.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(groups = "check-draft", dependsOnMethods = ("testChooseDraft"))
    public void testCheckLetterTo() {
        WebElement letterWhoSpan = driver.findElement(By.xpath("//span[@data-text='gg-poster@mail.ru']/span"));
        Assert.assertEquals(letterWhoSpan.getText(), "gg-poster@mail.ru");
    }

    @Test(groups = "check-draft", dependsOnMethods = ("testCheckLetterTo"))
    public void testCheckLetterTheme() {
        WebElement letterThemeInput = driver.findElement(By.xpath("//input[@class='compose__header__field']"));
        Assert.assertEquals(letterThemeInput.getAttribute("value"), "WebDriverTest");
    }

    @Test(groups = "check-draft", dependsOnMethods = ("testCheckLetterTheme"))
    public void testCheckLetterText() {
        WebElement letterFrame = driver.findElement(By.xpath("//iframe[contains(@id, '_composeEditor_ifr')]"));
        driver.switchTo().frame(letterFrame);
        WebElement letterTextInput = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
        Assert.assertEquals(letterTextInput.getText(), "WebDriverTest123Text");
        driver.switchTo().defaultContent();
    }
}
