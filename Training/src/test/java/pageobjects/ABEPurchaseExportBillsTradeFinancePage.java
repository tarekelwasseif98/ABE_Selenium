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
	private By limitIdPrefix = By.xpath("(//input[@id='_meoblimit_limitId$prefix'])[1]");
	private By limitIdSuffix = By.xpath("(//input[@id='_meoblimit_limitId$suffix'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_meoblimit_meoblimit_FinButton1'])[1]");
	private By billPurchaseAccountIdTextField = By.xpath("(//input[@id='_meobpur_meobpur_PurchaseAcct'])[1]");
	private By billPurchaseAmountTextField = By.xpath("(//input[@id='_meobpur_meobpur_BillPurchAmt$amt'])[1]");
	private By valueDateTextField = By.xpath("(//input[@id='_meobpur_meobpur_ValueDate'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_meobpur_meobpur_FinButton1'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_meobpreship_meobpreship_continue'])[1]");
	private By paySysIdTextField = By.xpath("(//input[@id='_meobevent_paySysId'])[1]");
	private By eventDetailsEditButton = By.xpath("(//span[@class='editcontent'])[2]");
	private By closeButton = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By rateCodeTextField = By.xpath("(//input[@id='_meobevent_pstRate$rateCode'])[1]");
	private By eventDetailsUpdateButton = By.xpath("(//button[@id='_meobevent_meobeventdet_updateSummary'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_meobevent_eventdet_FinButton1'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_meobevent_meobeventdet_updateSummary'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_meobtran_meobtran_FinButton1'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_meobtracer_tracerdet_FinButton1'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_meobmisc_meobmisc_FinButton1'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_meobaddn_meobaddn_FinButton1'])[1]");
	private By continue11Button = By.xpath("(//button[@id='_meobhistory_his_Continue'])[1]");
	//close
	private By continue12Button = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");

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
			PageFunctionUtils.waitOnElement(driver, tenorBillIdTextField);
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
}