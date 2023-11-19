package procedures;

import org.openqa.selenium.WebDriver;

import data.ABETellerOperationTransferLiabilitiesAndOperationData;
import pageobjects.ABETellerOperationTransferLiabilitiesAndOperationPage;


public class ABETellerOperationTransferLiabilitiesAndOperationProcedures {
	
	public static void tellerTransferByMaker(WebDriver driver, ABETellerOperationTransferLiabilitiesAndOperationData data) throws Exception {
		ABETellerOperationTransferLiabilitiesAndOperationPage ABETellerOperationTransferLiabilitiesAndOperation = new ABETellerOperationTransferLiabilitiesAndOperationPage(driver);
		ABETellerOperationTransferLiabilitiesAndOperation.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendTransactionType()
									  .pressGoButton()
									  .pressAddButton()
									  .ClickOnDebitRadioButton()
									  .SendKeysAccountId(data.getAccountIdDr())
									  .SendKeysTransactionAmmount(data.getTransactionAmount())
									  .SendKeysCcyDr(data.getCcyDr())
									  .PressOnSaveAndAddNewButton()
									  .PressCrRadioButton()
									  .sendKeysCrAccountId(data.getAccountIdCr())
									  .sendKeystransactionAmmount(data.getTransactionAmount())
									  .sendKeystransactionCcy(data.getCcyCr())
									  .PressSaveAndPreviewButton()
									  .saveTransactionId(data.getTcId());
//		String bc= ABETellerOperationTransferLiabilitiesAndOperation.FindRateCodeColor();
//		if (bc.contains("rgb(255, 0, 0)")) {
//			ABETellerOperationTransferLiabilitiesAndOperation.ScrollAndSwitchToFormArea();
//			driver.quit();
//			
//		} else {
//		    System.out.println("no error indicated by color");
//		   
//		}
//		
//		ABETellerOperationTransferLiabilitiesAndOperation.saveTransactionId(data.getTcId());
//
//									
		}

}