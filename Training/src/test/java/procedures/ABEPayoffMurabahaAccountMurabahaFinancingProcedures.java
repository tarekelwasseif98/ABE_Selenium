package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEPayoffMurabahaAccountMurabahaFinancingData;
import pageobjects.ABEPayoffMurabahaAccountMurabahaFinancingPage;

public class ABEPayoffMurabahaAccountMurabahaFinancingProcedures {
	public static void payoffMurabahaAccountMurabahaFinancing(WebDriver driver, ABEPayoffMurabahaAccountMurabahaFinancingData data) throws Exception {
		ABEPayoffMurabahaAccountMurabahaFinancingPage payoffMurabahaAccountMurabahaFinancingPage = new ABEPayoffMurabahaAccountMurabahaFinancingPage(driver);
		payoffMurabahaAccountMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
				    							 	 .switchFormAreaFrame()
				    							 	  .sendKeysAccountIdTextField(data.getAccountId())
				    							 	   .sendKeysPayoffValueDateTextField(data.getPayoffValueDate())
				    							 	    .selectTransactionType()
				    							 	     .sendKeysRefundAccountIdTextField(data.getRefundAccountId())
				    							 	      .pressGoButton()
				    							 	       .pressContinue1Button()
				    							 	        .pressContinue2Button()
				    							 	         .pressSubmitButton()
				    							 	          .saveAccountId(data.getAccountId(), data.getLinkedTcid());
		}
	}