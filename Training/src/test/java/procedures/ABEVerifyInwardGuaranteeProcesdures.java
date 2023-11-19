package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyInwardGuaranteeData;
import pageobjects.ABEVerifyInwardGuaranteePage;
import utils.FinacleFieldsUtils;

public class ABEVerifyInwardGuaranteeProcesdures {

	
	

	public static void verifyInwardGuaranteeByChecker(WebDriver driver, ABEVerifyInwardGuaranteeData data) throws Exception {
		ABEVerifyInwardGuaranteePage verifyInwardGuaranteePage = new ABEVerifyInwardGuaranteePage(driver);
		
		verifyInwardGuaranteePage.sendKeysSearchBarTextField(data.getMenu())
                                  .switchFormAreaFrame()
                                  .sendKeysAccountIdTextField(data.getGuaranteeNumberReferenceId())
                                  .pressGoButton()
                                  .pressGeneralDetailsContinueButton()
                                  .pressPartyContinueButton()
                                  .pressGuaranteeContinueButton()
                                  .pressLimitContinueButton()
                                  .pressMarginContinueButton()
                                  .pressChargesContinueButton()
                                  .pressInstructionContinueButton()
                                  .pressTracerContinueButton()
                                  .pressTextContinueButton()
                                  .pressMessageContinueButton()
                           	      .pressSubmitButton()
                          		  .saveGuaranteeId(data.getGuaranteeNumberReferenceId());
       
	}
	
		
	
}
