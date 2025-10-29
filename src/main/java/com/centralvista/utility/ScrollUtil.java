/**
 * @author surendragangwar
 * @since 23-Jun-2025
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;



	public class ScrollUtil {

		public static void scrollUntilElementVisible(WebDriver driver, By locator) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    int maxScrolls = 10; // safety limit
		    int scrollCount = 0;

		    // Scroll DOWN first
		    while (scrollCount < maxScrolls) {
		        try {
		            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		            WebElement element = driver.findElement(locator);
		            js.executeScript("arguments[0].scrollIntoView(true);", element);
		            return; // ✅ found, stop execution
		        } catch (TimeoutException e) {
		            js.executeScript("window.scrollBy(0, 300);"); // scroll down
		            scrollCount++;
		        }
		    }

		    // If not found, try scrolling UP
		    scrollCount = 0;
		    while (scrollCount < maxScrolls) {
		        try {
		            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		            WebElement element = driver.findElement(locator);
		            js.executeScript("arguments[0].scrollIntoView(true);", element);
		            return; // ✅ found, stop execution
		        } catch (TimeoutException e) {
		            js.executeScript("window.scrollBy(0, -300);"); // scroll up
		            scrollCount++;
		        }
		    }

		    throw new RuntimeException("❌ Element not found after scrolling up & down: " + locator);
		}
		
		public static void scrollToTop(WebDriver driver) {
		    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		}
		
		public static void scrollToBottom(WebDriver driver) {
		    ((JavascriptExecutor) driver).executeScript(
		        "window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });"
		    );
		}
	}
