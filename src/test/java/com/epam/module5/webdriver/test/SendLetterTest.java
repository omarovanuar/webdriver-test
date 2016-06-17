package com.epam.module5.webdriver.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SendLetterTest extends BaseTest{

    @Test(groups = "send-letter", dependsOnGroups = ("check-draft"))
    public void testSendLetter() {
        steps.sendLetter();
        Assert.assertTrue(steps.isSavedLetterSent(), "Letter wasn't sent");
        Assert.assertTrue(steps.isEmailValidInEdit(sentToUser), "Letter wasn't sent to expected user");
    }

    @Test(groups = "send-letter", dependsOnMethods = ("testSendLetter"))
    public void testCheckDrafts() {
        Assert.assertFalse(steps.checkLetterInDraft(), "Sent letter wasn't removed");
    }

    @Test(groups = "send-letter", dependsOnMethods = "testCheckDrafts")
    public void testCheckSent() {
        steps.viewLetterFromSent();
        Assert.assertTrue(steps.isEmailValidInSent(sentToUser), "Sent to User's email is not the same as expected");
    }
}
