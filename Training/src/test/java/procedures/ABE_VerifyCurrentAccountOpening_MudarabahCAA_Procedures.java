package procedures;

import org.openqa.selenium.WebDriver;

import data.ABE_VerifyCurrentAccountOpening_MudarabahCAA_Data;
import pageobjects.ABE_VerifyCurrentAccountOpening_MudarabahCAA_Page;

public class ABE_VerifyCurrentAccountOpening_MudarabahCAA_Procedures {
	
	public static void verifyCurrentAccountOpeningMudarabahCAA(WebDriver driver, ABE_VerifyCurrentAccountOpening_MudarabahCAA_Data data) throws Exception {
		ABE_VerifyCurrentAccountOpening_MudarabahCAA_Page verifyCurrentAccountOpeningMudarabahCAAPage = new ABE_VerifyCurrentAccountOpening_MudarabahCAA_Page(driver);
		verifyCurrentAccountOpeningMudarabahCAAPage.sendKeysSearchBarTextField(data.getMenu())
													.switchFormAreaFrame()
													 .sendKeysAccountIdTextField(data.getAccountid())
													  .navigateSideMenuTab()
													   .pressSubmitButton();
		}
	}