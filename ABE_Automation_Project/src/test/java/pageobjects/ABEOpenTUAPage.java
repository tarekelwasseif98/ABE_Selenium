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

public class ABEOpenTUAPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId = By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By cifIdTextField = By.xpath("(//input[@id='_critcifId'])[1]");
	private By schemeCodeTextField = By.xpath("(//input[@id='_schmCode'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By valueDateTextField = By.xpath("(//input[@id='_valueDate'])[1]");
	private By depositPeriodMonthsTextField = By.xpath("(//input[@id='_depPeriod$duration1'])[1]");
	private By depositPeriodDaysTextField = By.xpath("(//input[@id='_depPeriod$duration2'])[1]");
	private By initialDepositAmountTextField = By.xpath("(//input[@id='_iniDepAmt$amt'])[1]");
	private By profitCreditAccountIdTextField = By.xpath("(//input[@id='_intCrAcId'])[1]");
	private By repaymentAccountIdTextField = By.xpath("(//input[@id='_repActId'])[1]");
	private By debitAccountIdTextField = By.xpath("(//input[@id='_trnActId'])[1]");
	private By accountOpeningDateTextField = By.xpath("(//input[@id='_gnDtAcOpDte'])[1]");
	private By applicationDateTextField = By.xpath("(//input[@id='_applicnDte'])[1]");
	private By peggingFrequencyTextField = By.xpath("(//input[@id='_pegFrenew$duration1'])[1]");
	private By continueButton1 = By.xpath("(//button[@id='_bdtlCtnBtn'])[1]");
	private By continueButton2 = By.xpath("(//button[@id='_gnDtlCtnBtn'])[1]");
	private By continueButton3 = By.xpath("(//button[@id='_shmCont'])[1]");
	private By renewalAndClosureDetailsTab = By.xpath("(//a[@id='stepVIII_anchor'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	private String peggingFrequencyValue = "1";
	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public ABEOpenTUAPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEOpenTUAPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEOpenTUAPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending customer details: {0}")
	public ABEOpenTUAPage sendKeysAccountDetails(String cifid, String schemeCode) throws Exception {
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		PageFunctionUtils.clickOnElement(driver, cifIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifid);
		PageFunctionUtils.clickOnElement(driver, schemeCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver, schemeCodeTextField, schemeCode);
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Sending tua details: {0}")
	public ABEOpenTUAPage sendKeysTUADetails(String valueDate, String depositPeriodMonths, String depositPeriodDays, String initialDepositAmount, String profitCreditAccountId, String repaymentAccountId, String debitAccountId) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, valueDateTextField);
		PageFunctionUtils.clickOnElement(driver, valueDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, valueDateTextField, valueDate.substring(1));
		PageFunctionUtils.clearDataInWebElement(driver, depositPeriodMonthsTextField);
		PageFunctionUtils.enterDataInWebElement(driver, depositPeriodMonthsTextField, depositPeriodMonths);
		PageFunctionUtils.clearDataInWebElement(driver, depositPeriodDaysTextField);
		PageFunctionUtils.enterDataInWebElement(driver, depositPeriodDaysTextField, depositPeriodDays);
		PageFunctionUtils.clearDataInWebElement(driver, initialDepositAmountTextField);
		PageFunctionUtils.enterDataInWebElement(driver, initialDepositAmountTextField, initialDepositAmount);
		PageFunctionUtils.clickOnElement(driver, profitCreditAccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, profitCreditAccountIdTextField, profitCreditAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, repaymentAccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, repaymentAccountIdTextField, repaymentAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, debitAccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, debitAccountIdTextField, debitAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, continueButton1);
		PageFunctionUtils.clearDataInWebElement(driver, accountOpeningDateTextField);
		PageFunctionUtils.clickOnElement(driver, accountOpeningDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, accountOpeningDateTextField, valueDate.substring(1));
		PageFunctionUtils.clearDataInWebElement(driver, applicationDateTextField);
		PageFunctionUtils.clickOnElement(driver, applicationDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, applicationDateTextField, valueDate.substring(1));
		PageFunctionUtils.clickOnElement(driver, continueButton2);
		PageFunctionUtils.clickOnElement(driver, continueButton3);
		try {
			PageFunctionUtils.enterDataInWebElement(driver, peggingFrequencyTextField, peggingFrequencyValue);
		}
		catch(Exception e) {
		}
		PageFunctionUtils.clickOnElement(driver, renewalAndClosureDetailsTab);
		return this;
	}
	
	@Step("Press submit button")
	public ABEOpenTUAPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(87);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABEOpenTUAPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.OpenTUACsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.OpenTUACsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyTUAOpeningCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyTUAOpeningCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.OpenTUACsv, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.VerifyTUAOpeningCsv, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}										
}