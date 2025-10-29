package com.centralvista.Listener;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
//import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.centralvista.testBase.TestBase;
import com.centralvista.utility.ScreenshotUtil;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.io.ByteArrayInputStream;

public class TestListener extends TestBase implements ITestListener{

	  public TestListener() throws IOException {
	        super();
	    }

	  @Override
	    public void onTestFailure(ITestResult result) {
	        if (TestBase.getDriver() != null) {
	            byte[] screenshot = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);

	            // ✅ THIS attaches it to Allure:
	            Allure.addAttachment("Failure Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");

	            System.out.println("Screenshot attached to Allure for: " + result.getName());
	        }
	    }
	}