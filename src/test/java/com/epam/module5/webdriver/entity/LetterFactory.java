package com.epam.module5.webdriver.entity;

public class LetterFactory {
    public static Letter create(String userFrom, String userTo, String theme, String text) {
        return new Letter(userFrom, userTo, theme, text);
    }
}
