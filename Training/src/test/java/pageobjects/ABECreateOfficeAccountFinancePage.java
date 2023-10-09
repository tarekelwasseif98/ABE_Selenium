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

public class ABECreateOfficeAccountFinancePage {	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By GlSubHeadCodeTextField = By.xpath("(//input[@id='_glSubheadCode'])[1]");
	private By ccyTextField = By.xpath("(//input[@id='_crncyCode'])[1]");
	private By SchemeCodeTextField = By.xpath("(//input[@id='_schmCode'])[1]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By AccountHeadNameTextField = By.xpath("(//input[@id='_acctHeadName'])[1]");
	private By EODMaxBalanceTextField = By.xpath("(//input[@id='_freeText1'])[1]");
	private By SubmitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";

	
	 
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcId";
	public static String acId;
	private By accountIdSuccessMessage = By.id("_acctIdSum_text");

	public ABECreateOfficeAccountFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABECreateOfficeAccountFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABECreateOfficeAccountFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending office account type: {0}")
	public ABECreateOfficeAccountFinancePage sendKeysAccoundType(String SchemeCode, String GeneralLedgerSubhead, String ccy ) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver, GlSubHeadCodeTextField);
		PageFunctionUtils.clickAction(driver,GlSubHeadCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver,GlSubHeadCodeTextField,GeneralLedgerSubhead);
		PageFunctionUtils.clickAction(driver,SchemeCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver,SchemeCodeTextField,SchemeCode);
		PageFunctionUtils.clickAction(driver,ccyTextField);
		driver.findElement(ccyTextField).clear();
		PageFunctionUtils.enterDataInWebElement(driver,ccyTextField,ccy);
		PageFunctionUtils.clickAction(driver,GoButton);

		return this;
	}
	
	@Step("Sending office account details: {0}")
	public ABECreateOfficeAccountFinancePage sendKeysOfficeAccoundDetails(String AccountHeadName, String EODMaxBalance) throws Exception {

		PageFunctionUtils.clickAction(driver,AccountHeadNameTextField);
		PageFunctionUtils.enterDataInWebElement(driver,AccountHeadNameTextField,AccountHeadName);
		PageFunctionUtils.clickAction(driver,EODMaxBalanceTextField);
		PageFunctionUtils.enterDataInWebElement(driver,EODMaxBalanceTextField,EODMaxBalance);
		PageFunctionUtils.clickAction(driver,SubmitButton);
		acId = driver.findElement(accountIdSuccessMessage).getText();
		System.out.println("ACID: "+ acId);
		
		return this;
	}
	
	@Step("Save a/c. id")
	public ABECreateOfficeAccountFinancePage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECreateOfficeAccountFinanceCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECreateOfficeAccountFinanceCsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVerifyOfficeAccountFinanceCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVerifyOfficeAccountFinanceCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABECreateOfficeAccountFinanceCsv, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVerifyOfficeAccountFinanceCsv, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}		
	
	
	
	
	
	
	
	
	
	
	

}
