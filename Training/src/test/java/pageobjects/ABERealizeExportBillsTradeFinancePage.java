package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABERealizeExportBillsTradeFinancePage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By billIdTextField = By.xpath("(//input[@id='_billIdOthers'])[1]");
	private By tenorBillIdTextField = By.xpath("(//input[@id='_tenorBillId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By realizationAccountIdTextField = By.xpath("(//input[@id='_meobreal_brAcct'])[1]");
	private By billRealizationAmountTextField = By.xpath("(//input[@id='_meobreal_brAmt$amt'])[1]");
	private By realizationValueDateTextField = By.xpath("(//input[@id='_meobreal_realValueDate'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_meobreal_meobreal_FinButton1'])[1]");
	private By paySysIdTextField = By.xpath("(//input[@id='_meobevent_paySysId'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_meobevent_eventdet_FinButton1'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
	private By closeButton1 = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By repeatTaskButton = By.xpath("(//button[normalize-space()='Repeat Task'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Perform Export and Outward Bill Realization'])[1]");

	public ABERealizeExportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABERealizeExportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABERealizeExportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending bill id: {0}")
	public ABERealizeExportBillsTradeFinancePage sendKeysBillIdTextField(String billId) throws Exception {
		if(billId != null) {
			PageFunctionUtils.waitOnElement(driver, billIdTextField);
			PageFunctionUtils.clickOnElement(driver, billIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billIdTextField, billId.substring(1));
		}
		return this;
	}
	
	@Step("Sending tenor bill id: {0}")
	public ABERealizeExportBillsTradeFinancePage sendKeysTenorBillIdTextField(String tenorBillId) throws Exception {
		if(tenorBillId != null) {
			PageFunctionUtils.clickOnElement(driver, tenorBillIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, tenorBillIdTextField, tenorBillId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABERealizeExportBillsTradeFinancePage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Sending realization account id: {0}")
	public ABERealizeExportBillsTradeFinancePage sendKeysRealizationAccountIdTextField(String realizationAccountId) throws Exception {
		if(realizationAccountId != null) {
			PageFunctionUtils.waitOnElement(driver, realizationAccountIdTextField);
			PageFunctionUtils.clearDataInWebElement(driver, realizationAccountIdTextField);
			PageFunctionUtils.clickOnElement(driver, realizationAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, realizationAccountIdTextField, realizationAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Sending bill realization amount: {0}")
	public ABERealizeExportBillsTradeFinancePage sendKeysBillRealizationAmountTextField(String billRealizationAmount) throws Exception {
		if(billRealizationAmount != null) {
			PageFunctionUtils.clickOnElement(driver, billRealizationAmountTextField);
			PageFunctionUtils.clearDataInWebElement(driver, billRealizationAmountTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billRealizationAmountTextField, billRealizationAmount);
		}
		return this;
	}
	
	@Step("Sending value date: {0}")
	public ABERealizeExportBillsTradeFinancePage sendKeysValueDateTextField(String realizationValueDate) throws Exception {
		if(realizationValueDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, realizationValueDateTextField);
			PageFunctionUtils.clickOnElement(driver, realizationValueDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, realizationValueDateTextField, realizationValueDate.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABERealizeExportBillsTradeFinancePage pressContinue1Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Sending paysys id: {0}")
	public ABERealizeExportBillsTradeFinancePage sendKeysPaySysIdTextField(String paySysId) throws Exception {
		if(paySysId != null) {
			PageFunctionUtils.waitOnElement(driver, paySysIdTextField);
			PageFunctionUtils.clickOnElement(driver, paySysIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, paySysIdTextField, paySysId);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABERealizeExportBillsTradeFinancePage pressContinue2Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton1);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABERealizeExportBillsTradeFinancePage pressContinue3Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABERealizeExportBillsTradeFinancePage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
	
	@Step("Press repeat task button")
	public ABERealizeExportBillsTradeFinancePage pressRepeatTaskButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, repeatTaskButton);
		PageFunctionUtils.clickOnElement(driver, repeatTaskButton);
		return this;
	}
}