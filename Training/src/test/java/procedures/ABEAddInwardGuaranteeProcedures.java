package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEAddInwardGuaranteeData;
import pageobjects.ABEAddInwardGuaranteePage;

public class ABEAddInwardGuaranteeProcedures {

	
	
	
	public static void addInwardGuaranteeByMaker(WebDriver driver, ABEAddInwardGuaranteeData data) throws Exception {
		ABEAddInwardGuaranteePage AddInwardGuaranteePage = new ABEAddInwardGuaranteePage(driver);
		                           AddInwardGuaranteePage.sendKeysSearchBarTextField(data.getMenu())
	                                  .switchFormAreaFrame()
	                                  .sendkeysGuaranteeTypeField(data.getGuaranteeType())
	                                  .sendkeysCurrencyDetails(data.getCurrency())
	                                  .sendKeysCustomerDetailsCIF(data.getCif())
	                                  .goButton()
	                                  .sendkeysGuaranteeAmount(data.getGuaranteeAmount())
	                                  .pressGeneralDetailsContinueButton()
	                                  .sendkeysBeneficiaryName(data.getName())
	                                  .sendkeysBeneficiaryAddress(data.getAddress())
	                                  .pressOnPartyContinueButton()
	                                  .sendkeysExpiryDate(data.getExpiryDate())
	                                  .sendkeysclaimDate(data.getClaimDate())
	                                  .selectApplicableRules(data.getRulesdropdown())
	                                  .pressOnCounterGuaranteeButton()
	                                  .pressOnGuaranteeContinueButton()
	                                  .pressOnYesButton()
	                                  .pressLimitContinueButton()
	                                  .pressMarginContinueButton()
	                                  .pressChargesContinueButton()
	                                  .pressInstructionContinueButton()
	                                  .pressTracerContinueButton()
	                                  .pressTextContinueButton()
                                      .pressMessageContinueButton()	                                
	                                  .pressSubmitButton()
                                      .saveGuaranteeId(data.getGuaranteeNumberReference());		   
	}
}
