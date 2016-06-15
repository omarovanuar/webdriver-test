package com.epam.module5.webdriver.page;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MailPage extends Page {
    @FindBy(xpath = "//a[@class='b-toolbar__btn js-shortcut']")
    private WebElement newLetterButton;

    @FindBy(xpath = "//a[@href='/messages/drafts/']")
    private WebElement draftLettersLink;

    @FindBy(xpath = "//a[@href='/messages/sent/']")
    private WebElement sentLettersLink;

    @FindBy(xpath = "//a[@id='PH_logoutLink']")
    private WebElement logoutLink;

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

    public DraftPage isDraftPageLinkDisplayed() throws InterruptedException {
        Thread.sleep(200);
        draftLettersLink.click();
        return new DraftPage(driver);
    }

    public SentPage sentPageView() {
        sentLettersLink.click();
        return new SentPage(driver);
    }

    public LoginPage logout() {
        logoutLink.click();
        return new LoginPage(driver);
    }
}
