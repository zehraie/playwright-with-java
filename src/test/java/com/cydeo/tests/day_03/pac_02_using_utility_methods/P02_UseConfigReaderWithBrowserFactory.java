package com.cydeo.tests.day_03.pac_02_using_utility_methods;

import com.cydeo.utils.BrowserFactory;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

public class P02_UseConfigReaderWithBrowserFactory {

    static private Playwright playwright;
    static private Browser browser;

     private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();

        String browser1FromConfig = ConfigurationReader.getProperty("browser");
        browser = BrowserFactory.getBrowser(browser1FromConfig, playwright);
        System.out.println("browser1FromConfig = " + browser1FromConfig);
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {
        page = browser.newContext().newPage();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(2);
        page.close();
    }

    @Test
    void test1() {
        page.navigate(ConfigurationReader.getProperty("googleURL"));
    }
}
