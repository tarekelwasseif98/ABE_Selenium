package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEDisburseCorporateLoanCorporateLoansData;
import pageobjects.ABEDisburseCorporateLoanCorporateLoansPage;
import utils.FinacleFieldsUtils;

public class ABEDisburseCorporateLoanCorporateLoansProcedures {

	public static void ABEDisburseCorporateLoanCorporateLoans(WebDriver driver, ABEDisburseCorporateLoanCorporateLoansData data) throws Exception {
		ABEDisburseCorporateLoanCorporateLoansPage ABEDisburseCorporateLoanCorporateLoans = new ABEDisburseCorporateLoanCorporateLoansPage(driver);
		ABEDisburseCorporateLoanCorporateLoans.sendKeysSearchBarTextField(data.getMenu())
									       .switchFormAreaFrame()
									       .sendKeysAccoundId(data.getAccountId());
									       if(data.getValueDate().equalsIgnoreCase("FutureValueDate")) {
									    	  
									    	   ABEDisburseCorporateLoanCorporateLoans.sendKeyValueDate(data.getValueDate());
									       }else if(data.getValueDate().equalsIgnoreCase("CurrentValueDate")) {
									    	   
									    	   ABEDisburseCorporateLoanCorporateLoans.sendKeyValueDate(data.getValueDate()); 
									       }else if(data.getValueDate().equalsIgnoreCase("BackValueDate")) {
									    	   
									    	   ABEDisburseCorporateLoanCorporateLoans.sendKeyValueDate(data.getValueDate()); 
									       }
									       
									       if(data.getDisbursmentType().equalsIgnoreCase(FinacleFieldsUtils.NETDISBURSMENTTYPE))
									       {
									    	   ABEDisburseCorporateLoanCorporateLoans.selectNetDisbursmentRadioButton();
									       }
									       else if (data.getDisbursmentType().equalsIgnoreCase(FinacleFieldsUtils.GROSSDISBURSMENTTYPE)) {
									    	   ABEDisburseCorporateLoanCorporateLoans.selectGrossDisbursmentRadioButton();
									       }
									          ABEDisburseCorporateLoanCorporateLoans.pressDisbursmentDetailsContinueButton()
									         .pressAdditionalDetailsButton();
									       
									       if(ABEDisburseCorporateLoanCorporateLoans.ViewEditButton()) {
									    	   
									    	   ABEDisburseCorporateLoanCorporateLoans.pressEditButton()
									    	   .sendKeysDisbursmentAccount(data.getDisbursmentAccount())
									    	   .pressSaveAndPreviewButton();
									       }
									       
									       ABEDisburseCorporateLoanCorporateLoans.pressAddButton()
									       .enterDeatilsDrawDown(data.getDisbursmentAccount())
									       .pressDisbursmentModeContinueButton()
									       .pressSubmitButton();
													}

}
