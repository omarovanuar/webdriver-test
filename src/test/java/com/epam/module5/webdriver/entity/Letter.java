package com.epam.module5.webdriver.entity;

public class Letter {
    private String userFrom;
    private String userTo;
    private String theme;
    private String text;

    public Letter() {
    }

    public Letter(String userFrom, String userTo, String theme, String text) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.theme = theme;
        this.text = text;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter = (Letter) o;

        if (userFrom != null ? !userFrom.equals(letter.userFrom) : letter.userFrom != null) return false;
        if (userTo != null ? !userTo.equals(letter.userTo) : letter.userTo != null) return false;
        if (theme != null ? !theme.equals(letter.theme) : letter.theme != null) return false;
        return text != null ? text.equals(letter.text) : letter.text == null;

    }

    @Override
    public int hashCode() {
        int result = userFrom != null ? userFrom.hashCode() : 0;
        result = 31 * result + (userTo != null ? userTo.hashCode() : 0);
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
