package pageobjects;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.PythonParser.return_stmt_return;

import com.aspose.diagram.Page;
import com.aspose.psd.system.Threading.Thread;
import com.google.common.util.concurrent.ExecutionError;

import freemarker.core.ReturnInstruction.Return;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABECreateRetailCustomerPage {

	private WebDriver driver;

	// Search bar Elements
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By htmlDataFrmIFrameXpath = By.xpath("//frame[@name='HTMLDataFrm'][1]");
	private By crmABEIFrameXpath = By.xpath("//iframe[@name='CRM_ABE'][1]");
	private By loginFrameIframeXpath = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By adminButton = By.xpath("(//input[@id='login_Admin'])[1]");

	// Perform Duplicate Check Elements
	private By submitAdminButton = By.xpath("(//input[@id='submitBtn'])[1]");
	private By docTypeDropDownList = By.xpath("(//select[@id='_dedup_idCode_select'])[1]");
	private By docNumberTextField = By.xpath("(//input[@id='_dedup_IDNo'])[1]");
	private By cifSubtypeDropDownList = By.xpath("(//select[@id='_dEntype_select'])[1]");
	private By closedCIFsearchButton = By.xpath("(//button[normalize-space()='Closed CIF Search'])[1]");
	private By xbuttoncloseNoMatchFound = By.xpath("(//i[@class='material-icons'][normalize-space()='close'])[1]");
	private By performDedupButton = By.xpath("(//button[normalize-space()='Perform Dedup'])[1]");
	private By goButton = By.xpath("//button[@id='_bGo']");

	// Basic Details Elements
	private By salutationDropdownList = By.xpath("(//select[@id='_dSalt_select'])[1]");
	private By genderDropdownList = By.xpath("(//select[@id='_dGender_select'])[1]");
	private By dateOfBirthTextField = By.xpath("(//input[@id='_dDob'])[1]");
	private By closeISCOREcheckButton = By.xpath("(//i[@class='material-icons'][normalize-space()='close'])[1]");
	private By iSCORECheckButton = By.xpath("(//button[normalize-space()='IScore Check'])[1]");
	private By firstNameARtextField = By.xpath("(//input[@id='_tFrstname'])[1]");
	private By middleNameARtextField = By.xpath("(//input[@id='_tMdleName'])[1]");
	private By lastNameARtextField = By.xpath("(//input[@id='_tLstName'])[1]");
	private By firstNameENtextField = By.xpath("(//input[@id='_altfirsname'])[1]");
	private By middleNameENtextField = By.xpath("(//input[@id='_altmidname'])[1]");
	private By lastNameENtextField = By.xpath("(//input[@id='_altlastname'])[1]");
	private By idSummaryEditButton = By.xpath("(//i[@class='material-icons'][normalize-space()='edit'])[1]");

	// ID Summary Elements
	private By docSummaryCode = By.xpath("(//input[@id='_docCode'])[1]");
	private By idPrimaryDropDownList = By.xpath("(//select[@id='_preferred_select'])[1]");
	private By nationalityCustomerTextField = By.xpath("(//input[@id='_sNationality'])[1]");
	private By countryOfIssueTextField = By.xpath("(//input[@id='_country'])[1]");
	private By issueDateDocSummaryTextField = By.xpath("(//input[@id='_issuedt'])[1]");
	private By expiryDateSummaryTextField = By.xpath("(//input[@id='_expirydt'])[1]");
	private By updateButtonIDSummary = By.xpath("(//button[normalize-space()='Update'])[1]");

	// Address Section Elements
	private By addAddressButton = By.xpath(
			"//button[@id='_dgrd_addrsdet_AddRecBtn_label']//i[@class='material-icons'][normalize-space()='add_circle']");
	private By addressLine1TextField = By.xpath("(//input[@id='_pgaddressdet_crmaddress$freeTextAddress1'])[1]");
	private By cityAddressTextField = By.xpath("(//input[@id='_pgaddressdet_crmaddress$otherDetailsCity'])[1]");
	private By governorateTextField = By.xpath("(//input[@id='_pgaddressdet_crmaddress$otherDetailsState'])[1]");
	private By countryCodeAddressTextField = By.xpath("(//input[@id='_pgaddressdet_crmaddress$otherDetailsCountry'])[1]");
	private By editAddressIconButton = By.xpath("(//i[@class='material-icons'][normalize-space()='edit'])[4]");
	private By saveAndPreviewAddressDetailsButton = By.xpath("//button[@id='_pgaddressdet_addViewSummary']");

	// Document Summary
	private By addbuttonIDSummaryList = By.xpath("(//i[@class='material-icons'][normalize-space()='add_circle'])[1]");
	private By docCodeTextField = By.xpath("(//input[@id='_docCode'])[1]");
	private By issueDateIDRecord = By.xpath("(//input[@id='_issuedt'])[1]");
	private By expiryDateIDRecord = By.xpath("(//input[@id='_expirydt'])[1]");
	// Phone and Email Summary
	private By addButtonPhoneandEmail = By.xpath(
			"//button[@id='_dgr_phemail_AddRecBtn_label']//i[@class='material-icons'][normalize-space()='add_circle']");
	private By phoneTypeDropDownList = By.xpath("(//select[@id='_phtype_select'])[1]");
	private By phoneNumberTextField = By.xpath("(//input[@id='_phno'])[1]");
	private By saveAndPreviewPhoneAndEmailDetailsButton = By.xpath("//button[@id='_pgphemail_addViewSummary']");
	private By saveAndPreviewDetailsButton = By.xpath("(//button[normalize-space()='Save and Preview'])[1]");

	// Other Details Page Elements
	private By motherMaidenNameTextField = By.xpath("(//input[@id='_tMotherName'])[1]");
	private By motherFirstNameTextField = By.xpath("(//input[@id='_motherfrstname'])[1]");
	private By maritalstatusDropDownList = By.xpath("(//select[@id='_dMaristat_select'])[1]");
	private By employmentDetailsSubMenuButton = By.xpath("(//h3[normalize-space()='Employment Details'])[1]");
	private By customerTypeDropDownList = By.xpath("(//select[@id='_dEmplyStatus_select'])[1]");
	private By bankEmployeeRadioButton = By.xpath("(//input[@id='_otherdet_bankempy_radio'])[1]");
	private By bankEmployeeIDTextField = By.xpath("(//input[@id='_otherdet_bankempid'])[1]");

	// Other Details
	// Residential Details Elements
	private By residentialDetailsSubMenuButton = By.xpath("(//h3[normalize-space()='Residential Details'])[1]");
	private By residencyStatusDropDownList = By.xpath("(//select[@id='_residencyDetail_select'])[1]");
	private By fnrFlagDropDownList = By.xpath("(//select[@id='_dNRI_select'])[1]");
	private By resindencExpiryDateText = By.xpath("(//input[@id='_dTRO'])[1]");
	private By residenceCountryTextField = By.xpath("(//input[@id='_resCountryCust'])[1]");
	private By continueOtherDetailsButton = By.xpath("//button[@id='_rcreateOtherCont']");

	// Additional Details Elements
	private By segmentTypetextField = By.xpath("(//input[@id='_segCust'])[1]");
	private By subSegmentTypeTextField = By.xpath("(//input[@id='_subSegCust'])[1]");

	// CIF Message Element
	private By continueButtonCREATE = By.xpath("//button[@id='_bContinue']");
	private By saveAndENRICHButton = By.xpath("//button[@id='_bmSavenEnrch']");
	private By cifSUCCESSMessage = By.xpath("(//p[@id='_successenrchmsg_paraMsg'])[1]");
	private By proceedToEnrichButton = By.xpath("(//button[normalize-space()='Proceed to Enrich'])[1]");

	// Enrich Elements
	// Basic Details at General Details
	private By generalDetailsButtonlinkENRICH = By.xpath("(//a[@id='_custlink_gd_link'])[1]");
	private By placeofBirthTextFeildENRICH = By.xpath("(//input[@id='_placeOfBirth'])[1]");
	private By amlButtonScreenCheckENRICH = By.xpath("//button[@id='_bAml']");
	private By amlXButtonENRICH = By.xpath("//a[@id='_closeDialog']//i[@class='material-icons'][normalize-space()='close']");
	private By bankStatmentInstructionDropDownListENRICH = By.xpath("(//select[@id='_statement_select'])[1]");
	private By bankStatmentFreqDropDownListENRICH = By.xpath("(//select[@id='_accsplinst_select'])[1]");
	private By emailDropDownListENRICH = By.xpath("(//select[@id='_prefemailtype_select'])[1]");
	private By addemailPluseButtonENRICH = By.xpath("//button[@id='_dg_phemail_AddRecBtn_label']//i[@class='material-icons'][normalize-space()='add_circle']");
	private By emailRadioButtonENRICH = By.xpath("(//input[@id='_emailchannel_radio'])[1]");
	private By emailTypeDropDownListENRICH = By.xpath("(//select[@id='_emailtype_select'])[1]");
	private By emailTextFieldENRICH = By.xpath("(//input[@id='_emailid'])[1]");
	private By saveAndPreviewEmailButtonENRICH = By.xpath("//button[@id='_pgphoneemail_addViewSummary']");
	private By continueBasicDetailsButtonENRICH = By.xpath("//button[@id='_btncontinue']");
	private By continueButtonENRICH = By.xpath("(//button[normalize-space()='Continue'])[1]");
	
	// Other details at General Details
	private By emplomentDetailsSubMenuENRICH = By.xpath("(//h3[normalize-space()='Employment Details'])[1]");
	private By politicalOccupationList1ENRICH = By.xpath("(//select[@id='_acctnumb_select'])[1]");
	private By politicalOccupationList2ENRICH = By.xpath("(//select[@id='_jointtype_select'])[1]");
	private By dataIncomeUnemployedTextFieldENRICH = By.xpath("(//textarea[@id='_moredetails_textArea'])[1]");

	// ABE Specific at General Details
	private By poaDropDownListENRICH = By.xpath("(//select[@id='_poa_select'])[1]");
	private By accOpenPurposeDropDownListENRICH = By.xpath("(//select[@id='_accntOpngPurps_select'])[1]");
	private By correspondenceInstructionsDropDownListENRICH = By.xpath("(//select[@id='_deliveryflg_select'])[1]");
	private By payrollFlagDropDownListENRICH = By.xpath("(//select[@id='_payrollflg_select'])[1]");
	private By companyCustomerIDENRICH = By.xpath("(//input[@id='_cmpnyCustID'])[1]");

	// Risk Details at General Details
	private By countryDealingSearchIconENRICH = By.xpath("(//i[@id='_countryofdealing$searcher_image'])[1]");
	private By categoryCodecountryDealingTextFieldENRICH = By.xpath("(//input[@id='_cat_code'])[1]");
	private By searchCategorycountryDealingButtonENRICH = By.xpath("(//button[normalize-space()='Search'])[1]");
	private By checkBoxcountryDealingButtonENRICH = By.xpath("(//div[@role='checkbox'])[1]");
	private By selectButtoncountryDealingENRICH = By.xpath("(//button[normalize-space()='Select'])[1]");
	private By okCountryDealingButtonENRICH = By.xpath("(//button[normalize-space()='OK'])[1]");

	// PEP Details at Risk Details at at General Details
	private By pepDropDownListENRICH = By.xpath("(//select[@id='_pepflg_select'])[1]");
	private By calculateRiskButtonENRICH = By.xpath("(//button[normalize-space()='Calculate Risk'])[1]");
	private By hrrCompliantENRICH = By.xpath("(//select[@id='_hrrcomp_select'])[1]");
	private By pepTextField1ENRICH = By.xpath("(//textarea[@id='_risk1_textArea'])[1]");
	private By pepTextField2ENRICH = By.xpath("(//textarea[@id='_risk2_textArea'])[1]");
	private By pepTextField3ENRICH = By.xpath("(//input[@id='_risk3'])[1]");
	private By pepTextField4ENRICH = By.xpath("(//input[@id='_risk10'])[1]");
	private By pepTextField5ENRICH = By.xpath("(//input[@id='_risk8'])[1]");
	private By pepTextField6ENRICH = By.xpath("(//input[@id='_risk6'])[1]");
	private By pepNumberField7ENRICH = By.xpath("(//input[@id='_risk4$amt'])[1]");
	private By pepNumberField8ENRICH = By.xpath("(//input[@id='_risk5$amt'])[1]");
	private By pepNumberField9ENRICH = By.xpath("(//input[@id='_risk7$amt'])[1]");
	private By pepNumberField10ENRICH = By.xpath("(//input[@id='_risk9$amt'])[1]");
	private By pepTextField11ENRICH = By.xpath("(//input[@id='_pep1'])[1]");
	private By pepTextField12ENRICH = By.xpath("(//input[@id='_pep2'])[1]");
	private By pepTextField13ENRICH = By.xpath("(//input[@id='_pep3'])[1]");
	private By pepTextField14ENRICH = By.xpath("(//input[@id='_pep4'])[1]");
	private By pepTextField15ENRICH = By.xpath("(//input[@id='_pep5'])[1]");
	private By pepDateTextField16ENRICH = By.xpath("(//input[@id='_pep6'])[1]");

	// FATCA Details at General Details
	private By fatcaDropDownList1ENRICH = By.xpath("(//select[@id='_othrNat_select'])[1]");
	private By fatcaDropDownList2ENRICH = By.xpath("(//select[@id='_othrCntry_select'])[1]");
	private By fatcaDropDownList3ENRICH = By.xpath("(//select[@id='_rsdnt_select'])[1]");
	private By fatcaDropDownList4ENRICH = By.xpath("(//select[@id='_fatcacomp_select'])[1]");
   
	//bank defined Details 
	private By bankDefinedDetailsButtonENRICH = By.xpath("(//a[@id='_custlink_bd_link'])[1]");
	private By saveAndValidateBankDefinedDetailsButtonENRICH = By.xpath("//button[@id='_bSavenVal']");
	private By additionalDetailsButtonENRICH = By.xpath("//a[@id='_custlink_ad_link'])[1])");
	
	//Financial Details 
	private By continueFinancialDetailsButtonENRICH = By.xpath("//button[@id='_asset_BtnContinue']");
	private By depositeAmountFinanicalDetailsTextFieldENRICH = By.xpath("(//input[@id='_initDeposit$amt'])[1]");
	private By financeDetailsDropdownList1ENRICH = By.xpath("(//select[@id='_incomebrakt_select'])[1]");
	private By financeDetailsDropdownList2ENRICH = By.xpath("(//select[@id='_sourceinitfnd_select'])[1]");
	private By financeDetailsDropdownList3ENRICH = By.xpath("(//select[@id='_sourceofincome_select'])[1]");
	private By financeDetailsDropdownList4ENRICH = By.xpath("(//select[@id='_sourceoffunds_select'])[1])");
	private By financeDetailsButtonENRICH = By.xpath("(//a[@id='_custlink_fd_link'])[1]");
	private By saveAndValidateFinancialDetailsButtonENRICH = By.xpath("//button[@id='_bsaveandVal']");
	private By viewSummaryFinancialDetailsButtonENRICH = By.xpath("//button[@id='_success_FinButnViewSumry']");
	private By viewSummaryButtonENRICH = By.xpath("(//button[normalize-space()='View Summary'])[1]");
	private By submitButtonENRICH = By.xpath("(//button[@id='_submit'])[1]");
	private String linkedTcidCsvColumnName = "linkedTcid";
	private String tcIdCsvColumnName = "tcId";
	private String cifCsvColumnName = "CIF";
	private String cif;

	public ABECreateRetailCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Sending menu name: {0}")
	public ABECreateRetailCustomerPage sendKeysSearchBarTextField(String menu) throws Exception {
		driver.switchTo().parentFrame();
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeXpath);
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

	@Step("Select Admin View")
	public ABECreateRetailCustomerPage openRetailCustomerFristPage(String docType, String docNumber) throws Exception {
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeXpath);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, crmABEIFrameXpath);
		PageFunctionUtils.clickOnElement(driver, adminButton);
		PageFunctionUtils.clickOnElement(driver, submitAdminButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, htmlDataFrmIFrameXpath);
		PageFunctionUtils.waitOnElement(driver, docTypeDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, docTypeDropDownList, docType);
		PageFunctionUtils.clickOnElement(driver, docNumberTextField);
		PageFunctionUtils.enterDataInWebElement(driver, docNumberTextField, docNumber.substring(1));
		PageFunctionUtils.selectDropDownListByIndex(driver, cifSubtypeDropDownList, 1);
		PageFunctionUtils.clickOnElement(driver, closedCIFsearchButton);
		PageFunctionUtils.clickOnElement(driver, xbuttoncloseNoMatchFound);
		PageFunctionUtils.clickOnElement(driver, performDedupButton);
		PageFunctionUtils.sleep2();
		PageFunctionUtils.clickOnElement(driver, goButton);

		return this;
	}

	@Step("Select Basic Details")
	public ABECreateRetailCustomerPage fillBasicDetailsPASSPORT(String DOB) throws Exception {
		PageFunctionUtils.waitOnElement(driver, salutationDropdownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, salutationDropdownList, 1);
		PageFunctionUtils.selectDropDownListByIndex(driver, genderDropdownList, 1);
		PageFunctionUtils.enterDataInWebElement(driver, dateOfBirthTextField, DOB.substring(1));
		return this;
	}

	@Step("ISCORE Check")
	public ABECreateRetailCustomerPage iScoreCheck() throws Exception {
		PageFunctionUtils.waitOnElement(driver, iSCORECheckButton);
		PageFunctionUtils.clickOnElement(driver, iSCORECheckButton);
		PageFunctionUtils.clickOnElement(driver, closeISCOREcheckButton);
		return this;
	}

	@Step("Enter AR Customer Name")
	public ABECreateRetailCustomerPage enterARCustomerName(String firstARname, String midARname, String lastARname)
			throws Exception {
		PageFunctionUtils.clickOnElement(driver, firstNameARtextField);
		driver.findElement(firstNameARtextField).sendKeys("مراد");
		// PageFunctionUtils.enterDataInWebElement(driver, firstNameARtextField,
		// firstARname);
		PageFunctionUtils.clickOnElement(driver, middleNameARtextField);
		driver.findElement(middleNameARtextField).sendKeys("مراد");
		// PageFunctionUtils.enterDataInWebElement(driver, middleNameARtextField,
		// midARname);
		PageFunctionUtils.clickOnElement(driver, lastNameARtextField);
		driver.findElement(lastNameARtextField).sendKeys("مراد");
		// PageFunctionUtils.enterDataInWebElement(driver, lastNameARtextField,
		// lastARname);
		return this;
	}

	@Step("Enter EN Customer Name")
	public ABECreateRetailCustomerPage enterENCustomerName(String firstENname, String midENname, String lastENname)
			throws Exception {
		PageFunctionUtils.enterDataInWebElement(driver, firstNameENtextField, firstENname);
		PageFunctionUtils.enterDataInWebElement(driver, middleNameENtextField, midENname);
		PageFunctionUtils.enterDataInWebElement(driver, lastNameENtextField, lastENname);
		return this;
	}

	@Step("Enter Nationality")
	public ABECreateRetailCustomerPage enterNationalityOfCustomer(String nationalityCustomer) throws Exception {
		PageFunctionUtils.clickOnElement(driver, nationalityCustomerTextField);
		PageFunctionUtils.enterDataInWebElement(driver, nationalityCustomerTextField, nationalityCustomer);
		return this;
	}

	@Step("Add ID Summary")
	public ABECreateRetailCustomerPage addIDCustomer(String docCode, String docNumber, String idPrimaryStatus,
			String issueDateIDSummary, String expiryDateIDSummary) throws Exception {
		PageFunctionUtils.clickOnElement(driver, addbuttonIDSummaryList);
		PageFunctionUtils.waitOnElement(driver, docCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver, docCodeTextField, docCode);
		PageFunctionUtils.enterDataInWebElement(driver, docNumberTextField, docNumber);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, idPrimaryDropDownList, idPrimaryStatus);
		PageFunctionUtils.clickOnElement(driver, issueDateIDRecord);
		PageFunctionUtils.enterDataInWebElement(driver, issueDateIDRecord, issueDateIDSummary);
		PageFunctionUtils.enterDataInWebElement(driver, expiryDateIDRecord, expiryDateIDSummary);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewDetailsButton);
		return this;
	}

	@Step("Edit ID Summary")
	public ABECreateRetailCustomerPage editIDsummary(String countryOfIssueSummary, String issueDateIDSummary,
			String expiryDateIDSummary) throws Exception {
		PageFunctionUtils.clickOnElement(driver, idSummaryEditButton);
		PageFunctionUtils.waitOnElement(driver, docSummaryCode);
		PageFunctionUtils.enterDataInWebElement(driver, countryOfIssueTextField, countryOfIssueSummary);
		PageFunctionUtils.enterDataInWebElement(driver, issueDateDocSummaryTextField, issueDateIDSummary);
		PageFunctionUtils.enterDataInWebElement(driver, expiryDateSummaryTextField, expiryDateIDSummary);
		PageFunctionUtils.clickOnElement(driver, updateButtonIDSummary);
		return this;
	}

	@Step("Add Address Customer")
	public ABECreateRetailCustomerPage addAddressCustomer(String addressLine1, String cityAddress, String governorate,
			String country) throws Exception {

		PageFunctionUtils.clickOnElement(driver, addAddressButton);
		PageFunctionUtils.waitOnElement(driver, addressLine1TextField);
		PageFunctionUtils.enterDataInWebElement(driver, addressLine1TextField, addressLine1);
		PageFunctionUtils.enterDataInWebElement(driver, cityAddressTextField, cityAddress.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, governorateTextField, governorate.substring(1));
		PageFunctionUtils.enterDataInWebElement(driver, countryCodeAddressTextField, country);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewAddressDetailsButton);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewAddressDetailsButton);
		return this;
	}

	@Step("Edit Address")
	public ABECreateRetailCustomerPage editAddressCustomer(String addressLine1, String cityAddress, String governorate,
			String country) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.clickOnElement(driver, editAddressIconButton);
		PageFunctionUtils.clickOnElement(driver, addressLine1TextField);
		PageFunctionUtils.clearDataInWebElement(driver, addressLine1TextField);
		PageFunctionUtils.enterDataInWebElement(driver, addressLine1TextField, addressLine1);
		PageFunctionUtils.clickOnElement(driver, cityAddressTextField);
		PageFunctionUtils.clearDataInWebElement(driver, cityAddressTextField);
		PageFunctionUtils.enterDataInWebElement(driver, cityAddressTextField, cityAddress.substring(1));
		PageFunctionUtils.clickOnElement(driver, governorateTextField);
		PageFunctionUtils.clearDataInWebElement(driver, governorateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, governorateTextField, governorate.substring(1));
		PageFunctionUtils.clickOnElement(driver, countryCodeAddressTextField);
		PageFunctionUtils.clearDataInWebElement(driver, countryCodeAddressTextField);
		PageFunctionUtils.enterDataInWebElement(driver, countryCodeAddressTextField, country);
		PageFunctionUtils.clickOnElement(driver, updateButtonIDSummary);
		return this;
	}

	@Step("Add Phone & Email Summary")
	public ABECreateRetailCustomerPage addPhoneAndEmailSummary(String phoneNumber) throws Exception {
		try {
			PageFunctionUtils.clickOnElement(driver, addButtonPhoneandEmail);
		} catch (Exception e) {
			PageFunctionUtils.clickOnElement(driver, addButtonPhoneandEmail);
		}
		PageFunctionUtils.waitOnElement(driver, phoneTypeDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, phoneTypeDropDownList, 1);
		PageFunctionUtils.enterDataInWebElement(driver, phoneNumberTextField, phoneNumber.substring(1));
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewPhoneAndEmailDetailsButton);
		return this;
	}

	@Step("Continue")
	public ABECreateRetailCustomerPage continueBasicDetailsButton() throws Exception {
		PageFunctionUtils.sleep2();
		PageFunctionUtils.clickOnElement(driver, continueButtonCREATE);
		return this;
	}

	@Step("Continue")
	public ABECreateRetailCustomerPage continueOtherDetailsButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continueOtherDetailsButton);
		return this;
	}

	@Step("Personal Details")
	public ABECreateRetailCustomerPage fillPersonalDetails(String motherMaidenName, String motherFirstname)
			throws Exception {
		PageFunctionUtils.waitOnElement(driver, motherMaidenNameTextField);
		PageFunctionUtils.clickOnElement(driver, motherMaidenNameTextField);
		PageFunctionUtils.enterDataInWebElement(driver, motherMaidenNameTextField, motherMaidenName);
		PageFunctionUtils.enterDataInWebElement(driver, motherFirstNameTextField, motherFirstname);
		PageFunctionUtils.selectDropDownListByIndex(driver, maritalstatusDropDownList, 1);
		return this;
	}

	@Step("Employment Details")
	public ABECreateRetailCustomerPage fillEmploymentDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver, employmentDetailsSubMenuButton);
		PageFunctionUtils.waitOnElement(driver, customerTypeDropDownList);
		PageFunctionUtils.selectDropDownListByIndex(driver, customerTypeDropDownList, 5);
		return this;
	}

	@Step("Bank Employee")
	public ABECreateRetailCustomerPage selectBankEmployeeRadioButton(String bankEmployeeID) throws Exception {
		PageFunctionUtils.clickOnElement(driver, employmentDetailsSubMenuButton);
		PageFunctionUtils.clickOnElement(driver, bankEmployeeRadioButton);
		PageFunctionUtils.clickOnElement(driver, bankEmployeeIDTextField);
		PageFunctionUtils.enterDataInWebElement(driver, bankEmployeeIDTextField, bankEmployeeID.substring(1));
		return this;
	}

	@Step("Residential Details")
	public ABECreateRetailCustomerPage fillResidentialDetails(String residencyStatus, String resindencExpiryDate,
			String residenceCountry) throws Exception {
		PageFunctionUtils.clickOnElement(driver, residentialDetailsSubMenuButton);
		PageFunctionUtils.waitOnElement(driver, residencyStatusDropDownList);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, residencyStatusDropDownList, residencyStatus);
		PageFunctionUtils.selectDropDownListByIndex(driver, fnrFlagDropDownList, 2);
		PageFunctionUtils.clickOnElement(driver, resindencExpiryDateText);
		PageFunctionUtils.enterDataInWebElement(driver, resindencExpiryDateText, resindencExpiryDate.substring(1));
		PageFunctionUtils.clearDataInWebElement(driver, residenceCountryTextField);
		PageFunctionUtils.enterDataInWebElement(driver, residenceCountryTextField, residenceCountry);
		return this;
	}

	@Step("Segment Type")
	public ABECreateRetailCustomerPage addSegmentTypeRetailCustomer(String segment, String subSegment)
			throws Exception {
		PageFunctionUtils.waitOnElement(driver, segmentTypetextField);
		PageFunctionUtils.enterDataInWebElement(driver, segmentTypetextField, segment);
		PageFunctionUtils.enterDataInWebElement(driver, subSegmentTypeTextField, subSegment);
		return this;
	}

	@Step("Save and Enrich")
	public ABECreateRetailCustomerPage saveAndEnrich() throws Exception {
		PageFunctionUtils.clickOnElement(driver, saveAndENRICHButton);
		PageFunctionUtils.clickOnElement(driver, saveAndENRICHButton);
		cif = driver.findElement(cifSUCCESSMessage).getText().substring(42);
		System.out.println("CIF: " + cif);
		return this;

	}

	@Step("Save CIF")
	public ABECreateRetailCustomerPage saveCIF(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABECREATERETAILCUSTOMERCSV, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABECREATERETAILCUSTOMERCSV, cifCsvColumnName);
