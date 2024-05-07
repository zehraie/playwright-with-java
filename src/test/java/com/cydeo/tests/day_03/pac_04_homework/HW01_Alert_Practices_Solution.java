package com.cydeo.tests.day_03.pac_04_homework;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import java.util.List;

public class HW01_Alert_Practices_Solution {

    @Test
    public void confirmation_alert_test2(){
        //TC #2: Confirmation alert practice

        Driver.getPage().navigate("https://practice.cydeo.com/javascript_alerts");
        BrowserUtils.sleepWithThread(3);
        String title1 = Driver.getPage().title();
        System.out.println("title1 = " + title1);

        Driver.getPage().locator("button").nth(0).click();
        String title2 = Driver.getPage().title();
        System.out.println("title2 = " + title2);

        //3. Click to “Click for JS Prompt” button
Driver.getPage().locator("//button").last().click();
        String title3 = Driver.getPage().title();
        System.out.println("title3 = " + title3);



        //4. Type "prompt" and click to OK button from the alert


        //5. Verify “You entered: prompt” text is displayed.

        Driver.closeDriver();

    }



}




