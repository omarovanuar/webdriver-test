package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.DraftPage;
import com.epam.module5.webdriver.page.LetterEditPage;
import com.epam.module5.webdriver.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckDraftTest extends BaseTest{

    @Test(groups = "check-draft", dependsOnGroups = ("create"))
    public void testGoToDraft() {
        MailPage mailPage = new MailPage(driver);
        DraftPage draftPage = mailPage.draftPageView();
        Assert.assertTrue(draftPage.getDriver().getTitle().contains("Черновики"));
    }

    @Test(groups = "check-draft", dependsOnMethods = ("testGoToDraft"))
    public void testChooseDraft() {
        DraftPage draftPage = new DraftPage(driver);
        LetterEditPage letterEditPage = draftPage.editSavedLetter();
        Assert.assertTrue(letterEditPage.getDriver().getTitle().contains("Новое письмо"));
    }

    @Test(groups = "check-draft", dependsOnMethods = ("testChooseDraft"))
    public void testCheckSavedLetterFields() {
        LetterEditPage letterEditPage = new LetterEditPage(driver);
        Assert.assertEquals(letterEditPage.getLetterToField(), "gg-poster@mail.ru");
        Assert.assertEquals(letterEditPage.getLetterThemeField(), "WebDriverTest");
        Assert.assertEquals(letterEditPage.getLetterTextField(), "Hello! It's a Mail.Ru Test");
    }
}
