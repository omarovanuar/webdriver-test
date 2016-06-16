package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendLetterTest extends BaseTest{

    @Test(groups = "send-letter", dependsOnGroups = ("check-draft"))
    public void testSendLetter() {
        LetterEditPage letterEditPage = new LetterEditPage(driver);
        letterEditPage.sendLetter();
        Assert.assertTrue(letterEditPage.isSent(), "Letter wasn't sent");
        Assert.assertTrue(letterEditPage.sentToUser().equals(sentToUser.getEmail()), "Letter wasn't sent to expected user");
    }

    @Test(groups = "send-letter", dependsOnMethods = ("testSendLetter"), expectedExceptions = NoSuchElementException.class)
    public void testCheckDraft() {
        MailPage mailPage = new MailPage(driver);
        DraftPage draftPage = mailPage.draftPageView();
        draftPage.chooseSavedLetter();
    }

    @Test(groups = "send-letter", dependsOnMethods = "testCheckDraft")
    public void testCheckSent() {
        MailPage mailPage = new MailPage(driver);
        SentPage sentPage = mailPage.sentPageView();
        Assert.assertTrue(sentPage.getTitle().contains("Отправленные"), "It's not a Sent Page");

        SentLetterEditPage sentLetter = sentPage.editSentLetter();
        Assert.assertTrue(sentLetter.getUserToEmail().equals(sentToUser.getEmail()), "Sent to User's email is not the same as expected");
    }
}
