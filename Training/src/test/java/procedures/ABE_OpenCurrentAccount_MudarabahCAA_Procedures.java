package procedures;

import org.openqa.selenium.WebDriver;
import data.ABE_OpenCurrentAccount_MudarabahCAA_Data;
import pageobjects.ABE_OpenCurrentAccount_MudarabahCAA_Page;

public class ABE_OpenCurrentAccount_MudarabahCAA_Procedures {
	public static void openCurrentAccountMudarabahCAA(WebDriver driver, ABE_OpenCurrentAccount_MudarabahCAA_Data data) throws Exception {
		ABE_OpenCurrentAccount_MudarabahCAA_Page openCurrentAccountMudarabahCAAPage = new ABE_OpenCurrentAccount_MudarabahCAA_Page(driver);
		openCurrentAccountMudarabahCAAPage.sendKeysSearchBarTextField(data.getMenu())
									       .switchFormAreaFrame()
									        .sendKeysAccountDetails(data.getCif(), data.getSchemeCode(), data.getGeneralLedgerSubheadCode())
									         .pressSubmitButton()
										      .saveAccountId(data.getLinkedTCID());
		}
	}