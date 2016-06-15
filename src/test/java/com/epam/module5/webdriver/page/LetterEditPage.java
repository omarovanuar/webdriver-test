package com.epam.module5.webdriver.page;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterEditPage extends Page{
    @FindBy(xpath = "//textarea[@class='js-input compose__labels__input']")
    private WebElement letterToTextarea;

    @FindBy(xpath = "//span[@data-text='gg-poster@mail.ru']/span")
    private WebElement letterToSpan;

    @FindBy(xpath = "//input[@class='compose__header__field']")
    private WebElement letterThemeInput;

    @FindBy(xpath = "//iframe[contains(@id, '_composeEditor_ifr')]")
    private WebElement letterTextFrame;

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement letterTextBody;

    @FindBy(xpath = "//div[@class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']")
    private WebElement saveToDraftButton;

    @FindBy(xpath = "//div[@class='b-toolbar__message']")
    private WebElement letterSavedMessage;

    @FindBy(xpath = "//div[@class='b-toolbar__btn b-toolbar__btn_false js-shortcut']")
    private WebElement sendLetterButton;

    public LetterEditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void fillLetterFields(String to, String theme, String text) {
        letterToTextarea.sendKeys(to);
        letterThemeInput.sendKeys(theme);
        driver.switchTo().frame(letterTextFrame);
        letterTextBody.clear();
        letterTextBody.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public String getLetterToField() {
        return letterToSpan.getText();
    }

    public String getLetterThemeField() {
        return letterThemeInput.getAttribute("value");
    }

    public String getLetterTextField() {
        driver.switchTo().frame(letterTextFrame);
        String text = letterTextBody.getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public boolean isSavedToDraftMessageAppeared() {
        return (new WebDriverWait(driver, 10)).until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return letterSavedMessage.isDisplayed();
            }
        });
    }

    public void saveToDraft() {
        saveToDraftButton.click();
    }

    public void sendLetter() {
        sendLetterButton.click();
    }


}
