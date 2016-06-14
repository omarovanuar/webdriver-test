package com.epam.module5.webdriver;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverTest {
    private static WebDriver driver;

//    @BeforeClass
//    public static void setUp() {
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @AfterClass
//    public static void tearDown() {
//        driver.quit();
//    }

//    @Test
//    public void testEnterMailRu() {
//        driver.get("https://mail.ru/");
//    }
//
//    @Test(dependsOnMethods = ("testEnterMailRu"))
//    public void testLoginPass() {
//        WebElement loginInput = driver.findElement(By.xpath("//input[@id='mailbox__login']"));
//        loginInput.sendKeys("robbie.williams.92");
//        WebElement passInput = driver.findElement(By.xpath("//input[@id='mailbox__password']"));
//        passInput.sendKeys("123456789a");
//        WebElement LoginPassButton = driver.findElement(By.xpath("//input[@id='mailbox__auth__button']"));
//        LoginPassButton.click();
//        System.out.println("Page title is: " + driver.getTitle());
//    }
//
//    @Test(dependsOnMethods = ("testLoginPass"))
//    public void testCreateLetter() {
//        WebElement newLetterButton = driver.findElement(By.xpath("//div[@class='b-toolbar__item']/child::a"));
//        newLetterButton.click();
//        System.out.println("Page title is: " + driver.getTitle());
//    }
//
//    @Test(dependsOnMethods = ("testCreateLetter"))
//    public void testFillNewLetter() {
//        WebElement newLetterWho = driver.findElement(By.xpath("//textarea[@class='js-input compose__labels__input']"));
//        newLetterWho.sendKeys("gg-poster@mail.ru");
//        WebElement letterThemeInput = driver.findElement(By.xpath("//input[@class='compose__header__field']"));
//        letterThemeInput.sendKeys("WebDriverTest");
//        WebElement letterFrame = driver.findElement(By.xpath("//iframe[contains(@id, '_composeEditor_ifr')]"));
//        driver.switchTo().frame(letterFrame);
//        WebElement letterTextInput = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
//        letterTextInput.clear();
//        letterTextInput.sendKeys("WebDriverTest123Text");
//        driver.switchTo().defaultContent();
//    }
//
//
//
//    @Test(dependsOnMethods = ("testFillNewLetter"))
//    public void testSaveToDraft() {
//        WebElement draftSaveButton = driver.findElement(By.xpath("//div[@class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']"));
//        draftSaveButton.click();
//    }
//
//    @Test(dependsOnMethods = ("testSaveToDraft"))
//    public void testCheckDraftSaved() {
//        boolean result = (new WebDriverWait(driver, 10)).until(new Function<WebDriver, Boolean>() {
//            @Override
//            public Boolean apply(WebDriver webDriver) {
//                WebElement letterSavedMessage = webDriver.findElement(By.xpath("//div[@class='b-toolbar__message']"));
//                return letterSavedMessage.isDisplayed();
//            }
//        });
//        Assert.assertTrue(result);
//    }
//
//    @Test(dependsOnMethods = ("testCheckDraftSaved"))
//    public void testGoToDraft() {
//        WebElement draftsViewLink = driver.findElement(By.xpath("//a[@href='/messages/drafts/']"));
//        draftsViewLink.click();
//        System.out.println("Page title is: " + driver.getTitle());
//    }
//
//    @Test(dependsOnMethods = ("testGoToDraft"))
//    public void testChooseDraft() {
//        WebElement draftViewLink = driver.findElement(By.xpath("//a[@data-subject='WebDriverTest']"));
//        draftViewLink.click();
//        System.out.println("Page title is: " + driver.getTitle());
//    }
//
//    @Test(dependsOnMethods = ("testChooseDraft"))
//    public void testCheckLetterTo() {
//        WebElement letterWhoSpan = driver.findElement(By.xpath("//span[@data-text='gg-poster@mail.ru']/span"));
//        Assert.assertEquals(letterWhoSpan.getText(), "gg-poster@mail.ru");
//    }
//
//    @Test(dependsOnMethods = ("testCheckLetterTo"))
//    public void testCheckLetterTheme() {
//        WebElement letterThemeInput = driver.findElement(By.xpath("//input[@class='compose__header__field']"));
//        Assert.assertEquals(letterThemeInput.getAttribute("value"), "WebDriverTest");
//    }
//
//    @Test(dependsOnMethods = ("testCheckLetterTheme"))
//    public void testCheckLetterText() {
//        WebElement letterFrame = driver.findElement(By.xpath("//iframe[contains(@id, '_composeEditor_ifr')]"));
//        driver.switchTo().frame(letterFrame);
//        WebElement letterTextInput = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
//        Assert.assertEquals(letterTextInput.getText(), "WebDriverTest123Text");
//        driver.switchTo().defaultContent();
//    }
//
//    @Test(dependsOnMethods = ("testCheckLetterText"))
//    public void testSendLetter() {
//        WebElement draftViewButton = driver.findElement(By.xpath("//div[@class='b-toolbar__btn b-toolbar__btn_false js-shortcut']"));
//        draftViewButton.click();
//        System.out.println("Page title is: " + driver.getTitle());
//    }
//
//    @Test(dependsOnMethods = ("testSendLetter"), expectedExceptions = NoSuchElementException.class)
//    public void testCheckDraft() throws InterruptedException {
//        Thread.sleep(1000);
//        WebElement draftViewLink = driver.findElement(By.xpath("//a[@href='/messages/drafts/']"));
//        draftViewLink.click();
//        driver.findElement(By.xpath("//a[@data-subject='WebDriverTest']"));
//    }
//
//    @Test(dependsOnMethods = "testCheckDraft")
//    public void testGoToSent() {
//        WebElement sentLettersLink = driver.findElement(By.xpath("//a[@href='/messages/sent/']"));
//        sentLettersLink.click();
//        System.out.println("Page title is: " + driver.getTitle());
//    }
//
//    @Test(dependsOnMethods = "testGoToSent")
//    public void testCheckSentLetter() {
//        WebElement sentLettersLink = driver.findElement(By.xpath("//a[@data-subject='WebDriverTest']"));
//        sentLettersLink.click();
//    }
//
//    @Test(dependsOnMethods = "testCheckSentLetter")
//    public void testLogout() {
//        WebElement logoutLink = driver.findElement(By.xpath("//a[@id='PH_logoutLink']"));
//        logoutLink.click();
//        System.out.println("Page title is: " + driver.getTitle());
//    }
}
