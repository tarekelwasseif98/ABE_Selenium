package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFunctionUtils {
	public static void clickOnElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MaxTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	@Deprecated
	public static void clickOnElementWorkAround(WebDriver driver, By by) {
		int count = 0;
		boolean bool = true;
		while (bool) {
			try {
				count++;
				driver.findElement(by).click();
				bool = false;
			} catch (Exception e) {
				if ( count > Properties.MaxTime) {
					bool = false;
				} else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			 
			}
		}
	}
	
	public static void enterDataInWebElement(WebDriver driver,By by,String keysToSend) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MinTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(keysToSend);
	}
	
	public static void clearDataInWebElement(WebDriver driver,By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MinTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).clear();;
	}
	
	public static void waitOnElement(WebDriver driver, By by) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MaxTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static void waitOnFrameAndSwitchXpath(WebDriver driver, By by) throws InterruptedException {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Properties.MaxTime);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
		}
	
	public static void waitOnFrameAndSwitchId(WebDriver driver, String id) throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Properties.MaxTime);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}
	
	public static void sleep() throws InterruptedException {
		Thread.sleep(Properties.SleepTime);
		}
}