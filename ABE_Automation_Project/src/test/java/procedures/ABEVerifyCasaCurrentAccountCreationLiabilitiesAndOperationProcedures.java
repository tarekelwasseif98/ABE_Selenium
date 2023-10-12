package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData;
import pageobjects.ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage;

public class ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationProcedures {

	public static void Casa_VerifyCurrentAccountByMaker(WebDriver driver, ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationData data) throws Exception {
		ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage Casa_VerifyCurrentAccountByMaker = new ABEVerifyCasaCurrentAccountCreationLiabilitiesAndOperationPage(driver);
		Casa_VerifyCurrentAccountByMaker.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeysAcidTextField(data.getAccountId())
									  .pressSubmitButton();
//									  .saveAccountId(data.getLinkedTcId())
									
		}
	
}
