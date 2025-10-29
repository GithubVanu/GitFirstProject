/* Creation Date July /2024
 * Author : Hemant Kumar Sharma 
 * Dept   : Embedded System
 */
package com.centralvista.testBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	protected static Properties CONFIG;
	 public static int explicitWait; // changes done by surendra
	//public static Properties Objects;
	public static Properties APPTEXT;
	//public static XSSFReader Core;
	public static XSSFWorkbook Core;
	public static XSSFWorkbook testData=null;
	public static XSSFReader DBresults=null;
	public static Random randomGenerator = new SecureRandom(); // Random Port Number generation 
	public static String currentTest;
	public static String keyword;
	//public static SeleniumServer server;
	//public static DefaultSelenium selenium=null;
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	    
	//public static EventFiringWebDriver driver=null;
	public static String object;
	public static String currentTSID;
	public static String stepDescription;
	public static String proceedOnFail;
	public static String testStatus;
	public static String data_column_name;
	public static int  testRepeat;
	public static int nSelPort;
	public static String sSelPort;
	public static Calendar cal = new GregorianCalendar();
	public static  int month = cal.get(Calendar.MONTH);
	public static int year = cal.get(Calendar.YEAR);
	public static  int sec =cal.get(Calendar.SECOND);
	public static  int min =cal.get(Calendar.MINUTE);
	public static  int date = cal.get(Calendar.DATE);
	public static  int day =cal.get(Calendar.HOUR_OF_DAY);
	public static String strDate;
	public static String result;
	public static String mailresult=" - Script successfully executed - no errors found";
	public static String mailscreenshotpath;

	
	public static String getCurrentTimeStamp()
    { 
          SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy"+"_"+"HH-mm-ss");
          Date now = new Date(); 
          String CDate = CurrentDate.format(now); 
          return CDate; 
    }


	
	public static WebDriver getDriver() {
        return driver.get();
    }

    /** ✅ Set driver for current thread */
    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

	public TestBase() throws FileNotFoundException
	
	{

	
	CONFIG=new Properties();
	FileInputStream fs = new FileInputStream("G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\config\\config.properties");
	try {
		CONFIG.load(fs);
		 explicitWait = Integer.parseInt(CONFIG.getProperty("explicitWait"));
	} catch (IOException e) {
		explicitWait = 10; // fallback default
        System.out.println("Could not load explicit wait. Using default");
		e.printStackTrace();
	}
	
	
	
	
	//System.out.println("----------------------------------------------------------------------------------------------------");
	//System.out.println("                                   TEST EXECUTION STARTED                                       ");
	//System.out.println("------------------------------------------------------------------------------------------------------ ");
	}
	 public static WebDriver initialization() {
	        String browser = CONFIG.getProperty("testBrowser");
	        WebDriver webDriver;

	        if ("firefox".equalsIgnoreCase(browser)) {
	            WebDriverManager.firefoxdriver().setup();
	            webDriver = new FirefoxDriver();
	        } else if ("chrome".equalsIgnoreCase(browser)) {
	            WebDriverManager.chromedriver().setup();
	            ChromeOptions options = new ChromeOptions();
	            webDriver = new ChromeDriver(options);
	        } else if ("ie".equalsIgnoreCase(browser)) {
	            WebDriverManager.iedriver().setup();
	            webDriver = new InternetExplorerDriver();
	        } else {
	            throw new RuntimeException("Unsupported browser: " + browser);
	        }

	        setDriver(webDriver); // store in ThreadLocal
	        getDriver().manage().window().maximize();
	        getDriver().get(CONFIG.getProperty("testSiteURL"));
	        return getDriver();
	    }

	   
	}
	
	
	