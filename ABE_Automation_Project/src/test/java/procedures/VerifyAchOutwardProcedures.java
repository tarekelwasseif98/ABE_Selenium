package procedures;

import org.openqa.selenium.WebDriver;

import data.VerifyACHOutwardData;
import pageobjects.VerifyACHOutwardPage;

public class VerifyAchOutwardProcedures {
	
	public static void verifyAchOutwardBychecker(WebDriver driver, VerifyACHOutwardData data) throws Exception {
		VerifyACHOutwardPage VerifyACHOutwardPage = new VerifyACHOutwardPage(driver);
		VerifyACHOutwardPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysPaymentOrder(data.getPos())
		                                .pressGOButton()
		                                .pressSubmitButton();             
	}
}