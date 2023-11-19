package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifySTOPage {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private String loginFrameIframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By dropdownAction = By.xpath("(//select[@id='_criteria_FinFuncCode1$funcCombo_select'])[1]");
	private By mandateTypeRadioButton = By.xpath("(//label[normalize-space()='Standing Order'])[1]");
	private By mandateRefIDTextField = By.xpath("(//input[@id='_mandate_ref_no_crit'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitPayment = By.xpath("(//button[normalize-space()='Submit'])[1]");
	

	public ABEVerifySTOPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifySTOPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifySTOPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame((loginFrameIframeId));
	    driver.switchTo().frame((coreAbeIframeId));
	    driver.switchTo().frame((uxIframeId));
		PageFunctionUtils.waitOnElement(driver, but);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}
	
	@Step("Sending STO details: {0}")
	public ABEVerifySTOPage sendKeysMandateRef(String mandateRef) throws Exception {
		PageFunctionUtils.waitOnElement(driver, dropdownAction);

		// Select Drop Down Action
		Select dropdown1 = new Select(driver.findElement(dropdownAction));
		dropdown1.selectByIndex(4);

		// Select Mandate type Radio Button
		PageFunctionUtils.clickOnElement(driver, mandateTypeRadioButton);

		// Enter Mandate REF ID
		PageFunctionUtils.enterDataInWebElement(driver, mandateRefIDTextField, mandateRef.substring(1));
		return this;
	}
	
	@Step("Press Go button")
	public ABEVerifySTOPage pressGOButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
}
	
	
	@Step("Press submit button")
	public ABEVerifySTOPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitPayment);
		return this;
		
	}
	
}