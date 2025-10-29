package com.centralvista.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.centralvista.dataReader.excelReader;
import com.centralvista.testBase.TestBase;

import io.qameta.allure.Step;

public class LSEmpDashBoard  extends TestBase {

	@FindBy(xpath="//*[@id='sidebar']/div/div/ul/li[2]/a/div/span")	
	WebElement drpDownLSEmp;

	@FindBy(xpath="//*[@id='sidebar']/div/div/ul/li[2]/div/a[1]/div/span")
	WebElement drpDownElementAddEmp;

	@FindBy(xpath="//*[@id=sidebar]/div/div/ul/li[2]/div/a[2]/div/span")
	WebElement drpDownElementEmpl;

	@FindBy(xpath="//*[@id='fatherName']")
	WebElement fathersName;
	
	@FindBy(xpath="//*[@id='fullname']") //*[@id="fatherName"]
	WebElement fullName;
	
	//@FindBy(xpath="//*[@id='gender']")
	//WebElement selectGender;
	
	@FindBy(xpath="//*[@class='ng-option ng-star-inserted'][2]/span")
	WebElement dropDownSelectGender;
	
	@FindBy(xpath="//*[@id='dob']")
	WebElement dateOfBirth;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement eMail;
	
	@FindBy(xpath="//*[@id='aadhaarCardNumber']")
	WebElement aadharCardNumber;
	
	@FindBy(xpath="//*[@id='contact']")
	WebElement contactNumber;
	
	////*[@id="alternate_contact_number"]
	@FindBy(xpath="//*[@id='alternate_contact_number']")
	WebElement altContactNumber;
	
	////*[@id="bloodgroup"]
		
	@FindBy(xpath="//*[@id='identificationMark']")
	WebElement identificationMark;
	
	@FindBy(xpath="//*[@id='empId']")
	WebElement empId;
	
	@FindBy(xpath="//*[@id='serviceStartDate']")
	WebElement joiningDate;
	
	@FindBy(xpath="//*[@id='serviceEndDate']") ////*[@id="serviceEndDate"]
	WebElement retirementDate;
	
	@FindBy(xpath="//*[@id='departmentId']/div/div/div[3]/input")
	WebElement secretariat;
	
		
	
   @FindBy(xpath="//*[@role='option'][2]/span")
	WebElement dropDownSecretriat;
	
	@FindBy(xpath="//*[@id='branchId']")
	WebElement branch;
	
	@FindBy(xpath="//*[@role='listbox']/div/div/div[2]")
	WebElement branchDropDown;
	
	@FindBy(xpath="//*[@id='unitId']")
	WebElement unit;
	
	@FindBy(xpath="//*[@class='ng-dropdown-panel-items scroll-host']/child::div[2]/div[2]")
	WebElement unitDropDown;
	
	@FindBy(xpath="//*[contains(text(),'Category')]//parent::div//following-sibling::div/div")
	WebElement category;
	
	@FindBy(xpath="//*[@class='ng-dropdown-panel-items scroll-host']/div[2]/div[2]")
	WebElement dropDownCategory;
	
	@FindBy(xpath="//*[contains(text(),'Designation')]//parent::div//following-sibling::div/div")
	WebElement designation;
	
	@FindBy(xpath="//*[@class='ng-dropdown-panel-items scroll-host']/div[2]/div[4]")
	WebElement dropDowndesignation;
	
	@FindBy(xpath="//*[@id='gender']/div/div/div[3]/input")////*[@id='gender']/option[2] //*[@id="gender"]/div/div/div[2]/input
	WebElement gender;
	
	@FindBy(xpath="//*[@id='officeContact']")
	WebElement officeContactNumber;
	
	@FindBy(xpath="//*[@id='faxNumber']")
	WebElement faxNumber;
	
	@FindBy(xpath="//*[@id='currentFlatNumber']")
	WebElement flatNo;
	 
	@FindBy(xpath="//*[@id='permanentFlatNumber']")
	WebElement flatNoPermanent;
	
	@FindBy(xpath="//*[@id='permanentLocality']")////*[@id="currentLocality"]
	WebElement permanentLocality;
	
	@FindBy(xpath="//*[@id='currentLocality']")////*[@id="currentLocality"]
	WebElement currentLocality;
	
	
	
	@FindBy(xpath="//*[@id='permanentLocality']")//permanent locality
	WebElement currentPearmentLocality;
	
	@FindBy(xpath="//*[@id='currentState']")
	WebElement statePresentAddress;
	
	
	@FindBy(xpath="//*[@id='currentState']/ng-dropdown-panel/div/div/div[2]/span")////*[@id="currentState"]/option[6]
	WebElement statePresentAddressDropDownOption;
	
