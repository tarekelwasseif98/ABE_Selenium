package procedures;

import org.openqa.selenium.WebDriver;
import data.OpenIslamicCurrentAccountData;
import pageobjects.OpenIslamicCurrentAccountPage;

public class OpenIslamicCurrentAccountProcedures {
	public static void openIslamicCurrentAccountByMaker(WebDriver driver, OpenIslamicCurrentAccountData data) throws Exception {
		OpenIslamicCurrentAccountPage OpenIslamicCurrentAccountPage = new OpenIslamicCurrentAccountPage(driver);
		OpenIslamicCurrentAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									   .sendKeysAccoundDetails(data.getCif(), data.getSchemeCode(), data.getGeneralLedgerSubheadCode())
									    .pressSubmitButton()
										 .saveAccountId(data.getLinkedTCID());
		}
	}