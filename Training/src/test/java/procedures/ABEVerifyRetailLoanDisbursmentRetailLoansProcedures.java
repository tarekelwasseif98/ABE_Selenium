package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEVerifyRetailLoanDisbursmentRetailLoansData;
import pageobjects.ABEVerifyRetailLoanDisbursmentRetailLoansPage;

public class ABEVerifyRetailLoanDisbursmentRetailLoansProcedures {
	
	public static void ABEVerifyRetailLoanDisbursmentRetailLoans(WebDriver driver, ABEVerifyRetailLoanDisbursmentRetailLoansData data) throws Exception {
		ABEVerifyRetailLoanDisbursmentRetailLoansPage ABEVerifyRetailLoanDisbursmentRetailLoansByChecker = new ABEVerifyRetailLoanDisbursmentRetailLoansPage(driver);
		ABEVerifyRetailLoanDisbursmentRetailLoansByChecker.sendKeysSearchBarTextField(data.getMenu())
					 .switchFormAreaFrame()
					 .sendKeysAcidTextField(data.getAccountId())
					 .PressDisbursmentDetailsContinueButton()
					 .additionalDetailsContinueButton()
					 .PressDisbursmentModeContinueButton()
					 .PressSubmitButton()
					 .saveTransactionId(data.getTcId());
		}

}
