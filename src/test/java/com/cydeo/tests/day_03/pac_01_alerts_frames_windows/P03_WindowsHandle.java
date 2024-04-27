package com.cydeo.tests.day_03.pac_01_alerts_frames_windows;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

public class P03_WindowsHandle {
    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
               // .setSlowMo(1000)      //DONOT use with windows handele or use promise
        );
    }


    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }


    @BeforeEach
    void setUp() {
       // page = browser.newContext().newPage();
        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/windows");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(2);
        page.close();
    }

    @Test
    void test1() {  // search with waitfor Po

       //page.pause();       //!!!!!!! debug yapariz one by one
        //get the title

        System.out.println("before clicking page title =="+page.title());
        String header = page.locator("//h3").textContent();
        System.out.println("header" +header);

        //click Click Here button( it will open a new page)
        
      //  page.click("text=Click Here");  // 1_First option clicking the locatere
        ElementHandle locater = page.querySelector("text=Click Here");
       locater.click();


        //get second window title
        BrowserUtils.sleepWithThread(3);
        Page secondPage =page.waitForPopup(() -> {});
        // asagisi alternatif yapildi
//        Page secondPage = page.waitForPopup(() -> {
//            page.getByText("Click Here").click();
//        });
        System.out.println("after clicking the second page title"+ secondPage.title());

        //go back to first page
page.bringToFront();  // gidip GELME ICIN KULLNIYOR
BrowserUtils.sleepWithThread(1);
//        BrowserUtils.sleepWithThread(3);
//        secondPage.bringToFront();
//        BrowserUtils.sleepWithThread(3);

        page.bringToFront();
        //Click home
        page.click("text=Home");
        BrowserUtils.sleepWithThread(1);

        //get the title again
        System.out.println("practice title"+page.title());

    }
}
