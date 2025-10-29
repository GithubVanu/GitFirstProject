package com.centralvista.utility;

import org.testng.annotations.Test;

public class DataProviderRetired 
{
	String fullName;
	
	
	@Override
	public String toString() {
		return "DataProvider [fullName=" + fullName + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public DataProviderRetired() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider="testRetireData")
    public Object[][] loginTestData() {
        return new Object[][] {
            {"Srihari", "Vishu", "Lakshmi", "srihari@gmail.com"},
            {"John", "Doe", "Smith", "john@gmail.com"},
            {"", "Doe", "Smith", "john@gmail.com"}
          
        };
    }
	
	@Test(dataProvider="testRetireData")
	public  String dataProvider(String fullName)
	{
		System.out.println("I am full Name"+fullName);
		return fullName;
	}
}
