package procedures;

import org.openqa.selenium.WebDriver;

import data.CloseIslamicCasaAccountData;
import pageobjects.CloseIslamicCasaAccountPage;

public class CloseIslamicCasaAccountProcedures {
	public static void closeIslamicCasaAccountByMaker(WebDriver driver, CloseIslamicCasaAccountData data) throws Exception {
		CloseIslamicCasaAccountPage CloseIslamicCasaAccountPage = new CloseIslamicCasaAccountPage(driver);
		CloseIslamicCasaAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									   .sendKeysAccountIdTextField(data.getAccountId())
									    .sendKeystransferAccountIdTextField(data.getTransferAccountId())
									     .pressSubmitButton()
									      .saveAccountId(data.getLinkedTCID());
	}
}