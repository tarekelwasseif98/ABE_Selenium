package procedures;

import org.openqa.selenium.WebDriver;
import data.ABECreateSTOData;
import pageobjects.ABECreateSTOPage;
import utils.FinacleFieldsUtils;

public class ABECreateSTOProcedures {

	public static void CreateSTOByMaker(WebDriver driver, ABECreateSTOData data) throws Exception {
		ABECreateSTOPage ABECreateSTOPage = new ABECreateSTOPage(driver);
		ABECreateSTOPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysPaymentType(data.getModuleID())
		                                .pressGoButton()
		                                .sendKeysSTO(data.getAccount(), 
		                                		data.getCCY(),
		                                		data.getPreferred_PaySys_ID(),
		                                		data.getAccountOtherParty(),
		                                		data.getOtherPartyName(),
		                                		data.getBank_BEN(), 
		                                		data.getBranch_BEN());
		                                if(data.getAmtType().equalsIgnoreCase(FinacleFieldsUtils.AMOUNTTYPEFIXED))
		                                {ABECreateSTOPage.sendAmountTypeFixedSTO(
		                                		data.getAmount_Fixed(),		                     
		                                		data.getStart_Date(),
		                                		data.getNo_Executed(),
		                                		data.getFrequency(), 		                                				                                		
		                                		data.getValue_of_N());
		                                }
		                                else if(data.getAmtType().equalsIgnoreCase(FinacleFieldsUtils.AMOUNTTYPEDERIVED))
		                                {ABECreateSTOPage.sendAmountTypeDerivedSTO(
		                                		data.getAmount_Derived(),
		                                		data.getAmount_Multiples_Derived(),
		                                		data.getStart_Date(),
		                                		data.getNo_Executed(),
		                                		data.getFrequency(), 
		                                		data.getValue_of_N());
		                                }
		                                ABECreateSTOPage.submitSTO(data.getMaintenance_Charge_Event_ID());
		                                ABECreateSTOPage.saveSTO(data.getLinkedTcid());
	}
}