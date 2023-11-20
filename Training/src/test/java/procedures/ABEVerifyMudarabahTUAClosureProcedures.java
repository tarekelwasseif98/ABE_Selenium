package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyMudarabahTUAClosureData;
import pageobjects.ABEVerifyMudarabahTUAClosurePage;

public class ABEVerifyMudarabahTUAClosureProcedures {
	public static void verifyMudarabahTUAClosure(WebDriver driver, ABEVerifyMudarabahTUAClosureData data) throws Exception {
		ABEVerifyMudarabahTUAClosurePage verifyMudarabahTUAClosurePage = new ABEVerifyMudarabahTUAClosurePage(driver);
		verifyMudarabahTUAClosurePage.sendKeysSearchBarTextField(data.getMenu())
					         .switchFormAreaFrame()
					          .sendKeysAccountIdTextField(data.getAccountid())
					           .pressGoButton()
					            .pressSubmitButton();
		}
	}