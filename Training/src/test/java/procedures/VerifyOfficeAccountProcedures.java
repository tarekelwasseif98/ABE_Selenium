package procedures;
import org.openqa.selenium.WebDriver;

import data.VerifyOfficeAccountData;
import pageobjects.VerifyOfficeAccountPage;

public class VerifyOfficeAccountProcedures {
	

	public static void OfficeAccountByChecker(WebDriver driver, VerifyOfficeAccountData data) throws Exception {
		VerifyOfficeAccountPage VerifyOfficeAccountPage = new VerifyOfficeAccountPage(driver);
		VerifyOfficeAccountPage.sendKeysSearchBarTextField(data.getMenu())
										.switchFormAreaFrame()
										.sendKeysAcidTextField(data.getAccountId())
										 .pressSubmitButton();
		}

}
