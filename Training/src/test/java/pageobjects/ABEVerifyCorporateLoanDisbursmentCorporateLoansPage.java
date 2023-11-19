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

public class ABEVerifyCorporateLoanDisbursmentCorporateLoansPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By acidTextField = By.xpath("//input[@id='_claAcct'])[1]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']");
	private By disbursmentDetailscontinueButton = By.xpath("(//button[@id='_continueButton'])[1]");
	private By additionalDetailsContinueButton = By.xpath("(//button[@id='_adddetContBtn'])[1]");
	private By drawdownModeDetailsContinueButton = By.xpath("(//button[@id='_contButton'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	public static String transactionId;
	private By transactionIdSuccessMessage = By.xpath("(//div[@id='_disbresult_tranId_text'])[1]");
	public static String TcidCsvColumnName = "tcId";
	public static String referenceCsvColumnName = "transactionId";

	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Sending menu name: {0}")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage sendKeysSearchBarTextField(String menu)
			throws Exception {
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
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(("loginFrame"));
		driver.switchTo().frame(("Core_ABE"));
		driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}

	@Step("Sending a/c. id: {0}")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage sendKeysAcidTextField(String acId) throws Exception {
		acId = acId.substring(1);
		PageFunctionUtils.waitOnElement(driver, acidTextField);
		driver.findElement(acidTextField).click();
		driver.findElement(acidTextField).sendKeys(acId);
		driver.findElement(GoButton).click();
		return this;
	}

	@Step("press DrawDown Details Continue Button")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage pressDrawdownDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentDetailscontinueButton);
		return this;
	}

	@Step("Press Additional Deatils Continue Button")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage pressAdditionalDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, additionalDetailsContinueButton);
		return this;
	}

	@Step("Press Drawdown Mode Details ContinueButton")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage pressdrawdownModeDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, drawdownModeDetailsContinueButton);
		return this;
	}

	@Step("Press submit Button")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		transactionId = driver.findElement(transactionIdSuccessMessage).getText();
		System.out.println("transaction id: " + transactionId);
		return this;
	}

	@Step("Save transaction id")
	public ABEVerifyCorporateLoanDisbursmentCorporateLoansPage saveTransactionId(String tcId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABEVERIFYCORPORATELOANDISBURSMENTCORPORATELOANSCSV,
				TcidCsvColumnName, tcId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(
				Paths.ABEVERIFYCORPORATELOANDISBURSMENTCORPORATELOANSCSV, referenceCsvColumnName);
		CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYCORPORATELOANDISBURSMENTCORPORATELOANSCSV, rowByTcid1,
				columnByColumnName1, transactionId);
		return this;
	}

}
