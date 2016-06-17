package com.epam.module5.webdriver.runner;

import com.epam.module5.webdriver.setting.Settings;
import com.epam.module5.webdriver.test.BaseTest;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Settings settings = Settings.getArgs4jSettingsInstance();
        CmdLineParser cmdLineParser = new CmdLineParser(settings);
        try {
            cmdLineParser.parseArgument(args);
            System.out.println("Settings: " + settings);
        } catch (CmdLineException e) {
            System.out.println("Invalid arguments: " + e.getMessage());
            cmdLineParser.printUsage(System.out);
        }

        TestNG testng = new TestNG();
        for (XmlSuite suite : new Parser(settings.pathToTestNG).parseToList()) {
            testng.setCommandLineSuite(suite);
        }
        testng.run();
    }

}

