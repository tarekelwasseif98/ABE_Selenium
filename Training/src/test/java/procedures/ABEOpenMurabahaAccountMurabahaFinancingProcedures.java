package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenMurabahaAccountMurabahaFinancingData;
import pageobjects.ABEOpenMurabahaAccountMurabahaFinancingPage;

public class ABEOpenMurabahaAccountMurabahaFinancingProcedures {
	public static void openMurabahaAccountMurabahaFinancing(WebDriver driver, ABEOpenMurabahaAccountMurabahaFinancingData data) throws Exception {
		ABEOpenMurabahaAccountMurabahaFinancingPage openMurabahaAccountMurabahaFinancingPage = new ABEOpenMurabahaAccountMurabahaFinancingPage(driver);
		openMurabahaAccountMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
				    							 .switchFormAreaFrame()
				    							  .sendKeysAccountDetails(data.getCif(), data.getSchemeCode())
				    							   .sendKeysBasicAssetDetails(data.getAssetValue(), data.getCustomerMargin())
				    							    .sendKeysFinanceDetails(data.getFinancePeriodMonths(), data.getFinancePeriodDays(), data.getDebitAccountId())
				    							     .sendKeysRepaymentParameterDetails(data.getEquatedInstallment(), data.getNumberOfInstallments(), data.getInstallmentStartDate(), data.getInstallmentFrequency(), data.getProfitStartDate(), data.getProfitFrequency(), data.getDate(), data.getCalendar(), data.getOnHoliday())
				    							      .sendKeysOperativeAccountIdTextField(data.getOperativeAccountId())
				    							       .sendKeysAccountLimitDetails(data.getExpiryDate(), data.getDocumentDate(), data.getLimitIdPrefix(), data.getLimitIdSuffix(), data.getDrawingPowerIndicator())
				    							        .pressSubmitButton()
				    							         .saveAccountId(data.getLinkedTcid());
		}
	}