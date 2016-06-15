package com.epam.module5.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentPage extends Page {
    @FindBy(xpath = "//a[@data-subject='WebDriverTest']")
    private WebElement sentLetterLink;

    public SentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LetterEditPage editSentLetter() {
        sentLetterLink.click();
        return new LetterEditPage(driver);
    }
}
