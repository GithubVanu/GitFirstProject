package com.centralvista.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.centralvista.testBase.TestBase;
import com.centralvista.utility.DatePickers;

import io.qameta.allure.Step;



public class Ministrymemberpage extends TestBase {

    WebDriver driver;
    DatePickers datePicker;
   


    public Ministrymemberpage(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
       
        PageFactory.initElements(driver, this);
        
    }

    @FindBy(xpath = "//*[@id='fullname']")
    WebElement fullName;

    @FindBy(xpath = "//*[@id='fatherName']")
    WebElement fathername;

    @FindBy(xpath = "//*[@id='motherName']")
    WebElement mothername;

    @FindBy(xpath = "//*[@id='gender']")
    WebElement Gender;

    @FindBy(xpath = "//*[@id = 'dob']")
    WebElement dob;

    @FindBy(xpath = "//*[@id = 'email']")
    WebElement Email;

    @FindBy(xpath = "//*[@id = 'aadhaarCardNumber']")
    WebElement AadhaarCardNumber;

    @FindBy(xpath = "//*[@id = 'contactNumber']")
    WebElement contactnumber;

    @FindBy(xpath = "//*[@id = 'alternate_contact_number']")
    WebElement alternate_contact_number;

    @FindBy(xpath = "//*[@id = 'bloodgroup']")
    WebElement bloodgroup;

    @FindBy(xpath = "//*[@id='identificationMark']")
    WebElement identificationMark;

    @FindBy(xpath = "//*[@formcontrolname= 'session']")
    WebElement session;

    @FindBy(xpath = "//*[@id= 'serviceStartDate']")
    WebElement serviceStartDate;

    @FindBy(xpath = "//*[@id= 'serviceEndDate']")
    WebElement serviceEndDate;

    @FindBy(xpath = "//*[@id= 'ministry']")
    WebElement ministry;

    @FindBy(xpath = "//*[@id= 'classId']")
    WebElement classId;

    @FindBy(xpath = "//*[@id= 'designationId']")
    WebElement designationId;

    @FindBy(xpath = "//*[@id= 'officeContact']")
    WebElement officeContact;

    @FindBy(xpath = "//*[@id= 'faxNumber']")
    WebElement faxNumber;

    @FindBy(xpath = "//*[@id = 'purpose']")
    WebElement purpose;

    @FindBy(xpath = "//*[@id = 'permanentFlatNumber']")
    WebElement permanentFlatNumber;

    @FindBy(xpath = "//*[@id = 'permanentLocality']")
    WebElement permanentLocality;

    @FindBy(xpath = "//*[@id= 'permanentState']")
    WebElement permanentState;

    @FindBy(xpath = "//*[@id= 'permanentCity']")
    WebElement permanentCity;

    @FindBy(xpath = "//*[@id= 'permanentPincode']")
    WebElement permanentPincode;

    @FindBy(xpath = "//*[@id = 'currentFlatNumber']")
    WebElement currentFlatNumber;

    @FindBy(xpath = "//*[@id = 'currentLocality']")
    WebElement currentLocality;

    @FindBy(xpath = "//*[@id= 'currentState']")
    WebElement currentState;

    @FindBy(xpath = "//*[@id= 'currentCity']")
    WebElement currentCity;

    @FindBy(xpath = "//*[@id= 'currentPincode']")
    WebElement currentPincode;

    @FindBy(xpath = "//*[@id= 'flexCheckDefault']")
    WebElement flexCheckDefault;

    @FindBy(xpath = "/html/body/app-root/app-sessional-members/div/div/main/app-sm-register/div/div/div[2]/div/div/form/div[6]/div[3]/div/button")
    WebElement Submit;

    @FindBy(xpath = "//div[@class='alert-message']")
    WebElement alertMessage;
    
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchbox;

    @FindBy(xpath="//tbody/tr[1]/td[11]/i")
    WebElement viewverify;
    
    @FindBy(css="body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-3 > div > div.profile-usermenu > ul > li:nth-child(3) > a")
    WebElement uploadfascia;
    
    @FindBy(xpath = "//input[@id='hindiName']")
    WebElement hininame;

    @FindBy(xpath = "//input[@id='photo']")
    WebElement uploaPhoto;

    @FindBy(xpath = "//input[@id='signature']")
    WebElement uploaSignature;

    @FindBy(css = "button[type='submit']")
    WebElement submitFascia;
    
    @FindBy(xpath="//*[@id=\'typeEmailX\']")
    WebElement textBoxUsername;  ////*[@id="email"]

