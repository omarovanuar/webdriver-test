package com.epam.module5.webdriver.test;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendLetterTest extends BaseTest{

    @Test(groups = "send-letter", dependsOnGroups = ("check-draft"))
    public void testSendLetter() {
        steps.sendLetter();
        Assert.assertTrue(steps.isSavedLetterSent(), "Letter wasn't sent");
        Assert.assertTrue(steps.isEmailValidInEdit(sentToUser), "Letter wasn't sent to expected user");
    }

    @Test(groups = "send-letter", dependsOnMethods = ("testSendLetter"), expectedExceptions = NoSuchElementException.class)
    public void testCheckDrafts() {
        steps.viewLetterFromDraft();
    }

    @Test(groups = "send-letter", dependsOnMethods = "testCheckDrafts")
    public void testCheckSent() {
        steps.viewLetterFromSent();
        Assert.assertTrue(steps.isEmailValidInSent(sentToUser), "Sent to User's email is not the same as expected");
    }
}
