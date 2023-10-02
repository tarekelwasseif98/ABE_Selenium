package procedures;

import org.openqa.selenium.WebDriver;

import data.ABE_VerifyTUAOpening_TUA_Data;
import pageobjects.ABE_VerifyTUAOpening_TUA_Page;

public class ABE_VerifyTUAOpening_TUA_Procedures {
	
	public static void verifyTUAOpeningTUA(WebDriver driver, ABE_VerifyTUAOpening_TUA_Data data) throws Exception {
		ABE_VerifyTUAOpening_TUA_Page verifyTUAOpeningTUAPage = new ABE_VerifyTUAOpening_TUA_Page(driver);
		verifyTUAOpeningTUAPage.sendKeysSearchBarTextField(data.getMenu())
								.switchFormAreaFrame()
								 .sendKeysAccountIdTextField(data.getAccountid())
								  .navigateSideMenuTab()
								   .pressSubmitButton();
		}
	}