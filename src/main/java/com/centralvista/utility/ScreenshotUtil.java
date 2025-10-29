package com.centralvista.utility;



import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void captureAndAttach(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

            // Save file
            FileUtils.copyFile(src, new File(path));

            // Attach to Allure using byte stream
            byte[] bytes = FileUtils.readFileToByteArray(src);
            Allure.addAttachment("Failure Screenshot: " + testName, "image/png", new ByteArrayInputStream(bytes), ".png");

        } catch (IOException e) {
            System.err.println("Screenshot error: " + e.getMessage());
        }
    }
    
}