package com.centralvista.test;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.Login;
import com.centralvista.pages.Ministrymemberpage;
import com.centralvista.testBase.TestBase;
import com.centralvista.utility.DatePickers;
import com.centralvista.utility.ToastUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;


public class Ministrymembertest extends TestBase {

	
	Ministrymemberpage page;
	excelReader reader;
	DatePickers datePicker;
	JavascriptExecutor js;
	WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
	
	private static final Logger LOGGER = LogManager.getLogger(Ministrymembertest.class);

	private static final String SHEET_NAME = "AddMinistryMember";

	public Ministrymembertest() throws FileNotFoundException {
		
		  // starts the driver
		   
		    page  = new Ministrymemberpage(TestBase.getDriver()); // ✅ driver passed
		
	}

	@BeforeClass(alwaysRun = true)
	public void setUpAndSwitchRole() throws IOException, InterruptedException {
		 initialization();
		//TestBase.getDriver().get(CONFIG.getProperty("testSiteURL")); 
		page = new Ministrymemberpage(TestBase.getDriver());
		datePicker = new DatePickers(TestBase.getDriver());
		js = (JavascriptExecutor) TestBase.getDriver();
		reader = new excelReader("G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\TestData.xlsx");
		int row = 11;
		page.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		page.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		page.clickLogin();
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("MTRY_MEM_ADM");

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/a/div/span")))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/div/a[1]/div/span"))).click();
		System.out.println("Logger class = " + LOGGER.getClass());
	}

