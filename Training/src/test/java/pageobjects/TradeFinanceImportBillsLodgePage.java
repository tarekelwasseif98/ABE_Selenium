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

public class TradeFinanceImportBillsLodgePage {
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By cifTextField = By.xpath("(//input[@id='_cifId'])[1]");
	private By billTypeTextField = By.xpath("(//input[@id='_billType'])[1]");
	private By billCcyTextField= By.xpath("(//input[@id='_billCcy'])[1]");
	private By warning1 = By.xpath("//div[@id='finErrorPopup']//span[@id='modalCloseIcon'];");
	private By warning2 = By.id("//div[@id='finErrorPopup']");
	private By warning3 = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By warning4 = By.xpath("(//span[@id='modalCloseIcon'])[2]");
	private By underDocumentryCreditNoRadioButton = By.xpath("(//input[@id='_undno1_radio'])[1]");
	private By underDocumentryCreditYesRadioButton = By.xpath("(//input[@id='_undyes1_radio'])[1]");
	private By documentCreditNumberTextField = By.xpath("(//input[@id='_dcNo'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By operativeAcIdTextField = By.xpath("(//input[@id='_miibgen_oppAccId'])[1]");
	private By generalDetailsContinueButton = By.xpath("(//button[@id='_miibgen_miibgen_FinButton1'])[1]");
	private By billAmtTextField = By.xpath("(//input[@id='_miibgen_boeAmt$amt'])[1]");
	private By mixedBillAmtTextField = By.xpath("(//input[@id='_tenorBillAmt$amt'])[1]");
	private By lodgeDateField = By.xpath("(//input[@id='_miibgen_lodgeDate'])[1]");
	private By billCountryTextField = By.xpath("(//input[@id='_miibgen_billCountry'])[1]");
	private By otherBankRefNumTextField = By.xpath("(//input[@id='_miibgen_otherBankRefNo'])[1]");
	private By nameTextField = By.xpath("(//input[@id='_meobparty_nameDIdtl'])[1]");
	private By adress1TextField = By.xpath("(//input[@id='_meobparty_addr1DIdtl'])[1]");
	private By editButton = By.xpath("//a[@id='_tenordatagrid_editIcon_0']//span[@class='editcontent']");
	private By billDateField = By.xpath("(//input[@id='_billDate'])[1]");
	private By onboardDateField = By.xpath("(//input[@id='_shpmntDate'])[1]");
	private By partyDetailsContinueButton = By.xpath("(//button[@id='_meobparty_meobparty_FinButton1'])[1]");
	private By tenorDetailsContinueButton = By.xpath("(//button[@id='_meobtenor_continue'])[1]"); 
	private By invoiceAmtTextField = By.xpath("(//input[@id='_miibbill_invoiceAmt$amt'])[1]");
	private By monthTextField = By.xpath("(//input[@id='_tenorMonthDays$duration1'])[1]");
	private By dayTextField = By.xpath("(//input[@id='_tenorMonthDays$duration2'])[1]");
	private By tenorAddButton = By.xpath("(//span[@id='_tenordatagrid_AddRecBtn_label'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By updateButton = By.xpath("(//button[@id='_tenordetails_updateSummary'])[1]");
	private By billTenorDropDown = By.xpath("(//select[@id='_billTenor_select'])[1]");
	private By saveAndAddNewButton = By.xpath("(//button[@id='_tenordetails_addCreateNew'])[1]");
	private By saveAndPreviewButton =By.xpath("(//button[@id='_tenordetails_addViewSummary'])[1]");
	private By span2 = By.id("fbmevent_textSpan");
	private By span3 = By.id("tfccharge_textSpan");	
	private By span4 = By.id("fbmtran_textSpan");
	private By rateTextField = By.xpath("(//input[@id='_miibbill_notConvRateCode$rateCode'])[1]");
	public static String billId;
	private By accountIdSuccessMessage = By.id("_result_FinMessage1_paraMsg");
	public static String  referenceCsvColumnName = "reference";
	public static String  billIdCsvColumnName = "billId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	public static String  acceptLinkedTcidCsvColumnName = "acceptLinkedTcid";
	public static String  verifyAcceptLinkedTcidCsvColumnName = "verifyAcceptLinkedTcid";
	public static String  realizeLinkedTcidCsvColumnName = "realizeLinkedTcid";
	public static String  verifyRealizeLinkedTcidCsvColumnName = "verifyRealizeLinkedTcid";

	public TradeFinanceImportBillsLodgePage(WebDriver driver) {
		this.driver = driver;
	}
	

	@Step("Sending menu name: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public TradeFinanceImportBillsLodgePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		
		return this;	
	}
	
	@Step("Sending Cif: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysCif(String cif) throws Exception {

		PageFunctionUtils.waitOnElement(driver, cifTextField);
		PageFunctionUtils.clickOnElement(driver,cifTextField);
		PageFunctionUtils.enterDataInWebElement(driver,cifTextField,cif.substring(1));
		return this;
	}
	@Step("Sending doc credit number: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysDocumentCreditNum(String documentCreditNumber) throws Exception {

		PageFunctionUtils.clickOnElement(driver,documentCreditNumberTextField);
		PageFunctionUtils.enterDataInWebElement(driver,documentCreditNumberTextField,documentCreditNumber.substring(1));
		return this;
	}
	
	@Step("Sending bill type: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysBillType(String billType) throws Exception {

		PageFunctionUtils.clickOnElement(driver,billTypeTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billTypeTextField,billType);
		return this;
	}
	
	@Step("Sending bill Ccy: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysBillCcy(String billCcy) throws Exception {
        PageFunctionUtils.waitOnElement(driver, billCcyTextField);
		PageFunctionUtils.clickOnElement(driver,billCcyTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billCcyTextField,billCcy);
		return this;
	}
	
	@Step("Sending rate: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysRate(String rateCode) throws Exception {
		if(rateCode != null) {
		PageFunctionUtils.clickOnElement(driver,rateTextField);
		PageFunctionUtils.enterDataInWebElement(driver,rateTextField,rateCode);
	}
		return this;
	
	}
	
	@Step("Press on side tabs")
	public TradeFinanceImportBillsLodgePage PressSideTabs() throws Exception {
	

		
		
		PageFunctionUtils.clickOnElement(driver,span2);


		PageFunctionUtils.clickOnElement(driver,span3);
		PageFunctionUtils.clickOnElement(driver,span4);
		
		
		return this;
	}
	

	
	@Step("Press under Documentry Credit No Radio Button")
	public TradeFinanceImportBillsLodgePage PressunderDocumentryCreditNoRadioButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,underDocumentryCreditNoRadioButton);
		return this;
	}
	
	@Step("Press under Documentry Credit yes Radio Button")
	public TradeFinanceImportBillsLodgePage PressunderDocumentryCreditYesRadioButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,underDocumentryCreditYesRadioButton);
		return this;
	}
	
