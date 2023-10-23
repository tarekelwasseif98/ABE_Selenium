package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData;
import pageobjects.ABEVerifyMurabahaAccountDisbursementMurabahaFinancingPage;

public class ABEVerifyMurabahaAccountDisbursementMurabahaFinancingProcedures {
	
	public static void verifyMurabahaAccountDisbursementMurabahaFinancing(WebDriver driver, ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData data) throws Exception {
		ABEVerifyMurabahaAccountDisbursementMurabahaFinancingPage verifyMurabahaAccountDisbursementMurabahaFinancingPage = new ABEVerifyMurabahaAccountDisbursementMurabahaFinancingPage(driver);
		verifyMurabahaAccountDisbursementMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
															   .switchFormAreaFrame()
																.sendKeysAccountIdTextField(data.getAccountId())
																 .pressGoButton()
																  .pressContinue1Button()
																   .pressContinue2Button()
																    .pressContinue3Button()
																     .pressSubmitButton();
		}
	}