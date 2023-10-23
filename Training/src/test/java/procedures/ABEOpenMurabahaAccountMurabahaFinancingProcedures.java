package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenMurabahaAccountMurabahaFinancingData;
import pageobjects.ABEOpenMurabahaAccountMurabahaFinancingPage;

public class ABEOpenMurabahaAccountMurabahaFinancingProcedures {
	public static void openMurabahaAccountMurabahaFinancing(WebDriver driver, ABEOpenMurabahaAccountMurabahaFinancingData data) throws Exception {
		ABEOpenMurabahaAccountMurabahaFinancingPage openMurabahaAccountMurabahaFinancingPage = new ABEOpenMurabahaAccountMurabahaFinancingPage(driver);
		openMurabahaAccountMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
				    							 .switchFormAreaFrame()
				    							  .sendKeysCifIdTextField(data.getCif())
				    							   .sendKeysSchemeCodeTextField(data.getSchemeCode())
				    							    .pressGoButton()
				    							     .sendKeysAssetValueTextField(data.getAssetValue())
				    							      .sendKeysCustomerMarginTextField(data.getCustomerMargin())
				    							       .pressContinue1Button()
				    							        .sendKeysFinancePeriodMonthsTextField(data.getFinancePeriodMonths())
				    							         .sendKeysFinancePeriodDaysTextField(data.getFinancePeriodDays())
				    							          .sendKeysDebitAccountIdTextField(data.getDebitAccountId())
				    							           .pressContinue2Button()
				    							            .pressContinue3Button()
				    							             .pressContinue4Button()
				    							              .pressContinue5Button()
				    							     .sendKeysRepaymentParameterDetails(data.getEquatedInstallment(), data.getNumberOfInstallments(), data.getInstallmentStartDate(), data.getInstallmentFrequency(), data.getProfitStartDate(), data.getProfitFrequency(), data.getDate(), data.getCalendar(), data.getOnHoliday())
				    							      .sendKeysOperativeAccountIdTextField(data.getOperativeAccountId())
				    							       .sendKeysAccountLimitDetails(data.getExpiryDate(), data.getDocumentDate(), data.getLimitIdPrefix(), data.getLimitIdSuffix(), data.getDrawingPowerIndicator())
				    							        .pressSubmitButton()
				    							         .saveAccountId(data.getLinkedTcid());
		}
	}