package com.centralvista.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.centralvista.dataReader.excelReader;
import com.centralvista.testBase.TestBase;

public class LSRetiredEmpDashBoard extends TestBase
{
	
	Actions actions = new Actions(TestBase.getDriver());
	String actualMessageFromWebPage;
	JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
	int count=0;
	 public LSRetiredEmpDashBoard() throws IOException 
	 {
		 	excelReader xlReader;
		    String sheetName="AddRetiredEmployee";
		    String emp_id_from_testData;
			PageFactory.initElements(TestBase.getDriver(), this);
			xlReader=new excelReader();
			xlReader=new excelReader(excelReader.TESTDATA_SHEET_PATH);
			
	}


	@FindBy(xpath ="//*[@class='sidebar-toggle js-sidebar-toggle collapsed']")
	WebElement sideEmpBar;	
	
	//@FindBy(xpath="//*[@id=\"sidebar\"]/div/div/ul/li[2]/a/div/span")
	//WebElement drpDownLSEmp;
	
	
	@FindBy(xpath="//*[contains(text(),'LS Employees ')]")
	WebElement drpDownLSEmp;
	
	@FindBy(xpath="//*[contains(text(),'Add Retired Employee')]")
	WebElement drpDownElementAddRetiredEmp;
	
	@FindBy(xpath="//input[@id='fullname']")
	WebElement fullNameRetired;
	
	@FindBy(xpath="//input[@id='fatherName']")
	WebElement fatherNameRetired;
	
	@FindBy(xpath="//input[@id='motherName']")
	WebElement motherNameRetired;
	
	@FindBy(xpath="//*[@id='gender']")
	WebElement selectGenderRetired;
	
	@FindBy(xpath="//*[contains(text(),'Male')]")
	WebElement maleGenderRetired;
	
	@FindBy(xpath="//*[@id='dob']")
	WebElement dateOfBirth;
	
	@FindBy(xpath="//table[@class='days weeks']/tbody/tr[2]/td[4]")
    WebElement calendarBackButtonRetired;
    
    @FindBy(xpath="//button[@class='next']")
    WebElement calendarForwardButtonRetired;
    
    @FindBy(xpath="//table[@class='days weeks']/tbody/tr[3]/td[3]")
    WebElement calendarForwardDatePickerRetired;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailRetired;
	
	
	@FindBy(xpath="//input[@id='aadhaarCardNumber']")
	WebElement aadhaarCardNoRetired;
	
	@FindBy(xpath="//input[@id='contact']")
	WebElement contactNoRetired;
	
	@FindBy(xpath="//input[@id='alternate_contact_number']")
	WebElement alternatecontactNoRetired;
	
	@FindBy(xpath="//*[@id='bloodgroup']") ////*[@id="a4e3a5620427-1"]/span
	WebElement bloodGroupRetired;
	 
	@FindBy(xpath="//*[@id='bloodgroup']/ng-dropdown-panel/div/div/div[2]/span")
	WebElement bloodGroupDropDownRetired;
	
	@FindBy(xpath="//input[@id='identificationMark']")
	WebElement identificationMarkRetired;
	
	@FindBy(xpath="//input[@id='empId']")
	WebElement empIdRetired;
	
	@FindBy(xpath="//*[@id='serviceStartDate']")
	WebElement joiningDateRetired;
	
	@FindBy(xpath="//*[@id='serviceEndDate']") ////*[@id="serviceEndDate"]
	WebElement retirementcardDateRetired;
	
	@FindBy(xpath="//*[@id='retirementDate']") ////*[@id="serviceEndDate"]
	WebElement retirementDateRetired;
	
	@FindBy(xpath="//*[@id='departmentId']/div/div/div[3]/input")
	WebElement secretariatRetired;
	
	@FindBy(xpath="//*[contains(text(),'Lok Sabha Secretariat')]")
	WebElement secretariatLokRetired;
	
	
	@FindBy(xpath = "//ng-select[@id='branchId']")
	WebElement servicesRetiredList;
	
