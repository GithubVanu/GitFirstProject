/**
 * @author surendragangwar
 * @since 10-Jul-2025
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.pages;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.centralvista.testBase.TestBase;
import com.centralvista.utility.DatePickers;
import com.centralvista.utility.ScrollUtil;

public class AAMinistrymemberPage extends TestBase {

    WebDriver driver;
    DatePickers datePicker;
   


    public AAMinistrymemberPage(WebDriver driver) throws FileNotFoundException {
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
    
    
    
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(10) button:nth-child(1)")
  
    WebElement view;

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
    
   
    @FindBy(xpath = "//select[@id='applicationStatus']")
    WebElement applicationStatus;
    
    @FindBy(xpath = "//select[@id='withFascia']")
    WebElement selectfascia;
    
    @FindBy(xpath = "//*[@id=\"cardFasciaTypeCode\"]/div")
    WebElement fasciatype;
  
    @FindBy(xpath = "//span[normalize-space()='Generic Sticky/Thermal Fascia Card']")
    WebElement fasciavalue;
  
    @FindBy(xpath = "//*[@id=\"approvingAuthorityId\"]/div")
    WebElement approver;
    @FindBy(xpath = "(//input[@aria-autocomplete='list'])")
    WebElement approverz;
    @FindBy(xpath = "//textarea[@placeholder='Remarks']")
    WebElement remarks;
    
   
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submit;
  
    @FindBy(xpath = "//button[@title='Update']")
    WebElement GrantAccess;
    @FindBy(xpath = "//button[normalize-space(text())='Update']")
    WebElement GrantAccesscomplete;
    
    @FindBy(xpath = "(//button[normalize-space()='Approve/Reject Request'])[1]")
    WebElement clickApprove;
    
    
    
    

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
    
  
    
    public void backbutton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(backbutton)).click();
    }
    
    public void clickview() {
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(view)).click();
    }
    
    public void grantAccess() throws InterruptedException {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(GrantAccess)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(GrantAccesscomplete)).click();
        Thread.sleep(2000);
        ScrollUtil.scrollUntilElementVisible(driver, By.xpath("(//button[normalize-space()='Approve/Reject Request'])[1]"));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(clickApprove)).click();
        
    }
    

    
  
    public void selectfascia(String value) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       Select select = new Select(selectfascia);
       select.selectByVisibleText(value);
       
    }
    
    public void selectfasciatype() throws InterruptedException {
    	Thread.sleep(2000);
        fasciatype.click();
        Thread.sleep(2000);
        fasciavalue.click();
        
     }
       
       public void selectAction(String value) {
           Select select = new Select(applicationStatus);
           select.selectByVisibleText(value);
       }
       
       public void selectissuer() {
    	   approverz.sendKeys("346584");   // type your text
    	   approverz.sendKeys(Keys.ARROW_DOWN);
    	   approverz.sendKeys(Keys.ENTER);
          

        }
//       public void selectissuer() {
//    	   
//    	   approver.sendKeys("346584");
//    	   approver.sendKeys(Keys.ARROW_DOWN);
//    	   approver.sendKeys(Keys.ENTER);
//    	  
////           approverz.click();
////           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////           WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
////               By.xpath("//span[contains(text(),'Toshit kumar IA, (346584, Security, CCS Tech, Lok ')]")));
////           optionToSelect.click();
//
//        }

    
    public void setRemarks(String remark)
    {
    	remarks.sendKeys(remark);
    }
    public void submit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
    }

}

