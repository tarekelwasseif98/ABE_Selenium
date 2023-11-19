package pageobjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;
public class ABEIssueOutwardLGTradeFinancePage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	
	private By guaranteeTypeSearchField = By.xpath("(//input[@id='_guarType'])[1]");
	private By currencyField = By.xpath("(//input[@id='_bgCcy'])[1]");
	private By cifIdTextField = By.xpath("(//input[@id='_newCifId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	
	private By guaranteeAmountField = By.xpath("(//input[@id='_ogmgendtls_bgAmt$amt'])[1]");
	private By generalDetailscontinueButton = By.xpath("(//button[@id='_ogmgendtls_gendet_Continue'])[1]");
	
	private By beneficiaryNameTextField = By.xpath("(//input[@id='_ogmpartydtls_benName'])[1]");
	private By beneficiaryAddressTextField = By.xpath("(//input[@id='_ogmpartydtls_benAddr1'])[1]");	
	private By partyContinueButton = By.xpath("(//button[@id='_ogmpartydtls_partydet_Continue'])[1]");
	
	private By expiryDateField = By.xpath("(//input[@id='_ogmguarntee_expDate'])[1]");
	private By claimDateField = By.xpath("(//input[@id='_ogmguarntee_claimExpDate'])[1]");
	
	private By applicableRulesDropdownMenu = By.xpath("(//select[@id='_ogmguarntee_applcRules_select'])[1]");
	
	private By guaranteeAdditionalDetailsButton = By.xpath("(//h2[normalize-space()='Guarantee Additional Details'])[1]");	
	private By UndertakingermsAndConditionsDescriptionIconButton = By.xpath("(//img[@id='_ogmguarntee_guardetdesc$msgTextExp_image'])[1]");
	private By messageTextAreaField = By.xpath("(//textarea[@id='_ogmguarntee_guardetdesc$msgText_textArea'])[1]");
	private By acceptButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	
	private By purposeOfMessageDropdownMenu = By.xpath("(//select[@id='_ogmguarntee_purposeOfMsg_select'])[1]");
	private By guaranteeDetailsContinueButton = By.xpath("(//button[@id='_ogmguarntee_guarentedet_Continue'])[1]");
	
	private By limitIdField1 = By.xpath("(//input[@id='_limit_limitId$prefix'])[1]");
	private By limitIdField2 = By.xpath("(//input[@id='_limit_limitId$suffix'])[1]");
	private By continueLimitButton = By.xpath("(//button[@id='_limit_limit_Continue'])[1]");
	
	//continue Buttons
	private By continueMarginButton = By.xpath("(//button[@id='_margin_margin_Continue'])[1]");
	private By chargesContinueButton = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
	private By instructionContinueButton = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
	private By tracerContinueButton = By.xpath("(//button[@id='_ogmtracer_tracerdet_FinButton1'])[1]");
	private By textContinueButton = By.xpath("(//button[@id='_textdet_textdet_Continue'])[1]");
	private By messageContinueButton = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
    
	
	private By bankAccountReferenceTextField = By.xpath("(//input[@id='_ogmgendtls_otherBankRefNo'])[1]");
	private By paySysIDTextField = By.xpath("(//input[@id='_ogmgendtls_paysysId'])[1]");
	
	
	//Address
	private By addressTypeDropdownMenu = By.xpath("(//select[@id='_ogmpartydtls_advAddrtype_select'])[1]");
	private By bankIdentifierTextField = By.xpath("(//input[@id='_ogmpartydtls_advBic'])[1]");
	private By advisingNameTextField = By.xpath("(//input[@id='_ogmpartydtls_advName'])[1]");
	private By advisingAddressTextField = By.xpath("(//input[@id='_ogmpartydtls_advAddr1'])[1]");
	private By cityTextField = By.xpath("(//input[@id='_ogmpartydtls_advCity'])[1]");
	private By stateTextField = By.xpath("(//input[@id='_ogmpartydtls_advState'])[1]");
	private By countryTextField = By.xpath("(//input[@id='_ogmpartydtls_advCntry'])[1]");
	private By postalCodeTextField = By.xpath("(//input[@id='_ogmpartydtls_advPostCode'])[1]");
	
	//message details fields
	private By messageTypeDropdownMenu = By.xpath("(//select[@id='_messagedetails_mtNo_select'])[1]");
    private By receivingBankField = By.xpath("(//input[@id='_messagedetails_recvBic'])[1]");
	private By generateButton = By.xpath("(//button[normalize-space()='Generate'])[1]");
	
	private By editFirstButton = By.xpath("(//span[@class='editcontent'])[3]");
	private By acceptFirstMessageButton = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By updateFirstButton = By.xpath("(//button[@id='_messagedetails_messagedet_updateSummary'])[1]");
		
	private By editSecondButton = By.xpath("(//span[@class='editcontent'])[4]");
	private By editNarrativeButton = By.xpath("(//span[@class='editcontent'])[7]");
	
	private By narrativeTextButton = By.xpath("(//img[@id='_messagedetails_dynmsg_FinTextArea$msgTextExp_image'])[1]");
	
	private By narrativeTextField = By.xpath("(//textarea[@id='_messagedetails_dynmsg_FinTextArea$msgText_textArea'])[1]");
	
	private By acceptNarrativeButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private By saveButton = By.xpath("(//button[@id='_messagedetails_dynmsg_doneBtn'])[1]");
	private By acceptSecondMessageButton = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By updateSecondButton = By.xpath("(//button[@id='_messagedetails_messagedet_updateSummary'])[1]");
    
	private By purposeGuaranteeTextField = By.xpath("(//textarea[@id='_ogmguarntee_purpOfGrntee_textArea'])[1]");
	
	
	private By counterGuaranteeDetailsMenu = By.xpath("(//h3[normalize-space()='Counter Guarantee Details'])[1]");
	private By guaranteeNumberTextField = By.xpath("(//input[@id='_ogmguarntee_grnteeNum'])[1]");
	private By rateCodeField = By.xpath("(//input[@id='_ogmguarntee_cbgratecode_rate$rateCode'])[1]");
	
	private By printDraftButton = By.xpath("(//button[normalize-space()='Print Draft'])[1]");
	
	
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");	
	private By guranteeId = By.xpath("(//div[@id='_success_guarNo_text'])[1]");
	
	
	public static String acId;
	public static String  referenceCsvColumnName = "referenceGuarantee";
	public static String  guaranteeIdCsvColumnName = "guaranteeId";
	
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";  
	
	
	
	public ABEIssueOutwardLGTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	@Step("Sending menu name: {0}")
	public ABEIssueOutwardLGTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnElement(driver, searchBarTextField);
		PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
        PageFunctionUtils.clickOnElement(driver, searchButton);	       
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        }
        catch (Exception e) {
        }
	return this;
	}
	
	
	
	@Step("Frame switching")
	public ABEIssueOutwardLGTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);	    
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;		
	}
	
	
	@Step("Sending guarantee type: {0}")
	public ABEIssueOutwardLGTradeFinancePage sendkeysGuaranteeTypeField(String guaranteeType) throws Exception {		
		PageFunctionUtils.waitOnElement(driver, guaranteeTypeSearchField);
		PageFunctionUtils.clickOnElement(driver, guaranteeTypeSearchField);
		PageFunctionUtils.enterDataInWebElement(driver, guaranteeTypeSearchField, guaranteeType);
		return this;
	}
	
	
	
	
	@Step("Sending currency CCY: {0}")
	public ABEIssueOutwardLGTradeFinancePage sendkeysCurrencyDetails(String currency) throws Exception {		
		PageFunctionUtils.waitOnElement(driver, currencyField);
		PageFunctionUtils.clickOnElement(driver, currencyField);
		PageFunctionUtils.enterDataInWebElement(driver, currencyField, currency);
		return this;
	}
	
	
	
	@Step("Sending customer CIF: {0}")
	public ABEIssueOutwardLGTradeFinancePage sendKeysCustomerDetailsCIF(String cifid) throws Exception {						
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		PageFunctionUtils.clickOnElement(driver, cifIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifid.substring(1));
		return this;
	}
		
	
	
	
		
	@Step("press go button")
	public ABEIssueOutwardLGTradeFinancePage goButton() throws Exception {			
    PageFunctionUtils.clickOnElement(driver, goButton);	
	return this;		
}
	
	
	
   @Step("Enter guarantee amount: {0}")
   public ABEIssueOutwardLGTradeFinancePage sendkeysGuaranteeAmount(String guaranteeAmount) throws Exception{
	    PageFunctionUtils.waitOnElement(driver, guaranteeAmountField);
		PageFunctionUtils.clickOnElement(driver, guaranteeAmountField);
		PageFunctionUtils.clearDataInWebElement(driver,guaranteeAmountField );
		PageFunctionUtils.enterDataInWebElement(driver, guaranteeAmountField, guaranteeAmount);	
		return this;
   }

	
   @Step("Enter other bank reference number: {0}")
   public  ABEIssueOutwardLGTradeFinancePage senkeysBankAccount(String bankAccountReference) throws Exception{
	    PageFunctionUtils.waitOnElement(driver, bankAccountReferenceTextField);
		PageFunctionUtils.clickOnElement(driver, bankAccountReferenceTextField);
		PageFunctionUtils.enterDataInWebElement(driver, bankAccountReferenceTextField, bankAccountReference.substring(1));	
		return this;
   }
   
   
   
   @Step("Enter PaySysID: {0}")
   public  ABEIssueOutwardLGTradeFinancePage senkeysPaySysId(String paySysID) throws Exception{
	    PageFunctionUtils.waitOnElement(driver, paySysIDTextField);
		PageFunctionUtils.clickOnElement(driver, paySysIDTextField);
		PageFunctionUtils.enterDataInWebElement(driver, paySysIDTextField, paySysID);	
		return this;
   } 
   
   
   
   @Step("Press Continue Button")
   public ABEIssueOutwardLGTradeFinancePage pressGeneralDetailsContinueButton() throws Exception{   
	    PageFunctionUtils.waitOnElement(driver, generalDetailscontinueButton);
		PageFunctionUtils.clickOnElement(driver, generalDetailscontinueButton);
	   return this;
   }

  
   
   @Step("Enter beneficiary name: {0}")
   public ABEIssueOutwardLGTradeFinancePage sendkeysBeneficiaryName(String name) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, beneficiaryNameTextField);
	   PageFunctionUtils.clickOnElement(driver, beneficiaryNameTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, beneficiaryNameTextField, name);	
	   return this;
   }
   
   
   @Step("Enter beneficiary address: {0}")
   public ABEIssueOutwardLGTradeFinancePage sendkeysBeneficiaryAddress(String address) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, beneficiaryAddressTextField);
	   PageFunctionUtils.clickOnElement(driver, beneficiaryAddressTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, beneficiaryAddressTextField, address);	
	   return this;
   }
   
   
   
  
   
   
   @Step("Select address type: {0}")
   public ABEIssueOutwardLGTradeFinancePage selectAdressType(String addressType) throws Exception{
	    PageFunctionUtils.waitOnElement(driver, addressTypeDropdownMenu);
		PageFunctionUtils.clickOnElement(driver, addressTypeDropdownMenu);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, addressTypeDropdownMenu, addressType);
	   return this;
   }
   
   @Step("Enter bank identifier: {0}")
   public ABEIssueOutwardLGTradeFinancePage enterBankIdentifier(String bankIdentifier) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, bankIdentifierTextField);
	   PageFunctionUtils.clickOnElement(driver, bankIdentifierTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, bankIdentifierTextField, bankIdentifier);	
	   return this;
   }
   
   
   @Step("Enter advising name: {0}")
   public ABEIssueOutwardLGTradeFinancePage enterAdvisingName(String advisingName) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, advisingNameTextField);
	   PageFunctionUtils.clickOnElement(driver, advisingNameTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, advisingNameTextField, advisingName);	
	   return this;
   }
   
   
   @Step("Enter advising address: {0}")
   public ABEIssueOutwardLGTradeFinancePage enterAdvisingAddress(String advisingAddress) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, advisingAddressTextField);
	   PageFunctionUtils.clickOnElement(driver, advisingAddressTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, advisingAddressTextField, advisingAddress);	
	   return this;
   }
  
   
   @Step("Enter city: {0}")
   public ABEIssueOutwardLGTradeFinancePage enterCityField(String city) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, cityTextField);
	   PageFunctionUtils.clickOnElement(driver, cityTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, cityTextField, city.substring(1));	
	   return this;
   }
   

   @Step("Enter state: {0}")
   public ABEIssueOutwardLGTradeFinancePage enterStateField(String state) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, stateTextField);
	   PageFunctionUtils.clickOnElement(driver, stateTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, stateTextField, state.substring(1));	
	   return this;
   }
   
   
   @Step("Enter country field: {0}")
   public ABEIssueOutwardLGTradeFinancePage enterCountryField(String country) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, countryTextField);
	   PageFunctionUtils.clickOnElement(driver, countryTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, countryTextField, country);	
	   return this;
   }
   
   @Step("Enter postal code: {0}")
   public ABEIssueOutwardLGTradeFinancePage enterPostalCodeField(String postalCode) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, postalCodeTextField);
	   PageFunctionUtils.clickOnElement(driver, postalCodeTextField);
	   PageFunctionUtils.enterDataInWebElement(driver, postalCodeTextField, postalCode);	
	   return this;
   }
   
   
   
   @Step("press on party continue button")
   public ABEIssueOutwardLGTradeFinancePage pressOnPartyContinueButton() throws Exception{
	   PageFunctionUtils.waitOnElement(driver, partyContinueButton);
	   PageFunctionUtils.clickOnElement(driver, partyContinueButton);
	   return this;
   }
   
   
   
   
   @Step("enter purpose of guarantee: {0}")
   public ABEIssueOutwardLGTradeFinancePage enterPurposeOfGuarantee(String purposeGuarantee) throws Exception{
	   PageFunctionUtils.waitOnElement(driver, purposeGuaranteeTextField);
	   PageFunctionUtils.clickOnElement(driver, purposeGuaranteeTextField);
	   return this;
   }
   
 
  @Step("Enter expiry date: {0}")
  public ABEIssueOutwardLGTradeFinancePage sendkeysExpiryDate(String expiryDate) throws Exception{
	  PageFunctionUtils.waitOnElement(driver, expiryDateField);		
		PageFunctionUtils.clearDataInWebElement(driver,expiryDateField );
		PageFunctionUtils.clickOnElement(driver, expiryDateField);
		PageFunctionUtils.enterDataInWebElement(driver, expiryDateField, expiryDate.substring(1));
	  return this;
  }
   
  @Step("Enter claim date: {0}")
  public ABEIssueOutwardLGTradeFinancePage sendkeysclaimDate(String claimDate) throws Exception{
	    PageFunctionUtils.waitOnElement(driver, claimDateField);		
		PageFunctionUtils.clearDataInWebElement(driver,claimDateField );
		PageFunctionUtils.clickOnElement(driver, claimDateField);
		PageFunctionUtils.enterDataInWebElement(driver, claimDateField, claimDate.substring(1));
	  return this;
  } 
  
  
  
  @Step("select applicaple rules dropdown menu")
  public ABEIssueOutwardLGTradeFinancePage selectApplicableRules(String rulesdropdown) throws Exception{
	    PageFunctionUtils.waitOnElement(driver, applicableRulesDropdownMenu);
		PageFunctionUtils.clickOnElement(driver, applicableRulesDropdownMenu);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, applicableRulesDropdownMenu, rulesdropdown);
	  return this;
  }
  

	
	 @Step("click on counter guarantee details menu")
	  public ABEIssueOutwardLGTradeFinancePage selectCounterGuranteeMenu() throws Exception{
		    PageFunctionUtils.waitOnElement(driver, counterGuaranteeDetailsMenu);
			PageFunctionUtils.clickOnElement(driver, counterGuaranteeDetailsMenu);
		
		  return this;
	  }
	
	 
	 @Step("enter guarantee number ")
	  public ABEIssueOutwardLGTradeFinancePage enterGuaranteeNumber(String guaranteeNumberId) throws Exception{
		    PageFunctionUtils.waitOnElement(driver, guaranteeNumberTextField);
			PageFunctionUtils.clickOnElement(driver, guaranteeNumberTextField);
			PageFunctionUtils.enterDataInWebElement(driver, guaranteeNumberTextField, guaranteeNumberId.substring(1));
		
		  return this;
	  } 
  
	 
	 
	 @Step("enterrate code ")
	  public ABEIssueOutwardLGTradeFinancePage enterRateCode(String rateCode) throws Exception{
		    PageFunctionUtils.waitOnElement(driver, rateCodeField);
			PageFunctionUtils.clickOnElement(driver, rateCodeField);
			PageFunctionUtils.enterDataInWebElement(driver, rateCodeField, rateCode);
		
		  return this;
	  }  
  
  
  
  

 @Step("Select guarantee additional details")
 public ABEIssueOutwardLGTradeFinancePage selectGuaranteeAdditionalDetails() throws Exception{
	    PageFunctionUtils.waitOnElement(driver, guaranteeAdditionalDetailsButton);
		PageFunctionUtils.clickOnElement(driver, guaranteeAdditionalDetailsButton);
		return this;
 }
 
 
 @Step("Enter purpose of message: {0}")
 public ABEIssueOutwardLGTradeFinancePage enterpurposeOfMessage(String message) throws Exception{
	    if (message != null) {
	    PageFunctionUtils.waitOnElement(driver, UndertakingermsAndConditionsDescriptionIconButton);
		PageFunctionUtils.clickOnElement(driver, UndertakingermsAndConditionsDescriptionIconButton);			
	    PageFunctionUtils.switchToParentFrame(driver);
	    PageFunctionUtils.waitOnElement(driver, messageTextAreaField);
	    PageFunctionUtils.clickOnElement(driver, messageTextAreaField);
	    PageFunctionUtils.enterDataInWebElement(driver, messageTextAreaField, message);
	    }
	    PageFunctionUtils.waitOnElement(driver, acceptButton);
	    PageFunctionUtils.clickOnElement(driver, acceptButton);
	   
	
		 return this;
 }
  
 
 /*
 @Step("select purpose of message")
 public ABEIssueOutwardLGTradeFinancePage selectPurposeOfMessage(String purposedropdown) throws Exception{
	    PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
	    PageFunctionUtils.waitOnElement(driver, purposeOfMessageDropdownMenu);
		PageFunctionUtils.clickOnElement(driver, purposeOfMessageDropdownMenu);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, purposeOfMessageDropdownMenu, purposedropdown);
	 return this;
 }*/

  
 
