package com.cydeo.tests.day_01.pac_01_playwright_intro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P02_BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        //if you want to see browser pass this line below
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");
       // Thread.sleep(3000);
        page.waitForTimeout(3000);

        page.navigate("https://google.com");
        page.waitForTimeout(2000);


        page.goBack();
        page.waitForTimeout(2000);

        page.goForward();
        page.waitForTimeout(2000);

        page.reload();

        page.close();
        browser.close();
        playwright.close();
    }
}
