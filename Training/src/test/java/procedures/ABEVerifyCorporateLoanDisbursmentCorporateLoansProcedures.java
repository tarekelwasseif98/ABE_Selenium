package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEVerifyCorporateLoanDisbursmentCorporateLoansData;
import pageobjects.ABEVerifyCorporateLoanDisbursmentCorporateLoansPage;

public class ABEVerifyCorporateLoanDisbursmentCorporateLoansProcedures {
	
	public static void ABEVerifyCorporateLoanDisbursmentCorporateLoans(WebDriver driver, ABEVerifyCorporateLoanDisbursmentCorporateLoansData data) throws Exception {
		ABEVerifyCorporateLoanDisbursmentCorporateLoansPage ABEVerifyCorporateLoanDisbursmentCorporateLoansByChecker = new ABEVerifyCorporateLoanDisbursmentCorporateLoansPage(driver);
		ABEVerifyCorporateLoanDisbursmentCorporateLoansByChecker.sendKeysSearchBarTextField(data.getMenu())
					 .switchFormAreaFrame()
					 .sendKeysAcidTextField(data.getAccountId())
					 .pressDrawdownDetailsContinueButton()
					 .pressAdditionalDetailsContinueButton	()
					 .pressdrawdownModeDetailsContinueButton()
					 .pressSubmitButton()
					 .saveTransactionId(data.getTcId());
		}
}
