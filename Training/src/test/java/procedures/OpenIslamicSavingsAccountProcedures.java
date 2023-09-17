package procedures;

import org.openqa.selenium.WebDriver;
import data.OpenIslamicSavingsAccountData;
import pageobjects.OpenIslamicSavingsAccountPage;

public class OpenIslamicSavingsAccountProcedures {
	public static void islamicSavingsAccountByMaker(WebDriver driver, OpenIslamicSavingsAccountData data) throws Exception {
		OpenIslamicSavingsAccountPage OpenIslamicSavingsAccountPage = new OpenIslamicSavingsAccountPage(driver);
		OpenIslamicSavingsAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
<<<<<<< HEAD
									   .addAccountDetails(data.getCif())
									    .pressSubmitButton()
										 .saveAccountId();
=======
									   .sendKeysAccoundID(data.getCif())
									    .pressSubmitButton();
>>>>>>> 14e52afa61a4905f2b94932e32f35455606af542
		}
	}