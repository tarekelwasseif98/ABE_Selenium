package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenCorporateLoanCorporateLoansData;
import pageobjects.ABEOpenCorporateLoanCorporateLoansPage;
import utils.FinacleFieldsUtils;

public class ABEOpenCorporateLoanCorporateLoansProcedures {
	public static void openCorporateLoanCorporateLoans(WebDriver driver, ABEOpenCorporateLoanCorporateLoansData data) throws Exception {
		ABEOpenCorporateLoanCorporateLoansPage openCorporateLoanCorporateLoansPage = new ABEOpenCorporateLoanCorporateLoansPage(driver);
		openCorporateLoanCorporateLoansPage.sendKeysSearchBarTextField(data.getMenu())
				    					    .switchFormAreaFrame()
				    						 .sendKeysCifIdTextField(data.getCif())
				    						  .sendKeysSchemeCodeTextField(data.getSchemeCode())
				    						   .pressGoButton()
				    						    .sendKeysAccountOpeningDateTextField(data.getAccountOpeningDate())
				    							 .selectAccountStatement()
				    							  .pressContinue1Button()
				    							   .sendKeysLoanAmountTextField(data.getLoanAmount())
				    							    .sendKeysLoanPeriodMonthsTextField(data.getLoanPeriodMonths())
				    							     .sendKeysLoanPeriodDaysTextField(data.getLoanPeriodDays())
				    							      .pressContinue2Button()
				    							       .pressContinue3Button()
				    							        .selectInterestCompoundingFrequency()
				    							         .pressContinue4Button()
				    							          .pressContinue5Button()
				    							           .sendKeysNumberOfInstallmentsTextField(data.getNumberOfInstallments())
				    							            .sendKeysInstallmentStartDateTextField(data.getInstallmentStartDate());
				    							             if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)){
				    							            	 openCorporateLoanCorporateLoansPage.selectInstallmentFrequencyDaily()
				    							                	  								 .selectInstallmentFrequencyCalendar()
				    							                	  								  .selectInstallmentFrequencyOnHoliday();
				    							            	 }
				    							             else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectInstallmentFrequencyWeekly()
			                	  									  							     .selectInstallmentFrequencyCalendar()
			                	  									  								  .selectInstallmentFrequencyOnHoliday();
				    							            	 }
				    							             else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectInstallmentFrequencyFortnightly()
				    							                	  								 .selectInstallmentFrequencyCalendar()
				    							                	  								  .selectInstallmentFrequencyOnHoliday();
				    							            	 }
				    							             else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYBULLET)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectInstallmentFrequencyBullet()
			                	  									  							     .selectInstallmentFrequencyCalendar()
			                	  									  								  .selectInstallmentFrequencyOnHoliday();
				    							            	 }
				    							             else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectInstallmentFrequencyMonthly()
				    							                	  								 .selectInstallmentFrequencyDate(data.getDate())
			                	  									  								  .selectInstallmentFrequencyCalendar()
			                	  									  								   .selectInstallmentFrequencyOnHoliday();
				    							            	 }
				    							             else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectInstallmentFrequencyQuarterly()
				    							                	  								 .selectInstallmentFrequencyDate(data.getDate())
			                	  									  								  .selectInstallmentFrequencyCalendar()
			                	  									  								   .selectInstallmentFrequencyOnHoliday();
				    							            	 }
				    							             else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectInstallmentFrequencyHalfYearly()
				    							                	  								 .selectInstallmentFrequencyDate(data.getDate())
			                	  									  								  .selectInstallmentFrequencyCalendar()
			                	  									  								   .selectInstallmentFrequencyOnHoliday();
				    							            	 }
				    							             else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectInstallmentFrequencyYearly()
				    							                	  								 .selectInstallmentFrequencyDate(data.getDate())
			                	  									  								  .selectInstallmentFrequencyCalendar()
			                	  									  								   .selectInstallmentFrequencyOnHoliday();
				    							            	 }
				    							             if(data.getEquatedInstallment().equalsIgnoreCase(FinacleFieldsUtils.EQUATEDINSTALLMENTNO)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectEquatedInstallmentNo()
				    							                	  							     .sendKeysInterestStartDateTextField(data.getInterestStartDate());
				    							            	 if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)) {
				    							            		 openCorporateLoanCorporateLoansPage.selectInterestFrequencyDaily()
				    							                	  									 .selectInterestFrequencyCalendar()
				    							                	  									  .selectInterestFrequencyOnHoliday();
				    							            		 }
				    							            	 else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
				    							            		 openCorporateLoanCorporateLoansPage.selectInterestFrequencyWeekly()
				    							            		 									 .selectInterestFrequencyCalendar()
			                	  										 								  .selectInterestFrequencyOnHoliday();
				    							            		 }
				    							            	 else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
				    							            		 openCorporateLoanCorporateLoansPage.selectInterestFrequencyFortnightly()
										 									 							 .selectInterestFrequencyCalendar()
										 									 							  .selectInterestFrequencyOnHoliday();
				    							            		 }
				    							            	 else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)){
				    							            		 openCorporateLoanCorporateLoansPage.selectInterestFrequencyMonthly()
				    							                	  									 .selectInterestFrequencyDate(data.getDate())
	 									 									 							  .selectInterestFrequencyCalendar()
	 									 									 							   .selectInterestFrequencyOnHoliday();
				    							            		 }
				    							            	 else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY)) {
				    							            		 openCorporateLoanCorporateLoansPage.selectInterestFrequencyQuarterly()
			                	  										 								 .selectInterestFrequencyDate(data.getDate())
			                	  										 								  .selectInterestFrequencyCalendar()
			                	  										 								   .selectInterestFrequencyOnHoliday();
				    							            		 }
				    							            	 else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY)) {
				    							            		 openCorporateLoanCorporateLoansPage.selectInterestFrequencyHalfYearly()
			                	  										 								 .selectInterestFrequencyDate(data.getDate())
			                	  										 								  .selectInterestFrequencyCalendar()
			                	  										 								   .selectInterestFrequencyOnHoliday();
				    							            		 }
				    							            	 else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY)) {
				    							            		 openCorporateLoanCorporateLoansPage.selectInterestFrequencyYearly()
			                	  										 								 .selectInterestFrequencyDate(data.getDate())
			                	  										 								  .selectInterestFrequencyCalendar()
			                	  										 								   .selectInterestFrequencyOnHoliday();
				    							            		 }
				    							            	 else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYTWICEAMONTH)) {
				    							            		 openCorporateLoanCorporateLoansPage.selectInterestFrequencyTwiceAMonth()
				    							            		 									 .selectInterestFrequencyDate(data.getDate())
				    							            		 									  .selectInterestFrequencyCalendar()
				    							            		 									   .selectInterestFrequencyOnHoliday();
				    							            		 }
				    							            	 }
				    							             else if(data.getEquatedInstallment().equalsIgnoreCase(FinacleFieldsUtils.EQUATEDINSTALLMENTYES)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectEquatedInstallmentYes();
				    							            	 }
				    							             openCorporateLoanCorporateLoansPage.pressContinue6Button()
				    							             									 .pressContinue7Button()
				    							             									  .sendKeysOperativeAccountIdTextField(data.getOperativeAccountId())
				    							             									   .pressContinue8Button()
				    							             									    .pressContinue9Button()
				    							             									     .pressContinue10Button()
				    							             									      .pressContinue11Button()
				    							             									       .pressContinue12Button()
				    							             									        .sendKeysDocumentDateTextField(data.getDocumentDate())
				    							             									         .sendKeysLimitIdTextField(data.getLimitIdPrefix(), data.getLimitIdSuffix());
				    							             if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORDERIVED)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectDrawingPowerIndicatorDerived();
				    							            	 }
				    							             else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATOREQUAL)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectDrawingPowerIndicatorEqual();
				    							            	 }
				    							             else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORMAINTAINED)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectDrawingPowerIndicatorMaintained();
				    							            	 }
				    							             else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORPARENT)) {
				    							            	 openCorporateLoanCorporateLoansPage.selectDrawingPowerIndicatorParent();
				    							            	 }
				    							             openCorporateLoanCorporateLoansPage.sendKeysExpiryDateTextField(data.getExpiryDate())
				    							             									 .pressSubmitButton()
				    							             									  .saveAccountId(data.getLinkedTcid(), data.getModifyLinkedTcid(), data.getDisburseLinkedTcid());				    							                    
		}
	}