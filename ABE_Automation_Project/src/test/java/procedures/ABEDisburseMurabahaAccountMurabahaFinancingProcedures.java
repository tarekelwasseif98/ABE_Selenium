package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEDisburseMurabahaAccountMurabahaFinancingData;
import pageobjects.ABEDisburseMurabahaAccountMurabahaFinancingPage;

public class ABEDisburseMurabahaAccountMurabahaFinancingProcedures {
	public static void disburseMurabahaAccountMurabahaFinancing(WebDriver driver, ABEDisburseMurabahaAccountMurabahaFinancingData data) throws Exception {
		ABEDisburseMurabahaAccountMurabahaFinancingPage disburseMurabahaAccountMurabahaFinancingPage = new ABEDisburseMurabahaAccountMurabahaFinancingPage(driver);
		disburseMurabahaAccountMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
				    							 	 .switchFormAreaFrame()
				    							 	  .sendKeysMurabahaAccountId(data.getMurabahaAccountId())
				    							 	   .sendKeysValueDateTextField(data.getValueDate())
				    							 	   	.sendKeysDisbursementModeDetails(data.getCreditAccountId())
				    							         .pressSubmitButton()
				    							          .saveAccountId(data.getMurabahaAccountId(), data.getLinkedTcid());
		}
	}