package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFunctionUtils {
	public static void clickOnElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MAX_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	
	public static void clickOnElementWorkAround(WebDriver driver, By by) {
		int count = 0;
		boolean bool = true;
		while (bool) {
			try {
				count++;
				driver.findElement(by).click();
				bool = false;
			} catch (Exception e) {
				if ( count > Properties.MAX_TIME) {
					bool = false;
				} else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			 
			}
		}
	}
	
	public static void enterDataInWebElement(WebDriver driver,By by,String keysToSend) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MIN_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(keysToSend);
	}
	
	public static void sync(WebDriver driver, By by) throws InterruptedException {
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Properties.MAX_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static void sync2(WebDriver driver, By by) throws InterruptedException {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Properties.MAX_TIME);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
		}
	
//	public static void sync4(WebDriver driver) throws InterruptedException {
//		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Properties.MAX_TIME);
//		wait.until(ExpectedConditions.all);
//	}
	
	public static void sync3(WebDriver driver, String by) {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MAX_TIME);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
	}
}