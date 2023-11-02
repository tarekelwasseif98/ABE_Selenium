package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.FinacleFieldsUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABEOpenCorporateLoanCorporateLoansPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId = By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By cifIdTextField = By.xpath("(//input[@id='_cifid'])[1]");
	private By schemeCodeTextField = By.xpath("(//input[@id='_schmCode'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By accountOpeningDateTextField = By.xpath("(//input[@id='_acctOpenDate'])[1]");
	private By accountStatementDropDownList = By.xpath("(//select[@id='_pbPsFlg$acctStmt_select'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_btn_continueBasic'])[1]");
	private By loanAmountTextField = By.xpath("(//input[@id='_loan_amt$amt'])[1]");
	private By loanPeriodMonthsTextField = By.xpath("(//input[@id='_loan_period$duration1'])[1]");
	private By loanPeriodDaysTextField = By.xpath("(//input[@id='_loan_period$duration2'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_btn_continueLoandet'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_btn_continueRelP'])[1]");
	private By interestParameterDetailsMenu = By.xpath("(//span[@id='_sc_intParamDet_button_title'])[1]");
	private By interestCompoundingFrequencyDropDownList = By.xpath("(//select[@id='_dcompIntFlg_select'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_btn_continueint'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_btn_continueFee'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_btn_continueRepayParm'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_btn_continueRepaySchdet'])[1]");
	private By operativeAccountIdTextField = By.xpath("(//input[@id='_operacct'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_btn_continueRepIns'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_btn_continuedisb'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_btn_continueloanaddnl'])[1]");
	private By continue11Button = By.xpath("(//button[@id='_btn_continueDoc'])[1]");
	private By continue12Button = By.xpath("(//button[@id='_btn_continueMisc'])[1]");
	private By expiryDateTextField = By.xpath("(//input[@id='_expiryDate'])[1]");
	private By documentDateTextField = By.xpath("(//input[@id='_documentDate'])[1]");
	private By limitIdPrefixTextField = By.xpath("(//input[@id='_limitId$prefix'])[1]");
	private By limitIdSuffixTextField = By.xpath("(//input[@id='_limitId$suffix'])[1]");
	private By closeButton = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By drawingPowerIndicatorDropDownList = By.xpath("(//select[@id='_drawingPowerInd_select'])[1]");
	private By continue13Button = By.xpath("(//button[@id='_btn_continueacctlmts'])[1]");
	private By continue14Button = By.xpath("(//button[@id='_btn_continueIntNot'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By equatedInstallmentYesRadioButton = By.xpath("(//input[@id='_eiSchmFlg_Y_radio'])[1]");
	private By equatedInstallmentNoRadioButton = By.xpath("(//input[@id='_eiSchmFlg_N_radio'])[1]");
	private By numberOfInstallmentsTextField = By.xpath("(//input[@id='_noOfInstlmnts'])[1]");
	private By installmentStartDateTextField = By.xpath("(//input[@id='_instlmntStartDate'])[1]");
	private By installmentFrequencyDropDownList = By.xpath("(//select[@id='_einsFreq$frequency_select'])[1]");
	private By installmentFrequencyCalendarDropDownList = By.xpath("(//select[@id='_einsFreq$freqCalendar_select'])[1]");
	private By installmentFrequencyDateDropDownList = By.xpath("(//select[@id='_einsFreq$freqDate_select'])[1]");
	private By installmentFrequencyOnHolidayDropDownList = By.xpath("(//select[@id='_einsFreq$freqHoliday_select'])[1]");
	private By installmentFrequencyByDateRadioButton = By.xpath("(//input[@id='_einsFreq_RB2_radio'])[1]");
	private By interestFrequencyCalendarDropDownList = By.xpath("(//select[@id='_intFreq$freqCalendar_select'])[1]");
	private By interestFrequencyDateDropDownList = By.xpath("(//select[@id='_intFreq$freqDate_select'])[1]");
	private By interestFrequencyOnHolidayDropDownList = By.xpath("(//select[@id='_intFreq$freqHoliday_select'])[1]");
	private By interestFrequencyByDateRadioButton = By.xpath("(//input[@id='_intFreq_RB2_radio'])[1]");
	private By interestStartDateTextField = By.xpath("(//input[@id='_intStartDate'])[1]");
	private By interestFrequencyDropDownList = By.xpath("(//select[@id='_intFreq$frequency_select'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//div[@id='_resacctId_text'])[1]");
	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public ABEOpenCorporateLoanCorporateLoansPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysSearchBarTextField(String menu) throws Exception {
		if(menu != null) {
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
		        } catch (Exception e) {
	        }
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEOpenCorporateLoanCorporateLoansPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending cif id: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysCifIdTextField(String cifId) throws Exception {
		if(cifId != null) {
			PageFunctionUtils.waitOnElement(driver, cifIdTextField);
			PageFunctionUtils.clickOnElement(driver, cifIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifId);
		}
		return this;
	}
	
	@Step("Sending scheme code: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysSchemeCodeTextField(String schemeCode) throws Exception {
		if(schemeCode != null) {
			PageFunctionUtils.clickOnElement(driver, schemeCodeTextField);
			PageFunctionUtils.enterDataInWebElement(driver, schemeCodeTextField, schemeCode);
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEOpenCorporateLoanCorporateLoansPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Sending account opening date: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysAccountOpeningDateTextField(String accountOpeningDate) throws Exception {
		if(accountOpeningDate != null) {
			PageFunctionUtils.waitOnElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.clearDataInWebElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.clickOnElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, accountOpeningDateTextField, accountOpeningDate.substring(1));
		}
		return this;
	}
	
	@Step("Select account statement")
	public ABEOpenCorporateLoanCorporateLoansPage selectAccountStatement() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, accountStatementDropDownList, FinacleFieldsUtils.ACCOUNTSTATEMENTNONE);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue1Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Sending loan amount: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysLoanAmountTextField(String loanAmount) throws Exception {
		if(loanAmount != null) {
			PageFunctionUtils.waitOnElement(driver, loanAmountTextField);
			PageFunctionUtils.clickOnElement(driver, loanAmountTextField);
			PageFunctionUtils.clearDataInWebElement(driver, loanAmountTextField);
			PageFunctionUtils.enterDataInWebElement(driver, loanAmountTextField, loanAmount);
		}
		return this;
	}
	
	@Step("Sending loan period months: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysLoanPeriodMonthsTextField(String loanPeriodMonths) throws Exception {
		if(loanPeriodMonths != null) {
			PageFunctionUtils.clickOnElement(driver, loanPeriodMonthsTextField);
			PageFunctionUtils.clearDataInWebElement(driver, loanPeriodMonthsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, loanPeriodMonthsTextField, loanPeriodMonths);
		}
		return this;
	}
	
	@Step("Sending loan period days: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysLoanPeriodDaysTextField(String loanPeriodDays) throws Exception {
		if(loanPeriodDays != null) {
			PageFunctionUtils.clickOnElement(driver, loanPeriodDaysTextField);
			PageFunctionUtils.clearDataInWebElement(driver, loanPeriodDaysTextField);
			PageFunctionUtils.enterDataInWebElement(driver, loanPeriodDaysTextField, loanPeriodDays);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue2Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue3Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Select interest compounding frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestCompoundingFrequency() throws Exception {
		PageFunctionUtils.clickOnElement(driver, interestParameterDetailsMenu);
		PageFunctionUtils.waitOnElement(driver, interestCompoundingFrequencyDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestCompoundingFrequencyDropDownList, FinacleFieldsUtils.INTERESTCOMPOUNDINGFREQUENCYNOCOMPOUNDING);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue4Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue5Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Select equated installment")
	public ABEOpenCorporateLoanCorporateLoansPage selectEquatedInstallmentYes() throws Exception {
		PageFunctionUtils.clickOnElement(driver, equatedInstallmentYesRadioButton);
		return this;
	}
	
	@Step("Select equated installment")
	public ABEOpenCorporateLoanCorporateLoansPage selectEquatedInstallmentNo() throws Exception {
		PageFunctionUtils.clickOnElement(driver, equatedInstallmentNoRadioButton);
		return this;
	}
	
	@Step("Sending number of installments: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysNumberOfInstallmentsTextField(String numberOfInstallments) throws Exception {
		if(numberOfInstallments != null) {
			PageFunctionUtils.waitOnElement(driver, numberOfInstallmentsTextField);
			PageFunctionUtils.clickOnElement(driver, numberOfInstallmentsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, numberOfInstallmentsTextField, numberOfInstallments);
		}
		return this;
	}
	
	@Step("Sending installment start date: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysInstallmentStartDateTextField(String installmentStartDate) throws Exception {
		if(installmentStartDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, installmentStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, installmentStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, installmentStartDateTextField, installmentStartDate.substring(1));
		}
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyDaily() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYDAILY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyWeekly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYWEEKLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyFortnightly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYFORTNIGHTLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyBullet() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYBULLET);
		return this;
	}
	
	
	@Step("Select installment frequency calendar")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyCalendar() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyCalendarDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
		return this;
	}
	
	@Step("Select installment frequency on holiday")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyOnHoliday() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyOnHolidayDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyMonthly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYMONTHLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyQuarterly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYQUARTERLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyHalfYearly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYHALFYEARLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyYearly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYYEARLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyTwiceAMonth() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYTWICEAMONTH);
		return this;
	}
	
	@Step("Select installment frequency date: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage selectInstallmentFrequencyDate(String date) throws Exception {
		if(date != null) {
			PageFunctionUtils.clickOnElement(driver, installmentFrequencyByDateRadioButton);
			for(int i=0; i<FinacleFieldsUtils.DATEVALUES.length; i++) {
				if(Integer.parseInt(date) == FinacleFieldsUtils.DATEVALUES[i]) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDateDropDownList, date);
				}
			}
		}
		return this;
	}
	
	@Step("Sending interest start date: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysInterestStartDateTextField(String interestStartDate) throws Exception {
		if(interestStartDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, interestStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, interestStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, interestStartDateTextField, interestStartDate.substring(1));
		}
		return this;
	}
	
	@Step("Select interest frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyDaily() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYDAILY);
		return this;
	}
	
	@Step("Select interest frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyWeekly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYWEEKLY);
		return this;
	}
	
	@Step("Select interest frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyFortnightly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYFORTNIGHTLY);
		return this;
	}
	
	@Step("Select interest frequency calendar")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyCalendar() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyCalendarDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
		return this;
	}
	
	@Step("Select interest frequency on holiday")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyOnHoliday() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyOnHolidayDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
		return this;
	}
	
	@Step("Select interest frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyMonthly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYMONTHLY);
		return this;
	}
	
	@Step("Select interest frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyQuarterly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYQUARTERLY);
		return this;
	}
	
	@Step("Select interest frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyHalfYearly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYHALFYEARLY);
		return this;
	}
	
	@Step("Select interest frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyYearly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYYEARLY);
		return this;
	}
	
	@Step("Select interest frequency")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyTwiceAMonth() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYTWICEAMONTH);
		return this;
	}
	
	@Step("Select interest frequency date: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage selectInterestFrequencyDate(String date) throws Exception {
		if(date != null) {
			PageFunctionUtils.clickOnElement(driver, interestFrequencyByDateRadioButton);
			for(int i=0; i<FinacleFieldsUtils.DATEVALUES.length; i++) {
				if(Integer.parseInt(date) == FinacleFieldsUtils.DATEVALUES[i]) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDateDropDownList, date);
				}
			}
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue6Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue7Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		return this;
	}
	
	@Step("Sending operative account id: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysOperativeAccountIdTextField(String operativeAccountId) throws Exception {
		if(operativeAccountId != null) {
			PageFunctionUtils.waitOnElement(driver, operativeAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, operativeAccountIdTextField, operativeAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue8Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue9Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue10Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue11Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue11Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue12Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue12Button);
		return this;
	}
	
	@Step("Sending expiry date: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysExpiryDateTextField(String expiryDate) throws Exception {
		if(expiryDate != null) {
			PageFunctionUtils.waitOnElement(driver, expiryDateTextField);
			PageFunctionUtils.clearDataInWebElement(driver, expiryDateTextField);
			PageFunctionUtils.clickOnElement(driver, expiryDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, expiryDateTextField, expiryDate.substring(1));
		}	
		return this;
	}
	
	@Step("Sending document date: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysDocumentDateTextField(String documentDate) throws Exception {
		if(documentDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, documentDateTextField);
			PageFunctionUtils.clickOnElement(driver, documentDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, documentDateTextField, documentDate.substring(1));
		}	
		return this;
	}
	
	@Step("Sending limit id: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysLimitIdTextField(String limitIdPrefix, String limitIdSuffix) throws Exception {
		if(limitIdPrefix != null && limitIdSuffix != null) {
			PageFunctionUtils.enterDataInWebElement(driver, limitIdPrefixTextField, limitIdPrefix.substring(1));
			PageFunctionUtils.enterDataInWebElement(driver, limitIdSuffixTextField, limitIdSuffix.substring(1));
		}
		return this;
	}
	
	@Step("Select drawing power indicator")
	public ABEOpenCorporateLoanCorporateLoansPage selectDrawingPowerIndicatorDerived() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DRAWINGPOWERINDICATORDERIVED);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
	}
		return this;
	}
	
	@Step("Select drawing power indicator")
	public ABEOpenCorporateLoanCorporateLoansPage selectDrawingPowerIndicatorEqual() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DRAWINGPOWERINDICATOREQUAL);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
	}
		return this;
	}
	
	@Step("Select drawing power indicator")
	public ABEOpenCorporateLoanCorporateLoansPage selectDrawingPowerIndicatorMaintained() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DRAWINGPOWERINDICATORMAINTAINED);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
	}
		return this;
	}
	
	@Step("Select drawing power indicator")
	public ABEOpenCorporateLoanCorporateLoansPage selectDrawingPowerIndicatorParent() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DRAWINGPOWERINDICATORPARENT);
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
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue13Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue13Button);	
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCorporateLoanCorporateLoansPage pressContinue14Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue14Button);	
		return this;
	}
	
	@Step("Press submit button")
	public ABEOpenCorporateLoanCorporateLoansPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(0,20);
		return this;
	}
	
	@Step("Save account id")
	public ABEOpenCorporateLoanCorporateLoansPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.OpenCorporateLoanCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.OpenCorporateLoanCsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyCorporateLoanCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyCorporateLoanCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.OpenCorporateLoanCsv, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.VerifyCorporateLoanCsv, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}								
}