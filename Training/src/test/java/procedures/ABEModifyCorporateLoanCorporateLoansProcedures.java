package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEModifyCorporateLoanCorporateLoansData;
import pageobjects.ABEModifyCorporateLoanCorporateLoansPage;
import utils.FinacleFieldsUtils;

public class ABEModifyCorporateLoanCorporateLoansProcedures {
	public static void modifyCorporateLoanCorporateLoans(WebDriver driver, ABEModifyCorporateLoanCorporateLoansData data) throws Exception {
		ABEModifyCorporateLoanCorporateLoansPage modifyCorporateLoanCorporateLoansPage = new ABEModifyCorporateLoanCorporateLoansPage(driver);
		modifyCorporateLoanCorporateLoansPage.sendKeysSearchBarTextField(data.getMenu())
				    					    .switchFormAreaFrame()
				    					     .sendKeysAccountIdTextField(data.getAccountId())
				    						  .pressGoButton();
		if(data.getAccountOpeningDate() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysAccountOpeningDateTextField(data.getAccountOpeningDate());
		}
		modifyCorporateLoanCorporateLoansPage.selectAccountStatement()
				    						  .pressContinue1Button();
		if(data.getLoanAmount() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysLoanAmountTextField(data.getLoanAmount());
		}
		if(data.getLoanPeriodMonths() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysLoanPeriodMonthsTextField(data.getLoanPeriodMonths());
		}
		if(data.getLoanPeriodMonths() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysLoanPeriodDaysTextField(data.getLoanPeriodDays());
		}
		modifyCorporateLoanCorporateLoansPage.pressContinue2Button()
				    					 	  .pressContinue3Button();
		if(data.getInterestPlan() != null) {
			if(data.getInterestPlan().equalsIgnoreCase(FinacleFieldsUtils.INTERESTPLANRELATIVELYPEGGEDTOCOLLATERAL)) {
				modifyCorporateLoanCorporateLoansPage.selectInterestPlanDropDownListRelativelyPeggedToCollateral();
			}
			if(data.getInterestPlan().equalsIgnoreCase(FinacleFieldsUtils.INTERESTPLANFIXEDUPTOMATURITYDATE)) {
				modifyCorporateLoanCorporateLoansPage.selectInterestPlanDropDownListFixedUpToMaturityDate();
			}
			if(data.getInterestPlan().equalsIgnoreCase(FinacleFieldsUtils.INTERESTPLANFIXEDWITHREPRICINGANDFULLYFLOATING)) {
				modifyCorporateLoanCorporateLoansPage.selectInterestPlanDropDownListFixedWithRepricingAndFullyFloating();
			}
			if(data.getInterestPlan().equalsIgnoreCase(FinacleFieldsUtils.INTERESTPLANFIXEDFORATERMANDFLOATINGWITHREPRICING)) {
				modifyCorporateLoanCorporateLoansPage.selectInterestPlanDropDownListFixedForATermAndFloatingWithRepricing();
			}
			if(data.getInterestPlan().equalsIgnoreCase(FinacleFieldsUtils.INTERESTPLANFIXEDTILLMATURITYWITHREPRICING)) {
				modifyCorporateLoanCorporateLoansPage.selectInterestPlanDropDownListFixedTillMaturityWithRepricing();
			}
			if(data.getInterestPlan().equalsIgnoreCase(FinacleFieldsUtils.INTERESTPLANFIXEDANDFLOATINGWITHOUTREPRICING)) {
				modifyCorporateLoanCorporateLoansPage.selectInterestPlanDropDownListFixedAndFloatingWithoutRepricing();
			}
			if(data.getInterestPlan().equalsIgnoreCase(FinacleFieldsUtils.INTERESTPLANFIXEDANDFLOATINGWITHREPRICING)) {
				modifyCorporateLoanCorporateLoansPage.selectInterestPlanDropDownListFixedAndFloatingWithRepricing();
			}
			if(data.getInterestPlan().equalsIgnoreCase(FinacleFieldsUtils.INTERESTPLANFLOATINGUPTOMATURITY)) {
				modifyCorporateLoanCorporateLoansPage.selectInterestPlanDropDownListFloatingUpToMaturity();
			}
		}
		modifyCorporateLoanCorporateLoansPage.selectInterestCompoundingFrequency()
				    					 	   	.pressContinue4Button()
				    					 	   	 .pressContinue5Button();
		if(data.getNumberOfInstallments() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysNumberOfInstallmentsTextField(data.getNumberOfInstallments());
		}
		if(data.getInstallmentStartDate() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysInstallmentStartDateTextField(data.getInstallmentStartDate());
		}
		if(data.getInstallmentFrequency() != null) {
			if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)){
				modifyCorporateLoanCorporateLoansPage.selectInstallmentFrequencyDaily()
												  	  .selectInstallmentFrequencyCalendar()
												  	   .selectInstallmentFrequencyOnHoliday();
				}
			else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
				modifyCorporateLoanCorporateLoansPage.selectInstallmentFrequencyWeekly()
												  	  .selectInstallmentFrequencyCalendar()
												  	   .selectInstallmentFrequencyOnHoliday();
				}
			else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
				modifyCorporateLoanCorporateLoansPage.selectInstallmentFrequencyFortnightly()
													  .selectInstallmentFrequencyCalendar()
													   .selectInstallmentFrequencyOnHoliday();
				}
			else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYBULLET)) {
				modifyCorporateLoanCorporateLoansPage.selectInstallmentFrequencyBullet()
													  .selectInstallmentFrequencyCalendar()
													   .selectInstallmentFrequencyOnHoliday();
				}
			else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)) {
				modifyCorporateLoanCorporateLoansPage.selectInstallmentFrequencyMonthly()
													  .selectInstallmentFrequencyDate(data.getDate())
													   .selectInstallmentFrequencyCalendar()
													    .selectInstallmentFrequencyOnHoliday();
				}
			else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY)) {
				modifyCorporateLoanCorporateLoansPage.selectInstallmentFrequencyQuarterly()
													  .selectInstallmentFrequencyDate(data.getDate())
													   .selectInstallmentFrequencyCalendar()
													    .selectInstallmentFrequencyOnHoliday();
				}
			else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY)) {
				modifyCorporateLoanCorporateLoansPage.selectInstallmentFrequencyHalfYearly()
													  .selectInstallmentFrequencyDate(data.getDate())
													   .selectInstallmentFrequencyCalendar()
													    .selectInstallmentFrequencyOnHoliday();
				}
			else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY)) {
				modifyCorporateLoanCorporateLoansPage.selectInstallmentFrequencyYearly()
													  .selectInstallmentFrequencyDate(data.getDate())
													   .selectInstallmentFrequencyCalendar()
													    .selectInstallmentFrequencyOnHoliday();
				}
			}
		if(data.getEquatedInstallment() != null) {
			if(data.getEquatedInstallment().equalsIgnoreCase(FinacleFieldsUtils.EQUATEDINSTALLMENTNO)) {
				modifyCorporateLoanCorporateLoansPage.selectEquatedInstallmentNo()
													  .sendKeysInterestStartDateTextField(data.getInterestStartDate());
				if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)) {
					modifyCorporateLoanCorporateLoansPage.selectInterestFrequencyDaily()
														  .selectInterestFrequencyCalendar()
														   .selectInterestFrequencyOnHoliday();
					}
				else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
					modifyCorporateLoanCorporateLoansPage.selectInterestFrequencyWeekly()
														  .selectInterestFrequencyCalendar()
														   .selectInterestFrequencyOnHoliday();
					}
				else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
					modifyCorporateLoanCorporateLoansPage.selectInterestFrequencyFortnightly()
														  .selectInterestFrequencyCalendar()
														   .selectInterestFrequencyOnHoliday();
					}
				else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)){
					modifyCorporateLoanCorporateLoansPage.selectInterestFrequencyMonthly()
														  .selectInterestFrequencyDate(data.getDate())
														   .selectInterestFrequencyCalendar()
														    .selectInterestFrequencyOnHoliday();
					}
				else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY)) {
					modifyCorporateLoanCorporateLoansPage.selectInterestFrequencyQuarterly()
														  .selectInterestFrequencyDate(data.getDate())
														   .selectInterestFrequencyCalendar()
														    .selectInterestFrequencyOnHoliday();
					}
				else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY)) {
					modifyCorporateLoanCorporateLoansPage.selectInterestFrequencyHalfYearly()
														  .selectInterestFrequencyDate(data.getDate())
														   .selectInterestFrequencyCalendar()
														    .selectInterestFrequencyOnHoliday();
					}
				else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY)) {
					modifyCorporateLoanCorporateLoansPage.selectInterestFrequencyYearly()
														  .selectInterestFrequencyDate(data.getDate())
														   .selectInterestFrequencyCalendar()
														    .selectInterestFrequencyOnHoliday();
					}
				else if(data.getInterestFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYTWICEAMONTH)) {
					modifyCorporateLoanCorporateLoansPage.selectInterestFrequencyTwiceAMonth()
														  .selectInterestFrequencyDate(data.getDate())
														   .selectInterestFrequencyCalendar()
														    .selectInterestFrequencyOnHoliday();
					}
				}
			else if(data.getEquatedInstallment().equalsIgnoreCase(FinacleFieldsUtils.EQUATEDINSTALLMENTYES)) {
				modifyCorporateLoanCorporateLoansPage.selectEquatedInstallmentYes();
				}
			}
		modifyCorporateLoanCorporateLoansPage.pressContinue6Button()
											  .pressContinue7Button();
		if(data.getOperativeAccountId() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysOperativeAccountIdTextField(data.getOperativeAccountId());
		}
		modifyCorporateLoanCorporateLoansPage.pressContinue8Button();
		if(data.getLoanAmount() != null) {
			modifyCorporateLoanCorporateLoansPage.pressDrawdownScheduleEditButton()
												  .sendKeysDrawdownAmountTextField(data.getLoanAmount())
												   .pressDrawdownScheduleUpdateButton();
		}
		if(data.getExpiryDate() != null) {
			modifyCorporateLoanCorporateLoansPage.pressDrawdownScheduleEditButton()
												  .sendKeysDrawdownEndDateTextField(data.getExpiryDate())
												   .pressDrawdownScheduleUpdateButton();
		}
		modifyCorporateLoanCorporateLoansPage.pressContinue9Button()
											   .pressContinue10Button()
											    .pressContinue11Button()
											     .pressContinue12Button();
		if(data.getDocumentDate() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysDocumentDateTextField(data.getDocumentDate());
		}
		if(data.getLimitIdPrefix() != null && data.getLimitIdSuffix() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysLimitIdTextField(data.getLimitIdPrefix(), data.getLimitIdSuffix());
		}
		if(data.getDrawingPowerIndicator() != null) {
			if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORDERIVED)) {
				modifyCorporateLoanCorporateLoansPage.selectDrawingPowerIndicatorDerived();
				}
			else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATOREQUAL)) {
				modifyCorporateLoanCorporateLoansPage.selectDrawingPowerIndicatorEqual();
				}
			else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORMAINTAINED)) {
				modifyCorporateLoanCorporateLoansPage.selectDrawingPowerIndicatorMaintained();
				}
			else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORPARENT)) {
				modifyCorporateLoanCorporateLoansPage.selectDrawingPowerIndicatorParent();
				}
			}
		if(data.getExpiryDate() != null) {
			modifyCorporateLoanCorporateLoansPage.sendKeysExpiryDateTextField(data.getExpiryDate());
			}
		modifyCorporateLoanCorporateLoansPage.pressSubmitButton();
		}
	}