//		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEVERIFYRETAILCUSTOMERCSV, tcIdCsvColumnName, linkedId);
//		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYRETAILCUSTOMERCSV, cifCsvColumnName);
		if (rowByTcid1 != -1 /* && rowByTcid2 != -1 */) {
			CSVUtils.insertValueInCsvCell(Paths.ABECREATERETAILCUSTOMERCSV, rowByTcid1, columnByColumnName1, cif);
			// CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYRETAILCUSTOMERCSV, rowByTcid2,
			// columnByColumnName2,cif);
		}
		return this;
	}
	
	
	//ENRICH PROCESS
	@Step("Proceed to Enrich")
	public ABECreateRetailCustomerPage proceedtoEnrich() throws Exception {
		PageFunctionUtils.clickOnElement(driver, proceedToEnrichButton);
		return this;
	}

	@Step("Open General Details")
	public ABECreateRetailCustomerPage generalDetailsOption(String placeOfBirth) throws Exception {
		PageFunctionUtils.clickOnElement(driver, generalDetailsButtonlinkENRICH);
		PageFunctionUtils.enterDataInWebElement(driver, placeofBirthTextFeildENRICH, placeOfBirth);
		PageFunctionUtils.clickOnElement(driver, amlButtonScreenCheckENRICH);
		PageFunctionUtils.waitOnElement(driver, amlXButtonENRICH);
		PageFunctionUtils.clickOnElement(driver, amlXButtonENRICH);
		return this;
	}

	@Step("Bank Statment Details")
	public ABECreateRetailCustomerPage bankStatmentDetails() throws Exception {
		PageFunctionUtils.selectDropDownListByIndex(driver, bankStatmentInstructionDropDownListENRICH, 1);
		PageFunctionUtils.selectDropDownListByIndex(driver, bankStatmentFreqDropDownListENRICH, 1);
		return this;
	}

	@Step("Email Details")
	public ABECreateRetailCustomerPage EmailDetails(String email) throws Exception {
		PageFunctionUtils.selectDropDownListByIndex(driver, emailDropDownListENRICH, 1);
		PageFunctionUtils.sleep2();
		PageFunctionUtils.clickOnElement(driver, addemailPluseButtonENRICH);
		PageFunctionUtils.clickOnElement(driver, emailRadioButtonENRICH);
		PageFunctionUtils.waitOnElement(driver, emailTypeDropDownListENRICH);
		PageFunctionUtils.selectDropDownListByIndex(driver,emailTypeDropDownListENRICH, 1);
		PageFunctionUtils.enterDataInWebElement(driver, emailTextFieldENRICH , email);
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewEmailButtonENRICH);
		return this;
	}
	
	@Step("Continue Basic Details")
	public ABECreateRetailCustomerPage continueBasicDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continueBasicDetailsButtonENRICH);
		return this;
	}
	
	
	@Step("Occupation Details At ENRICH")
	public ABECreateRetailCustomerPage occupationDetailsUnemployed(String dataIncome) throws Exception {
		PageFunctionUtils.clickOnElement(driver, emplomentDetailsSubMenuENRICH);
		PageFunctionUtils.enterDataInWebElement(driver, dataIncomeUnemployedTextFieldENRICH, dataIncome);
		PageFunctionUtils.clickOnElement(driver, accOpenPurposeDropDownListENRICH);
		PageFunctionUtils.selectDropDownListByIndex(driver, politicalOccupationList1ENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver, politicalOccupationList2ENRICH, 2);
		return this;
	}
	
	@Step("ABE Specfic")
	public ABECreateRetailCustomerPage abeSpecficData(String payrollFlag , String payRollCustomerCompanyID) throws Exception{
		PageFunctionUtils.selectDropDownListByIndex(driver, poaDropDownListENRICH, 2);
		PageFunctionUtils.selectDropDownListByIndex(driver,accOpenPurposeDropDownListENRICH, 1);
		PageFunctionUtils.selectDropDownListByIndex(driver, correspondenceInstructionsDropDownListENRICH, 1);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, payrollFlagDropDownListENRICH, payrollFlag);
		PageFunctionUtils.enterDataInWebElement(driver, companyCustomerIDENRICH, payRollCustomerCompanyID);
		PageFunctionUtils.clickOnElement(driver, continueButtonENRICH);
		return this;
	}
	
	
	//Risk Details
	@Step("Country Dealing")
	public ABECreateRetailCustomerPage riskDetailsCountryDealing(String categoryCodecountryDealing) throws Exception{
		PageFunctionUtils.waitOnElement(driver, countryDealingSearchIconENRICH);
		PageFunctionUtils.clickOnElement(driver, countryDealingSearchIconENRICH);
		PageFunctionUtils.waitOnElement(driver, categoryCodecountryDealingTextFieldENRICH);
		PageFunctionUtils.enterDataInWebElement(driver,categoryCodecountryDealingTextFieldENRICH , categoryCodecountryDealing);
		PageFunctionUtils.clickOnElement(driver, searchCategorycountryDealingButtonENRICH);
		PageFunctionUtils.clickOnElement(driver, checkBoxcountryDealingButtonENRICH);
		PageFunctionUtils.clickOnElement(driver, selectButtoncountryDealingENRICH);
		PageFunctionUtils.clickOnElement(driver, okCountryDealingButtonENRICH);
		return this;
	}
	
	@Step("PEP Y")
	public ABECreateRetailCustomerPage pepselection(String pepTextField1, String pepTextField2, String pepTextField3, String pepTextField4, String pepTextField5, String pepTextField6, String pepNumberField7, String pepNumberField8, String pepNumberField9, String pepNumberField10, String pepTextField11, String pepTextField12, String pepTextField13, String pepTextField14, String pepTextField15) throws Exception{
		PageFunctionUtils.selectDropDownListByIndex(driver, pepDropDownListENRICH , 1);
		PageFunctionUtils.clickOnElement(driver, calculateRiskButtonENRICH);
		PageFunctionUtils.selectDropDownListByIndex(driver, hrrCompliantENRICH, 2);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField1ENRICH, pepTextField1);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField2ENRICH, pepTextField2);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField3ENRICH, pepTextField3);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField4ENRICH, pepTextField4);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField5ENRICH, pepTextField5);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField6ENRICH, pepTextField6);
		PageFunctionUtils.enterDataInWebElement(driver, pepNumberField7ENRICH, pepNumberField7);
		PageFunctionUtils.enterDataInWebElement(driver, pepNumberField8ENRICH, pepNumberField8);
		PageFunctionUtils.enterDataInWebElement(driver, pepNumberField9ENRICH, pepNumberField9);
		PageFunctionUtils.enterDataInWebElement(driver, pepNumberField10ENRICH, pepNumberField10);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField11ENRICH, pepTextField11);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField12ENRICH, pepTextField12);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField13ENRICH, pepTextField13);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField14ENRICH, pepTextField14);
		PageFunctionUtils.enterDataInWebElement(driver, pepTextField15ENRICH, pepTextField15);
		PageFunctionUtils.clickOnElement(driver, continueButtonENRICH);
		return this;
	}
	
	@Step("PEP N")
	public ABECreateRetailCustomerPage pepunSelected() throws Exception {
		PageFunctionUtils.selectDropDownListByIndex(driver, pepDropDownListENRICH, 2);
		return this;
	}
	
    @Step("FATCA")
    public ABECreateRetailCustomerPage fatcaSelection() throws Exception {
    	PageFunctionUtils.selectDropDownListByIndex(driver, fatcaDropDownList1ENRICH, 2);
    	PageFunctionUtils.selectDropDownListByIndex(driver, fatcaDropDownList2ENRICH, 2);
    	PageFunctionUtils.selectDropDownListByIndex(driver, fatcaDropDownList3ENRICH, 2);
    	PageFunctionUtils.selectDropDownListByIndex(driver, fatcaDropDownList4ENRICH, 2);
    	return this;
    }
    
    @Step("View Summary")
    public ABECreateRetailCustomerPage viewSummary() throws Exception {
    	PageFunctionUtils.clickOnElement(driver, viewSummaryButtonENRICH);
    	return this;
    }
    
    @Step("Open Bank definied Details")
    public ABECreateRetailCustomerPage openBankDefinedDetails() throws Exception {
    	PageFunctionUtils.clickOnElement(driver, bankDefinedDetailsButtonENRICH);
    	PageFunctionUtils.waitOnElement(driver, saveAndValidateBankDefinedDetailsButtonENRICH);
    	PageFunctionUtils.clickOnElement(driver, viewSummaryButtonENRICH);
    	return this;
    }
    
    @Step("Open financial Details")
    public ABECreateRetailCustomerPage openfinancialDetail() throws Exception {
    	PageFunctionUtils.clickOnElement(driver, financeDetailsButtonENRICH);
    	PageFunctionUtils.waitOnElement(driver, saveAndValidateBankDefinedDetailsButtonENRICH);
    	PageFunctionUtils.clickOnElement(driver, viewSummaryFinancialDetailsButtonENRICH);
    	return this;
    }
    
    @Step("Submit Enrichment")
    public ABECreateRetailCustomerPage submitEnrichment() throws Exception {
    	PageFunctionUtils.clickOnElement(driver, submitButtonENRICH);
    	return this;
    }
    
}