@Step("press on guarantee continue button")
public ABEIssueOutwardLGTradeFinancePage pressOnGuaranteeContinueButtonForPurposeMessage() throws Exception{	
	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
	PageFunctionUtils.waitOnElement(driver, guaranteeDetailsContinueButton);
	PageFunctionUtils.clickOnElement(driver, guaranteeDetailsContinueButton);
	
	return this;
}


@Step("press on guarantee continue button")
public ABEIssueOutwardLGTradeFinancePage pressOnGuaranteeContinueButton() throws Exception{		
	PageFunctionUtils.waitOnElement(driver, guaranteeDetailsContinueButton);
	PageFunctionUtils.clickOnElement(driver, guaranteeDetailsContinueButton);
	
	return this;
}




@Step("enter limit details: {0}")
public ABEIssueOutwardLGTradeFinancePage sendkeysLimitFields(String limitId1, String limitId2) throws Exception {
		PageFunctionUtils.waitOnElement(driver, limitIdField1);
		PageFunctionUtils.clickOnElement(driver, limitIdField1);
		PageFunctionUtils.enterDataInWebElement(driver, limitIdField1, limitId1.substring(1));	
		PageFunctionUtils.waitOnElement(driver, limitIdField2);
		PageFunctionUtils.clickOnElement(driver, limitIdField2);
		PageFunctionUtils.enterDataInWebElement(driver, limitIdField2, limitId2);
return this;		
}	


