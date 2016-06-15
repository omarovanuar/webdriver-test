package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.LetterEditPage;
import com.epam.module5.webdriver.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateLetterTest extends BaseTest {

    @Test(groups = "create", dependsOnGroups = {"enter"})
    public void testCreateLetter() {
        MailPage mailPage = new MailPage(driver);
        LetterEditPage letterPage = mailPage.createNewLetter();
        Assert.assertTrue(letterPage.getTitle().contains("Новое письмо"), "It's not a Letter Edit Page");
        letterPage.fillLetterFields("gg-poster@mail.ru", "WebDriverTest", "Hello! It's a Mail.Ru Test");
        Assert.assertTrue(letterPage.getLetter().equals(expectedLetter), "New letter and expected letter aren't the same");
    }
//
    @Test(groups = "create", dependsOnMethods = ("testCreateLetter"))
    public void testSaveToDraft() {
        LetterEditPage letterEditPage = new LetterEditPage(driver);
        letterEditPage.saveToDraft();
        Assert.assertTrue(letterEditPage.isSavedToDraftMessageAppeared(), "Save-message didn't appear");
    }
}
