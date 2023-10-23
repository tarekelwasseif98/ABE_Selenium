package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyOutwardTransferPaymentPage {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private String loginFrameIframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By dropdownAction = By.xpath("(//select[@id='_cFinFuncCode$funcCombo_select'])[1]");
	private By paymentOrderTextField = By.xpath("//input[@id='_po_id']");
	private By submitduplicateButton = By.id("Submit");
	private By goButton = By.id("_go");
	private By submitPayment = By.id("_submit");
	

	public ABEVerifyOutwardTransferPaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyOutwardTransferPaymentPage sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
		driver.switchTo().frame((loginFrameIframeID));
		PageFunctionUtils.waitOnElement(driver, searchBarTextField);
		PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
        PageFunctionUtils.clickOnElement(driver, searchButton);	       
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        }
        catch (Exception e) {
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEVerifyOutwardTransferPaymentPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame((loginFrameIframeId));
	    driver.switchTo().frame((coreAbeIframeId));
	    driver.switchTo().frame((uxIframeId));
		PageFunctionUtils.waitOnElement(driver, but);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}
	
	@Step("Sending payment details: {0}")
	public ABEVerifyOutwardTransferPaymentPage sendKeysPaymentOrder(String paymentOrder) throws Exception {
		PageFunctionUtils.waitOnElement(driver, dropdownAction);
		
		Select dropdown1 = new Select(driver.findElement(dropdownAction));
		dropdown1.selectByIndex(3);
		
		PageFunctionUtils.enterDataInWebElement(driver, paymentOrderTextField, paymentOrder.substring(1));
		return this;
		
	}
	
	@Step("Press Go button")
	public ABEVerifyOutwardTransferPaymentPage pressGOButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
}
	
	
	@Step("Press submit button")
	public ABEVerifyOutwardTransferPaymentPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitPayment);
		
		try {
			driver.switchTo().parentFrame();
			PageFunctionUtils.clickOnElement(driver, submitduplicateButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		} catch(Exception e) {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		}
		return this;
		
	}
	
}