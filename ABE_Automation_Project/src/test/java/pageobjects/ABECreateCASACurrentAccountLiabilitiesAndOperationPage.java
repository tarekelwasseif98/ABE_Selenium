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

public class ABECreateCASACurrentAccountLiabilitiesAndOperationPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By cifIdTextField = By.xpath("(//input[@id='_critCif'])[1]");
	private By SchemeCodeTextField = By.xpath("(//input[@id='_critSchmCode'])[1]");
	private By ccyTextField = By.xpath("(//input[@id='_crncyCode'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	public static String acId;
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	public static String acid;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";

	
	public ABECreateCASACurrentAccountLiabilitiesAndOperationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABECreateCASACurrentAccountLiabilitiesAndOperationPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABECreateCASACurrentAccountLiabilitiesAndOperationPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending customer & Account details: {0}")
	public ABECreateCASACurrentAccountLiabilitiesAndOperationPage sendKeysAccoundDetails(String cif, String schemeCode, String ccy) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		PageFunctionUtils.clickOnElement(driver,cifIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,cifIdTextField,cif);
		PageFunctionUtils.clickOnElement(driver,SchemeCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver,SchemeCodeTextField,schemeCode);
		PageFunctionUtils.clickOnElement(driver,ccyTextField);
		driver.findElement(ccyTextField).clear();
		PageFunctionUtils.enterDataInWebElement(driver,ccyTextField,ccy);	
		PageFunctionUtils.clickOnElement(driver,goButton);

		return this;
	}
	
	@Step("Press submit button")
	public ABECreateCASACurrentAccountLiabilitiesAndOperationPage pressSubmitButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,submitButton);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(53, 71);
		System.out.println("Account ID: "+ acId);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABECreateCASACurrentAccountLiabilitiesAndOperationPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECreateCASACurrentAccountLiabilitiesAndOperationCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECreateCASACurrentAccountLiabilitiesAndOperationCsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABECreateCASACurrentAccountLiabilitiesAndOperationCsv, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationCsv, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}		
	
	
	
	
	
	
	
}
