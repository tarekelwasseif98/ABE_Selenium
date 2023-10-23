package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyCurrentAccountOpeningMudarabahCAAData;
import pageobjects.ABEVerifyCurrentAccountOpeningMudarabahCAAPage;

public class ABEVerifyCurrentAccountOpeningMudarabahCAAProcedures {
	
	public static void verifyCurrentAccountOpeningMudarabahCAA(WebDriver driver, ABEVerifyCurrentAccountOpeningMudarabahCAAData data) throws Exception {
		ABEVerifyCurrentAccountOpeningMudarabahCAAPage verifyCurrentAccountOpeningMudarabahCAAPage = new ABEVerifyCurrentAccountOpeningMudarabahCAAPage(driver);
		verifyCurrentAccountOpeningMudarabahCAAPage.sendKeysSearchBarTextField(data.getMenu())
													.switchFormAreaFrame()
													 .sendKeysAccountIdTextField(data.getAccountid())
													  .pressGoButton()
													   .navigateSideTabMenu()
													    .pressSubmitButton();
		}
	}