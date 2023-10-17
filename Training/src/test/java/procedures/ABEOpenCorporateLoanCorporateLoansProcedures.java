package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenCorporateLoanCorporateLoansData;
import pageobjects.ABEOpenCorporateLoanCorporateLoansPage;

public class ABEOpenCorporateLoanCorporateLoansProcedures {
	public static void openCorporateLoanCorporateLoans(WebDriver driver, ABEOpenCorporateLoanCorporateLoansData data) throws Exception {
		ABEOpenCorporateLoanCorporateLoansPage openCorporateLoanCorporateLoansPage = new ABEOpenCorporateLoanCorporateLoansPage(driver);
		openCorporateLoanCorporateLoansPage.sendKeysSearchBarTextField(data.getMenu())
				    							 .switchFormAreaFrame()
				    							  .sendKeysAccountDetails(data.getCif(), data.getSchemeCode(), data.getAccountOpeningDate())
				    							   .sendKeysLoanDetails(data.getLoanAmount(), data.getLoanPeriodMonths(), data.getLoanPeriodDays())
				    							    .sendKeysRepaymentParametersDetails(data.getNumberOfInstallments(), data.getInstallmentStartDate(), data.getInstallmentFrequency(), data.getDate(), data.getCalendar(), data.getOnHoliday(), data.getEquatedInstallment(), data.getInterestStartDate(), data.getInterestFrequency())
				    							     .sendKeysOperativeAccountIdTextField(data.getOperativeAccountId())
				    							      .sendKeysAccountLimitDetails(data.getExpiryDate(), data.getDocumentDate(), data.getLimitIdPrefix(), data.getLimitIdSuffix(), data.getDrawingPowerIndicator())
				    							       .pressSubmitButton()
				    							        .saveAccountId(data.getLinkedTcid());
		}
	}