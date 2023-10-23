package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyCorporateLoanCorporateLoansData;
import pageobjects.ABEVerifyCorporateLoanCorporateLoansPage;

public class ABEVerifyCorporateLoanCorporateLoansProcedures {
	
	public static void verifyCorporateLoanCorporateLoans(WebDriver driver, ABEVerifyCorporateLoanCorporateLoansData data) throws Exception {
		ABEVerifyCorporateLoanCorporateLoansPage verifyCorporateLoanCorporateLoansPage = new ABEVerifyCorporateLoanCorporateLoansPage(driver);
		verifyCorporateLoanCorporateLoansPage.sendKeysSearchBarTextField(data.getMenu())
								.switchFormAreaFrame()
								 .sendKeysAccountIdTextField(data.getAccountid())
								  .navigateSideMenuTab()
								   .pressSubmitButton();
		}
	}