package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyOutwardTransferPaymentData;
import pageobjects.ABEVerifyOutwardTransferPaymentPage;

public class ABEVerifyOutwardTransferPaymentProcedures {
	
	public static void verifyAchOutwardBychecker(WebDriver driver, ABEVerifyOutwardTransferPaymentData data) throws Exception {
		ABEVerifyOutwardTransferPaymentPage ABEVerifyOutwardTransferPaymentPage = new ABEVerifyOutwardTransferPaymentPage(driver);
		ABEVerifyOutwardTransferPaymentPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysPaymentOrder(data.getPos())
		                                .pressGOButton()
		                                .pressSubmitButton();             
	}
}
