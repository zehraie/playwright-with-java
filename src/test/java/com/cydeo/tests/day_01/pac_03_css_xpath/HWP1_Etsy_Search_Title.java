package com.cydeo.tests.day_01.pac_03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class HWP1_Etsy_Search_Title {

    @Test
    void test1() {

        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        //Setting up our chromedriver using WebDriverManager
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        //Creating a new ChromeDriver and storing it in "driver"
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        //2. Go to https://www.etsy.com
        page.navigate("https://www.etsy.com");

        //3. Search for “wooden spoon”


        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”


        //close the page

        //close the browser

        //close the playwright
    }
}
