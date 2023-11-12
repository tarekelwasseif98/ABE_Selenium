package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_tempForacid'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Authorize Islamic Finance Account'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_btn_continueBasic'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_btn_continueLoandet'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_btn_continueFee'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_btn_continueint'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_btn_continueRelP'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_btn_continueRepayParm'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_btn_continueRepaySchdet'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_btn_continueRepIns'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_btn_continueacctlmts'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_btn_continueDoc'])[1]");

	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage sendKeysSearchBarTextField(String menu) throws Exception {
		if(menu != null) {
			PageFunctionUtils.sleep();
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
			PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);	       
	        WebDriverWait wait = new WebDriverWait(driver, 45);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
		        }
	        catch (Exception e) {
	        }
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;	
	}
	
	@Step("Sending account id: {0}")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage sendKeysAccountIdTextField(String accountId) throws Exception {
		if(accountId != null) {
			PageFunctionUtils.waitOnElement(driver, accountIdTextField);
			PageFunctionUtils.clickOnElement(driver, accountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue1Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue2Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue3Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue4Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue5Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue6Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue7Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue8Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue9Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressContinue10Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
}