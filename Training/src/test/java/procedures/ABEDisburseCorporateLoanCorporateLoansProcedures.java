package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEDisburseCorporateLoanCorporateLoansData;
import pageobjects.ABEDisburseCorporateLoanCorporateLoansPage;
import utils.FinacleFieldsUtils;

public class ABEDisburseCorporateLoanCorporateLoansProcedures {

	public static void disburseCorporateLoanCorporateLoans(WebDriver driver, ABEDisburseCorporateLoanCorporateLoansData data) throws Exception {
		ABEDisburseCorporateLoanCorporateLoansPage ABEDisburseCorporateLoanCorporateLoans = new ABEDisburseCorporateLoanCorporateLoansPage(driver);
		ABEDisburseCorporateLoanCorporateLoans.sendKeysSearchBarTextField(data.getMenu())
									       	   .switchFormAreaFrame()
									       	    .sendKeysAccoundId(data.getAccountId())
									       	     .sendKeyValueDate(data.getValueDate());
		if(data.getDisbursmentType().equalsIgnoreCase(FinacleFieldsUtils.NETDISBURSMENTTYPE)) {
			ABEDisburseCorporateLoanCorporateLoans.selectNetDisbursmentRadioButton();
			}
		else if (data.getDisbursmentType().equalsIgnoreCase(FinacleFieldsUtils.GROSSDISBURSMENTTYPE)) {
			ABEDisburseCorporateLoanCorporateLoans.selectGrossDisbursmentRadioButton();
			}
		ABEDisburseCorporateLoanCorporateLoans.pressDisbursmentDetailsContinueButton()
									           .pressAdditionalDetailsButton()
											    .pressEditButton()
									    	   	 .sendKeysDisbursmentAccountTextField(data.getDisbursmentAccount())
									    	      .pressSaveAndPreviewButton()
									    	       .pressDisbursmentModeContinueButton()
										       	    .pressSubmitButton()
										       	     .saveAccountId(data.getAccountId(), data.getLinkedTcId());
		}
	}