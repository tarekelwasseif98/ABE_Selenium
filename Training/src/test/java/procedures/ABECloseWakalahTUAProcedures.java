package procedures;

import org.openqa.selenium.WebDriver;

import data.ABECloseWakalahTUAData;
import pageobjects.ABECloseWakalahTUAPage;

public class ABECloseWakalahTUAProcedures {
	public static void closeWakalahTUA(WebDriver driver, ABECloseWakalahTUAData data) throws Exception {
		ABECloseWakalahTUAPage closeWakalahTUAPage = new ABECloseWakalahTUAPage(driver);
		closeWakalahTUAPage.sendKeysSearchBarTextField(data.getMenu())
					 .switchFormAreaFrame()
					  .sendKeysAccountIdTextField(data.getAccountId())
					   .sendKeysClosureValueDateTextField(data.getClosureValueDate())
					    .pressGoButton()
					     .sendKeysRepaymentAccountIdTextField(data.getRepaymentAccountId())
 		   			      .pressSubmitButton()
						   .saveAccountId(data.getLinkedTcid());
		}
	}