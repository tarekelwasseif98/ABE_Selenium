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
	private By tenorDetailsSaveAndPreviewButton = By.xpath("(//button[@id='_tenordetails_addViewSummary'])[1]");
	private By tenorDetailsEditButton = By.xpath("(//span[@class='editcontent'])[1]");
	private By tenorMonthsTextField = By.xpath("(//input[@id='_tenorMonthDays$duration1'])[1]");
	private By tenorDaysTextField = By.xpath("(//input[@id='_tenorMonthDays$duration2'])[1]");
	private By billDateTextField = By.xpath("(//input[@id='_billDate'])[1]");
	private By onboardDateTextField = By.xpath("(//input[@id='_shpmntDate'])[1]");
	private By tenorDetailsUpdateButton = By.xpath("(//button[@id='_tenordetails_updateSummary'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_meobtenor_continue'])[1]");
	private By invoiceAmountTextField = By.xpath("(//input[@id='_meobbill_invoiceAmt$amt'])[1]");
	private By invoiceNumberTextField = By.xpath("(//input[@id='_meobbill_invoiceNo'])[1]");
	private By invoiceDateTextField = By.xpath("(//input[@id='_meobbill_invoiceDate'])[1]");
	private By notionalConversionRateTextField = By.xpath("(//input[@id='_meobbill_notConvRateCode$rateCode'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_meobbill_meobbill_FinButton1'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_meobassign_FinButton1'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_margin_margin_Continue'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_meoblimit_meoblimit_FinButton1'])[1]");
	private By closeButton = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_meobhca_homeccyadv_FinButton1'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_meobpur_meobpur_FinButton1'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_meobpreship_meobpreship_continue'])[1]");
	private By continue11Button = By.xpath("(//button[@id='_meobreal_meobreal_FinButton1'])[1]");
	private By paySysIdTextField = By.xpath("(//input[@id='_meobevent_paySysId'])[1]");
	private By continue12Button = By.xpath("(//button[@id='_meobevent_eventdet_FinButton1'])[1]");
	private By continue13Button = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
	private By continue14Button = By.xpath("(//button[@id='_dclatercharge_charge_Continue'])[1]");
	private By continue15Button = By.xpath("(//button[@id='_meobtran_meobtran_FinButton1'])[1]");
	private By continue16Button = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
	private By continue17Button = By.xpath("(//button[@id='_meobtracer_tracerdet_FinButton1'])[1]");
	private By continue18Button = By.xpath("(//button[@id='_meobmisc_meobmisc_FinButton1'])[1]");
	private By continue19Button = By.xpath("(//button[@id='_meobaddn_meobaddn_FinButton1'])[1]");
	private By continue20Button = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
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
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifId);
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
		return this;
	}
	
	@Step("Sending operative account id: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysOperativeAccountIdTextField(String operativeAccountId) throws Exception {
		if(operativeAccountId != null) {
			PageFunctionUtils.waitOnElement(driver, operativeAccountIdTextField);
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
			PageFunctionUtils.clickOnElement(driver, draweeNameTextField);
			PageFunctionUtils.enterDataInWebElement(driver, draweeNameTextField, draweeName);
		}
		return this;
	}
	
	@Step("Sending drawee address line: {0}")
	public ABELodgeExportBillsTradeFinancePage sendKeysDraweeAddressLine1TextField(String draweeAddressLine1) throws Exception {
		if(draweeAddressLine1 != null) {
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
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue5Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue5Button);
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue6Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue6Button);
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue7Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue7Button);
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue8Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue8Button);
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue9Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue9Button);
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue10Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue10Button);
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue11Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue11Button);
		PageFunctionUtils.clickOnElement(driver, continue11Button);
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
	public ABELodgeExportBillsTradeFinancePage pressContinue12Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue12Button);
		PageFunctionUtils.clickOnElement(driver, continue12Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue13Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue13Button);
		PageFunctionUtils.clickOnElement(driver, continue13Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue14Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue14Button);
		PageFunctionUtils.clickOnElement(driver, continue14Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue15Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue15Button);
		PageFunctionUtils.clickOnElement(driver, continue15Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue16Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue16Button);
		PageFunctionUtils.clickOnElement(driver, continue16Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue17Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue17Button);
		PageFunctionUtils.clickOnElement(driver, continue17Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue18Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue18Button);
		PageFunctionUtils.clickOnElement(driver, continue18Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue19Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue19Button);
		PageFunctionUtils.clickOnElement(driver, continue19Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABELodgeExportBillsTradeFinancePage pressContinue20Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue20Button);
		PageFunctionUtils.clickOnElement(driver, continue20Button);
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
			int rowByTcid1 = CSVUtils.getRowByTcid(Paths.LodgeExportBillsCsv, linkedTcidCsvColumnName, linkedId);
			int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyLodgeExportBillsCsv, tcIdCsvColumnName, linkedId);
			int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.LodgeExportBillsCsv, referenceCsvColumnName);
			int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyLodgeExportBillsCsv, billIdCsvColumnName);		
			if(rowByTcid1 != -1 && rowByTcid2 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.LodgeExportBillsCsv, rowByTcid1, columnByColumnName1, billId);
				CSVUtils.insertValueInCsvCell(Paths.VerifyLodgeExportBillsCsv, rowByTcid2, columnByColumnName2, billId);
			}
		}
		
		if(acceptLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.LodgeExportBillsCsv, acceptLinkedTcidCsvColumnName, acceptLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.AcceptExportBillsCsv, tcIdCsvColumnName, acceptLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.AcceptExportBillsCsv, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.AcceptExportBillsCsv, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyAcceptLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.LodgeExportBillsCsv, verifyAcceptLinkedTcidCsvColumnName, verifyAcceptLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.VerifyAcceptExportBillsCsv, tcIdCsvColumnName, verifyAcceptLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.VerifyAcceptExportBillsCsv, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.VerifyAcceptExportBillsCsv, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		
		if(purchaseLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.LodgeExportBillsCsv, purchaseLinkedTcidCsvColumnName, purchaseLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.PurchaseExportBillsCsv, tcIdCsvColumnName, purchaseLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.PurchaseExportBillsCsv, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.PurchaseExportBillsCsv, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyPurchaseLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.LodgeExportBillsCsv, verifyPurchaseLinkedTcidCsvColumnName, verifyPurchaseLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.VerifyPurchaseExportBillsCsv, tcIdCsvColumnName, verifyPurchaseLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.VerifyPurchaseExportBillsCsv, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.VerifyPurchaseExportBillsCsv, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		
		if(realizeLinkedTcid != null) {
			int rowByTcid3 = CSVUtils.getRowByTcid(Paths.LodgeExportBillsCsv, realizeLinkedTcidCsvColumnName, realizeLinkedTcid);
			int rowByTcid4 = CSVUtils.getRowByTcid(Paths.RealizeExportBillsCsv, tcIdCsvColumnName, realizeLinkedTcid);
			int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.RealizeExportBillsCsv, billIdCsvColumnName);
			if(rowByTcid3 != -1 && rowByTcid4 != -1) {
				CSVUtils.insertValueInCsvCell(Paths.RealizeExportBillsCsv, rowByTcid4, columnByColumnName3, billId);
			}
			if(verifyRealizeLinkedTcid != null) {
				int rowByTcid5 = CSVUtils.getRowByTcid(Paths.LodgeExportBillsCsv, verifyRealizeLinkedTcidCsvColumnName, verifyRealizeLinkedTcid);
				int rowByTcid6 = CSVUtils.getRowByTcid(Paths.VerifyRealizeExportBillsCsv, tcIdCsvColumnName, verifyRealizeLinkedTcid);
				int columnByColumnName5 = CSVUtils.getColumnByColumnName(Paths.VerifyRealizeExportBillsCsv, billIdCsvColumnName);
				if(rowByTcid5 != -1 && rowByTcid6 != -1) {
					CSVUtils.insertValueInCsvCell(Paths.VerifyRealizeExportBillsCsv, rowByTcid6, columnByColumnName5, billId);
				}
			}
		}
		return this;
	}
}