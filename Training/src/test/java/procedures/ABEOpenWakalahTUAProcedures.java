package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenWakalahTUAData;
import pageobjects.ABEOpenWakalahTUAPage;

public class ABEOpenWakalahTUAProcedures {
	public static void openWakalahTUA(WebDriver driver, ABEOpenWakalahTUAData data) throws Exception {
		ABEOpenWakalahTUAPage openWakalahTUAPage = new ABEOpenWakalahTUAPage(driver);
		openWakalahTUAPage.sendKeysSearchBarTextField(data.getMenu())
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
					                .pressAccountPeggedNoButton()
					                 .navigateRenewalAndClosureDetailsTabMenu()
					                  .pressSubmitButton()
					                   .saveAccountId(data.getLinkedTcid(), data.getCloseLinkedTcid());
		}
	}