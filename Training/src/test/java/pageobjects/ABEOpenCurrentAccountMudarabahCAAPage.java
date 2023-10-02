package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By cifIdTextField = By.xpath("(//input[@id='_critCif'])[1]");
	private By schemeCodeTextField = By.xpath("(//input[@id='_critSchmCode'])[1]");
	private By generalLedgerSubheadCodeTextField = By.xpath("(//input[@id='_glSubHeadCde'])[1]");
	private By solIdTextField = By.xpath("(//input[@id='_solId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By continueButton = By.xpath("(//button[@id='_acctDetCon'])[1]");
	private By taxDetailsMenu = By.xpath("//span[@id='stepII2_textSpan']");
	private By taxCategoryMenu = By.id("_wtaxFlg_select");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
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
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
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
	public ABEOpenCurrentAccountMudarabahCAAPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame((loginFrameIframeId));
	    driver.switchTo().frame((coreAbeIframeId));
	    driver.switchTo().frame((uxIframeId));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;		
	}
	
	@Step("Sending customer details: {0}")
	public ABEOpenCurrentAccountMudarabahCAAPage sendKeysAccountDetails(String cifid, String schemeCode, String generalLedgerSubheadCode) throws Exception {
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		driver.findElement(cifIdTextField).click();
		driver.findElement(cifIdTextField).sendKeys(cifid);
		driver.findElement(schemeCodeTextField).click();
		driver.findElement(schemeCodeTextField).sendKeys(schemeCode);
		driver.findElement(generalLedgerSubheadCodeTextField).click();
		driver.findElement(generalLedgerSubheadCodeTextField).sendKeys(generalLedgerSubheadCode);
		driver.findElement(solIdTextField).click();
		driver.findElement(solIdTextField).clear();
		driver.findElement(solIdTextField).sendKeys("2588");
		driver.findElement(goButton).click();
		driver.findElement(continueButton).click();
		driver.findElement(taxDetailsMenu).click();
		Select dropdown = new Select(driver.findElement(taxCategoryMenu));
		dropdown.selectByIndex(2);
		return this;
	}
	
	@Step("Press submit button")
	public ABEOpenCurrentAccountMudarabahCAAPage pressSubmitButton() throws Exception {
		driver.findElement(submitButton).click();
		PageFunctionUtils.waitOnElement(driver, accountIdSuccessMessage);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(53, 71);
		System.out.println("Account ID: "+ acId);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABEOpenCurrentAccountMudarabahCAAPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.OpenIslamicCurrentAccountCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.OpenIslamicCurrentAccountCsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyIslamicCurrentAccountCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyIslamicCurrentAccountCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.OpenIslamicCurrentAccountCsv, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.VerifyIslamicCurrentAccountCsv, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}												
}