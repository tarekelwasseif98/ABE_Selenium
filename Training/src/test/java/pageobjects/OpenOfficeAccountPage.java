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

public class OpenOfficeAccountPage {	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By GlSubHeadCodeTextField = By.xpath("(//input[@id='_glSubheadCode'])[1]");
	private By SchemeCodeTextField = By.xpath("(//input[@id='_schmCode'])[1]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By AccountHeadNameTextField = By.xpath("(//input[@id='_acctHeadName'])[1]");
	private By EODMaxBalanceTextField = By.xpath("(//input[@id='_freeText1'])[1]");
	private By SubmitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	public static String acid;
	private By accountIdSuccessMessage = By.id("_acctIdSum_text");

	public OpenOfficeAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public OpenOfficeAccountPage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitch(driver, loginFrameIframeID);
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
	public OpenOfficeAccountPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitch(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending office account type: {0}")
	public OpenOfficeAccountPage sendKeysAccoundType(String SchemeCode, String GeneralLedgerSubhead) throws Exception {
		PageFunctionUtils.waitOnElement(driver, GlSubHeadCodeTextField);
		driver.findElement(GlSubHeadCodeTextField);
		driver.findElement(GlSubHeadCodeTextField).click();
		driver.findElement(GlSubHeadCodeTextField).sendKeys(GeneralLedgerSubhead);
		
		driver.findElement(SchemeCodeTextField);
		driver.findElement(SchemeCodeTextField).click();
		driver.findElement(SchemeCodeTextField).sendKeys(SchemeCode);
		driver.findElement(GoButton).click();
		
		
		return this;
	}
	
	@Step("Sending office account details: {0}")
	public OpenOfficeAccountPage sendKeysOfficeAccoundDetails(String AccountHeadName, String EODMaxBalance) throws Exception {
		PageFunctionUtils.waitOnElement(driver, AccountHeadNameTextField);
		driver.findElement(AccountHeadNameTextField);
		driver.findElement(AccountHeadNameTextField).click();
		driver.findElement(AccountHeadNameTextField).sendKeys(AccountHeadName);
		driver.findElement(EODMaxBalanceTextField);
		driver.findElement(EODMaxBalanceTextField).click();
		driver.findElement(EODMaxBalanceTextField).sendKeys(EODMaxBalance);
		driver.findElement(SubmitButton).click();
		acid = driver.findElement(accountIdSuccessMessage).getText();
		System.out.println("ACID: "+ acid);
		
		return this;
	}
	
	@Step("Save a/c. id")
	public OpenOfficeAccountPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.OpenOfficeAccountCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.OpenOfficeAccountCsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyOfficeAccountCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyOfficeAccountCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.OpenOfficeAccountCsv, rowByTcid1, columnByColumnName1, acid);
			CSVUtils.insertValueInCsvCell(Paths.VerifyOfficeAccountCsv, rowByTcid2, columnByColumnName2, acid);
		}
		return this;
	}		
	
	
	
	
	
	
	
	
	
	
	

}