	@FindBy(xpath="//*[@id='permanentState']")
	WebElement statePermanentAddress;
	
	@FindBy(xpath="//*[@id='permanentState']/option[6]")
	WebElement statePermanentAddressDropDownOption;
	
	
	@FindBy(xpath="//*[@id='currentCity']")
	WebElement cityForPresentAddress;
	
	@FindBy(xpath="//*[@id='permanentCity']")
	WebElement cityForPremanentAddress;
	
	@FindBy(xpath="//*[@id='permanentPincode']")
	WebElement pinCodePremanent;
	
	@FindBy(xpath="//*[@id='currentPincode']")
	WebElement pinCode;
	
	@FindBy(xpath="//*[@id='currentFromDate']")
	WebElement since;
	
    @FindBy(xpath="//button[@class='previous']")
    WebElement calendarBackButton;
    
    @FindBy(xpath="//button[@class='next']")
    WebElement calendarForwardButton;
    
    
    
    ///html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[1]/span
    //html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[1]/span
    
    @FindBy(xpath="//table[@class='days weeks']/tbody/tr[2]/td[3]")
    WebElement calendarBackDatePicker;
    
    @FindBy(xpath="//table[@class='days weeks']/tbody/tr[3]/td[3]")
    WebElement calendarForwardDatePicker;
    
    @FindBy(xpath="//*[@id='bloodgroup']") ////*[@id="a4e3a5620427-1"]/span
    WebElement bloodGroup;
    
   @FindBy(xpath="//*[@id='bloodgroup']/ng-dropdown-panel/div/div/div[2]/span")
    WebElement bloodGroupDropDown;
    
    @FindBy(xpath="//*[@id='inlineCheckbox1']") ////*[@id="inlineCheckbox1"]
    WebElement chkBoxSameAsPresentAddress;
    //
    
    @FindBy(xpath="//*[@id='flexCheckDefault']")
    WebElement chkBoxIAgree;
    
    @FindBy(xpath="/html/body/app-root/app-ls-employee-dashboard/div/div/main/app-add-ls-emp/div/div/div[2]/div[2]/form/div[6]/div[3]/div/button")
    WebElement btnSubmit;
    
    @FindBy(xpath="//*[contains(text(),'Employee List')]")
    WebElement hLinkEmployeeList;
    
    //html/body/app-root/app-ls-employee-dashboard/div/div/main/app-add-ls-emp/div/div/div[2]/div[2]/form/div[6]/div[3]/div/button
    
    String actualMessageFromWebPage;
    excelReader xlReader;
    String sheetName="AddNewEmployee";
    String emp_id_from_testData;
    public  Logger log=Logger.getLogger("LSEmpDashBoard");
    public LSEmpDashBoard() throws IOException {
			PageFactory.initElements(TestBase.getDriver(), this);
			xlReader=new excelReader();
			xlReader=new excelReader(excelReader.TESTDATA_SHEET_PATH);
			
			// TODO Auto-generated constructor stub
		}

