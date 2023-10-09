package procedures;

import org.openqa.selenium.WebDriver;

import data.ABECloseTUAData;
import pageobjects.ABECloseTUAPage;

public class ABECloseTUAProcedures {
	public static void closeTUA(WebDriver driver, ABECloseTUAData data) throws Exception {
		ABECloseTUAPage closeTUAPage = new ABECloseTUAPage(driver);
		closeTUAPage.sendKeysSearchBarTextField(data.getMenu())
					 .switchFormAreaFrame()
					  .sendKeysAccountIdTextField(data.getAccountId())
					   .sendKeysRepaymentAccountIdTextField(data.getRepaymentAccountId())
 		   			    .pressSubmitButton()
						 .saveAccountId(data.getLinkedTcid());
		}
	}