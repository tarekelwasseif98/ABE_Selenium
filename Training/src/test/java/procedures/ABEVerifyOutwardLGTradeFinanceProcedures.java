package procedures;

import utils.FinacleFieldsUtils;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyOVDData;
import data.ABEVerifyOutwardLGTradeFinanceData;
import pageobjects.ABEVerifyOVDPage;
import pageobjects.ABEVerifyOutwardLGTradeFinancePage;
import utils.PageFunctionUtils;
public class ABEVerifyOutwardLGTradeFinanceProcedures {

	
	public static void outwardLGTradeFinanceByChecker(WebDriver driver, ABEVerifyOutwardLGTradeFinanceData data) throws Exception {
	
		ABEVerifyOutwardLGTradeFinancePage VerifyOutwardLGTradeFinancePage = new ABEVerifyOutwardLGTradeFinancePage(driver);		
		VerifyOutwardLGTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
		                               .switchFormAreaFrame()
		                               .sendKeysAccountIdTextField(data.getGuaranteeId())
		                               .pressGoButton()
		                               .pressGeneralDetailsContinueButton()
		                               .pressPartyContinueButton()
		                               .pressGuaranteeContinueButton()
		                               .pressLimitContinueButton()
		                               .pressMarginContinueButton()
		                               .pressChargesContinueButton()
		                               .pressInstructionContinueButton()
		                               .pressTracerContinueButton()
		                               .pressTextContinueButton();
	    FinacleFieldsUtils FinacleFields  = new FinacleFieldsUtils();
		                          if  (data.getPaymentStatus() != null && data.getPaymentStatus().equals(FinacleFields.PAYMENTSTATUSREADY)) {   
       VerifyOutwardLGTradeFinancePage.pressFirstViewMessageButton()
                                      .selectPaymentStatus(data.getPaymentStatus())
                                      .pressAcceptFirstMessageButton()
                                      .pressCloseFirstMessageButton()
                                      .pressSecondViewMessageButton()
                                      .select2PaymentStatus(data.getPaymentStatus())
                                      .pressAcceptSecondMessageButton()
                                      .pressCloseSecondMessageButton()
                                      .pressMessageContinueButton();
		                        	  
		                          }else if(data.getPaymentStatus() == null) {
		VerifyOutwardLGTradeFinancePage.pressMessageContinueButton();
		                        	  
		                          }
		                          
		VerifyOutwardLGTradeFinancePage.pressSubmitButton();
		
	}
	
	
}
