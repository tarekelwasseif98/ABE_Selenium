package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyWakalahTUAOpeningData;
import pageobjects.ABEVerifyWakalahTUAOpeningPage;

public class ABEVerifyWakalahTUAOpeningProcedures {
	
	public static void verifyWakalahTUAOpening(WebDriver driver, ABEVerifyWakalahTUAOpeningData data) throws Exception {
		ABEVerifyWakalahTUAOpeningPage verifyMudarabahTUAOpeningTUAPage = new ABEVerifyWakalahTUAOpeningPage(driver);
		verifyMudarabahTUAOpeningTUAPage.sendKeysSearchBarTextField(data.getMenu())
								.switchFormAreaFrame()
								 .sendKeysAccountIdTextField(data.getAccountid())
								  .pressGoButton()
								   .navigateSideTabMenu()
								    .pressSubmitButton();
		}
	}