package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyCasaAccountClosureMudarabahData;
import pageobjects.ABEVerifyCasaAccountClosureMudarabahPage;

public class ABEVerifyCasaAccountClosureMudarabahProcedures {
	public static void verifyCasaAccountClosureMudarabah(WebDriver driver, ABEVerifyCasaAccountClosureMudarabahData data) throws Exception {
		ABEVerifyCasaAccountClosureMudarabahPage verifyCasaAccountClosureMudarabahPage = new ABEVerifyCasaAccountClosureMudarabahPage(driver);
		verifyCasaAccountClosureMudarabahPage.sendKeysSearchBarTextField(data.getMenu())
									  	      .switchFormAreaFrame()
									           .sendKeysAccountIdTextField(data.getAccountId())
									            .pressSubmitButton();
	}
}