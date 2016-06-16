package com.epam.module5.webdriver.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateLetterTest extends BaseTest {

    @Test(groups = "create", dependsOnGroups = {"enter"})
    public void testCreateLetter() {
        steps.createAndFillNewLetter("gg-poster@mail.ru", "WebDriverTest", "Hello! It's a Mail.Ru Test");
        Assert.assertTrue(steps.isPageContains("Новое письмо"), "It's not a Letter Edit Page");
        Assert.assertTrue(steps.isLetterValid(expectedLetter), "New letter and expected letter aren't the same");
    }

    @Test(groups = "create", dependsOnMethods = ("testCreateLetter"))
    public void testSaveToDraft() {
        steps.saveLetter();
        Assert.assertTrue(steps.isLetterSaved(), "Save-message didn't appear");
    }
}
