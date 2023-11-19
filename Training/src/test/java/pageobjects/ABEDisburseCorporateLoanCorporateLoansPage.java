package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEDisburseCorporateLoanCorporateLoansPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']");
	private String loginFrameById = "loginFrame";
	private String coreAbeFrameById = "Core_ABE";
	private String uxFrameById = "UX";

	private By accountIdTextField = By.xpath("(//input[@id='_claAcct'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By grossDisbursmentRadioButton = By.xpath("(//input[@id='_gross_radio'])[1]");
	private By netDisbursmentRadioButton = By.xpath("(//input[@id='_net_radio'])[1]");
	private By valueDateDrawDownTextField = By.xpath("(//input[@id='_valueDate'])[1]");
	private By disbursmentAmountTextField = By.xpath("(//input[@id='_disbursalAmt$amt'])[1]");
	private By disbursmentDetailscontinueButton = By.xpath("(//button[@id='_continueButton'])[1]");
	private By additionalDetailscontinueButton = By.xpath("(//button[@id='_adddetContBtn'])[1]");
	private By addButtonDrawDownMode = By.xpath("(//span[@id='_drawDownGrid_AddRecBtn_label'])[1]");
	private By modeDrawDownDropDownList = By.xpath("(//select[@id='_view_mode_select'])[1]");
	private By loanDisbursmentAmountTextField2 = By.xpath("(//input[@id='_view_loanAmtCrncy$amt'])[1]");
	private By sendAndPreviewButton = By.xpath("(//button[normalize-space()='Save and Preview'])[1]");
	private By editButtonDrawDownMode = By.xpath("(//span[@class='editcontent'])[1]");
	private By disbursmentCreditAccountTextField = By.xpath("(//input[@id='_view_creditAcctId'])[1]");
	private By updateButton = By.xpath("(//button[normalize-space()='Update'])[1]");
	public static String SuccessMessages;
	private By SuccessMessage = By.xpath("(//p[@id='_msg_paraMsg'])[1]");
	private By disbursmentModeContinueButton = By.xpath("(//button[@id='_disbmoddet_continue'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private String amountLoan;

	public ABEDisburseCorporateLoanCorporateLoansPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Sending menu name: {0}")
	public ABEDisburseCorporateLoanCorporateLoansPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEDisburseCorporateLoanCorporateLoansPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}

	@Step("Sending Loan id: {0}")
	public ABEDisburseCorporateLoanCorporateLoansPage sendKeysAccoundId(String accountId) throws Exception {

		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		PageFunctionUtils.clickOnElement(driver, accountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}

	@Step("Select Value Date for the Draw Down")
	public ABEDisburseCorporateLoanCorporateLoansPage sendKeyValueDate(String valueDateDrawDown) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, valueDateDrawDownTextField);
		PageFunctionUtils.enterDataInWebElement(driver, valueDateDrawDownTextField, valueDateDrawDown);
		return this;
	}

	@Step("Select Gross Disbursment Radio Button")
	public ABEDisburseCorporateLoanCorporateLoansPage selectGrossDisbursmentRadioButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, grossDisbursmentRadioButton);
		return this;
	}

	@Step("Select Net Disbursment Radio Button")
	public ABEDisburseCorporateLoanCorporateLoansPage selectNetDisbursmentRadioButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, netDisbursmentRadioButton);
		return this;
	}

	@Step("Get Disbursment Amount")
	public ABEDisburseCorporateLoanCorporateLoansPage sendAmountParitailDisbursmentAmount() throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentAmountTextField);
		amountLoan = driver.findElement(disbursmentAmountTextField).getText();
		return this;
	}

	@Step("press Disbursment details Continue Button")
	public ABEDisburseCorporateLoanCorporateLoansPage pressDisbursmentDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentDetailscontinueButton);
		return this;
	}

	@Step("Select additional details continue Button")
	public ABEDisburseCorporateLoanCorporateLoansPage pressAdditionalDetailsButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, additionalDetailscontinueButton);
		return this;
	}

	@Step("Press add button")
	public ABEDisburseCorporateLoanCorporateLoansPage pressAddButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, addButtonDrawDownMode);
		PageFunctionUtils.clickOnElement(driver, addButtonDrawDownMode);
		return this;
	}

	@Step("Deatils for Draw Down")
	public ABEDisburseCorporateLoanCorporateLoansPage enterDeatilsDrawDown(String disbursmentCreditAccount) throws Exception {
		PageFunctionUtils.waitOnElement(driver, modeDrawDownDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, modeDrawDownDropDownList, 0);
		PageFunctionUtils.waitOnElement(driver, disbursmentCreditAccountTextField);
		PageFunctionUtils.clickOnElement(driver, disbursmentCreditAccountTextField);
		PageFunctionUtils.enterDataInWebElement(driver, disbursmentCreditAccountTextField, disbursmentCreditAccount);
		PageFunctionUtils.clickOnElement(driver, loanDisbursmentAmountTextField2);
		PageFunctionUtils.enterDataInWebElement(driver, loanDisbursmentAmountTextField2, amountLoan);
		PageFunctionUtils.clickOnElement(driver, sendAndPreviewButton);
		return this;
	}

	@Step("View edit Button Draw Down Mode ")
	public boolean ViewEditButton() {
		return driver.findElement(editButtonDrawDownMode).isDisplayed();
	}

	@Step("Press edit Button Draw Down Mode ")
	public ABEDisburseCorporateLoanCorporateLoansPage pressEditButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, editButtonDrawDownMode);
		PageFunctionUtils.clickOnElement(driver, editButtonDrawDownMode);
		return this;
	}

	@Step("Send keys disbursment Credit Account")
	public ABEDisburseCorporateLoanCorporateLoansPage sendKeysDisbursmentAccount(String disbursmentCreditAccount)
			throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentCreditAccountTextField);
		PageFunctionUtils.enterDataInWebElement(driver, disbursmentCreditAccountTextField,
				disbursmentCreditAccount.substring(1));
		return this;
	}

	@Step("Press Update Button")
	public ABEDisburseCorporateLoanCorporateLoansPage pressSaveAndPreviewButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, updateButton);
		return this;
	}

	@Step("Press disbursment Mode Continue Button")
	public ABEDisburseCorporateLoanCorporateLoansPage pressDisbursmentModeContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentModeContinueButton);
		return this;
	}

	@Step("Press submit Button")
	public ABEDisburseCorporateLoanCorporateLoansPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		SuccessMessages = driver.findElement(SuccessMessage).getText();
		System.out.println(SuccessMessages);
		return this;
	}

}
