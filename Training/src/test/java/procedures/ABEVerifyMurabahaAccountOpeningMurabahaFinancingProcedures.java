package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyMurabahaAccountOpeningMurabahaFinancingData;
import pageobjects.ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage;

public class ABEVerifyMurabahaAccountOpeningMurabahaFinancingProcedures {
	
	public static void verifyMurabahaAccountOpeningMurabahaFinancing(WebDriver driver, ABEVerifyMurabahaAccountOpeningMurabahaFinancingData data) throws Exception {
		ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage verifyMurabahaAccountOpeningMurabahaFinancingPage = new ABEVerifyMurabahaAccountOpeningMurabahaFinancingPage(driver);
		verifyMurabahaAccountOpeningMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
								.switchFormAreaFrame()
								 .sendKeysAccountIdTextField(data.getAccountid())
								  .navigateSideMenuTab()
								   .pressSubmitButton();
		}
	}