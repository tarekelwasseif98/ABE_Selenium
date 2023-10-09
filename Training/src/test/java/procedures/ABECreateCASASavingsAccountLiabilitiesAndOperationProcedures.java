package procedures;

import org.openqa.selenium.WebDriver;
import data.ABECreateCASASavingsAccountLiabilitiesAndOperationData;
import pageobjects.ABECreateCASASavingsAccountLiabilitiesAndOperationPage;

public class ABECreateCASASavingsAccountLiabilitiesAndOperationProcedures {

	public static void Casa_CreateSavingsAccountByMaker(WebDriver driver, ABECreateCASASavingsAccountLiabilitiesAndOperationData data) throws Exception {
		ABECreateCASASavingsAccountLiabilitiesAndOperationPage Casa_CreateSavingsAccountByMaker = new ABECreateCASASavingsAccountLiabilitiesAndOperationPage(driver);
		Casa_CreateSavingsAccountByMaker.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeysAccoundDetails( data.getCif(),  data.getSchemeCode(),  data.getCcy())
									  .pressSubmitButton()
									  .saveAccountId(data.getLinkedTcid());
									
		}
}
