package com.cydeo.tests.day_03.pac_01_alerts_frames_windows;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

public class P01_AlertPractice {
    
    static private Playwright playwright;
    static private Browser browser;
    private Page page;
    @BeforeAll
    static void beforeAll() {
         playwright = Playwright.create();
        browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setSlowMo(5000));
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {
        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterEach
    void tearDown(){
        page.close();
    }

    @Test
    void test1() {
        page.navigate("https://practice.cydeo.com/javascript_alerts");
        page.locator("button").nth(0).click(); // or you can use first
        // we need to use before wesay accept the dialog but stull playwrigt autodissmed yani automatically explicitly deal with it
        page.onceDialog(d -> d.accept());

        String s = page.locator("#result").textContent();

        System.out.println("s "+ s);

    }

    @Test
    void test2() {
        page.onceDialog(dialog -> dialog.accept());   // koymasan  bu satiri cancell koyarsan okay basar
      //  page.locator("//button[.='Click for JS Confirm"']")....
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
        page.onceDialog(dialog -> dialog.accept());
        String s = page.locator("#result").textContent();
        System.out.println("s "+ s);

    }
}
