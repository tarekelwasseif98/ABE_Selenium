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

public class ABEOpenMurabahaAccountMurabahaFinancingPage {
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
	private By assetValueTextField = By.xpath("(//input[@id='_assVal$amt'])[1]");
	private By customerMarginTextField = By.xpath("(//input[@id='_custMg$amt'])[1]");
	private By financePeriodMonthsTextField = By.xpath("(//input[@id='_loan_period$duration1'])[1]");
	private By financePeriodDaysTextField = By.xpath("(//input[@id='_loan_period$duration2'])[1]");
	private By debitAccountIdTextField = By.xpath("(//input[@id='_od_debitAcId'])[1]");
	private By equatedInstallmentYesRadioButton = By.xpath("(//input[@id='_eiSchmFlg_Y_radio'])[1]");
	private By equatedInstallmentNoRadioButton = By.xpath("(//input[@id='_eiSchmFlg_N_radio'])[1]");
	private By numberOfInstallmentsTextField = By.xpath("(//input[@id='_noOfInstlmnts'])[1]");
	private By installmentStartDateTextField = By.xpath("(//input[@id='_instlmntStartDate'])[1]");
	private By installmentFrequencyDropDownList = By.xpath("(//select[@id='_einsFreq$frequency_select'])[1]");
	private By profitStartDateTextField = By.xpath("(//input[@id='_intStartDate'])[1]");
	private By profitFrequencyDropDownList = By.xpath("(//select[@id='_intFreq$frequency_select'])[1]");
	private By byDateEquatedRadioButton = By.xpath("(//input[@id='_einsFreq_RB2_radio'])[1]");
	private By byDateNonEquatedRadioButton = By.xpath("(//input[@id='_intFreq_RB2_radio'])[1]");
	private By dateEquatedDropDownList = By.xpath("(//select[@id='_einsFreq$freqDate_select'])[1]");
	private By dateNonEquatedDropDownList = By.xpath("(//select[@id='_intFreq$freqDate_select'])[1]");
	private By repaymentTypeDropDownList = By.xpath(("(//select[@id='_repaymentType_select'])[1]"));
	private By calendarEquatedDropDownList = By.xpath("(//select[@id='_einsFreq$freqCalendar_select'])[1]");
	private By onHolidayEquatedDropDownList = By.xpath("(//select[@id='_einsFreq$freqHoliday_select'])[1]");
	private By calendarNonEquatedDropDownList = By.xpath("(//select[@id='_intFreq$freqCalendar_select'])[1]");
	private By onHolidayNonEquatedDropDownList = By.xpath("(//select[@id='_intFreq$freqHoliday_select'])[1]");
	private By operativeAccountIdTextField = By.xpath("(//input[@id='_operacct'])[1]");
	private By expiryDateTextField = By.xpath("(//input[@id='_expiryDate'])[1]");
	private By documentDateTextField = By.xpath("(//input[@id='_documentDate'])[1]");
	private By limitIdPrefixTextField = By.xpath("(//input[@id='_limitId$prefix'])[1]");
	private By limitIdSuffixTextField = By.xpath("(//input[@id='_limitId$suffix'])[1]");
	private By closeButton = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By drawingPowerIndicatorDropDownList = By.xpath("(//select[@id='_drawingPowerInd_select'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_btn_continueBasic'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_btn_continueLoandet'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_btn_continueFee'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_btn_continueint'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_btn_continueRelP'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_btn_continueRepayParm'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_btn_continueRepaySchdet'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_btn_continueRepIns'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_btn_continueacctlmts'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_btn_continueDoc'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Open Islamic Financing Account'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//div[@id='_resacctId_text'])[1]");
	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	public static String disburseTcidCsvColumnName = "disburseTcid";
	public static String  murabahaAccountIdCsvColumnName = "murabahaAccountId";
	
	public ABEOpenMurabahaAccountMurabahaFinancingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysSearchBarTextField(String menu) throws Exception {
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
		        } catch (Exception e) {
	        }
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEOpenMurabahaAccountMurabahaFinancingPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending cif id: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysCifIdTextField(String cifId) throws Exception {
		if(cifId != null) {
			PageFunctionUtils.waitOnElement(driver, cifIdTextField);
			PageFunctionUtils.clickOnElement(driver, cifIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifId.substring(1));
		}
		return this;
	}
	
	@Step("Sending scheme code: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysSchemeCodeTextField(String schemeCode) throws Exception {
		if(schemeCode != null) {
			PageFunctionUtils.clickOnElement(driver, schemeCodeTextField);
			PageFunctionUtils.enterDataInWebElement(driver, schemeCodeTextField, schemeCode);
		}
		return this;
	}
	
