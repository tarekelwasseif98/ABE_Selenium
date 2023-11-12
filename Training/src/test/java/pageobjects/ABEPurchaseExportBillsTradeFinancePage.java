package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEPurchaseExportBillsTradeFinancePage {
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
	private By limitDetailsSideTabMenu = By.xpath("(//span[@id='fbmlimit_textSpan'])[1]");
	private By limitIdPrefixTextField = By.xpath("(//input[@id='_meoblimit_limitId$prefix'])[1]");
	private By limitIdSuffixTextField = By.xpath("(//input[@id='_meoblimit_limitId$suffix'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_meoblimit_meoblimit_FinButton1'])[1]");
	private By billPurchaseAccountIdTextField = By.xpath("(//input[@id='_meobpur_meobpur_PurchaseAcct'])[1]");
	private By billPurchaseAmountTextField = By.xpath("(//input[@id='_meobpur_meobpur_BillPurchAmt$amt'])[1]");
	private By valueDateTextField = By.xpath("(//input[@id='_meobpur_meobpur_ValueDate'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_meobpur_meobpur_FinButton1'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_meobpreship_meobpreship_continue'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_meobevent_eventdet_FinButton1'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_meobtran_meobtran_FinButton1'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_meobtracer_tracerdet_FinButton1'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_meobmisc_meobmisc_FinButton1'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_meobaddn_meobaddn_FinButton1'])[1]");
	private By continue11Button = By.xpath("(//button[@id='_meobhistory_his_Continue'])[1]");
	private By continue12Button = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By closeButton = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Purchase Export and Outward Bill'])[1]");

	public ABEPurchaseExportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEPurchaseExportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEPurchaseExportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending bill id: {0}")
	public ABEPurchaseExportBillsTradeFinancePage sendKeysBillIdTextField(String billId) throws Exception {
		if(billId != null) {
			PageFunctionUtils.waitOnElement(driver, billIdTextField);
			PageFunctionUtils.clickOnElement(driver, billIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billIdTextField, billId.substring(1));
		}
		return this;
	}
	
	@Step("Sending tenor bill id: {0}")
	public ABEPurchaseExportBillsTradeFinancePage sendKeysTenorBillIdTextField(String tenorBillId) throws Exception {
		if(tenorBillId != null) {
			PageFunctionUtils.clickOnElement(driver, tenorBillIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, tenorBillIdTextField, tenorBillId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEPurchaseExportBillsTradeFinancePage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Side tab navigation")
	public ABEPurchaseExportBillsTradeFinancePage navigateLimitDetailsSideTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, limitDetailsSideTabMenu);
		PageFunctionUtils.clickOnElement(driver, limitDetailsSideTabMenu);
		return this;
	}
	
	@Step("Sending limit id: {0}")
	public ABEPurchaseExportBillsTradeFinancePage sendKeysLimitIdTextField(String limitIdPrefix, String limitIdSuffix) throws Exception {
		if(limitIdPrefix != null) {
			PageFunctionUtils.waitOnElement(driver, limitIdPrefixTextField);
			PageFunctionUtils.clickOnElement(driver, limitIdPrefixTextField);
			PageFunctionUtils.enterDataInWebElement(driver, limitIdPrefixTextField, limitIdPrefix.substring(1));
		}
		if(limitIdSuffix != null) {
			PageFunctionUtils.waitOnElement(driver, limitIdSuffixTextField);
			PageFunctionUtils.clickOnElement(driver, limitIdSuffixTextField);
			PageFunctionUtils.enterDataInWebElement(driver, limitIdSuffixTextField, limitIdSuffix.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue1Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Sending bill purchase account id: {0}")
	public ABEPurchaseExportBillsTradeFinancePage sendKeysBillPurchaseAccountIdTextField(String billPurchaseAccountId) throws Exception {
		if(billPurchaseAccountId != null) {
			PageFunctionUtils.waitOnElement(driver, billPurchaseAccountIdTextField);
			PageFunctionUtils.clearDataInWebElement(driver, billPurchaseAccountIdTextField);
			PageFunctionUtils.clickOnElement(driver, billPurchaseAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billPurchaseAccountIdTextField, billPurchaseAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Sending bill purchase amount: {0}")
	public ABEPurchaseExportBillsTradeFinancePage sendKeysBillPurchaseAmountTextField(String billPurchaseAmount) throws Exception {
		if(billPurchaseAmount != null) {
			PageFunctionUtils.clickOnElement(driver, billPurchaseAmountTextField);
			PageFunctionUtils.clearDataInWebElement(driver, billPurchaseAmountTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billPurchaseAmountTextField, billPurchaseAmount);
		}
		return this;
	}
	
	@Step("Sending value date: {0}")
	public ABEPurchaseExportBillsTradeFinancePage sendKeysValueDateTextField(String valueDate) throws Exception {
		if(valueDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, valueDateTextField);
			PageFunctionUtils.clickOnElement(driver, valueDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, valueDateTextField, valueDate.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue2Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue3Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue4Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue5Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue6Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue7Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue8Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue9Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue10Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue11Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue11Button);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEPurchaseExportBillsTradeFinancePage pressContinue12Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue12Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABEPurchaseExportBillsTradeFinancePage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
}