@Step("press limit continue button")
public ABEIssueOutwardLGTradeFinancePage pressLimitContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, continueLimitButton);
	PageFunctionUtils.clickOnElement(driver, continueLimitButton);
	return this;
}


@Step("press margin continue button")
public ABEIssueOutwardLGTradeFinancePage pressMarginContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, continueMarginButton);
	PageFunctionUtils.clickOnElement(driver, continueMarginButton);
	return this;
}



@Step("press charges continue button")
public ABEIssueOutwardLGTradeFinancePage pressChargesContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, chargesContinueButton);
	PageFunctionUtils.clickOnElement(driver, chargesContinueButton);
	return this;
}




@Step("press instruction continue button")
public ABEIssueOutwardLGTradeFinancePage pressInstructionContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, instructionContinueButton);
	PageFunctionUtils.clickOnElement(driver,instructionContinueButton);
	return this;
}




@Step("press tracer continue button")
public ABEIssueOutwardLGTradeFinancePage pressTracerContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, tracerContinueButton);
	PageFunctionUtils.clickOnElement(driver, tracerContinueButton);
	return this;
}




@Step("press text continue button")
public ABEIssueOutwardLGTradeFinancePage pressTextContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, textContinueButton);
	PageFunctionUtils.clickOnElement(driver, textContinueButton);
	return this;
}



