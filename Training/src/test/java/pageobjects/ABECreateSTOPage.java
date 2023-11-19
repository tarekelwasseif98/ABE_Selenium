package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.FinacleFieldsUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABECreateSTOPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By dropdownAction = By.xpath("(//select[@id='_criteria_FinFuncCode1$funcCombo_select'])[1]");
	private By mandateTypeRadioButton = By.xpath("(//label[normalize-space()='Standing Order'])[1]");
	private By moduleIDTextField = By.xpath("(//input[@id='_module_id_crit'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By accSendTextField = By.xpath("(//input[@id='_acct_id_mnd_dtls'])[1]");
	private By ccyTextField = By.xpath("(//input[@id='_crncy_mnd_dtls'])[1]");
	private By prefPaySysIDTextField = By.xpath("(//input[@id='_paysys_id_mnd_dtls'])[1]");
	private By accRecvTextField = By.xpath("(//input[@id='_acct_id_2_mnd_dtls'])[1]");
	private By nameRecvTextField = By.xpath("(//input[@id='_other_party_name_mnd_dtls'])[1]");
	private By bankRecvTextField = By.xpath("(//input[@id='_bank_branch_code_mnd_dtls$bankCode'])[1]");
	private By branchRecvTextField = By.xpath("(//input[@id='_bank_branch_code_mnd_dtls$branchCode'])[1]");
	private By fixedAmtTypeRadioButton = By.xpath("(//input[@id='_crit_FinRadioButton1_radio'])[1]");
	private By startDateFixedAmtType = By.xpath("(//input[@id='_start_date_mnd_dtls'])[1]");
	private By noOfExecuteFixedAmtType = By.xpath("(//input[@id='_no_of_times_exec_mnd_dtls'])[1]");
	private By frequencyDropDownList = By.xpath("(//select[@id='_freq_mnd_dtls$frequency_select'])[1]");
	private By weekFrequnecyDropDownList = By.xpath("(//select[@id='_freq_mnd_dtls$freqWeek_select'])[1]");
	private By dayFrequnecyDropDownList = By.xpath("(//select[@id='_freq_mnd_dtls$freqDay_select'])[1]");
	private By calenderDropDownList = By.xpath("(//select[@id='_freq_mnd_dtls$freqCalendar_select'])[1]");
	private By onHolidayDropDownList = By.xpath("(//select[@id='_freq_mnd_dtls$freqHoliday_select'])[1]");
	private By valueOfNdaysTextField = By.xpath("(//input[@id='_freq_mnd_dtls$valueOfN'])[1]");
	private By derivedAmtTypeRadioButton = By.xpath("(//input[@id='_crit_FinRadioButton2_radio'])[1]");
	private By amtFixedTextField = By.xpath("(//input[@id='_amt_mnd_dtls$amt'])[1]");
	private By accBalanceDerivedTextField = By.xpath("(//input[@id='_acct_balance_mnd_dtls$amt'])[1]");
	private By amtInMultiplesDerivedTextField = By.xpath("(//input[@id='_amt_multiples_mnd_dtls$amt'])[1]");
	private By balanceIndictorDropDownList = By.xpath("(//select[@id='_acct_balance_ind_mnd_dtls_select'])[1]");
	private By continueButton = By.xpath("(//button[@id='_continue_mnd_dtls'])[1]");
	private By processingChargesMenu = By.xpath("(//h2[normalize-space()='Processing Charges'])[1]");
	private By chargeEventIDTextField = By.xpath("(//input[@id='_maint_chrg_id_addtln_dtls'])[1]");
	private By submitRecord = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private String mandateCsvColumnName = "mandate";
	private String linkedTcidCsvColumnName = "linkedTcid";
	private String tcIdCsvColumnName = "tcId";
	private String mandateNO;
	private By mandateIDOutput = By.xpath("(//div[@id='_result_ref_no_text'])[1]");

	public ABECreateSTOPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Sending menu name: {0}")
	public ABECreateSTOPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABECreateSTOPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(("loginFrame"));
		driver.switchTo().frame(("Core_ABE"));
		driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}

	@Step("Sending STO details: {0}")
	public ABECreateSTOPage sendKeysPaymentType(String module) throws Exception {
		PageFunctionUtils.waitOnElement(driver, dropdownAction);

		// Select Drop Down Action
		Select dropdown1 = new Select(driver.findElement(dropdownAction));
		dropdown1.selectByIndex(1);

		// Select Mandate type Radio Button
		PageFunctionUtils.clickOnElement(driver, mandateTypeRadioButton);

		// Enter Module ID
		PageFunctionUtils.clickOnElement(driver, moduleIDTextField);
		PageFunctionUtils.enterDataInWebElement(driver, moduleIDTextField, module);

		return this;
	}

	@Step("Press Go button")
	public ABECreateSTOPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}

	@Step("Sending STO details: {0}")
	public ABECreateSTOPage sendKeysSTO(String accSend, String ccy, String paysys, String accRecv, String nameRecv,
			String bankRecv, String branchRecv) throws Exception {
		PageFunctionUtils.waitOnElement(driver, accSendTextField);

		// Enter Account Sender
		String substringAcc = accSend.substring(1);
		PageFunctionUtils.enterDataInWebElement(driver, accSendTextField, substringAcc);

		// Enter CCY
		PageFunctionUtils.enterDataInWebElement(driver, ccyTextField, ccy);

		// Enter Preferred PaysysID
		PageFunctionUtils.enterDataInWebElement(driver, prefPaySysIDTextField, paysys);

		// Enter Account Receiver
		PageFunctionUtils.enterDataInWebElement(driver, accRecvTextField, accRecv);

		// Enter Name Receiver
		PageFunctionUtils.enterDataInWebElement(driver, nameRecvTextField, nameRecv);

		// Enter Bank and Branch Receiver
		PageFunctionUtils.enterDataInWebElement(driver, bankRecvTextField, bankRecv.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, branchRecvTextField, branchRecv.substring(1));
		return this;
	}

	@Step("Select Amount type Fixed: {0}")
	public ABECreateSTOPage sendAmountTypeFixedSTO(String amtFixed, String startDate, String noOfExe, String frequency,
			String valueNday) throws Exception {
		// Select Fixed Amount type
		PageFunctionUtils.clickOnElement(driver, fixedAmtTypeRadioButton);
		PageFunctionUtils.clickOnElement(driver, fixedAmtTypeRadioButton);
		PageFunctionUtils.enterDataInWebElement(driver, amtFixedTextField, amtFixed);
		PageFunctionUtils.clickOnElement(driver, startDateFixedAmtType);
		PageFunctionUtils.enterDataInWebElement(driver, startDateFixedAmtType, startDate.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, noOfExecuteFixedAmtType, noOfExe);
		// Frequency Monthly
		if (frequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)) {
			PageFunctionUtils.selectDropDownListByIndex(driver, frequencyDropDownList, 4);
			PageFunctionUtils.selectDropDownListByIndex(driver, weekFrequnecyDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, dayFrequnecyDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, calenderDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, onHolidayDropDownList, 1);
		} else // Frequency Daily
		if (frequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)) {
			PageFunctionUtils.selectDropDownListByIndex(driver, frequencyDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, calenderDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, onHolidayDropDownList, 2);
		} else // Frequency Weekly
		if (frequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
			PageFunctionUtils.selectDropDownListByIndex(driver, frequencyDropDownList, 2);
			PageFunctionUtils.selectDropDownListByIndex(driver, calenderDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, onHolidayDropDownList, 2);
		} else // Frequency N Days
		if (frequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYNDAYS)) {
			PageFunctionUtils.selectDropDownListByIndex(driver, frequencyDropDownList, 8);
			PageFunctionUtils.enterDataInWebElement(driver, valueOfNdaysTextField, valueNday);
			PageFunctionUtils.selectDropDownListByIndex(driver, calenderDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, onHolidayDropDownList, 2);
		}
		return this;
	}

	@Step("Select Amount type Derived: {0}")
	public ABECreateSTOPage sendAmountTypeDerivedSTO(String accBalance, String amtInMulti, String startDate,
			String noOfExe, String frequency, String valueNday) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver, derivedAmtTypeRadioButton);
		PageFunctionUtils.clickOnElement(driver, derivedAmtTypeRadioButton);
		PageFunctionUtils.clickOnElement(driver, derivedAmtTypeRadioButton);
		PageFunctionUtils.enterDataInWebElement(driver, accBalanceDerivedTextField, accBalance);
		PageFunctionUtils.enterDataInWebElement(driver, amtInMultiplesDerivedTextField, amtInMulti);
		PageFunctionUtils.selectDropDownListByIndex(driver, balanceIndictorDropDownList, 3);
		PageFunctionUtils.clickOnElement(driver, startDateFixedAmtType);
		PageFunctionUtils.enterDataInWebElement(driver, startDateFixedAmtType, startDate.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, noOfExecuteFixedAmtType, noOfExe);

		// Frequency Monthly
		if (frequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)) {
			PageFunctionUtils.selectDropDownListByIndex(driver, frequencyDropDownList, 4);
			PageFunctionUtils.selectDropDownListByIndex(driver, weekFrequnecyDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, dayFrequnecyDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, calenderDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, onHolidayDropDownList, 1);
		} else // Frequency Daily
		if (frequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)) {
			PageFunctionUtils.selectDropDownListByIndex(driver, frequencyDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, calenderDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, onHolidayDropDownList, 2);
		} else // Frequency Weekly
		if (frequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
			PageFunctionUtils.selectDropDownListByIndex(driver, frequencyDropDownList, 2);
			PageFunctionUtils.selectDropDownListByIndex(driver, calenderDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, onHolidayDropDownList, 2);
		} else // Frequency N Days
		if (frequency.equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYNDAYS)) {
			PageFunctionUtils.selectDropDownListByIndex(driver, frequencyDropDownList, 8);
			PageFunctionUtils.enterDataInWebElement(driver, valueOfNdaysTextField, valueNday);
			PageFunctionUtils.selectDropDownListByIndex(driver, calenderDropDownList, 1);
			PageFunctionUtils.selectDropDownListByIndex(driver, onHolidayDropDownList, 2);
		}
		return this;
	}

	@Step("Submit STO Record: {0}")
	public ABECreateSTOPage submitSTO(String chargeEvent) throws Exception {

		// Press Continue Button
		PageFunctionUtils.clickOnElement(driver, continueButton);

		// Select Charge Type
		PageFunctionUtils.clickOnElement(driver, processingChargesMenu);
		PageFunctionUtils.clickOnElement(driver, chargeEventIDTextField);
		PageFunctionUtils.enterDataInWebElement(driver, chargeEventIDTextField, chargeEvent);

		// Submit Record
		PageFunctionUtils.clickOnElement(driver, submitRecord);

		// Save Mandate Reference ID
		PageFunctionUtils.waitOnElement(driver, mandateIDOutput);
		mandateNO = driver.findElement(mandateIDOutput).getText();
		return this;

	}

	@Step("Save MandateID")
	public ABECreateSTOPage saveSTO(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECREATESTOCSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECREATESTOCSV, mandateCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYSTOCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYSTOCSV, mandateCsvColumnName);
		if (rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABECREATESTOCSV, rowByTcid1, columnByColumnName1, mandateNO);
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYSTOCSV, rowByTcid2, columnByColumnName2, mandateNO);
		}
		return this;
	}
}