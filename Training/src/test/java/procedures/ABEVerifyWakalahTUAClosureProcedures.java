package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyWakalahTUAClosureData;
import pageobjects.ABEVerifyWakalahTUAClosurePage;

public class ABEVerifyWakalahTUAClosureProcedures {
	public static void verifyWakalahTUAClosure(WebDriver driver, ABEVerifyWakalahTUAClosureData data) throws Exception {
		ABEVerifyWakalahTUAClosurePage verifyWakalahTUAClosurePage = new ABEVerifyWakalahTUAClosurePage(driver);
		verifyWakalahTUAClosurePage.sendKeysSearchBarTextField(data.getMenu())
					         .switchFormAreaFrame()
					          .sendKeysAccountIdTextField(data.getAccountid())
					           .pressGoButton()
					            .pressSubmitButton();
		}
	}