package com.cydeo.tests.day_01.pac_02_locaters_getText_getAttribute;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P03_GoogleSearch {
    @Test
    void name() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        //if you want to see browser pass this line below
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://ww.google.com");
        // locate the element
        Locator searchBoxElement = page.locator("textarea[name='q']");
        //searchBoxElement.type("Selenium");
      //  searchBoxElement.fill("Selenium");
       // searchBoxElement.pressSequentially("Selenium");  // like human writing
        searchBoxElement.pressSequentially("Selenium",
                new Locator.PressSequentiallyOptions().setDelay(100));
        // how to hit Enter
        Keyboard keyboard = page.keyboard();
        keyboard.press("Enter");

        page.waitForTimeout(2000);

        page.close();
        browser.close();
        playwright.close();


    }
}
