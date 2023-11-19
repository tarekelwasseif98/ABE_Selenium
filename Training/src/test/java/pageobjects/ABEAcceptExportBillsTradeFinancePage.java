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
	private By eventDetailsSideTabMenu = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By paySysIdTextField = By.xpath("(//input[@id='_meobevent_paySysId'])[1]");
	private By transactionDetailsSideTabMenu = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Accept Export and Outward Bill'])[1]");
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
	
	@Step("Side tab navigation")
	public ABEAcceptExportBillsTradeFinancePage navigateEventDetailsSideTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, eventDetailsSideTabMenu);
		PageFunctionUtils.clickOnElement(driver, eventDetailsSideTabMenu);
		return this;
	}
	
	@Step("Sending paysys id: {0}")
	public ABEAcceptExportBillsTradeFinancePage sendKeysPaySysIdTextField(String paySysId) throws Exception {
		if(paySysId != null) {
			PageFunctionUtils.waitOnElement(driver, paySysIdTextField);
			PageFunctionUtils.clearDataInWebElement(driver, paySysIdTextField);
			PageFunctionUtils.clickOnElement(driver, paySysIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, paySysIdTextField, paySysId);
		}
		return this;
	}
	
	@Step("Side tab navigation")
	public ABEAcceptExportBillsTradeFinancePage navigateTransactionDetailsSideTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, transactionDetailsSideTabMenu);
		PageFunctionUtils.clickOnElement(driver, transactionDetailsSideTabMenu);
		return this;
	}
	
	@Step("Side tab navigation")
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
	
	@Step("Press submit button")
	public ABEAcceptExportBillsTradeFinancePage pressSubmitButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, submitButton);
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
	
	@Step("Press repeat task button")
	public ABEAcceptExportBillsTradeFinancePage pressRepeatTaskButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, repeatTaskButton);
		PageFunctionUtils.clickOnElement(driver, repeatTaskButton);
		return this;
	}
}