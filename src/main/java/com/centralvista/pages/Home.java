package com.centralvista.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home {

	WebDriver driver;

	public Home()
	{
		
	//this .driver=webDriver;
   PageFactory.initElements(driver, this);

	}

public void dumy()
{
	
	System.out.println("I am in home page");
}
}
