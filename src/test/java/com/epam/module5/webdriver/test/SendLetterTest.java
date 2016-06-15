package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.page.DraftPage;
import com.epam.module5.webdriver.page.LetterEditPage;
import com.epam.module5.webdriver.page.MailPage;
import com.epam.module5.webdriver.page.SentPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendLetterTest extends BaseTest{

    @Test(groups = "send-letter", dependsOnGroups = ("check-draft"))
    public void testSendLetter() {
        LetterEditPage letterEditPage = new LetterEditPage(driver);
        letterEditPage.sendLetter();
        Assert.assertTrue(letterEditPage.getDriver().getTitle().contains("Новое письмо"));
    }

    @Test(groups = "send-letter", dependsOnMethods = ("testSendLetter"), expectedExceptions = NoSuchElementException.class)
    public void testCheckDraft() throws InterruptedException {
        MailPage mailPage = new MailPage(driver);
        DraftPage draftPage = mailPage.isDraftPageLinkDisplayed();
        draftPage.editSavedLetter();
    }

    @Test(groups = "send-letter", dependsOnMethods = "testCheckDraft")
    public void testGoToSent() {
        MailPage mailPage = new MailPage(driver);
        SentPage sentPage = mailPage.sentPageView();
        Assert.assertTrue(sentPage.getDriver().getTitle().contains("Отправленные"));
    }

    @Test(groups = "send-letter", dependsOnMethods = "testGoToSent")
    public void testCheckSentLetter() {
        SentPage sentPage = new SentPage(driver);
        LetterEditPage letterEditPage = sentPage.editSentLetter();
        Assert.assertTrue(letterEditPage.getDriver().getTitle().contains("WebDriverTest - robbie.williams.92@mail.ru"));
    }
}
