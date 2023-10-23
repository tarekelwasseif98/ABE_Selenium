package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEAuthorizeOutwardTransferPaymentPage {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private String loginFrameIframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By paysysid = By.xpath("//input[@id='_paysysId']");
	private By paymentOrderTextField = By.xpath("(//input[@id='_poID'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By approvePayment = By.id("_approveButton");
	
	public ABEAuthorizeOutwardTransferPaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEAuthorizeOutwardTransferPaymentPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEAuthorizeOutwardTransferPaymentPage switchFormAreaFrame() throws Exception {
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
	public ABEAuthorizeOutwardTransferPaymentPage sendKeysPaymentOrder(String paySysID, String paymentOrder) throws Exception {
		PageFunctionUtils.waitOnElement(driver, paysysid);
		PageFunctionUtils.enterDataInWebElement(driver, paysysid, paySysID);
		PageFunctionUtils.enterDataInWebElement(driver, paymentOrderTextField, paymentOrder.substring(1));
		return this;	
	}
	
	@Step("Press Go button")
	public ABEAuthorizeOutwardTransferPaymentPage pressGOButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
}
	@Step("Press Approve button")
	public ABEAuthorizeOutwardTransferPaymentPage pressApproveButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, approvePayment);
		return this;
	}
}