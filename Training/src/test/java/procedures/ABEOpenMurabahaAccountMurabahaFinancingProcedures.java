package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEOpenMurabahaAccountMurabahaFinancingData;
import pageobjects.ABEOpenMurabahaAccountMurabahaFinancingPage;
import utils.FinacleFieldsUtils;

public class ABEOpenMurabahaAccountMurabahaFinancingProcedures {
	public static void openMurabahaAccountMurabahaFinancing(WebDriver driver, ABEOpenMurabahaAccountMurabahaFinancingData data) throws Exception {
		ABEOpenMurabahaAccountMurabahaFinancingPage openMurabahaAccountMurabahaFinancingPage = new ABEOpenMurabahaAccountMurabahaFinancingPage(driver);
		openMurabahaAccountMurabahaFinancingPage.sendKeysSearchBarTextField(data.getMenu())
				    							 .switchFormAreaFrame()
				    							  .sendKeysCifIdTextField(data.getCif())
				    							   .sendKeysSchemeCodeTextField(data.getSchemeCode())
				    							    .pressGoButton()
				    							    .sendKeysAccountOpeningDateTextField(data.getAccountOpeningDate())
				    							     .sendKeysAssetValueTextField(data.getAssetValue())
				    							      .sendKeysCustomerMarginTextField(data.getCustomerMargin())
				    							       .pressContinue1Button()
				    							        .sendKeysFinancePeriodMonthsTextField(data.getFinancePeriodMonths())
				    							         .sendKeysFinancePeriodDaysTextField(data.getFinancePeriodDays())
				    							          .sendKeysDebitAccountIdTextField(data.getDebitAccountId())
				    							           .pressContinue2Button()
				    							            .pressContinue3Button()
				    							             .pressContinue4Button()
				    							              .pressContinue5Button();
															   if(data.getEquatedInstallment().equalsIgnoreCase(FinacleFieldsUtils.EQUATEDINSTALLMENTYES)) {
																   openMurabahaAccountMurabahaFinancingPage.selectEquatedInstallmentYes()
																   										    .sendKeysNumberOfInstallmentsTextField(data.getNumberOfInstallments())
																   										     .sendKeysInstallmentStartDateTextField(data.getInstallmentStartDate());
																   										      if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)) {
																   										    	openMurabahaAccountMurabahaFinancingPage.selectInstallmentFrequencyDaily()
																   										    											 .selectEquatedCalendar()
																   										    											  .selectEquatedOnHoliday();
																   										      }
																   										      else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
																   										    	openMurabahaAccountMurabahaFinancingPage.selectInstallmentFrequencyWeekly()
						   										    											 										 .selectEquatedCalendar()
						   										    											 										  .selectEquatedOnHoliday();
																   										      }
																   										      else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
																   										    	openMurabahaAccountMurabahaFinancingPage.selectInstallmentFrequencyFortnightly()
						   										    											 										 .selectEquatedCalendar()
						   										    											 										  .selectEquatedOnHoliday();
																   										      }
																   										      else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)) {
																   										    	openMurabahaAccountMurabahaFinancingPage.selectInstallmentFrequencyMonthly()
																   										    											 .selectEquatedDate(data.getDate())
																   										    											  .selectEquatedCalendar()
																   										    											   .selectEquatedOnHoliday();
																   										      }
																   										      else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY)) {
																   										    	openMurabahaAccountMurabahaFinancingPage.selectInstallmentFrequencyQuarterly()
						   										    											 										 .selectEquatedDate(data.getDate())
						   										    											 										  .selectEquatedCalendar()
						   										    											 										   .selectEquatedOnHoliday();
																   										      }
																   										      else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY)) {
																   										    	openMurabahaAccountMurabahaFinancingPage.selectInstallmentFrequencyHalfYearly()
						   										    											 										 .selectEquatedDate(data.getDate())
						   										    											 										  .selectEquatedCalendar()
						   										    											 										   .selectEquatedOnHoliday();
																   										      }
																   										      else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY)) {
																   										    	openMurabahaAccountMurabahaFinancingPage.selectInstallmentFrequencyYearly()
						   										    											 										 .selectEquatedDate(data.getDate())
						   										    											 										  .selectEquatedCalendar()
						   										    											 										   .selectEquatedOnHoliday();
																   										      }
																   										      else if(data.getInstallmentFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYTWICEAMONTH)) {
																   										    	openMurabahaAccountMurabahaFinancingPage.selectInstallmentFrequencyTwiceAMonth()
						   										    											 										 .selectEquatedDate(data.getDate())
						   										    											 										  .selectEquatedCalendar()
						   										    											 										   .selectEquatedOnHoliday();
																   										    	}
																   										      }
															   else if(data.getEquatedInstallment().equalsIgnoreCase(FinacleFieldsUtils.EQUATEDINSTALLMENTNO)) {
																   openMurabahaAccountMurabahaFinancingPage.selectEquatedInstallmentNo()
																   											.sendKeysNumberOfInstallmentsTextField(data.getNumberOfInstallments())
																   											 .selectInstallmentFrequencyBullet()
																   											  .sendKeysInstallmentStartDateTextField(data.getInstallmentStartDate())
																   											   .selectEquatedCalendar()
																   											    .selectEquatedOnHoliday()
																   											     .sendKeysProfitStartDateTextField(data.getProfitStartDate());
																   												  if(data.getProfitFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYDAILY)) {
																   													openMurabahaAccountMurabahaFinancingPage.selectProfitFrequencyDaily()
																   																							 .selectNonEquatedCalendar()
																   																							  .selectNonEquatedOnHoliday();
																   													}
																   												  else if(data.getProfitFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYWEEKLY)) {
																   													openMurabahaAccountMurabahaFinancingPage.selectProfitFrequencyWeekly()
						   																							 										 .selectNonEquatedCalendar()
						   																							 										  .selectNonEquatedOnHoliday();
																   													}
																   												  else if(data.getProfitFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYFORTNIGHTLY)) {
																   													openMurabahaAccountMurabahaFinancingPage.selectProfitFrequencyFortnightly()
						   																							 										 .selectNonEquatedCalendar()
						   																							 										  .selectNonEquatedOnHoliday();
																   													}
																   												  else if(data.getProfitFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYMONTHLY)) {
																   													openMurabahaAccountMurabahaFinancingPage.selectProfitFrequencyMonthly()
																   																							 .selectNonEquatedDate(data.getDate())
																   																							  .selectNonEquatedCalendar()
																   																							   .selectNonEquatedOnHoliday();
																   													}
																   												  else if(data.getProfitFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYQUARTERLY)) {
																   													openMurabahaAccountMurabahaFinancingPage.selectProfitFrequencyQuarterly()
						   																							 										 .selectNonEquatedDate(data.getDate())
						   																							 										  .selectNonEquatedCalendar()
						   																							 										   .selectNonEquatedOnHoliday();
																   													}
																   												  else if(data.getProfitFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYHALFYEARLY)) {
																   													openMurabahaAccountMurabahaFinancingPage.selectProfitFrequencyHalfYearly()
						   																							 										 .selectNonEquatedDate(data.getDate())
						   																							 										  .selectNonEquatedCalendar()
						   																							 										   .selectNonEquatedOnHoliday();
																   													}
																   												  else if(data.getProfitFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYYEARLY)) {
																   													openMurabahaAccountMurabahaFinancingPage.selectProfitFrequencyYearly()
						   																							 										 .selectNonEquatedDate(data.getDate())
						   																							 										  .selectNonEquatedCalendar()
						   																							 										   .selectNonEquatedOnHoliday();
																   													}
																   												  else if(data.getProfitFrequency().equalsIgnoreCase(FinacleFieldsUtils.FREQUENCYTWICEAMONTH)) {
																   													openMurabahaAccountMurabahaFinancingPage.selectProfitFrequencyTwiceAMonth()
						   																							 										 .selectNonEquatedDate(data.getDate())
						   																							 										  .selectNonEquatedCalendar()
						   																							 										   .selectNonEquatedOnHoliday();
																   													}
																   												  }
															   openMurabahaAccountMurabahaFinancingPage.pressContinue6Button()
															   											.pressContinue7Button()
															   											 .sendKeysOperativeAccountIdTextField(data.getOperativeAccountId())
															   											  .pressContinue8Button()
															   											   .sendKeysExpiryDateTextField(data.getExpiryDate())
															   											    .sendKeysDocumentDateTextField(data.getDocumentDate())
															   											     .sendKeysLimitIdTextField(data.getLimitIdPrefix(), data.getLimitIdSuffix());
															   												  if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORDERIVED)) {
															   													  openMurabahaAccountMurabahaFinancingPage.selectDrawingPowerIndicatorDerived();
															   													  }
															   												  else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATOREQUAL)) {
															   													  openMurabahaAccountMurabahaFinancingPage.selectDrawingPowerIndicatorEqual();
															   													  }
															   												  else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORMAINTAINED)) {
															   													  openMurabahaAccountMurabahaFinancingPage.selectDrawingPowerIndicatorMaintained();
															   													  }
															   												  else if(data.getDrawingPowerIndicator().equalsIgnoreCase(FinacleFieldsUtils.DRAWINGPOWERINDICATORPARENT)) {
															   													  openMurabahaAccountMurabahaFinancingPage.selectDrawingPowerIndicatorParent();
															   													  }
															   												  openMurabahaAccountMurabahaFinancingPage.pressContinue9Button()
															   											    										   .pressContinue10Button()
															   											    										    .pressSubmitButton()
															   											    										     .saveAccountId(data.getLinkedTcid(), data.getDisburseTcid());
		}
	}