package com.centralvista.test;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.centralvista.pages.Login;
import com.centralvista.testBase.TestBase;

public class RD extends TestBase {
 Login login;
 
 public RD() throws FileNotFoundException
	{
		super();
	}
	
	@BeforeClass
	public void setUp()throws FileNotFoundException
	{	initialization();
		login = new Login();
		//xlReader=new excelReader();
	}
	
	@Test
	public void start() throws FileNotFoundException
	{
		
		login.loginWithValidCredentials("11488", "Cdac@123");
		System.out.println(login.getCurrentUrl());
		
	}
	
}
