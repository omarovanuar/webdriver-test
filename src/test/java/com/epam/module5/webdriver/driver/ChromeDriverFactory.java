package com.epam.module5.webdriver.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ChromeDriverFactory extends WebDriverFactory{
    private static final String PATH_TO_CHROMEDRIVER = "D:\\drivers\\chromedriver\\chromedriver.exe";

    @Override
    public WebDriver createDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(PATH_TO_CHROMEDRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        driver = new ChromeDriver(service);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
