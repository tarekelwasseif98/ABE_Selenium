package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenTUAData;
import pageobjects.ABEOpenTUAPage;

public class ABEOpenTUAProcedures {
	public static void openTUA(WebDriver driver, ABEOpenTUAData data) throws Exception {
		ABEOpenTUAPage openTUAPage = new ABEOpenTUAPage(driver);
		openTUAPage.sendKeysSearchBarTextField(data.getMenu())
				    .switchFormAreaFrame()
					 .sendKeysAccountDetails(data.getCif(), data.getSchemeCode())
					  .sendKeysTUADetails(data.getDepositPeriodMonths(), data.getDepositPeriodDays(), data.getInitialDepositAmount(), data.getProfitCreditAccountId(), data.getRepaymentAccountId(), data.getDebitAccountId())
					   .pressSubmitButton()
				        .saveAccountId(data.getLinkedTcid());
		}
	}