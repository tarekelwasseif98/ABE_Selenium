package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aspose.psd.system.Threading.Thread;
import io.qameta.allure.Step;
import data.ABECreateOutwardTransferPaymentData;
import tests.ABECreateACHOutwardTest;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABECreateSTOPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By dropdownAction = By.xpath("(//select[@id='_criteria_FinFuncCode1$funcCombo_select'])[1]");
	private By mandateTypeRadioButton = By.xpath("(//label[normalize-space()='Standing Order'])[1]");
	private By moduleIDTextField = By.xpath("(//input[@id='_module_id_crit'])[1]");
	private By goButton = By.id("_go");
	private By accSendTextField = By.xpath("(//input[@id='_acct_id_mnd_dtls'])[1]");
	private String mandateCsvColumnName = "mandate";
	private String linkedTcidCsvColumnName = "linkedTcid";
	private String tcIdCsvColumnName = "tcId";
	private String mandateNO;
	private By paymentOrderIDOutput = By.xpath("(//div[@id='_resultPOID_text'])[1]");
	
	
	public ABECreateSTOPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABECreateSTOPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABECreateSTOPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending STO details: {0}")
	public ABECreateSTOPage sendKeysPaymentType(String module) throws Exception {
		PageFunctionUtils.waitOnElement(driver, dropdownAction);
		
		//Select Drop Down Action
		Select dropdown1 = new Select(driver.findElement(dropdownAction));
		dropdown1.selectByIndex(1);
		
		//Select Mandate type Radio Button 
		PageFunctionUtils.clickOnElement(driver, mandateTypeRadioButton);
	
		//Enter Module ID **ERROR**
		PageFunctionUtils.clickOnElement(driver, moduleIDTextField);
		PageFunctionUtils.enterDataInWebElement(driver, moduleIDTextField, module);

		return this;
		
	}

	
	@Step("Press Go button")
	public ABECreateSTOPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
}
 	
	
	@Step("Sending STO details: {0}")
	public ABECreateSTOPage sendKeysSTO (String countryCodeREM	, String waiveRemark ,String waiveChargeRadio, String chargetype, String accRem, String ccy, String nameRem, String address1_Ben, String address2_Ben, String purcode, String address1_Rem, String address2_Rem ,String amount, String date, String line1, String accBen, String nameBen, String bicBen, String networkBen, String bankBen, String branchBen) throws Exception {
		//PageFunctionUtils.waitOnElement(driver, accountRemTextField);
		return this;
		}
	}
	
