package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEVerifyCorporateLoanDisbursmentCorporateLoansData;
import pageobjects.ABEVerifyCorporateLoanDisbursmentCorporateLoansPage;

public class ABEVerifyCorporateLoanDisbursmentCorporateLoansProcedures {
	
	public static void verifyCorporateLoanDisbursmentCorporateLoans(WebDriver driver, ABEVerifyCorporateLoanDisbursmentCorporateLoansData data) throws Exception {
		ABEVerifyCorporateLoanDisbursmentCorporateLoansPage ABEVerifyCorporateLoanDisbursmentCorporateLoansByChecker = new ABEVerifyCorporateLoanDisbursmentCorporateLoansPage(driver);
		ABEVerifyCorporateLoanDisbursmentCorporateLoansByChecker.sendKeysSearchBarTextField(data.getMenu())
					 											 .switchFormAreaFrame()
					 											  .sendKeysAccountIdTextField(data.getAccountId())
					 											   .pressDrawdownDetailsContinueButton()
					 											    .pressAdditionalDetailsContinueButton()
					 											     .pressDrawdownModeDetailsContinueButton()
					 											      .pressSubmitButton();
		}
	}