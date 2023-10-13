package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
WebDriver driver;

@FindBy(xpath="//*[@id=\'typeEmailX\']")
WebElement textBoxUsername;

@FindBy(xpath="//*[@id=\'typePasswordX\']")
WebElement textBoxPassword; 

@FindBy(xpath="/html/body/app-root/app-login/section/div/div/div/div/div/form/div/button")
WebElement buttonLogin;

@FindBy(xpath="/html/body/app-root/app-login/section/div/div/div/div/div/form/div/p")
WebElement labelTitle;

public Login(WebDriver webdriver)
{
	
	this.driver = driver;

    //This initElements method will create all WebElements

    PageFactory.initElements(driver, this);
}

public String getLabelTitle()
{
	return labelTitle.getText();
}

public void setUserName(String userName)
{
	textBoxUsername.sendKeys(userName);
	
}
public void setPassword(String password)
{
	textBoxPassword.sendKeys(password);
	
}
public void clickBtnLogin()
{
	buttonLogin.click();
	
}
}
