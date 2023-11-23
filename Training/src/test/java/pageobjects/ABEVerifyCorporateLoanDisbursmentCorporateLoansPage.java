package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyCorporateLoanDisbursmentCorporateLoansPage {
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_claAcct'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']"); 
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By disbursmentDetailscontinueButton = By.xpath("(//button[@id='_continueButton'])[1]");
	private By additionalDetailsContinueButton = By.xpath("(//button[@id='_adddetContBtn'])[1]");
	private By drawdownModeDetailsContinueButton = By.xpath("(//button[@id='_contButton'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Verify Commercial Lending Drawdown or Reversal'])[1]");
	public static String transactionId;
	public static String tcidCsvColumnName = "tcId";
	public static String referenceCsvColumnName = "transactionId";

	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Sending menu name: {0}")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.switchToParentFrame(driver);
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
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;
	}

	@Step("Sending account id: {0}")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage sendKeysAccountIdTextField(String accountId) throws Exception {
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		PageFunctionUtils.clickOnElement(driver, accountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(2));
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}

	@Step("Press continue button")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage pressDrawdownDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentDetailscontinueButton);
		return this;
	}

	@Step("Press continue button")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage pressAdditionalDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, additionalDetailsContinueButton);
		return this;
	}

	@Step("Press continue button")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage pressDrawdownModeDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, drawdownModeDetailsContinueButton);
		return this;
	}

	@Step("Press submit button")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
}