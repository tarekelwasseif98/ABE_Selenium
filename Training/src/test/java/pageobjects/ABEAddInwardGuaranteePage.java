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
	
	public class ABEAddInwardGuaranteePage {
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
		
	    private By counterGuaranteeButton = By.xpath("(//h3[normalize-space()='Counter Guarantee Details'])[1]");
	    private By yesButton =By.xpath("(//input[@id='_igmguarntee_link_Counguar_Y_radio'])[1]");
		
	
		private By guaranteeDetailsContinueButton = By.xpath("(//button[@id='_ogmguarntee_guarentedet_Continue'])[1]");
		
		
		
		//continue Buttons
		private By continueLimitButton = By.xpath("(//button[@id='_limit_limit_Continue'])[1]");
		private By continueMarginButton = By.xpath("(//button[@id='_margin_margin_Continue'])[1]");
		private By chargesContinueButton = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
		private By instructionContinueButton = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
		private By tracerContinueButton = By.xpath("(//button[@id='_ogmtracer_tracerdet_FinButton1'])[1]");
		private By textContinueButton = By.xpath("(//button[@id='_textdet_textdet_Continue'])[1]");
		private By messageContinueButton = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
	    
		
		private By bankAccountReferenceTextField = By.xpath("(//input[@id='_ogmgendtls_otherBankRefNo'])[1]");
		private By paySysIDTextField = By.xpath("(//input[@id='_ogmgendtls_paysysId'])[1]");
		
		
		
		private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");	
		private By guaranteeId = By.xpath("(//div[@id='_success_guarNo_text'])[1]");
		
		
		public static String acId;
		public static String  guaranteeInwardCsvColumnName = "guaranteeNumberReference";
		public static String  guaranteeInwardNumberIdCsvColumnName = "guaranteeNumberId";
		
		
		
		
		public static String  tcIdCsvColumnName = "tcId";
		public static String  linkedTcidInwardCsvColumnName = "linkedTcid1";  
		
		
		
		public ABEAddInwardGuaranteePage(WebDriver driver) {
			this.driver = driver;
		}
		
		
		@Step("Sending menu name: {0}")
		public ABEAddInwardGuaranteePage sendKeysSearchBarTextField(String menu) throws Exception {
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
		public ABEAddInwardGuaranteePage switchFormAreaFrame() throws Exception {
			PageFunctionUtils.sleep();
			PageFunctionUtils.switchToParentFrame(driver);
		    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);	    
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			return this;		
		}
		
		
		@Step("Sending guarantee type: {0}")
		public ABEAddInwardGuaranteePage sendkeysGuaranteeTypeField(String guaranteeType) throws Exception {		
			PageFunctionUtils.waitOnElement(driver, guaranteeTypeSearchField);
			PageFunctionUtils.clickOnElement(driver, guaranteeTypeSearchField);
			PageFunctionUtils.enterDataInWebElement(driver, guaranteeTypeSearchField, guaranteeType);
			return this;
		}
		
		
		
		
		@Step("Sending currency CCY: {0}")
		public ABEAddInwardGuaranteePage sendkeysCurrencyDetails(String currency) throws Exception {		
			PageFunctionUtils.waitOnElement(driver, currencyField);
			PageFunctionUtils.clickOnElement(driver, currencyField);
			PageFunctionUtils.enterDataInWebElement(driver, currencyField, currency);
			return this;
		}
		
		
		
		@Step("Sending customer CIF: {0}")
		public ABEAddInwardGuaranteePage sendKeysCustomerDetailsCIF(String cifid) throws Exception {						
			PageFunctionUtils.waitOnElement(driver, cifIdTextField);
			PageFunctionUtils.clickOnElement(driver, cifIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifid.substring(1));
			return this;
		}
			
		
		
		
			
		@Step("press go button")
		public ABEAddInwardGuaranteePage goButton() throws Exception {			
	    PageFunctionUtils.clickOnElement(driver, goButton);	
		return this;		
	}
		
		
		
	   @Step("Enter guarantee amount: {0}")
	   public ABEAddInwardGuaranteePage sendkeysGuaranteeAmount(String guaranteeAmount) throws Exception{
		    PageFunctionUtils.waitOnElement(driver, guaranteeAmountField);
			PageFunctionUtils.clickOnElement(driver, guaranteeAmountField);
			PageFunctionUtils.clearDataInWebElement(driver,guaranteeAmountField );
			PageFunctionUtils.enterDataInWebElement(driver, guaranteeAmountField, guaranteeAmount);	
			return this;
	   }	
	
	   @Step("Press Continue Button")
	   public ABEAddInwardGuaranteePage pressGeneralDetailsContinueButton() throws Exception{   
		    PageFunctionUtils.waitOnElement(driver, generalDetailscontinueButton);
			PageFunctionUtils.clickOnElement(driver, generalDetailscontinueButton);
		   return this;
	   }


	   @Step("Enter beneficiary name: {0}")
	   public ABEAddInwardGuaranteePage sendkeysBeneficiaryName(String name) throws Exception{
		   PageFunctionUtils.waitOnElement(driver, beneficiaryNameTextField);
		   PageFunctionUtils.clickOnElement(driver, beneficiaryNameTextField);
		   PageFunctionUtils.enterDataInWebElement(driver, beneficiaryNameTextField, name);	
		   return this;
	   }
	   
	   
	   @Step("Enter beneficiary address: {0}")
	   public ABEAddInwardGuaranteePage sendkeysBeneficiaryAddress(String address) throws Exception{
		   PageFunctionUtils.waitOnElement(driver, beneficiaryAddressTextField);
		   PageFunctionUtils.clickOnElement(driver, beneficiaryAddressTextField);
		   PageFunctionUtils.enterDataInWebElement(driver, beneficiaryAddressTextField, address);	
		   return this;
	   }
	   
	   
	   
	   @Step("press on party continue button")
	   public ABEAddInwardGuaranteePage pressOnPartyContinueButton() throws Exception{
		   PageFunctionUtils.waitOnElement(driver, partyContinueButton);
		   PageFunctionUtils.clickOnElement(driver, partyContinueButton);
		   return this;
	   }

	   @Step("Enter expiry date: {0}")
	   public ABEAddInwardGuaranteePage sendkeysExpiryDate(String expiryDate) throws Exception{
	 	  PageFunctionUtils.waitOnElement(driver, expiryDateField);		
	 		PageFunctionUtils.clearDataInWebElement(driver,expiryDateField );
	 		PageFunctionUtils.clickOnElement(driver, expiryDateField);
	 		PageFunctionUtils.enterDataInWebElement(driver, expiryDateField, expiryDate.substring(1));
	 	  return this;
	   }
	    
	   @Step("Enter claim date: {0}")
	   public ABEAddInwardGuaranteePage sendkeysclaimDate(String claimDate) throws Exception{
	 	    PageFunctionUtils.waitOnElement(driver, claimDateField);		
	 		PageFunctionUtils.clearDataInWebElement(driver,claimDateField );
	 		PageFunctionUtils.clickOnElement(driver, claimDateField);
	 		PageFunctionUtils.enterDataInWebElement(driver, claimDateField, claimDate.substring(1));
	 	  return this;
	   } 
	   
	   
	   
	   @Step("select applicaple rules dropdown menu")
	   public ABEAddInwardGuaranteePage selectApplicableRules(String rulesdropdown) throws Exception{
	 	    PageFunctionUtils.waitOnElement(driver, applicableRulesDropdownMenu);
	 		PageFunctionUtils.clickOnElement(driver, applicableRulesDropdownMenu);
	 		PageFunctionUtils.selectDropDownListByVisibleText(driver, applicableRulesDropdownMenu, rulesdropdown);
	 	  return this;
	   }
	   

@Step("press on counter guarantee  button")
public ABEAddInwardGuaranteePage pressOnCounterGuaranteeButton() throws Exception{		
	PageFunctionUtils.waitOnElement(driver, counterGuaranteeButton);
	PageFunctionUtils.clickOnElement(driver, counterGuaranteeButton);
	
	return this;
}


@Step("press on yes  button")
public ABEAddInwardGuaranteePage pressOnYesButton() throws Exception{		
	PageFunctionUtils.waitOnElement(driver, yesButton);
	PageFunctionUtils.clickOnElement(driver, yesButton);
	
	return this;
}
	   
	   
	   
	   

@Step("press on guarantee continue button")
public ABEAddInwardGuaranteePage pressOnGuaranteeContinueButton() throws Exception{		
	PageFunctionUtils.waitOnElement(driver, guaranteeDetailsContinueButton);
	PageFunctionUtils.clickOnElement(driver, guaranteeDetailsContinueButton);
	
	return this;
}

@Step("press limit continue button")
public ABEAddInwardGuaranteePage pressLimitContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, continueLimitButton);
	PageFunctionUtils.clickOnElement(driver, continueLimitButton);
	return this;
}


