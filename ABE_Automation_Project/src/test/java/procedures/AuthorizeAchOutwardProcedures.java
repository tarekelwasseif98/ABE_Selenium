package procedures;

import org.openqa.selenium.WebDriver;

import data.AuthorizeACHOutwardData;
import pageobjects.AuthorizeACHOutwardPage;

public class AuthorizeAchOutwardProcedures {
	
	public static void AuthorizeAchOutwardBychecker(WebDriver driver, AuthorizeACHOutwardData data) throws Exception {
		AuthorizeACHOutwardPage AuthorizeACHOutwardPage = new AuthorizeACHOutwardPage(driver);
		AuthorizeACHOutwardPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysPaymentOrder(data.getPaysysID(), data.getPos())
		                                .pressGOButton()
		                                .pressApproveButton();         
	}
}