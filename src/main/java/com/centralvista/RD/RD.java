package com.centralvista.RD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.decorators.WebDriverDecorator;
public class RD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\AutomationBackUp\\latestChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		
		WebDriver wd = new ChromeDriver();		
		
		
		wd.get("http://localhost/#/login");
		wd.manage().window().maximize();
		wd.findElement(By.xpath("//*[@id='typeEmailX']")).sendKeys("11488");
		wd.findElement(By.xpath("//*[@id='typePasswordX']")).sendKeys("Cdac@123");
		//wd.findElement(By..linkText("Forgot password?")).click();
		
		String title=wd.findElement(By.xpath("//h2[contains(text(),'Login')]")).getText();
		
		System.out.println("The txt label is "+title);
		//wd.findElement(By.className("btn btn-outline-light btn-lg px-5")).click();
		
		
		//wd.get("https://facebook.com"); http://localhost/#/login
	    //wd.get("http://localhost/#/login");
	    //wd.findElement(By.xpath("//*[@id=\'typeEmailX\']")).sendKeys("11488");
		//wd.findElement(By.id("typePasswordX")).sendKeys("Cdac@123");
		//wd.findElement("")
		//wd.findElement(By)	
	
	
	
	}

}
