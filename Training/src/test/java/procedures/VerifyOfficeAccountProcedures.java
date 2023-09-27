package procedures;
import org.openqa.selenium.WebDriver;

import data.ABE_Verify_OfficeAccount_Finance_Data;
import pageobjects.ABE_Verify_OfficeAccount_Finance_Page;

public class VerifyOfficeAccountProcedures {
	

	public static void OfficeAccountByChecker(WebDriver driver, ABE_Verify_OfficeAccount_Finance_Data data) throws Exception {
		ABE_Verify_OfficeAccount_Finance_Page VerifyOfficeAccountPage = new ABE_Verify_OfficeAccount_Finance_Page(driver);
		VerifyOfficeAccountPage.sendKeysSearchBarTextField(data.getMenu())
										.switchFormAreaFrame()
										.sendKeysAcidTextField(data.getAccountId())
										 .pressSubmitButton();
		}

}
