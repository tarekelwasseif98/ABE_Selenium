package procedures;

import org.openqa.selenium.WebDriver;

import data.ABECloseCasaAccountMudarabahData;
import pageobjects.ABECloseCasaAccountMudarabahPage;

public class ABECloseCasaAccountMudarabahProcedures {
	public static void closeCasaAccountMudarabah(WebDriver driver, ABECloseCasaAccountMudarabahData data) throws Exception {
		ABECloseCasaAccountMudarabahPage closeCasaAccountMudarabahPage = new ABECloseCasaAccountMudarabahPage(driver);
		closeCasaAccountMudarabahPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									   .sendKeysAccountIdTextField(data.getAccountId())
									    .pressGoButton()
									     .selectTransactionType()
									      .sendKeysTransferAccountIdTextField(data.getTransferAccountId())
									       .pressSubmitButton()
									        .saveAccountId(data.getLinkedTCID());
	}
}