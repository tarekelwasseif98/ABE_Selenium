package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyTUAOpeningData;
import pageobjects.ABEVerifyTUAOpeningPage;

public class ABEVerifyTUAOpeningProcedures {
	
	public static void verifyTUAOpeningTUA(WebDriver driver, ABEVerifyTUAOpeningData data) throws Exception {
		ABEVerifyTUAOpeningPage verifyTUAOpeningTUAPage = new ABEVerifyTUAOpeningPage(driver);
		verifyTUAOpeningTUAPage.sendKeysSearchBarTextField(data.getMenu())
								.switchFormAreaFrame()
								 .sendKeysAccountIdTextField(data.getAccountid())
								  .pressGoButton()
								   .navigateSideTabMenu()
								    .pressSubmitButton();
		}
	}