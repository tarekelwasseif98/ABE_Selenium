package procedures;

import org.openqa.selenium.WebDriver;

import data.VerifyIslamicCurrentAccountData;
import pageobjects.VerifyIslamicCurrentAccountPage;

public class VerifyIslamicCurrentAccountProcedures {
	
	public static void verifyIslamicCurrentAccountByChecker(WebDriver driver, VerifyIslamicCurrentAccountData data) throws Exception {
		VerifyIslamicCurrentAccountPage VerifyIslamicCurrentAccountPage = new VerifyIslamicCurrentAccountPage(driver);
		VerifyIslamicCurrentAccountPage.sendKeysSearchBarTextField(data.getMenu())
										.switchFormAreaFrame()
										 .sendKeysAccountIdTextField(data.getAccountid())
										  .navigateSideMenuTab()
										   .pressSubmitButton();
		}
	}