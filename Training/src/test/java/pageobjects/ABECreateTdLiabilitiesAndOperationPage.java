package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABECreateTdLiabilitiesAndOperationPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By functionCodeDropdown =By.xpath("(//select[@id='_funcCode_select'])[1]"); 
	private By renewalDropdown =By.xpath("(//select[@id='_renewOption_select'])[1]"); 
	private String renewalType = "Principal Only";
	private String type = "Open";
	private By cifTextField =By.xpath("(//input[@id='_cifId'])[1]"); 
	private By ccyTextField =By.xpath("(//input[@id='_crncyCode'])[1]"); 
	private By schemeCodeField =By.xpath("(//input[@id='_schmCode'])[1]"); 
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By initialDepositAmmountTextField = By.xpath("(//input[@id='_initDepAmt$amt'])[1]");
	private By debitAcIdTextField = By.xpath("(//input[@id='_debitAcId'])[1]");
	private By SubmitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By accountIdSuccessMessage = By.id("_resMsg_paraMsg");
	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	private By mPeriodTextField = By.xpath("(//input[@id='_depPeriod$duration1'])[1]");
	private By dPeriodTextField = By.xpath("(//input[@id='_depPeriod$duration2'])[1]");
	private By schemeErrorPopUp = By.xpath("(//p[@id='errorItem_0.errorDesc'])[1]");

	
	

	
	public ABECreateTdLiabilitiesAndOperationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABECreateTdLiabilitiesAndOperationPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABECreateTdLiabilitiesAndOperationPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Selecting Td type: {0}")
	public ABECreateTdLiabilitiesAndOperationPage SelectFunctionCodeDropDown() throws Exception {
		
		PageFunctionUtils.waitOnElement(driver, functionCodeDropdown);
		PageFunctionUtils.clickOnElement(driver,functionCodeDropdown);
		Select functionCodeDropdownSelector = new Select(driver.findElement(functionCodeDropdown));
		functionCodeDropdownSelector.selectByVisibleText(type);

		return this;
	}
	
	@Step("Sending Cif: {0}")
	public ABECreateTdLiabilitiesAndOperationPage sendKeysCif(String cif ) throws Exception {
		
		PageFunctionUtils.clickOnElement(driver,cifTextField);
		PageFunctionUtils.enterDataInWebElement(driver,cifTextField,cif);

		return this;
		}
	
	@Step("Sending Scheme code: {0}")
	public ABECreateTdLiabilitiesAndOperationPage sendKeysSchemeCode(String schemeCode ) throws Exception {
	
	PageFunctionUtils.clickOnElement(driver,schemeCodeField);
	PageFunctionUtils.enterDataInWebElement(driver,schemeCodeField,schemeCode);
	return this;
	}
	
	@Step("Sending CCY: {0}")
	public ABECreateTdLiabilitiesAndOperationPage sendKeysCcy(String ccy ) throws Exception {
	
	PageFunctionUtils.clickOnElement(driver,ccyTextField);
	PageFunctionUtils.enterDataInWebElement(driver,ccyTextField,ccy);
	return this;
	}
	
	@Step("Press go button")
	public ABECreateTdLiabilitiesAndOperationPage PressGoButton() throws Exception {
	
	PageFunctionUtils.clickOnElement(driver,GoButton);
	return this;
	}
	
	
	@Step("Sending Td deposit amount: {0} ")
	public ABECreateTdLiabilitiesAndOperationPage sendKeysInitialDepositAmmount(String initialDepositAmmount) throws Exception {

		PageFunctionUtils.clickOnElement(driver,initialDepositAmmountTextField);
		PageFunctionUtils.enterDataInWebElement(driver,initialDepositAmmountTextField,initialDepositAmmount);

		return this;
		
	}
	
	@Step("Sending debit AcId: {0} ")
	public ABECreateTdLiabilitiesAndOperationPage sendKeysDebitAcId(String debitAcId ) throws Exception {

		PageFunctionUtils.clickOnElement(driver,debitAcIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,debitAcIdTextField,debitAcId.substring(1));
	
		return this;
		
	}
	
	@Step("select Renewal Type: ")
	public ABECreateTdLiabilitiesAndOperationPage selectRenewalType() throws Exception {

		Select renewalDropdownSelector = new Select(driver.findElement(renewalDropdown));
		renewalDropdownSelector.selectByVisibleText(renewalType);
		
		return this;
		
	}
	
	@Step("Sending Td details: ")
	public String getMonthPeriodValue() throws Exception {
		
		String f1= driver.findElement(mPeriodTextField).getAttribute("value");
		
		return f1;
		
	}
	
	@Step("Sending Td details: ")
	public String getDayPeriodValue() throws Exception {
		
		String f2= driver.findElement(dPeriodTextField).getAttribute("value");
		
		return f2;
		
	}
	
	@Step("Sending Td monthly period: {0} ")
	public ABECreateTdLiabilitiesAndOperationPage sendKeysTdPeriod(String monthlyPeriod,String dailyPeriod) throws Exception {

		PageFunctionUtils.clickOnElement(driver,mPeriodTextField);
		PageFunctionUtils.clearDataInWebElement(driver, mPeriodTextField);
		PageFunctionUtils.enterDataInWebElement(driver,mPeriodTextField, monthlyPeriod );
		PageFunctionUtils.clickOnElement(driver,dPeriodTextField);
		PageFunctionUtils.clearDataInWebElement(driver, dPeriodTextField);
		PageFunctionUtils.enterDataInWebElement(driver,dPeriodTextField, dailyPeriod );

		return this;
		
	}
	
	@Step("Press submit button:  ")
	public ABECreateTdLiabilitiesAndOperationPage pressSubmitButton() throws Exception {

		PageFunctionUtils.waitOnElement(driver, SubmitButton);
		PageFunctionUtils.clickOnElement(driver,SubmitButton);
		
		return this;
		
	}
	
	
	@Step("Saving TD ID: {0}")
	public ABECreateTdLiabilitiesAndOperationPage saveTd(String linkedId) throws Exception {

		try {
			acId = driver.findElement(accountIdSuccessMessage).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PageFunctionUtils.clickOnElement(driver,SubmitButton);
			driver.switchTo().parentFrame();
			AssertionFactory.assertionFailWithMessage(driver.findElement(schemeErrorPopUp).getText().toString());

		}
		
		
		System.out.println("ACID: "+ acId.substring(41));
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECREATETDLIABILITIESANDOPERATIONCSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECREATETDLIABILITIESANDOPERATIONCSV, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYTDLIABILITIESANDOPERATIONCSV, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYTDLIABILITIESANDOPERATIONCSV, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.ABECREATETDLIABILITIESANDOPERATIONCSV, rowByTcid1, columnByColumnName1, acId.substring(41));
			CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYTDLIABILITIESANDOPERATIONCSV, rowByTcid2, columnByColumnName2, acId.substring(41));
		}
	
		return this;
	}
	
}