@Step("press margin continue button")
public ABEAddInwardGuaranteePage pressMarginContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, continueMarginButton);
	PageFunctionUtils.clickOnElement(driver, continueMarginButton);
	return this;
}



@Step("press charges continue button")
public ABEAddInwardGuaranteePage pressChargesContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, chargesContinueButton);
	PageFunctionUtils.clickOnElement(driver, chargesContinueButton);
	return this;
}




@Step("press instruction continue button")
public ABEAddInwardGuaranteePage pressInstructionContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, instructionContinueButton);
	PageFunctionUtils.clickOnElement(driver,instructionContinueButton);
	return this;
}




@Step("press tracer continue button")
public ABEAddInwardGuaranteePage pressTracerContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, tracerContinueButton);
	PageFunctionUtils.clickOnElement(driver, tracerContinueButton);
	return this;
}




@Step("press text continue button")
public ABEAddInwardGuaranteePage pressTextContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, textContinueButton);
	PageFunctionUtils.clickOnElement(driver, textContinueButton);
	return this;
}



@Step("press message continue button")
public ABEAddInwardGuaranteePage pressMessageContinueButton() throws Exception{
	PageFunctionUtils.waitOnElement(driver, messageContinueButton);
	PageFunctionUtils.clickOnElement(driver, messageContinueButton);
	return this;
}





	
@Step("Press submit button")
public ABEAddInwardGuaranteePage pressSubmitButton() throws Exception {
	
   PageFunctionUtils.waitOnElement(driver, submitButton);
   PageFunctionUtils.clickOnElement(driver, submitButton);
   PageFunctionUtils.acceptWarning(driver);
	Thread.sleep(3500);
	acId = driver.findElement(guaranteeId).getText();
	System.out.println("Guarantee Number ID: "+ acId); 
	return this;
}



@Step("Save guarantee. id")
public ABEAddInwardGuaranteePage saveGuaranteeId(String linkedTcid1) throws Exception {
int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ADDINWARDGUARANTEECSV, linkedTcidInwardCsvColumnName, linkedTcid1);
int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ADDINWARDGUARANTEECSV, guaranteeInwardCsvColumnName);


int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VERIFYINWARDGUARANTEECSV, linkedTcidInwardCsvColumnName, linkedTcid1);
int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VERIFYINWARDGUARANTEECSV, guaranteeInwardNumberIdCsvColumnName);



if(rowByTcid1 != -1 && rowByTcid2 != -1) {

	CSVUtils.insertValueInCsvCell(Paths.ADDINWARDGUARANTEECSV, rowByTcid1, columnByColumnName1, acId);
	CSVUtils.insertValueInCsvCell(Paths.VERIFYINWARDGUARANTEECSV, rowByTcid2, columnByColumnName2, acId);
	

}
return this;
}

	
}
