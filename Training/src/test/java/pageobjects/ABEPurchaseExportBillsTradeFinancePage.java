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
	private By eventDetailsSideTabMenu = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By paySysIdTextField = By.xpath("(//input[@id='_meobevent_paySysId'])[1]");
	private By transactionDetailsSideTabMenu = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By repeatTaskButton = By.xpath("(//button[normalize-space()='Repeat Task'])[1]");
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
	
	@Step("Side tab navigation")
	public ABEPurchaseExportBillsTradeFinancePage navigateEventDetailsSideTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, eventDetailsSideTabMenu);
		PageFunctionUtils.clickOnElement(driver, eventDetailsSideTabMenu);
		return this;
	}
	
	@Step("Sending paysys id: {0}")
	public ABEPurchaseExportBillsTradeFinancePage sendKeysPaySysIdTextField(String paySysId) throws Exception {
		if(paySysId != null) {
			PageFunctionUtils.waitOnElement(driver, paySysIdTextField);
			PageFunctionUtils.clearDataInWebElement(driver, paySysIdTextField);
			PageFunctionUtils.clickOnElement(driver, paySysIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, paySysIdTextField, paySysId);
		}
		return this;
	}
	
	@Step("Side tab navigation")
	public ABEPurchaseExportBillsTradeFinancePage navigateTransactionDetailsSideTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, transactionDetailsSideTabMenu);
		PageFunctionUtils.clickOnElement(driver, transactionDetailsSideTabMenu);
		return this;
	}
	
	@Step("Press submit button")
	public ABEPurchaseExportBillsTradeFinancePage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
	
	@Step("Press repeat task button")
	public ABEPurchaseExportBillsTradeFinancePage pressRepeatTaskButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, repeatTaskButton);
		PageFunctionUtils.clickOnElement(driver, repeatTaskButton);
		return this;
	}
}