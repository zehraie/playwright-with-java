package com.cydeo.tests.day_01.pac_02_locaters_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class p01_GetTitleAndGetUrl {

    // command+N  create automatically one test method  or Alt+insert  // or right click and click generete option
   @DisplayName("test1")
    @Test
    void name() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        //if you want to see browser pass this line below
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/");

        System.out.println( page.url());
       System.out.println(page.title());

       Assertions.assertTrue(page.url().contains("cydeo"));
       Assertions.assertEquals("Practice", page.title());

       page.waitForTimeout(3000);

       page.close();
       browser.close();
       playwright.close();

   }
}
