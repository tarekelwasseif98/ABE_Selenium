package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By acidTextField = By.id("_tempAcid");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By continueButton = By.xpath("(//button[@id='_acctDetCon'])[1]");

	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");

	public ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending a/c. id: {0}")
	public ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage sendKeysAcidTextField(String ACID) throws Exception {
		
		ACID = ACID.substring(1);
		PageFunctionUtils.waitOnElement(driver, acidTextField);
		PageFunctionUtils.clickAction(driver,acidTextField);
		PageFunctionUtils.enterDataInWebElement(driver,acidTextField,ACID);
		PageFunctionUtils.clickAction(driver,goButton);
		PageFunctionUtils.clickAction(driver,continueButton);


		return this;
	}
	

	@Step("Press submit button")
	public ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage pressSubmitButton() throws Exception {

		PageFunctionUtils.clickAction(driver,submitButton);

		return this;
	}
	
	
	
	
}
