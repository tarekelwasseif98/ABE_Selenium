package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABECreateCASASavingsAccountLiabilitiesAndOperationPage {
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By cifIdTextField = By.xpath("(//input[@id='_critCif'])[1]");
	private By SchemeCodeTextField = By.xpath("(//input[@id='_critSchmCode'])[1]");
	private By ccyTextField = By.xpath("(//input[@id='_crncyCode'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	public static String acId;
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	public static String acid;
	public static String error;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";

	
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending customer & Account details: {0}")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage sendKeysAccoundDetails(String cif, String schemeCode, String ccy) throws Exception {
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		driver.findElement(cifIdTextField).click();
		driver.findElement(cifIdTextField).sendKeys(cif);
		driver.findElement(SchemeCodeTextField).click();
		driver.findElement(SchemeCodeTextField).sendKeys(schemeCode);
		driver.findElement(ccyTextField).click();
		driver.findElement(ccyTextField).clear();
		driver.findElement(ccyTextField).sendKeys(ccy);
		driver.findElement(goButton).click();		
		try {
			driver.switchTo().parentFrame();
			boolean isErrorMessageDisplayed = driver.findElement(By.id("errorItem_0.errorDesc")).isDisplayed();
			if(isErrorMessageDisplayed==true) {
				AssertionFactory.assertionFailWithMessage("Error message displayed while opening the account");	
			} else {
				PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
				}
		} catch (Exception e) {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			}	
		return this;
	}
	
	@Step("Press submit button")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage pressSubmitButton() throws Exception {
		driver.findElement(submitButton);
		driver.findElement(submitButton).click();
		Thread.sleep(3500);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(53, 71);
		System.out.println("Account ID: "+ acId);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECreateCASASavingsAccountLiabilitiesAndOperationCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECreateCASASavingsAccountLiabilitiesAndOperationCsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABECreateCASASavingsAccountLiabilitiesAndOperationCsv, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationCsv, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}	
}
