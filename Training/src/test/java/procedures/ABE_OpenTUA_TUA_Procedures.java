package procedures;

import org.openqa.selenium.WebDriver;
import data.ABE_OpenTUA_TUA_Data;
import pageobjects.ABE_OpenTUA_TUA_Page;

public class ABE_OpenTUA_TUA_Procedures {
	public static void openTUA(WebDriver driver, ABE_OpenTUA_TUA_Data data) throws Exception {
		ABE_OpenTUA_TUA_Page openTUAPage = new ABE_OpenTUA_TUA_Page(driver);
		openTUAPage.sendKeysSearchBarTextField(data.getMenu())
				    .switchFormAreaFrame()
					 .sendKeysAccountDetails(data.getCif(), data.getSchemeCode())
					  .sendKeysTUADetails(data.getDepositPeriodMonths(), data.getDepositPeriodDays(), data.getInitialDepositAmount(), data.getProfitCreditAccountId(), data.getRepaymentAccountId(), data.getDebitAccountId())
					   .pressSubmitButton()
				        .saveAccountId(data.getLinkedTcid());
		}
	}