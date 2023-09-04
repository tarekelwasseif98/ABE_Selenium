package procedures;

import org.openqa.selenium.WebDriver;
import pageobjects.VerifyIslamicSavingsAccountPage;

public class VerifyIslamicsavingsAccountProcedures {
	
	public void navigateToVerifyIslamicSavingsAccountPage(WebDriver driver, String menu, String val) throws Exception {
		VerifyIslamicSavingsAccountPage VerifyIslamicSavingsAccountPage = new VerifyIslamicSavingsAccountPage(driver);
		VerifyIslamicSavingsAccountPage.sendKeysMenuName(menu);
		VerifyIslamicSavingsAccountPage.addAccountDetails(val);
		}
}