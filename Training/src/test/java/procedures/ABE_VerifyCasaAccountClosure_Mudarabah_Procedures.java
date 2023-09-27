package procedures;

import org.openqa.selenium.WebDriver;

import data.ABE_VerifyCasaAccountClosure_Mudarabah_Data;
import pageobjects.ABE_VerifyCasaAccountClosure_Mudarabah_Page;

public class ABE_VerifyCasaAccountClosure_Mudarabah_Procedures {
	public static void verifyCasaAccountClosureMudarabah(WebDriver driver, ABE_VerifyCasaAccountClosure_Mudarabah_Data data) throws Exception {
		ABE_VerifyCasaAccountClosure_Mudarabah_Page verifyCasaAccountClosureMudarabahPage = new ABE_VerifyCasaAccountClosure_Mudarabah_Page(driver);
		verifyCasaAccountClosureMudarabahPage.sendKeysSearchBarTextField(data.getMenu())
									  	  .switchFormAreaFrame()
									       .sendKeysAccountIdTextField(data.getAccountId())
									         .pressSubmitButton();
	}
}