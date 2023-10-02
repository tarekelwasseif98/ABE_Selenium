package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenCurrentAccountMudarabahCAAData;
import pageobjects.ABEOpenCurrentAccountMudarabahCAAPage;

public class ABE_OpenCurrentAccount_MudarabahCAA_Procedures {
	public static void openCurrentAccountMudarabahCAA(WebDriver driver, ABEOpenCurrentAccountMudarabahCAAData data) throws Exception {
		ABEOpenCurrentAccountMudarabahCAAPage openCurrentAccountMudarabahCAAPage = new ABEOpenCurrentAccountMudarabahCAAPage(driver);
		openCurrentAccountMudarabahCAAPage.sendKeysSearchBarTextField(data.getMenu())
									       .switchFormAreaFrame()
									        .sendKeysAccountDetails(data.getCif(), data.getSchemeCode(), data.getGeneralLedgerSubheadCode())
									         .pressSubmitButton()
										      .saveAccountId(data.getLinkedTCID());
		}
	}