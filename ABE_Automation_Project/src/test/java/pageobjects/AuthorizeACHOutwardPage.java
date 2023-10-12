package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class AuthorizeACHOutwardPage {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private String loginFrameIframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By paysysID = By.xpath("//input[@id='_paysysId']");
	private By paymentOrderTextField = By.xpath("(//input[@id='_poID'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By approvePayment = By.id("_approveButton");
	

	public AuthorizeACHOutwardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public AuthorizeACHOutwardPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public AuthorizeACHOutwardPage switchFormAreaFrame() throws Exception {
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
	public AuthorizeACHOutwardPage sendKeysPaymentOrder(String PaySysID, String PaymentOrder) throws Exception {
		PageFunctionUtils.waitOnElement(driver, paysysID);
		
		driver.findElement(paysysID).sendKeys(PaySysID);
			
		driver.findElement(paymentOrderTextField).sendKeys(PaymentOrder.substring(1));
		return this;
		
	}
	
	@Step("Press Go button")
	public AuthorizeACHOutwardPage pressGOButton() throws Exception {
		driver.findElement(goButton).click();
		Thread.sleep(3500);
		return this;
}
	
	
	@Step("Press Approve button")
	public AuthorizeACHOutwardPage pressApproveButton() throws Exception {
		driver.findElement(approvePayment).click();
		return this;
	}
}