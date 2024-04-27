package com.cydeo.tests.day_02.pac_01_multipeElement_checkbox_radio;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P02_findElements {
    @Test
    void name() {
        Playwright playwright=Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/abtest");
        // see all link on the page
        // querySelectorAll  = list of element
        List<ElementHandle> links = page.querySelectorAll("//a");
        for (ElementHandle each : links){
            System.out.println(each.getAttribute("href"));

        }
        // BrowserUtils.sleepWithPage(page,1);
        BrowserUtils.sleepWithThread(3);

        page.close();
        browser.close();
        playwright.close();

    }
}
