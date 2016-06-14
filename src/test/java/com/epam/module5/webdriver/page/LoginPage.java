package com.epam.module5.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{

    private static final String URL = "http://www.mail.ru";

    @FindBy(xpath = "//input[@id='mailbox__login']")
    private WebElement inputUser;

    @FindBy(xpath = "//input[@id='mailbox__password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='mailbox__auth__button']")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.get(URL);
    }

    public MailPage login(String user, String password) {
        inputUser.sendKeys(user);
        inputPassword.sendKeys(password);
        buttonLogin.click();
        return new MailPage(driver);
    }


}
