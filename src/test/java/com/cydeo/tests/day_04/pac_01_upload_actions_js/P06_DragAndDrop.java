package com.cydeo.tests.day_04.pac_01_upload_actions_js;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P06_DragAndDrop {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/drag_and_drop_circles");

    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        // get make ready target and source
        //draggable
        Locator source = Driver.getPage().getByTestId("draggable");
        Locator target = Driver.getPage().getByTestId("droptarget");
        System.out.println("before drag and drop = " + target.textContent());
        source.dragTo(target);

        System.out.println("after drag and drop = " + target.textContent());

        Assertions.assertEquals("You did great!", target.textContent());

    }

    @Test
    void test2() {
        //draggable
        Locator source = Driver.getPage().getByTestId("draggable");
        Locator target = Driver.getPage().getByTestId("droptarget");
        System.out.println("before drag and drop = " + target.textContent());
        source.click();
        Driver.getPage().mouse().down();  // means go with, click down - press not direction
        BrowserUtils.sleepWithThread(3);
        Driver.getPage().mouse().move(500, 200);
        BrowserUtils.sleepWithThread(2);
        Driver.getPage().mouse().up();   // means release the mouse  =

        System.out.println("after drag and drop = " + target.textContent());

        Assertions.assertEquals("You did great!", target.textContent());

    }}
