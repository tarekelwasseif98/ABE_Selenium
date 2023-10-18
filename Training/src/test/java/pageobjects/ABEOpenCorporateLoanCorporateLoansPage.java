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
	
	@Step("Sending customer details: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysAccountDetails(String cifid, String schemeCode, String accountOpeningDate) throws Exception {
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		PageFunctionUtils.clickOnElement(driver, cifIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifid);
		PageFunctionUtils.clickOnElement(driver, schemeCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver, schemeCodeTextField, schemeCode);
		PageFunctionUtils.clickOnElement(driver, goButton);
		PageFunctionUtils.clearDataInWebElement(driver, accountOpeningDateTextField);
		PageFunctionUtils.clickOnElement(driver, accountOpeningDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, accountOpeningDateTextField, accountOpeningDate.substring(1));
		PageFunctionUtils.selectDropDownListByVisibleText(driver, accountStatementDropDownList, FinacleFieldsUtils.AccountStatementNone);
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Sending loan details: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysLoanDetails(String loanAmount, String loanPeriodMonths, String loanPeriodDays) throws Exception {
		PageFunctionUtils.waitOnElement(driver, loanAmountTextField);
		PageFunctionUtils.clickOnElement(driver, loanAmountTextField);
		PageFunctionUtils.clearDataInWebElement(driver, loanAmountTextField);
		PageFunctionUtils.enterDataInWebElement(driver, loanAmountTextField, loanAmount);
		PageFunctionUtils.clickOnElement(driver, loanPeriodMonthsTextField);
		PageFunctionUtils.clearDataInWebElement(driver, loanPeriodMonthsTextField);
		PageFunctionUtils.enterDataInWebElement(driver, loanPeriodMonthsTextField, loanPeriodMonths);
		PageFunctionUtils.clickOnElement(driver, loanPeriodDaysTextField);
		PageFunctionUtils.clearDataInWebElement(driver, loanPeriodDaysTextField);
		PageFunctionUtils.enterDataInWebElement(driver, loanPeriodDaysTextField, loanPeriodDays);
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		PageFunctionUtils.clickOnElement(driver, interestParameterDetailsMenu);
		PageFunctionUtils.waitOnElement(driver, interestCompoundingFrequencyDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, interestCompoundingFrequencyDropDownList, FinacleFieldsUtils.InterestCompoundingFrequencyNoCompounding);
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Sending repayment parameters details: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysRepaymentParametersDetails(String numberOfInstallments, String installmentStartDate, String installmentFrequency, String date, String calendar, String onHoliday, String equatedInstallment, String interestStartDate, String interestFrequency) throws Exception {
		PageFunctionUtils.clickOnElement(driver, numberOfInstallmentsTextField);
		PageFunctionUtils.enterDataInWebElement(driver, numberOfInstallmentsTextField, numberOfInstallments);
		PageFunctionUtils.clearDataInWebElement(driver, installmentStartDateTextField);
		PageFunctionUtils.clickOnElement(driver, installmentStartDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, installmentStartDateTextField, installmentStartDate.substring(1));
		
		if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyDaily) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyWeekly) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyFortnightly) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyBullet)) {
			if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyDaily)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyDaily);
			}
			else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyWeekly)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyWeekly);
			}
			else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyFortnightly)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyFortnightly);
			}
			else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyBullet)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyBullet);
			}
			
			if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CalendarGregorianCalendar)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyCalendarDropDownList, FinacleFieldsUtils.CalendarGregorianCalendar);
			}
			else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CalendarHijriCalendar)){
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyCalendarDropDownList, FinacleFieldsUtils.CalendarHijriCalendar);
			}
			
			if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidayNextDay)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidayNextDay);
			}
			else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidayPreviousDay)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidayPreviousDay);
			}
			else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidaySkip)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidaySkip);
			}
		}
		else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyMonthly) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyQuarterly) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyHalfYearly) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyYearly) || installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyTwiceAMonth)){
			if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyMonthly)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyMonthly);
			}
			else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyQuarterly)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyQuarterly);
			}
			else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyHalfYearly)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyHalfYearly);
			}
			else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyYearly)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyYearly);
			}
			else if(installmentFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyTwiceAMonth)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDropDownList, FinacleFieldsUtils.FrequencyTwiceAMonth);
			}
			
			PageFunctionUtils.clickOnElement(driver, installmentFrequencyByDateRadioButton);
			for(int i=0; i<FinacleFieldsUtils.DateValues.length; i++) {
				if(Integer.parseInt(date) == FinacleFieldsUtils.DateValues[i]) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyDateDropDownList, date);
				}
			}
			if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CalendarGregorianCalendar)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyCalendarDropDownList, FinacleFieldsUtils.CalendarGregorianCalendar);
			}
			else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CalendarHijriCalendar)){
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyCalendarDropDownList, FinacleFieldsUtils.CalendarHijriCalendar);
			}
			
			if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidayNextDay)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidayNextDay);
			}
			else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidayPreviousDay)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidayPreviousDay);
			}
			else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidaySkip)) {
				PageFunctionUtils.selectDropDownListByVisibleText(driver, installmentFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidaySkip);
			}
		}
		
		if(equatedInstallment.equalsIgnoreCase(FinacleFieldsUtils.EquatedInstallmentNo)) {
			PageFunctionUtils.clickOnElement(driver, equatedInstallmentNoRadioButton);
			PageFunctionUtils.clearDataInWebElement(driver, interestStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, interestStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, interestStartDateTextField, installmentStartDate.substring(1));
			
			if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyDaily) || interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyWeekly) || interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyFortnightly)) {
				if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyDaily)){
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FrequencyDaily);
				}
				else if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyWeekly)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FrequencyWeekly);
				}
				else if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyFortnightly)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FrequencyFortnightly);
				}
				if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CalendarGregorianCalendar)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyCalendarDropDownList, FinacleFieldsUtils.CalendarGregorianCalendar);
				}
				else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CalendarHijriCalendar)){
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyCalendarDropDownList, FinacleFieldsUtils.CalendarHijriCalendar);
				}
				
				if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidayNextDay)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidayNextDay);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidayPreviousDay)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidayPreviousDay);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidaySkip)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidaySkip);
				}
			}
			else if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyMonthly) || interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyQuarterly) || interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyHalfYearly) || interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyYearly) || interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyTwiceAMonth)) {
				if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyMonthly)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FrequencyMonthly);
				}
				else if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyQuarterly)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FrequencyQuarterly);
				}
				else if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyHalfYearly)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FrequencyHalfYearly);
				}
				else if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyYearly)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FrequencyYearly);
				}
				else if(interestFrequency.equalsIgnoreCase(FinacleFieldsUtils.FrequencyTwiceAMonth)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDropDownList, FinacleFieldsUtils.FrequencyTwiceAMonth);
				}
				PageFunctionUtils.clickOnElement(driver, interestFrequencyByDateRadioButton);
				for(int i=0; i<FinacleFieldsUtils.DateValues.length; i++) {
					if(Integer.parseInt(date) == FinacleFieldsUtils.DateValues[i]) {
						PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyDateDropDownList, date);
					}
				}
				if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CalendarGregorianCalendar)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyCalendarDropDownList, FinacleFieldsUtils.CalendarGregorianCalendar);
				}
				else if(calendar.equalsIgnoreCase(FinacleFieldsUtils.CalendarHijriCalendar)){
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyCalendarDropDownList, FinacleFieldsUtils.CalendarHijriCalendar);
				}
				
				if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidayNextDay)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidayNextDay);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidayPreviousDay)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidayPreviousDay);
				}
				else if(onHoliday.equalsIgnoreCase(FinacleFieldsUtils.OnHolidaySkip)) {
					PageFunctionUtils.selectDropDownListByVisibleText(driver, interestFrequencyOnHolidayDropDownList, FinacleFieldsUtils.OnHolidaySkip);
				}
			}
		}
		else if(equatedInstallment.equalsIgnoreCase(FinacleFieldsUtils.EquatedInstallmentYes)) {
			PageFunctionUtils.clickOnElement(driver, equatedInstallmentYesRadioButton);
		}
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		return this;
	}
	
	@Step("Sending operative account id: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysOperativeAccountIdTextField(String operativeAccountId) throws Exception {
		PageFunctionUtils.enterDataInWebElement(driver, operativeAccountIdTextField, operativeAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		PageFunctionUtils.clickOnElement(driver, continue11Button);
		PageFunctionUtils.clickOnElement(driver, continue12Button);
		return this;
	}
	
	@Step("Sending account limit details: {0}")
	public ABEOpenCorporateLoanCorporateLoansPage sendKeysAccountLimitDetails(String expiryDate, String documentDate, String limitIdPrefix, String limitIdSuffix, String drawingPowerIndicator) throws Exception {
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
		if(drawingPowerIndicator.equalsIgnoreCase(FinacleFieldsUtils.DrawingPowerIndicatorDerived)) {
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DrawingPowerIndicatorDerived);
		}
		if(drawingPowerIndicator.equalsIgnoreCase(FinacleFieldsUtils.DrawingPowerIndicatorEqual)) {
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DrawingPowerIndicatorEqual);
		}
		if(drawingPowerIndicator.equalsIgnoreCase(FinacleFieldsUtils.DrawingPowerIndicatorMaintained)) {
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DrawingPowerIndicatorMaintained);
		}
		if(drawingPowerIndicator.equalsIgnoreCase(FinacleFieldsUtils.DrawingPowerIndicatorParent)) {
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIndicatorDropDownList, FinacleFieldsUtils.DrawingPowerIndicatorParent);
		}
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
	}
		PageFunctionUtils.clickOnElement(driver, continue13Button);
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
	
	@Step("Save a/c. id")
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