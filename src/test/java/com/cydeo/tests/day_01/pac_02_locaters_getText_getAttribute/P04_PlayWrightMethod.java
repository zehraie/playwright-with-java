package com.cydeo.tests.day_01.pac_02_locaters_getText_getAttribute;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P04_PlayWrightMethod {
    @Test
    void name() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        //if you want to see browser pass this line below
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://library2.cybertekschool.com/login.html");

        //Placeholder location
        //Placeholder incasesensitive
        Locator emailAddressElement = page.getByPlaceholder("Email address");
        // Locator emailAddressElement = page.getByPlaceholder("ail address");  // this code also work
        emailAddressElement.fill("incorrectemail@gmail.com");

        // page.getByPlaceholder("Email address", new Page.GetByPlaceholderOptions()
        //         .setExact(true)).fill("incorrectemail@gmail.com");

        //  how to locate password box
         page.getByLabel("Password").fill("incorrectpassword");
        //page.getByPlaceholder("Password").fill("incorrectPassword");
        // page.querySelector(#inputPassword").fill("incorrectPassword");   // id ile locate yapmak

        // click the sign in button, tek button old specific yapmaya gerek yok
        page.getByRole(AriaRole.BUTTON).click();
        // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in").setExact(true)).click();

        System.out.println(page.getByRole(AriaRole.ALERT).textContent());
        System.out.println(page.getByRole(AriaRole.ALERT).isVisible());
        page.waitForTimeout(3000);


        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();

    }
}
