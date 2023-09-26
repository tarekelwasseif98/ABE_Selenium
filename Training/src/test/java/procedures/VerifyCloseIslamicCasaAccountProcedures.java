package procedures;

import org.openqa.selenium.WebDriver;

import data.VerifyCloseIslamicCasaAccountData;
import pageobjects.VerifyCloseIslamicCasaAccountPage;

public class VerifyCloseIslamicCasaAccountProcedures {
	public static void verifyCloseIslamicCasaAccountByChecker(WebDriver driver, VerifyCloseIslamicCasaAccountData data) throws Exception {
		VerifyCloseIslamicCasaAccountPage VerifyCloseIslamicCasaAccountPage = new VerifyCloseIslamicCasaAccountPage(driver);
		VerifyCloseIslamicCasaAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  	  .switchFormAreaFrame()
									       .sendKeysAccountIdTextField(data.getAccountId())
									         .pressSubmitButton();
	}
}