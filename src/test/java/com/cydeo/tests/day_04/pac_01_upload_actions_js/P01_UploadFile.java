package com.cydeo.tests.day_04.pac_01_upload_actions_js;

import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class P01_UploadFile {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/upload");
    }

    @Test
    void test1() {
        // whereis  the project       user directory                 this is my file path
        String pathOfFile = System.getProperty("user.dir") + "/src/test/resources/uploadtest.txt";
        Driver.getPage().getByTestId("file-upload").setInputFiles(Path.of(pathOfFile));
                                                   //.sendKeys(pathOfFile)// seleniumda
        /*
        more than one file
        Driver.getPage().getByTestId("file-upload")
        .setInputFiles(new Path[] {Paths.get(pathOfTxtFile), Paths.get(pathOfPdfSecondFile)});
         */

        // delete the file
     //   BrowserUtils.sleepWithThread(3);
        // Driver.getPage().getByTestId("file-upload").setInputFiles(new Path[0]);

        BrowserUtils.sleepWithThread(3);
        Driver.getPage().getByTestId("file-submit").click();
       System.out.println(Driver.getPage().locator("//h3").textContent());

        Assertions.assertEquals("File Uploaded!",Driver.getPage().locator("//h3").textContent() );

    }

    @AfterEach
    void tearDown() {
        Driver.closeDriver();
    }
}
