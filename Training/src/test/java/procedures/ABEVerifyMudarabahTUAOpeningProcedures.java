package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyMudarabahTUAOpeningData;
import pageobjects.ABEVerifyMudarabahTUAOpeningPage;

public class ABEVerifyMudarabahTUAOpeningProcedures {
	
	public static void verifyMudarabahTUAOpening(WebDriver driver, ABEVerifyMudarabahTUAOpeningData data) throws Exception {
		ABEVerifyMudarabahTUAOpeningPage verifyMudarabahTUAOpeningTUAPage = new ABEVerifyMudarabahTUAOpeningPage(driver);
		verifyMudarabahTUAOpeningTUAPage.sendKeysSearchBarTextField(data.getMenu())
								.switchFormAreaFrame()
								 .sendKeysAccountIdTextField(data.getAccountid())
								  .pressGoButton()
								   .navigateSideTabMenu()
								    .pressSubmitButton();
		}
	}