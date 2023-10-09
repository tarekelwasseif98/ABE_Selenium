package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class CreateAchOutwardPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By dropdownAction = By.xpath("(//select[@id='_cFinFuncCode$funcCombo_select'])[1]");
	private By paySysTextField = By.xpath("(//input[@id='_cPaysysID'])[1]");
	private By paymentTypeDropdown = By.xpath("(//select[@id='_cPaymentType_select'])[1]");
	private By goButton = By.id("_go");
	private By accountRemTextField = By.xpath("(//input[@id='_debtorAcID'])[1]");
	private By currencyTextField = By.xpath("(//input[@id='_genInsReqAmt_crncy'])[1]");
	private By amountTextField = By.xpath("(//input[@id='_genInsReqAmt$amt'])[1]");
	private By additionalInstrumentDetailsDropDown = By.xpath("(//h3[normalize-space()='Additional Instrument Details'])[1]");
	private By futureValueDateTextField = By.xpath(("(//input[@id='_genInsDate'])[1]"));
	private By remittanceInfoDropDown = By.xpath("(//h3[normalize-space()='Remittance Information'])[1]");
	private By line1TextField = By.xpath("(//input[@id='_remittanceInfo1'])[1]");
	private By accountBenTextField = By.id("_genCredAcID");
	private By nameBenTextField = By.id("_genCreName");
	private By bicBenTextField = By.id("_genCrBank_bic$bic");
	private By networkBenTextField = By.id("_genCrBank_bic$networkId");
	private By bankBenTextField = By.id("_genCrBnkBankBrCode$bankCode");
	private By branchBenTextField = By.id("_genCrBnkBankBrCode$branchCode");
	private By enrichButton = By.id(("_fetch"));
	private By continueButton = By.id("_genContinue");
	private By chargeFetchButton = By.id("_chrgFetch");
	private By continueChargeButton = By.id("_chargeContinue");
	private By submitPayment = By.id("_submit");
	private String PosCsvColumnName = "Pos";
	private String linkedTcidCsvColumnName = "linkedTcid";
	private String tcIdCsvColumnName = "tcId";
	private String POID;
	private By PaymentOrderIDOutput = By.xpath("(//div[@id='_resultPOID_text'])[1]");
	
	public CreateAchOutwardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public CreateAchOutwardPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public CreateAchOutwardPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitch(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending payment details: {0}")
	public CreateAchOutwardPage sendKeysPaymentType(String PaySys) throws Exception {
		PageFunctionUtils.waitOnElement(driver, dropdownAction);
		
		Select dropdown1 = new Select(driver.findElement(dropdownAction));
		dropdown1.selectByIndex(1);
		
		Select dropdown2 = new Select(driver.findElement(paymentTypeDropdown));
		dropdown2.selectByIndex(1);
		
		driver.findElement(paySysTextField).sendKeys(PaySys);
		return this;
		
	}
	
	@Step("Press Go button")
	public CreateAchOutwardPage pressSubmitButton() throws Exception {
		driver.findElement(goButton).click();
		Thread.sleep(3500);
		return this;
}
	
	
	@Step("Sending ACH Outward Payment details: {0}")
	public CreateAchOutwardPage sendKeysAchOutwardPayment(String AccRem, String CCY, String Amount, String Date, String Line1, String AccBen, String NameBen, String BicBen, String NetworkBen, String BankBen, String BranchBen) throws Exception {
		PageFunctionUtils.waitOnElement(driver, accountRemTextField);
	
		String substringAcc = AccRem.substring(1);
		driver.findElement(accountRemTextField).sendKeys(substringAcc);
		
		driver.findElement(currencyTextField).sendKeys(CCY);
		
		driver.findElement(amountTextField).clear();
		String substringAmount = Amount.substring(1);
		driver.findElement(amountTextField).sendKeys(substringAmount);
		
		PageFunctionUtils.waitOnElement(driver, additionalInstrumentDetailsDropDown);
		driver.findElement(additionalInstrumentDetailsDropDown).click();
		
		driver.findElement(futureValueDateTextField).click();
		driver.findElement(futureValueDateTextField).sendKeys(Date);
		
		driver.findElement(remittanceInfoDropDown).click();
		driver.findElement(line1TextField).sendKeys(Line1);
		
		driver.findElement(accountBenTextField).sendKeys(AccBen);
		
		driver.findElement(nameBenTextField).sendKeys(NameBen);
		
		driver.findElement(bicBenTextField).sendKeys(BicBen);
		
		driver.findElement(networkBenTextField).sendKeys(NetworkBen);
		
		/*
		 * String s1 = BankBen.substring(2); String s2 = BranchBen.substring(3);
		 * 
		 * System.out.println(s1); System.out.println(s2);
		 * 
		 * driver.findElement(bankBenTextField).sendKeys(s1);
		 * 
		 * driver.findElement(branchBenTextField).sendKeys(s2);
		 */
		
		driver.findElement(enrichButton).click();
		
		driver.findElement(continueButton).click();
		
		driver.findElement(chargeFetchButton).click();
		
		driver.findElement(continueChargeButton).click();
		
		driver.findElement(submitPayment).click();
		
		POID = driver.findElement(PaymentOrderIDOutput).getText();
		
		return this;
		
	}
	
	@Step("Save a/c. id")
	public CreateAchOutwardPage savePO(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.Create_ACH_OutwardCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.Create_ACH_OutwardCsv, PosCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.Verify_ACH_Outwardcsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.Verify_ACH_Outwardcsv, PosCsvColumnName);
		int rowByTcid3 = CSVUtils.getRowByTcid(Paths.Authorize_ACH_Outwardcsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.Authorize_ACH_Outwardcsv, PosCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1 && rowByTcid3 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.Create_ACH_OutwardCsv, rowByTcid1, columnByColumnName1, POID);
			CSVUtils.insertValueInCsvCell(Paths.Verify_ACH_Outwardcsv, rowByTcid2, columnByColumnName2, POID);
			CSVUtils.insertValueInCsvCell(Paths.Authorize_ACH_Outwardcsv, rowByTcid3, columnByColumnName3, POID);
		}
		return this;
	}	
		
}