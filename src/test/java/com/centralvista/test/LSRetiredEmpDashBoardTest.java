package com.centralvista.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.EmpHomePage;
import com.centralvista.pages.LSEmpDashBoardEmpList;
import com.centralvista.pages.LSRetiredEmpDashBoard;
import com.centralvista.pages.Login;
import com.centralvista.testBase.TestBase;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LSRetiredEmpDashBoardTest extends TestBase {
	Login login;
	EmpHomePage empHome;
	excelReader xlReader;
	LSRetiredEmpDashBoard lsRetiredEmpDB;
	LSEmpDashBoardEmpList lsEmpDBViewEmpList;
	int count=0;
	
	
	//DataProvider dataProvider = new DataProvider;
	
	public static Logger APPLICATION_LOGS;
	String sheetName = "LoginHomePage";
	public Logger log = Logger.getLogger("LoginTest");
	public String expectedResult;
	

	public LSRetiredEmpDashBoardTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() throws IOException 
	{
		initialization();
		login = new Login();
		login = new Login();
		empHome=new EmpHomePage();
		//xlReader=new excelReader();
		xlReader=new excelReader(excelReader.TESTDATA_SHEET_PATH);
		lsEmpDBViewEmpList =new LSEmpDashBoardEmpList();
		lsRetiredEmpDB=new LSRetiredEmpDashBoard();
	}
	
	@DataProvider(name = "testRetireData")
    public Object[][] loginTestData() 
	{
        return new Object[][]
        		{
                 {"Srihari","Madhusudhan","Aditi","srihari1@gmail.com","0001236523458","7054375330","012065656626323","Mole on head","123574","001206953226","010004236652","14 Abc","Noida 62","Noida","110022"},
                 {"Ram","Madhusudhan","Aditi","ram1234@gmail.com","0001206523458","7054375345","012065656626323","Mole on head","123575","001206953226","010004236652","14 Abc","Noida 62","Noida","110022"}
                 };
	}
	
	@Test(priority = 1 ,dataProvider="testRetireData",description = "To check whether the  user is  able to added retired employee or not")
	@Severity(SeverityLevel.CRITICAL)
	public void addRetiredEmp(String fullName,String fatherName,
			String motherName,String emailId,String aadharCardNo,String contactNo,String alternateContactNo
			,String idMark,String empId,String officeContactNo,String faxNumber,String permanentFlatNo,String permanentLocatalityNo
			,String permanentCity,String currentPincode) throws FileNotFoundException, InterruptedException
	{
		if(count==0)
		{
		//first time
			System.out.println(" I am in addnew Employee");
		    String userName=xlReader.getCellData(sheetName, 1,2);
		    String password=xlReader.getCellData(sheetName, 2,2);
		    //String a=xlReader.getCellData(sheetName,"UserName", 2);
		   // expectedResult="Employee registered successfully with EMP-ID: 4567";
		    //System.out.println("+++++++"+a);
		    //System.out.println("+++++++"+password);
			log.info("Entered userName is"+userName);
			log.info("Entered password is"+password);
			login.loginWithValidCredentials(userName, password);
			TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(2000);
			empHome.selectRole();
			TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
		
		count++;
		
		String actual=lsRetiredEmpDB.addNewRetiredEmp(fullName,fatherName,motherName,emailId,aadharCardNo,contactNo,alternateContactNo,idMark,empId,officeContactNo,faxNumber,permanentFlatNo,permanentLocatalityNo,permanentCity,currentPincode);
		//Assert.assertEquals(actulaMessage, "SUCCESS Retired Employee registered successfully with EMP-ID:");
		String expected = "Retired Employee registered successfully with EMP-ID: ";
		String updatedresult = actual.replaceAll("\\b\\d+\\b", "");

		Assert.assertEquals(updatedresult, expected);
	}
	
	/*
	@Test(priority = 2 ,description = "To check whether the user is able to added duplicate email id or not")
	@Severity(SeverityLevel.CRITICAL)
	public void addDuplicateEmailRetiredEmp() throws FileNotFoundException, InterruptedException
	{
		String actualResponse=lsRetiredEmpDB.addExistingEmailRetiredEmp();
		String excepted ="Email already exists.";
		System.out.println(actualResponse);
		
		Assert.assertEquals(actualResponse, excepted);
	}
	
	
	@Test(priority = 3 ,description = "To check whether the user is able to added duplicate mobile number or not")
	@Severity(SeverityLevel.CRITICAL)
	public void addDuplicateContactNumberRetiredEmp() throws FileNotFoundException, InterruptedException
	{
		String actualResponse=lsRetiredEmpDB.addContactNumberRetiredEmp();
		String excepted ="Contact Number already exists.";
		System.out.println(actualResponse);
		
		Assert.assertEquals(actualResponse, excepted);
	}
	
	@Test(priority = 4 ,description = "To check whether the user is able to added duplicate Addhar Card Number or not")
	@Severity(SeverityLevel.CRITICAL)
	public void addDuplicateAddharCardNumberRetiredEmp() throws FileNotFoundException, InterruptedException
	{
		String actualResponse=lsRetiredEmpDB.addAddharCardNumberRetiredEmp();
		String excepted ="Aadhaar Number already exists.";
		System.out.println(actualResponse);
		
		Assert.assertEquals(actualResponse, excepted);
	}
	
	@Test(priority = 5 ,description = "To check whether the user is able to added duplicate Employee-ID or not")
	@Severity(SeverityLevel.CRITICAL)
	public void addDuplicateEmployeeIDRetiredEmp() throws FileNotFoundException, InterruptedException
	{
		
		String actualResponse=lsRetiredEmpDB.addDuplicateEmployeeIDRetiredEmp();
		String excepted ="EmpId already exists.";
		System.out.println(actualResponse);
		
		Assert.assertEquals(actualResponse, excepted);
	}
	
	@Test(priority = 6 ,description = "To check whether the user is search the added employee on Retired Employees List page or not")
	@Severity(SeverityLevel.CRITICAL)
	public void searchRetiredEmp() throws FileNotFoundException, InterruptedException
	{
		
		String actualResponse=lsRetiredEmpDB.searchRetiredEmpByEmpId();
		String excepted ="EmpId already exists.";
		System.out.println(actualResponse);
		
		Assert.assertEquals(actualResponse, excepted);
	}
	*/
}
