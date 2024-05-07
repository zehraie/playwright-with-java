package com.cydeo.tests.day_03.pac_03_using_singleton_with_palywright;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.Test;

public class P02_LoginFormWithSingleton {
    @Test
    void test1() {
        Driver.getPage().navigate(ConfigurationReader.getProperty("cydeoLoginURL"));
        Driver.getPage().locator("input").first().fill("tomsmith");
        Driver.getPage().locator("input").last().fill("SuperSecretPassword");
        Driver.getPage().getByTestId("wooden_spoon").click();

        // Get the page title
        String pageTitle = Driver.getPage().title();
        System.out.println("Page Title after login: " + pageTitle);

        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }
}
