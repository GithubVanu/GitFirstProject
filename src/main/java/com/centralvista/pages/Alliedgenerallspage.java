
package com.centralvista.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.centralvista.dataReader.excelReader;
import com.centralvista.testBase.TestBase;
import com.centralvista.utility.DatePickers;
import com.centralvista.utility.ScrollUtil;
import com.centralvista.utility.ToastUtil;

public class Alliedgenerallspage extends TestBase {
	WebDriver driver;
	DatePickers datePicker;
	excelReader reader;
	private  static final String SHEET_NAME = "AddAlliedGeneralls";

	@FindBy(xpath = "//*[@id='fullname']")
	WebElement fullName;

	@FindBy(xpath = "//*[@id='fatherName']")
	WebElement fathername;

	@FindBy(xpath = "//*[@id='motherName']")
	WebElement mothername;

	@FindBy(xpath = "//ng-select[@id='gender']\r\n")
	WebElement Gender;

	@FindBy(xpath = "//*[@id = 'dob']")
	WebElement dob;

	@FindBy(xpath = "//*[@id = 'email']")
	WebElement Email;

	@FindBy(xpath = "//*[@id = 'aadhaarCardNumber']")
	WebElement AadhaarCardNumber;

	@FindBy(xpath = "//*[@id = 'contactNumber']")
	WebElement contactnumber;

	@FindBy(xpath = "//*[@id = 'alternate_contact_number']")
	WebElement alternate_contact_number;

	@FindBy(xpath = "//*[@id = 'bloodgroup']")
	WebElement bloodgroup;

	@FindBy(xpath = "//*[@id='identificationMark']")
	WebElement identificationMark;

	@FindBy(xpath = "//*[@id='empId']")
	WebElement employementID;

	@FindBy(xpath = "//*[@id='serviceStartDate']")
	WebElement serviceStartDate;

	@FindBy(xpath = "//*[@id= 'agencyId']")
	WebElement agencyId;

	@FindBy(xpath = "//*[@id= 'designationId']")
	WebElement designationId;

	@FindBy(xpath = "//*[@id= 'classId']")
	WebElement classId;

	@FindBy(xpath = "//*[@id= 'officeContact']")
	WebElement officeContact;

	@FindBy(xpath = "//*[@id= 'faxNumber']")
	WebElement faxNumber;

	@FindBy(xpath = "//*[@id= 'secretariatCode']")
	WebElement secretariat;

	@FindBy(xpath = "//*[@id = 'permanentFlatNumber']")
	WebElement permanentFlatNumber;

	@FindBy(xpath = "//*[@id = 'permanentLocality']")
	WebElement permanentLocality;

	@FindBy(xpath = "//*[@id= 'permanentState']")
	WebElement permanentState;

	@FindBy(xpath = "//*[@id= 'permanentCity']")
	WebElement permanentCity;

	@FindBy(xpath = "//*[@id= 'permanentPincode']")
	WebElement permanentPincode;

	@FindBy(xpath = "//*[@id = 'currentFlatNumber']")
	WebElement currentFlatNumber;

	@FindBy(xpath = "//*[@id = 'currentLocality']")
	WebElement currentLocality;

	@FindBy(xpath = "//*[@id= 'currentState']")
	WebElement currentState;

	@FindBy(xpath = "//*[@id= 'currentCity']")
	WebElement currentCity;

	@FindBy(xpath = "//*[@id= 'currentPincode']")
	WebElement currentPincode;

	@FindBy(xpath = "//*[contains(text(),'Submit')]")
	WebElement submitButton;

	@FindBy(xpath = "//*[contains(text(),'Allied General ')]//i")
	WebElement clickAlliedGeneral;

	@FindBy(xpath = "//*[contains(text(),'All General List')]")
	WebElement clickAllGeneralList;

	@FindBy(xpath = "//parent::div[@class='row cont-wrapper']//following::input")
	WebElement searchAlliedEmployeeLs;

	@FindBy(xpath = "//parent::table[@class='table tlist table-striped table-responsive table-sm row-border hover dataTable no-footer']//following::td//i[@class='fa fa-eye action_colr mx-1']")
	WebElement viewAlliedEmployeeLs;

