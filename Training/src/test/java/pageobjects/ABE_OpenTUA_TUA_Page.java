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

public class ABE_OpenTUA_TUA_Page {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By cifIdTextField = By.xpath("(//input[@id='_critcifId'])[1]");
	private By schemeCodeTextField = By.xpath("(//input[@id='_schmCode'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By depositPeriodMonthsTextField = By.xpath("(//input[@id='_depPeriod$duration1'])[1]");
	private By depositPeriodDaysTextField = By.xpath("(//input[@id='_depPeriod$duration2'])[1]");
	private By initialDepositAmountTextField = By.xpath("(//input[@id='_iniDepAmt$amt'])[1]");
	private By profitCreditAccountIdTextField = By.xpath("(//input[@id='_intCrAcId'])[1]");
	private By repaymentAccountIdTextField = By.xpath("(//input[@id='_repActId'])[1]");
	private By debitAccountIdTextField = By.xpath("(//input[@id='_trnActId'])[1]");
	private By peggingFrequencyTextField = By.xpath("(//input[@id='_pegFrenew$duration1'])[1]");
	private By continueButton1 = By.xpath("(//button[@id='_bdtlCtnBtn'])[1]");
	private By continueButton2 = By.xpath("(//button[@id='_gnDtlCtnBtn'])[1]");
	private By continueButton3 = By.xpath("(//button[@id='_shmCont'])[1]");
	private By renewalAndClosureDetailsTab = By.xpath("(//a[@id='stepVIII_anchor'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By warningAcceptButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	private String peggingFrequencyValue = "1";
	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public ABE_OpenTUA_TUA_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABE_OpenTUA_TUA_Page sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
		driver.switchTo().frame((loginFrameIframeId));
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
	public ABE_OpenTUA_TUA_Page switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame((loginFrameIframeId));
	    driver.switchTo().frame((coreAbeIframeId));
	    driver.switchTo().frame((uxIframeId));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;		
	}
	
	@Step("Sending customer details: {0}")
	public ABE_OpenTUA_TUA_Page sendKeysAccountDetails(String cifid, String schemeCode) throws Exception {
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		driver.findElement(cifIdTextField).click();
		driver.findElement(cifIdTextField).sendKeys(cifid);
		driver.findElement(schemeCodeTextField).click();
		driver.findElement(schemeCodeTextField).sendKeys(schemeCode);
		driver.findElement(goButton).click();
		return this;
	}
	
	@Step("Sending tua details: {0}")
	public ABE_OpenTUA_TUA_Page sendKeysTUADetails(String depositPeriodMonths, String depositPeriodDays, String initialDepositAmount, String profitCreditAccountId, String repaymentAccountId, String debitAccountId) throws Exception {
		
		driver.findElement(depositPeriodMonthsTextField).clear();
		driver.findElement(depositPeriodMonthsTextField).sendKeys(depositPeriodMonths);
		driver.findElement(depositPeriodDaysTextField).clear();
		driver.findElement(depositPeriodDaysTextField).sendKeys(depositPeriodDays);
		driver.findElement(initialDepositAmountTextField).clear();
		driver.findElement(initialDepositAmountTextField).sendKeys(initialDepositAmount);
		driver.findElement(profitCreditAccountIdTextField).click();
		driver.findElement(profitCreditAccountIdTextField).sendKeys(profitCreditAccountId.substring(1));
		driver.findElement(repaymentAccountIdTextField).click();
		driver.findElement(repaymentAccountIdTextField).sendKeys(repaymentAccountId.substring(1));
		driver.findElement(debitAccountIdTextField).click();
		driver.findElement(debitAccountIdTextField).sendKeys(debitAccountId.substring(1));
		driver.findElement(continueButton1).click();
		driver.findElement(continueButton2).click();
		driver.findElement(continueButton3).click();
		try {
			driver.findElement(peggingFrequencyTextField).sendKeys(peggingFrequencyValue);
		}
		catch(Exception e) {
		}
		driver.findElement(renewalAndClosureDetailsTab).click();
		return this;
	}
	
	@Step("Press submit button")
	public ABE_OpenTUA_TUA_Page pressSubmitButton() throws Exception {
		driver.findElement(submitButton).click();
		driver.switchTo().parentFrame();
		Boolean isPresent = driver.findElements(warningAcceptButton).size() > 0;
		if(isPresent) {
			driver.findElement(warningAcceptButton).click();
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		}
		else {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
			acId = driver.findElement(accountIdSuccessMessage).getText().substring(87);
		}
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(87);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABE_OpenTUA_TUA_Page saveAccountId(String linkedId) throws Exception {
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