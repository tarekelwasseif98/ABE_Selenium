package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenCurrentAccountMudarabahCAAData;
import pageobjects.ABEOpenCurrentAccountMudarabahCAAPage;

public class ABEOpenCurrentAccountMudarabahCAAProcedures {
	public static void openCurrentAccountMudarabahCAA(WebDriver driver, ABEOpenCurrentAccountMudarabahCAAData data) throws Exception {
		ABEOpenCurrentAccountMudarabahCAAPage openCurrentAccountMudarabahCAAPage = new ABEOpenCurrentAccountMudarabahCAAPage(driver);
		openCurrentAccountMudarabahCAAPage.sendKeysSearchBarTextField(data.getMenu())
									       .switchFormAreaFrame()
									        .sendKeysCifIdTextField(data.getCif())
									         .sendKeysSchemeCodeTextField(data.getSchemeCode())
									          .sendKeysGeneralLedgerSubheadCodeTextField(data.getGeneralLedgerSubheadCode())
									           .pressGoButton()
									            .pressContinueButton()
									             .selectTaxCategory()
									              .pressSubmitButton()
										           .saveAccountId(data.getLinkedTCID());
		}
	}