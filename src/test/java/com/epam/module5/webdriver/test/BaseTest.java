package com.epam.module5.webdriver.test;

import com.epam.module5.webdriver.entity.Letter;
import com.epam.module5.webdriver.entity.LetterFactory;
import com.epam.module5.webdriver.entity.User;
import com.epam.module5.webdriver.entity.UserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String EXPECTED_USER_NAME = "Robbie Williams";
    private static final String EXPECTED_USER_EMAIL = "robbie.williams.92@mail.ru";
    private static final String SENT_TO_USER_NAME = "Ануар Омаров";
    private static final String SEND_TO_USER_EMAIL = "gg-poster@mail.ru";
    private static final String LETTER_THEME = "WebDriverTest";
    private static final String LETTER_TEXT = "Hello! It's a Mail.Ru Test";

    static final User expectedUser = UserFactory.create(EXPECTED_USER_NAME, EXPECTED_USER_EMAIL);
    static final User sentToUser = UserFactory.create(SENT_TO_USER_NAME, SEND_TO_USER_EMAIL);
    static final Letter expectedLetter = LetterFactory.create(EXPECTED_USER_EMAIL, SEND_TO_USER_EMAIL, LETTER_THEME, LETTER_TEXT);
    static WebDriver driver = new FirefoxDriver();

    @BeforeSuite
    public static void beforeSuite() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public static void afterSuite() {
        driver.quit();
    }
}
