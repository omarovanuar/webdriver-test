package com.epam.module5.webdriver.page;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return (new WebDriverWait(driver, 20)).until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver webDriver) {
                return webDriver.getTitle();
            }
        });
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

}
