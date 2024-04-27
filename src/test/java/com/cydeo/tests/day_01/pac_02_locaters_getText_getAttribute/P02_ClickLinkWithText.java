package com.cydeo.tests.day_01.pac_02_locaters_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class P02_ClickLinkWithText {
    @Test
    void name() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        //if you want to see browser pass this line below
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/");
        // vewPort you can set your browser
       // page.setViewportSize(1920, 1080);
        page.waitForTimeout(3000);
        // clicking the locater
        page.click("text=A/B Testing");
        page.waitForTimeout(2000);
        page.goBack();
        page.waitForTimeout(2000);
        page.click("text=Autocomplete");
        page.waitForTimeout(2000);
        System.out.println(page.title());

        page.close();
        browser.close();
        playwright.close();
    }
}
