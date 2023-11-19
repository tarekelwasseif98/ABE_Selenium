
package pageobjects;

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

public class ABEOpenOVDPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']"); 
	
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	
	
	private By cifIdTextField = By.xpath("(//input[@id='_critCif'])[1]");	
	private By schemeCodeTextField = By.xpath("(//input[@id='_critSchmCode'])[1]");
	private By currencyField = By.xpath("(//input[@id='_crncyCode'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	
    private By documentDateField = By.xpath("(//input[@id='_docDate'])[1]");
	private By expiryDateField = By.xpath("(//input[@id='_acLmtExpDte'])[1]");
	
	
	private By addButton = By.xpath("(//span[@id='_intSlabGrid_AddRecBtn'])[1]");
	private By tenorOfSlabField = By.xpath("(//input[@id='_tenorofSlab$duration1'])[1]");	
	private By saveAndPreviewButton = By.xpath("(//button[@id='_intSlabDetI_addViewSummary'])[1]");
	private By additionalContinueButton = By.xpath("(//button[@id='_acctDetCon'])[1]");
	
	private By generalContinueButton = By.xpath("(//button[@id='_genContinue'])[1]");
	
	private By signatureContinueButton = By.xpath("(//button[@id='_sigMandCon'])[1]");
	
	private By accountContinueButton = By.xpath("(//button[@id='_actLmtCont'])[1]");
	
	
	private By interestContinueButton = By.xpath("(//button[@id='_intcontinue'])[1]");
	private By schemeContinueButton = By.xpath("(//button[@id='_schmCont'])[1]");
	private By revolvingContinueButton = By.xpath("(//button[@id='_revolODCont'])[1]");
	private By relatedContinueButton = By.xpath("(//button[@id='_relcontinue'])[1]");
	private By collateralAddButton = By.xpath("(//span[@id='_linkCollGrid_AddRecBtn'])[1]");
	private By collateralCodeField = By.xpath("(//input[@id='_colateralCde'])[1]");
	private By apportionedAmountField = By.xpath("(//input[@id='_aportndAmt$amt'])[1]");
	private By entityIDField = By.xpath("(//input[@id='_entityId'])[1]");
	private By loanToValue = By.xpath("(//input[@id='_loanToValue'])[1]");
	
	private By collateralSaveAndPreviewButton = By.xpath("(//button[@id='_linkColDetI_addViewSummary'])[1]");
	
	private By collateralSaveAndAddNewButton = By.xpath("(//button[@id='_linkColDetI_addCreateNew'])[1]");
	
	private By collateralContinueButton = By.xpath("(//button[@id='_linkCont'])[1]");
	private By documentContinueButton = By.xpath("(//button[@id='_docDtlCont1'])[1]");
	
	private By taxContinueButton = By.xpath("(//button[@id='_taxCont'])[1]");
	private By exceptionContinueButton = By.xpath("(//button[@id='_execContinue'])[1]");
	private By bankEmployeeContinueButton = By.xpath("(//button[@id='_staffCont1'])[1]");
	private By flexifixedContinueButton = By.xpath("(//button[@id='_ffd_ButtCon'])[1]");
	private By paymentContinueButton = By.xpath("(//button[@id='_payICont'])[1]");
	private By chargeContinueButton = By.xpath("(//button[@id='_feeDetCont'])[1]");
	private By baseContinueButton = By.xpath("(//button[@id='_baselCont'])[1]");
	private By freeTextOptions = By.xpath("(//h2[@id='_sec_misCdes2_headerTitle'])[1]");
	private By withdrawalField = By.xpath("(//textarea[@id='_misFreeTxt4_textArea'])[1]");
	private By missContinueButton = By.xpath("(//button[@id='_misContinue'])[1]");
    
	private By drawingPowerOptions = By.xpath("(//h2[normalize-space()='Drawing Power Details'])[1]");
	private By drawingPowerIdicatorMenu = By.xpath("(//select[@id='_drawinPwrInd_select'])[1]");
	
	private By turnOverRadioButton = By.xpath("(//input[@id='_turnno_radio'])[1]");
	
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");	
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	
	
	private By closeButton = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	

	public static String acId;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  accountIdCsvColumnName2 = "accountId2";
	
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	public static String linkedTcidCsvColumnName2 ="linkedTcid2";
	
	public ABEOpenOVDPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEOpenOVDPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEOpenOVDPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);	    
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;		
	}
	
	
	
	@Step("Sending customer CIF: {0}")
	public ABEOpenOVDPage sendKeysCustomerDetailsCIF(String cifid) throws Exception {
						
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		PageFunctionUtils.clickOnElement(driver, cifIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, cifIdTextField, cifid.substring(1));
		return this;
	}
		
		
	@Step("Sending customer scheme code: {0}")
	public ABEOpenOVDPage sendKeysCustomerDetailsSchemeCode(String schemeCode) throws Exception {	
		PageFunctionUtils.waitOnElement(driver, schemeCodeTextField);
		PageFunctionUtils.clickOnElement(driver, schemeCodeTextField);
		PageFunctionUtils.enterDataInWebElement(driver, schemeCodeTextField, schemeCode);
		return this;
	}
	
	
	
	@Step("Sending customer currency: {0}")
	public ABEOpenOVDPage sendKeysCustomerDetailsCurrency(String currency) throws Exception {	
		if(currency != null) {
			PageFunctionUtils.waitOnElement(driver, currencyField);		
			PageFunctionUtils.clearDataInWebElement(driver, currencyField);
			PageFunctionUtils.clickOnElement(driver, currencyField);
			PageFunctionUtils.enterDataInWebElement(driver, currencyField, currency);
			
		}
		return this;
	}
	
	
		
	@Step("press go button")
		public ABEOpenOVDPage goButton() throws Exception {			
	   PageFunctionUtils.clickOnElement(driver, goButton);	
		return this;		
	}
	
		
	
		
	@Step("sending customer account document date")
	public ABEOpenOVDPage sendKeysCustomerAccountDocumentDate(String documentDate) throws Exception {				
		PageFunctionUtils.waitOnElement(driver, documentDateField);		
		PageFunctionUtils.clearDataInWebElement(driver,documentDateField );
		PageFunctionUtils.clickOnElement(driver, documentDateField);
		PageFunctionUtils.enterDataInWebElement(driver, documentDateField, documentDate.substring(1));
	return this;
	}
	

	
	@Step("sending customer account expiry date")
	public ABEOpenOVDPage sendKeysCustomerAccountExpiryDate(String expiryDate) throws Exception {					
		PageFunctionUtils.waitOnElement(driver, expiryDateField);		
		PageFunctionUtils.clearDataInWebElement(driver,expiryDateField );
		PageFunctionUtils.clickOnElement(driver, expiryDateField);
		PageFunctionUtils.enterDataInWebElement(driver, expiryDateField, expiryDate.substring(1));
		return this;
	}	 
		 


	@Step("press Add button")
	public ABEOpenOVDPage pressAddButton() throws Exception {					
		PageFunctionUtils.clickOnElement(driver, addButton);
	return this;	 
	}
	

	@Step("tenor slab field")
	public ABEOpenOVDPage sendkeystenorFields( String tenor) throws Exception {	
		PageFunctionUtils.waitOnElement(driver, tenorOfSlabField);
		PageFunctionUtils.clickOnElement(driver, tenorOfSlabField);
		PageFunctionUtils.clearDataInWebElement(driver,tenorOfSlabField );
		PageFunctionUtils.enterDataInWebElement(driver, tenorOfSlabField, tenor);									
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewButton);			
		return this;		
	}	
	
	
	
	
	@Step("select drawing power details {0}")
	public ABEOpenOVDPage selectDrawingPower(String dropdownMenu) throws Exception {			    		
		PageFunctionUtils.waitOnElement(driver, drawingPowerOptions);
		PageFunctionUtils.clickOnElement(driver, drawingPowerOptions);
		PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIdicatorMenu, dropdownMenu);
	return this;	
	}
	
	
	@Step("press addidtional continue ")
	public ABEOpenOVDPage pressAddidtionalContinueButton() throws Exception {		
		PageFunctionUtils.waitOnElement(driver, additionalContinueButton);
	    PageFunctionUtils.clickOnElement(driver, additionalContinueButton);
	 return this;   
	}
	
	
	@Step("turn over")
	public ABEOpenOVDPage turnOver() throws Exception {		  						 
		    PageFunctionUtils.waitOnElement(driver, additionalContinueButton);
	         PageFunctionUtils.clickOnElement(driver, additionalContinueButton);
		     PageFunctionUtils.waitOnElement(driver, turnOverRadioButton);
		     PageFunctionUtils.clickOnElement(driver, turnOverRadioButton);
		     return this;
		     
	}
	
	@Step("press addidtional continue ")
	public ABEOpenOVDPage pressForSecuredRetail() throws Exception {		
        		PageFunctionUtils.waitOnElement(driver, additionalContinueButton);
   		        PageFunctionUtils.clickOnElement(driver, additionalContinueButton);
   		        return this;
        	}
			        
        	@Step("press general continue button")
        	public ABEOpenOVDPage pressGeneralContinueButton() throws Exception {		
         PageFunctionUtils.waitOnElement(driver, generalContinueButton);
	     PageFunctionUtils.clickOnElement(driver, generalContinueButton);

		return this;
	}
	

        	
        	
        	
	@Step("press on signature continue button ")
	public ABEOpenOVDPage pressSignatureContinueButton() throws Exception {
			     	     	     			     	     
	     PageFunctionUtils.waitOnElement(driver, signatureContinueButton);
	     PageFunctionUtils.clickOnElement(driver, signatureContinueButton);
	     return this;
	}
	  
	@Step("press on account continue button ")
	public ABEOpenOVDPage pressAccountContinueButton() throws Exception {
	     PageFunctionUtils.waitOnElement(driver, accountContinueButton);
	     PageFunctionUtils.clickOnElement(driver, accountContinueButton);
	    return this; 
	}
	
	@Step("press on interest continue button ")
	public ABEOpenOVDPage pressInterestContinueButton() throws Exception {
	     PageFunctionUtils.waitOnElement(driver, interestContinueButton);
	     PageFunctionUtils.clickOnElement(driver, interestContinueButton);
	  return this;   
	}
	 
	
	@Step("press on scheme continue button ")
	public ABEOpenOVDPage pressSchemeContinueButton() throws Exception {
	     PageFunctionUtils.waitOnElement(driver, schemeContinueButton);
	     PageFunctionUtils.clickOnElement(driver, schemeContinueButton);
	 return this;    
	} 
	
	@Step("press on revolving continue button ")
	public ABEOpenOVDPage pressRevolvingContinueButton() throws Exception {
	     PageFunctionUtils.waitOnElement(driver, revolvingContinueButton);
	     PageFunctionUtils.clickOnElement(driver, revolvingContinueButton);
	 return this;  
	}
	    
	
	@Step("press on related continue button ")
	public ABEOpenOVDPage pressRelatedContinueButton() throws Exception {
	     PageFunctionUtils.waitOnElement(driver, relatedContinueButton);
	     PageFunctionUtils.clickOnElement(driver, relatedContinueButton);	         	     	 
	     return this;
	}
	
	
	
	     @Step("Send keys to collateral details: {0}")
	 	public ABEOpenOVDPage addCollateralDetails(String collateralCode) throws Exception {   
				PageFunctionUtils.waitOnElement(driver, collateralAddButton);
    	 		PageFunctionUtils.clickOnElement(driver, collateralAddButton);
			    PageFunctionUtils.waitOnElement(driver, collateralCodeField);
				PageFunctionUtils.clickOnElement(driver, collateralCodeField);
				PageFunctionUtils.enterDataInWebElement(driver, collateralCodeField, collateralCode);								    	 
	    	 return this;
	    	 }
	     
	     
	     @Step("Send keys to collateral details: {0}")
	  	 public ABEOpenOVDPage sendkeysCollateralDetailsLoanValue(String modifyLoan) throws Exception {   
	  	        		    		    		 
					if (modifyLoan != null) {									    						
				PageFunctionUtils.waitOnElement(driver, loanToValue);
				PageFunctionUtils.clickOnElement(driver, loanToValue);
				PageFunctionUtils.clearDataInWebElement(driver,loanToValue );
				PageFunctionUtils.enterDataInWebElement(driver, loanToValue, modifyLoan.substring(1));					
					}
					return this;
                    }
	    	 
	     
	     
				 @Step("Send keys to collateral details: {0}")
				  public ABEOpenOVDPage sendkeysCollateralDetailsApportionedAmount(String apportionedAmount) throws Exception {   				  	     		
				PageFunctionUtils.waitOnElement(driver, apportionedAmountField);
				PageFunctionUtils.clickOnElement(driver, apportionedAmountField);
				PageFunctionUtils.clearDataInWebElement(driver,apportionedAmountField );
				PageFunctionUtils.enterDataInWebElement(driver, apportionedAmountField, apportionedAmount);
				 return this;
				 }
				 
				 
				@Step("Send keys to collateral details: {0}")
			  	public ABEOpenOVDPage sendkeysCollateralDetailsEntityId(String entityId) throws Exception {   			  			
				 PageFunctionUtils.waitOnElement(driver, entityIDField);
		         PageFunctionUtils.waitOnElement(driver, entityIDField);
				 PageFunctionUtils.clickOnElement(driver, entityIDField);
				 PageFunctionUtils.enterDataInWebElement(driver, entityIDField, entityId.substring(1));
				 return this;
				}
				
				 @Step("Press on collateral save button ")
				  public ABEOpenOVDPage pressCollateralSaveAndPreviewButton() throws Exception {   			  		
				 PageFunctionUtils.waitOnElement(driver, collateralSaveAndPreviewButton);
				 PageFunctionUtils.clickOnElement(driver, collateralSaveAndPreviewButton);
				 return this;
				 }
				 
				 
				@Step("Send keys to collateral details: {0}")
				 public ABEOpenOVDPage sendkeysForTwoEntitiesIds(String collateralCode,String entityId, String entityId1) throws Exception {    	
				PageFunctionUtils.waitOnElement(driver, collateralAddButton);
			    PageFunctionUtils.clickOnElement(driver, collateralAddButton);  		    		   			
			    PageFunctionUtils.waitOnElement(driver, collateralCodeField);
				PageFunctionUtils.clickOnElement(driver, collateralCodeField);
				PageFunctionUtils.enterDataInWebElement(driver, collateralCodeField, collateralCode);
	    
	    	 return this;
	    	 }
				
				
				@Step("Send keys to collateral details")
			  	 public ABEOpenOVDPage sendkeysForTwoEntitiesIdsLoanValue(String modifyLoan) throws Exception {   
			  	
				if (modifyLoan != null) {									    						
					PageFunctionUtils.waitOnElement(driver, loanToValue);
					PageFunctionUtils.clickOnElement(driver, loanToValue);
					PageFunctionUtils.clearDataInWebElement(driver,loanToValue );
					PageFunctionUtils.enterDataInWebElement(driver, loanToValue, modifyLoan.substring(1));					
						}
				return this;
				}
				

				@Step("Send keys to collateral details")
			   public ABEOpenOVDPage sendkeysForTwoEntitiesIdsApportionedAmount(String apportionedAmount) throws Exception {   		  		
				PageFunctionUtils.waitOnElement(driver, apportionedAmountField);
				PageFunctionUtils.clickOnElement(driver, apportionedAmountField);
				PageFunctionUtils.clearDataInWebElement(driver,apportionedAmountField );
				PageFunctionUtils.enterDataInWebElement(driver, apportionedAmountField, apportionedAmount);
				
				return this;
				}
				
				@Step("Send keys to collateral details")
			  	 public ABEOpenOVDPage sendkeysForEntityId1(String entityId1) throws Exception {   			  			
				     PageFunctionUtils.waitOnElement(driver, entityIDField);
			         PageFunctionUtils.waitOnElement(driver, entityIDField);
					 PageFunctionUtils.clickOnElement(driver, entityIDField);
					 PageFunctionUtils.enterDataInWebElement(driver, entityIDField, entityId1.substring(1));
					 return this;
				}
					 
				@Step("press on collateral save and preview button")
				public ABEOpenOVDPage pressCollateralSaveAndPreviewButton1() throws Exception {   
					  			 
					 PageFunctionUtils.waitOnElement(driver, collateralSaveAndPreviewButton);
					 PageFunctionUtils.clickOnElement(driver, collateralSaveAndPreviewButton);	
					 return this;
	    	 }
	    	
	    	
	    	 

			 
			@Step("press on collateral continue button")
			public ABEOpenOVDPage pressCollateralContinueButton() throws Exception {   				 
	    	 PageFunctionUtils.waitOnElement(driver, collateralContinueButton);
			 PageFunctionUtils.clickOnElement(driver, collateralContinueButton);	
				try {
	                PageFunctionUtils.switchToParentFrame(driver);
	                PageFunctionUtils.clickOnElement(driver, closeButton);
	                PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
	                } catch (Exception e) {
	                	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
	                	}
				return this;
			 }
			
		
	     @Step("press on document continue button")
	 	 public ABEOpenOVDPage pressDocumentContinueButton() throws Exception { 	   	   
	        PageFunctionUtils.waitOnElement(driver, documentContinueButton);
		    PageFunctionUtils.clickOnElement(driver, documentContinueButton);
	     return this;   
	     }
	     
	        
	     @Step("press on tax continue button ")
	 	 public ABEOpenOVDPage pressTaxContinueButton() throws Exception {  
	        PageFunctionUtils.waitOnElement(driver, taxContinueButton);
		     PageFunctionUtils.clickOnElement(driver, taxContinueButton);
		     return this;
	     }
	       
	     
	     @Step("press on exception continue button ")
	 	 public ABEOpenOVDPage pressExceptionContinueButton() throws Exception {  
		     PageFunctionUtils.waitOnElement(driver, exceptionContinueButton);
		     PageFunctionUtils.clickOnElement(driver, exceptionContinueButton);
	       return this; 
	     }
		     
	     
	     @Step("press on bank employee continue button ")
	 	 public ABEOpenOVDPage pressBankContinueButton() throws Exception {  
		     PageFunctionUtils.waitOnElement(driver, bankEmployeeContinueButton);
		     PageFunctionUtils.clickOnElement(driver, bankEmployeeContinueButton);
	       return this;
	     }
	     
	     @Step("press on flexi fixed continue button ")
	 	 public ABEOpenOVDPage pressFlexiContinueButton() throws Exception {  
		     PageFunctionUtils.waitOnElement(driver, flexifixedContinueButton);
		     PageFunctionUtils.clickOnElement(driver, flexifixedContinueButton);
	      return this;  
	     }
	     
	     
	     @Step("press on payment continue button ")
	 	 public ABEOpenOVDPage pressPaymentContinueButton() throws Exception {  
		     PageFunctionUtils.waitOnElement(driver, paymentContinueButton);
		     PageFunctionUtils.clickOnElement(driver, paymentContinueButton);
	      return this; 
	     }
	     
	     @Step("press on charge continue button ")
	 	 public ABEOpenOVDPage pressChargeContinueButton() throws Exception {  
		     PageFunctionUtils.waitOnElement(driver, chargeContinueButton);
		     PageFunctionUtils.clickOnElement(driver, chargeContinueButton);
	      return this;  
	     }
	     
	     @Step("press on base continue button ")
	 	 public ABEOpenOVDPage pressBaseContinueButton() throws Exception {  
		     PageFunctionUtils.waitOnElement(driver, baseContinueButton);
		     PageFunctionUtils.clickOnElement(driver, baseContinueButton);
		     return this;
	     }  
	     
	     @Step("press on free text options button ")
	 	 public ABEOpenOVDPage pressFreeOptionsButton() throws Exception {  
		     PageFunctionUtils.waitOnElement(driver, freeTextOptions);
		     PageFunctionUtils.clickOnElement(driver, freeTextOptions);
	      return this;   
	     }

	     @Step("enter withdrawal amount ")
	 	 public ABEOpenOVDPage sendkeysWithdrawalField(String withdrawal) throws Exception {  
			PageFunctionUtils.waitOnElement(driver, withdrawalField);
			PageFunctionUtils.clickOnElement(driver, withdrawalField);
			PageFunctionUtils.clearDataInWebElement(driver,withdrawalField );
			PageFunctionUtils.enterDataInWebElement(driver, withdrawalField, withdrawal);
			return this;	
	     }
			
	     @Step("press on miss continue button")
	 	 public ABEOpenOVDPage pressMissContinueButton() throws Exception {  
			 PageFunctionUtils.waitOnElement(driver, missContinueButton);
		     PageFunctionUtils.clickOnElement(driver, missContinueButton);			
		return this;
       	}
	

        
		
			
	@Step("Press submit button")
	public ABEOpenOVDPage pressSubmitButton() throws Exception {
		
		 PageFunctionUtils.waitOnElement(driver, submitButton);
	     PageFunctionUtils.clickOnElement(driver, submitButton);
	     PageFunctionUtils.acceptWarning(driver);
		Thread.sleep(3500);
		acId = driver.findElement(accountIdSuccessMessage).getText().substring(55);
		System.out.println("Account ID: "+ acId); 
		return this;
	}
	

	
