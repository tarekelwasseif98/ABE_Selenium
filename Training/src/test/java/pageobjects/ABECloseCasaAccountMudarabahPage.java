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

public class ABECloseCasaAccountMudarabahPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId = By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_acctId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");	
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By backgroundMenuButton = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By transferBalanceRadioButton = By.xpath("(//input[@id='_trfrYes_radio'])[1]");
	private By transactionTypeMenu = By.id("_tranType_select");
	private By transferAccountIdTextField = By.xpath("(//input[@id='_trfrActId'])[1]");
	public static By accountIdSuccessMessage = By.xpath("(//p[@id='_clsResMsg_paraMsg'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Close Islamic Liability Account'])[1]");
	private static String accountId;
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";

	public ABECloseCasaAccountMudarabahPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABECloseCasaAccountMudarabahPage sendKeysSearchBarTextField(String menu) throws Exception {
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
		        }
	        catch (Exception e) {
	        }
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABECloseCasaAccountMudarabahPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnElement(driver, backgroundMenuButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;
	}
	
	@Step("Sending account id: {0}")
	public ABECloseCasaAccountMudarabahPage sendKeysAccountIdTextField(String accountId) throws Exception {
		if(accountId != null) {
			PageFunctionUtils.waitOnElement(driver, accountIdTextField);
			PageFunctionUtils.clickOnElement(driver, accountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABECloseCasaAccountMudarabahPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Select transaction type")
	public ABECloseCasaAccountMudarabahPage selectTransactionType() throws Exception {
		PageFunctionUtils.clickOnElement(driver, transferBalanceRadioButton);
		PageFunctionUtils.selectDropDownListByIndex(driver, transactionTypeMenu, 2);
		return this;
	}
	
	@Step("Sending transfer account id: {0}")
	public ABECloseCasaAccountMudarabahPage sendKeysTransferAccountIdTextField(String transferAccountId) throws Exception {
		if(transferAccountId != null) {
			PageFunctionUtils.clickOnElement(driver, transferAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, transferAccountIdTextField, transferAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Press submit button")
	public ABECloseCasaAccountMudarabahPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		accountId = driver.findElement(accountIdSuccessMessage).getText().substring(92);
		return this;
	}
	
	@Step("Save account id")
	public ABECloseCasaAccountMudarabahPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECLOSECASAACCOUNTMUDARABAHCSV, linkedTcidCsvColumnName, linkedId);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYCASAACCOUNTCLOSUREMUDARABAHCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYCASAACCOUNTCLOSUREMUDARABAHCSV, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYCASAACCOUNTCLOSUREMUDARABAHCSV, rowByTcid2, columnByColumnName2, accountId);
		}
		return this;
	}
}