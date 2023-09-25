package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class CreateAchOutwardPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By DropdownAction = By.xpath("(//select[@id='_cFinFuncCode$funcCombo_select'])[1]");
	private By PaySysTextField = By.xpath("(//input[@id='_cPaysysID'])[1]");
	private By PayTypeDropdown = By.xpath("(//select[@id='_cPaymentType_select'])[1]");
	private By GoButton = By.id("_go");
	
	public CreateAchOutwardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public CreateAchOutwardPage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitch(driver, loginFrameIframeID);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
	        PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
	        } catch (Exception e) {
	        }
	        return this;        
	}
	
	@Step("Frame switching")
	public CreateAchOutwardPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitch(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending payment details: {0}")
	public CreateAchOutwardPage sendKeysPaymentType(String PaySys) throws Exception {
		PageFunctionUtils.waitOnElement(driver, DropdownAction);
		
		Select dropdown1 = new Select(driver.findElement(DropdownAction));
		dropdown1.selectByIndex(1);
		
		Select dropdown2 = new Select(driver.findElement(PayTypeDropdown));
		dropdown2.selectByIndex(1);
		
		driver.findElement(PaySysTextField).sendKeys(PaySys);
		return this;
		
	}
	
	@Step("Press Go button")
	public CreateAchOutwardPage pressSubmitButton() throws Exception {
		driver.findElement(GoButton).click();
		Thread.sleep(3500);
		return this;
}
	
	
	@Step("Sending ACH Outward Payment details: {0}")
	public CreateAchOutwardPage sendKeysAchOutwardPayment(String PaySys) throws Exception {
		PageFunctionUtils.waitOnElement(driver, DropdownAction);
		
		Select dropdown1 = new Select(driver.findElement(DropdownAction));
		dropdown1.selectByIndex(1);
		
		Select dropdown2 = new Select(driver.findElement(PayTypeDropdown));
		dropdown2.selectByIndex(1);
		
		driver.findElement(PaySysTextField).sendKeys(PaySys);
		return this;
		
	}
}