package procedures;

import org.openqa.selenium.WebDriver;

import data.VerifyIslamicSavingsAccountData;
import pageobjects.VerifyIslamicSavingsAccountPage;

public class VerifyIslamicSavingsAccountProcedures {
	
	public static void islamicSavingsAccountByChecker(WebDriver driver, VerifyIslamicSavingsAccountData data) throws Exception {
		VerifyIslamicSavingsAccountPage VerifyIslamicSavingsAccountPage = new VerifyIslamicSavingsAccountPage(driver);
		VerifyIslamicSavingsAccountPage.sendKeysMenuName(data.getMenu());
		VerifyIslamicSavingsAccountPage.switchFormAreaFrame();
		VerifyIslamicSavingsAccountPage.sendKeysAcidTextField(data.getAccountid());
		VerifyIslamicSavingsAccountPage.navigateSideMenu();
		VerifyIslamicSavingsAccountPage.pressSubmitButton();
		}
	}