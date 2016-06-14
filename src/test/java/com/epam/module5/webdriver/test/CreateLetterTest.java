package com.epam.module5.webdriver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateLetterTest extends BaseTest {

    @Test(groups = "create", dependsOnGroups = {"enter"})
    public void testCreateLetter() {
        WebElement newLetterButton = driver.findElement(By.xpath("//div[@class='b-toolbar__item']/child::a"));
        newLetterButton.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test(groups = "create", dependsOnMethods = ("testCreateLetter"))
    public void testFillNewLetter() {
        WebElement newLetterWho = driver.findElement(By.xpath("//textarea[@class='js-input compose__labels__input']"));
        newLetterWho.sendKeys("gg-poster@mail.ru");
        WebElement letterThemeInput = driver.findElement(By.xpath("//input[@class='compose__header__field']"));
        letterThemeInput.sendKeys("WebDriverTest");
        WebElement letterFrame = driver.findElement(By.xpath("//iframe[contains(@id, '_composeEditor_ifr')]"));
        driver.switchTo().frame(letterFrame);
        WebElement letterTextInput = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
        letterTextInput.clear();
        letterTextInput.sendKeys("WebDriverTest123Text");
        driver.switchTo().defaultContent();
    }

    @Test(groups = "create", dependsOnMethods = ("testFillNewLetter"))
    public void testSaveToDraft() {
        WebElement draftSaveButton = driver.findElement(By.xpath("//div[@class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']"));
        draftSaveButton.click();
    }
}
