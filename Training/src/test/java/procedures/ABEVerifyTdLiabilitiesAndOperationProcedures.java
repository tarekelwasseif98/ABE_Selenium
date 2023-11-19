package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEVerifyTdLiabilitiesAndOperationData;
import pageobjects.ABEVerifyTdLiabilitiesAndOperationPage;

public class ABEVerifyTdLiabilitiesAndOperationProcedures {
	
	public static void ABEVerifyTdLiabilitiesAndOperationByChecker(WebDriver driver, ABEVerifyTdLiabilitiesAndOperationData data) throws Exception {
		ABEVerifyTdLiabilitiesAndOperationPage ABEVerifyTdLiabilitiesAndOperationByChecker = new ABEVerifyTdLiabilitiesAndOperationPage(driver);
		ABEVerifyTdLiabilitiesAndOperationByChecker.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .selectFuntionCodeType()
									  .sendKeysAccountId(data.getAccountId())
									  .pressGoButton()
									  .pressSubmitButton();
		try {
			
        	ABEVerifyTdLiabilitiesAndOperationByChecker.getSuccessMessageText();

		} catch (Exception e) {

	        try {
	        	ABEVerifyTdLiabilitiesAndOperationByChecker.handleAlert();
	        } catch (Exception e1) {
	        	ABEVerifyTdLiabilitiesAndOperationByChecker.submitAssertion();

	        }
		
									 
									
		}
	}
}