	@FindBy(xpath = "//parent::div[@class='profile-usermenu']//following::li//a[contains(text(),'Update Icard Fascia Data')]")
	WebElement updateFasciaAlliedGeneralLs;

	@FindBy(xpath = "//parent::div[@class='profile-content']//child::div[1]//following::div[7]//child::input[@formcontrolname='hindiName']")
	WebElement hindiNameAlliedGeneralLS;

	@FindBy(xpath = "//parent::div[@class='profile-content']//child::div[1]//following::div[8]//child::input[@id='photo']")
	WebElement photoselectorAlliedGeneralLS;

	@FindBy(xpath = "//parent::div[@class='profile-content']//child::div[1]//following::div[7]//child::input[@id='signature']")
	WebElement signselectorAlliedGeneralLS;

	@FindBy(xpath = "//parent::div[@class='col-md-12 main-mrd1 ne-dd mb-2 mt-2']//child::button[contains(text(),'Submit')]")
	WebElement submitUpdateButtonAlliedGeneralLS;

	public Alliedgenerallspage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alliedgenerallspage(WebDriver driver) throws FileNotFoundException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setFullName(String value) {
		// fullName.clear();
		fullName.sendKeys(value);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Zoom out to 80%
		js.executeScript("document.body.style.zoom='4" + "0%'");

	}

	public void setFathername(String value) {
		// fathername.clear();
		fathername.sendKeys(value);
	}

	public void setMothername(String value) {
		// mothername.clear();
		mothername.sendKeys(value);
	}

	/*
	 * public void setGender(String value) {
	 * 
	 * Select select = new Select(Gender); select.selectByVisibleText(value);
	 * System.out.println("I am gender value "+ value); }
	 */