@Step("select message type: {0}")
public ABEIssueOutwardLGTradeFinancePage selectMessageType(String messageMenu) throws Exception{
	  PageFunctionUtils.waitOnElement(driver, messageTypeDropdownMenu);
			PageFunctionUtils.clickOnElement(driver, messageTypeDropdownMenu);
			PageFunctionUtils.selectDropDownListByVisibleText(driver, messageTypeDropdownMenu, messageMenu);
	return this;
}


@Step("Enter receiving bank identifier : {0}")
public ABEIssueOutwardLGTradeFinancePage enterReceivingBank(String receivingBank) throws Exception{
	  PageFunctionUtils.waitOnElement(driver, receivingBankField);
	  PageFunctionUtils.clickOnElement(driver, receivingBankField);
	  PageFunctionUtils.enterDataInWebElement(driver, receivingBankField, receivingBank);
	return this;
}



@Step("Click on generate button")
public ABEIssueOutwardLGTradeFinancePage clickOnGenerateButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, generateButton);
	  PageFunctionUtils.clickOnElement(driver, generateButton);
	return this;
}



@Step("Click on first edit button")
public ABEIssueOutwardLGTradeFinancePage clickOnFirstEditButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, editFirstButton);
	  PageFunctionUtils.clickOnElement(driver, editFirstButton);
	return this;
}


