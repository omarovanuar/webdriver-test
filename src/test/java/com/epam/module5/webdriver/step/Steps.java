package com.epam.module5.webdriver.step;

import com.epam.module5.webdriver.driver.ChromeDriverFactory;
import com.epam.module5.webdriver.driver.FirefoxDriverFactory;
import com.epam.module5.webdriver.driver.WebDriverFactory;
import com.epam.module5.webdriver.entity.Letter;
import com.epam.module5.webdriver.entity.User;
import com.epam.module5.webdriver.page.*;
import com.epam.module5.webdriver.setting.Settings;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    private Letter createdLetter;
    private WebDriver driver;

    public void initBrowser()
    {
        driver = getFactory(Settings.getArgs4jSettingsInstance().browserName).createDriver();
    }

    private WebDriverFactory getFactory(String factory) {
        if (factory == null) {
            return new FirefoxDriverFactory();
        }
        switch (factory) {
            case "chrome":
                return new ChromeDriverFactory();
            default:
                return new FirefoxDriverFactory();
        }
    }

    public void closeDriver()
    {
        driver.quit();
    }

    public void loginMailRu(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(login, password);
    }

    public boolean isPageContains(String pagePart) {
        MailPage mailPage = new MailPage(driver);
        return mailPage.getTitle().contains(pagePart);
    }

    public boolean isEmailValid(User user) {
        return new MailPage(driver).getUserEmail().equals(user.getEmail());
    }

    public boolean isEmailValidInEdit(User user) {
        return new LetterEditPage(driver).getUserToEmail().equals(user.getEmail());
    }

    public boolean isEmailValidInSent(User user) {
        return new SentLetterEditPage(driver).getUserToEmail().equals(user.getEmail());
    }

    public void createAndFillNewLetter(String to, String theme, String text) {
        MailPage mailPage = new MailPage(driver);
        LetterEditPage letterPage = mailPage.createNewLetter();
        letterPage.fillLetterFields(to, theme, text);
    }

    public boolean isLetterValid(Letter letter) {
        LetterEditPage letterPage = new LetterEditPage(driver);
        createdLetter = letterPage.getLetter();
        return createdLetter.equals(letter);
    }

    public void saveLetter() {
        LetterEditPage letterEditPage = new LetterEditPage(driver);
        letterEditPage.saveToDraft();
    }

    public boolean isLetterSaved() {
        LetterEditPage editPage = new LetterEditPage(driver);
        return editPage.isSavedToDraftMessageAppeared();
    }

    public void viewLetterFromDraft() {
        MailPage mailPage = new MailPage(driver);
        DraftPage draftPage = mailPage.draftPageView();
        createdLetter.setId(draftPage.getLetterId());
        draftPage.chooseSavedLetter();
    }

    public void sendLetter() {
        LetterEditPage letterEditPage = new LetterEditPage(driver);
        letterEditPage.sendLetter();
    }
    public boolean isSavedLetterSent() {
        LetterEditPage editPage = new LetterEditPage(driver);
        return editPage.isSent();
    }

    public boolean checkLetterInDraft() {
        MailPage mailPage = new MailPage(driver);
        DraftPage draftPage = mailPage.draftPageView();
        return !draftPage.isDraftEmpty() && draftPage.getLetterId().equals(createdLetter.getId());

    }

    public void viewLetterFromSent() {
        MailPage mailPage = new MailPage(driver);
        SentPage sentPage = mailPage.sentPageView();
        sentPage.editSentLetter();
    }

    public void logoutMailRu() {
        MailPage mailPage = new MailPage(driver);
        mailPage.logout();
    }


}
