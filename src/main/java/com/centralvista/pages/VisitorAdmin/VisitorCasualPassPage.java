/**
 * @author surendragangwar
 * @since 18-Sept-2025
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */

package com.centralvista.pages.VisitorAdmin;

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
import com.centralvista.utility.ScrollUtil;

public class VisitorCasualPassPage extends TestBase {

	WebDriver driver;

	public VisitorCasualPassPage(WebDriver driver) throws FileNotFoundException {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement forwardrequest;

	public void requestforcasualpass() {

		forwardrequest.click();
	}
	
	
	
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement category;
	
	public void selectcategory(String value) {
		category.click();
		category.sendKeys(value);
		category.sendKeys(Keys.ENTER);  
    }
	
	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement material;
	
	public void selectmaterial(String value) {
		material.click();
		material.sendKeys(value);
		material.sendKeys(Keys.ENTER);  
    }
	
	@FindBy(xpath="//input[@id='purpose']")
	WebElement purpose;
	
	public void setPurpose(String value) {
		purpose.sendKeys(value);
		
	}
	
	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement recauthority;
	
	public void selectrecauthority(String value) {
		recauthority.click();
		recauthority.sendKeys(value);
		recauthority.sendKeys(Keys.ENTER);  
    }
	
	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement referrertype;
	
	public void selectreferrertype(String value) {
		referrertype.click();
		referrertype.sendKeys(value);
		referrertype.sendKeys(Keys.ENTER);  
    }
	
	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement referrerperson;
	
	public void selectreferrerperson(String value) {
		referrerperson.click();
		referrerperson.sendKeys(value);
		referrerperson.sendKeys(Keys.ENTER);  
    }
	
	@FindBy(xpath = "(//input[@type='text'])[9]")
	WebElement building;
	
	public void selectbuilding(String value) {
		building.click();
		building.sendKeys(value);
		building.sendKeys(Keys.ENTER);  
    }
	
	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement selectroom;
	
	public void selectroom(String value) {
		selectroom.click();
		selectroom.sendKeys(value);
		selectroom.sendKeys(Keys.ENTER);  
    }
	
	
	@FindBy(xpath = "//button[normalize-space()='Request']")
	WebElement requetpass;

	public void submitrequest() {

		requetpass.click();
	}
	
	@FindBy(xpath = "//button[@title='Action']")
	WebElement fwtopprover;

	public void fwtoapprover() {

		fwtopprover.click();
	}
	
	 @FindBy(xpath = "//*[@id='applicationStatus']")
	    WebElement applicationStatus;
	  
	    @FindBy(xpath = "//*[@id=\"approvingAuthorityEmpId\"]")
	    WebElement approver;
	 
	    @FindBy(xpath = "//textarea[@placeholder='Remarks']")
	    WebElement remarks;
	    
	    @FindBy(xpath = "//button[normalize-space()='Submit']")
	    WebElement submit;
	
	 public void setapplicationStatus(String value) {
	        Select select = new Select(applicationStatus);
	        select.selectByVisibleText(value);
	    }
	    
	    
	  
	    public void selectApprover() {
	       approver.click();
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
	           By.xpath("//option[@value='123456']")));
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
	  
	    

		@FindBy(xpath = "//button[@title='View']")
		WebElement fwtoissuer;

		public void fwtoissuer() {

			fwtoissuer.click();
		}
		
		
		
		@FindBy(xpath = "//button[normalize-space()='Grant / Update Access Permission']")
		WebElement accesspermission;
		@FindBy(xpath = "//button[normalize-space()='Update']")
		WebElement authorise;
		@FindBy(xpath = "//button[normalize-space()='Approve/Reject Request']")
		WebElement approve;
		public void accesspermission() throws InterruptedException {
			ScrollUtil.scrollUntilElementVisible(TestBase.getDriver(), By.xpath("//button[normalize-space()='Grant / Update Access Permission']"));
			accesspermission.click();
			ScrollUtil.scrollToBottom(TestBase.getDriver());
			Thread.sleep(2000);
			authorise.click();
			Thread.sleep(2000);
			ScrollUtil.scrollToBottom(TestBase.getDriver());
			Thread.sleep(2000);
			approve.click();
			
		}
		
		 @FindBy(xpath = "//*[@id='cardTypePhysicalCode']")
		    WebElement fasciatype;
		  
		    @FindBy(xpath = "//*[@id=\"applicationStatus\"]")
		    WebElement applicationstatus;
		    
		    @FindBy(xpath = "//*[@id=\"approvingAuthorityEmpId\"]")
		    WebElement issuer;
		 
		
		
		 public void setfasciatype(String value) {
		        Select select = new Select(fasciatype);
		        select.selectByVisibleText(value);
		    }
		 
		 public void applicationstatus(String value) {
		        Select select = new Select(applicationstatus);
		        select.selectByVisibleText(value);
		    }
		    
		
		  
		    public void selectissuer() {
		       issuer.click();
		       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		       WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
		           By.xpath("//option[@value='346584']")));
		       optionToSelect.click();

		    }
		
}
