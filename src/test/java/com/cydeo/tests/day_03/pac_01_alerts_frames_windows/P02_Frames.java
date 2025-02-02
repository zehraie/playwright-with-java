package com.cydeo.tests.day_03.pac_01_alerts_frames_windows;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class P02_Frames {
    static private Playwright playwright;
    static private Browser browser;
    private Page page;
    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setSlowMo(3000));
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {
        page = browser.newPage();
     //   page.navigate("https://practice.cydeo.com/nested_frames ");  this is not used
        page.navigate("https://practice.cydeo.com/iframe");
    }

    @AfterEach
    void tearDown(){
        page.close();
    }
    @Test
    void test1() {

        FrameLocator firstIframe = page.frameLocator("#mce_0_ifr");
        firstIframe.locator("#tinymce").clear();
        BrowserUtils.sleepWithThread(2);
        firstIframe.locator("#tinymce").fill("Here is Adam");

       // page.locator("//p").textContent();  this line is wrong
        String text = firstIframe.locator("//p").textContent();
        System.out.println("text "+text);


        Assertions.assertEquals("Here is Adam",text);


        System.out.println(page.locator("//h3").textContent());



    }
}
