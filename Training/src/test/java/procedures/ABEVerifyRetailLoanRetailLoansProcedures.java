package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEVerifyRetailLoanRetailLoansData;
import pageobjects.ABEVerifyRetailLoanRetailLoansPage;

public class ABEVerifyRetailLoanRetailLoansProcedures {
	
	public static void ABEVerifyRetailLoanRetailLoans(WebDriver driver, ABEVerifyRetailLoanRetailLoansData data) throws Exception {
		ABEVerifyRetailLoanRetailLoansPage ABEVerifyRetailLoanRetailLoansByChecker = new ABEVerifyRetailLoanRetailLoansPage(driver);
		ABEVerifyRetailLoanRetailLoansByChecker.sendKeysSearchBarTextField(data.getMenu())
					 .switchFormAreaFrame()
					 .sendKeysAcidTextField(data.getAccountId())
					 .PressGoButton()
					 .PressContinueButtonBasic()
					 .PressContinueButtonDetails()
					 .PressContinueButtonRelatedParty()
					 .PressContinueButtoninterest()
					 .PressContinueButtonFees()
					 .PressContinueButtonRepayment()
					 .PressContinueButtonSched()
					 .PressSubmitButton();
		}

}
