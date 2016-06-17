package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.driver.WebDriverFactory;
import com.epam.module5.webdriver.entity.Letter;
import com.epam.module5.webdriver.entity.User;
import com.epam.module5.webdriver.step.Steps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private static final String EXPECTED_USER_NAME = "Robbie Williams";
    private static final String EXPECTED_USER_EMAIL = "robbie.williams.92@mail.ru";
    private static final String SENT_TO_USER_NAME = "Ануар Омаров";
    private static final String SEND_TO_USER_EMAIL = "gg-poster@mail.ru";
    private static final String LETTER_THEME = "WebDriverTest";
    private static final String LETTER_TEXT = "Hello! It's a Mail.Ru Test";


    static final User expectedUser = new User(EXPECTED_USER_NAME, EXPECTED_USER_EMAIL);
    static final User sentToUser = new User(SENT_TO_USER_NAME, SEND_TO_USER_EMAIL);
    static final Letter expectedLetter = new Letter(EXPECTED_USER_EMAIL, SEND_TO_USER_EMAIL, LETTER_THEME, LETTER_TEXT);
    static Steps steps;

    @BeforeSuite
    public static void beforeSuite() {
        steps = new Steps();
        steps.initBrowser();
    }

    @AfterSuite
    public static void afterSuite() {
        steps.closeDriver();
    }


}
