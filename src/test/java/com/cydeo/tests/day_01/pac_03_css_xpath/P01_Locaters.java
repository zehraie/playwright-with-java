package com.cydeo.tests.day_01.pac_03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class P01_Locaters {
    @Test
    void name() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        //if you want to see browser pass this line below
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://login1.nextbasecrm.com/");   //Authorization

        page.querySelector("[name='USER_LOGIN']").fill("incorrectuser");

        page.waitForTimeout(5000);
        page.querySelector("[name=USER_PASSWORD]").fill("incorrectpassword");
        page.waitForTimeout(5000);
        page.querySelector(".login-btn").click();

        String errorMessage = page.querySelector(".errortext").textContent();
        System.out.println("errorMessage="+errorMessage);


        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();
    }
}