	@FindBy(xpath = "//ng-select[@id='branchId']//div[6]//span")
	WebElement servicesRetiredSelector;

	
	
	@FindBy(xpath = "//ng-select[@id='unitId']")
	WebElement unitRetiredList;
	
	@FindBy(xpath = "//ng-select[@id='unitId']//div[3]//span")
	WebElement unitRetiredSelector;
	
	
	
	@FindBy(xpath = "//ng-select[@id='classId']")
	WebElement categoryRetiredList;
	
	@FindBy(xpath = "//ng-select[@id='classId']//div[2]//div[2]//span")
	WebElement categoryRetiredSelector;
	
	@FindBy(xpath ="//ng-select[@id='designationId']")
	WebElement designationRetiredList;
	
	@FindBy(xpath ="//ng-select[@id='designationId']//div[3]//span")
	WebElement designationRetiredSelector;
	
	
	@FindBy(xpath="//input[@id='officeContact']")
	WebElement officeContactRetired;
	
	@FindBy(xpath="//input[@id='faxNumber']")
	WebElement faxNumberRetired;
	
	@FindBy(xpath="//input[@id='permanentFlatNumber']")
	WebElement permanentFlatNoRetired;

	@FindBy(xpath="//input[@id='permanentLocality']")
	WebElement permanentLocalityRetired;
	
	@FindBy(xpath="//ng-select[@id='permanentState']")
	WebElement permanentStateRetiredList;
	
	@FindBy(xpath="//ng-select[@id='permanentState']//div//div[2]//div[3]//span")
	WebElement permanentStateRetiredSelector;
	
	
	@FindBy(xpath="//input[@id='permanentCity']")
	WebElement permanentCityRetired;
	
	@FindBy(xpath="//input[@id='permanentPincode']")
	WebElement currentPincodeRetired;
	

    @FindBy(xpath="//input[@id='inlineCheckbox1']") ////*[@id="inlineCheckbox1"]
    WebElement checkBoxSameAsPresentAddressRetired;
    
    @FindBy(xpath="//input[@id='flexCheckDefault']")
    WebElement iAgreeConsentRetired;
    
    @FindBy(xpath = "//*[contains(text(),'Submit')]")
    WebElement submitButtonRetired;
    
    		
    
//    @FindBy(xpath="//button[@class='previous']")
//    WebElement calendarBackButtonRetired;
//    
//    @FindBy(xpath="//button[@class='next']")
//    WebElement calendarForwardButtonRetired;
	