@Step("Click on accept first message button")
public ABEIssueOutwardLGTradeFinancePage clickOnAcceptFirstMessageButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, acceptFirstMessageButton);
	  PageFunctionUtils.clickOnElement(driver, acceptFirstMessageButton);
	return this;
}

@Step("Click on update first button")
public ABEIssueOutwardLGTradeFinancePage clickOnUpdateFirstButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, updateFirstButton);
	  PageFunctionUtils.clickOnElement(driver, updateFirstButton);
	return this;
}



@Step("Click on second edit button")
public ABEIssueOutwardLGTradeFinancePage clickOnSecondEditButton() throws Exception{
	  PageFunctionUtils.waitOnElement(driver, editSecondButton);
	  PageFunctionUtils.clickOnElement(driver, editSecondButton);
	return this;
}


@Step("Click on edit narrative button")
public ABEIssueOutwardLGTradeFinancePage clickOnEditNarrativeButton() throws Exception{
	
	 PageFunctionUtils.waitOnElement(driver, editNarrativeButton);
	 PageFunctionUtils.clickOnElement(driver, editNarrativeButton);
	return this;
}





@Step("Enter narrative text field")
public ABEIssueOutwardLGTradeFinancePage enterNarrativeTextField(String narrativeText) throws Exception{
	 	
	 if (narrativeText != null) {
		 PageFunctionUtils.waitOnElement(driver, narrativeTextButton);
		 PageFunctionUtils.clickOnElement(driver, narrativeTextButton);	
		    PageFunctionUtils.switchToParentFrame(driver);
		    PageFunctionUtils.waitOnElement(driver, narrativeTextField);
		    PageFunctionUtils.clickOnElement(driver, narrativeTextField);
		    PageFunctionUtils.enterDataInWebElement(driver, narrativeTextField, narrativeText);		 
		    }
	    PageFunctionUtils.waitOnElement(driver, acceptNarrativeButton);
	    PageFunctionUtils.clickOnElement(driver, acceptNarrativeButton);
		   
	return this;
}


