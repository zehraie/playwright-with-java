package com.cydeo.tests.day_04.pac_02_waits_actions;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P01_PoMPractice {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://library1.cydeo.com");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }


    @Test
    void test1() {
    }
}
