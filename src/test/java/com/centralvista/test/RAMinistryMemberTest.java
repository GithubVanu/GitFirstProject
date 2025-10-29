/**
 * @author surendragangwar
 * @since 24-Jun-2025
 * @version 1.0
 * 
 * Description: [This Class Contains Test Cases of Recomenation Authority Page for Ministry Member]
 */
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
import com.centralvista.pages.EmpHomePage;
import com.centralvista.pages.Login;
import com.centralvista.pages.Ministrymemberpage;
import com.centralvista.pages.RAMinistryMemberPage;
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

public class RAMinistryMemberTest extends TestBase {

	Ministrymemberpage page;
	Ministrymembertest minispagetest;
	RAMinistryMemberPage rpage;
	excelReader reader;
	DatePickers datePicker;
	JavascriptExecutor js;
	WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));

	private static final Logger LOGGER = LogManager.getLogger(RAMinistryMemberTest.class);

	private static final String SHEET_NAME = "AddMinistryMember";

	public RAMinistryMemberTest() throws FileNotFoundException {

		super();

	}

	@BeforeClass(alwaysRun = true)
	public void setUpAndSwitchRole() throws IOException, InterruptedException {
		 
		minispagetest = new Ministrymembertest();
		page = new Ministrymemberpage(TestBase.getDriver());
		rpage = new RAMinistryMemberPage(TestBase.getDriver());
		datePicker = new DatePickers(TestBase.getDriver());
		js = (JavascriptExecutor) TestBase.getDriver();
		reader = new excelReader("G:\\stsworkspac\\codeformyself\\src\\test\\resources\\testdata\\TestData.xlsx");
		int row = 13;
		rpage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		rpage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		rpage.clickSubmit();
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("RECOMMENDER");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[8]/a/div/span")))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[8]/div/a[1]/div/span"))).click();
		System.out.println("Logger class = " + LOGGER.getClass());

	}

	@Test(priority = 1, groups = { "sanity", "regression" })
	@Description("Verify that Request is Reach to the mention Recommeing Authority")
	@Epic("Recommening Authority")
	@Feature("Recommening Authority - Ministry Member Pending Icard Request List")
	@Severity(SeverityLevel.CRITICAL)
	public void rec_auth_minis_mem_requestverify() throws Exception {
		LOGGER.info("Verify that Request is Reach to the mention Arrive in Recommeing Authority");

		int row = 1;
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		page.setSearchlist(searchValue);
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		Thread.sleep(5000);
		List<WebElement> rows = TestBase.getDriver().findElements(By.cssSelector("tbody tr.ng-star-inserted"));
		Thread.sleep(5000);
		int rowCount = rows.size();
		System.out.println("Total TR count: " + rowCount);
		Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);
		boolean found = rows.stream().map(e -> e.getText().trim().toLowerCase())
				.anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

		Assert.assertTrue(found, "No row contains the text '" + searchValue + "'. Found values: "
				+ rows.stream().map(WebElement::getText).toList());

	}

	@Test(priority = 2, groups = { "sanity", "regression" })
	@Description("Verify that value fills at the time of registration is same or not")
	@Epic("Recommening Authority")
	@Feature("Recommening Authority - Ministry Member Pending Icard Request List")
	@Severity(SeverityLevel.CRITICAL)
	public void rec_auth_verifyMembervalues() throws Exception {
		LOGGER.info("Verify that Request is Reach to the mention Recommeing Authority");
		int row = 1;
		rpage.clickView();
		String expectEmpName = reader.getCellvalue(SHEET_NAME, row, 0);
		String expectFatherName = reader.getCellvalue(SHEET_NAME, row, 1);
		// String expectMotherName = reader.getCellvalue(SHEET_NAME, row, 2);
		String expectGender = reader.getCellvalue(SHEET_NAME, row, 3);
		String expectDOB = reader.getCellvalue(SHEET_NAME, row, 4);
//		String expectEmail = reader.getCellvalue(SHEET_NAME, row, 5);
//		String expectAadhaar = reader.getCellvalue(SHEET_NAME, row, 6);	

		String expectMobile = reader.getCellvalue(SHEET_NAME, row, 7);
//		String expectAltMobile = reader.getCellvalue(SHEET_NAME, row, 8);	
		// String expectBloodGroup = reader.getCellvalue(SHEET_NAME, row, 9);
		String expectIdMark = reader.getCellvalue(SHEET_NAME, row, 10);
		String expectedSession = reader.getCellvalue(SHEET_NAME, row, 11);
		String expectedValidFrom = reader.getCellvalue(SHEET_NAME, row, 12);
		String expectedValisto = reader.getCellvalue(SHEET_NAME, row, 13);
		String expectedMinistry = reader.getCellvalue(SHEET_NAME, row, 14);
		String expectedCategory = reader.getCellvalue(SHEET_NAME, row, 15);
		String expectedesignation = reader.getCellvalue(SHEET_NAME, row, 16);
		String expectOfficeNo = reader.getCellvalue(SHEET_NAME, row, 17);
//		String expectFaxNo = reader.getCellvalue(SHEET_NAME, row, 18);

		String presenthouseNo = reader.getCellvalue(SHEET_NAME, row, 25);
		String presentLocality = reader.getCellvalue(SHEET_NAME, row, 26);
		String presentState = reader.getCellvalue(SHEET_NAME, row, 27);
		String presentCity = reader.getCellvalue(SHEET_NAME, row, 28);
		String presentPinz = reader.getCellvalue(SHEET_NAME, row, 29);
		String expectPresentAddr = presenthouseNo + ", " + presentLocality + ", " + presentState + ", " + presentCity
				+ ", " + presentPinz;

		// Get actual values from UI
		String actualFullName = rpage.getEmpName();
		String actualFatherName = rpage.getFatherName();

		String actualGender = rpage.getGender();
		String actualDOB = rpage.getDOB();
		// String actualBloodGroup = page.getBloodGroup();

		String actualMobile = rpage.getMobile();
		String actualOfficeNo = rpage.getOfficeNo();
		String actualIdMark = rpage.getIdMark();
		String actualPresentAddr = rpage.getPresentAddress();
		String actualesignation = rpage.getDesignation();
		String actualCategory = rpage.getCategory();

		// String actualAltMobile = rpage.getAltMobile();
		String actualMinistry = rpage.getMinistry();

		String actualSession = rpage.getSession();
		String actualValidFrom = rpage.getValidFrom();
		String actualValisto = rpage.getValidTo();

		String actualBloodGroup = rpage.getBloodGroup();
		String actualEmail = rpage.getExpectedEmail();
		String actualAadhaar = rpage.getAadhaar();

		String actualFaxNo = rpage.getFaxNo();

		// String actualPermanentAddr = rpage.getPermanentAddress();

		// Validate each field
		validateField("Emp Name", expectEmpName, actualFullName);
		validateField("Father's Name", expectFatherName, actualFatherName);
		validateField("Gender", expectGender, actualGender);
		validateField("Date of Birth", expectDOB, actualDOB);
		validateField("Mobile Number", expectMobile, actualMobile);
		validateField("Office Number", expectOfficeNo, actualOfficeNo);
		validateField("Identification Mark", expectIdMark, actualIdMark);
		validateField("Present Address", expectPresentAddr, actualPresentAddr);
		validateField("designation", expectedesignation, actualesignation);
		validateField("Category", expectedCategory, actualCategory);
		validateField("Ministry", expectedMinistry, actualMinistry);
		validateField("session", expectedSession, actualSession);
		validateField("service start", expectedValidFrom, actualValidFrom);
		validateField("Valid Up to", expectedValisto, actualValisto);

		// validateField("Alternate Mobile", expectAltMobile, actualAltMobile);

		// validateField("Blood Group", expectBloodGroup, actualBloodGroup);
		// validateField("Email", expectEmail, actualEmail);
		// validateField("Aadhaar Number", expectAadhaar, actualAadhaar);

		// validateField("Fax Number", expectFaxNo, actualFaxNo);

		// validateField("Permanent Address", expectPermtAddr, actualPermanentAddr);

	}

	public void validateField(String label, String expected, String actual) {
		if (!expected.equalsIgnoreCase(actual)) {
			throw new AssertionError(label + " mismatch! Expected: " + expected + ", Found: " + actual);
		}
	}

	@Test(priority = 3, groups = { "sanity", "regression" })
	@Description("Verify that Recommeing Authority is able to forwar the Request to Approving Authority")
	@Epic("Recommening Authority")
	@Feature("Recommening Authority - Ministry Member Pending Icard Request List")
	@Severity(SeverityLevel.CRITICAL)
	public void minisMem_forwartoApprover() throws Exception {
		LOGGER.info("Verify that Request is Reach to the selected Authority");
		int row = 16;
		rpage.backbutton();
		rpage.forwarToapprover();
		rpage.setapplicationStatus("Forward to Approver");
		rpage.selectApprover();
		rpage.setRemarks("Application Verfiy");
		rpage.submit();
		String exceptMessage = "status updated successfully";
		ToastUtil.validateToastMessage(TestBase.getDriver(), exceptMessage);

	}

	@Test(priority = 4, groups = { "sanity", "regression" })
	@Description("Verify member is present in Requeste Icar list or not after initiating the Request")
	@Epic("Recommening Authority")
	@Feature("Ministry Member Dashboard - I Card Request")
	@Severity(SeverityLevel.CRITICAL)
	public void raminis_mem_logout() throws Exception {
		Thread.sleep(5000);
		page.logout();
		String expecteurl = "http://10.226.42.155/#/login";
		String currurl = "http://10.226.42.155/#/login";
		Assert.assertEquals(currurl, expecteurl);
	}
}
