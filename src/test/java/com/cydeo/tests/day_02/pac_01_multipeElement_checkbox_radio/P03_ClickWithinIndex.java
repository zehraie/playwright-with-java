package com.cydeo.tests.day_02.pac_01_multipeElement_checkbox_radio;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_ClickWithinIndex {
    @Test
    void name() {
        Playwright playwright=Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/");

        List<ElementHandle> elementHandles = page.querySelectorAll(".container li a");

        System.out.println("elementHandle size= "+elementHandles.size());

      //  page.locator(".container li a")  // all link start with a
                //.first()
               // .last()
//                .nth(4)
//                .click();
        for (int i = 0; i < elementHandles.size(); i++) {
            Locator locator = page.locator(".container li a").nth(i);

            if (locator.textContent().equals("A/B Testing")) {

                page.locator(".container li a")
                        // .first()
                        //  .last()
                        .nth(i)
                        .click();

                break;
            }


        }

        BrowserUtils.sleepWithThread(3);

        page.close();
        browser.close();
        playwright.close();

    }
}
