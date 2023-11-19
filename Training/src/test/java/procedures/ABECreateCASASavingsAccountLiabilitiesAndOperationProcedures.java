package procedures;
import org.openqa.selenium.WebDriver;
import data.ABECreateCASASavingsAccountLiabilitiesAndOperationData;
import pageobjects.ABECreateCASASavingsAccountLiabilitiesAndOperationPage;
import utils.AssertionFactory;

public class ABECreateCASASavingsAccountLiabilitiesAndOperationProcedures {

	public static void Casa_CreateSavingsAccountByMaker(WebDriver driver, ABECreateCASASavingsAccountLiabilitiesAndOperationData data) throws Exception {
		ABECreateCASASavingsAccountLiabilitiesAndOperationPage Casa_CreateSavingsAccountByMaker = new ABECreateCASASavingsAccountLiabilitiesAndOperationPage(driver);
		Casa_CreateSavingsAccountByMaker.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeyscCif(data.getCif())
									  .sendKeysSchemeCode(data.getSchemeCode())
									  .sendKeysCcy(data.getCcy())
									  .pressGoButton();
									  
		try {
			//check error message
			boolean isErrorMessageDisplayed=Casa_CreateSavingsAccountByMaker.CheckErrorMessage();
			if(isErrorMessageDisplayed==true) {
				AssertionFactory.assertionFailWithMessage("Error message displayed while opening the account");	
			} else {
				Casa_CreateSavingsAccountByMaker.SwtitchToformAreaFrame();
				}
		} catch (Exception e) {
			Casa_CreateSavingsAccountByMaker.SwtitchToformAreaFrame();
			}	
		Casa_CreateSavingsAccountByMaker.pressSubmitButton()
									  .saveAccountId(data.getLinkedTcid());
									
		}
}
