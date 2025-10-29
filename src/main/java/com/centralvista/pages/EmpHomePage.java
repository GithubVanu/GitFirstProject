package com.centralvista.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.centralvista.testBase.TestBase;

public class EmpHomePage extends TestBase {

@FindBy(xpath="/html/body/app-root/app-ls-employee-portal/div/div/main/app-ls-emp-portal-home/div/div/div[5]/div/button")
WebElement btnClickVisitor;
	
@FindBy(xpath="/html/body/app-root/app-ls-employee-portal/div/div/main/app-ls-emp-portal-home/div/div/div[1]")
WebElement labelPageHeader;

@FindBy(xpath="//*[@id='userRole']")
WebElement drpSwitchRole;

@FindBy(xpath="//*[@id='userRole']/option[6]")
WebElement drpSwitchRoleOptionLoksabhaAdmin;

///html/body/app-root/app-ls-employee-portal/div/div/main/app-ls-emp-portal-home/div/div/div[1]


///html/body/app-root/app-ls-employee-portal/div/div/main/app-ls-emp-portal-home/div/div/div[1]

public EmpHomePage ()throws FileNotFoundException
{
	PageFactory.initElements(TestBase.getDriver(), this);	
	
}

public String getLabelServices()
{
	
	System.out.println(" I am in getLabelServices"+labelPageHeader.getText());
	return labelPageHeader.getText();
}

public void selectRole()
{
	System.out.println("Enetered in the Switch Role method");
	drpSwitchRole.click();
	drpSwitchRoleOptionLoksabhaAdmin.click();
	//Select drpDown=new Select(drpSwitchRole);
	//drpDown.selectByValue("Lok Sabha Employee Admin");
}


//public EmpHomePage getCurrentUrl()
//{
	// return new EmpHomePage();
	 
//}


}
