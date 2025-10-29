package com.centralvista.pages;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.centralvista.testBase.TestBase;

import io.qameta.allure.Step;

public class LSEmpDashBoardEmpList extends TestBase {

	@FindBy(xpath="//input[@type='search']")
	WebElement searchBoxEmployeeList;
	
	@FindBy(xpath="//*[@id='DataTables_Table_27']/thead/tr/th[1]")
	WebElement tableHeaderEmployeeID;
	
	@FindBy(xpath="//*[@id='DataTables_Table_27']/thead/tr/th[2]")
	WebElement tableHeaderFullName;
	
	@FindAll(@FindBy(xpath="//table[@id='DataTables_Table_0']/thead/tr/th"))
	public List<WebElement> tableColCount;
	
	@FindAll(@FindBy(xpath="//*[@id='DataTables_Table_0']/tbody/tr"))
	public List<WebElement> tableRowCount;
	
	//@FindBy(xpath="//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")
	//WebElement tableRow;
	////table[@id='DataTables_Table_0']/tbody/tr
	
	int colCount=0;
	int rowCount=0;
	boolean existingEmployee=false;
	//Hash Map to store employee id and 
	Map<String,String> empList=new HashMap();
	public  Logger log=Logger.getLogger("LSEmpDashBoardEmpList");
	public LSEmpDashBoardEmpList() throws FileNotFoundException {
	//super();
		// TODO Auto-generated constructor stub
	PageFactory.initElements(TestBase.getDriver(),this);
	
	}
	
	//This method will search whether an employee exists or not
	@Step("Going to search the existing employee  with employeeId: {0}, fullName:{1} for method: {method} step") 
	public boolean searchExistingEmployee(String emp_Id,String fullName) throws InterruptedException
	{
		
		searchBoxEmployeeList.sendKeys(emp_Id);
		//This sleep is to get the table rows of the searced employees only otherwise all the table rows on the page would be populated
		Thread.sleep(5000);
		//System.out.println("The emp_id is " +tableRowCount.size());	
		colCount=tableColCount.size(); //6
		rowCount=tableRowCount.size();  //4
						
		for (int i=1;i<=rowCount-1;i++) //here rowcount-1 is used because by xpath one extra row is being returned which has no data
		{
			//for(int j=1;j<colCount;j++)
			//System.out.println(driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+i+"]/td["+j+"]")).getText());
			
				//The below for loop is to store the data in the hashmap
			String id=TestBase.getDriver().findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+i+"]/td[1]")).getText();
			String name=TestBase.getDriver().findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr["+i+"]/td[2]")).getText();
			empList.put(id, name);
				
		}
		
	//Print the map elements
		log.info("The key value pair in hashmap are "+empList);
	//Search if the existing employee exists in the system or not ,if it exists then return true else returm false
	    for(String key:empList.keySet())	
	    {
	    	//System.out.println(" I am in loop "+"with key"+key);
	    	//System.out.println("======"+emp_Id);
	    	if (empList.get(key).equals(fullName))
	    	{
	    	 
	    		//System.out.println(empList.get(key));
	    		log.info("The Employee "+empList.get(key)+" exists with the employee_id "+emp_Id);
	    		return true;
	    	
	    	}
	    }
		return false;
		}
		//This method will click on View icon for the searched employee
     public LSEmpDashBoardView ViewTheSearchedEmployee(String empId) throws FileNotFoundException 
	{
	return new LSEmpDashBoardView();
	}
   //This method will click on Update icon for the searched employee
	public LSEmpDashBoardUpdate UpdateTheSearchedEmployee(String empId) throws FileNotFoundException 
	{
	return new LSEmpDashBoardUpdate();
	}
	
}