//		//Enter Account Debtor
//		String substringAcc = accRem.substring(1);
//		PageFunctionUtils.enterDataInWebElement(driver, accountRemTextField, substringAcc);
//		
//		//Enter Name Debtor
//		PageFunctionUtils.clickOnElement(driver, nameRemTextField);
//		PageFunctionUtils.clearDataInWebElement(driver,nameRemTextField);
//		PageFunctionUtils.enterDataInWebElement(driver, nameRemTextField, nameRem);
//		
//		//Enter Address1 Debtor
//		PageFunctionUtils.clickOnElement(driver,additionalDebtorDropDown);
//		PageFunctionUtils.clearDataInWebElement(driver,addressRemLine1TextField);
//		PageFunctionUtils.enterDataInWebElement(driver, addressRemLine1TextField, address1_Rem);
//		
//		//Enter Address2 Debtor
//		PageFunctionUtils.clearDataInWebElement(driver,addressRemLine2TextField);
//		PageFunctionUtils.enterDataInWebElement(driver, addressRemLine2TextField, address2_Rem);
//		
//		//Enter CCY
//		PageFunctionUtils.enterDataInWebElement(driver, currencyTextField, ccy);		
//		
//		//Enter Amount
//		PageFunctionUtils.clearDataInWebElement(driver, amountTextField);
//		String substringAmount = amount.substring(1);
//		PageFunctionUtils.enterDataInWebElement(driver, amountTextField, substringAmount);
//		
//		//Select Waive Charges
//		if(waiveChargeRadio.equals("YES")) {
//		PageFunctionUtils.clickOnElement(driver, waiveChargesYes);
//		PageFunctionUtils.clickOnElement(driver,waiveChargeRemarkTextField);
//		PageFunctionUtils.enterDataInWebElement(driver,waiveChargeRemarkTextField, waiveRemark);
//		
//		}else if(waiveChargeRadio.equals("NO")) {
//			PageFunctionUtils.clickOnElement(driver, waiveChargesNo);
//			}
//		//Enter Purpose Code
//		PageFunctionUtils.clickOnElement(driver, purposeCode);
//		PageFunctionUtils.enterDataInWebElement(driver, purposeCode, purcode);
//		
//		if(waiveChargeRadio.equals("NO")) {
//		//Select Charge Type
//		PageFunctionUtils.clickOnElement(driver, additionalChargeDropDown);
//		Select renewalDropdownSelector = new Select(driver.findElement(chargeType));
//		renewalDropdownSelector.selectByVisibleText(chargetype);
//		}
//		//Enter Future Value Date
//		PageFunctionUtils.waitOnElement(driver, additionalInstrumentDetailsDropDown);
//		PageFunctionUtils.clickOnElement(driver, additionalInstrumentDetailsDropDown);
//		PageFunctionUtils.clickOnElement(driver,futureValueDateTextField);
//		PageFunctionUtils.enterDataInWebElement(driver,futureValueDateTextField, date);
//		
//		//Enter Remittance Information
//		PageFunctionUtils.clickOnElement(driver,remittanceInfoDropDown);
//		PageFunctionUtils.enterDataInWebElement(driver, line1TextField, line1);
//		
//		//Enter Account Creditor
//		PageFunctionUtils.enterDataInWebElement(driver, accountBenTextField, accBen);
//		
//		//Enter Name Creditor
//		PageFunctionUtils.enterDataInWebElement(driver, nameBenTextField, nameBen);
//		
//		//Enter BIC Creditor
//		PageFunctionUtils.enterDataInWebElement(driver, bicBenTextField, bicBen);
//		
//		//Enter Network Creditor
//		PageFunctionUtils.enterDataInWebElement(driver, networkBenTextField, networkBen);
//		
//		//Enter Address1 Creditor
//		PageFunctionUtils.clickOnElement(driver, additionalCreditorDropDown); 
//		PageFunctionUtils.clearDataInWebElement(driver,addressBenLine1TextField);
//		PageFunctionUtils.enterDataInWebElement(driver, addressBenLine1TextField, address1_Ben);
//		
//		//Enter Address2 Creditor
//		PageFunctionUtils.waitOnElement(driver, addressBenLine2TextField);
//		PageFunctionUtils.clearDataInWebElement(driver,addressBenLine2TextField);
//		PageFunctionUtils.enterDataInWebElement(driver, addressBenLine2TextField, address2_Ben);
//		
//		
//		//Enter Country Code Creditor 
//		PageFunctionUtils.waitOnElement(driver, countryCodeREMTextField);
//		PageFunctionUtils.clickOnElement(driver, countryCodeREMTextField);
//		PageFunctionUtils.enterDataInWebElement(driver, countryCodeREMTextField, countryCodeREM);
//		
//		/*
//		 * String s1 = BankBen.substring(2); String s2 = BranchBen.substring(3);
//		 * 
//		 * System.out.println(s1); System.out.println(s2);
//		 * 
//		 * driver.findElement(bankBenTextField).sendKeys(s1);
//		 * 
//		 * driver.findElement(branchBenTextField).sendKeys(s2);
//		 */
//		
//		//Click Enrich Button
//		PageFunctionUtils.clickOnElement(driver, enrichButton);
//		
//		//Click Continue Button
//		PageFunctionUtils.clickOnElement(driver,continueButton);
//		
////		//Click Charge fetch button
////		PageFunctionUtils.clickOnElement(driver,chargeFetchButton);
//		
//		//Click Continue Charge button
//		PageFunctionUtils.clickOnElement(driver,continueChargeButton);
//		
//		//Submit button 
//		PageFunctionUtils.clickOnElement(driver, submitPayment);
//		
//		
//		try {
//			driver.switchTo().parentFrame();
//			PageFunctionUtils.clickOnElement(driver, submitduplicateButton);
//			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
//		} catch(Exception e) {
//			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
//		}
//		poID = driver.findElement(paymentOrderIDOutput).getText();
//	
//		return this;
//	}
//	
//	@Step("Save POID")
//	public ABECreateSTOPage saveACHPO(String paysysId, String linkedId) throws Exception {
//		if (paysysId.equals("ACH")) {
//			int rowByTcid1 = CSVUtils.getRowByTcid(Paths.Create_ACH_OutwardCsv, linkedTcidCsvColumnName, linkedId);
//			int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.Create_ACH_OutwardCsv, posCsvColumnName);
//			int rowByTcid2 = CSVUtils.getRowByTcid(Paths.Verify_ACH_Outwardcsv, tcIdCsvColumnName, linkedId);
//			int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.Verify_ACH_Outwardcsv, posCsvColumnName);
//			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.Authorize_ACH_Outwardcsv, linkedTcidCsvColumnName, linkedId);
//			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.Authorize_ACH_Outwardcsv, posCsvColumnName);
//			if(rowByTcid1 != -1 && rowByTcid2 != -1 && rowByTcid3 != -1) {
//				CSVUtils.insertValueInCsvCell(Paths.Create_ACH_OutwardCsv, rowByTcid1, columnByColumnName1, poID);
//				CSVUtils.insertValueInCsvCell(Paths.Verify_ACH_Outwardcsv, rowByTcid2, columnByColumnName2, poID);
//				CSVUtils.insertValueInCsvCell(Paths.Authorize_ACH_Outwardcsv, rowByTcid3, columnByColumnName3, poID);
//			}
//		}
//			else if(paysysId.equals("ACHUS")) {
//				int rowByTcid11 = CSVUtils.getRowByTcid(Paths.ABECreateACHUSOutwardCsv, linkedTcidCsvColumnName, linkedId);
//				int columnByColumnName11 = CSVUtils.getColumnByColumnName(Paths.ABECreateACHUSOutwardCsv, posCsvColumnName);
//				int rowByTcid22 = CSVUtils.getRowByTcid(Paths.ABEVerifyACHUSOutwardCsv, tcIdCsvColumnName, linkedId);
//				int columnByColumnName22 = CSVUtils.getColumnByColumnName(Paths.ABEVerifyACHUSOutwardCsv, posCsvColumnName);
//				int rowByTcid33 = CSVUtils.getRowByTcid(Paths.ABEAuthorizeACHUSOutwardCsv, linkedTcidCsvColumnName, linkedId);
//				int columnByColumnName33 = CSVUtils.getColumnByColumnName(Paths.ABEAuthorizeACHUSOutwardCsv, posCsvColumnName);
//				if(rowByTcid11 != -1 && rowByTcid22 != -1 && rowByTcid33 != -1) {
//					CSVUtils.insertValueInCsvCell(Paths.ABECreateACHUSOutwardCsv, rowByTcid11, columnByColumnName11, poID);
//					CSVUtils.insertValueInCsvCell(Paths.ABEVerifyACHUSOutwardCsv, rowByTcid22, columnByColumnName22, poID);
//					CSVUtils.insertValueInCsvCell(Paths.ABEAuthorizeACHUSOutwardCsv, rowByTcid33, columnByColumnName33, poID);
//				}	
//	}
//			else if(paysysId.equals("ACHER")) {
//			int rowByTcid111 = CSVUtils.getRowByTcid(Paths.ABECreateACHEROutwardCsv, linkedTcidCsvColumnName, linkedId);
//			int columnByColumnName111 = CSVUtils.getColumnByColumnName(Paths.ABECreateACHEROutwardCsv, posCsvColumnName);
//			int rowByTcid222 = CSVUtils.getRowByTcid(Paths.ABEVerifyACHEROutwardCsv, tcIdCsvColumnName, linkedId);
//			int columnByColumnName222 = CSVUtils.getColumnByColumnName(Paths.ABEVerifyACHEROutwardCsv, posCsvColumnName);
//			int rowByTcid333 = CSVUtils.getRowByTcid(Paths.ABEAuthorizeACHEROutwardCsv, linkedTcidCsvColumnName, linkedId);
//			int columnByColumnName333 = CSVUtils.getColumnByColumnName(Paths.ABEAuthorizeACHEROutwardCsv, posCsvColumnName);
//			if(rowByTcid111 != -1 && rowByTcid222 != -1 && rowByTcid333 != -1) {
//				CSVUtils.insertValueInCsvCell(Paths.ABECreateACHEROutwardCsv, rowByTcid111, columnByColumnName111, poID);
//				CSVUtils.insertValueInCsvCell(Paths.ABEVerifyACHEROutwardCsv, rowByTcid222, columnByColumnName222, poID);
//				CSVUtils.insertValueInCsvCell(Paths.ABEAuthorizeACHEROutwardCsv, rowByTcid333, columnByColumnName333, poID);
//			}
//}
//
//			else if(paysysId.equals("SWIFT")) {
//			int rowByTcid1111 = CSVUtils.getRowByTcid(Paths.ABECreateSWIFTOutwardCsv, linkedTcidCsvColumnName, linkedId);
//			int columnByColumnName1111 = CSVUtils.getColumnByColumnName(Paths.ABECreateSWIFTOutwardCsv, posCsvColumnName);
//			int rowByTcid2222 = CSVUtils.getRowByTcid(Paths.ABEVerifySWIFTOutwardCsv, tcIdCsvColumnName, linkedId);
//			int columnByColumnName2222 = CSVUtils.getColumnByColumnName(Paths.ABEVerifySWIFTOutwardCsv, posCsvColumnName);
//			int rowByTcid3333 = CSVUtils.getRowByTcid(Paths.ABEAuthorizeSWIFTOutwardCsv, linkedTcidCsvColumnName, linkedId);
//			int columnByColumnName3333 = CSVUtils.getColumnByColumnName(Paths.ABEAuthorizeSWIFTOutwardCsv, posCsvColumnName);
//			if(rowByTcid1111 != -1 && rowByTcid2222 != -1 && rowByTcid3333 != -1) {
//				CSVUtils.insertValueInCsvCell(Paths.ABECreateSWIFTOutwardCsv, rowByTcid1111, columnByColumnName1111, poID);
//				CSVUtils.insertValueInCsvCell(Paths.ABEVerifySWIFTOutwardCsv, rowByTcid2222, columnByColumnName2222, poID);
//				CSVUtils.insertValueInCsvCell(Paths.ABEAuthorizeSWIFTOutwardCsv, rowByTcid3333, columnByColumnName3333, poID);
//			}
//			}
//		
//			else if(paysysId.equals("ESWFT")) {
//				int rowByTcid11111 = CSVUtils.getRowByTcid(Paths.ABECreateESWIFTOutwardCsv, linkedTcidCsvColumnName, linkedId);
//				int columnByColumnName11111 = CSVUtils.getColumnByColumnName(Paths.ABECreateESWIFTOutwardCsv, posCsvColumnName);
//				int rowByTcid22222 = CSVUtils.getRowByTcid(Paths.ABEVerifyESWIFTOutwardCsv, tcIdCsvColumnName, linkedId);
//				int columnByColumnName22222 = CSVUtils.getColumnByColumnName(Paths.ABEVerifyESWIFTOutwardCsv, posCsvColumnName);
//				int rowByTcid33333 = CSVUtils.getRowByTcid(Paths.ABEAuthorizeESWIFTOutwardCsv, linkedTcidCsvColumnName, linkedId);
//				int columnByColumnName33333 = CSVUtils.getColumnByColumnName(Paths.ABEAuthorizeESWIFTOutwardCsv, posCsvColumnName);
//				if(rowByTcid11111 != -1 && rowByTcid22222 != -1 && rowByTcid33333 != -1) {
//					CSVUtils.insertValueInCsvCell(Paths.ABECreateESWIFTOutwardCsv, rowByTcid11111, columnByColumnName11111, poID);
//					CSVUtils.insertValueInCsvCell(Paths.ABEVerifyESWIFTOutwardCsv, rowByTcid22222, columnByColumnName22222, poID);
//					CSVUtils.insertValueInCsvCell(Paths.ABEAuthorizeESWIFTOutwardCsv, rowByTcid33333, columnByColumnName33333, poID);
//				}
//				}
//
//		return this;	
//}
//}