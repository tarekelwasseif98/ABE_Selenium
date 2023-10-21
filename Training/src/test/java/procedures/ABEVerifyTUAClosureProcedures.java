package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyTUAClosureData;
import pageobjects.ABEVerifyTUAClosurePage;

public class ABEVerifyTUAClosureProcedures {
	public static void verifyTUAClosure(WebDriver driver, ABEVerifyTUAClosureData data) throws Exception {
		ABEVerifyTUAClosurePage verifyTUAClosurePage = new ABEVerifyTUAClosurePage(driver);
		verifyTUAClosurePage.sendKeysSearchBarTextField(data.getMenu())
					         .switchFormAreaFrame()
					          .sendKeysAccountIdTextField(data.getAccountid())
					           .pressGoButton()
					            .pressSubmitButton();
		}
	}