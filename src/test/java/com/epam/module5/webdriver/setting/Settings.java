package com.epam.module5.webdriver.setting;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.kohsuke.args4j.Option;

public class Settings {
    private static Settings settings = new Settings();

    private Settings() {}

    @Option(name = "--testng", usage = "Set path to testng.xml file", required = true)
    public String pathToTestNG;

    @Option(name = "--browser", usage = "Set browser for execution: firefox, chrome. Default value: firefox")
    public String browserName;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public static Settings getArgs4jSettingsInstance() {
        return settings;
    }
}
