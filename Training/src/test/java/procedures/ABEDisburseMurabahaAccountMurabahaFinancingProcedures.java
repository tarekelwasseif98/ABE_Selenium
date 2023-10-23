package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEDisburseMurabahaAccountMurabahaFinancingData;
import pageobjects.ABEDisburseMurabahaAccountMurabahaFinancingPage;

public class ABEDisburseMurabahaAccountMurabahaFinancingProcedures {
	public static void disburseMurabahaAccountMurabahaFinancing(WebDriver driver, ABEDisburseMurabahaAccountMurabahaFinancingData data) throws Exception {
		ABEDisburseMurabahaAccountMurabahaFinancingPage disburseMurabahaAccountMurabahaFinancingPage = new ABEDisburseMurabahaAccountMurabahaFinancingPage(driver);
		disburseMurabahaAccountMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
				    							 	 .switchFormAreaFrame()
				    							 	  .sendKeysAccountIdTextField(data.getMurabahaAccountId())
				    							 	   .pressGoButton()
				    							 	    .sendKeysValueDateTextField(data.getValueDate())
				    							 	     .selectTransactionType()
				    							 	      .pressContinue1Button()
				    							 	       .pressContinue2Button()
				    							 	        .pressAddButton()
				    							 	         .selectModeOfDisbursement()
				    							 	          .sendKeysCreditAccountIdTextField(data.getCreditAccountId())
				    							 	           .pressSaveAndPreviewButton()
				    							 	            .pressContinue3Button()
				    							 	             .pressSubmitButton()
				    							 	              .saveAccountId(data.getMurabahaAccountId(), data.getLinkedTcid());
		}
	}