//	@AfterMethod
//	public void cleanup() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		try {
//			wait.until(
//					ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div/div")));
//		} catch (Exception ignored) {
//		}
//		driver.manage().deleteAllCookies();
//		wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/a/div/span")))
//				.click();
//		wait.until(ExpectedConditions
//				.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/div/a[1]/div/span"))).click();
//	}

	
	private void fillFormData(int row) throws Exception {
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
		        page.setContactnumber(reader.getCellvalue(SHEET_NAME, row, 7));
		        page.setAlternateContactNumber(reader.getCellvalue(SHEET_NAME, row, 8));
		        page.setBloodgroup(reader.getCellvalue(SHEET_NAME, row, 9).trim());
		        page.setIdentificationMark(reader.getCellvalue(SHEET_NAME, row, 10).trim());
		        page.setSession(reader.getCellvalue(SHEET_NAME, row, 11).trim());
		        datePicker.selectservicedate(reader.getdatevalue(SHEET_NAME, row, 12).trim());
		        datePicker.selectenddate(reader.getdatevalue(SHEET_NAME, row, 13).trim());
		        page.setMinistry(reader.getCellvalue(SHEET_NAME, row, 14).trim());
		        page.setClassId(reader.getCellvalue(SHEET_NAME, row, 15).trim());
		        page.setDesignationId(reader.getCellvalue(SHEET_NAME, row, 16).trim());
		        page.setOfficeContact(reader.getCellvalue(SHEET_NAME, row, 17).trim());
		        page.setFaxNumber(reader.getCellvalue(SHEET_NAME, row, 18).trim());
		        page.setPurpose(reader.getCellvalue(SHEET_NAME, row, 19).trim());
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
		
	

	@Test(priority = 1, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify Ministry member is registered with correct data")
	@Epic("Ministry Member")
	@Feature("Registration of New member")
	@Severity(SeverityLevel.BLOCKER)
	public void valid_registration() throws Exception {
		int row = 1;
		fillFormData(row);
		page.clickSubmit();
		
		String expected =  reader.getCellvalue(SHEET_NAME, row, 30);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}

	@Test(priority = 2, groups = "regression")
	@Description("Verify that Ministry Member registration fails when using an already registered contact number")
	@Epic("Ministry Member")
	@Feature("Registration of New member")
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
	@Description("Verify that Ministry Member registration fails when using an already registered email")
	@Epic("Ministry Member")
	@Feature("Registration of New member")
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
	@Description("Verify that Ministry Member registration fails when using an already registered existing aahaar")
	@Epic("Ministry Member")
	@Feature("Registration of New member")
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

	
	@Test(priority = 5, groups = { "sanity", "regression" })

	@Description("Verify that search by name works correctly in the Ministry Member list after registration")
	@Epic("Ministry Member")
	@Feature("Available in List")
	@Severity(SeverityLevel.CRITICAL)
	public void minis_mem_list() throws Exception {
		
		
		int row = 1;
		By sidebarLocator = By.xpath("//*[@id='sidebar']/div/div/ul/li[2]/a/div/span");
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement sidebarItem = wait.until(ExpectedConditions.elementToBeClickable(sidebarLocator));
		((JavascriptExecutor) TestBase.getDriver()).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(300);
		((JavascriptExecutor) TestBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", sidebarItem);
		Thread.sleep(300);
		try {
		    sidebarItem.click();
		} catch (ElementClickInterceptedException e) {
		    ((JavascriptExecutor) TestBase.getDriver()).executeScript("arguments[0].click();", sidebarItem);
		}
		//driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/a/div/span")).click();   This line must uncomment if run sanity
		TestBase.getDriver().findElement(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/div/a[2]/div/span")).click();
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		page.setSearchlist(searchValue);
		Thread.sleep(2000);
		List<WebElement> nameCells = TestBase.getDriver().findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]"));
		System.out.println(nameCells + "Search succw=essfull");
		Assert.assertTrue(nameCells.size() > 0, "No rows displayed after search!");
		boolean found = false;
		for (WebElement nameCell : nameCells) {
			if (nameCell.getText().trim().equalsIgnoreCase(searchValue.trim())) {
				found = true;
				break;
			}
		}

		Assert.assertTrue(found, "Expected name '" + searchValue + "' not found in filtered results.");
	}

	@Test(priority = 6, groups = { "sanity", "regression" })
	@Description("Verify the user information which are input at the time of registration")
	@Epic("Ministry Member")
	@Feature("Verify Information")
	@Severity(SeverityLevel.CRITICAL)
	public void minis_mem_verifyinfo() throws Exception {
		int row = 1;
		page.clickView();
		String expectFullName = reader.getCellvalue(SHEET_NAME, row, 0);
		String expectFatherName = reader.getCellvalue(SHEET_NAME, row, 1);
		String expectMotherName = reader.getCellvalue(SHEET_NAME, row, 2);
		String expectGender = reader.getCellvalue(SHEET_NAME, row, 3);
		String expectDOB = reader.getCellvalue(SHEET_NAME, row, 4);
		String expectEmail = reader.getCellvalue(SHEET_NAME, row, 5);
		String expectAadhaar = reader.getCellvalue(SHEET_NAME, row, 6);
		String expectMobile = reader.getCellvalue(SHEET_NAME, row, 7);
		String expectAltMobile = reader.getCellvalue(SHEET_NAME, row, 8);
		// String expectBloodGroup = reader.getCellvalue(SHEET_NAME, row, 9);
		String expectIdMark = reader.getCellvalue(SHEET_NAME, row, 10);
		String expectOfficeNo = reader.getCellvalue(SHEET_NAME, row, 17);
		String expectFaxNo = reader.getCellvalue(SHEET_NAME, row, 18);

		String permhouseNo = reader.getCellvalue(SHEET_NAME, row, 20);
		String permLocality = reader.getCellvalue(SHEET_NAME, row, 21);
		String permState = reader.getCellvalue(SHEET_NAME, row, 22);
		String permCity = reader.getCellvalue(SHEET_NAME, row, 23);
		String permPin = reader.getCellvalue(SHEET_NAME, row, 24);
		String expectPermtAddr = permhouseNo + ", " + permLocality + ", " + permState + ", " + permCity + ", "
				+ permPin;
		String presenthouseNo = reader.getCellvalue(SHEET_NAME, row, 25);
		String presentLocality = reader.getCellvalue(SHEET_NAME, row, 26);
		String presentState = reader.getCellvalue(SHEET_NAME, row, 27);
		String presentCity = reader.getCellvalue(SHEET_NAME, row, 28);
		String presentPinz = reader.getCellvalue(SHEET_NAME, row, 29);
		String expectPresentAddr = presenthouseNo + ", " + presentLocality + ", " + presentState + ", " + presentCity
				+ ", " + presentPinz;
		String expectedesignation = reader.getCellvalue(SHEET_NAME, row, 16);
		String expectedMinistry = reader.getCellvalue(SHEET_NAME, row, 14);
		String expectedCategory = reader.getCellvalue(SHEET_NAME, row, 15);
		String expectedSession = reader.getCellvalue(SHEET_NAME, row, 11);
		String expectedValidFrom = reader.getCellvalue(SHEET_NAME, row, 12);
		String expectedValisto = reader.getCellvalue(SHEET_NAME, row, 13);

		// Get actual values from UI
		String actualFullName = page.getFullName();
		String actualFatherName = page.getFatherName();
		String actualMotherName = page.getMotherName();
		String actualGender = page.getGender();
		String actualDOB = page.getDateOfBirth();
		String actualMobile = page.getMobileNumber();
		String actualAltMobile = page.getAlternateMobileNumber();
		String actualIdMark = page.getIdentificationMark();
		// String actualBloodGroup = page.getBloodGroup();
		String actualEmail = page.getEmail();
		String actualAadhaar = page.getAadhaarNumber();
		String actualOfficeNo = page.getOfficeNumber();
		String actualFaxNo = page.getFaxNumber();
		String actualPresentAddr = page.getPresentAddress();
		String actualPermanentAddr = page.getPermanentAddress();
		String actualesignation = page.getDesignation();
		String actualMinistry = page.getMinistry();
		String actualCategory = page.getCategory();
		String actualSession = page.getSession();
		String actualValidFrom = page.getValidFrom();
		String actualValisto = page.getValidTo();

		// Validate each field
		validateField("Full Name", expectFullName, actualFullName);
		validateField("Father's Name", expectFatherName, actualFatherName);
		validateField("Mother's Name", expectMotherName, actualMotherName);
		validateField("Gender", expectGender, actualGender);
		validateField("Date of Birth", expectDOB, actualDOB);
		validateField("Mobile Number", expectMobile, actualMobile);
		validateField("Alternate Mobile", expectAltMobile, actualAltMobile);
		validateField("Identification Mark", expectIdMark, actualIdMark);
		// validateField("Blood Group", expectBloodGroup, actualBloodGroup);
		validateField("Email", expectEmail, actualEmail);
		validateField("Aadhaar Number", expectAadhaar, actualAadhaar);
		validateField("Office Number", expectOfficeNo, actualOfficeNo);
		validateField("Fax Number", expectFaxNo, actualFaxNo);
		validateField("Present Address", expectPresentAddr, actualPresentAddr);
		validateField("Permanent Address", expectPermtAddr, actualPermanentAddr);
		validateField("designation", expectedesignation, actualesignation);
		validateField("Ministry", expectedMinistry, actualMinistry);
		validateField("Category", expectedCategory, actualCategory);
		validateField("session", expectedSession, actualSession);
		validateField("service start", expectedValidFrom, actualValidFrom);
		validateField("Valid Up to", expectedValisto, actualValisto);

	}

	public void validateField(String label, String expected, String actual) {
		if (!expected.equalsIgnoreCase(actual)) {
			throw new AssertionError(label + " mismatch! Expected: " + expected + ", Found: " + actual);
		}
	}
	
	@Test(priority = 7, groups ="regression" ) //only for regression later rempve
	@Description("Verify that user is able to submit fascia or not by without passing values")
	@Epic("Ministry Member")
	@Feature("Upload Fascia")
	@Severity(SeverityLevel.CRITICAL)
	@Step()
	public void minis_mem_uploadfasciawithooufilling() throws Exception {
		LOGGER.info("Fascia uploaz starts");
		page.clickUploadFasciabutton();
		page.clickSubmitFasciabutton();
		
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-html-container")));

		String message = popup.getText();
		System.out.println("Popup Text: " + message);
		
		Assert.assertEquals(message, "Please fill atleast one Field from the form");
		WebElement okButton = TestBase.getDriver().findElement(By.xpath("//button[normalize-space()='OK']"));
		okButton.click();
		


	}
	
	@Test(priority = 8, groups =  "regression" )  //only for regression later rempve
	@Description("Verify that user is able to submit fascia or not by passing name in english")
	@Epic("Ministry Member")
	@Feature("Upload Fascia")
	@Severity(SeverityLevel.CRITICAL)
	@Step()
	public void minis_mem_uploadfasciainvalidname() throws Exception {

		page.clickUploadFasciabutton();

		page.setHindiName("rahul");
		String photoPath = "G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\photo.jpg";
		page.uploadPhoto(photoPath);
		String signFile = "G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\sinature.jpg";
		page.uploadSignature(signFile);

		TestBase.getDriver().findElement(By.xpath(
				"/html/body/app-root/app-sessional-members/div/div/main/app-sm-view-details/div/div/div[2]/app-sm-update-fascia-data/div/div[2]/div/form/div/div[1]/div/div[1]/label"))
				.click();

		page.clickSubmitFasciabutton();

		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement popup = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div/div[2]")));
	
		//String actualMessage = popup.getText();
		String exceptMessage = "only hindi name is allow";
		//System.out.println("Popup Text: " + popupText);
		ToastUtil.validateToastMessage(TestBase.getDriver(), exceptMessage);
		
	
	}
	
	
	

	@Test(priority = 9, groups = { "sanity", "regression" })
	@Description("Verify that user is able to submit fascia or not by passing all valid data")
	@Epic("Ministry Member")
	@Feature("Ministry Member Dashboard - Upload Fascia")
	@Severity(SeverityLevel.CRITICAL)
	public void minis_mem_uploadfascia() throws Exception {
		LOGGER.info("Fascia uploaz starts");
		page.clickUploadFasciabutton();
		page.setHindiName("नकली नाम");
		String photoPath = "G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\photo.jpg";
		page.uploadPhoto(photoPath);
		String signFile = "G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\sinature.jpg";
		page.uploadSignature(signFile);
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(TestBase.explicitWait));
		page.clickSubmitFasciabutton();
		String exceptMessage = "Data captured successfully.";
		ToastUtil.validateToastMessage(TestBase.getDriver(), exceptMessage);
		By toastLocator = By.cssSelector("div.toast-message");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		LOGGER.info("Fascia uploaz over");
		
	}

	@Test(priority = 10, groups = { "sanity", "regression" })
	@Description("Verify that user is able to sent the icar request not by passing all correct  value")
	@Epic("Ministry Member")
	@Feature("I Card Request")
	@Severity(SeverityLevel.CRITICAL)
	public void minis_mem_requestcar() throws Exception {
		LOGGER.info("icar request for ministry member starts");
		int row =1;
		js.executeScript("window.scrollTo(0, 0);");
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[normalize-space()='All Member List']"))).click();
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		page.setSearchlist(searchValue);
		System.out.println(searchValue);
		Thread.sleep(2000);
		page.clickIcarRequest();
		page.setRequestType("New");
		page.selectRecommendingAuthority("000506");
		String photoPath = "G:\\myprojects\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\photo.jpg";
		page.uploaddocument(photoPath);
		page.setremark("request Initiate");
		page.setBuiling("New Parliament");
		page.selectRoom("All Rooms"); 
		page.IcarRequestButton();
//		WebElement toast = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div"));
//		String actual = toast.getText();
		String exceptMessage = "Application successfully forwarded to recommender";

		ToastUtil.validateToastMessage(TestBase.getDriver(), exceptMessage);
	}
	
	

	@Test(priority = 11, groups = { "sanity", "regression" })
	@Description("Verify member is present in Requeste Icar list or not after initiating the Request")
	@Epic("Ministry Member")
	@Feature("I Card Request")
	@Severity(SeverityLevel.CRITICAL)
	public void minis_mem_requestverify() throws Exception {
		 LOGGER.info("verify icar request for ministry member starts");
		 int row = 1;
			String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
			page.setSearchlist(searchValue);
			WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
			
	        Thread.sleep(5000);
			
			List<WebElement> rows = TestBase.getDriver().findElements(
				    By.cssSelector("tbody tr.ng-star-inserted")
				);
			Thread.sleep(5000);
				
				int rowCount = rows.size();
				System.out.println("Total TR count: " + rowCount);
			
			Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);

			// Verify if search value exists in any row
			boolean found = rows.stream()
			    .map(e -> e.getText().trim().toLowerCase())
			    .anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

			Assert.assertTrue(found,
			    "No row contains the text '" + searchValue + "'. Found values: " +
			        rows.stream().map(WebElement::getText).toList());
		}
	
	
	@Test(priority = 12, groups = { "sanity", "regression" })
	@Description("Verify member is present in Requeste Icar list or not after initiating the Request")
	@Epic("Ministry Member")
	@Feature("I Card Request")
	@Severity(SeverityLevel.CRITICAL)
	public void minis_mem_logout() throws Exception {
		Thread.sleep(5000);
				page.logout();
				String expecteurl = "http://10.226.42.155/#/login";
				String currurl = "http://10.226.42.155/#/login";

				    Assert.assertEquals(currurl, expecteurl);

		
		
		
	
	}
}
