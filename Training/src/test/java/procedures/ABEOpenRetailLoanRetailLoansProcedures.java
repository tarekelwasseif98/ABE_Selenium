package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEOpenRetailLoanRetailLoansData;
import pageobjects.ABEOpenRetailLoanRetailLoansPage;


public class ABEOpenRetailLoanRetailLoansProcedures {
	
	public static void ABEOpenRetailLoanRetailLoans(WebDriver driver, ABEOpenRetailLoanRetailLoansData data) throws Exception {
		ABEOpenRetailLoanRetailLoansPage ABEOpenRetailLoanRetailLoans = new ABEOpenRetailLoanRetailLoansPage(driver);
		ABEOpenRetailLoanRetailLoans.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeysCif(data.getCif())
									  .sendKeysSchemeCode(data.getSchemeCode())
									  .pressGoButton()
									  .sendKeysAccountStatment()
									  .PressContinueButton()
									  .sendKeysLoanAmmountTextField(data.getLoanAmt())
									  .sendKeysLoanPeriodTextField(data.getLoanPeriod())
									  .PressContinue()
									  .sendKeysNumberOfInstallmentsTextField(data.getNumberofInstallments())
									  .sendKeysInstallmentFrequencyDropDown(data.getInstallmentFrequency())
									  .sendKeysinstallmentDateDropDown(data.getDate())
									  .sendKeysCalenderType()
									  .pressRepaymentParameterContinueButton()
									  .SendKeysOperativeAccount(data.getOperativeAccount())
									  .PressSubmit()
									  .saveAccountId(data.getLinkedTcId(), data.getLinkedTcId2(), data.getLinkedTcId3());
		}

}
