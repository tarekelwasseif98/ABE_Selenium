package procedures;

import org.openqa.selenium.WebDriver;

import data.VerifyIslamicCurrentAccountData;
import pageobjects.VerifyIslamicCurrentAccountPage;

public class VerifyIslamicCurrentAccountProcedures {
	
	public static void islamicCurrentAccountByChecker(WebDriver driver, VerifyIslamicCurrentAccountData data) throws Exception {
		VerifyIslamicCurrentAccountPage VerifyIslamicCurrentAccountPage = new VerifyIslamicCurrentAccountPage(driver);
		VerifyIslamicCurrentAccountPage.sendKeysMenuName(data.getMenu())
										.switchFormAreaFrame()
										 .sendKeysAccountIdTextField(data.getAccountid())
										  .navigateSideMenuTab()
										   .pressSubmitButton();
		}
	}