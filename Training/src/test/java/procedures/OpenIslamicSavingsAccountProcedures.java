package procedures;

import org.openqa.selenium.WebDriver;
import data.OpenIslamicSavingsAccountData;
import pageobjects.OpenSavingsAccountPage;

public class OpenIslamicSavingsAccountProcedures {
	public static void IslamicSavingsAccount_Maker(WebDriver driver, OpenIslamicSavingsAccountData data) throws Exception {
		OpenSavingsAccountPage OpenSavingsAccountPage = new OpenSavingsAccountPage(driver);
		OpenSavingsAccountPage.sendKeysMenuName(data.getMenu());
		OpenSavingsAccountPage.addAccountDetails(data.getCif());
		}
}