	public void setGender(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Gender.click();

		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@role='option']//span[normalize-space(text())='" + value + "']")));
		option.click();

	}

	public void setEmail(String value) {
		Email.clear();
		Email.sendKeys(value);
	}

	public void setAadhaarCardNumber(String value) {
		AadhaarCardNumber.sendKeys(value);

	}

	public void setContactNumber(String value) {
		contactnumber.sendKeys(value);
	}

	public void setAlternateContactNumber(String value) {
		// Driver is importing the
		// WebDriver driver = new ChromeDriver();

		// Value is send from excel to the field
		alternate_contact_number.sendKeys(value);
	}

	/*
	 * public void setBloodgroup(String value) { Select select = new
	 * Select(bloodgroup); select.selectByValue(value); }
	 */

	public void setBloodgroup(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open dropdown
		bloodgroup.click();

		// Wait until option is clickable
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@role='option']//span[normalize-space(text())='" + value + "']")));
		// Scroll and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		option.click();

	}

	public void setIdentificationMark(String value) {

		identificationMark.clear();
		identificationMark.sendKeys(value);
	}

	public void setEmployementID(String value) {
		employementID.sendKeys(value);

	}

	public void setAgency(String value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		agencyId.click();
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@role='option']//span[normalize-space(text())='" + value + "']")));

		option.click();

	}

	public void setDesignationId(String value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		designationId.click();
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@role='option']//span[normalize-space(text())='" + value + "']")));

		option.click();
	}

	public void setCategory(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		classId.click();
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@role='option']//span[normalize-space(text())='" + value + "']")));
		option.click();

	}

	public void setOfficeContact(String value) {
		officeContact.clear();
		officeContact.sendKeys(value);

	}

	public void setFaxNumber(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		faxNumber.clear();
		faxNumber.sendKeys(value);
	}

	public void setSecretariat(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		secretariat.click();
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@role='option']//span[normalize-space(text())='" + value + "']")));
		option.click();

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(false);", permanentFlatNumber);
	}

	public void setPermanentFlatNumber(String value) {

		permanentFlatNumber.clear();
		permanentFlatNumber.sendKeys(value);
	}

	public void setPermanentLocality(String value) {
		permanentLocality.clear();
		permanentLocality.sendKeys(value);
	}

	public void setPermanentState(String value) {
		permanentState.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@role='option']//span[normalize-space(text())='" + value + "']")));
		// Scroll and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		option.click();

	}

	public void setPermanentCity(String value) {
		permanentCity.clear();
		permanentCity.sendKeys(value);
	}

	public void setPermanentPincode(String value) {
		permanentPincode.clear();
		permanentPincode.sendKeys(value);
	}

	public void setCurrentFlatNumber(String value) {
		currentFlatNumber.clear();
		currentFlatNumber.sendKeys(value);
	}

	public void setCurrentLocality(String value) {
		currentLocality.clear();
		currentLocality.sendKeys(value);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(false);", Submit);
	}

	public void setCurrentState(String value) {
		currentState.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@role='option']//span[normalize-space(text())='" + value + "']")));
		// Scroll and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		option.click();
	}

	public void setCurrentCity(String value) {
		currentCity.clear();
		currentCity.sendKeys(value);
	}

	public void setCurrentPincode(String value) {
		currentPincode.clear();
		currentPincode.sendKeys(value);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Zoom out to 80%
		js.executeScript("document.body.style.zoom='100%'");
	}

	public void clickSubmit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

	}

	/*public void updateAlliedGeneralFasciaLS(String searchedEmpid) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
		// zoom percentage is 30% for samll screen
		// js.executeScript("document.body.style.zoom='30%'");
		// Zoom in to 40% for large screen

		js.executeScript("document.body.style.zoom='60%'");

		// clicking allied general
		//wait.until(ExpectedConditions.elementToBeClickable(clickAlliedGeneral)).click();

		// Wait and click on All General List
		//wait.until(ExpectedConditions.elementToBeClickable(clickAllGeneralList)).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));
		
		// This id is set to data file to send data
	//	int row1 = 1;
		
	//	String searchValue = reader.getCellvalue(SHEET_NAME, row1, 11);
   //     searchAlliedEmployeeLs.sendKeys(searchValue);
		
		
		// Now wait for the search box to be visible/clickable
		wait.until(ExpectedConditions.visibilityOf(searchAlliedEmployeeLs));
		wait.until(ExpectedConditions.elementToBeClickable(searchAlliedEmployeeLs));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));

		// I am not using to wait because i have preavious used it
		wait.until(ExpectedConditions.visibilityOf(viewAlliedEmployeeLs));
		wait.until(ExpectedConditions.elementToBeClickable(viewAlliedEmployeeLs)).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));

		wait.until(ExpectedConditions.visibilityOf(updateFasciaAlliedGeneralLs));
		wait.until(ExpectedConditions.elementToBeClickable(updateFasciaAlliedGeneralLs)).click();

		wait.until(ExpectedConditions.visibilityOf(hindiNameAlliedGeneralLS));
		wait.until(ExpectedConditions.elementToBeClickable(hindiNameAlliedGeneralLS)).sendKeys("सामान्य नाम");

		String filePathPhoto = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\centralvista\\testdata\\photo.jpg";
		photoselectorAlliedGeneralLS.sendKeys(filePathPhoto);

		String filePathSign = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\centralvista\\testdata\\sinature.jpg";
		signselectorAlliedGeneralLS.sendKeys(filePathSign);
		wait.until(ExpectedConditions.visibilityOf(submitUpdateButtonAlliedGeneralLS));
		wait.until(ExpectedConditions.elementToBeClickable(submitUpdateButtonAlliedGeneralLS)).click();
		js.executeScript("document.body.style.zoom='100%'");
		String exceptMessage = "Information updated successfully";
		ToastUtil.validateToastMessage(driver, exceptMessage);
		By toastLocator = By.cssSelector("div.toast-message");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
	}
*/
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchbox;

	public void setSearchlist(String value) {
		searchbox.clear();
		searchbox.sendKeys(value);
	}

	@FindBy(xpath = "//parent::table[@class='table tlist table-striped table-responsive table-sm row-border hover dataTable no-footer']//following::td//i[@class='fa fa-paper-plane action_colr mx-1 ng-star-inserted']")
	WebElement requestICard;

	public void clickIcarRequest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
		wait.until(ExpectedConditions.elementToBeClickable(requestICard)).click();
	}

	@FindBy(xpath = "//*[@id= 'reIssuance']")
	WebElement requestType;

	public void setRequestType(String value) {
		requestType.sendKeys(value);
	}

	@FindBy(xpath = "//parent::form[@class='ng-invalid ng-dirty ng-touched']//following::div//span[contains(text(),'--Select Recommend Authority--')]")
	WebElement approvingAuthority;

	public void selectRecommendingAuthority(String authorityName) {
		// Click the dropdown to open the list
		approvingAuthority.click();

		// Type into the input to filter
		WebElement input = driver.findElement(By.xpath("//div[@aria-expanded='true']//input[@type='text']")); // Adjust
																												// XPath
																												// as
																												// needed
		input.sendKeys(authorityName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
		// Wait and select the matching option
		WebElement desiredOption = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='ng-option-label ng-star-inserted']")));
		desiredOption.click();
	}

	public void setUserName(String uName) {
		textBoxUsername.sendKeys(uName);
	}

	public void setPassword(String pwd) {
		textBoxPassword.sendKeys(pwd);
	}

	@FindBy(xpath = "//*[@id=\'typeEmailX\']")
	WebElement textBoxUsername; //// *[@id="email"]

	@FindBy(xpath = "//*[@id=\'typePasswordX\']")
	WebElement textBoxPassword;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement btnLogin;

	public void clickLogin() {

		btnLogin.click();
	}

	public void sendEmployeeID(String employeeId) {
		// TODO Auto-generated method stub
		System.out.println("I am employee id of valid empoloyee");

	}

	
	public void updateAlliedGeneralFasciaLS(String searchValue) 
	{
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
		// zoom percentage is 30% for samll screen
		// js.executeScript("document.body.style.zoom='30%'");
		// Zoom in to 40% for large screen

		js.executeScript("document.body.style.zoom='60%'");
		
		System.out.println("I am employee id value "+ searchValue);
        
        // Wait and click on All General List
        wait.until(ExpectedConditions.elementToBeClickable(clickAlliedGeneral)).click();
        
		// Wait and click on All General List
		wait.until(ExpectedConditions.elementToBeClickable(clickAllGeneralList)).click();

		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));
		
		// This id is set to data file to send data
	//	int row1 = 1;
		
	//	String searchValue = reader.getCellvalue(SHEET_NAME, row1, 11);
		
        searchAlliedEmployeeLs.sendKeys(searchValue);
		
		
		// Now wait for the search box to be visible/clickable
		wait.until(ExpectedConditions.visibilityOf(searchAlliedEmployeeLs));
		wait.until(ExpectedConditions.elementToBeClickable(searchAlliedEmployeeLs));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));

		// I am not using to wait because i have preavious used it
		wait.until(ExpectedConditions.visibilityOf(viewAlliedEmployeeLs));
		wait.until(ExpectedConditions.elementToBeClickable(viewAlliedEmployeeLs)).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ngx-spinner")));

		wait.until(ExpectedConditions.visibilityOf(updateFasciaAlliedGeneralLs));
		wait.until(ExpectedConditions.elementToBeClickable(updateFasciaAlliedGeneralLs)).click();

		wait.until(ExpectedConditions.visibilityOf(hindiNameAlliedGeneralLS));
		wait.until(ExpectedConditions.elementToBeClickable(hindiNameAlliedGeneralLS)).sendKeys("सामान्य नाम");

		String filePathPhoto = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\centralvista\\testdata\\photo.jpg";
		photoselectorAlliedGeneralLS.sendKeys(filePathPhoto);

		String filePathSign = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\centralvista\\testdata\\sinature.jpg";
		signselectorAlliedGeneralLS.sendKeys(filePathSign);
		wait.until(ExpectedConditions.visibilityOf(submitUpdateButtonAlliedGeneralLS));
		wait.until(ExpectedConditions.elementToBeClickable(submitUpdateButtonAlliedGeneralLS)).click();
		js.executeScript("document.body.style.zoom='100%'");
		String exceptMessage = "Information updated successfully";
		ToastUtil.validateToastMessage(driver, exceptMessage);
		By toastLocator = By.cssSelector("div.toast-message");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		
	}

}
