package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFunctionUtils {
	public static void clickOnElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MAXTIME);
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
				if ( count > Properties.MAXTIME) {
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
		WebDriverWait wait = new WebDriverWait(driver, Properties.MINTIME);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(keysToSend);
	}
	
	public static void clearDataInWebElement(WebDriver driver,By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MINTIME);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).clear();;
	}
	
	public static void waitOnElement(WebDriver driver, By by) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Properties.MAXTIME);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static void waitOnFrameAndSwitchXpath(WebDriver driver, By by) throws InterruptedException {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Properties.MAXTIME);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
		}
	
	public static void waitOnFrameAndSwitchId(WebDriver driver, String id) throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Properties.MAXTIME);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}
	
	public static void switchToParentFrame(WebDriver driver) throws InterruptedException {
		driver.switchTo().parentFrame();
	}
	
	public static void sleep() throws InterruptedException {
		Thread.sleep(Properties.SLEEPTIME);
		}
	
	public static void sleep2() throws InterruptedException {
		Thread.sleep(Properties.SLEEPTIME2);
		}
	
	public static void scrollUp(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
		}
	
	public static void scrollUpToElement(WebDriver driver, By by) throws InterruptedException {
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		}
	
	public static void selectDropDownListByIndex(WebDriver driver, By by, int index) {
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByIndex(index);
	}
	
	public static void selectDropDownListByVisibleText(WebDriver driver, By by, String name) {
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByVisibleText(name);
	}
	
	public static void selectDropDownListByValue(WebDriver driver, By by, String value) {
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByValue(value);
	}
	
	public static String getDropDownListSelectedValue(WebDriver driver, By by) {
		Select select = new Select(driver.findElement(by));
		WebElement option = select.getFirstSelectedOption();
		String selectedValue = option.getText();
		return selectedValue;
	}
	
	public static boolean elementIsDisplayed(WebDriver driver, By by) {
		boolean isDisplayed = driver.findElement(by).isDisplayed();
		return isDisplayed;
	}
	
	public static void acceptWarning(WebDriver driver) throws InterruptedException {
		PageFunctionUtils.switchToParentFrame(driver);
		Boolean isPresent = driver.findElements(By.xpath("(//button[normalize-space()='Accept'])[1]")).size() > 0;
		if(isPresent) {
			PageFunctionUtils.clickOnElement(driver, By.xpath("(//button[normalize-space()='Accept'])[1]"));
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, By.xpath("//iframe[@name='formArea']"));
		} else {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, By.xpath("//iframe[@name='formArea']"));
		}
	}
	
	public static void closeWarning(WebDriver driver) throws InterruptedException {
		PageFunctionUtils.switchToParentFrame(driver);
		Boolean isPresent = driver.findElements(By.xpath("(//button[normalize-space()='Close'])[1]")).size() > 0;
		if(isPresent) {
			PageFunctionUtils.clickOnElement(driver, By.xpath("(//button[normalize-space()='Close'])[1]"));
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, By.xpath("//iframe[@name='formArea']"));
		} else {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, By.xpath("//iframe[@name='formArea']"));
		}
	}
}