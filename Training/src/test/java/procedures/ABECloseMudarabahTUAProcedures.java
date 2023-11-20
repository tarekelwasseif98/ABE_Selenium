package procedures;

import org.openqa.selenium.WebDriver;

import data.ABECloseMudarabahTUAData;
import pageobjects.ABECloseMudarabahTUAPage;

public class ABECloseMudarabahTUAProcedures {
	public static void closeMudarabahTUA(WebDriver driver, ABECloseMudarabahTUAData data) throws Exception {
		ABECloseMudarabahTUAPage closeMudarabahTUAPage = new ABECloseMudarabahTUAPage(driver);
		closeMudarabahTUAPage.sendKeysSearchBarTextField(data.getMenu())
					 .switchFormAreaFrame()
					  .sendKeysAccountIdTextField(data.getAccountId())
					   .sendKeysClosureValueDateTextField(data.getClosureValueDate())
					    .pressGoButton()
					     .sendKeysRepaymentAccountIdTextField(data.getRepaymentAccountId())
 		   			      .pressSubmitButton()
						   .saveAccountId(data.getLinkedTcid());
		}
	}