package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.FinacleFieldsUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABELodgeExportBillsTradeFinancePage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By billTypeTextField = By.xpath("(//input[@id='_billType'])[1]");
	private By billCcyTextField = By.xpath("(//input[@id='_billCcy'])[1]");
	private By cifIdTextField = By.xpath("(//input[@id='_cifId'])[1]");
	private By underDocumentaryCreditYesRadioButton = By.xpath("(//input[@id='_undyes1_radio'])[1]");
	private By underDocumentaryCreditNoRadioButton = By.xpath("(//input[@id='_undno1_radio'])[1]");
	private By documentaryCreditNoTextField = By.xpath("(//input[@id='_dcNo'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By operativeAccountIdTextField = By.xpath("(//input[@id='_meobgen_oppAccId'])[1]");
	private By drawerSwiftAddressDetailsYesRadioButton = By.xpath("(//input[@id='_meobgen_finyes1_radio'])[1]");
	private By drawerSwiftAddressDetailsNoRadioButton = By.xpath("(//input[@id='_meobgen_finno1_radio'])[1]");
	private By billAmountTextField = By.xpath("(//input[@id='_meobgen_boeAmt$amt'])[1]");
	private By billCountryTextField = By.xpath("(//input[@id='_meobgen_billCountry'])[1]");
	private By lodgeDateTextField = By.xpath("(//input[@id='_meobgen_lodgeDate'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_meobgen_meobgen_FinButton1'])[1]");
	private By draweeNameTextField = By.xpath("(//input[@id='_meobparty_nameDIdtl'])[1]");
	private By draweeAddressLine1TextField = By.xpath("(//input[@id='_meobparty_addr1DIdtl'])[1]");
	private By draweeSwiftAddressDetailsYesRadioButton = By.xpath("(//input[@id='_meobparty_meobparty_FinRadioButton12_radio'])[1]");
	private By draweeSwiftAddressDetailsNoRadioButton = By.xpath("(//input[@id='_meobparty_party_FinRadio21_radio'])[1]");
	private By draweeBankDetailsButton = By.xpath("(//h2[normalize-space()='Drawee Bank Details'])[1]");
	private By draweeBankAddressTypeDropDownList = By.xpath("(//select[@id='_meobparty_addrTypeDBdtl_select'])[1]");
	private By draweeBankIdentifierTextField = By.xpath("(//input[@id='_meobparty_bicDBdtl'])[1]");
	private By draweeBankSwiftAddressDetailsYesRadioButton = By.xpath("(//input[@id='_meobparty_editAdde1_radio'])[1]");
	private By draweeBankNameTextField = By.xpath("(//input[@id='_meobparty_nameDBdtl1'])[1]");
	private By draweeBankAddressLine1TextField = By.xpath("(//input[@id='_meobparty_addr1DBdtl1'])[1]");
	private By draweeBankSwiftAddressDetailsNoRadioButton = By.xpath("(//input[@id='_meobparty_meobparty_FinRadioButton21_radio'])[1]");
	private By beneficiaryBankDetailsButton = By.xpath("(//h2[normalize-space()='Beneficiary Bank Details'])[1]");
	private By beneficiaryBankAddressTypeDropDownList = By.xpath("(//select[@id='_meobparty_addrTypeBBdtl_select'])[1]");
	private By beneficiaryBankIdentifierTextField = By.xpath("(//input[@id='_meobparty_bicBBdtl'])[1]");
	private By beneficiaryBankSwiftAddressDetailsYesRadioButton = By.xpath("(//input[@id='_meobparty_meobparty_FinRadioButton13_radio'])[1]");
	private By beneficiaryBankNameTextField = By.xpath("(//input[@id='_meobparty_nameBBdtl1'])[1]");
	private By beneficiaryBankAddressLine1TextField = By.xpath("(//input[@id='_meobparty_addr1BBdtl1'])[1]");
	private By beneficiaryBankSwiftAddressDetailsNoRadioButton = By.xpath("(//input[@id='_meobparty_meobparty_FinRadioButton22_radio'])[1]");
	private By collectingBankDetailsButton = By.xpath("(//h2[normalize-space()='Collecting Bank Details'])[1]");
	private By collectingBankAddressTypeDropDownList = By.xpath("(//select[@id='_meobparty_addrTypeCBdtl_select'])[1]");
	private By collectingBankIdentifierTextField = By.xpath("(//input[@id='_meobparty_bicCBdtl'])[1]");
	private By collectingBankSwiftAddressDetailsYesRadioButton = By.xpath("(//input[@id='_meobparty_meobparty_FinRadioButton14_radio'])[1]");
	private By collectingBankNameTextField = By.xpath("(//input[@id='_meobparty_nameCBdtl1'])[1]");
	private By collectingBankAddressLine1TextField = By.xpath("(//input[@id='_meobparty_addr1CBdtl1'])[1]");
	private By collectingBankSwiftAddressDetailsNoRadioButton = By.xpath("(//input[@id='_meobparty_meobparty_FinRadioButton23_radio'])[1]");
	private By correspondentBankDetailsButton = By.xpath("(//h2[normalize-space()='Correspondent Bank Details'])[1]");
	private By correspondentBankAddressTypeDropDownList = By.xpath("(//select[@id='_meobparty_addrTypeCOBdtl_select'])[1]");
	private By correspondentBankIdentifierTextField = By.xpath("(//input[@id='_meobparty_bicCOBdtl'])[1]");
	private By correspondentBankSwiftAddressDetailsYesRadioButton = By.xpath("(//input[@id='_meobparty_meobparty_FinRadioButton15_radio'])[1]");
	private By correspondentBankNameTextField = By.xpath("(//input[@id='_meobparty_nameCOBdtl1'])[1]");
	private By correspondentBankAddressLine1TextField = By.xpath("(//input[@id='_meobparty_addr1COBdtl1'])[1]");
	private By correspondentBankSwiftAddressDetailsNoRadioButton = By.xpath("(//input[@id='_meobparty_meobparty_FinRadioButton24_radio'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_meobparty_meobparty_FinButton1'])[1]");
	private By tenorDetailsAddButton = By.xpath("(//span[@id='_tenordatagrid_AddRecBtn_label'])[1]");
	private By mixedBillAmountTextField = By.xpath("(//input[@id='_tenorBillAmt$amt'])[1]");
	private By billTenorDropDownList = By.xpath("(//select[@id='_billTenor_select'])[1]");
	private By tenorDetailsButton = By.xpath("(//a[@id='_dccrUtAmtExp$linkBtn_anchor'])[1]");
	private By dueDateIndicator1TextField = By.xpath("(//select[@id='_dcrutDueDateInd1_select'])[1]");
	public static String dueDateIndicator1;
	private By utilizedAmount1TextField = By.xpath("(//input[@id='_dcrutAmt1$amt'])[1]");
	private By dueDateIndicator2TextField = By.xpath("(//select[@id='_dcrutDueDateInd2_select'])[1]");
	public static String dueDateIndicator2;
	private By utilizedAmount2TextField = By.xpath("(//input[@id='_dcrutAmt2$amt'])[1]");
	private By acceptTenorDetailsButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private By tenorDetailsSaveAndPreviewButton = By.xpath("(//button[@id='_tenordetails_addViewSummary'])[1]");
	private By tenorDetailsEditButton = By.xpath("(//span[@class='editcontent'])[1]");
	private By tenorMonthsTextField = By.xpath("(//input[@id='_tenorMonthDays$duration1'])[1]");
	private By tenorDaysTextField = By.xpath("(//input[@id='_tenorMonthDays$duration2'])[1]");
	private By billDateTextField = By.xpath("(//input[@id='_billDate'])[1]");
	private By onboardDateTextField = By.xpath("(//input[@id='_shpmntDate'])[1]");
	private By dueDateTextField = By.xpath("(//input[@id='_dueDate'])[1]");
	private By tenorDetailsUpdateButton = By.xpath("(//button[@id='_tenordetails_updateSummary'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_meobtenor_continue'])[1]");
	private By invoiceAmountTextField = By.xpath("(//input[@id='_meobbill_invoiceAmt$amt'])[1]");
	private By invoiceNumberTextField = By.xpath("(//input[@id='_meobbill_invoiceNo'])[1]");
	private By invoiceDateTextField = By.xpath("(//input[@id='_meobbill_invoiceDate'])[1]");
	private By documentStatusDropDownList = By.xpath("(//select[@id='_meobbill_docStatus_select'])[1]");
	private By notionalConversionRateTextField = By.xpath("(//input[@id='_meobbill_notConvRateCode$rateCode'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_meobbill_meobbill_FinButton1'])[1]");
	private By closeButton1 = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By eventDetailsSideTabMenu = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By paySysIdTextField = By.xpath("(//input[@id='_meobevent_paySysId'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_meobevent_eventdet_FinButton1'])[1]");
	private By transactionDetailsSideTabMenu = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By billIdSuccessMessage = By.xpath("(//p[@id='_result_FinMessage1_paraMsg'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Lodge Export and Outward Bill'])[1]");
	public static String billId;
	public static String  referenceCsvColumnName = "reference";
	public static String  billIdCsvColumnName = "billId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	public static String  acceptLinkedTcidCsvColumnName = "acceptLinkedTcid";
	public static String  verifyAcceptLinkedTcidCsvColumnName = "verifyAcceptLinkedTcid";
	public static String  purchaseLinkedTcidCsvColumnName = "purchaseLinkedTcid";
	public static String  verifyPurchaseLinkedTcidCsvColumnName = "verifyPurchaseLinkedTcid";
	public static String  realizeLinkedTcidCsvColumnName = "realizeLinkedTcid";
	public static String  verifyRealizeLinkedTcidCsvColumnName = "verifyRealizeLinkedTcid";
	
	public ABELodgeExportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
		if(menu != null) {
			PageFunctionUtils.sleep();
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
			PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);	       
	        WebDriverWait wait = new WebDriverWait(driver, 45);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
		        }
	        catch (Exception e) {
	        	
	        }
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABELodgeExportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending bill type: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysBillTypeTextField(String billType) throws Exception {
		if(billType != null) {
			PageFunctionUtils.waitOnElement(driver, billTypeTextField);
			PageFunctionUtils.clickOnElement(driver, billTypeTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billTypeTextField, billType);
		}
		return this;
	}
	
	@Step("Sending bill ccy: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysBillCcyTextField(String billCcy) throws Exception {
		if(billCcy != null) {
			PageFunctionUtils.clickOnElement(driver, billCcyTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billCcyTextField, billCcy);
		}
		return this;
	}
	
	@Step("Sending cif id: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysCifIdTextField(String cifId) throws Exception {
		if(cifId != null) {
			PageFunctionUtils.clickOnElement(driver, cifIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifId.substring(1));
		}
		return this;
	}
	
	@Step("Press under documentary credit button")
	public ABELodgeExportBillsTradeFinancePage pressUnderDocumentaryCreditYesButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, underDocumentaryCreditYesRadioButton);
		return this;
	}
	
	@Step("Press under documentary credit button")
	public ABELodgeExportBillsTradeFinancePage pressUnderDocumentaryCreditNoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, underDocumentaryCreditNoRadioButton);
		return this;
	}
	
	@Step("Sending documentary credit no.: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysDocumentaryCreditNoTextField(String documentaryCreditNo) throws Exception {
		if(documentaryCreditNo != null) {
			PageFunctionUtils.clickOnElement(driver, documentaryCreditNoTextField);
			PageFunctionUtils.enterDataInWebElement(driver, documentaryCreditNoTextField, documentaryCreditNo.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABELodgeExportBillsTradeFinancePage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		try {
			PageFunctionUtils.clickOnElement(driver, goButton);
		} catch(Exception e) {
			
		}
		return this;
	}
	
	@Step("Sending operative account id: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysOperativeAccountIdTextField(String operativeAccountId) throws Exception {
		if(operativeAccountId != null) {
			PageFunctionUtils.clearDataInWebElement(driver, operativeAccountIdTextField);
			PageFunctionUtils.clickOnElement(driver, operativeAccountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, operativeAccountIdTextField, operativeAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Press drawer swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressDrawerSwiftAddressDetailsYesButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, drawerSwiftAddressDetailsYesRadioButton);
		return this;
	}
	
	@Step("Press drawer swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressDrawerSwiftAddressDetailsNoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, drawerSwiftAddressDetailsNoRadioButton);
		return this;
	}
	
	@Step("Sending bill amount: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysBillAmountTextField(String billAmount) throws Exception {
		if(billAmount != null) {
			PageFunctionUtils.clickOnElement(driver, billAmountTextField);
			PageFunctionUtils.clearDataInWebElement(driver, billAmountTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billAmountTextField, billAmount);
		}
		return this;
	}
	
	@Step("Sending bill country: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysBillCountryTextField(String billCountry) throws Exception {
		if(billCountry != null) {
			PageFunctionUtils.clickOnElement(driver, billCountryTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billCountryTextField, billCountry);
		}
		return this;
	}
	
	@Step("Sending lodge date: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysLodgeDateTextField(String lodgeDate) throws Exception {
		if(lodgeDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, lodgeDateTextField);
			PageFunctionUtils.clickOnElement(driver, lodgeDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, lodgeDateTextField, lodgeDate.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue1Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Sending drawee name: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysDraweeNameTextField(String draweeName) throws Exception {
		if(draweeName != null) {
			PageFunctionUtils.waitOnElement(driver, draweeNameTextField);
			PageFunctionUtils.clearDataInWebElement(driver, draweeNameTextField);
			PageFunctionUtils.clickOnElement(driver, draweeNameTextField);
			PageFunctionUtils.enterDataInWebElement(driver, draweeNameTextField, draweeName);
		}
		return this;
	}
	
	@Step("Sending drawee address line: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysDraweeAddressLine1TextField(String draweeAddressLine1) throws Exception {
		if(draweeAddressLine1 != null) {
			PageFunctionUtils.clearDataInWebElement(driver, draweeAddressLine1TextField);
			PageFunctionUtils.clickOnElement(driver, draweeAddressLine1TextField);
			PageFunctionUtils.enterDataInWebElement(driver, draweeAddressLine1TextField, draweeAddressLine1);
		}
		return this;
	}
	
	@Step("Press drawee swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressDraweeSwiftAddressDetailsYesButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, draweeSwiftAddressDetailsYesRadioButton);
		return this;
	}
	
	@Step("Press drawee swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressDraweeSwiftAddressDetailsNoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, draweeSwiftAddressDetailsNoRadioButton);
		return this;
	}
	
	@Step("Press drawee bank details button")
	public ABELodgeExportBillsTradeFinancePage pressDraweeBankDetailsButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, draweeBankDetailsButton);
		return this;
	}
	
	@Step("Select drawee bank address type")
	public ABELodgeExportBillsTradeFinancePage selectDraweeBankAddressTypeBankIdentifier() throws Exception {
		PageFunctionUtils.waitOnElement(driver, draweeBankAddressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, draweeBankAddressTypeDropDownList, FinacleFieldsUtils.ADDRESSTYPEBANKIDENTIFIER);
		return this;
	}
	
	@Step("Select drawee bank address type")
	public ABELodgeExportBillsTradeFinancePage selectDraweeBankAddressTypeNameAndAddress() throws Exception {
		PageFunctionUtils.waitOnElement(driver, draweeBankAddressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, draweeBankAddressTypeDropDownList, FinacleFieldsUtils.ADDRESSTYPENAMEANDADDRESS);
		return this;
	}
	
	@Step("Sending drawee bank identifier: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysDraweeBankIdentifierTextField(String draweeBankIdentifier) throws Exception {
		if(draweeBankIdentifier != null) {
			PageFunctionUtils.clearDataInWebElement(driver, draweeBankIdentifierTextField);
			PageFunctionUtils.clickOnElement(driver, draweeBankIdentifierTextField);
			PageFunctionUtils.enterDataInWebElement(driver, draweeBankIdentifierTextField, draweeBankIdentifier.substring(1));
		}
		return this;
	}
	
	@Step("Sending drawee bank name: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysDraweeBankNameTextField(String draweeBankName) throws Exception {
		if(draweeBankName != null) {
			PageFunctionUtils.waitOnElement(driver, draweeBankNameTextField);
			PageFunctionUtils.clearDataInWebElement(driver, draweeBankNameTextField);
			PageFunctionUtils.clickOnElement(driver, draweeBankNameTextField);
			PageFunctionUtils.enterDataInWebElement(driver, draweeBankNameTextField, draweeBankName);
		}
		return this;
	}
	
	@Step("Sending drawee bank address line: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysDraweeBankAddressLine1TextField(String draweeBankAddressLine1) throws Exception {
		if(draweeBankAddressLine1 != null) {
			PageFunctionUtils.clearDataInWebElement(driver, draweeBankAddressLine1TextField);
			PageFunctionUtils.clickOnElement(driver, draweeBankAddressLine1TextField);
			PageFunctionUtils.enterDataInWebElement(driver, draweeBankAddressLine1TextField, draweeBankAddressLine1);
		}
		return this;
	}
	
	@Step("Press drawee bank swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressDraweeBankSwiftAddressDetailsYesButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, draweeBankSwiftAddressDetailsYesRadioButton);
		return this;
	}
	
	@Step("Press drawee bank swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressDraweeBankSwiftAddressDetailsNoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, draweeBankSwiftAddressDetailsNoRadioButton);
		return this;
	}
	
	@Step("Press beneficiary bank details button")
	public ABELodgeExportBillsTradeFinancePage pressBeneficiaryBankDetailsButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, beneficiaryBankDetailsButton);
		return this;
	}
	
	@Step("Select beneficiary bank address type")
	public ABELodgeExportBillsTradeFinancePage selectBeneficiaryBankAddressTypeBankIdentifier() throws Exception {
		PageFunctionUtils.waitOnElement(driver, beneficiaryBankAddressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, beneficiaryBankAddressTypeDropDownList, FinacleFieldsUtils.ADDRESSTYPEBANKIDENTIFIER);
		return this;
	}
	
	@Step("Select beneficiary bank address type")
	public ABELodgeExportBillsTradeFinancePage selectBeneficiaryBankAddressTypeNameAndAddress() throws Exception {
		PageFunctionUtils.waitOnElement(driver, beneficiaryBankAddressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, beneficiaryBankAddressTypeDropDownList, FinacleFieldsUtils.ADDRESSTYPENAMEANDADDRESS);
		return this;
	}
	
	@Step("Sending beneficiary bank identifier: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysBeneficiaryBankIdentifierTextField(String beneficiaryBankIdentifier) throws Exception {
		if(beneficiaryBankIdentifier != null) {
			PageFunctionUtils.clearDataInWebElement(driver, beneficiaryBankIdentifierTextField);
			PageFunctionUtils.clickOnElement(driver, beneficiaryBankIdentifierTextField);
			PageFunctionUtils.enterDataInWebElement(driver, beneficiaryBankIdentifierTextField, beneficiaryBankIdentifier.substring(1));
		}
		return this;
	}
	
	@Step("Sending beneficiary bank name: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysBeneficiaryBankNameTextField(String beneficiaryBankName) throws Exception {
		if(beneficiaryBankName != null) {
			PageFunctionUtils.waitOnElement(driver, beneficiaryBankNameTextField);
			PageFunctionUtils.clearDataInWebElement(driver, beneficiaryBankNameTextField);
			PageFunctionUtils.clickOnElement(driver, beneficiaryBankNameTextField);
			PageFunctionUtils.enterDataInWebElement(driver, beneficiaryBankNameTextField, beneficiaryBankName);
		}
		return this;
	}
	
	@Step("Sending beneficiary bank address line: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysBeneficiaryBankAddressLine1TextField(String beneficiaryBankAddressLine1) throws Exception {
		if(beneficiaryBankAddressLine1 != null) {
			PageFunctionUtils.clearDataInWebElement(driver, beneficiaryBankAddressLine1TextField);
			PageFunctionUtils.clickOnElement(driver, beneficiaryBankAddressLine1TextField);
			PageFunctionUtils.enterDataInWebElement(driver, beneficiaryBankAddressLine1TextField, beneficiaryBankAddressLine1);
		}
		return this;
	}
	
	@Step("Press beneficiary bank swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressBeneficiaryBankSwiftAddressDetailsYesButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, beneficiaryBankSwiftAddressDetailsYesRadioButton);
		return this;
	}
	
	@Step("Press beneficiary bank swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressBeneficiaryBankSwiftAddressDetailsNoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, beneficiaryBankSwiftAddressDetailsNoRadioButton);
		return this;
	}
	
	@Step("Press collecting bank details button")
	public ABELodgeExportBillsTradeFinancePage pressCollectingBankDetailsButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, collectingBankDetailsButton);
		return this;
	}
	
	@Step("Select collecting bank address type")
	public ABELodgeExportBillsTradeFinancePage selectCollectingBankAddressTypeBankIdentifier() throws Exception {
		PageFunctionUtils.waitOnElement(driver, collectingBankAddressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, collectingBankAddressTypeDropDownList, FinacleFieldsUtils.ADDRESSTYPEBANKIDENTIFIER);
		return this;
	}
	
	@Step("Select collecting bank address type")
	public ABELodgeExportBillsTradeFinancePage selectCollectingBankAddressTypeNameAndAddress() throws Exception {
		PageFunctionUtils.waitOnElement(driver, collectingBankAddressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, collectingBankAddressTypeDropDownList, FinacleFieldsUtils.ADDRESSTYPENAMEANDADDRESS);
		return this;
	}
	
	@Step("Sending collecting bank identifier: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysCollectingBankIdentifierTextField(String collectingBankIdentifier) throws Exception {
		if(collectingBankIdentifier != null) {
			PageFunctionUtils.clearDataInWebElement(driver, collectingBankIdentifierTextField);
			PageFunctionUtils.clickOnElement(driver, collectingBankIdentifierTextField);
			PageFunctionUtils.enterDataInWebElement(driver, collectingBankIdentifierTextField, collectingBankIdentifier.substring(1));
		}
		return this;
	}
	
	@Step("Sending collecting bank name: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysCollectingBankNameTextField(String collectingBankName) throws Exception {
		if(collectingBankName != null) {
			PageFunctionUtils.waitOnElement(driver, collectingBankNameTextField);
			PageFunctionUtils.clearDataInWebElement(driver, collectingBankNameTextField);
			PageFunctionUtils.clickOnElement(driver, collectingBankNameTextField);
			PageFunctionUtils.enterDataInWebElement(driver, collectingBankNameTextField, collectingBankName);
		}
		return this;
	}
	
	@Step("Sending collecting bank address line: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysCollectingBankAddressLine1TextField(String collectingBankAddressLine1) throws Exception {
		if(collectingBankAddressLine1 != null) {
			PageFunctionUtils.clearDataInWebElement(driver, collectingBankAddressLine1TextField);
			PageFunctionUtils.clickOnElement(driver, collectingBankAddressLine1TextField);
			PageFunctionUtils.enterDataInWebElement(driver, collectingBankAddressLine1TextField, collectingBankAddressLine1);
		}
		return this;
	}
	
	@Step("Press collecting bank swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressCollectingBankSwiftAddressDetailsYesButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, collectingBankSwiftAddressDetailsYesRadioButton);
		return this;
	}
	
	@Step("Press collecting bank swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressCollectingBankSwiftAddressDetailsNoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, collectingBankSwiftAddressDetailsNoRadioButton);
		return this;
	}
	
	@Step("Press correspondent bank details button")
	public ABELodgeExportBillsTradeFinancePage pressCorrespondentBankDetailsButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, correspondentBankDetailsButton);
		return this;
	}
	
	@Step("Select correspondent bank address type")
	public ABELodgeExportBillsTradeFinancePage selectCorrespondentBankAddressTypeBankIdentifier() throws Exception {
		PageFunctionUtils.waitOnElement(driver, correspondentBankAddressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, correspondentBankAddressTypeDropDownList, FinacleFieldsUtils.ADDRESSTYPEBANKIDENTIFIER);
		return this;
	}
	
	@Step("Select correspondent bank address type")
	public ABELodgeExportBillsTradeFinancePage selectCorrespondentBankAddressTypeNameAndAddress() throws Exception {
		PageFunctionUtils.waitOnElement(driver, correspondentBankAddressTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, correspondentBankAddressTypeDropDownList, FinacleFieldsUtils.ADDRESSTYPENAMEANDADDRESS);
		return this;
	}
	
	@Step("Sending correspondent bank identifier: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysCorrespondentBankIdentifierTextField(String correspondentBankIdentifier) throws Exception {
		if(correspondentBankIdentifier != null) {
			PageFunctionUtils.clearDataInWebElement(driver, correspondentBankIdentifierTextField);
			PageFunctionUtils.clickOnElement(driver, correspondentBankIdentifierTextField);
			PageFunctionUtils.enterDataInWebElement(driver, correspondentBankIdentifierTextField, correspondentBankIdentifier.substring(1));
		}
		return this;
	}
	
	@Step("Sending correspondent bank name: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysCorrespondentBankNameTextField(String correspondentBankName) throws Exception {
		if(correspondentBankName != null) {
			PageFunctionUtils.waitOnElement(driver, correspondentBankNameTextField);
			PageFunctionUtils.clearDataInWebElement(driver, correspondentBankNameTextField);
			PageFunctionUtils.clickOnElement(driver, correspondentBankNameTextField);
			PageFunctionUtils.enterDataInWebElement(driver, correspondentBankNameTextField, correspondentBankName);
		}
		return this;
	}
	
	@Step("Sending correspondent bank address line: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysCorrespondentBankAddressLine1TextField(String correspondentBankAddressLine1) throws Exception {
		if(correspondentBankAddressLine1 != null) {
			PageFunctionUtils.clearDataInWebElement(driver, correspondentBankAddressLine1TextField);
			PageFunctionUtils.clickOnElement(driver, correspondentBankAddressLine1TextField);
			PageFunctionUtils.enterDataInWebElement(driver, correspondentBankAddressLine1TextField, correspondentBankAddressLine1);
		}
		return this;
	}
	
	@Step("Press correspondent bank swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressCorrespondentBankSwiftAddressDetailsYesButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, correspondentBankSwiftAddressDetailsYesRadioButton);
		return this;
	}
	
	@Step("Press correspondent bank swift address details button")
	public ABELodgeExportBillsTradeFinancePage pressCorrespondentBankSwiftAddressDetailsNoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, correspondentBankSwiftAddressDetailsNoRadioButton);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue2Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Press tenor details edit button")
	public ABELodgeExportBillsTradeFinancePage pressTenorDetailsEditButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsEditButton);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsEditButton);
		return this;
	}
	
	@Step("Press tenor details add button")
	public ABELodgeExportBillsTradeFinancePage pressTenorDetailsAddButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsAddButton);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsAddButton);
		return this;
	}
	
	@Step("Sending mixed bill amount: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysMixedBillAmountTextField(String mixedBillAmount) throws Exception {
		if(mixedBillAmount != null) {
			try {
				PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
			}
			catch(Exception e) {
				
			}
			PageFunctionUtils.waitOnElement(driver, mixedBillAmountTextField);
			PageFunctionUtils.clickOnElement(driver, mixedBillAmountTextField);
			PageFunctionUtils.enterDataInWebElement(driver, mixedBillAmountTextField, mixedBillAmount);
		}
		return this;
	}
	
	@Step("Select bill tenor")
	public ABELodgeExportBillsTradeFinancePage selectBillTenorSight() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, billTenorDropDownList, FinacleFieldsUtils.BILLTENORSIGHT);
		return this;
	}
	
	@Step("Select bill tenor")
	public ABELodgeExportBillsTradeFinancePage selectBillTenorUsance() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, billTenorDropDownList, FinacleFieldsUtils.BILLTENORUSANCE);
		return this;
	}
	
	@Step("Press tenor details button")
	public ABELodgeExportBillsTradeFinancePage pressTenorDetailsButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsButton);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsButton);
		try {
			PageFunctionUtils.clickOnElement(driver, tenorDetailsButton);
		} catch(Exception e) {
			
		}
		return this;
	}
	
	@Step("Get due date indicator")
	public String getTextdueDateIndicator1TextField() throws InterruptedException {
		PageFunctionUtils.switchToParentFrame(driver);
		dueDateIndicator1 = PageFunctionUtils.getDropDownListSelectedValue(driver, dueDateIndicator1TextField);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return dueDateIndicator1;
	}
	
	@Step("Get due date indicator")
	public String getTextdueDateIndicator2TextField() throws InterruptedException {
		PageFunctionUtils.switchToParentFrame(driver);
		dueDateIndicator2 = PageFunctionUtils.getDropDownListSelectedValue(driver, dueDateIndicator2TextField);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return dueDateIndicator2;
	}
	
	@Step("Sending utilized amount: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysUtilizedAmount1TextField(String utilizedAmount) throws Exception {
		if(utilizedAmount != null) {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.waitOnElement(driver, utilizedAmount1TextField);
			PageFunctionUtils.clearDataInWebElement(driver, utilizedAmount1TextField);
			PageFunctionUtils.clickOnElement(driver, utilizedAmount1TextField);
			PageFunctionUtils.enterDataInWebElement(driver, utilizedAmount1TextField, utilizedAmount);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Sending utilized amount: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysUtilizedAmount2TextField(String utilizedAmount) throws Exception {
		if(utilizedAmount != null) {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.waitOnElement(driver, utilizedAmount2TextField);
			PageFunctionUtils.clearDataInWebElement(driver, utilizedAmount2TextField);
			PageFunctionUtils.clickOnElement(driver, utilizedAmount2TextField);
			PageFunctionUtils.enterDataInWebElement(driver, utilizedAmount2TextField, utilizedAmount);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Press accept tenor details button")
	public ABELodgeExportBillsTradeFinancePage pressAcceptTenorDetailsButton() throws Exception {
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnElement(driver, acceptTenorDetailsButton);
		PageFunctionUtils.clickOnElement(driver, acceptTenorDetailsButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.waitOnElement(driver, acceptTenorDetailsButton);
			PageFunctionUtils.clickOnElement(driver, acceptTenorDetailsButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		} catch(Exception e) {
			
		}
		return this;
	}
	
	@Step("Sending tenor months: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysTenorMonthsTextField(String tenorMonths) throws Exception {
		if(tenorMonths != null) {
			PageFunctionUtils.waitOnElement(driver, tenorMonthsTextField);
			PageFunctionUtils.clickOnElement(driver, tenorMonthsTextField);
			PageFunctionUtils.enterDataInWebElement(driver, tenorMonthsTextField, tenorMonths);
		}
		return this;
	}
	
	@Step("Sending tenor days: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysTenorDaysTextField(String tenorDays) throws Exception {
		if(tenorDays != null) {
			PageFunctionUtils.waitOnElement(driver, tenorDaysTextField);
			PageFunctionUtils.clickOnElement(driver, tenorDaysTextField);
			PageFunctionUtils.enterDataInWebElement(driver, tenorDaysTextField, tenorDays);
		}
		return this;
	}
	
	@Step("Sending bill date: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysBillDateTextField(String billDate) throws Exception {
		if(billDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, billDateTextField);
			PageFunctionUtils.clickOnElement(driver, billDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billDateTextField, billDate.substring(1));
		}
		return this;
	}
	
	@Step("Sending onboard date: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysOnboardDateTextField(String onboardDate) throws Exception {
		if(onboardDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, onboardDateTextField);
			PageFunctionUtils.clickOnElement(driver, onboardDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, onboardDateTextField, onboardDate.substring(1));
		}
		return this;
	}
	
	@Step("Sending due date: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysDueDateTextField(String dueDate) throws Exception {
		if(dueDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, dueDateTextField);
			PageFunctionUtils.clickOnElement(driver, dueDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, dueDateTextField, dueDate.substring(1));
		}
		return this;
	}
	
	@Step("Press tenor details update button")
	public ABELodgeExportBillsTradeFinancePage pressTenorDetailsUpdateButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsUpdateButton);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsUpdateButton);
		return this;
	}
	
	@Step("Press tenor details save and preview button")
	public ABELodgeExportBillsTradeFinancePage pressTenorDetailsSaveAndPreviewButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsSaveAndPreviewButton);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsSaveAndPreviewButton);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue3Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue3Button);
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Sending invoice amount: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysInvoiceAmountTextField(String invoiceAmount) throws Exception {
		if(invoiceAmount != null) {
			PageFunctionUtils.waitOnElement(driver, invoiceAmountTextField);
			PageFunctionUtils.clickOnElement(driver, invoiceAmountTextField);
			PageFunctionUtils.clearDataInWebElement(driver, invoiceAmountTextField);
			PageFunctionUtils.enterDataInWebElement(driver, invoiceAmountTextField, invoiceAmount);
		}
		return this;
	}
	
	@Step("Sending invoice number: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysInvoiceNumberTextField(String invoiceNumber) throws Exception {
		if(invoiceNumber != null) {
			PageFunctionUtils.clickOnElement(driver, invoiceNumberTextField);
			PageFunctionUtils.enterDataInWebElement(driver, invoiceNumberTextField, invoiceNumber);
		}
		return this;
	}
	
	@Step("Sending invoice date: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysInvoiceDateTextField(String invoiceDate) throws Exception {
		if(invoiceDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, invoiceDateTextField);
			PageFunctionUtils.clickOnElement(driver, invoiceDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, invoiceDateTextField, invoiceDate.substring(1));
		}
		return this;
	}
	
	@Step("Select document status")
	public ABELodgeExportBillsTradeFinancePage selectDocumentStatusClean() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, documentStatusDropDownList, FinacleFieldsUtils.DOCUMENTSTATUSCLEAN);
		return this;
	}
	
	@Step("Select document status")
	public ABELodgeExportBillsTradeFinancePage selectDocumentStatusDiscrepant() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, documentStatusDropDownList, FinacleFieldsUtils.DOCUMENTSTATUSDISCREPANT);
		return this;
	}
	
	@Step("Select document status")
	public ABELodgeExportBillsTradeFinancePage selectDocumentStatusDiscrepantAndAccepted() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, documentStatusDropDownList, FinacleFieldsUtils.DOCUMENTSTATUSDISCREPANTANDACCEPTED);
		return this;
	}
	
	@Step("Select document status")
	public ABELodgeExportBillsTradeFinancePage selectDocumentStatusReturned() throws Exception {
		PageFunctionUtils.selectDropDownListByVisibleText(driver, documentStatusDropDownList, FinacleFieldsUtils.DOCUMENTSTATUSRETURNED);
		return this;
	}
	
	@Step("Sending notional conversion rate: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysNotionalConversionRateTextField(String notionalConversionRate) throws Exception {
		if(notionalConversionRate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, notionalConversionRateTextField);
			PageFunctionUtils.clickOnElement(driver, notionalConversionRateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, notionalConversionRateTextField, notionalConversionRate.substring(1));
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue4Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue4Button);
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		return this;
	}
	
	@Step("Side tab navigation")
	public ABELodgeExportBillsTradeFinancePage navigateEventDetailsSideTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, eventDetailsSideTabMenu);
		PageFunctionUtils.clickOnElement(driver, eventDetailsSideTabMenu);
		return this;
	}
	
	@Step("Side tab navigation")
	public ABELodgeExportBillsTradeFinancePage navigateTransactionDetailsSideTabMenu() throws Exception {
		PageFunctionUtils.waitOnElement(driver, transactionDetailsSideTabMenu);
		PageFunctionUtils.clickOnElement(driver, transactionDetailsSideTabMenu);
		return this;
	}
	
	@Step("Sending paysys id: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysPaySysIdTextField(String paySysId) throws Exception {
		if(paySysId != null) {
			PageFunctionUtils.waitOnElement(driver, paySysIdTextField);
			PageFunctionUtils.clickOnElement(driver, paySysIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, paySysIdTextField, paySysId);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue5Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue5Button);
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton1);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Press submit button")
	public ABELodgeExportBillsTradeFinancePage pressSubmitButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, submitButton);
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.waitOnElement(driver, billIdSuccessMessage);
		billId = driver.findElement(billIdSuccessMessage).getText().substring(45);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
	
	@Step("Save bill id")
	public ABELodgeExportBillsTradeFinancePage saveBillId(String linkedId, String acceptLinkedTcid, String verifyAcceptLinkedTcid, String purchaseLinkedTcid, String verifyPurchaseLinkedTcid, String realizeLinkedTcid, String verifyRealizeLinkedTcid) throws Exception {
		if(linkedId != null) {
			int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, linkedTcidCsvColumnName, linkedId);
			int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYLODGEEXPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, linkedId);
			int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, referenceCsvColumnName);
			int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYLODGEEXPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);		
			if(rowByTcid1 != -1 && rowByTcid2 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, rowByTcid1, columnByColumnName1, billId);
				CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYLODGEEXPORTBILLSTRADEFINANCECSV, rowByTcid2, columnByColumnName2, billId);
			}
		}
		
		if(acceptLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, acceptLinkedTcidCsvColumnName, acceptLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEACCEPTEXPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, acceptLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEACCEPTEXPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEACCEPTEXPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyAcceptLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, verifyAcceptLinkedTcidCsvColumnName, verifyAcceptLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.ABEVERIFYACCEPTEXPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyAcceptLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYACCEPTEXPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACCEPTEXPORTBILLSTRADEFINANCECSV, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		
		if(purchaseLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, purchaseLinkedTcidCsvColumnName, purchaseLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEPURCHASEEXPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, purchaseLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEPURCHASEEXPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEPURCHASEEXPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyPurchaseLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, verifyPurchaseLinkedTcidCsvColumnName, verifyPurchaseLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.ABEVERIFYPURCHASEEXPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyPurchaseLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYPURCHASEEXPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYPURCHASEEXPORTBILLSTRADEFINANCECSV, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		
		if(realizeLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, realizeLinkedTcidCsvColumnName, realizeLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEREALIZEEXPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, realizeLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEREALIZEEXPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.ABEREALIZEEXPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyRealizeLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.ABELODGEEXPORTBILLSTRADEFINANCECSV, verifyRealizeLinkedTcidCsvColumnName, verifyRealizeLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.ABEVERIFYREALIZEEXPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyRealizeLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYREALIZEEXPORTBILLSTRADEFINANCECSV, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYREALIZEEXPORTBILLSTRADEFINANCECSV, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		return this;
	}
}