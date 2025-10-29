package com.centralvista.test;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import com.centralvista.excelReader.Xlfile_Reader;
import com.centralvista.testBase.TestBase;




public class ReadDataFromExcel extends TestBase{
 
	  public ReadDataFromExcel() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Xlfile_Reader Core;
	  public static Xlfile_Reader testData=null;
	  public static Xlfile_Reader DBresults=null;
	
	@Test
  
   
  public void f() {
  

	  
	  Xlfile_Reader xl;
 //Core= new Xlfile_Reader(System.getProperty("user.dir")+"\\src\\config\\Core.xlsx");
 System.out.println("3333333333333333333333"+System.getProperty("user.dir"));
// testData  =  new Xlfile_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\centralvista\\testdata\\TestData.xlsx");
 testData  =  new Xlfile_Reader("C:\\Users\\DELL\\Desktop\\AutomationBackUp\\GitFirstProject\\GitFirstProject\\src\\main\\java\\com\\centralvista\\testdata\\TestData.xlsx");
 //C:\Users\HP\Downloads\GitFirstProject\GitFirstProject\src\main\java\com\centralvista\testdata\TestData.xlsx
 //String username = testData.getCellData("LoginHomePage", 1, 1);
 int username = testData.getRowCount("LoginHomePage");	
 System.out.println("*************************"+username);
  
  }
}
