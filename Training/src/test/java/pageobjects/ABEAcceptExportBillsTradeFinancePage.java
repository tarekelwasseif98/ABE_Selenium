package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEAcceptExportBillsTradeFinancePage {
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
	private By generalDetailsSideTab = By.xpath("(//span[@id='fbmgeneral_textSpan'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_meobgen_meobgen_FinButton1'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_meobparty_meobparty_FinButton1'])[1]");
	private By tenorDetailsEditButton1 = By.xpath("(//span[@class='editcontent'])[1]");
	private By tenorDetailsEditButton2 = By.xpath("(//span[@class='editcontent'])[2]");
	private By acceptanceDateTextField = By.xpath("(//input[@id='_acceptDate'])[1]");
	private By tenorDetailsUpdateButton = By.xpath("(//button[@id='_tenordetails_updateSummary'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_meobtenor_continue'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_meobbill_meobbill_FinButton1'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_meobassign_FinButton1'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_meoblimit_meoblimit_FinButton1'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_meobpur_meobpur_FinButton1'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_meobevent_eventdet_FinButton1'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_meobtran_meobtran_FinButton1'])[1]");
	private By continue11Button = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
	private By continue12Button = By.xpath("(//button[@id='_meobtracer_tracerdet_FinButton1'])[1]");
	private By continue13Button = By.xpath("(//button[@id='_meobmisc_meobmisc_FinButton1'])[1]");
	private By continue14Button = By.xpath("(//button[@id='_meobaddn_meobaddn_FinButton1'])[1]");
	private By continue15Button = By.xpath("(//button[@id='_meobhistory_his_Continue'])[1]");
	private By closeButton = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By continue16Button = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By repeatTaskButton = By.xpath("(//button[normalize-space()='Repeat Task'])[1]");
	public static String billId;
	public static String  billIdCsvColumnName = "billId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public ABEAcceptExportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEAcceptExportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEAcceptExportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending bill id: {0}")
	public ABEAcceptExportBillsTradeFinancePage sendKeysBillIdTextField(String billId) throws Exception {
		if(billId != null) {
			PageFunctionUtils.waitOnElement(driver, billIdTextField);
			PageFunctionUtils.clickOnElement(driver, billIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billIdTextField, billId.substring(1));
		}
		return this;
	}
	
	@Step("Sending tenor bill id: {0}")
	public ABEAcceptExportBillsTradeFinancePage sendKeysTenorBillIdTextField(String tenorBillId) throws Exception {
		if(tenorBillId != null) {
			PageFunctionUtils.waitOnElement(driver, tenorBillIdTextField);
			PageFunctionUtils.clickOnElement(driver, tenorBillIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, tenorBillIdTextField, tenorBillId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEAcceptExportBillsTradeFinancePage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("General details side tab navigation")
	public ABEAcceptExportBillsTradeFinancePage navigateGeneralDetailsSideTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, generalDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, generalDetailsSideTab);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue1Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue1Button);
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue2Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue2Button);
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Press tenor details edit button")
	public ABEAcceptExportBillsTradeFinancePage pressTenorDetailsEditButton1() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsEditButton1);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsEditButton1);
		return this;
	}
	
	@Step("Press tenor details edit button")
	public ABEAcceptExportBillsTradeFinancePage pressTenorDetailsEditButton2() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsEditButton2);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsEditButton2);
		return this;
	}
	
	@Step("Sending acceptance date: {0}")
	public ABEAcceptExportBillsTradeFinancePage sendKeysAcceptanceDateTextField(String acceptanceDate) throws Exception {
		if(acceptanceDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, acceptanceDateTextField);
			PageFunctionUtils.clickOnElement(driver, acceptanceDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, acceptanceDateTextField, acceptanceDate.substring(1));
		}
		return this;
	}
	
	@Step("Press tenor details update button")
	public ABEAcceptExportBillsTradeFinancePage pressTenorDetailsUpdateButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsUpdateButton);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsUpdateButton);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue3Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue3Button);
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue4Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue4Button);
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue5Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue5Button);
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue6Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue6Button);
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue7Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue7Button);
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue8Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue8Button);
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue9Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue9Button);
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue10Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue10Button);
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue11Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue11Button);
		PageFunctionUtils.clickOnElement(driver, continue11Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue12Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue12Button);
		PageFunctionUtils.clickOnElement(driver, continue12Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue13Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue13Button);
		PageFunctionUtils.clickOnElement(driver, continue13Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue14Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue14Button);
		PageFunctionUtils.clickOnElement(driver, continue14Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEAcceptExportBillsTradeFinancePage pressContinue15Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue15Button);
		PageFunctionUtils.clickOnElement(driver, continue15Button);
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
	public ABEAcceptExportBillsTradeFinancePage pressContinue16Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue16Button);
		PageFunctionUtils.clickOnElement(driver, continue16Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABEAcceptExportBillsTradeFinancePage pressSubmitButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, submitButton);
		PageFunctionUtils.clickOnElement(driver, submitButton);
		return this;
	}
	
	@Step("Press repeat task button")
	public ABEAcceptExportBillsTradeFinancePage pressRepeatTaskButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, repeatTaskButton);
		PageFunctionUtils.clickOnElement(driver, repeatTaskButton);
		return this;
	}
}