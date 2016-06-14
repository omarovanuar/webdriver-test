package com.epam.module5.webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
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
