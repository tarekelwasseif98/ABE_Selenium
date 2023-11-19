package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABEOpenRetailLoanRetailLoansPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By cifTextField = By.xpath("(//input[@id='_cifid'])[1]");
	private By schemeCodeTextField = By.xpath("(//input[@id='_schmCode'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By BasicDetailsContinueButton = By.xpath("(//button[@id='_btn_continueBasic'])[1]");
	private By loanDetailsContinueButton = By.xpath("(//button[@id='_btn_continueLoandet'])[1]");
	private By relatedPartyDetailsContinueButton = By.xpath("(//button[@id='_btn_continueRelP'])[1]");
	private By interestDetailsContinueButton = By.xpath("(//button[@id='_btn_continueint'])[1]");
	private By feeDetailsContinueButton = By.xpath("(//button[@id='_btn_continueFee'])[1]");
	private By repaymentScheduleContinueButton = By.xpath("(//button[@id='_btn_continueRepaySchdet'])[1]");
	private By repaymentRepaymentParameterContinueButton = By.xpath("(//button[@id='_btn_continueRepayParm'])[1]"); 
	private By accountStatmentDropDown = By.xpath("(//select[@id='_pbPsFlg$acctStmt_select'])[1]");
	private String type = "None";
	private String calenderType ="Gregorian Calendar"; 
	private String Holiday ="Next Day"; 
	private By loanPeriodTextField = By.xpath("(//input[@id='_loan_period$duration1'])[1]");
	private By loanAmmountTextField = By.xpath("(//input[@id='_loan_amt$amt'])[1]");
	private By numberOfInstallmentsTextField = By.xpath("(//input[@id='_noOfInstlmnts'])[1]");
	private By installmentFrequencyDropDown = By.xpath("(//select[@id='_einsFreq$frequency_select'])[1]");
	private By installmentFrequencyRadioButon = By.xpath("(//input[@id='_einsFreq_RB2_radio'])[1]");
	private By installmentDateDropDown = By.xpath("(//select[@id='_einsFreq$freqDate_select'])[1]");
	private By installmentCalenderDropDown = By.xpath("(//select[@id='_einsFreq$freqCalendar_select'])[1]");
	private By installmentOnHolidayDropDown = By.xpath("(//select[@id='_einsFreq$freqHoliday_select'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By operativeAccountTextField = By.xpath("(//input[@id='_operacct'])[1]");
	private By compoundingIndicatiorRadioButton = By.xpath("(//input[@id='_compRestInd_A_radio'])[1]");
	private By accountIdSuccessMessage = By.id("_resMsg_paraMsg");
	private By accountIdReference = By.id("_resacctId_text");
	public static String acId;
	public static String successMessage;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcId";
	private By interestParameterDetailsSection = By.xpath("(//span[@id='_sc_intParamDet_button_title'])[1]");

	
	
	public ABEOpenRetailLoanRetailLoansPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEOpenRetailLoanRetailLoansPage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeID);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
	        PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
	        } catch (Exception e) {
	        }
	        return this;        
	}
	
	@Step("Frame switching")
	public ABEOpenRetailLoanRetailLoansPage switchFormAreaFrame() throws Exception {
		
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending Cif: {0}")
	public ABEOpenRetailLoanRetailLoansPage sendKeysCif(String cif) throws Exception {

		PageFunctionUtils.waitOnElement(driver, cifTextField);
		PageFunctionUtils.clickOnElement(driver,cifTextField);
		PageFunctionUtils.enterDataInWebElement(driver,cifTextField,cif);
		return this;
	}
	
	@Step("Sending scheme code: {0}")
	public ABEOpenRetailLoanRetailLoansPage sendKeysSchemeCode(String schemeCode) throws Exception {
		PageFunctionUtils.clickOnElement(driver,schemeCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver,schemeCodeTextField,schemeCode);
		return this;
	}
	@Step("Press go button")
	public ABEOpenRetailLoanRetailLoansPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver,goButton);		
		return this;
	}
	
	@Step("sending account statment:")
	public ABEOpenRetailLoanRetailLoansPage sendKeysAccountStatment() throws Exception {		
		
		PageFunctionUtils.waitOnElement(driver, accountStatmentDropDown);
		PageFunctionUtils.clickOnElement(driver,accountStatmentDropDown);
		Select accountStatmentsDropDown = new Select(driver.findElement(accountStatmentDropDown));
		accountStatmentsDropDown.selectByVisibleText(type);
		return this;
	}
	
	@Step("Pressing continue button:")
	public ABEOpenRetailLoanRetailLoansPage PressContinueButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,BasicDetailsContinueButton);
		
		return this;
	}
	
	@Step("Sending loan amount: {0}")
	public ABEOpenRetailLoanRetailLoansPage sendKeysLoanAmmountTextField(String loanAmmount) throws Exception {

		PageFunctionUtils.waitOnElement(driver, loanAmmountTextField);
		PageFunctionUtils.clickOnElement(driver,loanAmmountTextField);
		PageFunctionUtils.clearDataInWebElement(driver, loanAmmountTextField);
		PageFunctionUtils.enterDataInWebElement(driver,loanAmmountTextField,loanAmmount);
		
		return this;
	}
	@Step("Sending loan period: {0}")
	public ABEOpenRetailLoanRetailLoansPage sendKeysLoanPeriodTextField(String loanPeriod) throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,loanPeriodTextField);
		PageFunctionUtils.clearDataInWebElement(driver, loanPeriodTextField);
		PageFunctionUtils.enterDataInWebElement(driver,loanPeriodTextField,loanPeriod);
		
		return this;
	}
	
	@Step("Pressing continue")
	public ABEOpenRetailLoanRetailLoansPage PressContinue() throws Exception {
	
		PageFunctionUtils.clickOnElement(driver,loanDetailsContinueButton);	
		PageFunctionUtils.clickOnElement(driver,relatedPartyDetailsContinueButton);
		PageFunctionUtils.clickOnElement(driver,interestParameterDetailsSection);
		try {
		PageFunctionUtils.clickOnElement(driver,compoundingIndicatiorRadioButton);
		PageFunctionUtils.clickOnElement(driver,interestDetailsContinueButton);
		PageFunctionUtils.clickOnElement(driver,feeDetailsContinueButton);
		}catch (Exception e) {
			PageFunctionUtils.clickOnElement(driver,interestDetailsContinueButton);
			PageFunctionUtils.clickOnElement(driver,feeDetailsContinueButton);		
			}
		return this;
	}
	

	@Step("Sending Number of installments: {0}")
	public ABEOpenRetailLoanRetailLoansPage sendKeysNumberOfInstallmentsTextField(String numberOfInstallments) throws Exception {

		PageFunctionUtils.waitOnElement(driver, numberOfInstallmentsTextField);
		PageFunctionUtils.clickOnElement(driver,numberOfInstallmentsTextField);
		PageFunctionUtils.clearDataInWebElement(driver, numberOfInstallmentsTextField);
		PageFunctionUtils.enterDataInWebElement(driver,numberOfInstallmentsTextField,numberOfInstallments);
		return this;
	}
	
	@Step("Sending installment Frequency : {0}")
	public ABEOpenRetailLoanRetailLoansPage sendKeysInstallmentFrequencyDropDown(String installmentsFrequency) throws Exception {

		PageFunctionUtils.clickOnElement(driver,installmentFrequencyDropDown);
		Select installmentsFrequencyDropDown = new Select(driver.findElement(installmentFrequencyDropDown));
		installmentsFrequencyDropDown.selectByVisibleText(installmentsFrequency);
		PageFunctionUtils.clickOnElement(driver,installmentFrequencyRadioButon);
		
		return this;
	}
	
	@Step("Sending installment Date: {0}")
	public ABEOpenRetailLoanRetailLoansPage sendKeysinstallmentDateDropDown(String Date) throws Exception {

	    PageFunctionUtils.clickOnElement(driver,installmentDateDropDown);
		Select installmentsDateDropDown = new Select(driver.findElement(installmentDateDropDown));
		installmentsDateDropDown.selectByVisibleText(Date);
			return this;
	}
	@Step("Sending calendar type:")
	public ABEOpenRetailLoanRetailLoansPage sendKeysCalenderType() throws Exception {

		PageFunctionUtils.clickOnElement(driver,installmentCalenderDropDown);
		Select installmentsCalenderDropDown = new Select(driver.findElement(installmentCalenderDropDown));
		installmentsCalenderDropDown.selectByVisibleText(calenderType);
		PageFunctionUtils.clickOnElement(driver,installmentOnHolidayDropDown);
		Select installmentsOnHolidayDropDown = new Select(driver.findElement(installmentOnHolidayDropDown));
		installmentsOnHolidayDropDown.selectByVisibleText(Holiday);
	
		
		return this;
	}
	@Step("press Repayment Continue button: ")
	public ABEOpenRetailLoanRetailLoansPage pressRepaymentParameterContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, repaymentRepaymentParameterContinueButton);
		
		return this;
	}
	@Step("Sending operative account")
	public ABEOpenRetailLoanRetailLoansPage SendKeysOperativeAccount(String operativeAccount) throws Exception {
		PageFunctionUtils.clickOnElement(driver,repaymentScheduleContinueButton);	
		PageFunctionUtils.clickOnElement(driver,operativeAccountTextField);	
		PageFunctionUtils.enterDataInWebElement(driver, operativeAccountTextField, operativeAccount.substring(1));		
		return this;
	}
	
	@Step("Pressing Submit")
	public ABEOpenRetailLoanRetailLoansPage PressSubmit() throws Exception {
		try {
			PageFunctionUtils.waitOnElement(driver, submitButton);
			PageFunctionUtils.clickOnElement(driver,submitButton);	
			acId = driver.findElement(accountIdReference).getText().substring(0,20);
			successMessage = driver.findElement(accountIdSuccessMessage).getText();		
			System.out.println("ACID: "+ accountIdReference + " "+acId);
		} catch (Exception e) {
			PageFunctionUtils.clickOnElement(driver,submitButton);	
			acId = driver.findElement(accountIdReference).getText().substring(0,20);
			successMessage = driver.findElement(accountIdSuccessMessage).getText();		
			System.out.println("ACID: "+ accountIdReference + " "+acId);
		}
		return this;

	}
	
	@Step("Save a/c. id")
	public ABEOpenRetailLoanRetailLoansPage saveAccountId(String linkedId, String linkedId2,String linkedId3) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABEOPENRETAILLOANRETAILLOANSCSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABEOPENRETAILLOANRETAILLOANSCSV, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYRETAILLOANRETAILLOANSCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYRETAILLOANRETAILLOANSCSV, accountIdCsvColumnName);
		int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABEDISBURSERETAILLOANRETAILLOANSCSV, tcIdCsvColumnName, linkedId2);
		int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEDISBURSERETAILLOANRETAILLOANSCSV, accountIdCsvColumnName);
		int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSCSV, tcIdCsvColumnName, linkedId3);
		int columnByColumnName4 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSCSV, accountIdCsvColumnName);
		
		if(rowByTcid1 != -1 && rowByTcid2 != -1 && rowByTcid3 != -1 && rowByTcid4 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABEOPENRETAILLOANRETAILLOANSCSV, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYRETAILLOANRETAILLOANSCSV, rowByTcid2, columnByColumnName2, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEDISBURSERETAILLOANRETAILLOANSCSV, rowByTcid3, columnByColumnName3, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSCSV, rowByTcid4, columnByColumnName4, acId);

		}
		return this;
		
	}
}
