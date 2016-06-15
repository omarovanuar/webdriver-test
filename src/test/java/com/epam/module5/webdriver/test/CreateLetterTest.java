package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.LetterEditPage;
import com.epam.module5.webdriver.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateLetterTest extends BaseTest {

    @Test(groups = "create", dependsOnGroups = {"enter"})
    public void testCreateLetter() {
        MailPage mailPage = new MailPage(driver);
        LetterEditPage letterEditPage = mailPage.createNewLetter();
        Assert.assertTrue(letterEditPage.getDriver().getTitle().contains("Новое письмо"));
    }

    @Test(groups = "create", dependsOnMethods = ("testCreateLetter"))
    public void testFillNewLetter() {
        LetterEditPage letterEditPage = new LetterEditPage(driver);
        letterEditPage.fillLetterFields("gg-poster@mail.ru", "WebDriverTest", "Hello! It's a Mail.Ru Test");
        Assert.assertEquals(letterEditPage.getLetterToField(), "gg-poster@mail.ru");
        Assert.assertEquals(letterEditPage.getLetterThemeField(), "WebDriverTest");
        Assert.assertEquals(letterEditPage.getLetterTextField(), "Hello! It's a Mail.Ru Test");
    }
//
    @Test(groups = "create", dependsOnMethods = ("testFillNewLetter"))
    public void testSaveToDraft() {
        LetterEditPage letterEditPage = new LetterEditPage(driver);
        letterEditPage.saveToDraft();
        Assert.assertTrue(letterEditPage.isSavedToDraftMessageAppeared());
    }
}
