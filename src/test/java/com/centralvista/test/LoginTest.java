package com.centralvista.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.centralvista.Listener.TestListener;
import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.EmpHomePage;
import com.centralvista.pages.Login;
import com.centralvista.testBase.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
//import com.crm.qa.pages.LoginPage;
//import com.crm.qa.util.TestUtil;

@Listeners({TestListener.class})
@Epic("Quarter 1 Release")
@Feature("Feature 1 :Login Test")
@Story("This test case belongs to userStory-456 of Sprint1")
public class LoginTest extends TestBase{

	Login login;
	EmpHomePage empHome;
	excelReader xlReader;
	String sheetName = "LoginHomePage";
	public static String EmpHomeServicesHeader = "Services";
	public  Logger log=Logger.getLogger("LoginTest");	
	
	//public static final Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	//Logger logger = new 
	//APPLICATION_LOGS=LogManager.getLogger(LoginTest.class);
	public LoginTest() throws FileNotFoundException
	{
		super();
	}
	
	@BeforeSuite
	public void printTestHeader()
	{
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("                                   TEST EXECUTION STARTED                                       ");
		System.out.println("------------------------------------------------------------------------------------------------------ ");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp()throws IOException
	{	initialization();
		login = new Login();
		//empHome=new EmpHomePage();
		//xlReader=new excelReader();
		xlReader=new excelReader(excelReader.TESTDATA_SHEET_PATH);
	}
	//@DataProvider
	//public Object[][] getCRMTestData() throws InvalidFormatException{
	//	Object data[][] = xlReader.getTestData(sheetName);
		//return data;
	//}
	
/*	@Test(priority=1, dataProvider="getCRMTestData")
	public void loginWithValidCredentials(String TCID,String username,String password){
		
		System.out.println("i am in login Test");
		//APPLICATION_LOGS.debug("I am in the root logger");
		try {
			empHome = login.getLogin(CONFIG.getProperty("userName"), CONFIG.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//home = login.getLogin(, "));	
		System.out.println(login.getCurrentUrl());
		
		
		System.out.println("username"+username);
		System.out.println("password"+password);
	//Fetch the 1st username password
		String fromExcelFile1=xlReader.getCellData(sheetName, 2, 2);
		String fromExcelFile2=xlReader.getCellData(sheetName, 2, 3);
		System.out.println("+++++++++++++++++++++++++++"+fromExcelFile1);
		System.out.println("+++++++++++++++++++++++++++"+fromExcelFile2);
	
	}
*/
	
	@Test(groups = {"sanity", "regression"}, priority=1,description="Verify that user is able to login with correct username and Password combination")
	@Description("Enter the correct username and password on the login screen")
	//@Story("This test case belongs to userStory-456")
	@Severity(SeverityLevel.BLOCKER)
	
	//@priority("")
	public void getLoginWithValidUserNamePassword() throws FileNotFoundException, InterruptedException
		{
	    String userName=xlReader.getCellData(sheetName, 1,2);
	    String password=xlReader.getCellData(sheetName, 2,2);
	    empHome = login.loginWithValidCredentials(userName, password);
	    Thread.sleep(5000);
		//System.out.println(empHome.getLabelServices());
		//get the labelServices from EmpHomePage
	    String actualTitleFromPage=empHome.getLabelServices();
	   // log.debug("++++++++++++++++++++++++++++++++++"+actualTitleFromPage);
	    //empHome.clickOnVisitor();
		//System.out.println(EmpHomeServicesHeader);
		//System.out.println("Actual title from page "+actualTitleFromPage);
	    Assert.assertEquals(actualTitleFromPage, EmpHomeServicesHeader,"Passed Credentials are Correct");
		//driver.close();
		}
	
//	@Test(priority=2,description="Verify that user is not able to login with incorrect username and Password combination")
//	@Description("Enter the incorrect username and correct password")
//	//@Story("This test case belongs to userStory-456")
//	@Severity(SeverityLevel.CRITICAL)
//	//@Feature("Login Test Functionality")
//		public void getLoginWithInValidPassword() throws FileNotFoundException, InterruptedException
//		{
//	    String userName=xlReader.getCellData(sheetName, 1,3);
//	    String password=xlReader.getCellData(sheetName, 2,3);
//	    String expectedLabel="Authentication failed, please check credentials1";
//	    Assert.assertEquals(login.loginWithInValidCredentials(userName, password), expectedLabel);
//	    //empHome = login.getLogin(userName, password);
//	    //Thread.sleep(5000);
//		
//	    //System.out.println(empHome.getLabelServices());
//		//get the labelServices from EmpHomePage
//	    
//		}
	
	
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}

}