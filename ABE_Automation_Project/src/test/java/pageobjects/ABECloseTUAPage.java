package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABECloseTUAPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_acntId'])[1]");
	private By closureValueDateTextField = By.xpath("(//input[@id='_clsValDate'])[1]");
	private By repaymentAccountIdTextField = By.xpath("(//input[@id='_repayActId'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Close Islamic Top Up Deposit Account'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By backgroundMenuButton = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public ABECloseTUAPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABECloseTUAPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	        }
        catch (Exception e) {
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABECloseTUAPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnElement(driver, backgroundMenuButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending a/c. id: {0}")
	public ABECloseTUAPage sendKeysAccountIdTextField(String accountId, String closureValueDate) throws Exception {
		accountId = accountId.substring(1);
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		PageFunctionUtils.clickOnElement(driver, accountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId);
		PageFunctionUtils.clearDataInWebElement(driver, closureValueDateTextField);
		PageFunctionUtils.clickOnElement(driver, closureValueDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, closureValueDateTextField, closureValueDate.substring(1));
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Sending repayment a/c. id: {0}")
	public ABECloseTUAPage sendKeysRepaymentAccountIdTextField(String repaymentAccountId) throws Exception {
		repaymentAccountId = repaymentAccountId.substring(1);
		PageFunctionUtils.waitOnElement(driver, repaymentAccountIdTextField);
		PageFunctionUtils.clearDataInWebElement(driver, repaymentAccountIdTextField);
		PageFunctionUtils.clickOnElement(driver, repaymentAccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, repaymentAccountIdTextField, repaymentAccountId);
		return this;
	}
	
	@Step("Press submit button")
	public ABECloseTUAPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.sleep();
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(60);		
		WebElement element = driver.findElement(menuNameTextBox);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABECloseTUAPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.CloseTUACsv, linkedTcidCsvColumnName, linkedId);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyTUAClosureCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyTUAClosureCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.VerifyTUAClosureCsv, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}	
}