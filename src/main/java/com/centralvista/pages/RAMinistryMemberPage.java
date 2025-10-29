/**
 * @author surendragangwar
 * @since 24-Jun-2025
 * @version 1.0
 * 
 * Description: [This Class Contains Xpath of Recomenation Authority Page for Ministry Member]
 */
package com.centralvista.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.centralvista.testBase.TestBase;
import com.centralvista.utility.DatePickers;

import io.qameta.allure.Step;



public class RAMinistryMemberPage extends TestBase {

    WebDriver driver;
    DatePickers datePicker;
   


    public RAMinistryMemberPage(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
       
        PageFactory.initElements(driver, this);
        
    }
    
    @FindBy(xpath="//*[@id=\'typeEmailX\']")
    WebElement textBoxUsername;  ////*[@id="email"]

    @FindBy(xpath="//*[@id=\'typePasswordX\']")
    WebElement textBoxPassword; 

    @FindBy(xpath="//*[@id=\'home\']/div[1]/div/div[1]/div/div/a[1]")
    WebElement btnLoginHomePage; 

    @FindBy(xpath="//button[contains(text(),'Login')]")
    WebElement btnLogin;
    
    
    
    @FindBy(xpath = "(//i[@class='fa fa-paper-plane'])[1]")
  
    WebElement forwatoApproverButton;

    @FindBy(xpath = "//*[@id='fatherName']")
    WebElement fathername;

    @FindBy(xpath = "//*[@id='motherName']")
    WebElement mothername;

   
    @FindBy(xpath = "//*[@id = 'dob']")
    WebElement dob;
    
    @FindBy(xpath="(//button[@title='View'])[1]")
    WebElement viewverify;
    
    @FindBy(xpath="//i[@class='fa fa-arrow-left']")
    WebElement backbutton;
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[1]")
    WebElement Empname; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[3]")
    WebElement FatherName; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[4]")
    WebElement Gender; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[5]")
    WebElement DOB; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[6]")
    WebElement expectEmail; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[7]")
    WebElement Aadhaar; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[7]")
    WebElement Mobile; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[9]")
    WebElement AltMobile; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[6]")
    WebElement BloodGroup; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[9]")
    WebElement IdMark; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[15]")
    WebElement Session; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[16]")
    WebElement ValidFrom; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[17]")
    WebElement Valisto; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[14]")
    WebElement Ministry; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[13]")
    WebElement Category; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[11]")
    WebElement designation; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[8]")
    WebElement OfficeNo; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[7]")
    WebElement FaxNo; 
    
    @FindBy(xpath="(//div[@class='col-md-7 flt_left'])[10]")
    WebElement PresentAddr; 
    
   
    @FindBy(xpath = "//*[@id='applicationStatus']")
    WebElement applicationStatus;
  
    @FindBy(xpath = "(//input[@aria-autocomplete='list'])")
    WebElement approver;
 
    @FindBy(xpath = "//textarea[@placeholder='Remarks']")
    WebElement remarks;
    
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submit;
  

    public void setUserName(String uName)
    {
    	textBoxUsername.sendKeys(uName);
    }

    public void setPassword(String pwd)
    {
    	textBoxPassword.sendKeys(pwd);
    }

    public void clickSubmit() {
     
        btnLogin.click();
        }
    
    public String getEmpName() {
        return Empname.getText().trim();
    }

    public String getFatherName() {
        return FatherName.getText().trim();
    }

    public String getGender() {
        return Gender.getText().trim();
    }

    public String getDOB() {
        return DOB.getText().trim();
    }

    public String getExpectedEmail() {
        return expectEmail.getText().trim();
    }

    public String getAadhaar() {
        return Aadhaar.getText().trim();
    }

    // ⚠️ Note: Same XPath as Aadhaar — should be corrected.
    public String getMobile() {
        return Mobile.getText().trim();
    }

    public String getAltMobile() {
        return AltMobile.getText().trim();
    }

    // ⚠️ Note: Same XPath as expectEmail — should be corrected.
    public String getBloodGroup() {
        return BloodGroup.getText().trim();
    }

    // ⚠️ Note: Same XPath as AltMobile — should be corrected.
    public String getIdMark() {
        return IdMark.getText().trim();
    }

    public String getSession() {
        return Session.getText().trim();
    }

    public String getValidFrom() {
        return ValidFrom.getText().trim();
    }

    public String getValidTo() {
        return Valisto.getText().trim();
    }

    public String getMinistry() {
        return Ministry.getText().trim();
    }

    public String getCategory() {
        return Category.getText().trim();
    }

    public String getDesignation() {
        return designation.getText().trim();
    }

    public String getOfficeNo() {
        return OfficeNo.getText().trim();
    }

    // ⚠️ Note: Same XPath as Mobile & Aadhaar — should be corrected.
    public String getFaxNo() {
        return FaxNo.getText().trim();
    }

    public String getPresentAddress() {
        return PresentAddr.getText().trim();
    }
    
    public void clickView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(viewverify)).click();
    }
    
    public void backbutton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(backbutton)).click();
    }
    
    public void forwarToapprover() {
        //Submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(forwatoApproverButton)).click();
    }
    
    public void setapplicationStatus(String value) {
        Select select = new Select(applicationStatus);
        select.selectByVisibleText(value);
    }
    
    
  
    public void selectApprover() {
       approver.click();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
           By.xpath("//span[contains(text(),'Approver, (000507, Central Pass Issuing Cell RS, C')]")));
       optionToSelect.click();

    }
    
    public void setRemarks(String remark)
    {
    	remarks.sendKeys(remark);
    }
    public void submit() {
        //Submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
    }

}

