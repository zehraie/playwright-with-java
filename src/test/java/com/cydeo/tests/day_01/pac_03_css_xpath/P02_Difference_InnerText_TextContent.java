package com.cydeo.tests.day_01.pac_03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class P02_Difference_InnerText_TextContent {
    @Test
    void name() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("http://localhost:63342/playwright-with-java/getText.html?_ijt=qnf6gvvhsisr7fehv33nehd7gq&_ij_reload=RELOAD_ON_SAVE");

        String textContent = page.querySelector("#example").textContent();
        String innerText = page.querySelector("#example").innerText();

        System.out.println("textContent = " + textContent);
        System.out.println("innerText = " + innerText);

        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();

    }
}
