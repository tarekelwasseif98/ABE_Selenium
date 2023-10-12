package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABEOpenMurabahaAccountMurabahaFinancingPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']"); 
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
	public ABEOpenMurabahaAccountMurabahaFinancingPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending customer details: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysAccountDetails(String cifid, String schemeCode) throws Exception {
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		PageFunctionUtils.clickOnElement(driver, cifIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifid);
		PageFunctionUtils.clickOnElement(driver, schemeCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver, schemeCodeTextField, schemeCode);
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Sending basic asset details: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysBasicAssetDetails(String assetValue, String customerMargin) throws Exception {
		PageFunctionUtils.waitOnElement(driver, assetValueTextField);
		PageFunctionUtils.clickOnElement(driver, assetValueTextField);
		PageFunctionUtils.clearDataInWebElement(driver, assetValueTextField);
		PageFunctionUtils.enterDataInWebElement(driver, assetValueTextField, assetValue);
		if(Integer.parseInt(assetValue) < Integer.parseInt(customerMargin)) {
			AssertionFactory.assertionFailWithMessage("Customer margin can not be greater than asset value");
		}
		else {
			PageFunctionUtils.clickOnElement(driver, customerMarginTextField);
			PageFunctionUtils.clearDataInWebElement(driver, customerMarginTextField);
			PageFunctionUtils.enterDataInWebElement(driver, customerMarginTextField, customerMargin);
		}
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Sending finance details: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysFinanceDetails(String financePeriodMonths, String financePeriodDays, String debitAccountId) throws Exception {
		PageFunctionUtils.waitOnElement(driver, financePeriodMonthsTextField);
		PageFunctionUtils.clickOnElement(driver, financePeriodMonthsTextField);
		PageFunctionUtils.clearDataInWebElement(driver, financePeriodMonthsTextField);
		PageFunctionUtils.enterDataInWebElement(driver, financePeriodMonthsTextField, financePeriodMonths);
		PageFunctionUtils.clickOnElement(driver, financePeriodDaysTextField);
		PageFunctionUtils.clearDataInWebElement(driver, financePeriodDaysTextField);
		PageFunctionUtils.enterDataInWebElement(driver, financePeriodDaysTextField, financePeriodDays);
		PageFunctionUtils.clickOnElement(driver, debitAccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, debitAccountIdTextField, debitAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Sending repayment parameter details: {0}")
	public ABEOpenMurabahaAccountMurabahaFinancingPage sendKeysRepaymentParameterDetails(String equatedInstallment, String numberOfInstallments, String installmentStartDate, String installmentFrequency, String profitStartDate, String profitFrequency, String date, String calendar, String onHoliday) throws Exception {
		Select installmentFrequencyDropDownListSelector = new Select(driver.findElement(installmentFrequencyDropDownList));
		Select dateEquatedDropDownListSelector = new Select(driver.findElement(dateEquatedDropDownList));
		Select calendarEquatedDropDownListSelector = new Select(driver.findElement(calendarEquatedDropDownList));
		Select onHolidayEquatedDropDownListSelector = new Select(driver.findElement(onHolidayEquatedDropDownList));
		Select repaymentTypeDropDownListSelector = new Select(driver.findElement(repaymentTypeDropDownList));
		int [] dateValues = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		if(equatedInstallment.equalsIgnoreCase("yes")) {
			PageFunctionUtils.waitOnElement(driver, equatedInstallmentYesRadioButton);
			PageFunctionUtils.clickOnElement(driver, equatedInstallmentYesRadioButton);
			PageFunctionUtils.clickOnElement(driver, numberOfInstallmentsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, numberOfInstallmentsTextField, numberOfInstallments);
			PageFunctionUtils.clearDataInWebElement(driver, installmentStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, installmentStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, installmentStartDateTextField, installmentStartDate.substring(1));
			if(installmentFrequency.equalsIgnoreCase("daily") || installmentFrequency.equalsIgnoreCase("weekly") || installmentFrequency.equalsIgnoreCase("fortnightly")) {
				if(installmentFrequency.equalsIgnoreCase("daily")) {
					installmentFrequencyDropDownListSelector.selectByVisibleText("Daily");
				}
				else if(installmentFrequency.equalsIgnoreCase("weekly")) {
					installmentFrequencyDropDownListSelector.selectByVisibleText("Weekly");
				}
				else if(installmentFrequency.equalsIgnoreCase("fortnightly")) {
					installmentFrequencyDropDownListSelector.selectByVisibleText("Fortnightly");
				}
				
				if(calendar.equalsIgnoreCase("gregorian calendar")) {
					calendarEquatedDropDownListSelector.selectByVisibleText("Gregorian Calendar");
				}
				else if(calendar.equalsIgnoreCase("hijri calendar")) {
					calendarEquatedDropDownListSelector.selectByVisibleText("Hijri Calendar");
				}
				
				if(onHoliday.equalsIgnoreCase("next day")) {
					onHolidayEquatedDropDownListSelector.selectByVisibleText("Next Day");
				}
				else if(onHoliday.equalsIgnoreCase("previous day")) {
					onHolidayEquatedDropDownListSelector.selectByVisibleText("Previous Day");
				}
				else if(onHoliday.equalsIgnoreCase("skip")){
					onHolidayEquatedDropDownListSelector.selectByVisibleText("Skip");
				}
			}
			if(installmentFrequency.equalsIgnoreCase("monthly") || installmentFrequency.equalsIgnoreCase("quarterly") || installmentFrequency.equalsIgnoreCase("half yearly") || installmentFrequency.equalsIgnoreCase("yearly") || installmentFrequency.equalsIgnoreCase("twice a month")) {
				if(installmentFrequency.equalsIgnoreCase("monthly")) {
					installmentFrequencyDropDownListSelector.selectByVisibleText("Monthly");
				}
				else if(installmentFrequency.equalsIgnoreCase("quarterly")) {
					installmentFrequencyDropDownListSelector.selectByVisibleText("Quarterly");
				}
				else if(installmentFrequency.equalsIgnoreCase("half yearly")) {
					installmentFrequencyDropDownListSelector.selectByVisibleText("Half Yearly");
				}
				else if(installmentFrequency.equalsIgnoreCase("yearly")) {
					installmentFrequencyDropDownListSelector.selectByVisibleText("Yearly");
				}
				else if(installmentFrequency.equalsIgnoreCase("twice a month")) {
					installmentFrequencyDropDownListSelector.selectByVisibleText("Twice a Month");
				}
				PageFunctionUtils.clickOnElement(driver, byDateEquatedRadioButton);
				for(int i=0; i<dateValues.length; i++) {
					if(Integer.parseInt(date) == dateValues[i]) {
						dateEquatedDropDownListSelector.selectByVisibleText(date);
					}
				}
				if(calendar.equalsIgnoreCase("gregorian calendar")) {
					calendarEquatedDropDownListSelector.selectByVisibleText("Gregorian Calendar");
				}
				else if(calendar.equalsIgnoreCase("hijri calendar")) {
					calendarEquatedDropDownListSelector.selectByVisibleText("Hijri Calendar");
				}
				
				if(onHoliday.equalsIgnoreCase("next day")) {
					onHolidayEquatedDropDownListSelector.selectByVisibleText("Next Day");
				}
				else if(onHoliday.equalsIgnoreCase("previous day")) {
					onHolidayEquatedDropDownListSelector.selectByVisibleText("Previous Day");
				}
				else if(onHoliday.equalsIgnoreCase("skip")){
					onHolidayEquatedDropDownListSelector.selectByVisibleText("Skip");
				}			
				
			}
		}
		else {
			PageFunctionUtils.clickOnElement(driver, equatedInstallmentNoRadioButton);
			PageFunctionUtils.clickOnElement(driver, numberOfInstallmentsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, numberOfInstallmentsTextField, numberOfInstallments);
			repaymentTypeDropDownListSelector.selectByVisibleText("Bullet");
			PageFunctionUtils.clearDataInWebElement(driver, installmentStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, installmentStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, installmentStartDateTextField, installmentStartDate.substring(1));
			
			if(calendar.equalsIgnoreCase("gregorian calendar")) {
				calendarEquatedDropDownListSelector.selectByVisibleText("Gregorian Calendar");
			}
			else if(calendar.equalsIgnoreCase("hijri calendar")) {
				calendarEquatedDropDownListSelector.selectByVisibleText("Hijri Calendar");
			}
			
			if(onHoliday.equalsIgnoreCase("next day")) {
				onHolidayEquatedDropDownListSelector.selectByVisibleText("Next Day");
			}
			else if(onHoliday.equalsIgnoreCase("previous day")) {
				onHolidayEquatedDropDownListSelector.selectByVisibleText("Previous Day");
			}
			else if(onHoliday.equalsIgnoreCase("skip")){
				onHolidayEquatedDropDownListSelector.selectByVisibleText("Skip");
			}
			PageFunctionUtils.clearDataInWebElement(driver, profitStartDateTextField);
			PageFunctionUtils.clickOnElement(driver, profitStartDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, profitStartDateTextField, profitStartDate.substring(1));
			Select profitFrequencyDropDownListSelector = new Select(driver.findElement(profitFrequencyDropDownList));
			Select dateNonEquatedDropDownListSelector = new Select(driver.findElement(dateNonEquatedDropDownList));
			Select calendarNonEquatedDropDownListSelector = new Select(driver.findElement(calendarNonEquatedDropDownList));
			Select onHolidayNonEquatedDropDownListSelector = new Select(driver.findElement(onHolidayNonEquatedDropDownList));
			if(profitFrequency.equalsIgnoreCase("daily") || profitFrequency.equalsIgnoreCase("weekly") || profitFrequency.equalsIgnoreCase("fortnightly")) {
				if(profitFrequency.equalsIgnoreCase("daily")) {
					profitFrequencyDropDownListSelector.selectByVisibleText("Daily");
				}
				else if(profitFrequency.equalsIgnoreCase("weekly")) {
					profitFrequencyDropDownListSelector.selectByVisibleText("Weekly");
				}
				else if(profitFrequency.equalsIgnoreCase("fortnightly")) {
					profitFrequencyDropDownListSelector.selectByVisibleText("Fortnightly");
				}
				
				if(calendar.equalsIgnoreCase("gregorian calendar")) {
					calendarNonEquatedDropDownListSelector.selectByVisibleText("Gregorian Calendar");
				}
				else if(calendar.equalsIgnoreCase("hijri calendar")) {
					calendarNonEquatedDropDownListSelector.selectByVisibleText("Hijri Calendar");
				}
				
				if(onHoliday.equalsIgnoreCase("next day")) {
					onHolidayNonEquatedDropDownListSelector.selectByVisibleText("Next Day");
				}
				else if(onHoliday.equalsIgnoreCase("previous day")) {
					onHolidayNonEquatedDropDownListSelector.selectByVisibleText("Previous Day");
				}
				else if(onHoliday.equalsIgnoreCase("skip")){
					onHolidayNonEquatedDropDownListSelector.selectByVisibleText("Skip");
				}
			}
			if(profitFrequency.equalsIgnoreCase("monthly") || profitFrequency.equalsIgnoreCase("quarterly") || profitFrequency.equalsIgnoreCase("half yearly") || profitFrequency.equalsIgnoreCase("yearly") || profitFrequency.equalsIgnoreCase("twice a month")) {
				if(profitFrequency.equalsIgnoreCase("monthly")) {
					profitFrequencyDropDownListSelector.selectByVisibleText("Monthly");
				}
				else if(profitFrequency.equalsIgnoreCase("quarterly")) {
					profitFrequencyDropDownListSelector.selectByVisibleText("Quarterly");
				}
				else if(profitFrequency.equalsIgnoreCase("half yearly")) {
					profitFrequencyDropDownListSelector.selectByVisibleText("Half Yearly");
				}
				else if(profitFrequency.equalsIgnoreCase("yearly")) {
					profitFrequencyDropDownListSelector.selectByVisibleText("Yearly");
				}
				else if(profitFrequency.equalsIgnoreCase("twice a month")) {
					profitFrequencyDropDownListSelector.selectByVisibleText("Twice a Month");
				}
				PageFunctionUtils.clickOnElement(driver, byDateNonEquatedRadioButton);
				for(int i=0; i<dateValues.length; i++) {
					if(Integer.parseInt(date) == dateValues[i]) {
						dateNonEquatedDropDownListSelector.selectByVisibleText(date);
					}
				}
				if(calendar.equalsIgnoreCase("gregorian calendar")) {
					calendarNonEquatedDropDownListSelector.selectByVisibleText("Gregorian Calendar");
				}
				else if(calendar.equalsIgnoreCase("hijri calendar")) {
					calendarNonEquatedDropDownListSelector.selectByVisibleText("Hijri Calendar");
				}
				
				if(onHoliday.equalsIgnoreCase("next day")) {
					onHolidayNonEquatedDropDownListSelector.selectByVisibleText("Next Day");
				}
				else if(onHoliday.equalsIgnoreCase("previous day")) {
					onHolidayNonEquatedDropDownListSelector.selectByVisibleText("Previous Day");
				}
				else if(onHoliday.equalsIgnoreCase("skip")){
					onHolidayNonEquatedDropDownListSelector.selectByVisibleText("Skip");
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
		Select drawingPowerIndicatorDropDownListSelector = new Select(driver.findElement(drawingPowerIndicatorDropDownList));
		if(drawingPowerIndicator.equalsIgnoreCase("derived")) {
			drawingPowerIndicatorDropDownListSelector.selectByVisibleText("Derived");
		}
		if(drawingPowerIndicator.equalsIgnoreCase("equal")) {
			drawingPowerIndicatorDropDownListSelector.selectByVisibleText("Equal");
		}
		if(drawingPowerIndicator.equalsIgnoreCase("maintained")) {
			drawingPowerIndicatorDropDownListSelector.selectByVisibleText("Maintained");
		}
		if(drawingPowerIndicator.equalsIgnoreCase("parent")) {
			drawingPowerIndicatorDropDownListSelector.selectByVisibleText("Parent");
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