package procedures;
import org.openqa.selenium.WebDriver;

import data.ABEVerifyOfficeAccountFinanceData;
import pageobjects.ABEVerifyOfficeAccountFinancePage;

public class ABEVerifyOfficeAccountFinanceProcedures {
	

	public static void OfficeAccountByChecker(WebDriver driver, ABEVerifyOfficeAccountFinanceData data) throws Exception {
		ABEVerifyOfficeAccountFinancePage VerifyOfficeAccountPage = new ABEVerifyOfficeAccountFinancePage(driver);
		VerifyOfficeAccountPage.sendKeysSearchBarTextField(data.getMenu())
										.switchFormAreaFrame()
										.sendKeysAcidTextField(data.getAccountId())
										.pressGoButton()
										.pressSubmitButton();
		}

}
