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
	private By basicAccountDetailsErrorMessage = By.id("errorItem_0.errorDesc");
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
	
	@Step("Sending Cif: {0}")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage sendKeyscCif(String cif) throws Exception {
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		driver.findElement(cifIdTextField).click();
		driver.findElement(cifIdTextField).sendKeys(cif);
		
		return this;
	}
	
	@Step("Sending Scheme Code: {0}")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage sendKeysSchemeCode( String schemeCode) throws Exception {
		driver.findElement(SchemeCodeTextField).click();
		driver.findElement(SchemeCodeTextField).sendKeys(schemeCode);
		
		return this;
	}
	
	@Step("Sending ccy: {0}")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage sendKeysCcy(String ccy) throws Exception {
		driver.findElement(ccyTextField).click();
		driver.findElement(ccyTextField).clear();
		driver.findElement(ccyTextField).sendKeys(ccy);
		
		return this;
	}
	
	@Step("Press go button")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage pressGoButton() throws Exception {
		driver.findElement(goButton).click();		

		return this;
	}
	
	
	@Step("Checked error message")
	public boolean CheckErrorMessage() throws Exception {
		driver.switchTo().parentFrame();
		boolean isErrorMessageDisplayed = driver.findElement(basicAccountDetailsErrorMessage).isDisplayed();
		
		
		return isErrorMessageDisplayed;
	}
	
	@Step("Switch to form area frame")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage SwtitchToformAreaFrame() throws Exception {
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		
		return this;
	}
	
	
	@Step("Press submit button")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage pressSubmitButton() throws Exception {
		driver.findElement(submitButton);
		driver.findElement(submitButton).click();
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(53, 71);
		System.out.println("Account ID: "+ acId);
		return this;
	}
	
	@Step("Save a/c. id")
	public ABECreateCASASavingsAccountLiabilitiesAndOperationPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECREATECASASAVINGSACCOUNTLIABILITIESANDOPERATIONCSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECREATECASASAVINGSACCOUNTLIABILITIESANDOPERATIONCSV, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYCASASAVINGSACCOUNTCREATIONLIABILITIESANDOPERATIONCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYCASASAVINGSACCOUNTCREATIONLIABILITIESANDOPERATIONCSV, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABECREATECASASAVINGSACCOUNTLIABILITIESANDOPERATIONCSV, rowByTcid1, columnByColumnName1, acId);
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYCASASAVINGSACCOUNTCREATIONLIABILITIESANDOPERATIONCSV, rowByTcid2, columnByColumnName2, acId);
		}
		return this;
	}	
}