    @FindBy(xpath="//*[@id=\'typePasswordX\']")
    WebElement textBoxPassword;  
    
    @FindBy(xpath="//button[contains(text(),'Login')]")
    
    WebElement btnLogin;
    public void clickLogin() {
        
        btnLogin.click();
        }
    
    public void setUserName(String uName)
    {
    	textBoxUsername.sendKeys(uName);
    }

    public void setPassword(String pwd)
    {
    	textBoxPassword.sendKeys(pwd);
    }
    
    // Setters with clear() + sendKeys()
    public void setFullName(String value) {
       // fullName.clear();
        fullName.sendKeys(value);
      
    }

	
	public void setFathername(String value) {
        //fathername.clear();
        fathername.sendKeys(value);
    }

    public void setMothername(String value) {
       // mothername.clear();
        mothername.sendKeys(value);
    }

    public void setGender(String value) {
        Select select = new Select(Gender);
        select.selectByVisibleText(value);
    }


    public void setEmail(String value) {
        Email.clear();
        Email.sendKeys(value);
    }

    public void setAadhaarCardNumber(String value) {
       
        AadhaarCardNumber.sendKeys(value);
    }

    public void setContactnumber(String value) {
       
        contactnumber.sendKeys(value);
    }

    public void setAlternateContactNumber(String value) {
       
        alternate_contact_number.sendKeys(value);
    }

    public void setBloodgroup(String value) {
        Select select = new Select(bloodgroup);
        select.selectByValue(value);
    }
   

    public void setIdentificationMark(String value) {
        identificationMark.clear();
        identificationMark.sendKeys(value);
    }
    
    public void setSession(String value) {
        Select select = new Select(session);
        select.selectByVisibleText(value);
    }

   
//    public void setServiceStartDate(String value) {
//    	datePicker.selectDate(serviceStartDate, value);
//    }
//
//    public void setServiceEndDate(String value) {
//    	datePicker.selectDate(serviceEndDate, value);
//    }

    public void setMinistry(String value) {
        Select select = new Select(ministry);
        select.selectByVisibleText(value);
    } 
    
    public void setClassId(String value) {
        Select select = new Select(classId);
        select.selectByVisibleText(value);
    } 

    public void setDesignationId(String value) {
        Select select = new Select(designationId);
        select.selectByVisibleText(value);
    } 

    public void setOfficeContact(String value) {
        officeContact.clear();
        officeContact.sendKeys(value);
    }

    public void setFaxNumber(String value) {
        faxNumber.clear();
        faxNumber.sendKeys(value);
    }

    public void setPurpose(String value) {
        purpose.clear();
        purpose.sendKeys(value);
    }

    public void setPermanentFlatNumber(String value) {
        permanentFlatNumber.clear();
        permanentFlatNumber.sendKeys(value);
    }

    public void setPermanentLocality(String value) {
        permanentLocality.clear();
        permanentLocality.sendKeys(value);
    }

    
    public void setPermanentState(String value) {
        Select select = new Select(permanentState);
        select.selectByVisibleText(value);
    } 

    public void setPermanentCity(String value) {
        permanentCity.clear();
        permanentCity.sendKeys(value);
    }

    public void setPermanentPincode(String value) {
        permanentPincode.clear();
        permanentPincode.sendKeys(value);
    }

    public void setCurrentFlatNumber(String value) {
        currentFlatNumber.clear();
        currentFlatNumber.sendKeys(value);
    }

    public void setCurrentLocality(String value) {
        currentLocality.clear();
        currentLocality.sendKeys(value);
    }

    public void setCurrentState(String value) {
        Select select = new Select(currentState);
        select.selectByVisibleText(value);
    } 
      
    public void setCurrentCity(String value) {
        currentCity.clear();
        currentCity.sendKeys(value);
    }

    public void setCurrentPincode(String value) {
        currentPincode.clear();
        currentPincode.sendKeys(value);
    }
    
    public void setSearchlist(String value) {
    	searchbox.clear();
    	searchbox.sendKeys(value);
    }

	public void clickSubmit() {
        //Submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();
    }

    public String getSuccessAlertMessage() {
		return driver.findElement(By.xpath("//div[@aria-label][2]")).getText(); // adjust ID
	}
 
    public String getAlertMessage() {
		return driver.findElement(By.xpath("//div[@aria-label]")).getText(); // adjust ID
	}
    
