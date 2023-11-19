package procedures;

import org.openqa.selenium.WebDriver;

import data.ABECreateCASACurrentAccountLiabilitiesAndOperationData;
import pageobjects.ABECreateCASACurrentAccountLiabilitiesAndOperationPage;

public class ABECreateCASACurrentAccountLiabilitiesAndOperationProcedures {

	public static void Casa_CreateCurrentAccountByMaker(WebDriver driver, ABECreateCASACurrentAccountLiabilitiesAndOperationData data) throws Exception {
		ABECreateCASACurrentAccountLiabilitiesAndOperationPage createCasaCurrentAccountByMaker = new ABECreateCASACurrentAccountLiabilitiesAndOperationPage(driver);
		createCasaCurrentAccountByMaker.sendKeysSearchBarTextField(data.getMenu())
									   .switchFormAreaFrame()
									   .sendKeysCif(data.getCif())
									   .sendKeysSchemeCode(data.getSchemeCode())
									   .sendKeysCcy(data.getCcy())
									   .PressGoButton()
									   .pressSubmitButton()
									   .saveAccountId(data.getLinkedTcid());
									
		}
}