    @Step("Executing the method: {method} ")
    public String addNewEmp() throws InterruptedException
	{
		//Thread.sleep(16000);
		
		//System.out.println("before");
		drpDownLSEmp.click();
		//System.out.println("after");
		drpDownElementAddEmp.click();
		Thread.sleep(5000);
		log.info("Entering in the Personal Details Field");
		//************Personal Details******************* 
		for(int row=2;row<3;row++)
		{
		for (int col=0;col<14;col++)
		{
				
		//fullName.sendKeys("abcd");
		fullName.sendKeys(xlReader.getCellData(sheetName, col, row));
		fathersName.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		Thread.sleep(5000);
		
		
		gender.click();
		Thread.sleep(5000);
		dropDownSelectGender.click();
		
		//Hemant
		//Thread.sleep(5000);
		Actions actions_dob = new Actions(TestBase.getDriver());
		actions_dob.moveToElement(dateOfBirth).click().build().perform();
		//dateOfBirth.click();
		Thread.sleep(5000);
		calendarBackButton.click();
		Thread.sleep(5000);
		calendarBackDatePicker.click();
	
		eMail.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		String  b=xlReader.getCellData(sheetName, ++col, row);
		//System.out.println("++++++++++++++++++++++"+b);
		//aadharCardNumber.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		aadharCardNumber.sendKeys(b);
		contactNumber.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		altContactNumber.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		
		bloodGroup.click();
		bloodGroupDropDown.click();
		
		//bloodGroupDropDown.click();
		identificationMark.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		
		//*********Service Details  Section************
		log.info("Entering in the Service Details  Section");
		
		emp_id_from_testData=xlReader.getCellData(sheetName, ++col, row);
		empId.sendKeys(emp_id_from_testData);
		Actions act_joiningDate=new Actions(TestBase.getDriver());
		act_joiningDate.moveToElement(joiningDate).click().build().perform();
		//joiningDate.click();
		calendarBackButton.click();
		calendarBackDatePicker.click();
		Thread.sleep(5000);
		
		/*JavascriptExecutor executor_retirementDate = (JavascriptExecutor)TestBase.getDriver();
		executor_retirementDate.executeScript("arguments[0].click();", retirementDate);
		executor_retirementDate.executeScript("arguments[0].click();", calendarForwardButton);
		executor_retirementDate.executeScript("arguments[0].click();", calendarForwardDatePicker);
        Thread.sleep(2000);
		*/
		
		Actions actions_retirementDate = new Actions(TestBase.getDriver());
		actions_retirementDate.moveToElement(retirementDate).click().build().perform();
		//retirementDate.click();
		Thread.sleep(3000);
		calendarForwardButton.click();
		Thread.sleep(3000);
		calendarForwardDatePicker.click();
		
		//WebTestBase.getDriver()Wait waitSecretariat =new WebTestBase.getDriver()Wait(TestBase.getDriver(),Duration.ofSeconds(20));
		//waitSecretariat.until(ExpectedConditions.elementToBeClickable(secretariat));
		Actions actions_secretariat = new Actions(TestBase.getDriver());
		actions_secretariat.moveToElement(secretariat).click().build().perform();
		//secretariat.click();
		Thread.sleep(5000);
		dropDownSecretriat.click();
		branch.click();
		Thread.sleep(5000);
		branchDropDown.click();
		unit.click();
		Thread.sleep(5000);
		unitDropDown.click();
		//Thread.sleep(7000);
		Actions actions = new Actions(TestBase.getDriver());

		actions.moveToElement(category).click().perform();
		
		//category.click();
		dropDownCategory.click();
		Thread.sleep(5000);
		designation.click();
		Thread.sleep(5000);
	    dropDowndesignation.click();
		officeContactNumber.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		faxNumber.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		
		//*****************Permanent address************
		log.info("Entering in the Permanent Address Section");
		flatNoPermanent.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		currentPearmentLocality.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		Thread.sleep(5000);
		statePermanentAddress.click();
		statePermanentAddressDropDownOption.click();
		cityForPremanentAddress.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		pinCodePremanent.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		
		//**********Present Address Section********** 
		
		log.info("Entering in the Present Address Section");
		flatNo.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		currentLocality.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		Thread.sleep(5000);
		statePresentAddress.click();
		statePresentAddressDropDownOption.click();
		cityForPresentAddress.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		pinCode.sendKeys(xlReader.getCellData(sheetName, ++col, row));
		Actions actions_since = new Actions(TestBase.getDriver());
		actions_since.moveToElement(since).click().perform();
		//since.click();
		calendarBackButton.click();
		calendarBackDatePicker.click();
			
		JavascriptExecutor executor = (JavascriptExecutor)TestBase.getDriver();
        executor.executeScript("arguments[0].click();", chkBoxSameAsPresentAddress);
        executor.executeScript("arguments[0].click();", chkBoxIAgree);
        //Thread.sleep(5000);
        executor.executeScript("arguments[0].click();", btnSubmit);
        //Actions actionBtnClick=new Actions(TestBase.getDriver());
        //actionBtnClick.moveToElement(btnSubmit).click().build().perform();
          
        
        Thread.sleep(2000);

        actualMessageFromWebPage=TestBase.getDriver().findElement(By.xpath("//*[@id='toast-container']/div/div[2]")).getText();
        log.info("The original message after registering the employee is"+actualMessageFromWebPage);

//String Expected="Employee registered successfully with EMP-ID: "+emp_id_from_testData;

//System.out.println("OOOOOOOO"+Original);
//System.out.println("OOOOOOOO"+Expected);
		 
		 }
		//return Original;	
		}
		//return Original;		 
		//System.out.println("uyuyuyeuryeuryeyr");
		return actualMessageFromWebPage;
		}
	
    @Step("Executing the  method: {method} ")
    public LSEmpDashBoardEmpList clickEmployeeList() throws FileNotFoundException
	{
		Actions action=new Actions(TestBase.getDriver());
		action.moveToElement(hLinkEmployeeList).click().build().perform();
		//hLinkEmployeeList.click();
		return new LSEmpDashBoardEmpList();
	}
public void viewEmpList()

{
		
		
}


		
}
