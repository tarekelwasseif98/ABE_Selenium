package procedures;

import org.openqa.selenium.WebDriver;
import pageobjects.OpenSavingsAccountPage;

public class OpenSavingsAccountProcedures {
	public void IslamicSavingsAccount_Maker(WebDriver driver, String menu, String val) throws Exception {
		OpenSavingsAccountPage OpenSavingsAccountPage = new OpenSavingsAccountPage(driver);
		OpenSavingsAccountPage.sendKeysMenuName(menu);
		OpenSavingsAccountPage.addAccountDetails(val);
		}	
}