package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABEDisburseMurabahaAccountMurabahaFinancingPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By murabahaAccountIdTextField = By.xpath("(//input[@id='_acctNum'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By valueDateTextField = By.xpath("(//input[@id='_valueDate'])[1]");
	private By transactionTypeRadioButton = By.xpath("(//input[@id='_tranTypetransfer_radio'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_disbursedet_BContinue'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_adddet_continueBt'])[1]");
	private By addButton = By.xpath("(//span[@id='_dg_trdisbmoddet_AddRecBtn_label'])[1]");
	private By modeOfDisbursementDropDownList = By.xpath("(//select[@id='_trdisbmode_mode_select'])[1]");
	private By creditAccountIdTextfield = By.xpath("(//input[@id='_trdisbmode_extAccountId'])[1]");
	private By saveAndPreviewButton = By.xpath("(//button[normalize-space()='Save and Preview'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_disbmoddet_continue'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	public static String acId;
	public static String  murabahaAccountId = "murabahaAccountId";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public ABEDisburseMurabahaAccountMurabahaFinancingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEDisburseMurabahaAccountMurabahaFinancingPage sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
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
	public ABEDisburseMurabahaAccountMurabahaFinancingPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending customer details: {0}")
	public ABEDisburseMurabahaAccountMurabahaFinancingPage sendKeysMurabahaAccountId(String murabahaAccountId) throws Exception {
		PageFunctionUtils.waitOnElement(driver, murabahaAccountIdTextField);
		PageFunctionUtils.clickOnElement(driver, murabahaAccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, murabahaAccountIdTextField, murabahaAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Sending value date: {0}")
	public ABEDisburseMurabahaAccountMurabahaFinancingPage sendKeysValueDateTextField(String valueDate) throws Exception {
		PageFunctionUtils.enterDataInWebElement(driver, valueDateTextField, valueDate.substring(1));
		PageFunctionUtils.clickOnElement(driver, transactionTypeRadioButton);
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            PageFunctionUtils.clickOnElement(driver, continue1Button);
        } catch (Exception e) {
		}
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Sending disbursement mode details: {0}")
	public ABEDisburseMurabahaAccountMurabahaFinancingPage sendKeysDisbursementModeDetails(String creditAccountId) throws Exception {
		PageFunctionUtils.clickOnElement(driver, addButton);
		PageFunctionUtils.selectDropDownListByIndex(driver, modeOfDisbursementDropDownList, 1);
		PageFunctionUtils.enterDataInWebElement(driver, creditAccountIdTextfield, creditAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewButton);
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABEDisburseMurabahaAccountMurabahaFinancingPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABEDisburseMurabahaAccountMurabahaFinancingPage saveAccountId(String accountId, String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.DisburseMurabahaAccountCsv, linkedTcidCsvColumnName, linkedId);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyMurabahaAccountDisbursementCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyMurabahaAccountDisbursementCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.VerifyMurabahaAccountDisbursementCsv, rowByTcid2, columnByColumnName2, accountId);
		}
		return this;
	}												
}