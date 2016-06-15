package com.epam.module5.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{

    private static final String URL = "http://www.mail.ru";

    @FindBy(xpath = "//input[@id='mailbox__login']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='mailbox__password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='mailbox__auth__button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.get(URL);
    }

    public MailPage login(String user, String password) {
        usernameInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MailPage(driver);
    }


}
