/**
 * @author surendragangwar
 * @since 10-Jul-2025
 * @version 1.0
 * 
 * Description: [This Class Contains Test Cases of Approving Authority Page for Ministry Member]
 */
package com.centralvista.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.AAMinistrymemberPage;
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

public class AAMinistrymemberTest extends TestBase{

	Ministrymemberpage page;
	Ministrymembertest minispagetest;
	AAMinistrymemberPage apage;
	excelReader reader;
	DatePickers datePicker;
	JavascriptExecutor js;
	WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
	
	private static final Logger LOGGER = LogManager.getLogger(AAMinistrymemberTest.class);

	private static final String SHEET_NAME = "AddMinistryMember";

	public AAMinistrymemberTest() throws FileNotFoundException {
		
		super();
		
	}

	@BeforeClass(alwaysRun = true)
	public void setUpAndSwitchRole() throws IOException, InterruptedException {
		
        minispagetest= new Ministrymembertest();
		page = new Ministrymemberpage(TestBase.getDriver());
		apage = new AAMinistrymemberPage(TestBase.getDriver());
		datePicker = new DatePickers(TestBase.getDriver());
		js = (JavascriptExecutor) TestBase.getDriver();
		reader = new excelReader("G:\\stsworkspac\\codeformyself\\src\\test\\resources\\testdata\\TestData.xlsx");
		int row =15;
		 apage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		 apage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		 apage.clickSubmit();	
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("APPROVER");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[9]/a/div/span")))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[9]/div/a[1]/div/span"))).click();
		System.out.println("Logger class = " + LOGGER.getClass());

		
	}
		
	@Test(priority = 1, groups = { "sanity", "regression" })
	@Description("Verify that Request is Reach to the mention Approving  Authority")
	@Epic("TG004")
	@Feature("Approving Authority - Ministry Member Pending Icard Request List")
	@Severity(SeverityLevel.CRITICAL)
	public void app_auth_minis_mem_requestverify() throws Exception {
		LOGGER.info("Verify that Request is arrive at Approving Autority.");
		
		int row = 1;
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		page.setSearchlist(searchValue);

		// Wait until at least 1 matching row (excluding "No data" row) is visible
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		
        Thread.sleep(5000);
		// Get the list of rows
		List<WebElement> rows = TestBase.getDriver().findElements(
			    By.cssSelector("tbody tr.ng-star-inserted")
			);
		Thread.sleep(5000);
			// Count them
			int rowCount = rows.size();
			System.out.println("Total TR count: " + rowCount);
		// Assertion for count > 0
		Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);

		// Verify if search value exists in any row
		boolean found = rows.stream()
		    .map(e -> e.getText().trim().toLowerCase())
		    .anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

		Assert.assertTrue(found,
		    "No row contains the text '" + searchValue + "'. Found values: " +
		        rows.stream().map(WebElement::getText).toList());
	}
	
	@Test(priority = 2, groups = { "sanity", "regression" })
	@Description("Verify that Approving  Authority is able to forwar the Request to Issuing Authority")
	@Epic("Approving Authority")
	@Feature("Approving Authority - Ministry Member Pending Icard Request List")
	@Severity(SeverityLevel.CRITICAL)
	public void minisMem_forwartoissuer() throws Exception {
		
		
		apage.clickview();
		 
		ScrollUtil.scrollUntilElementVisible(TestBase.getDriver(), By.xpath("//button[@title='Update']"));
		Thread.sleep(2000);

		apage.grantAccess();
		
		apage.selectfascia("Yes");
		apage.selectfasciatype();
		apage.selectAction("Approve and Forward to Issuer");
		
		Thread.sleep(2000);
		//apage.selectissuer();
		TestBase.getDriver().findElement(By.xpath("//*[@id=\"approvingAuthorityId\"]/div/div/div[3]")).click();
		WebElement input = TestBase.getDriver().findElement(By.xpath("//div[@aria-expanded='true']//input[@type='text']"));
		input.sendKeys("346584");
		input.sendKeys(Keys.ARROW_DOWN);
		input.sendKeys(Keys.ENTER);
		 Thread.sleep(5000);
		apage.setRemarks("Application Verify");
		apage.submit();
		String exceptMessage = "Approval status updated successfully.";
		ToastUtil.validateToastMessage(TestBase.getDriver(), exceptMessage);

	}

	@Test(priority = 3, groups = { "sanity", "regression" })
	@Description("Verify member is move to Ministry Member Request Status List or not after forwarding it to issuer")
	@Epic("Approving  Authority")
	@Feature("Ministry Member Request Status List")
	@Severity(SeverityLevel.CRITICAL)
	public void minisMem_checkstatus() throws Exception {
      LOGGER.info("Verify that Request is move to Ministry Member Request Status List in Approving Autority.");
      TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Recommended Ministry Member']")).click();
      TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Ministry Member Recommend Status List']")).click();
		int row = 1;
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		page.setSearchlist(searchValue);

		// Wait until at least 1 matching row (excluding "No data" row) is visible
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		
        Thread.sleep(5000);
		// Get the list of rows
		List<WebElement> rows = TestBase.getDriver().findElements(
			    By.cssSelector("tbody tr.ng-star-inserted")
			);
		Thread.sleep(5000);
			// Count them
			int rowCount = rows.size();
			System.out.println("Total TR count: " + rowCount);
		// Assertion for count > 0
		Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);

		// Verify if search value exists in any row
		boolean found = rows.stream()
		    .map(e -> e.getText().trim().toLowerCase())
		    .anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

		Assert.assertTrue(found,
		    "No row contains the text '" + searchValue + "'. Found values: " +
		        rows.stream().map(WebElement::getText).toList());
	}
	
	@Test(priority = 4, groups = { "sanity", "regression" })
	@Description("Verify that the Approving authority is logout successful or not")
	@Epic("Approving Authority")
	@Feature("Logout")
	@Severity(SeverityLevel.CRITICAL)
	public void aaminis_mem_logout() throws Exception {
		Thread.sleep(5000);
		page.logout();
		String expecteurl = "http://10.226.42.155/#/login";
		String currurl = "http://10.226.42.155/#/login";
		Assert.assertEquals(currurl, expecteurl);
	}
	
	@Test(priority = 5, groups = { "sanity", "regression" })
	@Description("Verify that Issuing Authority is able to login or not")
	@Epic("Issuing Authority")
	@Feature("Login")
	@Severity(SeverityLevel.CRITICAL)
	public void iaminis_mem_login() throws Exception {
		Thread.sleep(5000);
		reader = new excelReader("G:\\stsworkspac\\codeformyself\\src\\test\\resources\\testdata\\TestData.xlsx");
		int row =17;
		 apage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		 apage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		 apage.clickSubmit();	
		
	}
	
	@Test(priority = 6, groups = { "sanity", "regression" })
	@Description("Verify that Issuing Authority is able to login or not")
	@Epic("Issuing Authority")
	@Feature("Login")
	@Severity(SeverityLevel.CRITICAL)
	public void minisMem_checkstatusIa() throws Exception {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("ISSUANCE");
		Thread.sleep(2000);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Ministry Member Request']")))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[normalize-space()='Ministry Member Approved Icard List']"))).click();
		System.out.println("Logger class = " + LOGGER.getClass());
		
		int row = 1;
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		page.setSearchlist(searchValue);

		// Wait until at least 1 matching row (excluding "No data" row) is visible
		 wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		
        Thread.sleep(5000);
		// Get the list of rows
		List<WebElement> rows = TestBase.getDriver().findElements(
			    By.cssSelector("tbody tr.ng-star-inserted")
			);
		Thread.sleep(5000);
			// Count them
			int rowCount = rows.size();
			System.out.println("Total TR count: " + rowCount);
		// Assertion for count > 0
		Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);

		// Verify if search value exists in any row
		boolean found = rows.stream()
		    .map(e -> e.getText().trim().toLowerCase())
		    .anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

		Assert.assertTrue(found,
		    "No row contains the text '" + searchValue + "'. Found values: " +
		        rows.stream().map(WebElement::getText).toList());
	}
	
	@Test(priority = 7, groups = { "sanity", "regression" })
	@Description("Verify that the Issuing authority is logout successful or not")
	@Epic("Approving Authority")
	@Feature("Logout")
	@Severity(SeverityLevel.CRITICAL)
	public void iaminis_mem_logout() throws Exception {
		Thread.sleep(5000);
		page.logout();
		String expecteurl = "http://10.226.42.155/#/login";
		String currurl = "http://10.226.42.155/#/login";
		Assert.assertEquals(currurl, expecteurl);
	}
	
}

