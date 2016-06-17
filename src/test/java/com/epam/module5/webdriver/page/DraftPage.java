package com.epam.module5.webdriver.page;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftPage extends Page {

    @FindBy(xpath = "//a[@data-subject='WebDriverTest']")
    private WebElement savedLetterLink;

    @FindBy(xpath = "//div[@class='b-datalist b-datalist_letters b-datalist_letters_to']/child::div[last()]/div")
    private WebElement letterIdDiv;

    @FindBy(xpath = "//div[@class='b-datalist b-datalist_letters b-datalist_letters_to']/child::div[last()]")
    private WebElement letterListDiv;


    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LetterEditPage chooseSavedLetter() {
        savedLetterLink.click();
        return new LetterEditPage(driver);
    }

    public String getLetterId(){
        return (new WebDriverWait(driver, 20)).until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver webDriver) {
                return letterIdDiv.getAttribute("data-Id");
            }
        });
    }

    public boolean isDraftEmpty() {
        return letterListDiv.getAttribute("class").equals("b-datalist__empty");
    }
}
