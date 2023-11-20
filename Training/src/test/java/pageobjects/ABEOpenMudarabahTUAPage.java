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

public class ABEOpenMudarabahTUAPage {
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
	private By continue1Button = By.xpath("(//button[@id='_bdtlCtnBtn'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_gnDtlCtnBtn'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_shmCont'])[1]");
	private By renewalAndClosureDetailsTab = By.xpath("(//a[@id='stepVIII_anchor'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Open Islamic Top Up Deposit Account'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	public static String accountId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	public static String  closeLinkedTcidCsvColumnName = "closeLinkedTcid";
	
	public ABEOpenMudarabahTUAPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEOpenMudarabahTUAPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEOpenMudarabahTUAPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending cif id: {0}")
	public ABEOpenMudarabahTUAPage sendKeysCifIdTextField(String cifId) throws Exception {
		if(cifId != null) {
			PageFunctionUtils.waitOnElement(driver, cifIdTextField);
			PageFunctionUtils.clickOnElement(driver, cifIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifId.substring(1));
		}
		return this;
	}
	
	@Step("Sending scheme code: {0}")
	public ABEOpenMudarabahTUAPage sendKeysSchemeCodeTextField(String schemeCode) throws Exception {
		if(schemeCode != null) {
			PageFunctionUtils.clickOnElement(driver, schemeCodeTextField);
			PageFunctionUtils.enterDataInWebElement(driver, schemeCodeTextField, schemeCode);
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEOpenMudarabahTUAPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Sending value date: {0}")
	public ABEOpenMudarabahTUAPage sendKeysValueDateTextField(String valueDate) throws Exception {
		if(valueDate != null) {
			PageFunctionUtils.waitOnElement(driver, valueDateTextField);
			PageFunctionUtils.clearDataInWebElement(driver, valueDateTextField);
			PageFunctionUtils.clickOnElement(driver, valueDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, valueDateTextField, valueDate.substring(1));
		}
		return this;
	}
	
	@Step("Sending deposit period months: {0}")
	public ABEOpenMudarabahTUAPage sendKeysDepositPeriodMonthsTextField(String depositPeriodMonths) throws Exception {
		if(depositPeriodMonths != null) {
			PageFunctionUtils.clearDataInWebElement(driver, depositPeriodMonthsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, depositPeriodMonthsTextField, depositPeriodMonths);
		}
		return this;
	}
	
	@Step("Sending deposit period days: {0}")
	public ABEOpenMudarabahTUAPage sendKeysDepositPeriodDaysTextField(String depositPeriodDays) throws Exception {
		if(depositPeriodDays != null) {
			PageFunctionUtils.clearDataInWebElement(driver, depositPeriodDaysTextField);
			PageFunctionUtils.enterDataInWebElement(driver, depositPeriodDaysTextField, depositPeriodDays);
		}
		return this;
	}
	
	@Step("Sending initial deposit amount: {0}")
	public ABEOpenMudarabahTUAPage sendKeysInitialDepositAmountTextField(String initialDepositAmount) throws Exception {
		if(initialDepositAmount != null) {
			PageFunctionUtils.clearDataInWebElement(driver, initialDepositAmountTextField);
			PageFunctionUtils.enterDataInWebElement(driver, initialDepositAmountTextField, initialDepositAmount);
		}
		return this;
	}
	
	@Step("Sending profit credit account id: {0}")
	public ABEOpenMudarabahTUAPage sendKeysProfitCreditAccountIdTextField(String profitCreditAccountId) throws Exception {
		if(profitCreditAccountId != null) {
			PageFunctionUtils.clickOnElement(driver, profitCreditAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, profitCreditAccountIdTextField, profitCreditAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Sending repayment account id: {0}")
	public ABEOpenMudarabahTUAPage sendKeysRepaymentAccountIdTextField(String repaymentAccountId) throws Exception {
		if(repaymentAccountId != null) {
			PageFunctionUtils.clickOnElement(driver, repaymentAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, repaymentAccountIdTextField, repaymentAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Sending debit account id: {0}")
	public ABEOpenMudarabahTUAPage sendKeysDebitAccountIdTextField(String debitAccountId) throws Exception {
		if(debitAccountId != null) {
			PageFunctionUtils.clickOnElement(driver, debitAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, debitAccountIdTextField, debitAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMudarabahTUAPage pressContinue1Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Sending account opening date: {0}")
	public ABEOpenMudarabahTUAPage sendKeysAccountOpeningDateTextField(String accountOpeningDate) throws Exception {
		if(accountOpeningDate != null) {
			PageFunctionUtils.waitOnElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.clearDataInWebElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.clickOnElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, accountOpeningDateTextField, accountOpeningDate.substring(1));
		}
		return this;
	}
	
	@Step("Sending application date: {0}")
	public ABEOpenMudarabahTUAPage sendKeysApplicationDateTextField(String applicationDate) throws Exception {
		if(applicationDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, applicationDateTextField);
			PageFunctionUtils.clickOnElement(driver, applicationDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, applicationDateTextField, applicationDate.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMudarabahTUAPage pressContinue2Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMudarabahTUAPage pressContinue3Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Renewal and closure details tab navigation")
	public ABEOpenMudarabahTUAPage navigateRenewalAndClosureDetailsTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, renewalAndClosureDetailsTab);
		PageFunctionUtils.clickOnElement(driver, renewalAndClosureDetailsTab);
		return this;
	}
	
	@Step("Press submit button")
	public ABEOpenMudarabahTUAPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		accountId = driver.findElement(accountIdSuccessMessage).getText().substring(87);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
	
	@Step("Save account id")
	public ABEOpenMudarabahTUAPage saveAccountId(String linkedId, String closeLinkedTcid) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABEOPENMUDARABAHTUACSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABEOPENMUDARABAHTUACSV, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYMUDARABAHTUAOPENINGCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYMUDARABAHTUAOPENINGCSV, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABEOPENMUDARABAHTUACSV, rowByTcid1, columnByColumnName1, accountId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYMUDARABAHTUAOPENINGCSV, rowByTcid2, columnByColumnName2, accountId);
		}
		int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABEOPENMUDARABAHTUACSV, closeLinkedTcidCsvColumnName, closeLinkedTcid);
		int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABECLOSEMUDARABAHTUACSV, tcIdCsvColumnName, closeLinkedTcid);
		int columnByColumnName4 = CSVUtils.getColumnByColumnName(Paths.ABECLOSEMUDARABAHTUACSV, accountIdCsvColumnName);
		if(rowByTcid3 != -1 && rowByTcid4 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABECLOSEMUDARABAHTUACSV, rowByTcid4, columnByColumnName4, accountId);
		}
		return this;
	}							
}