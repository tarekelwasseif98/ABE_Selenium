package procedures;

import org.openqa.selenium.WebDriver;

import data.ABE_CloseCasaAccount_Mudarabah_Data;
import pageobjects.ABE_CloseCasaAccount_Mudarabah_Page;

public class ABE_CloseCasaAccount_Mudarabah_Procedures {
	public static void closeIslamicCasaAccountByMaker(WebDriver driver, ABE_CloseCasaAccount_Mudarabah_Data data) throws Exception {
		ABE_CloseCasaAccount_Mudarabah_Page CloseIslamicCasaAccountPage = new ABE_CloseCasaAccount_Mudarabah_Page(driver);
		CloseIslamicCasaAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									   .sendKeysAccountIdTextField(data.getAccountId())
									    .sendKeystransferAccountIdTextField(data.getTransferAccountId())
									     .pressSubmitButton()
									      .saveAccountId(data.getLinkedTCID());
	}
}