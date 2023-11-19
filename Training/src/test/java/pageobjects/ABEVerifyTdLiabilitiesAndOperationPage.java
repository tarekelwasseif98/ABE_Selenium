package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.AssertionFactory;
import utils.PageFunctionUtils;

public class ABEVerifyTdLiabilitiesAndOperationPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By functionCodeDropdown =By.xpath("(//select[@id='_funcCode_select'])[1]"); 
	private String type = "Verify";
	private By accountIdTextField =By.xpath("(//input[@id='_acctNo'])[1]"); 
	private By GoButton =By.xpath("(//button[normalize-space()='Go'])[1]"); 
	private By submitButton =By.xpath("(//button[normalize-space()='Submit'])[1]"); 
	private By accountIdSuccessMessage =By.xpath("(//div[@id='_resMsg_finMessage'])[1]"); 
	public static String acVerificationMessage;

	private By alertSubmitButton =By.xpath("//button[@id='Submit']"); 
	private By errorPopUp =By.xpath("(//p[@id='errorItem_0.errorDesc'])[1]"); 

	
	
	public ABEVerifyTdLiabilitiesAndOperationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyTdLiabilitiesAndOperationPage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeID);
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
	public ABEVerifyTdLiabilitiesAndOperationPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("select function code dropdown")
	public ABEVerifyTdLiabilitiesAndOperationPage selectFuntionCodeType() throws Exception {
		PageFunctionUtils.waitOnElement(driver, functionCodeDropdown);
		PageFunctionUtils.clickOnElement(driver,functionCodeDropdown);
		Select functionCodeDropdownSelector = new Select(driver.findElement(functionCodeDropdown));
		functionCodeDropdownSelector.selectByVisibleText(type);
		return this;	
	}
	

	@Step("Sending Td ID: {0}")
	public ABEVerifyTdLiabilitiesAndOperationPage sendKeysAccountId(String accountId ) throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,accountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,accountIdTextField,accountId.substring(1));
		return this;
	}
	
	@Step("press go button")
	public ABEVerifyTdLiabilitiesAndOperationPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver,GoButton);

		return this;	
	}
	
	@Step("press submit button")
	public ABEVerifyTdLiabilitiesAndOperationPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver,submitButton);
		return this;	
	}
	
	@Step("Get Success Message Text")
	public ABEVerifyTdLiabilitiesAndOperationPage getSuccessMessageText() throws Exception {
		acVerificationMessage = driver.findElement(accountIdSuccessMessage).getText();
		System.out.println(acVerificationMessage);
		return this;	
	}
	
	@Step("Handle alert")
	public ABEVerifyTdLiabilitiesAndOperationPage handleAlert() throws Exception {
		driver.switchTo().parentFrame();
    	PageFunctionUtils.waitOnElement(driver, alertSubmitButton);
		PageFunctionUtils.clickOnElement(driver,alertSubmitButton);
		PageFunctionUtils.scrollUp(driver);	
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("getting success message and asserting")
	public ABEVerifyTdLiabilitiesAndOperationPage submitAssertion() throws Exception {
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		PageFunctionUtils.scrollUp(driver);
		driver.switchTo().parentFrame();
		AssertionFactory.assertionFailWithMessage(driver.findElement(errorPopUp).getText().toString());

		return this;	
	}
	

}
