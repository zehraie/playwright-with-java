package com.cydeo.tests.day_02.pac_02_dropdowns;

import com.cydeo.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;

public class P02_DropdownSelectOption {
    @Test
    void test1() {
            Playwright playwright = Playwright.create();

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://practice.cydeo.com/dropdown");
            Locator yearDropdown = page.locator("#year");
            Locator monthDropdown = page.locator("#month");
            Locator dayDropdown = page.locator("#day");
            String expectedYear="1988";
            String expectedMonth="January";
            int expectedDay=12;

            BrowserUtils.sleepWithThread(1);
            //select with value
            yearDropdown.selectOption(new SelectOption().setValue(expectedYear));
            BrowserUtils.sleepWithThread(1);
            //select with text(label)
            monthDropdown.selectOption(new SelectOption().setLabel(expectedMonth));
            BrowserUtils.sleepWithThread(1);
            //select with index
            dayDropdown.selectOption(new SelectOption().setIndex(expectedDay-1));

            BrowserUtils.sleepWithThread(3);
   //Bu code calismiyour
//            String actualYear = page.evaluate("el=>el.selectedOptions[0].text", yearDropdown).toString();
//            String actualMonth = page.evaluate("el=>el.selectedOptions[0].text", monthDropdown).toString();
//            String actualDay = page.evaluate("el=>el.selectedOptions[0].text", dayDropdown).toString();

                    String actualYear = page.evaluate("el=>el.selectedOptions[0].text", yearDropdown.elementHandle()).toString();
            String actualMonth = page.evaluate("el=>el.selectedOptions[0].text", monthDropdown.elementHandle()).toString();
            String actualDay = page.evaluate("el=>el.selectedOptions[0].text", dayDropdown.elementHandle()).toString();
//
//        String actualYear = yearDropdown.evaluate("el => el.selectedOptions[0].innerText").toString();
//        String actualMonth = monthDropdown.evaluate("el => el.selectedOptions[0].innerText").toString();
//        String actualDay = dayDropdown.evaluate("el => el.selectedOptions[0].innerText").toString();

   //     String visibleYear = page.evaluate("element => element.selectedOptions[0].text", yearDropdown).toString();
//        String visibleMonth = page.evaluate("element => element.selectedOptions[0].text", month).toString();
//        String visibleDay = page.evaluate("element => element.selectedOptions[0].text", day).toString();

//        String actualYear = page.evaluate("document.querySelector('#year').value").toString();
//        String actualMonth = page.evaluate("document.querySelector('#month').value").toString();
//        String actualDay = page.evaluate("document.querySelector('#day').value").toString();

            int month_as_int = Integer.parseInt(page.evaluate("document.querySelector('#month').value").toString())+1;
            System.out.println("Month from DOM: " +month_as_int);
            System.out.println("actualYear = " + actualYear);
            System.out.println("actualMonth = " + actualMonth);
            System.out.println("actualDay = " + actualDay);
            page.close();
            browser.close();

            playwright.close();
    }
}
