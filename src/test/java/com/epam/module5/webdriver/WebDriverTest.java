package com.epam.module5.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class WebDriverTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testEnterMailRu() {
        driver.get("https://mail.ru/");
    }

    @Test(dependsOnMethods = ("testEnterMailRu"))
    public void testLoginPass() {
        WebElement login = driver.findElement(By.xpath("//input[@id='mailbox__login']"));
        login.sendKeys("robbie.williams.92");
        WebElement pass = driver.findElement(By.xpath("//input[@id='mailbox__password']"));
        pass.sendKeys("123456789a");
        WebElement button = driver.findElement(By.xpath("//input[@id='mailbox__auth__button']"));
        button.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(dependsOnMethods = ("testLoginPass"))
    public void testCreateLetter() {
        WebElement newLetterButton = driver.findElement(By.xpath("//div[@class='b-toolbar__item']/child::a"));
        newLetterButton.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(dependsOnMethods = ("testCreateLetter"))
    public void testFillNewLetter() {
        WebElement newLetterWho = driver.findElement(By.xpath("//textarea[@class='js-input compose__labels__input']"));
        newLetterWho.sendKeys("gg-poster@mail.ru");
        WebElement newLetterTheme = driver.findElement(By.xpath("//input[@class='compose__header__field']"));
        newLetterTheme.sendKeys("WebDriverTest");
        WebElement newLetterText = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
        System.out.println(newLetterText.getLocation());
        System.out.println(newLetterText.getText());
        System.out.println(newLetterText.getCssValue("class"));
        newLetterText.sendKeys("WebDriverTest123Text");
        WebElement draftSaveArrow = driver.findElement(By.cssSelector("div[class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']"));
        draftSaveArrow.click();
    }

    @Test(dependsOnMethods = ("testFillNewLetter"))
    public void testSaveToDraft() {
        WebElement draftSaveButton = driver.findElement(By.cssSelector("div[class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']"));
        draftSaveButton.click();
    }

    @Test(dependsOnMethods = ("testSaveToDraft"))
    public void testCheckDraft() {
        WebElement draftViewButton = driver.findElement(By.cssSelector("a[href='/messages/drafts/']"));
        draftViewButton.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(dependsOnMethods = ("testCheckDraft"))
    public void testChooseDraft() {
        WebElement draftViewButton = driver.findElement(By.cssSelector("div[class='b-datalist__item js-datalist-item b-datalist__item_last']"));
        draftViewButton.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(dependsOnMethods = ("testChooseDraft"))
    public void testCheckLetterTo() {
        WebElement newLetterWho = driver.findElement(By.cssSelector("span.js-compose-label:nth-child(6) > span:nth-child(2)"));
        Assert.assertEquals(newLetterWho.getText(), "gg-poster@mail.ru");
    }

    @Test(dependsOnMethods = ("testCheckLetterTo"))
    public void testCheckLetterTheme() {
        WebElement newLetterTheme = driver.findElement(By.xpath("//input[@class='compose__header__field']"));
        Assert.assertEquals(newLetterTheme.getAttribute("value"), "WebDriverTest");
    }

    @Test(dependsOnMethods = ("testCheckLetterTheme"))
    public void testSendLetter() {
        WebElement draftViewButton = driver.findElement(By.cssSelector("div[class='b-toolbar__btn b-toolbar__btn_false js-shortcut']"));
        draftViewButton.click();
        System.out.println("Page title is: " + driver.getTitle());
    }
}
