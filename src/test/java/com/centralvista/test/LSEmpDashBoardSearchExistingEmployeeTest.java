package com.centralvista.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

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
@Feature("Feature 2: Employee Search")
@Story("This test case belongs to userStory-458 of Sprint1")
public class LSEmpDashBoardSearchExistingEmployeeTest extends TestBase {

	Login login;
	EmpHomePage empHome;
	excelReader xlReader;
	LSEmpDashBoard lsEmpDB;
	LSEmpDashBoardEmpList lsEmpDBViewEmpList;
	public static Logger APPLICATION_LOGS;	
	String sheetName = "AddNewEmployee";
	public  Logger log=Logger.getLogger("LoginTest");
	String empIdFromTestData;
	String empNameFromTestData;
	
	public LSEmpDashBoardSearchExistingEmployeeTest() throws FileNotFoundException
	{
		
		super();
	}
	@BeforeClass
	public void setUp()throws IOException
	{	//initialization();
		login = new Login();
		empHome=new EmpHomePage();
		//xlReader=new excelReader();
		lsEmpDB=new LSEmpDashBoard();
		xlReader=new excelReader(excelReader.TESTDATA_SHEET_PATH);
		lsEmpDBViewEmpList =new LSEmpDashBoardEmpList();
	}
	@Test(priority=1,description="Verify that application is able to Search the existing employee")
	@Description("Enter the employee Id in the search box")
	//@Story("This test case belongs to userStory-456")
	@Severity(SeverityLevel.NORMAL)
   public void validateTheEmloyeeExists() throws FileNotFoundException, InterruptedException
   {
	   
	   	   
	   System.out.println(" I am in validateThe employeelist");
	   empIdFromTestData=xlReader.getCellData(sheetName, 7, 2);
	   empNameFromTestData=xlReader.getCellData(sheetName, "Full Name", 2);  
	   //  Search an existing employee 
			lsEmpDB.clickEmployeeList();
			//lsEmpDBViewEmpList.searchExistingEmployee(4567);
			/*if(lsEmpDBViewEmpList.searchExistingEmployee(empIdFromTestData,empNameFromTestData))
			{
				//System.out.println("Employee" +empIdFromTestData+"exists in the database");
				
			}
			else
				System.out.println("Employee" +empIdFromTestData+" does not exists in the database");	
	   }*/
            //System.out.println(empIdFromTestData);
			//System.out.println(lsEmpDBViewEmpList.searchExistingEmployee(empIdFromTestData,empNameFromTestData));
			Assert.assertTrue(lsEmpDBViewEmpList.searchExistingEmployee(empIdFromTestData,empNameFromTestData));
			
   
   }


}