	public String addNewRetiredEmp(String fullName,String fatherName,
			String motherName,String emailId,String aadharCardNo,String contactNo,String alternateContactNo
			,String idMark,String empId,String officeContactNo,String faxNumber,String permanentFlatNo,String permanentLocatalityNo
			,String permanentCity,String currentPincode) throws InterruptedException 
	{
		actions.moveToElement(unitRetiredList).perform(); 
		
		//js.executeScript("document.body.style.zoom='45%'");
		

		//System.out.println("I am dropdown of LS employee dropdown");
		//sideEmpBar.click();
		if(count==0)
		{
			TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//Thread.sleep(5000);
		//	System.out.println("I am dropdown of LS employee dropdown");
			drpDownLSEmp.click();
			System.out.println("I am clickable");
			TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//Thread.sleep(2000);
			drpDownElementAddRetiredEmp.click();
			
		}
		count++;
		fullNameRetired.sendKeys(fullName);
		fatherNameRetired.sendKeys(fatherName);
		motherNameRetired.sendKeys(motherName);
		
		selectGenderRetired.click();
		maleGenderRetired.click();
		
		//Code of selecting date of birth
	//	Actions actions_dob = new Actions(driver);
		actions.moveToElement(dateOfBirth).click().build().perform();
		calendarBackButtonRetired.click();
	
		emailRetired.sendKeys(emailId);
		//Actions actions = new Actions(driver);
		
		
		aadhaarCardNoRetired.sendKeys(aadharCardNo);
		contactNoRetired.sendKeys(contactNo);
		alternatecontactNoRetired.sendKeys(alternateContactNo);
		
		bloodGroupRetired.click();
		bloodGroupDropDownRetired.click();
		
		identificationMarkRetired.sendKeys(idMark);
		empIdRetired.sendKeys(empId);
		
		//joiningDate
	//	Actions act_joiningDate=new Actions(driver);
		actions.moveToElement(joiningDateRetired).click().build().perform();
		//joiningDate.click();
		calendarBackButtonRetired.click();
	
		
		
		//card valid upto date
	//	Actions actions_retirementcardDate = new Actions(driver);
		actions.moveToElement(retirementcardDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		//Retirement date
	//	Actions actions_retirementDate = new Actions(driver);
		actions.moveToElement(retirementDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		/*actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll Down
		actions.sendKeys(Keys.PAGE_UP).perform();   // Scroll Up
		for (int i = 0; i < 1; i++) {  // Scroll down 3 times
		    actions.sendKeys(Keys.ARROW_DOWN).perform();
		    Thread.sleep(200);
		}*/
				
		secretariatRetired.click();
		secretariatLokRetired.click();
		
		servicesRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		servicesRetiredSelector.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		unitRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		unitRetiredSelector.click();
		
		categoryRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		categoryRetiredSelector.click();
    	
		designationRetiredList.click();
		designationRetiredSelector.click();
		
		officeContactRetired.sendKeys(officeContactNo);
		faxNumberRetired.sendKeys(faxNumber);
		permanentFlatNoRetired.sendKeys(permanentFlatNo);
		permanentLocalityRetired.sendKeys(permanentLocatalityNo);
		permanentStateRetiredList.click();
		permanentStateRetiredSelector.click();
		permanentCityRetired.sendKeys(permanentCity);
		currentPincodeRetired.sendKeys(currentPincode);
		checkBoxSameAsPresentAddressRetired.click();
		iAgreeConsentRetired.click();
		submitButtonRetired.click();
		
		// actualMessageFromWebPage=driver.findElement(By.xpath("//*[@id='toast-container']//div[2]")).getText();
	//	actualMessageFromWebPage=driver.findElement(By.xpath("//*[contains(text(),'SUCCESS')]")).getText();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		actualMessageFromWebPage=TestBase.getDriver().findElement(By.xpath("//div[@class='overlay-container']//div[2]")).getText();
		js.executeScript("document.body.style.zoom='100%'");
		return actualMessageFromWebPage;
		
	}


	public String addExistingEmailRetiredEmp() throws InterruptedException 
	{
		Thread.sleep(10000);
		js.executeScript("document.body.style.zoom='45%'");
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//drpDownLSEmp.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//drpDownElementAddRetiredEmp.click();
		
		fullNameRetired.sendKeys("Aman");
		fatherNameRetired.sendKeys("Om kumar");
		motherNameRetired.sendKeys("durga singh");
		
		selectGenderRetired.click();
		maleGenderRetired.click();
		
		
		
		//Code of selecting date of birth
	//	Actions actions_dob = new Actions(driver);
		actions.moveToElement(dateOfBirth).click().build().perform();
		calendarBackButtonRetired.click();
	
		emailRetired.sendKeys("srihari1@gmail.com");
		//Actions actions = new Actions(driver);
		
		
		aadhaarCardNoRetired.sendKeys("000000000999");
		contactNoRetired.sendKeys("7050000065");
		alternatecontactNoRetired.sendKeys("01207054375331");
		
		bloodGroupRetired.click();
		bloodGroupDropDownRetired.click();
		
		identificationMarkRetired.sendKeys("Mole on head");
		empIdRetired.sendKeys("70400");
		
		//joiningDate
	//	Actions act_joiningDate=new Actions(driver);
		actions.moveToElement(joiningDateRetired).click().build().perform();
		//joiningDate.click();
		calendarBackButtonRetired.click();
	
		
		
		//card valid upto date
	//	Actions actions_retirementcardDate = new Actions(driver);
		actions.moveToElement(retirementcardDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		//Retirement date
	//	Actions actions_retirementDate = new Actions(driver);
		actions.moveToElement(retirementDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		/*actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll Down
		actions.sendKeys(Keys.PAGE_UP).perform();   // Scroll Up
		for (int i = 0; i < 1; i++) {  // Scroll down 3 times
		    actions.sendKeys(Keys.ARROW_DOWN).perform();
		    Thread.sleep(200);
		}*/
				
		secretariatRetired.click();
		secretariatLokRetired.click();
		
		servicesRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		servicesRetiredSelector.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		unitRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		unitRetiredSelector.click();
		
		categoryRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		categoryRetiredSelector.click();
    	
		designationRetiredList.click();
		designationRetiredSelector.click();
		
		officeContactRetired.sendKeys("012065626595");
		faxNumberRetired.sendKeys("012065626595");
		permanentFlatNoRetired.sendKeys("12");
		permanentLocalityRetired.sendKeys("abc123");
		permanentStateRetiredList.click();
		permanentStateRetiredSelector.click();
		permanentCityRetired.sendKeys("Noida");
		currentPincodeRetired.sendKeys("203203");
		checkBoxSameAsPresentAddressRetired.click();
		iAgreeConsentRetired.click();
		submitButtonRetired.click();
		
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		actualMessageFromWebPage=TestBase.getDriver().findElement(By.xpath("//div[@class='overlay-container']//div//div//div")).getText();

		//System.out.println("I am actual message->" +actualMessageFromWebPage);
		js.executeScript("document.body.style.zoom='100%'");
		return actualMessageFromWebPage;
	
	}


	public String addContactNumberRetiredEmp() throws InterruptedException 
	{
		TestBase.getDriver().navigate().refresh();
		Thread.sleep(10000);
		js.executeScript("document.body.style.zoom='45%'");
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//drpDownLSEmp.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//drpDownElementAddRetiredEmp.click();
		
		fullNameRetired.sendKeys("Aman");
		fatherNameRetired.sendKeys("Om kumar");
		motherNameRetired.sendKeys("durga singh");
		
		selectGenderRetired.click();
		maleGenderRetired.click();
		
		
		
		//Code of selecting date of birth
	//	Actions actions_dob = new Actions(driver);
		actions.moveToElement(dateOfBirth).click().build().perform();
		calendarBackButtonRetired.click();
	
		emailRetired.sendKeys("srihari23@gmail.com");
		//Actions actions = new Actions(driver);
		
		
		aadhaarCardNoRetired.sendKeys("000000000999");
		contactNoRetired.sendKeys("7054375330");
		alternatecontactNoRetired.sendKeys("01207054375331");
		
		bloodGroupRetired.click();
		bloodGroupDropDownRetired.click();
		
		identificationMarkRetired.sendKeys("Mole on head");
		empIdRetired.sendKeys("70400");
		
		//joiningDate
	//	Actions act_joiningDate=new Actions(driver);
		actions.moveToElement(joiningDateRetired).click().build().perform();
		//joiningDate.click();
		calendarBackButtonRetired.click();
	
		
		
		//card valid upto date
	//	Actions actions_retirementcardDate = new Actions(driver);
		actions.moveToElement(retirementcardDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		//Retirement date
	//	Actions actions_retirementDate = new Actions(driver);
		actions.moveToElement(retirementDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		/*actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll Down
		actions.sendKeys(Keys.PAGE_UP).perform();   // Scroll Up
		for (int i = 0; i < 1; i++) {  // Scroll down 3 times
		    actions.sendKeys(Keys.ARROW_DOWN).perform();
		    Thread.sleep(200);
		}*/
				
		secretariatRetired.click();
		secretariatLokRetired.click();
		
		servicesRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		servicesRetiredSelector.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		unitRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		unitRetiredSelector.click();
		
		categoryRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		categoryRetiredSelector.click();
    	
		designationRetiredList.click();
		designationRetiredSelector.click();
		
		officeContactRetired.sendKeys("012065626595");
		faxNumberRetired.sendKeys("012065626595");
		permanentFlatNoRetired.sendKeys("12");
		permanentLocalityRetired.sendKeys("abc123");
		permanentStateRetiredList.click();
		permanentStateRetiredSelector.click();
		permanentCityRetired.sendKeys("Noida");
		currentPincodeRetired.sendKeys("203203");
		checkBoxSameAsPresentAddressRetired.click();
		iAgreeConsentRetired.click();
		submitButtonRetired.click();
		
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		actualMessageFromWebPage=TestBase.getDriver().findElement(By.xpath("//div[@class='overlay-container']//div//div//div")).getText();

		//System.out.println("I am actual message->" +actualMessageFromWebPage);
		js.executeScript("document.body.style.zoom='100%'");
		return actualMessageFromWebPage;
	}


	public String addAddharCardNumberRetiredEmp() throws InterruptedException {
		TestBase.getDriver().navigate().refresh();
		Thread.sleep(10000);
		js.executeScript("document.body.style.zoom='45%'");
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//drpDownLSEmp.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//drpDownElementAddRetiredEmp.click();
		
		fullNameRetired.sendKeys("Aman");
		fatherNameRetired.sendKeys("Om kumar");
		motherNameRetired.sendKeys("durga singh");
		
		selectGenderRetired.click();
		maleGenderRetired.click();
		
		
		
		//Code of selecting date of birth
	//	Actions actions_dob = new Actions(driver);
		actions.moveToElement(dateOfBirth).click().build().perform();
		calendarBackButtonRetired.click();
	
		emailRetired.sendKeys("srihari23@gmail.com");
		//Actions actions = new Actions(driver);
		
		
		aadhaarCardNoRetired.sendKeys("0001236523458");
		contactNoRetired.sendKeys("9054375330");
		alternatecontactNoRetired.sendKeys("01207054375331");
		
		bloodGroupRetired.click();
		bloodGroupDropDownRetired.click();
		
		identificationMarkRetired.sendKeys("Mole on head");
		empIdRetired.sendKeys("003574");
		
		//joiningDate
	//	Actions act_joiningDate=new Actions(driver);
		actions.moveToElement(joiningDateRetired).click().build().perform();
		//joiningDate.click();
		calendarBackButtonRetired.click();
	
		
		
		//card valid upto date
	//	Actions actions_retirementcardDate = new Actions(driver);
		actions.moveToElement(retirementcardDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		//Retirement date
	//	Actions actions_retirementDate = new Actions(driver);
		actions.moveToElement(retirementDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		/*actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll Down
		actions.sendKeys(Keys.PAGE_UP).perform();   // Scroll Up
		for (int i = 0; i < 1; i++) {  // Scroll down 3 times
		    actions.sendKeys(Keys.ARROW_DOWN).perform();
		    Thread.sleep(200);
		}*/
				
		secretariatRetired.click();
		secretariatLokRetired.click();
		
		servicesRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		servicesRetiredSelector.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		unitRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		unitRetiredSelector.click();
		
		categoryRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		categoryRetiredSelector.click();
    	
		designationRetiredList.click();
		designationRetiredSelector.click();
		
		officeContactRetired.sendKeys("012065626595");
		faxNumberRetired.sendKeys("012065626595");
		permanentFlatNoRetired.sendKeys("12");
		permanentLocalityRetired.sendKeys("abc123");
		permanentStateRetiredList.click();
		permanentStateRetiredSelector.click();
		permanentCityRetired.sendKeys("Noida");
		currentPincodeRetired.sendKeys("203203");
		checkBoxSameAsPresentAddressRetired.click();
		iAgreeConsentRetired.click();
		submitButtonRetired.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		actualMessageFromWebPage=TestBase.getDriver().findElement(By.xpath("//div[@class='overlay-container']//div//div//div")).getText();

	//	System.out.println("I am actual message->" +actualMessageFromWebPage);
		js.executeScript("document.body.style.zoom='100%'");
		return actualMessageFromWebPage;
	}


	public String addDuplicateEmployeeIDRetiredEmp() throws InterruptedException 
	{
		TestBase.getDriver().navigate().refresh();
		Thread.sleep(10000);
		js.executeScript("document.body.style.zoom='45%'");
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//drpDownLSEmp.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//drpDownElementAddRetiredEmp.click();
		
		fullNameRetired.sendKeys("Aman");
		fatherNameRetired.sendKeys("Om kumar");
		motherNameRetired.sendKeys("durga singh");
		
		selectGenderRetired.click();
		maleGenderRetired.click();
		
		
		
		//Code of selecting date of birth
	//	Actions actions_dob = new Actions(driver);
		actions.moveToElement(dateOfBirth).click().build().perform();
		calendarBackButtonRetired.click();
	
		emailRetired.sendKeys("srihari23@gmail.com");
		//Actions actions = new Actions(driver);
		
		
		aadhaarCardNoRetired.sendKeys("002865292149");
		contactNoRetired.sendKeys("9054375345");
		alternatecontactNoRetired.sendKeys("01207054375331");
		
		bloodGroupRetired.click();
		bloodGroupDropDownRetired.click();
		
		identificationMarkRetired.sendKeys("Mole on head");
		empIdRetired.sendKeys("123574");
		
		//joiningDate
	//	Actions act_joiningDate=new Actions(driver);
		actions.moveToElement(joiningDateRetired).click().build().perform();
		//joiningDate.click();
		calendarBackButtonRetired.click();
	
		
		
		//card valid upto date
	//	Actions actions_retirementcardDate = new Actions(driver);
		actions.moveToElement(retirementcardDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		//Retirement date
	//	Actions actions_retirementDate = new Actions(driver);
		actions.moveToElement(retirementDateRetired).click().build().perform();
		calendarForwardButtonRetired.click();
		calendarForwardButtonRetired.click();
		calendarForwardDatePickerRetired.click();
		
		/*actions.sendKeys(Keys.PAGE_DOWN).perform(); // Scroll Down
		actions.sendKeys(Keys.PAGE_UP).perform();   // Scroll Up
		for (int i = 0; i < 1; i++) {  // Scroll down 3 times
		    actions.sendKeys(Keys.ARROW_DOWN).perform();
		    Thread.sleep(200);
		}*/
				
		secretariatRetired.click();
		secretariatLokRetired.click();
		
		servicesRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		servicesRetiredSelector.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		unitRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		unitRetiredSelector.click();
		
		categoryRetiredList.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		categoryRetiredSelector.click();
    	
		designationRetiredList.click();
		designationRetiredSelector.click();
		
		officeContactRetired.sendKeys("012065626595");
		faxNumberRetired.sendKeys("012065626595");
		permanentFlatNoRetired.sendKeys("12");
		permanentLocalityRetired.sendKeys("abc123");
		permanentStateRetiredList.click();
		permanentStateRetiredSelector.click();
		permanentCityRetired.sendKeys("Noida");
		currentPincodeRetired.sendKeys("203203");
		checkBoxSameAsPresentAddressRetired.click();
		iAgreeConsentRetired.click();
		submitButtonRetired.click();
		TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		actualMessageFromWebPage=TestBase.getDriver().findElement(By.xpath("//div[@class='overlay-container']//div//div//div")).getText();

	//	System.out.println("I am actual message->" +actualMessageFromWebPage);
		js.executeScript("document.body.style.zoom='100%'");
		return actualMessageFromWebPage;

	}


	public String searchRetiredEmpByEmpId() 
	{
		drpDownLSEmp.click();
		
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
