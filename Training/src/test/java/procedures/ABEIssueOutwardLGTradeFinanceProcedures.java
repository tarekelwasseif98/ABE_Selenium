package procedures;

import org.openqa.selenium.WebDriver;

import utils.FinacleFieldsUtils;
import data.ABEIssueOutwardLGTradeFinanceData;
import pageobjects.ABEIssueOutwardLGTradeFinancePage;
import utils.PageFunctionUtils;

public class ABEIssueOutwardLGTradeFinanceProcedures {
	
	public static void issueOutwardPaymentLGTradeFinanceByMaker(WebDriver driver, ABEIssueOutwardLGTradeFinanceData data) throws Exception {
		ABEIssueOutwardLGTradeFinancePage IssueOutwardLGTradeFinancePage = new ABEIssueOutwardLGTradeFinancePage(driver);
		IssueOutwardLGTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
		                                  .switchFormAreaFrame();
		   IssueOutwardLGTradeFinancePage.sendkeysGuaranteeTypeField(data.getGuaranteeType())
		                                  .sendkeysCurrencyDetails(data.getCurrency())
		                                  .sendKeysCustomerDetailsCIF(data.getCif())
		                                  .goButton()
		                                  .sendkeysGuaranteeAmount(data.getGuaranteeAmount());		                                                
		    FinacleFieldsUtils FinacleFields  = new FinacleFieldsUtils();
		    
		    //LOBID //LOPER
		                 if(data.getGuarantee().equals(FinacleFields.GUARANTEETYPELOBID) || data.getGuarantee().equals(FinacleFields.GURANATEETYPELOPER)) {		    
		    IssueOutwardLGTradeFinancePage.pressGeneralDetailsContinueButton()
		                                  .sendkeysBeneficiaryName(data.getName())
		                                  .sendkeysBeneficiaryAddress(data.getAddress())
		                                  .pressOnPartyContinueButton()
		                                  .enterPurposeOfGuarantee(data.getPurposeGuarantee())
		                                  .sendkeysExpiryDate(data.getExpiryDate())
		                                  .sendkeysclaimDate(data.getClaimDate())
		                                  .selectApplicableRules(data.getRulesdropdown())		                                 
		                                  .pressOnGuaranteeContinueButton()
		                                  .sendkeysLimitFields(data.getLimitId1(), data.getLimitId2())
		                                  .pressLimitContinueButton()
		                                  .pressMarginContinueButton()
		                                  .pressChargesContinueButton()
		                                  .pressInstructionContinueButton()
		                                  .pressTracerContinueButton()
		                                  .pressTextContinueButton()
                                          .pressMessageContinueButton()	                                
		                                  .pressSubmitButton()
                                          .saveAccountId(data.getLinkedTcid());
		    //FBIDG //FPERG
	             }else if(data.getGuarantee().equals(FinacleFields.GURANATEETYPEFBIDG) || data.getGuarantee().equals(FinacleFields.GURANATEETYPEFPERG)) {
	            	 
	            		 IssueOutwardLGTradeFinancePage.senkeysBankAccount(data.getBankAccountReference())
		                 .senkeysPaySysId(data.getPaySysID())
                         .pressGeneralDetailsContinueButton()
                         .sendkeysBeneficiaryName(data.getName())
                         .sendkeysBeneficiaryAddress(data.getAddress());
              if (data.getAddressType().equals(FinacleFields.ADDRESSTYPEBANKIDENTIFIER)) {          	            		
            	 IssueOutwardLGTradeFinancePage.enterBankIdentifier(data.getBankIdentifier());
              }else if(data.getAddressType().equals(FinacleFields.ADDRESSTYPENAMEANDADDRESS)) {
            	  IssueOutwardLGTradeFinancePage.enterAdvisingName(data.getAdvisingName())
            	                                .enterAdvisingAddress(data.getAdvisingAddress())
            	                                .enterCityField(data.getCity())
            	                                .enterStateField(data.getState())
            	                                .enterCountryField(data.getCountry())
            	                                .enterPostalCodeField(data.getPostalCode());
            	               
              }
            	 IssueOutwardLGTradeFinancePage.pressOnPartyContinueButton();
            	if(data.getPurposeGuarantee() !=null) {
            		IssueOutwardLGTradeFinancePage.enterPurposeOfGuarantee(data.getPurposeGuarantee());
            	}
            	IssueOutwardLGTradeFinancePage.sendkeysExpiryDate(data.getExpiryDate())
                         .sendkeysclaimDate(data.getClaimDate())                         
                         .selectApplicableRules(data.getRulesdropdown());  
         //OCBID   	
            if( data.getGuarantee().equals(FinacleFields.GURANATEETYPEOCBID)) {
                        	 IssueOutwardLGTradeFinancePage.senkeysBankAccount(data.getBankAccountReference())
    		                 .senkeysPaySysId(data.getPaySysID())
                             .pressGeneralDetailsContinueButton()
                             .sendkeysBeneficiaryName(data.getName())
                             .sendkeysBeneficiaryAddress(data.getAddress());
                  if (data.getAddressType().equals(FinacleFields.ADDRESSTYPEBANKIDENTIFIER)) {          	            		
                	 IssueOutwardLGTradeFinancePage.enterBankIdentifier(data.getBankIdentifier());
                  }else if(data.getAddressType().equals(FinacleFields.ADDRESSTYPENAMEANDADDRESS)) {
                	  IssueOutwardLGTradeFinancePage.enterAdvisingName(data.getAdvisingName())
                	                                .enterAdvisingAddress(data.getAdvisingAddress())
                	                                .enterCityField(data.getCity())
                	                                .enterStateField(data.getState())
                	                                .enterCountryField(data.getCountry())
                	                                .enterPostalCodeField(data.getPostalCode());
                	               
                  }
                	 IssueOutwardLGTradeFinancePage.pressOnPartyContinueButton();
                	if(data.getPurposeGuarantee() !=null) {
                		IssueOutwardLGTradeFinancePage.enterPurposeOfGuarantee(data.getPurposeGuarantee());
                	}
                	IssueOutwardLGTradeFinancePage.sendkeysExpiryDate(data.getExpiryDate())
                             .sendkeysclaimDate(data.getClaimDate())                         
                             .selectApplicableRules(data.getRulesdropdown())         
                        	  .selectCounterGuranteeMenu()
                              .enterGuaranteeNumber(data.getGuaranteeNumberId())
                              .enterRateCode(data.getRateCode());                        	 
                         }
            	 
                         IssueOutwardLGTradeFinancePage.selectGuaranteeAdditionalDetails()		                               
                         .enterpurposeOfMessage(data.getMessage())
                        .pressOnGuaranteeContinueButtonForPurposeMessage()
                        .sendkeysLimitFields(data.getLimitId1(), data.getLimitId2())
                         .pressLimitContinueButton()
                         .pressMarginContinueButton()
                         .pressChargesContinueButton()
                         .pressInstructionContinueButton()
                         .pressTracerContinueButton()
                         .pressTextContinueButton()
                         .selectMessageType(data.getMessageMenu())
                         .enterReceivingBank(data.getReceivingBank())
                         .clickOnGenerateButton()
                         .clickOnFirstEditButton()
                         .clickOnAcceptFirstMessageButton()
                         .clickOnUpdateFirstButton()
                         .clickOnSecondEditButton()
                         .clickOnEditNarrativeButton()                       
                         .enterNarrativeTextField(data.getNarrativeText())
                         .clickOnSaveButton()
                         .acceptSecondMessageButton()
                         .clickOnUpdateSecondButton()
                         .pressMessageContinueButton()	                                
                         .pressSubmitButton()
                         .saveAccountId(data.getLinkedTcid());
	}
}
	}
