/**
 * @author surendragangwar
 * @since 03-Sept-2025
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.test.VisitorAdmin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v119.page.model.NavigatedWithinDocument;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.Login;
import com.centralvista.pages.Ministrymemberpage;
import com.centralvista.pages.VisitorAdmin.VisitorRegistrationPage;
import com.centralvista.testBase.TestBase;
import com.centralvista.utility.DatePickers;
import com.centralvista.utility.ScrollUtil;
import com.centralvista.utility.ToastUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class VisitorRegistrationTest extends TestBase {
	
	VisitorRegistrationPage vpage;
	excelReader reader;
	DatePickers datePicker;
	JavascriptExecutor js;
	
	private static final Logger LOGGER = LogManager.getLogger(VisitorRegistrationPage.class);

	private static final String SHEET_NAME = "VisitorAdmin";

	public VisitorRegistrationTest() throws FileNotFoundException {
		
		// starts the driver
		   
		    vpage  = new VisitorRegistrationPage(TestBase.getDriver());
		    
		
	}

	@BeforeClass(alwaysRun = true)
	public void setUpAndSwitchRole() throws IOException, InterruptedException {
		 initialization();  
		//TestBase.getDriver().get(CONFIG.getProperty("testSiteURL")); 
		vpage = new VisitorRegistrationPage(TestBase.getDriver());
		datePicker = new DatePickers(TestBase.getDriver());
		reader = new excelReader("G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\TestData.xlsx");
		int row = 14;
		vpage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		vpage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		vpage.clickLogin();
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("VISITOR_ADMIN");

		wait.until(
				ExpectedConditions.elementToBeClickable(vpage.getRegistrationsidebar()))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(vpage.getRegistrrationlink())).click();
		System.out.println("Logger class = " + LOGGER.getClass());
	}	
	
	public void fillFormData(int row) throws Exception {
		 try {
		        LOGGER.info("Filling form for row: " + row);

		        WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));

		        vpage.setFullName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		        vpage.setfathername(reader.getCellvalue(SHEET_NAME, row, 1).trim());		        
		        vpage.selectType(reader.getCellvalue(SHEET_NAME, row, 2).trim());
		        vpage.setAadhaarnumber(reader.getCellvalue(SHEET_NAME, row, 3).trim());
		        vpage.setcontact(reader.getCellvalue(SHEET_NAME, row, 4).trim());
		        vpage.selectGender(reader.getCellvalue(SHEET_NAME, row, 5).trim());
		        vpage.selectbg(reader.getCellvalue(SHEET_NAME, row, 6).trim());
		        vpage.setemail(reader.getCellvalue(SHEET_NAME, row, 7).trim());
		        vpage.setAltcontact(reader.getCellvalue(SHEET_NAME, row, 8).trim());
		        vpage.setidentificationMark(reader.getCellvalue(SHEET_NAME, row, 9).trim());		        
		        datePicker.selectdob(reader.getdatevalue(SHEET_NAME, row, 10).trim());
		        vpage.setremark(reader.getCellvalue(SHEET_NAME, row, 11).trim());
		        vpage.setPermanentFlatNumber(reader.getCellvalue(SHEET_NAME, row, 12).trim());
		        vpage.setPermanentLocality(reader.getCellvalue(SHEET_NAME, row, 13).trim());
		        vpage.setPermanentState(reader.getCellvalue(SHEET_NAME, row, 14).trim());
		        vpage.setPermanentCity(reader.getCellvalue(SHEET_NAME, row, 15).trim());
		        vpage.setPermanentPincode(reader.getCellvalue(SHEET_NAME, row, 16).trim());
		        vpage.setCurrentFlatNumber(reader.getCellvalue(SHEET_NAME, row, 17).trim());
		        vpage.setCurrentLocality(reader.getCellvalue(SHEET_NAME, row, 18).trim());
		        vpage.setCurrentState(reader.getCellvalue(SHEET_NAME, row, 19).trim());
		        vpage.setCurrentCity(reader.getCellvalue(SHEET_NAME, row, 20).trim());
		        vpage.setCurrentPincode(reader.getCellvalue(SHEET_NAME, row, 21).trim());

		        ScrollUtil.scrollUntilElementVisible(TestBase.getDriver(), By.id("check1"));
		        Thread.sleep(2000);
		        WebElement checkbox = TestBase.getDriver().findElement(By.id("check1"));
		        checkbox.click();

		        LOGGER.info("Form filled successfully for row: " + row);

		    } catch (Exception e) {
		        LOGGER.error("❌ Error at row " + row + ": " + e.getMessage(), e);

		        Assert.fail("Form filling failed at row " + row + ": " + e.getMessage());
		    }
		}
	
	
	@Test(priority = 1, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that Visitor is registered with correct data or not by passing compulsury value")
	@Epic("Visitor Admin")
	@Feature("Registration of New Visitor")
	@Severity(SeverityLevel.CRITICAL)
	public void valid_registrationonlyman() throws Exception {
		int row = 1;
		 WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));

	        vpage.setFullName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
	     // vpage.setfathername(reader.getCellvalue(SHEET_NAME, row, 1).trim());		        
	        vpage.selectType(reader.getCellvalue(SHEET_NAME, row, 2));
	        
	        vpage.setAadhaarnumber(reader.getCellvalue(SHEET_NAME, row, 3).trim());
	        vpage.setcontact(reader.getCellvalue(SHEET_NAME, row, 4));
	        vpage.selectGender(reader.getCellvalue(SHEET_NAME, row, 5).trim());
	        ScrollUtil.scrollUntilElementVisible(TestBase.getDriver(), By.id("check1"));
	        Thread.sleep(2000);
	        WebElement checkbox = TestBase.getDriver().findElement(By.id("check1"));
	        checkbox.click();
		vpage.clickSubmit();
		
		String expected =  reader.getCellvalue(SHEET_NAME, row, 22);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	
	@Test(priority = 2, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that Visitor is registered with correct data or not by passing All values")
	@Epic("Visitor Admin")
	@Feature("Registration of New Visitor")
	@Severity(SeverityLevel.BLOCKER)
	public void valid_registration() throws Exception {
		vpage.getRegistrrationlink().click();
		int row = 2;
		 WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
          
	     fillFormData(row);
		vpage.clickSubmit();
		
		String expected =  reader.getCellvalue(SHEET_NAME, row, 22);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 3, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that Visitor is registered or not by passing existing I number")
	@Epic("Visitor Admin")
	@Feature("Registration of New Visitor")
	@Severity(SeverityLevel.CRITICAL)
	public void existing_i_registration() throws Exception {
		vpage.getRegistrrationlink().click();
		int row = 3;
		 WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
          
	     fillFormData(row);
		vpage.clickSubmit();
		
		String expected =  reader.getCellvalue(SHEET_NAME, row, 22);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 4, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that Visitor is registered or not by passing existing emails")
	@Epic("Visitor Admin")
	@Feature("Registration of New Visitor")
	@Severity(SeverityLevel.CRITICAL)
	public void existing_email_registration() throws Exception {
		TestBase.getDriver().navigate().refresh();
		ScrollUtil.scrollUntilElementVisible(TestBase.getDriver(), By.xpath("//h3[normalize-space()='REGISTER NEW VISITOR']"));
		 //Thread.sleep(2500);
		int row = 4;
          
	     fillFormData(row);
		vpage.clickSubmit();
		
		String expected =  reader.getCellvalue(SHEET_NAME, row, 22);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 5, groups = { "sanity", "regression" }) 
	@Description("Verify that Visitor is registered or not by passing existing mobile number")
	@Epic("Visitor Admin")
	@Feature("Registration of New Visitor")
	@Severity(SeverityLevel.CRITICAL)
	public void existing_mobile_registration() throws Exception {
		TestBase.getDriver().navigate().refresh();
		
		ScrollUtil.scrollUntilElementVisible(TestBase.getDriver(), By.xpath("//h3[normalize-space()='REGISTER NEW VISITOR']"));
		Thread.sleep(2500);
		int row = 5;
		 
	     fillFormData(row);
		vpage.clickSubmit();
		
		String expected =  reader.getCellvalue(SHEET_NAME, row, 22);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 6, groups = { "sanity", "regression" })

	@Description("Verify that search by name works correctly in the Ministry Member list after registration")
	@Epic("Visitor Admin")
	@Feature("Available in Visitor list")
	@Severity(SeverityLevel.CRITICAL)
	public void visitor_list() throws Exception {
		LOGGER.info("Verify that registere member is present in visitor list or not");
		ScrollUtil.scrollToTop(TestBase.getDriver());
		Thread.sleep(2000);
		int row = 2;
		
		vpage.getRegistrationsidebar().click();
		TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Registered Visitor List']")).click();
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		vpage.setSearchlist(searchValue);
		
		Thread.sleep(5000);
		List<WebElement> rows = TestBase.getDriver().findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]"));
		Thread.sleep(5000);
		int rowCount = rows.size();
		System.out.println("Total TR count: " + rowCount);
		Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);
		boolean found = rows.stream().map(e -> e.getText().trim().toLowerCase())
				.anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

		Assert.assertTrue(found, "No row contains the text '" + searchValue + "'. Found values: "
				+ rows.stream().map(WebElement::getText).toList());

	}

		
	@Test(priority = 7, groups = { "sanity", "regression" })
	@Description("Verify the user information which are input at the time of registration")
	@Epic("Visitor Admin")
	@Feature("Verify Visitor Information")
	@Severity(SeverityLevel.CRITICAL)
	public void visitor_verifyinfo() throws Exception {
		int row = 2;
		vpage.clickView();
		String expectFullName = reader.getCellvalue(SHEET_NAME, row, 0);
		String expectFatherName = reader.getCellvalue(SHEET_NAME, row, 1);
		String expectitype = reader.getCellvalue(SHEET_NAME, row, 2);
		String expecti = reader.getCellvalue(SHEET_NAME, row, 3);
		String expectMobile = reader.getCellvalue(SHEET_NAME, row, 4);
		String expectGender = reader.getCellvalue(SHEET_NAME, row, 5);
		String expectBloodGroup = reader.getCellvalue(SHEET_NAME, row, 6);
		String expectEmail = reader.getCellvalue(SHEET_NAME, row, 7);
		String expectAltMobile = reader.getCellvalue(SHEET_NAME, row, 8);
		String expectIdMark = reader.getCellvalue(SHEET_NAME, row, 9);
		String expectDOB = reader.getCellvalue(SHEET_NAME, row, 10);
		String remarks = reader.getCellvalue(SHEET_NAME, row, 11);		
		//String expectMotherName = reader.getCellvalue(SHEET_NAME, row, 2);

		String permhouseNo = reader.getCellvalue(SHEET_NAME, row, 12);
		String permLocality = reader.getCellvalue(SHEET_NAME, row, 13);
		String permState = reader.getCellvalue(SHEET_NAME, row, 14);
		String permCity = reader.getCellvalue(SHEET_NAME, row, 15);
		String permPin = reader.getCellvalue(SHEET_NAME, row, 16);
		String expectPermtAddr = permhouseNo + ", " + permLocality + ", " + permState + ", " + permCity + ", "
				+ permPin;
		String currenthouseNo = reader.getCellvalue(SHEET_NAME, row, 17);
		String currentLocality = reader.getCellvalue(SHEET_NAME, row, 18);
		String currentState = reader.getCellvalue(SHEET_NAME, row, 19);
		String currentCity = reader.getCellvalue(SHEET_NAME, row, 20);
		String currentPinz = reader.getCellvalue(SHEET_NAME, row, 21);
		String expectcurrentAddr = currenthouseNo + ", " + currentLocality + ", " + currentState + ", " + currentCity
				+ ", " + currentPinz;
		
		// Get actual values from UI
		String actualFullName = vpage.getFullName();
		String actualFatherName = vpage.getFatherName();
		//String actualidtype = vpage.getAlternateMobileNumber();
		String actualidnumber = vpage.getAlternateMobileNumber();
		
		//String actualMotherName = page.getMotherName();
		String actualMobile = vpage.getMobileNumber();
		String actualGender = vpage.getGender();
		String actualBloodGroup = vpage.getBloodGroup();
		String actualEmail = vpage.getEmail();
		String actualAlternateMobile = vpage.getMobileNumber();
		String actualIdMark = vpage.getIdentificationMark();		
		String actualDOB = vpage.getDateOfBirth();
		String actualremarks = vpage.getDateOfBirth();
		String actaulpermAddress = vpage.getPermanentAddress();
		String actaulcurrentAddress = vpage.getPresentAddress();

		validateField("Full Name", expectFullName, actualFullName);
		validateField("Father's Name", expectFatherName, actualFatherName);
		validateField("Gender", expectGender, actualGender);
		validateField("Blood Group", expectBloodGroup, actualBloodGroup);
		//validateField("Mother's Name", expectMotherName, actualMotherName);
		validateField("Aadhaar Number", expecti, actualidnumber);
		validateField("Mobile Number", expectMobile, actualMobile);		
		validateField("Email", expectEmail, actualEmail);
		validateField("Alternate Mobile", expectAltMobile, actualAlternateMobile);
		validateField("Identification Mark", expectIdMark, actualIdMark);		
		validateField("Date of Birth", expectDOB, actualDOB);
		validateField("Remarks", remarks, actualremarks);
		validateField("Present Address", expectcurrentAddr, actaulcurrentAddress);
		validateField("Permanent Address", expectPermtAddr, actaulpermAddress);
		vpage.backfromview();
		
	}

	public void validateField(String label, String expected, String actual) {
		if (!expected.equalsIgnoreCase(actual)) {
			throw new AssertionError(label + " mismatch! Expected: " + expected + ", Found: " + actual);
		}
	}	
		
	@Test(priority = 12, groups = { "sanity", "regression" })
	@Description("Verify member is present in Requeste Icar list or not after initiating the Request")
	@Epic("Ministry Member")
	@Feature("I Card Request")
	@Severity(SeverityLevel.CRITICAL)
	public void minis_mem_logout() throws Exception {
		Thread.sleep(5000);
				vpage.logout();
				String expecteurl = "http://10.226.42.155/#/login";
				String currurl = "http://10.226.42.155/#/login";
				    Assert.assertEquals(currurl, expecteurl);

	}

}