    public void clickView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(viewverify)).click();
    }
    
    
    
    
    // View page path available here
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(1) > div.col-md-7.flt_left > p.card-text")
    
    WebElement fullname;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(3) > div.col-md-7.flt_left > p.card-text")
    WebElement Fathername;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(4) > div.col-md-7.flt_left > p.card-text")
    WebElement Mothername;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(5) > div.col-md-7.flt_left > p.card-text")
    WebElement gender;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(6) > div.col-md-7.flt_left > p.card-text")
    WebElement birth;

    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(7) > div.col-md-7.flt_left > p.card-text")
    WebElement MobileNumber;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(8) > div.col-md-7.flt_left > p.card-text")
    WebElement AlternateMobileNumber;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(9) > div.col-md-7.flt_left > p.card-text")
    WebElement VisibleIdentificationMark;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(10) > div.col-md-7.flt_left > p.card-text")
    WebElement BlooGroup;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(11) > div.col-md-7.flt_left > p.card-text")
    WebElement email;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(12) > div.col-md-7.flt_left > p.card-text")
    WebElement AahaarNumber;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(13) > div.col-md-7.flt_left > p.card-text")
    WebElement OfficeNumber;
    
    @FindBy(css = "div.profile-content.ng-star-inserted > :nth-child(2) > :nth-child(2) > :nth-child(14) > div.col-md-7.flt_left > p.card-text")
    WebElement FaxNumber;
    
    @FindBy(css = "body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-9 > div > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div.col-md-7.flt_left > p")
    WebElement Present;
    
    @FindBy(css = "body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-9 > div > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div.col-md-7.flt_left > p")
    WebElement Permanent;
    
    
    @FindBy(css = "body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-9 > div > div:nth-child(3) > div > div > div > table > tbody > tr > td:nth-child(2)")
    WebElement esignation;
    
    @FindBy(css = "body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-9 > div > div:nth-child(3) > div > div > div > table > tbody > tr > td:nth-child(3)")
    WebElement Ministry;
    
    @FindBy(css = "body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-9 > div > div:nth-child(3) > div > div > div > table > tbody > tr > td:nth-child(4)")
    WebElement Category;
    
    @FindBy(css = "body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-9 > div > div:nth-child(3) > div > div > div > table > tbody > tr > td:nth-child(5)")
    WebElement Session;
    
    @FindBy(css = "body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-9 > div > div:nth-child(3) > div > div > div > table > tbody > tr > td:nth-child(6)")
    WebElement valisfrom;
    
    @FindBy(css = "body > app-root > app-sessional-members > div > div > main > app-sm-view-details > div > div > div.col-md-9 > div > div:nth-child(3) > div > div > div > table > tbody > tr > td:nth-child(7)")
    WebElement Valisto;
    
    
    // getterssssss
    @Step("get first name {0}")
    public String getFullName() {
        return fullname.getText().trim();
    }

    public String getFatherName() {
        return Fathername.getText().trim();
    }

    public String getMotherName() {
        return Mothername.getText().trim();
    }

    public String getGender() {
        return gender.getText().trim();
    }

    public String getDateOfBirth() {
        return birth.getText().trim();
    }

    public String getMobileNumber() {
        return MobileNumber.getText().trim();
    }

    public String getAlternateMobileNumber() {
        return AlternateMobileNumber.getText().trim();
    }

    public String getIdentificationMark() {
        return VisibleIdentificationMark.getText().trim();
    }

    public String getBloodGroup() {
        return BlooGroup.getText().trim();
    }

    public String getEmail() {
        return email.getText().trim();
    }

    public String getAadhaarNumber() {
        return AahaarNumber.getText().trim();
    }

    public String getOfficeNumber() {
        return OfficeNumber.getText().trim();
    }

    public String getFaxNumber() {
        return FaxNumber.getText().trim();
    }

    public String getPresentAddress() {
        return Present.getText().trim();
    }

    public String getPermanentAddress() {
        return Permanent.getText().trim();
    }
    
    public String getDesignation() {
	    return esignation.getText().trim();
	}

	public String getMinistry() {
	    return Ministry.getText().trim();
	}

	public String getCategory() {
	    return Category.getText().trim();
	}

	public String getSession() {
	    return Session.getText().trim();
	}

	public String getValidFrom() {
	    return valisfrom.getText().trim();
	}

	public String getValidTo() {
	    return Valisto.getText().trim();
	} 
	
	public void clickUploadFasciabutton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(uploadfascia)).click();
    }
	
	public void setHindiName(String name) {
	    hininame.clear();
	    hininame.sendKeys(name);
	}

	public String getHindiName() {
	    return hininame.getAttribute("value");
	}

	public void uploadPhoto(String photoFilePath) {
	    File photoFile = new File(photoFilePath);
	    if (photoFile.exists()) {
	        uploaPhoto.sendKeys(photoFile.getAbsolutePath());
	    } else {
	        throw new RuntimeException("Photo file not found at: " + photoFilePath);
	    }
	}
	
	public void uploadSignature(String signatureFilePath) {
	    File signFile = new File(signatureFilePath);
	    if (signFile.exists()) {
	        uploaSignature.sendKeys(signFile.getAbsolutePath());
	    } else {
	        throw new RuntimeException("signature file not found at: " + signatureFilePath);
	    }
	}

	public void clickSubmitFasciabutton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitFascia);
	    new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait))
	        .until(ExpectedConditions.elementToBeClickable(submitFascia));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitFascia);
	}
	
	
	// For icard request
	
	@FindBy(xpath="//tbody/tr[1]/td[14]/i")
    WebElement icarRequest;
	
	 public void clickIcarRequest() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
	        wait.until(ExpectedConditions.elementToBeClickable(icarRequest)).click();
	    }
	
	  @FindBy(xpath = "//*[@id= 'reIssuance']")
	    WebElement requestType;
	 
	  @FindBy(xpath = "//*[@id= 'approvingAuthority']")
	    WebElement approvingAuthority;
	    
	  @FindBy(xpath = "//input[@id='document']")
	    WebElement uploaocument;

	  @FindBy(xpath = "//*[@id = 'remark']")
	    WebElement remark;	
	  
	  @FindBy(xpath = "//*[@id= 'buildingId']")
	    WebElement buildingId;
	  
	  @FindBy(xpath = "//*[@id=\"rooms\"]")
	    WebElement rooms;
	  
	  @FindBy(xpath = "//button[normalize-space()='Request']")
	    WebElement requesticardbutton;
	
