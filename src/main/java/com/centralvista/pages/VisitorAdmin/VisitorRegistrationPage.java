/**
 * @author surendragangwar
 * @since 03-Sept-2025
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.pages.VisitorAdmin;

import java.io.FileNotFoundException;
import java.time.Duration;

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

public class VisitorRegistrationPage extends TestBase {

	 WebDriver driver;
	  

	    public VisitorRegistrationPage(WebDriver driver) throws FileNotFoundException {
	        this.driver = driver;	       
	        PageFactory.initElements(driver, this);
	        
	    }
	    
	    public void setUserName(String uName)
	    {
	    	textBoxUsername.sendKeys(uName);
	    }

	    public void setPassword(String pwd)
	    {
	    	textBoxPassword.sendKeys(pwd);
	    }
	    
	    @FindBy(xpath="//*[@id=\'typeEmailX\']")
	    WebElement textBoxUsername;  ////*[@id="email"]

	    @FindBy(xpath="//*[@id=\'typePasswordX\']")
	    WebElement textBoxPassword;  
	    
	    @FindBy(xpath="//button[contains(text(),'Login')]")
	    WebElement btnLogin;
	   
	@FindBy(xpath = "//span[normalize-space()='Visitor']")
	WebElement registrationsidebar;
	
	@FindBy(xpath= "//div[@class='dropdown-container expand']//a[1]//div[1]//span[1]")
	WebElement registrrationlink;
	
	@FindBy(xpath= "//input[@id='fullname']")
	WebElement fullName;
	
	public void setFullName(String value) {
		fullName.sendKeys(value);
		
	}
	
	@FindBy(xpath = "//input[@id='fatherName']")
	WebElement fathername;
	
	public void setfathername(String value) {
		fathername.sendKeys(value);
		
	}
	
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement idtypes;
	
	public void selectType(String value) {
        idtypes.click();
        idtypes.sendKeys(value);
        idtypes.sendKeys(Keys.ENTER);  
    }
	
	@FindBy(xpath="//input[@id='aadhaarCardNumber']")
	WebElement idnumber;
	
	public void setAadhaarnumber(String value) {
		idnumber.sendKeys(value);
	}
	
	@FindBy(xpath= "//input[@id='contactNumber']")
	WebElement mobileNumber;
	
	public void setcontact(String value) {
		mobileNumber.sendKeys(value);
	}
	
	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement gender;
	
	public void selectGender(String value) {
		gender.click();
		gender.sendKeys(value);
		gender.sendKeys(Keys.ENTER); 
    }
	
	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement bloodgroup;

	public void selectbg(String value) {
       
        bloodgroup.click();
        bloodgroup.sendKeys(value);
        bloodgroup.sendKeys(Keys.ENTER); 
    }
	
	@FindBy(xpath= "//input[@id='email']")
	WebElement email;
	
	public void setemail(String value) {
		email.sendKeys(value);
	}
	
	@FindBy(xpath= "//input[@id='alternate_contact_number']")
	WebElement alternatecontact;
	
	
	public void setAltcontact(String value) {
		alternatecontact.sendKeys(value);
		
	}
	
	@FindBy(xpath="//input[@id='identificationMark']")
	WebElement identificationMark;
	
	public void setidentificationMark(String value) {
		identificationMark.sendKeys(value);
		
	}
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dob;
	
	@FindBy(xpath="//input[@id='remark']")
	WebElement remark;
	
	public void setremark(String value) {
		remark.sendKeys(value);
		
	}
	
	
	 @FindBy(xpath = "//*[@id = 'permanentFlatNumber']")
	    WebElement permanentFlatNumber;

	    @FindBy(xpath = "//*[@id = 'permanentLocality']")
	    WebElement permanentLocality;

	    @FindBy(xpath = "(//input[@type='text'])[14]")
	    WebElement permanentState;

	    @FindBy(xpath = "//*[@id= 'permanentCity']")
	    WebElement permanentCity;

	    @FindBy(xpath = "//*[@id= 'permanentPincode']")
	    WebElement permanentPincode;
	    
	    public void setPermanentFlatNumber(String value) {
	        permanentFlatNumber.clear();
	        permanentFlatNumber.sendKeys(value);
	    }

	    public void setPermanentLocality(String value) {
	        permanentLocality.clear();
	        permanentLocality.sendKeys(value);
	    }

	    
	    public void setPermanentState(String value) {
	        permanentState.click();
	        permanentState.sendKeys(value);
	        permanentState.sendKeys(Keys.ENTER); 
	    } 

	    public void setPermanentCity(String value) {
	        permanentCity.clear();
	        permanentCity.sendKeys(value);
	    }

	    public void setPermanentPincode(String value) {
	        permanentPincode.clear();
	        permanentPincode.sendKeys(value);
	    }

	    @FindBy(xpath = "//*[@id = 'currentFlatNumber']")
	    WebElement currentFlatNumber;

	    @FindBy(xpath = "//*[@id = 'currentLocality']")
	    WebElement currentLocality;

	    @FindBy(xpath = "(//input[@type='text'])[18]")
	    WebElement currentState;

	    @FindBy(xpath = "//*[@id= 'currentCity']")
	    WebElement currentCity;

	    @FindBy(xpath = "//*[@id= 'currentPincode']")
	    WebElement currentPincode;
	    
	    public void setCurrentFlatNumber(String value) {
	        currentFlatNumber.clear();
	        currentFlatNumber.sendKeys(value);
	    }

	    public void setCurrentLocality(String value) {
	        currentLocality.clear();
	        currentLocality.sendKeys(value);
	    }

	    public void setCurrentState(String value) {
	    	currentState.click();
	    	currentState.sendKeys(value);
	    	currentState.sendKeys(Keys.ENTER); 
	    } 
	      
	    public void setCurrentCity(String value) {
	        currentCity.clear();
	        currentCity.sendKeys(value);
	    }

	    public void setCurrentPincode(String value) {
	        currentPincode.clear();
	        currentPincode.sendKeys(value);
	    }
	    
	    @FindBy(xpath = "//input[@id='check1']")
	    WebElement flexCheckDefault;
	    
	    @FindBy(xpath = "//button[normalize-space()='Submit']")
	    WebElement Submit;


	
		 public void clickLogin() {
		        
		        btnLogin.click();
		        }

		
		public WebElement getRegistrationsidebar() {
			return registrationsidebar;
		}

		
		public void setRegistrationsidebar(WebElement registrationsidebar) {
			this.registrationsidebar = registrationsidebar;
		}

		
		public WebElement getRegistrrationlink() {
			return registrrationlink;
		}

		
		public void setRegistrrationlink(WebElement registrrationlink) {
			this.registrrationlink = registrrationlink;
		}

		public void clickSubmit() {
	        //Submit.click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
	        wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();
	    }

		 @FindBy(xpath = "//input[@placeholder='Type in here...']")
		    WebElement searchbox;
		 
		public void setSearchlist(String value) {
    	searchbox.clear();
    	searchbox.sendKeys(value);
    }
		
		  @FindBy(xpath="(//button[@title='View Details'])[1]")
		    WebElement viewverify;
		
				public void clickView() {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
			        wait.until(ExpectedConditions.elementToBeClickable(viewverify)).click();
			    }
				
				
				 @FindBy(css = "body > app-root > app-visitor-admin > div > div > main > app-va-visitor-registered-details > div > div.brdcrm > h3 > span")
				    
				    WebElement fullname;
				    
				    @FindBy(css = "body > app-root > app-visitor-admin > div > div > main > app-va-visitor-registered-details > div > div.wrapper.mt-5 > div > div:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2)")
				    WebElement Fathername;
				    
//				    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(4) > div.col-md-7.flt_left > p.card-text")
//				    WebElement Mothername;
	
				    
				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)")
				    WebElement Gender;
//				    
				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)")
				    WebElement BlooGroup;

				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2)")
				    WebElement AahaarNumber;
				    
				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(2)")
				    WebElement MobileNumber;
				    
				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(7) > td:nth-child(2)")
				    WebElement Email;
				    
				    
				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(8) > td:nth-child(2)")
				    WebElement AlternateMobileNumber;
				    
				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(9) > td:nth-child(2)")
				    WebElement VisibleIdentificationMark;
				    
				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(10) > td:nth-child(2)")
				    WebElement birth;
				   				   				    
				    @FindBy(css = "body > app-root:nth-child(1) > app-visitor-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-va-visitor-registered-details:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(11) > td:nth-child(2)")
				    WebElement remarksgiven; 
				    
				    @FindBy(xpath = "/html/body/app-root/app-visitor-admin/div/div/main/app-va-visitor-registered-details/div/div[2]/div/div[2]/table/tbody/tr[2]/td[2]")
				    WebElement Present;
				    
				    @FindBy(xpath = "/html/body/app-root/app-visitor-admin/div/div/main/app-va-visitor-registered-details/div/div[2]/div/div[2]/table/tbody/tr[3]/td[2]")
				    WebElement Permanent;
				   
				    
				public String getFullName() {
			        return fullname.getText().trim();
			    }

			    public String getFatherName() {
			        return Fathername.getText().trim();
			    }

//			    public String getMotherName() {
//			        return Mothername.getText().trim();}

			    public String getGender() {
			        return Gender.getText().trim();
			    }
			    
			    public String getBloodGroup() {
			        return BlooGroup.getText().trim();
			    }

			    public String getAadhaarNumber() {
			        return AahaarNumber.getText().trim();
			    }
			    
			    public String getMobileNumber() {
			        return MobileNumber.getText().trim();
			    }
			    
			    public String getEmail() {
			        return Email.getText().trim();
			    }
			    
			    public String getAlternateMobileNumber() {
			        return AlternateMobileNumber.getText().trim();
			    }
			    
			    public String getIdentificationMark() {
			        return VisibleIdentificationMark.getText().trim();
			    }

			    
			    public String getDateOfBirth() {
			        return birth.getText().trim();
			    }


			    public String getRemarks() {
			        return remarksgiven.getText().trim();
			    }


			    public String getPresentAddress() {
			        return Present.getText().trim();
			    }

			    public String getPermanentAddress() {
			        return Permanent.getText().trim();
			    }
  
			    @FindBy(xpath="(//span[@class='arrows-hed']")
			    WebElement backfromview;
			
					public void backfromview() {
						ScrollUtil.scrollToTop(TestBase.getDriver());
				        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
				        wait.until(ExpectedConditions.elementToBeClickable(backfromview)).click();
				    }
					
					  
				    @FindBy(xpath = "//img[@class='userImg ng-star-inserted']")
				    WebElement userMenu;
				    @FindBy(xpath = "//a[normalize-space()='Logout']")
				    WebElement logout;
				    
				    public void logout() throws InterruptedException {
//				        Actions actions = new Actions(driver);
//				        actions.moveToElement(userMenu).perform();
				    	userMenu.click();
				        Thread.sleep(1000);
				        logout.click();
				        Thread.sleep(3000);
				    } 
	}
