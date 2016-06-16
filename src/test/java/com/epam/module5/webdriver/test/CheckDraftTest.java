package com.epam.module5.webdriver.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckDraftTest extends BaseTest{

    @Test(groups = "check-draft", dependsOnGroups = ("create"))
    public void testChooseFromDraft() {
        steps.viewLetterFromDraft();
        Assert.assertTrue(steps.isPageContains("Новое письмо"), "It's not a Letter Edit Page");
        Assert.assertTrue(steps.isLetterValid(expectedLetter), "Draft letter and expected letter aren't the same");
    }
}
