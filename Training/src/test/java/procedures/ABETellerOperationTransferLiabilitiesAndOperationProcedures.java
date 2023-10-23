package procedures;

import org.openqa.selenium.WebDriver;

import data.ABETellerOperationTransferLiabilitiesAndOperationData;
import pageobjects.ABETellerOperationTransferLiabilitiesAndOperationPage;

public class ABETellerOperationTransferLiabilitiesAndOperationProcedures {
	
	public static void tellerTransferByMaker(WebDriver driver, ABETellerOperationTransferLiabilitiesAndOperationData data) throws Exception {
		ABETellerOperationTransferLiabilitiesAndOperationPage OpenOfficeAccountPage = new ABETellerOperationTransferLiabilitiesAndOperationPage(driver);
		OpenOfficeAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendTransactionType()
									  .sendDebitorDetails(data.getAccountIdDr(), data.getCcyDr(), data.getTransactionAmount())
									  .sendCreditorDetails(data.getAccountIdCr(), data.getCcyCr(), data.getTransactionAmount())
									  .saveTransactionId(data.getTcId());

									
		}


}