package com.centralvista.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.centralvista.testBase.TestBase;

import io.qameta.allure.Step;

public class Login extends TestBase{
//WebDriver driver;



@FindBy(xpath="//*[@id=\'typeEmailX\']")
WebElement textBoxUsername;  ////*[@id="email"]

@FindBy(xpath="//*[@id=\'typePasswordX\']")
WebElement textBoxPassword; 

@FindBy(xpath="//*[@id=\'home\']/div[1]/div/div[1]/div/div/a[1]")
WebElement btnLoginHomePage; 

@FindBy(xpath="//button[contains(text(),'Login')]")
WebElement btnLogin;

@FindBy(xpath="/html/body/app-root/app-login/section/div/div/div/div/div/form/div/p[1]")
WebElement labelLogin;

@FindBy(xpath="//div[contains(text(),'Authentication failed, please check credentials')]")
WebElement labelInvalidCredentials;

//To be removed
@FindBy(xpath="/html/body/app-root/app-ls-employee-portal/div/div/main/app-ls-emp-portal-home/div/div/div[5]/div/button")

WebElement btnClickVisitor;
public Login()throws FileNotFoundException
{
	
	//this .driver=webDriver;
   PageFactory.initElements(TestBase.getDriver(), this);
	
	

}

public void setUserName(String uName)
{
	textBoxUsername.sendKeys(uName);
}

public void setPassword(String pwd)
{
	textBoxPassword.sendKeys(pwd);
}

public String validateLoginPageTitle(){
	return labelLogin.getText();
}


@Step("Going to login with username: {0}, password:{1} for method: {method} step")
public EmpHomePage loginWithValidCredentials(String username ,String password) throws FileNotFoundException
{
	
	setUserName(username);
	setPassword(password);
//try {
//Thread.sleep(3000);
//} catch (InterruptedException e) {
// TODO Auto-generated catch block
//e.printStackTrace();
//	}
	btnLogin.click();
	// to be removed 
	//btnClickVisitor.click();
	//xpath="/html/body/app-root/app-ls-employee-portal/div/div/main/app-ls-emp-portal-home/div/div/div[5]/div/button
	
	return new EmpHomePage();
	
}
@Step("Going to login with username: {0}, password:{1} for method: {method} step")
public String loginWithInValidCredentials(String username ,String password) throws FileNotFoundException, InterruptedException
{
	
	setUserName(username);
	setPassword(password);
	btnLogin.click();
	Thread.sleep(5000);
	System.out.println(labelInvalidCredentials.getText());
	return labelInvalidCredentials.getText();
	
}
 public String getCurrentUrl()
 {
	 return TestBase.getDriver().getCurrentUrl();
	 
 }

}