@Step("Save a/c. id")
public ABEOpenOVDPage saveAccountId(String linkedId2, String linkedId) throws Exception {
	int rowByTcid1 = CSVUtils.getRowByTcid(Paths.OPENOVERDRAFTACCOUNTCSV, linkedTcidCsvColumnName2, linkedId2);
	int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.OPENOVERDRAFTACCOUNTCSV, referenceCsvColumnName);
		
	int rowByTcid2 = CSVUtils.getRowByTcid(Paths.MODIFYOVERDRAFTACCOUNTBEFOREVERIFICATIONCSV, tcIdCsvColumnName, linkedId2);
	int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.MODIFYOVERDRAFTACCOUNTBEFOREVERIFICATIONCSV, accountIdCsvColumnName2);
	
	int rowByTcid3 = CSVUtils.getRowByTcid(Paths.VERIFYOVERDRAFTACCOUNTCSV, tcIdCsvColumnName, linkedId);
	int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.VERIFYOVERDRAFTACCOUNTCSV, accountIdCsvColumnName);
	
	if(rowByTcid1 != -1 && rowByTcid2 != -1 && rowByTcid3 != -1) {
	
		CSVUtils.insertValueInCsvCell(Paths.OPENOVERDRAFTACCOUNTCSV, rowByTcid1, columnByColumnName1, acId);
		CSVUtils.insertValueInCsvCell(Paths.MODIFYOVERDRAFTACCOUNTBEFOREVERIFICATIONCSV, rowByTcid2, columnByColumnName2, acId);
	
		CSVUtils.insertValueInCsvCell(Paths.VERIFYOVERDRAFTACCOUNTCSV, rowByTcid3, columnByColumnName3, acId); 
	
	}
	
	return this;
}
	
}
		
