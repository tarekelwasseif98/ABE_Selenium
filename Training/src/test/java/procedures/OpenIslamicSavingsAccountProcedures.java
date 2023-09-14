package procedures;

import org.openqa.selenium.WebDriver;
import data.OpenIslamicSavingsAccountData;
import pageobjects.OpenIslamicSavingsAccountPage;

public class OpenIslamicSavingsAccountProcedures {
	public static void islamicSavingsAccountByMaker(WebDriver driver, OpenIslamicSavingsAccountData data) throws Exception {
		OpenIslamicSavingsAccountPage OpenIslamicSavingsAccountPage = new OpenIslamicSavingsAccountPage(driver);
		OpenIslamicSavingsAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									   .addAccountDetails(data.getCif())
									    .pressSubmitButton();
		}
	}