	@Step("Pres go button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressGoButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, goButton);
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Sending account opening date: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysAccountOpeningDateTextField(String accountOpeningDate) throws Exception {
		if(accountOpeningDate != null) {
			PageFunctionUtils.waitOnElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.clearDataInWebElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.clickOnElement(driver, accountOpeningDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, accountOpeningDateTextField, accountOpeningDate.substring(1));
		}
		return this;
	}
	
	@Step("Sending asset value: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysAssetValueTextField(String assetValue) throws Exception {
		if(assetValue != null) {
			PageFunctionUtils.waitOnElement(driver, assetValueTextField);
			PageFunctionUtils.clickOnElement(driver, assetValueTextField);
			PageFunctionUtils.clearDataInWebElement(driver, assetValueTextField);
			PageFunctionUtils.enterDataInWebElement(driver, assetValueTextField, assetValue);
		}
		return this;
	}
	
	@Step("Sending customer margin: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysCustomerMarginTextField(String customerMargin) throws Exception {
			if(customerMargin != null) {
				PageFunctionUtils.clickOnElement(driver, customerMarginTextField);
				PageFunctionUtils.clearDataInWebElement(driver, customerMarginTextField);
				PageFunctionUtils.enterDataInWebElement(driver, customerMarginTextField, customerMargin);
			}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue1Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Sending finance period months: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysFinancePeriodMonthsTextField(String financePeriodMonths) throws Exception {
		if(financePeriodMonths != null) {
			PageFunctionUtils.waitOnElement(driver, financePeriodMonthsTextField);
			PageFunctionUtils.clickOnElement(driver, financePeriodMonthsTextField);
			PageFunctionUtils.clearDataInWebElement(driver, financePeriodMonthsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, financePeriodMonthsTextField, financePeriodMonths);
		}
		return this;
	}
	
	@Step("Sending finance period days: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysFinancePeriodDaysTextField(String financePeriodDays) throws Exception {
		if(financePeriodDays != null) {
			PageFunctionUtils.clickOnElement(driver, financePeriodDaysTextField);
			PageFunctionUtils.clearDataInWebElement(driver, financePeriodDaysTextField);
			PageFunctionUtils.enterDataInWebElement(driver, financePeriodDaysTextField, financePeriodDays);
		}
		return this;
	}
	
	@Step("Sending debit account id: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysDebitAccountIdTextField(String debitAccountId) throws Exception {
		if(debitAccountId != null) {
			PageFunctionUtils.clickOnElement(driver, debitAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, debitAccountIdTextField, debitAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue2Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue3Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue4Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue5Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Select equated installment")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectEquatedInstallmentYes() throws Exception {
		PageFunctionUtils.waitOnElement(driver, equatedInstallmentYesRadioButton);
		PageFunctionUtils.clickOnElement(driver, equatedInstallmentYesRadioButton);
		return this;
	}
	
	@Step("Select equated installment")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectEquatedInstallmentNo() throws Exception {
		PageFunctionUtils.waitOnElement(driver, equatedInstallmentNoRadioButton);
		PageFunctionUtils.clickOnElement(driver, equatedInstallmentNoRadioButton);
		return this;
	}
	
	@Step("Sending number of installments: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysNumberOfInstallmentsTextField(String numberOfInstallments) throws Exception {
		if(numberOfInstallments != null) {
			PageFunctionUtils.clickOnElement(driver, numberOfInstallmentsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, numberOfInstallmentsTextField, numberOfInstallments);
		}
		return this;
	}
	
	@Step("Sending installment start date: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysInstallmentStartDateTextField(String installmentStartDate) throws Exception {
		if(installmentStartDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, installmentStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, installmentStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, installmentStartDateTextField, installmentStartDate.substring(1));
		}
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyDaily() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYDAILY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyWeekly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYWEEKLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyFortnightly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYFORTNIGHTLY);
		return this;
	}
	
	@Step("Select calendar")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectEquatedCalendar() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarEquatedDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
		return this;
	}
	
	@Step("Select on holiday")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectEquatedOnHoliday() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyMonthly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYMONTHLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyQuarterly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYQUARTERLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyHalfYearly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYHALFYEARLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyYearly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYYEARLY);
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyTwiceAMonth() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYTWICEAMONTH);
		return this;
	}
	
	@Step("Select installment frequency date: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectEquatedDate(String date) throws Exception {
		if(date != null) {
			PageFunctionUtils.clickOnElement(driver, byDateEquatedRadioButton);
			for(int i=0; i<FinacleFieldsUtils.DATEVALUES.length; i++) {
				if(Integer.parseInt(date) == FinacleFieldsUtils.DATEVALUES[i]) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, dateEquatedDropDownList, date);
				}
			}
		}
		return this;
	}
	
	@Step("Select installment frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectInstallmentFrequencyBullet() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, repaymentTypeDropDownList, FinacleFieldsUtils.FREQUENCYBULLET);
		return this;
	}
	
	@Step("Sending profit start date: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysProfitStartDateTextField(String profitStartDate) throws Exception {
		if(profitStartDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, profitStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, profitStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, profitStartDateTextField, profitStartDate.substring(1));
		}
		return this;
	}
	
	@Step("Select profit frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectProfitFrequencyDaily() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYDAILY);
		return this;
	}
	
	@Step("Select profit frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectProfitFrequencyWeekly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYWEEKLY);
		return this;
	}
	
	@Step("Select profit frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectProfitFrequencyFortnightly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYFORTNIGHTLY);
		return this;
	}
	
	@Step("Select calendar")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectNonEquatedCalendar() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarNonEquatedDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
		return this;
	}
	
	@Step("Select on holiday")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectNonEquatedOnHoliday() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayNonEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
		
		return this;
	}
	
	@Step("Select profit frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectProfitFrequencyMonthly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYMONTHLY);
		return this;
	}
	
	@Step("Select profit frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectProfitFrequencyQuarterly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYQUARTERLY);
		return this;
	}
	
	@Step("Select profit frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectProfitFrequencyHalfYearly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYHALFYEARLY);
		return this;
	}
	
	@Step("Select profit frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectProfitFrequencyYearly() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYYEARLY);
		return this;
	}
	
	@Step("Select profit frequency")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectProfitFrequencyTwiceAMonth() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYTWICEAMONTH);
		return this;
	}
	
	@Step("Select profit frequency date: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectNonEquatedDate(String date) throws Exception {
		if(date != null) {
			PageFunctionUtils.clickOnElement(driver, byDateNonEquatedRadioButton);
			for(int i=0; i<FinacleFieldsUtils.DATEVALUES.length; i++) {
				if(Integer.parseInt(date) == FinacleFieldsUtils.DATEVALUES[i]) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, dateNonEquatedDropDownList, date);
				}
			}
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue6Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue7Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		return this;
	}
	
	@Step("Sending operative account id: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysOperativeAccountIdTextField(String operativeAccountId) throws Exception {
		if(operativeAccountId != null) {
			PageFunctionUtils.waitOnElement(driver, operativeAccountIdTextField);
			PageFunctionUtils.clickOnElement(driver, operativeAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, operativeAccountIdTextField, operativeAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue8Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		return this;
	}
	
	@Step("Sending expiry date: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysExpiryDateTextField(String expiryDate) throws Exception {
		if(expiryDate != null) {
			PageFunctionUtils.waitOnElement(driver, expiryDateTextField);
			PageFunctionUtils.clearDataInWebElement(driver, expiryDateTextField);
			PageFunctionUtils.clickOnElement(driver, expiryDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, expiryDateTextField, expiryDate.substring(1));
		}
		return this;
	}
	
	@Step("Sending document date: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysDocumentDateTextField(String documentDate) throws Exception {
		if(documentDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, documentDateTextField);
			PageFunctionUtils.clickOnElement(driver, documentDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, documentDateTextField, documentDate.substring(1));
		}
		return this;
	}
	
	@Step("Sending limit id: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysLimitIdTextField(String limitIdPrefix, String limitIdSuffix) throws Exception {
		if(limitIdPrefix != null && limitIdSuffix != null) {
			PageFunctionUtils.enterDataInWebElement(driver, limitIdPrefixTextField, limitIdPrefix.substring(1));
			PageFunctionUtils.enterDataInWebElement(driver, limitIdSuffixTextField, limitIdSuffix.substring(1));
			}
		return this;
	}
	
	@Step("Select drawing power indicator")
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectDrawingPowerIndicatorDerived() throws Exception {
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
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectDrawingPowerIndicatorEqual() throws Exception {
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
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectDrawingPowerIndicatorMaintained() throws Exception {
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
	public ABEOpenMurabahaAccountMurabahaFinancingPage selectDrawingPowerIndicatorParent() throws Exception {
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
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue9Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressContinue10Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(0,20);
		return this;
	}
	
	@Step("Save account id")
	public ABEOpenMurabahaAccountMurabahaFinancingPage saveAccountId(String linkedId, String disburseTcid) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGCSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGCSV, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYMURABAHAACCOUNTOPENINGMURABAHAFINANCINGCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYMURABAHAACCOUNTOPENINGMURABAHAFINANCINGCSV, accountIdCsvColumnName);
		int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGCSV, disburseTcidCsvColumnName, disburseTcid);		
		int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEDISBURSEMURABAHAACCOUNTMURABAHAFINANCINGCSV, tcIdCsvColumnName, disburseTcid);
		int columnByColumnName4 = CSVUtils.getColumnByColumnName(Paths.ABEDISBURSEMURABAHAACCOUNTMURABAHAFINANCINGCSV, murabahaAccountIdCsvColumnName);
		
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGCSV, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYMURABAHAACCOUNTOPENINGMURABAHAFINANCINGCSV, rowByTcid2, columnByColumnName2, acId);
		}
		
		if(rowByTcid3 != -1 && rowByTcid4 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABEDISBURSEMURABAHAACCOUNTMURABAHAFINANCINGCSV, rowByTcid4, columnByColumnName4, acId);
		}
		return this;
	}								
}