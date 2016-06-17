package com.epam.module5.webdriver.driver;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverFactory {
    protected WebDriver driver;

    public abstract WebDriver createDriver();
}
