package com.epam.module5.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentLetterEditPage extends Page{
    @FindBy(xpath = "//span[@class='b-letter__head__addrs__value']/span/span[1]")
    private WebElement letterSentToSpan;

    public SentLetterEditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUserToEmail() {
        return letterSentToSpan.getText();
    }
}
