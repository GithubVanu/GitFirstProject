package com.centralvista.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.centralvista.dataReader.excelReader;
import com.centralvista.pages.EmpHomePage;
import com.centralvista.pages.Login;
import com.centralvista.testBase.TestBase;

public class EmpHomePageTest extends TestBase {

	Login login;
	EmpHomePage empHome;
	excelReader xlReader;
	public static Logger APPLICATION_LOGS;	
	String sheetName = "LoginHomePage";
	 
	 public EmpHomePageTest() throws FileNotFoundException
		{
			super();
		}
		
		@BeforeClass
		public void setUp()throws IOException
		{	initialization();
			login = new Login();
			empHome=new EmpHomePage();
			//xlReader=new excelReader();
			xlReader=new excelReader(excelReader.TESTDATA_SHEET_PATH);
		}
		
		@Test (priority=1)
		public void start() throws FileNotFoundException
		{
			
			
			{
		    String userName=xlReader.getCellData(sheetName, 1,2);
		    String password=xlReader.getCellData(sheetName, 2,2);
		    System.out.println("+++++++"+userName);
		    System.out.println("+++++++"+password);
			login.loginWithValidCredentials(userName, password);
			}
			
		}

@Test(priority=2)
   public void switchToRole() throws InterruptedException
   {
	Thread.sleep(5000);
	empHome.selectRole();
	
   }









}
