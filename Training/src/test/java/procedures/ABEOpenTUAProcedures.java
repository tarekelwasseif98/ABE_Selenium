package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenTUAData;
import pageobjects.ABEOpenTUAPage;

public class ABEOpenTUAProcedures {
	public static void openTUA(WebDriver driver, ABEOpenTUAData data) throws Exception {
		ABEOpenTUAPage openTUAPage = new ABEOpenTUAPage(driver);
		openTUAPage.sendKeysSearchBarTextField(data.getMenu())
				    .switchFormAreaFrame()
					 .sendKeysCifIdTextField(data.getCif())
					  .sendKeysSchemeCodeTextField(data.getSchemeCode())
					   .pressGoButton()
					    .sendKeysValueDateTextField(data.getValueDate())
					     .sendKeysDepositPeriodMonthsTextField(data.getDepositPeriodMonths())
					      .sendKeysDepositPeriodDaysTextField(data.getDepositPeriodDays())
					       .sendKeysInitialDepositAmountTextField(data.getInitialDepositAmount())
					        .sendKeysProfitCreditAccountIdTextField(data.getProfitCreditAccountId())
					         .sendKeysRepaymentAccountIdTextField(data.getRepaymentAccountId())
					          .sendKeysDebitAccountIdTextField(data.getDebitAccountId())
					           .pressContinue1Button()
					            .sendKeysAccountOpeningDateTextField(data.getValueDate())
					             .sendKeysApplicationDateTextField(data.getValueDate())
					              .pressContinue2Button()
					               .pressContinue3Button()
					                .navigateRenewalAndClosureDetailsTabMenu()
					                 .pressSubmitButton()
					                  .saveAccountId(data.getLinkedTcid(), data.getCloseLinkedTcid());
		}
	}