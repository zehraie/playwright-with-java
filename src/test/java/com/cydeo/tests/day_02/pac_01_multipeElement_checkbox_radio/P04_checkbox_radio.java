package com.cydeo.tests.day_02.pac_01_multipeElement_checkbox_radio;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P04_checkbox_radio {
    @Test
    void name() {
        Playwright playwright = Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/checkboxes");
        Locator checkBox1 = page.locator("#box1");
        Locator checkBox2 = page.locator("#box2");
        //Locator checkBox1 = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Checkbox 1"));
//getByrole not working because it is in span
        Locator checkBox11 = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setChecked(false));  // working

        System.out.println(checkBox1.isChecked());
        System.out.println(checkBox2.isChecked());
        BrowserUtils.sleepWithThread(3);

        checkBox1.click();
       // checkBox1.check();  // check will check if it is checkbox and tick it
      //  checkBox1.uncheck();
        checkBox2.click();
        BrowserUtils.sleepWithThread(3);
        System.out.println(checkBox2.isChecked());
        page.close();
        browser.close();
        playwright.close();
    }
}
