package com.cydeo.tests.day_04.pac_01_upload_actions_js;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import org.junit.jupiter.api.*;

public class P02_Hover {


    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/hovers");
    }

    @Test
    void test1() {
        Driver.getPage().locator("img").nth(0).hover();
        BrowserUtils.sleepWithThread(2);
        System.out.println(Driver.getPage().locator("//h5").nth(0).textContent());

        Driver.getPage().locator("img").nth(1).hover();
        BrowserUtils.sleepWithThread(2);
        System.out.println(Driver.getPage().locator("//h5").nth(1).textContent());


        Driver.getPage().locator("img").nth(2).hover();
        BrowserUtils.sleepWithThread(2);
        System.out.println(Driver.getPage().locator("//h5").nth(2).textContent());

        /*
            @Test
    void inALoop() {

        for(int i = 0; i <3; i++){
            Driver.getPage().locator("img").nth(i).hover();
            BrowserUtils.sleepWithThread(2);
            System.out.println("Driver.getPage().locator(\"h5\").first() = " + Driver.getPage().locator("h5").first().textContent());

        }
    }
         */
    }
    @Test
    void test2() {
        /* selenium
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(webelemnt);

         */

        ElementHandle firstImage = Driver.getPage().locator("(//img)[1]").elementHandle()
                ;
        ElementHandle firstImageName = Driver.getPage().querySelector("(//h5)[1]");
        BrowserUtils.sleepWithThread(2);

        firstImage.hover();
        System.out.println(firstImageName.isVisible());
        Assertions.assertTrue(firstImageName.isVisible());

    }

    @AfterEach
    void tearDown() {
        Driver.closeDriver();
    }
}
