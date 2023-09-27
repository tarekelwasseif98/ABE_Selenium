package procedures;

import org.openqa.selenium.WebDriver;
import data.ABE_OpenCurrentAccount_MudarabahCAA_Data;
import pageobjects.ABE_OpenCurrentAccount_MudarabahCAA_Page;

public class ABE_OpenCurrentAccount_MudarabahCAA_Procedures {
	public static void openIslamicCurrentAccountByMaker(WebDriver driver, ABE_OpenCurrentAccount_MudarabahCAA_Data data) throws Exception {
		ABE_OpenCurrentAccount_MudarabahCAA_Page OpenIslamicCurrentAccountPage = new ABE_OpenCurrentAccount_MudarabahCAA_Page(driver);
		OpenIslamicCurrentAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									   .sendKeysAccoundDetails(data.getCif(), data.getSchemeCode(), data.getGeneralLedgerSubheadCode())
									    .pressSubmitButton()
										 .saveAccountId(data.getLinkedTCID());
		}
	}