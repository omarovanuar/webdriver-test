package com.epam.module5.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage extends Page {
    @FindBy(xpath = "//a[@data-subject='WebDriverTest']")
    private WebElement savedLetterLink;

    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LetterEditPage editSavedLetter() {
        savedLetterLink.click();
        return new LetterEditPage(driver);
    }
}
