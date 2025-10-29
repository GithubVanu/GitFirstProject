
package com.centralvista.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.Alliedgenerallspage;
import com.centralvista.pages.Login;
import com.centralvista.pages.Ministrymemberpage;
import com.centralvista.testBase.TestBase;
import com.centralvista.utility.DatePickers;
import com.centralvista.utility.ScrollUtil;
import com.centralvista.utility.ToastUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class Alliedgenerallstest extends TestBase
{
	Login login;
	Alliedgenerallspage page;
	excelReader reader;
	DatePickers datePicker;
	
	JavascriptExecutor js;
	WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
	
	private static final Logger LOGGER = LogManager.getLogger(Alliedgenerallspage.class);

	private static final String SHEET_NAME = "AddAlliedGeneralls";
	

	public Alliedgenerallstest() throws FileNotFoundException
	{
		super();
	}
	@BeforeClass(alwaysRun = true)
	public void setUpAndSwitchRole() throws IOException, InterruptedException 
	{
		//This function is used to resolve the issue webdriver is null
		 initialization(); 
		 
		page = new Alliedgenerallspage(TestBase.getDriver());
		datePicker = new DatePickers(TestBase.getDriver());
		js = (JavascriptExecutor) TestBase.getDriver();
		reader = new excelReader("G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\TestData.xlsx");
		
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		
		
	    int row = 9;
		page.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		page.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		page.clickLogin();
		
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("ALLIED_GEN_ADM");

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/a/div/span")))
				.click();
		//This function is of clicking on the sidebar
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/div/a[1]/div/span"))).click();
		System.out.println("Logger class = " + LOGGER.getClass());
	}
	@AfterMethod
	public void cleanup() 
	{
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		try {
			wait.until(
					ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div/div")));
		} catch (Exception ignored) {
		}
		TestBase.getDriver().manage().deleteAllCookies();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/a/div/span")))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/div/a[1]/div/span"))).click();
	}
	
	private void fillFormData(int row) throws Exception
	{
		 try {
		        LOGGER.info("Filling form for row: " + row);
		        WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
		        page.setFullName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		        page.setFathername(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		        page.setMothername(reader.getCellvalue(SHEET_NAME, row, 2).trim());
		        page.setGender(reader.getCellvalue(SHEET_NAME, row, 3).trim());
		        datePicker.selectdob(reader.getdatevalue(SHEET_NAME, row, 4).trim());
		        page.setEmail(reader.getCellvalue(SHEET_NAME, row, 5).trim());
		        page.setAadhaarCardNumber(reader.getCellvalue(SHEET_NAME, row, 6));
		        page.setContactNumber(reader.getCellvalue(SHEET_NAME, row, 7));
		        page.setAlternateContactNumber(reader.getCellvalue(SHEET_NAME, row, 8));
		        page.setBloodgroup(reader.getCellvalue(SHEET_NAME, row, 9).trim());
		        page.setIdentificationMark(reader.getCellvalue(SHEET_NAME, row, 10).trim());
		        page.setEmployementID(reader.getCellvalue(SHEET_NAME, row, 11).trim());
		        datePicker.selectservicedate(reader.getdatevalue(SHEET_NAME, row, 12).trim());
		        datePicker.selectenddate(reader.getdatevalue(SHEET_NAME, row, 13).trim());
		        page.setAgency(reader.getCellvalue(SHEET_NAME, row, 14).trim());
		      	page.setDesignationId(reader.getCellvalue(SHEET_NAME, row, 15).trim());
		        page.setCategory(reader.getCellvalue(SHEET_NAME, row, 16).trim());
		        page.setOfficeContact(reader.getCellvalue(SHEET_NAME, row, 17).trim());
		        page.setFaxNumber(reader.getCellvalue(SHEET_NAME, row, 18).trim());
		        page.setSecretariat(reader.getCellvalue(SHEET_NAME, row, 19).trim());
		        page.setPermanentFlatNumber(reader.getCellvalue(SHEET_NAME, row, 20).trim());
		        page.setPermanentLocality(reader.getCellvalue(SHEET_NAME, row, 21).trim());
		        page.setPermanentState(reader.getCellvalue(SHEET_NAME, row, 22).trim());
		        page.setPermanentCity(reader.getCellvalue(SHEET_NAME, row, 23).trim());
		        page.setPermanentPincode(reader.getCellvalue(SHEET_NAME, row, 24).trim());
		        page.setCurrentFlatNumber(reader.getCellvalue(SHEET_NAME, row, 25).trim());
		        page.setCurrentLocality(reader.getCellvalue(SHEET_NAME, row, 26).trim());
		        page.setCurrentState(reader.getCellvalue(SHEET_NAME, row, 27).trim());
		        page.setCurrentCity(reader.getCellvalue(SHEET_NAME, row, 28).trim());
		        page.setCurrentPincode(reader.getCellvalue(SHEET_NAME, row, 29).trim());
		        WebElement checkbox = TestBase.getDriver().findElement(By.id("flexCheckDefault"));
		        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
		        Thread.sleep(500); // Optional wait
		        js.executeScript("arguments[0].click();", checkbox);
		        LOGGER.info("Form filled successfully for row: " + row);
		    } catch (Exception e) {
		        LOGGER.error("❌ Error at row " + row + ": " + e.getMessage(), e);
		        // Stop test
		        Assert.fail("Form filling failed at row " + row + ": " + e.getMessage());
		    }
		}
	
	
	@Test(priority = 1, groups = "regression")
	@Description("Verify Allied General LS can be registered successfully with valid data")
	@Epic("TG001")
	@Feature("allied general ls Dashboard - Add New Member")
	@Severity(SeverityLevel.BLOCKER)
	public void valid_registration() throws Exception 
	{
		int row = 1;
		fillFormData(row);
		page.clickSubmit();
		String expected =  reader.getCellvalue(SHEET_NAME, row, 30);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 2, groups = "regression")
	@Description("verify allied general ls registration with existing contact")
	@Epic("TG002")
	@Feature("allied general ls Dashboard - Add New member")
	@Severity(SeverityLevel.CRITICAL)
	@Step()
	public void invalid_registration_existingcontact() throws Exception {
		TestBase.getDriver().navigate().refresh();
		js.executeScript("window.scrollTo(0, 0);");
		int row = 2;
		fillFormData(row);
		page.clickSubmit();
		String expected =  reader.getCellvalue(SHEET_NAME, row, 30);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 3, groups = "regression")
	@Description("Verify allied general ls registration with existing email")
	@Epic("TG003")
	@Feature("allied general ls Dashboard - Add New member")
	@Severity(SeverityLevel.CRITICAL)
	public void invalid_registration_existingemail() throws Exception {
		TestBase.getDriver().navigate().refresh();
		js.executeScript("window.scrollTo(0, 0);");
		int row = 3;
		fillFormData(row);
		page.clickSubmit();
		String expected =  reader.getCellvalue(SHEET_NAME, row, 30);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 4, groups = "regression")
	@Description("Verify allied general ls registration with existing aahaar")
	@Epic("TG004")
	@Feature("allied general ls Dashboard - Add New member")
	@Severity(SeverityLevel.CRITICAL)
	public void invalid_registration_existingaadhaar() throws Exception {
		TestBase.getDriver().navigate().refresh();
		js.executeScript("window.scrollTo(0, 0);");
		int row = 4;
		fillFormData(row);
		page.clickSubmit();
		String expected =  reader.getCellvalue(SHEET_NAME, row, 30);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
		Thread.sleep(5000);
	}
	
	@Test(priority = 5, groups = "regression")
	@Description("Verify allied general ls registration with existing employee id")
	@Epic("TG005")
	@Feature("allied general ls Dashboard - Add New member")
	@Severity(SeverityLevel.CRITICAL)
	public void invalid_registration_existingemployeeid() throws Exception {
		TestBase.getDriver().navigate().refresh();
		js.executeScript("window.scrollTo(0, 0);");
		int row = 5;
		fillFormData(row);
		page.clickSubmit();
		String expected =  reader.getCellvalue(SHEET_NAME, row, 30);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
		Thread.sleep(5000);
		
	}
	
	/**/
	
	@Test(priority = 6, groups = "regression")
	@Description("Verify allied general lsis able to Update fascia of employee")
	@Epic("TG006")
	@Feature("allied general ls Dashboard - Update fascia of employee")
	@Severity(SeverityLevel.CRITICAL)
	public void updated_fascia_employeeid() throws Exception 
	{
		
		TestBase.getDriver().navigate().refresh();
		/*
		 int row =1;
		js.executeScript("window.scrollTo(0, 0);");
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		
		ScrollUtil.scrollUntilElementVisible(TestBase.getDriver(), page.clickAlliedGeneral);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Allied General'"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//parent::div[@class='dropdown-container expand']//following::div//span[contains(text(),'General LS List')]"))).click();
		
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 11);
		
		page.setSearchlist(searchValue);
		
		System.out.println("I am search vlaue from sheet->"+searchValue);
		
		Thread.sleep(2000);
		
		*/
		
		int row =1;
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 11);
		
		page.updateAlliedGeneralFasciaLS(searchValue);
	
	}
	
	
	
	
	@Test(priority = 7, groups = { "sanity", "regression" })
	@Description("Verify that user is able to sent the icard request not by passing all correct  value")
	@Epic("TG007")
	@Feature("Allied general LS Dashboard - I Card Request")
	@Severity(SeverityLevel.CRITICAL)
	public void allied_general_requestcard() throws Exception {
		LOGGER.info("I-card request for Allied General LS");
		
		int row =1;
		js.executeScript("window.scrollTo(0, 0);");
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//parent::div[@class='dropdown-container expand']//following::div//span[contains(text(),'General LS List')]"))).click();
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 11);
		page.setSearchlist(searchValue);
		System.out.println("I am search vlaue from sheet->"+searchValue);
		Thread.sleep(2000);
	    page.clickIcarRequest();
	  	page.setRequestType("New Card");
	  	page.selectRecommendingAuthority("000506");
	  	/*String photoPath = "E:\\Automation Selenium\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\photo.jpg";
		page.uploaddocument(photoPath);
		page.setremark("request Initiate");
		page.setBuiling("New Parliament");
		page.selectRoom("All Rooms"); 
		page.IcarRequestButton(); */
//		WebElement toast = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
//		String actual = toast.getText();
		String exceptMessage = "Application successfully forwarded to recommender";

		ToastUtil.validateToastMessage(TestBase.getDriver(), exceptMessage);
	}
		
}
