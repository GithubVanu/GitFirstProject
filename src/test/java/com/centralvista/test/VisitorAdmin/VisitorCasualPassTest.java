/**
 * @author surendragangwar
 * @since 18-Sept-2025
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.VisitorAdmin.VisitorCasualPassPage;
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

public class VisitorCasualPassTest extends TestBase {
	
	VisitorRegistrationPage vpage;
	excelReader reader;
	DatePickers datePicker;
	JavascriptExecutor js;
	VisitorRegistrationTest vtest;
	VisitorCasualPassPage cpage;
	
	private static final Logger LOGGER = LogManager.getLogger(VisitorCasualPassPage.class);

	private  static final String SHEET_NAME = "VisitorAdmin";

	public VisitorCasualPassTest() throws FileNotFoundException {
		
	
		   
		    //cpage  = new VisitorCasualPassPage(TestBase.getDriver());
		
	}

	@BeforeClass(alwaysRun = true)
	public void setUpAndSwitchRole() throws IOException, InterruptedException {
		cpage  = new VisitorCasualPassPage(TestBase.getDriver());
		vpage = new VisitorRegistrationPage(TestBase.getDriver());
		vtest = new VisitorRegistrationTest();
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
		        Thread.sleep(2000);
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
	@Description("Verify that Visitor is registered with correct data or not by passing All values")
	@Epic("Visitor Admin")
	@Feature("Registration of New Visitor")
	@Severity(SeverityLevel.BLOCKER)
	public void valid_registration() throws Exception {
		vpage.getRegistrrationlink().click();
		int row = 18;
		 WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));         
	   fillFormData(row);
		vpage.clickSubmit();
		
		String expected =  reader.getCellvalue(SHEET_NAME, row, 22);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 2, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that Visitor request is forwarded to Recommening Authority or not")
	@Epic("Visitor Admin")
	@Feature("Pass Request for Casual Visitor")
	@Severity(SeverityLevel.BLOCKER)
	public void casualpass_visitorrequest() throws Exception {
	 
		int row = 22;
		cpage.requestforcasualpass();
		cpage.selectcategory(reader.getCellvalue(SHEET_NAME, row, 0));
		//datePicker.selectfromdate(reader.getdatevalue(SHEET_NAME, row, 1).trim());
		datePicker.selecttodate(reader.getdatevalue(SHEET_NAME, row, 2).trim());
		cpage.selectmaterial(reader.getCellvalue(SHEET_NAME, row,5));
		cpage.setPurpose(reader.getCellvalue(SHEET_NAME, row,6));
		cpage.selectrecauthority(reader.getCellvalue(SHEET_NAME, row, 7).trim());
		cpage.selectreferrertype(reader.getCellvalue(SHEET_NAME, row, 8).trim());
		cpage.selectreferrerperson(reader.getCellvalue(SHEET_NAME, row, 9).trim());
		cpage.selectbuilding(reader.getCellvalue(SHEET_NAME, row, 10).trim());
		cpage.selectroom(reader.getCellvalue(SHEET_NAME, row, 11));
		cpage.submitrequest();
//		cpage.selectcategory(reader.getCellvalue(SHEET_NAME, row, 0));
		String expected =  reader.getCellvalue(SHEET_NAME, row, 12);
		System.out.println(expected);
		ToastUtil.validateToastMessage(TestBase.getDriver(), expected);
	}
	
	@Test(priority = 3, groups = { "sanity", "regression" })
	@Description("Verify That visitor Admin is able to logout or not after forwarding the visitor request to Recommending Authority")
	@Epic("Visitor Admin")
	@Feature("Logout")
	@Severity(SeverityLevel.CRITICAL)
	public void visitor_admin_logout() throws Exception {
		Thread.sleep(5000);
				vpage.logout();
				String expecteurl = "http://10.226.42.155/#/login";
				String currurl = "http://10.226.42.155/#/login";
				    Assert.assertEquals(currurl, expecteurl);

	}
	
	@Test(priority = 4, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that request is reached to the Recommending Authority or not")
	@Epic("Visitor Admin")
	@Feature("Casual Pass- Recommending Authority")
	@Severity(SeverityLevel.BLOCKER)
	public void casualpass_verifyreq() throws Exception {
	 
		LOGGER.info("Verify that requested visitor is present in list");
		//ScrollUtil.scrollToTop(TestBase.getDriver());
		Thread.sleep(2000);
		int row = 25;
		vpage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		vpage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		vpage.clickLogin();
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("RECOMMENDER");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Visitor Pass Request']")));
		TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Visitor Pass Request']")).click();
		TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Visitor Pass Request List']")).click();
		int row1 = 18;
		String searchValue = reader.getCellvalue(SHEET_NAME, row1, 0);
		vpage.setSearchlist(searchValue);
		Thread.sleep(2000);
		new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		Thread.sleep(5000);
		List<WebElement> rows = TestBase.getDriver().findElements(By.xpath("//*[@id=\"DataTables_Table_2\"]/tbody/tr[1]/td[2]"));
		Thread.sleep(5000);
		int rowCount = rows.size();
		System.out.println("Total TR count: " + rowCount);
		Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);
		boolean found = rows.stream().map(e -> e.getText().trim().toLowerCase())
				.anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

		Assert.assertTrue(found, "No row contains the text '" + searchValue + "'. Found values: "
				+ rows.stream().map(WebElement::getText).toList());

	}
		
	@Test(priority = 5, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that recommening authority is able to forwar request to approving authority or not")
	@Epic("Visitor Admin")
	@Feature("Casual Pass- Recommending Authority")
	@Severity(SeverityLevel.BLOCKER)
	public void casualpass_fortoapprover() throws Exception {
	 
		LOGGER.info("Verify that request is forware to approver or not");
		
		cpage.fwtoapprover();
		cpage.setapplicationStatus("Forward to Approver");
		cpage.selectApprover();
		cpage.setRemarks("Application verifies");
		cpage.submit();
		
		String exceptMessage = "Visitor Application updated successfully";
		ToastUtil.validateToastMessage(TestBase.getDriver(), exceptMessage);
		
		
	}
	
	@Test(priority = 6, groups = { "sanity", "regression" })
	@Description("Verify That Recommending Authority is able to logout or not after forwarding the visitor request to Approving Authority")
	@Epic("Recommending Authority")
	@Feature("Logout")
	@Severity(SeverityLevel.CRITICAL)
	public void rec_authority_logout() throws Exception {
		Thread.sleep(10000);
				vpage.logout();
				String expecteurl = "http://10.226.42.155/#/login";
				String currurl = "http://10.226.42.155/#/login";
				    Assert.assertEquals(currurl, expecteurl);

	}

	@Test(priority = 7, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that request is reached to the approving Authority or not")
	@Epic("Visitor Admin")
	@Feature("Casual Pass- Approving Authority")
	@Severity(SeverityLevel.BLOCKER)
	public void casualpass_verifyrequ() throws Exception {
	 
		LOGGER.info("Verify that Recommene visitor is present in list");
		//ScrollUtil.scrollToTop(TestBase.getDriver());
		Thread.sleep(2000);
		int row = 27;
		vpage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		vpage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		vpage.clickLogin();
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("APPROVER");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Recommended Visitors']")));
		TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Recommended Visitors']")).click();
		TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Casual Pass Request List']")).click();
		int row1 = 18;
		String searchValue = reader.getCellvalue(SHEET_NAME, row1, 0);
		vpage.setSearchlist(searchValue);
		Thread.sleep(5000);
		new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		Thread.sleep(5000);
		List<WebElement> rows = TestBase.getDriver().findElements(By.xpath("//*[@id=\"DataTables_Table_3\"]/tbody/tr[1]/td[2]"));
		Thread.sleep(5000);
		int rowCount = rows.size();
		System.out.println("Total TR count: " + rowCount);
		Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);
		boolean found = rows.stream().map(e -> e.getText().trim().toLowerCase())
				.anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

		Assert.assertTrue(found, "No row contains the text '" + searchValue + "'. Found values: "
				+ rows.stream().map(WebElement::getText).toList());

	}
	
	@Test(priority = 8, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that Approving authority is able to forwar request for generic to Issuing authority or not")
	@Epic("Visitor Admin")
	@Feature("Casual Pass- Approving Authority")
	@Severity(SeverityLevel.BLOCKER)
	public void casualpass_fortoissuer() throws Exception {
	 
		LOGGER.info("Verify that request is forware to approver or not");
		Thread.sleep(5000);
		cpage.fwtoissuer();
		cpage.accesspermission();
		cpage.setfasciatype("Generic Pass");
		cpage.setapplicationStatus("Approve and Forward to Issuer");
		cpage.selectissuer();
		cpage.setRemarks("Application Verfiy");
		cpage.submit();
		String exceptMessage = "Visitor Application updated successfully";
		ToastUtil.validateToastMessage(TestBase.getDriver(), exceptMessage);
	}
	
	@Test(priority = 9, groups = { "sanity", "regression" })
	@Description("Verify That Approving Authority is able to logout or not after forwarding the visitor request to Issuing Authority")
	@Epic("Approving Authority")
	@Feature("Logout")
	@Severity(SeverityLevel.CRITICAL)
	public void app_authority_logout() throws Exception {
		Thread.sleep(10000);
				vpage.logout();
				String expecteurl = "http://10.226.42.155/#/login";
				String currurl = "http://10.226.42.155/#/login";
				    Assert.assertEquals(currurl, expecteurl);

	}
	
	@Test(priority = 10, groups = { "sanity", "regression" }) // resolv elater
	@Description("Verify that request is reached to the approving Authority or not")
	@Epic("Visitor Admin")
	@Feature("Casual Pass- Issuing Authority")
	@Severity(SeverityLevel.BLOCKER)
	public void casualpass_verifyreqatIA() throws Exception {
	 
		LOGGER.info("Verify that Recommene visitor is present in list");
		//ScrollUtil.scrollToTop(TestBase.getDriver());
		Thread.sleep(10000);
		int row = 29;
		vpage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		vpage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		vpage.clickLogin();
		WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("ISSUANCE");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Recommended Visitors']")));
		TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Recommended Visitors']")).click();
		TestBase.getDriver().findElement(By.xpath("//span[normalize-space()='Casual Pass Request List']")).click();
		int row1 = 18;
		String searchValue = reader.getCellvalue(SHEET_NAME, row1, 0);
		vpage.setSearchlist(searchValue);
		Thread.sleep(5000);
		new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
		Thread.sleep(5000);
		List<WebElement> rows = TestBase.getDriver().findElements(By.xpath("//*[@id=\"DataTables_Table_3\"]/tbody/tr[1]/td[2]"));
		Thread.sleep(5000);
		int rowCount = rows.size();
		System.out.println("Total TR count: " + rowCount);
		Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);
		boolean found = rows.stream().map(e -> e.getText().trim().toLowerCase())
				.anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

		Assert.assertTrue(found, "No row contains the text '" + searchValue + "'. Found values: "
				+ rows.stream().map(WebElement::getText).toList());

	}
	
	@Test(priority = 11, groups = { "sanity", "regression" })
	@Description("Verify That Issuing Authority is able to logout or not")
	@Epic("Issuing Authority")
	@Feature("Logout")
	@Severity(SeverityLevel.CRITICAL)
	public void issuing_authority_logout() throws Exception {
		Thread.sleep(10000);
				vpage.logout();
				String expecteurl = "http://10.226.42.155/#/login";
				String currurl = "http://10.226.42.155/#/login";
				    Assert.assertEquals(currurl, expecteurl);

	}
	
	
}