	@Step("Press go Button")
	public TradeFinanceImportBillsLodgePage PressGoButton() throws Exception {
		try {
		PageFunctionUtils.clickOnElement(driver,goButton);
		} catch(Exception e) {
			PageFunctionUtils.clickOnElement(driver,goButton);

		}
		return this;
	}
	@Step("Press update Button")
	public TradeFinanceImportBillsLodgePage PressUpdateButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,updateButton);
		return this;
	}
	
	@Step("Sending operative account Id: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysOperativeAcId(String operativeAcId) throws Exception {

		PageFunctionUtils.clickOnElement(driver,operativeAcIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,operativeAcIdTextField,operativeAcId.substring(1));
		return this;
	}
	
	@Step("Sending bill amount: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysBillAmount(String billAmount) throws Exception {

		PageFunctionUtils.clickOnElement(driver,billAmtTextField);
		PageFunctionUtils.clearDataInWebElement(driver, billAmtTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billAmtTextField,billAmount);
		return this;
	}
	@Step("Sending mixed bill amount: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysMixedBillAmount(String billAmount) throws Exception {

		PageFunctionUtils.clickOnElement(driver,mixedBillAmtTextField);
		PageFunctionUtils.clearDataInWebElement(driver, mixedBillAmtTextField);
		PageFunctionUtils.enterDataInWebElement(driver,mixedBillAmtTextField,billAmount);
		return this;
	}
	
	@Step("Sending lodge date: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysLodgeDate(String lodgeDate) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, lodgeDateField);
		PageFunctionUtils.clickOnElement(driver,lodgeDateField);
		PageFunctionUtils.enterDataInWebElement(driver,lodgeDateField,lodgeDate);
		return this;
	}
	
	@Step("Sending onboard date: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysOnboardDate(String onboardDate) throws Exception {

		PageFunctionUtils.clearDataInWebElement(driver, onboardDateField);
		PageFunctionUtils.clickOnElement(driver,onboardDateField);

		PageFunctionUtils.enterDataInWebElement(driver,onboardDateField,onboardDate);
		return this;
	}
	
	@Step("Sending bill date: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysBillDate(String billDate) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, billDateField);
		PageFunctionUtils.clickOnElement(driver,billDateField);
		PageFunctionUtils.enterDataInWebElement(driver,billDateField,billDate);
		return this;
	}
	

	@Step("Sending bill country: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysBillCountry(String billCountry) throws Exception {

		PageFunctionUtils.clickOnElement(driver,billCountryTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billCountryTextField,billCountry);
		return this;
	}
	
	@Step("Sending other bank ref number: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysOtherBankRefNum(String otherBankRefNum) throws Exception {

		PageFunctionUtils.clickOnElement(driver,otherBankRefNumTextField);
		PageFunctionUtils.enterDataInWebElement(driver,otherBankRefNumTextField,otherBankRefNum);
		return this;
	}
	
	@Step("Press general details continue button")
	public TradeFinanceImportBillsLodgePage PressGeneralDetailsContinueButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,generalDetailsContinueButton);
		return this;
	}
	
	@Step("Add mixed-sight bill tenor")
	public TradeFinanceImportBillsLodgePage addBill1Tenor(String billAmount, String billType, String onboardDate, String billDate) throws Exception {
		sendKeysMixedBillAmount(billAmount);
		PageFunctionUtils.selectDropDownListByIndex(driver, billTenorDropDown, 1);
		sendKeysOnboardDate(onboardDate);
		sendKeysBillDate(billDate);
		PageFunctionUtils.clickOnElement(driver, saveAndAddNewButton);
		
		return this;
	}
	
	@Step("Add mixed-usance bill tenor")
	public TradeFinanceImportBillsLodgePage addBill2Tenor(String billAmount, String billType,String month, String day, String onboardDate, String billDate) throws Exception {
		sendKeysMixedBillAmount(billAmount);
		PageFunctionUtils.selectDropDownListByIndex(driver, billTenorDropDown, 2);
		sendKeysTenor(month, day);
		sendKeysOnboardDate(onboardDate);
		sendKeysBillDate(billDate);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewButton);
		
		return this;
	}
	
	@Step("Press edit button")
	public TradeFinanceImportBillsLodgePage PressEditButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,editButton);
		return this;
	}
	@Step("Press tenor add button")
	public TradeFinanceImportBillsLodgePage PressTenorAddButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,tenorAddButton);
		return this;
	}
	
	@Step("Sending tenor: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysTenor(String month, String day) throws Exception {
		PageFunctionUtils.clearDataInWebElement(driver, monthTextField);
		PageFunctionUtils.clickOnElement(driver,monthTextField);
		PageFunctionUtils.enterDataInWebElement(driver,monthTextField,month);
		PageFunctionUtils.clearDataInWebElement(driver, dayTextField);
		PageFunctionUtils.clickOnElement(driver,dayTextField);
		PageFunctionUtils.enterDataInWebElement(driver,dayTextField,day);
		return this;
	}
	
	
	@Step("Press party Details Continue button")
	public TradeFinanceImportBillsLodgePage PressPartyDetailsContinueButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,partyDetailsContinueButton);
		return this;
	}
	@Step("Press tenor Details Continue button")
	public TradeFinanceImportBillsLodgePage PressTenorDetailsContinueButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,tenorDetailsContinueButton);
		return this;
	}
	
	@Step("Sending name: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysinvoiceAmtTextField(String invoiceAmount) throws Exception {

		PageFunctionUtils.clickOnElement(driver,invoiceAmtTextField);
		PageFunctionUtils.clearDataInWebElement(driver, invoiceAmtTextField);
		PageFunctionUtils.enterDataInWebElement(driver,invoiceAmtTextField,invoiceAmount);
		return this;
	}
	
	@Step("Sending name: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysName(String name) throws Exception {

		PageFunctionUtils.clickOnElement(driver,nameTextField);
		PageFunctionUtils.enterDataInWebElement(driver,nameTextField,name);
		return this;
	}
	
	@Step("Sending name: {0}")
	public TradeFinanceImportBillsLodgePage sendKeysAdress1(String adress1) throws Exception {

		PageFunctionUtils.clickOnElement(driver,adress1TextField);
		PageFunctionUtils.enterDataInWebElement(driver,adress1TextField,adress1);
		return this;
	}
	
	@Step("Press submit button")
	public TradeFinanceImportBillsLodgePage PressSubmitButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,submitButton);
		PageFunctionUtils.acceptWarning(driver);
		billId = driver.findElement(accountIdSuccessMessage).getText().substring(45);
		System.out.println("bill Id: "+ billId);
		return this;
	}

	
	@Step("Save a/c. id")
	public TradeFinanceImportBillsLodgePage saveAccountId(String linkedId, String acceptLinkedTcid, String verifyAcceptLinkedTcid, String realizeLinkedTcid, String verifyRealizeLinkedTcid) throws Exception {
	
		  if(linkedId != null) {

              int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, linkedTcidCsvColumnName, linkedId);

              int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, tcIdCsvColumnName, linkedId);
              
              int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, referenceCsvColumnName);

              int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, billIdCsvColumnName);           
              
              
              if(rowByTcid1 != -1 && rowByTcid2 != -1) {

                     CSVUtils.insertValueInCsvCell(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, rowByTcid1, columnByColumnName1, billId);

                     CSVUtils.insertValueInCsvCell(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, rowByTcid2, columnByColumnName2, billId);

              }

       }
		if(acceptLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, acceptLinkedTcidCsvColumnName, acceptLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, acceptLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyAcceptLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, verifyAcceptLinkedTcidCsvColumnName, verifyAcceptLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyAcceptLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		
	
		if(realizeLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, realizeLinkedTcidCsvColumnName, realizeLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, realizeLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyRealizeLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, verifyRealizeLinkedTcidCsvColumnName, verifyRealizeLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyRealizeLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		return this;
	}		
}
