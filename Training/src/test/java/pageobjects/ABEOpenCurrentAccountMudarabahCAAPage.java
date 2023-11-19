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

public class ABEOpenCurrentAccountMudarabahCAAPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By cifIdTextField = By.xpath("(//input[@id='_critCif'])[1]");
	private By schemeCodeTextField = By.xpath("(//input[@id='_critSchmCode'])[1]");
	private By generalLedgerSubheadCodeTextField = By.xpath("(//input[@id='_glSubHeadCde'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By continueButton = By.xpath("(//button[@id='_acctDetCon'])[1]");
	private By taxDetailsMenu = By.xpath("//span[@id='stepII2_textSpan']");
	private By taxCategoryDropDownList = By.id("_wtaxFlg_select");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Open Islamic Current Account'])[1]");
	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public ABEOpenCurrentAccountMudarabahCAAPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEOpenCurrentAccountMudarabahCAAPage sendKeysSearchBarTextField(String menu) throws Exception {
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
		        }
	        catch (Exception e) {
	        }
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEOpenCurrentAccountMudarabahCAAPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending cif id: {0}")
	public ABEOpenCurrentAccountMudarabahCAAPage sendKeysCifIdTextField(String cifId) throws Exception {
		if(cifId != null) {
			PageFunctionUtils.waitOnElement(driver, cifIdTextField);
			PageFunctionUtils.clickOnElement(driver, cifIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifId.substring(1));
		}
		return this;
	}
	
	@Step("Sending scheme code: {0}")
	public ABEOpenCurrentAccountMudarabahCAAPage sendKeysSchemeCodeTextField(String schemeCode) throws Exception {
		if(schemeCode != null) {
			PageFunctionUtils.clickOnElement(driver, schemeCodeTextField);
			PageFunctionUtils.enterDataInWebElement(driver, schemeCodeTextField, schemeCode);
		}
		return this;
	}
	
	@Step("Sending general ledger subhead code: {0}")
	public ABEOpenCurrentAccountMudarabahCAAPage sendKeysGeneralLedgerSubheadCodeTextField(String generalLedgerSubheadCode) throws Exception {
		if(generalLedgerSubheadCode != null) {
			PageFunctionUtils.clickOnElement(driver, generalLedgerSubheadCodeTextField);
			PageFunctionUtils.enterDataInWebElement(driver, generalLedgerSubheadCodeTextField, generalLedgerSubheadCode);
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEOpenCurrentAccountMudarabahCAAPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Press continue button")
	public ABEOpenCurrentAccountMudarabahCAAPage pressContinueButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continueButton);
		PageFunctionUtils.clickOnElement(driver, continueButton);
		return this;
	}
	
	@Step("Select tax category")
	public ABEOpenCurrentAccountMudarabahCAAPage selectTaxCategory() throws Exception {
		PageFunctionUtils.clickOnElement(driver, taxDetailsMenu);
		PageFunctionUtils.selectDropDownListByIndex(driver, taxCategoryDropDownList, 2);
		return this;
	}
	
	@Step("Press submit button")
	public ABEOpenCurrentAccountMudarabahCAAPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(53);
		return this;
	}
	
	@Step("Save account id")
	public ABEOpenCurrentAccountMudarabahCAAPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABEOPENCURRENTACCOUNTMUDARABAHCAACSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABEOPENCURRENTACCOUNTMUDARABAHCAACSV, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYCURRENTACCOUNTOPENINGCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYCURRENTACCOUNTOPENINGCSV, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABEOPENCURRENTACCOUNTMUDARABAHCAACSV, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYCURRENTACCOUNTOPENINGCSV, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}												
}