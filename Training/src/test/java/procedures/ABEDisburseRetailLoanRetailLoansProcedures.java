package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEDisburseRetailLoanRetailLoansData;
import pageobjects.ABEDisburseRetailLoanRetailLoansPage;
import utils.FinacleFieldsUtils;

public class ABEDisburseRetailLoanRetailLoansProcedures {
	
	public static void ABEDisburseRetailLoanRetailLoans(WebDriver driver, ABEDisburseRetailLoanRetailLoansData data) throws Exception {
		ABEDisburseRetailLoanRetailLoansPage ABEDisburseRetailLoanRetailLoans = new ABEDisburseRetailLoanRetailLoansPage(driver);
		ABEDisburseRetailLoanRetailLoans.sendKeysSearchBarTextField(data.getMenu())
									       .switchFormAreaFrame()
									       .sendKeysAccoundId(data.getAccountId())
									       .SelectTransferRadioButton();
									       if(data.getDisbursmentType().equals(FinacleFieldsUtils.NETDISBURSEMENTTYPE))
									       {
									    	   ABEDisburseRetailLoanRetailLoans.SelectNetDisbursmentRadioButton();
									       }
									       else if (data.getDisbursmentType().equals(FinacleFieldsUtils.GROSSDISBURSEMENTTYPE)) {
									    	
									    	   ABEDisburseRetailLoanRetailLoans.SelectGrossDisbursmentRadioButton();
									       }
									       if(data.getFinalDisbursment().equals(FinacleFieldsUtils.FULLDISBURSEMENT))
									       {
									    	   ABEDisburseRetailLoanRetailLoans.SelectFullDisbursmentRadioButton();

									       }
									       else if(data.getFinalDisbursment().equals(FinacleFieldsUtils.PARTIALDISBURSEMENT))
									       {
									    	   ABEDisburseRetailLoanRetailLoans.SelectPartialDisbursmentRadioButton();
									    	   
									       }
									       
								       	   ABEDisburseRetailLoanRetailLoans.PressDisbursmentDetailsContinueButton()
								       	   .pressAdditionalDetailsButton()
								    	   .PressDisbursmentModeContinueButton()
								    	   .PressAddButton()
								    	   .sendKeysDisbursmentAccount(data.getDisbursmentAccount())
								    	   .PressSaveAndPreviewButton()
								    	   .PressDisbursmentModeContinueButton()
								    	   .PressSubmitButton();

									       
													}
											
											}
