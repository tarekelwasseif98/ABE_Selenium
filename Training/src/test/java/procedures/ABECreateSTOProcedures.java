package procedures;

import org.openqa.selenium.WebDriver;
import data.ABECreateSTOData;
import pageobjects.ABECreateSTOPage;

public class ABECreateSTOProcedures {

	public static void CreateSTOByMaker(WebDriver driver, ABECreateSTOData data) throws Exception {
		ABECreateSTOPage ABECreateSTOPage = new ABECreateSTOPage(driver);
		ABECreateSTOPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysPaymentType(data.getModuleID());
//		                                .pressSubmitButton()
//		                                .sendKeysAchOutwardPayment(
//		                                		data.getCountryCode_REM(),
//		                                		data.getWaiveChargeRemark(),
//		                                		data.getChargeWaiveOption(),
//		                                		data.getCharge_type(), 
//		                                		data.getAccount(),
//		                                		data.getCCY(), 
//		                                		data.getName_REM() , 
//		                                		data.getAddress1_BEN(), 
//		                                		data.getAddress2_BEN(),
//		                                		data.getPurpose_Code() ,
//		                                		data.getAddress1_REM(),
//		                                		data.getAddress2_REM(),
//		                                		data.getAmount(),
//		                                		data.getDate(),
//		                                		data.getLine1(), 
//		                                		data.getAccount_ben(),
//		                                		data.getName_ben(),  
//		                                		data.getBic_ben(), 
//		                                		data.getNetwork_ben(),
//		                                		data.getBank_ben(), 
//		                                		data.getBranch_ben())
//		                                .saveACHPO(data.getPaysysID(), data.getLinkedTcid());
		
	}
	
}