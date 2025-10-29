	package com.centralvista.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.centralvista.Listener.TestListener;
import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.EmpHomePage;
import com.centralvista.pages.LSEmpDashBoard;
import com.centralvista.pages.LSEmpDashBoardEmpList;
import com.centralvista.pages.Login;
import com.centralvista.testBase.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


//@Listeners(com.centralvista.utility.TestListener.class)

@Listeners({TestListener.class})
@Epic("Quarter 1 Release")
@Feature("Feature 2: Employee Registration")
@Story("This test case belongs to userStory-457 of Sprint1")
public class LSEmpDashBoardTest extends TestBase{


	Login login;
	EmpHomePage empHome;
	excelReader xlReader;
	LSEmpDashBoard lsEmpDB;
	LSEmpDashBoardEmpList lsEmpDBViewEmpList;
	public static Logger APPLICATION_LOGS;	
	String sheetName = "LoginHomePage";
	public  Logger log=Logger.getLogger("LoginTest");
	public  String expectedResult;	
	
	public LSEmpDashBoardTest() throws FileNotFoundException
	{
		
		super();
	}
	@BeforeClass
	public void setUp()throws IOException
	{	initialization();
		login = new Login();
		empHome=new EmpHomePage();
		//xlReader=new excelReader();
		lsEmpDB=new LSEmpDashBoard();
		xlReader=new excelReader(excelReader.TESTDATA_SHEET_PATH);
		lsEmpDBViewEmpList =new LSEmpDashBoardEmpList();
	}
   
   @Test(priority=1,description="Add a new employee with all mandatory and optional fields")
	@Description("Registering a non existing employee by providing the correct field values")
	//@Story("This test case belongs to userStory-456")
	@Severity(SeverityLevel.CRITICAL)
public void addNewEmployee() throws FileNotFoundException, InterruptedException
{
	System.out.println(" I am in addnew Employee");
	    String userName=xlReader.getCellData(sheetName, 1,2);
	    String password=xlReader.getCellData(sheetName, 2,2);
	    //String a=xlReader.getCellData(sheetName,"UserName", 2);
	    expectedResult="Employee registered successfully with EMP-ID: 4567";
	    //System.out.println("+++++++"+a);
	    //System.out.println("+++++++"+password);
		log.info("Entered userName is"+userName);
		log.info("Entered password is"+password);
		login.loginWithValidCredentials(userName, password);
		Thread.sleep(5000);
		empHome.selectRole();
		Thread.sleep(5000);
	 	// Add a new Employee
		Assert.assertEquals(lsEmpDB.addNewEmp(), expectedResult);
 }
  
}
