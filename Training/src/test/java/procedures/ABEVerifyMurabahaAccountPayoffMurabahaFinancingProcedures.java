package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEVerifyMurabahaAccountPayoffMurabahaFinancingData;
import pageobjects.ABEVerifyMurabahaAccountPayoffMurabahaFinancingPage;

public class ABEVerifyMurabahaAccountPayoffMurabahaFinancingProcedures {
	
	public static void verifyMurabahaAccountPayoffMurabahaFinancing(WebDriver driver, ABEVerifyMurabahaAccountPayoffMurabahaFinancingData data) throws Exception {
		ABEVerifyMurabahaAccountPayoffMurabahaFinancingPage verifyMurabahaAccountPayoffMurabahaFinancingPage = new ABEVerifyMurabahaAccountPayoffMurabahaFinancingPage(driver);
		verifyMurabahaAccountPayoffMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
															   .switchFormAreaFrame()
																.sendKeysAccountIdTextField(data.getAccountId())
																 .pressGoButton()
																  .pressContinue1Button()
																   .pressContinue2Button()
																    .pressSubmitButton();
		}
	}