//	    public void setrequestType(String value) {
//	        Select select = new Select(requestType);
//	        select.selectByVisibleText(value);
//	    } 
//	    
	    public void setRequestType(String value) {
	        requestType.sendKeys(value);
	    }
	    
	    public void selectRecommendingAuthority(String authorityName) {
	        // Click the dropdown to open the list
	    	approvingAuthority.click();

	        // Type into the input to filter
	        WebElement input = driver.findElement(By.xpath("//div[@aria-expanded='true']//input[@type='text']")); // Adjust XPath as needed
	        input.sendKeys(authorityName);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait));
	        // Wait and select the matching option
	        WebElement desiredOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//span[@class='ng-option-label ng-star-inserted']")));
	        desiredOption.click();
	    }
	    
//	    public void setapprovingAuthority(String value) {
//	        Select select = new Select(approvingAuthority);
//	        select.selectByVisibleText(value);
//	    } 
	    
	    public void uploaddocument(String ocumentFilePath) {
		    File ocumentFile = new File(ocumentFilePath);
		    if (ocumentFile.exists()) {
		    	uploaocument.sendKeys(ocumentFile.getAbsolutePath());
		    } else {
		        throw new RuntimeException("Ocument file not found at: " + ocumentFilePath);
		    }
		}
	    
	    public void setremark(String value) {
	    	remark.clear();
	    	remark.sendKeys(value);
	    }
	    
	  
	    public void setBuiling(String value) {
	    	buildingId.sendKeys(value);
	    }
	    
	    public void selectRoom(String roomName) {
	        driver.findElement(By.id("rooms")).click(); // open dropdown

	        WebElement searchInput = driver.findElement(By.xpath("//div[@aria-expanded='true']//input[@type='text']"));
	        searchInput.sendKeys(roomName);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//span[@class='ng-option-label ng-star-inserted']")
	        ));
	        option.click();
	    }
	    
	    public void IcarRequestButton() {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", requesticardbutton);
		    new WebDriverWait(driver, Duration.ofSeconds(TestBase.explicitWait))
		        .until(ExpectedConditions.elementToBeClickable(requesticardbutton));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", requesticardbutton);
	    }
	    
	    @FindBy(xpath = "//img[@class='userImg ng-star-inserted']")
	    WebElement userMenu;
	    @FindBy(xpath = "//a[normalize-space()='Logout']")
	    WebElement logout;
	    
	    public void logout() throws InterruptedException {
//	        Actions actions = new Actions(driver);
//	        actions.moveToElement(userMenu).perform();
	    	userMenu.click();
	        Thread.sleep(1000);
	        logout.click();
	        Thread.sleep(3000);
	    } 
}
