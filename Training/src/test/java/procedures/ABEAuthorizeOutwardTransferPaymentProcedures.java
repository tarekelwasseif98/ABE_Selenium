package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEAuthorizeOutwardTransferPaymentData;
import pageobjects.ABEAuthorizeOutwardTransferPaymentPage;

public class ABEAuthorizeOutwardTransferPaymentProcedures {
	
	public static void AuthorizeAchOutwardBychecker(WebDriver driver, ABEAuthorizeOutwardTransferPaymentData data) throws Exception {
		ABEAuthorizeOutwardTransferPaymentPage ABEAuthorizeOutwardTransferPaymentPage = new ABEAuthorizeOutwardTransferPaymentPage(driver);
		ABEAuthorizeOutwardTransferPaymentPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysPaymentOrder(data.getPaysysID(), data.getPos())
		                                .pressGOButton()
		                                .pressApproveButton();         
	}
}