@Step("Click on save button")
public ABEIssueOutwardLGTradeFinancePage clickOnSaveButton() throws Exception{
	    PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
	    PageFunctionUtils.waitOnElement(driver, saveButton);
	    PageFunctionUtils.clickOnElement(driver, saveButton);
return this;

}



@Step("Click on accept send message button")
public ABEIssueOutwardLGTradeFinancePage acceptSecondMessageButton() throws Exception{
PageFunctionUtils.waitOnElement(driver, acceptSecondMessageButton);
PageFunctionUtils.clickOnElement(driver, acceptSecondMessageButton);
return this;

}


@Step("Click on update second button")
public ABEIssueOutwardLGTradeFinancePage clickOnUpdateSecondButton() throws Exception{
	 
	  PageFunctionUtils.waitOnElement(driver, updateSecondButton);
	  PageFunctionUtils.clickOnElement(driver, updateSecondButton);
	return this;
}






@Step("press message continue button")
public ABEIssueOutwardLGTradeFinancePage pressMessageContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, messageContinueButton);
	PageFunctionUtils.clickOnElement(driver, messageContinueButton);
	return this;
}





	
@Step("Press submit button")
public ABEIssueOutwardLGTradeFinancePage pressSubmitButton() throws Exception {
	
   PageFunctionUtils.waitOnElement(driver, submitButton);
   PageFunctionUtils.clickOnElement(driver, submitButton);
   PageFunctionUtils.acceptWarning(driver);
	Thread.sleep(3500);
	acId = driver.findElement(guranteeId).getText();
	System.out.println("Guarantee ID: "+ acId); 
	return this;
}



@Step("Save a/c. id")
public ABEIssueOutwardLGTradeFinancePage saveAccountId(String linkedTcid ) throws Exception {
int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, linkedTcidCsvColumnName, linkedTcid);
int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, referenceCsvColumnName);
	

int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VERIFYOUTWARDLGTRADEFINANCECSV, tcIdCsvColumnName, linkedTcid);
int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VERIFYOUTWARDLGTRADEFINANCECSV, guaranteeIdCsvColumnName);


if(rowByTcid1 != -1 && rowByTcid2 != -1) {

	CSVUtils.insertValueInCsvCell(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, rowByTcid1, columnByColumnName1, acId);
	CSVUtils.insertValueInCsvCell(Paths.VERIFYOUTWARDLGTRADEFINANCECSV, rowByTcid2, columnByColumnName2, acId); 

}

return this;
}

   
	
}
