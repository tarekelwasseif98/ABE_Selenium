package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifySTOData;

import pageobjects.ABEVerifySTOPage;

public class ABEVerifySTOProcedures {
	
	public static void verifySTOBychecker(WebDriver driver, ABEVerifySTOData data) throws Exception {
		ABEVerifySTOPage ABEVerifySTOPage = new ABEVerifySTOPage(driver);
		ABEVerifySTOPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysMandateRef(data.getMandate())
		                                .pressGOButton()
		                                .pressSubmitButton();             
	}
}
