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
	private By accountIdSuccessMessage = By.xpath("(//div[@id='_resacctId_text'])[1]");
	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
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
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysCifIdTextField(String cifid) throws Exception {
		if(cifid != null) {
			PageFunctionUtils.waitOnElement(driver, cifIdTextField);
			PageFunctionUtils.clickOnElement(driver, cifIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifid);
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
		PageFunctionUtils.clickOnElement(driver, goButton);
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
	
	@Step("Sending repayment parameter details: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysRepaymentParameterDetails(String equatedInstallment, String numberOfInstallments, String installmentStartDate, String installmentFrequency, String profitStartDate, String profitFrequency, String date, String calendar, String onHoliday) throws Exception {
		if(equatedInstallment.equalsIgnoreCase(FinacleFieldsUtils.EQUATEDINSTALLMENTYES)) {
			PageFunctionUtils.waitOnElement(driver, equatedInstallmentYesRadioButton);
			PageFunctionUtils.clickOnElement(driver, equatedInstallmentYesRadioButton);
			PageFunctionUtils.clickOnElement(driver, numberOfInstallmentsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, numberOfInstallmentsTextField, numberOfInstallments);
			PageFunctionUtils.clearDataInWebElement(driver, installmentStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, installmentStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, installmentStartDateTextField, installmentStartDate.substring(1));
			if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
				if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYDAILY);
				}
				else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYWEEKLY);
				}
				else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYFORTNIGHTLY);
				}
				
				if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARGREGORIANCALENDAR)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarEquatedDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
				}
				else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARHIJRICALENDAR)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarEquatedDropDownList, FinacleFieldsUtils.CALENDARHIJRICALENDAR);
				}
				
				if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYNEXTDAY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYSKIP)){
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYSKIP);
				}
			}
			if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYTWICEAMONTH)) {
				if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYMONTHLY);
				}
				else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYQUARTERLY);
				}
				else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYHALFYEARLY);
				}
				else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYYEARLY);
				}
				else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYTWICEAMONTH)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYTWICEAMONTH);
				}
				PageFunctionUtils.clickOnElement(driver, byDateEquatedRadioButton);
				for(int i=0; i<FinacleFieldsUtils.DATEVALUES.length; i++) {
					if(Integer.parseInt(date) == FinacleFieldsUtils.DATEVALUES[i]) {
						PageFunctionUtils.selectDropDownListByVisibleText(driver, dateEquatedDropDownList, date);
					}
				}
				if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARGREGORIANCALENDAR)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarEquatedDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
				}
				else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARHIJRICALENDAR)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarEquatedDropDownList, FinacleFieldsUtils.CALENDARHIJRICALENDAR);
				}
				
				if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYNEXTDAY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYSKIP)){
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYSKIP);
				}			
				
			}
		}
		else {
			PageFunctionUtils.clickOnElement(driver, equatedInstallmentNoRadioButton);
			PageFunctionUtils.clickOnElement(driver, numberOfInstallmentsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, numberOfInstallmentsTextField, numberOfInstallments);
			PageFunctionUtils.selectDropDownListByVisibleText(driver, repaymentTypeDropDownList, FinacleFieldsUtils.FREQUENCYBULLET);
			PageFunctionUtils.clearDataInWebElement(driver, installmentStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, installmentStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, installmentStartDateTextField, installmentStartDate.substring(1));
			
			if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARGREGORIANCALENDAR)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarEquatedDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
			}
			else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARHIJRICALENDAR)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarEquatedDropDownList, FinacleFieldsUtils.CALENDARHIJRICALENDAR);
			}
			
			if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYNEXTDAY)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
			}
			else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY);
			}
			else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYSKIP)){
				PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYSKIP);
			}
			PageFunctionUtils.clearDataInWebElement(driver, profitStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, profitStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, profitStartDateTextField, profitStartDate.substring(1));
			if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY) || profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY) || profitFrequency.equalsIgnoreCase("fortnightly")) {
				if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYDAILY);
				}
				else if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYWEEKLY);
				}
				else if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYFORTNIGHTLY);
				}
				
				if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARGREGORIANCALENDAR)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarNonEquatedDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
				}
				else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARHIJRICALENDAR)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarNonEquatedDropDownList, FinacleFieldsUtils.CALENDARHIJRICALENDAR);
				}
				
				if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYNEXTDAY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayNonEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayNonEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYSKIP)){
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayNonEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYSKIP);
				}
			}
			if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY) || profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY) || profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY) || profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY) || profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYTWICEAMONTH)) {
				if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYMONTHLY);
				}
				else if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYQUARTERLY);
				}
				else if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYHALFYEARLY);
				}
				else if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYYEARLY);
				}
				else if(profitFrequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYTWICEAMONTH)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, profitFrequencyDropDownList, FinacleFieldsUtils.FREQUENCYTWICEAMONTH);
				}
				PageFunctionUtils.clickOnElement(driver, byDateNonEquatedRadioButton);
				for(int i=0; i<FinacleFieldsUtils.DATEVALUES.length; i++) {
					if(Integer.parseInt(date) == FinacleFieldsUtils.DATEVALUES[i]) {
						PageFunctionUtils.selectDropDownListByVisibleText(driver, dateNonEquatedDropDownList, date);
					}
				}
				if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARGREGORIANCALENDAR)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarNonEquatedDropDownList, FinacleFieldsUtils.CALENDARGREGORIANCALENDAR);
				}
				else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CALENDARHIJRICALENDAR)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, calendarNonEquatedDropDownList, FinacleFieldsUtils.CALENDARHIJRICALENDAR);
				}
				
				if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYNEXTDAY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayNonEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYNEXTDAY);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayNonEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYPREVIOUSDAY);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.ONHOLIDAYSKIP)){
					PageFunctionUtils.selectDropDownListByVisibleText(driver, onHolidayNonEquatedDropDownList, FinacleFieldsUtils.ONHOLIDAYSKIP);
				}
				
			}
		}
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		return this;
	}
	
	@Step("Sending operative account id: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysOperativeAccountIdTextField(String operativeAccountId) throws Exception {
		PageFunctionUtils.waitOnElement(driver, operativeAccountIdTextField);
		PageFunctionUtils.clickOnElement(driver, operativeAccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, operativeAccountIdTextField, operativeAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		return this;
	}
	
	@Step("Sending account limit details: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysAccountLimitDetails(String expiryDate, String documentDate, String limitIdPrefix, String limitIdSuffix, String drawingPowerIndicator) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, expiryDateTextField);
		PageFunctionUtils.clickOnElement(driver, expiryDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, expiryDateTextField, expiryDate.substring(1));
		PageFunctionUtils.clearDataInWebElement(driver, documentDateTextField);
		PageFunctionUtils.clickOnElement(driver, documentDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, documentDateTextField, documentDate.substring(1));
		try {
			PageFunctionUtils.enterDataInWebElement(driver, limitIdPrefixTextField, limitIdPrefix.substring(1));
			PageFunctionUtils.enterDataInWebElement(driver, limitIdSuffixTextField, limitIdSuffix.substring(1));
		} catch(Exception e) {
	}
		if(drawingPowerIndicator.equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORDERIVED)) {
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DRAWINGPOWERINDICATORDERIVED);
		}
		if(drawingPowerIndicator.equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATOREQUAL)) {
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DRAWINGPOWERINDICATOREQUAL);
		}
		if(drawingPowerIndicator.equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORMAINTAINED)) {
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DRAWINGPOWERINDICATORMAINTAINED);
		}
		if(drawingPowerIndicator.equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORPARENT)) {
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DRAWINGPOWERINDICATORPARENT);
		}
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
	}
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABEOpenMurabahaAccountMurabahaFinancingPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(0,20);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABEOpenMurabahaAccountMurabahaFinancingPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.OpenMurabahaAccountCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.OpenMurabahaAccountCsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyMurabahaAccountOpeningCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyMurabahaAccountOpeningCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.OpenMurabahaAccountCsv, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.VerifyMurabahaAccountOpeningCsv, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}								
}