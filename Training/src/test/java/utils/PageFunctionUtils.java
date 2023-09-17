package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFunctionUtils {
	public static void clickOnElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Properties.maxTime);
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
				if ( count > Properties.maxTime) {
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
		WebDriverWait wait = new WebDriverWait(driver, Properties.minTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(keysToSend);
	}
	
	public static void waitOnElement(WebDriver driver, By by) throws InterruptedException {
		//Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Properties.maxTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static void waitOnFrameAndSwitch(WebDriver driver, By by) throws InterruptedException {
			//Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Properties.maxTime);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
		}
	
	public static void sleep() throws InterruptedException {
		Thread.sleep(Properties.sleepTime);
		}
}