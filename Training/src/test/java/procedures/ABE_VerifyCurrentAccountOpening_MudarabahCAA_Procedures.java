package procedures;

import org.openqa.selenium.WebDriver;

import data.ABE_VerifyCurrentAccountOpening_MudarabahCAA_Data;
import pageobjects.ABE_VerifyCurrentAccountOpening_MudarabahCAA_Page;

public class ABE_VerifyCurrentAccountOpening_MudarabahCAA_Procedures {
	
	public static void verifyIslamicCurrentAccountByChecker(WebDriver driver, ABE_VerifyCurrentAccountOpening_MudarabahCAA_Data data) throws Exception {
		ABE_VerifyCurrentAccountOpening_MudarabahCAA_Page VerifyIslamicCurrentAccountPage = new ABE_VerifyCurrentAccountOpening_MudarabahCAA_Page(driver);
		VerifyIslamicCurrentAccountPage.sendKeysSearchBarTextField(data.getMenu())
										.switchFormAreaFrame()
										 .sendKeysAccountIdTextField(data.getAccountid())
										  .navigateSideMenuTab()
										   .pressSubmitButton();
		}
	}