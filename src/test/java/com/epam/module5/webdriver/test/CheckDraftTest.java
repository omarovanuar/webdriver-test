package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.DraftPage;
import com.epam.module5.webdriver.page.LetterEditPage;
import com.epam.module5.webdriver.page.MailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckDraftTest extends BaseTest{

    @Test(groups = "check-draft", dependsOnGroups = ("create"))
    public void testChooseFromDraft() {
        MailPage mailPage = new MailPage(driver);
        DraftPage draftPage = mailPage.draftPageView();
        Assert.assertTrue(draftPage.getDriver().getTitle().contains("Черновики"), "It's not a Draft Page");

        LetterEditPage letterEditPage = draftPage.chooseSavedLetter();
        Assert.assertTrue(letterEditPage.getTitle().contains("Новое письмо"), "It's not a Letter Edit Page");
        Assert.assertTrue(letterEditPage.getLetter().equals(expectedLetter), "Draft letter and expected letter aren't the same");
    }
}
