package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData;
import pageobjects.ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationPage;

public class ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationProcedures {

	public static void Casa_VerifySavingsAccountByMaker(WebDriver driver, ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData data) throws Exception {
		ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationPage Casa_VerifySavingsAccountByMaker = new ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationPage(driver);
		Casa_VerifySavingsAccountByMaker.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeysAcidTextField(data.getAccountId())
									  .pressGoButton()
									  .pressContinueButton()
									  .pressSubmitButton();
//									  .saveAccountId(data.getLinkedTcId())
									
		}
	
}
