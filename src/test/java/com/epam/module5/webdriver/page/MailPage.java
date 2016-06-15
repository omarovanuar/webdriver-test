package com.epam.module5.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends Page {
    @FindBy(xpath = "//a[@class='b-toolbar__btn js-shortcut']")
    private WebElement newLetterButton;

    @FindBy(xpath = "//a[@href='/messages/drafts/']")
    private WebElement draftLettersLink;

    @FindBy(xpath = "//a[@href='/messages/sent/']")
    private WebElement sentLettersLink;

    @FindBy(xpath = "//a[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "//div[@class='x-ph__auth_list__item__info__email__text']")
    private WebElement userName;

    @FindBy(xpath = "//i[@id='PH_user-email']")
    private WebElement userEmail;

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LetterEditPage createNewLetter() {
        newLetterButton.click();
        return new LetterEditPage(driver);
    }

    public DraftPage draftPageView() {
        draftLettersLink.click();
        return new DraftPage(driver);
    }

    public SentPage sentPageView() {
        sentLettersLink.click();
        return new SentPage(driver);
    }

    public String getUserName() {
        return userName.getText();
    }

    public String getUserEmail() {
        return userEmail.getText();
    }

    public LoginPage logout() {
        logoutLink.click();
        return new LoginPage(driver);
    }
}
