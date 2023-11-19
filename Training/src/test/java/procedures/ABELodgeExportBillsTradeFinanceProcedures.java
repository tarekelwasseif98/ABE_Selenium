package procedures;

import org.openqa.selenium.WebDriver;
import data.ABELodgeExportBillsTradeFinanceData;
import pageobjects.ABELodgeExportBillsTradeFinancePage;
import utils.FinacleFieldsUtils;

public class ABELodgeExportBillsTradeFinanceProcedures {
	public static void lodgeExportBillsTradeFinance(WebDriver driver, ABELodgeExportBillsTradeFinanceData data) throws Exception {
		ABELodgeExportBillsTradeFinancePage lodgeExportBillsTradeFinancePage = new ABELodgeExportBillsTradeFinancePage(driver);
		lodgeExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
				    					 .switchFormAreaFrame()
				    					  .sendKeysBillTypeTextField(data.getBillType())
				    					   .sendKeysBillCcyTextField(data.getBillCcy())
				    					    .sendKeysCifIdTextField(data.getCifId());
		if(data.getUnderDocumentaryCredit().equalsIgnoreCase(FinacleFieldsUtils.UNDERDOCUMENTARYCREDITYES)) {
			lodgeExportBillsTradeFinancePage.pressUnderDocumentaryCreditYesButton()
											 .sendKeysDocumentaryCreditNoTextField(data.getDocumentaryCreditNo());
			}
		else if(data.getUnderDocumentaryCredit().equalsIgnoreCase(FinacleFieldsUtils.UNDERDOCUMENTARYCREDITNO)) {
			lodgeExportBillsTradeFinancePage.pressUnderDocumentaryCreditNoButton();
			}
		lodgeExportBillsTradeFinancePage.pressGoButton()
										 .sendKeysOperativeAccountIdTextField(data.getOperativeAccountId());
		if(data.getDrawerSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSYES)) {
			lodgeExportBillsTradeFinancePage.pressDrawerSwiftAddressDetailsYesButton();
			}
		else if(data.getDrawerSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSNO)) {
			lodgeExportBillsTradeFinancePage.pressDrawerSwiftAddressDetailsNoButton();
			}
		lodgeExportBillsTradeFinancePage.sendKeysBillAmountTextField(data.getBillAmount())
										 .sendKeysBillCountryTextField(data.getBillCountry())
										  .sendKeysLodgeDateTextField(data.getLodgeDate())
										   .pressContinue1Button()
										    .sendKeysDraweeNameTextField(data.getDraweeName())
										     .sendKeysDraweeAddressLine1TextField(data.getDraweeAddress());
		if(data.getDraweeSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSYES)) {
			lodgeExportBillsTradeFinancePage.pressDraweeSwiftAddressDetailsYesButton();
			}
		else if(data.getDraweeSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSNO)) {
			lodgeExportBillsTradeFinancePage.pressDraweeBankSwiftAddressDetailsNoButton();
			}
		lodgeExportBillsTradeFinancePage.pressDraweeBankDetailsButton();
		if(data.getDraweeBankAddressType().equalsIgnoreCase(FinacleFieldsUtils.ADDRESSTYPEBANKIDENTIFIER)) {
			lodgeExportBillsTradeFinancePage.selectDraweeBankAddressTypeBankIdentifier();
			}
		else if(data.getDraweeBankAddressType().equalsIgnoreCase(FinacleFieldsUtils.ADDRESSTYPENAMEANDADDRESS)) {
			lodgeExportBillsTradeFinancePage.selectDraweeBankAddressTypeNameAndAddress();
			}
		lodgeExportBillsTradeFinancePage.sendKeysDraweeBankIdentifierTextField(data.getDraweeBankIdentifier());
		if(data.getDraweeBankSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSYES)) {
			lodgeExportBillsTradeFinancePage.pressDraweeBankSwiftAddressDetailsYesButton()
											 .sendKeysDraweeBankNameTextField(data.getDraweeBankName())
											  .sendKeysDraweeBankAddressLine1TextField(data.getDraweeBankAddress());
			}
		else if(data.getDraweeBankSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSNO)) {
			lodgeExportBillsTradeFinancePage.pressDraweeBankSwiftAddressDetailsNoButton();
			}
		lodgeExportBillsTradeFinancePage.pressBeneficiaryBankDetailsButton();
		if(data.getBeneficiaryBankAddressType().equalsIgnoreCase(FinacleFieldsUtils.ADDRESSTYPEBANKIDENTIFIER)) {
			lodgeExportBillsTradeFinancePage.selectBeneficiaryBankAddressTypeBankIdentifier();
			}
		else if(data.getBeneficiaryBankAddressType().equalsIgnoreCase(FinacleFieldsUtils.ADDRESSTYPENAMEANDADDRESS)) {
			lodgeExportBillsTradeFinancePage.selectBeneficiaryBankAddressTypeNameAndAddress();
			}
		lodgeExportBillsTradeFinancePage.sendKeysBeneficiaryBankIdentifierTextField(data.getBeneficiaryBankIdentifier());
		if(data.getBeneficiaryBankSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSYES)) {
			lodgeExportBillsTradeFinancePage.pressBeneficiaryBankSwiftAddressDetailsYesButton()
											 .sendKeysBeneficiaryBankNameTextField(data.getBeneficiaryBankName())
											  .sendKeysBeneficiaryBankAddressLine1TextField(data.getBeneficiaryBankAddress());
			}
		else if(data.getBeneficiaryBankSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSNO)) {
			lodgeExportBillsTradeFinancePage.pressBeneficiaryBankSwiftAddressDetailsNoButton();
			}
		lodgeExportBillsTradeFinancePage.pressCollectingBankDetailsButton();
		if(data.getCollectingBankAddressType() != null) {
			if(data.getCollectingBankAddressType().equalsIgnoreCase(FinacleFieldsUtils.ADDRESSTYPEBANKIDENTIFIER)) {
				lodgeExportBillsTradeFinancePage.selectCollectingBankAddressTypeBankIdentifier();
				}
			else if(data.getCollectingBankAddressType().equalsIgnoreCase(FinacleFieldsUtils.ADDRESSTYPENAMEANDADDRESS)) {
				lodgeExportBillsTradeFinancePage.selectCollectingBankAddressTypeNameAndAddress();
				}
		}
		if(data.getCollectingBankIdentifier() != null) {
			lodgeExportBillsTradeFinancePage.sendKeysCollectingBankIdentifierTextField(data.getCollectingBankIdentifier());
		}
		if(data.getCollectingBankSwiftAddressDetails() != null) {
			if(data.getCollectingBankSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSYES)) {
				lodgeExportBillsTradeFinancePage.pressCollectingBankSwiftAddressDetailsYesButton()
												 .sendKeysCollectingBankNameTextField(data.getCollectingBankName())
												  .sendKeysCollectingBankAddressLine1TextField(data.getCollectingBankAddress());
				}
			else if(data.getCollectingBankSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSNO)) {
				lodgeExportBillsTradeFinancePage.pressCollectingBankSwiftAddressDetailsNoButton();
				}
		}
		lodgeExportBillsTradeFinancePage.pressCorrespondentBankDetailsButton();
		if(data.getCorrespondentBankAddressType().equalsIgnoreCase(FinacleFieldsUtils.ADDRESSTYPEBANKIDENTIFIER)) {
			lodgeExportBillsTradeFinancePage.selectCorrespondentBankAddressTypeBankIdentifier();
			}
		else if(data.getCorrespondentBankAddressType().equalsIgnoreCase(FinacleFieldsUtils.ADDRESSTYPENAMEANDADDRESS)) {
			lodgeExportBillsTradeFinancePage.selectCorrespondentBankAddressTypeNameAndAddress();
			}
		lodgeExportBillsTradeFinancePage.sendKeysCorrespondentBankIdentifierTextField(data.getCorrespondentBankIdentifier());
		if(data.getCorrespondentBankSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSYES)) {
			lodgeExportBillsTradeFinancePage.pressCorrespondentBankSwiftAddressDetailsYesButton()
											 .sendKeysCorrespondentBankNameTextField(data.getCorrespondentBankName())
											  .sendKeysCorrespondentBankAddressLine1TextField(data.getCorrespondentBankAddress());
			}
		else if(data.getCorrespondentBankSwiftAddressDetails().equalsIgnoreCase(FinacleFieldsUtils.SWIFTADDRESSDETAILSNO)) {
			lodgeExportBillsTradeFinancePage.pressCorrespondentBankSwiftAddressDetailsNoButton();
			}
		lodgeExportBillsTradeFinancePage.pressContinue2Button();
		if(data.getType().equalsIgnoreCase(FinacleFieldsUtils.BILLTYPESIGHT)) {
			lodgeExportBillsTradeFinancePage.pressTenorDetailsEditButton()
											 .sendKeysBillDateTextField(data.getSightBillDate())
											  .sendKeysOnboardDateTextField(data.getSightOnboardDate())
											   .sendKeysDueDateTextField(data.getSightDueDate())
											    .pressTenorDetailsUpdateButton();
			}
		else if(data.getType().equalsIgnoreCase(FinacleFieldsUtils.BILLTYPEUSANCE)) {
			lodgeExportBillsTradeFinancePage.pressTenorDetailsEditButton()
											 .sendKeysTenorMonthsTextField(data.getUsanceTenorMonths())
											  .sendKeysTenorDaysTextField(data.getUsanceTenorDays())
											   .sendKeysBillDateTextField(data.getUsanceBillDate())
											    .sendKeysOnboardDateTextField(data.getUsanceOnboardDate())
												 .pressTenorDetailsUpdateButton();
			}
		else if(data.getType().equalsIgnoreCase(FinacleFieldsUtils.BILLTYPEMIXEDTENOR) && data.getUnderDocumentaryCredit().equalsIgnoreCase(FinacleFieldsUtils.UNDERDOCUMENTARYCREDITNO)) {
			if(data.getMixedBillTenor1().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT)) {
				lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
												 .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
												  .selectBillTenorSight()
												   .sendKeysBillDateTextField(data.getMixedBillDate1())
												    .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate1())
												     .sendKeysDueDateTextField(data.getMixedBillDueDate1())
												     .pressTenorDetailsSaveAndPreviewButton();
				}
			else if(data.getMixedBillTenor1().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) {
				lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
												 .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
												  .selectBillTenorUsance()
												   .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths1())
												    .sendKeysTenorDaysTextField(data.getMixedBillTenorDays1())
												     .sendKeysBillDateTextField(data.getMixedBillDate1())
												      .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate1())
												       .pressTenorDetailsSaveAndPreviewButton();
				}
		if(data.getMixedBillTenor2().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT)) {
			lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
											 .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
											  .selectBillTenorSight()
											   .sendKeysBillDateTextField(data.getMixedBillDate2())
											    .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate2())
											     .sendKeysDueDateTextField(data.getMixedBillDueDate2())
											      .pressTenorDetailsSaveAndPreviewButton();
			}
		else if(data.getMixedBillTenor2().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) {
				lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
												 .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
												  .selectBillTenorUsance()
												   .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths2())
												    .sendKeysTenorDaysTextField(data.getMixedBillTenorDays2())
												     .sendKeysBillDateTextField(data.getMixedBillDate2())
												      .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate2())
												       .pressTenorDetailsSaveAndPreviewButton();
				}
		}
		else if(data.getType().equalsIgnoreCase(FinacleFieldsUtils.BILLTYPEMIXEDTENOR) && data.getUnderDocumentaryCredit().equalsIgnoreCase(FinacleFieldsUtils.UNDERDOCUMENTARYCREDITYES)){
			lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
										 	 .pressTenorDetailsButton();
			if(lodgeExportBillsTradeFinancePage.getTextdueDateIndicator1TextField().equalsIgnoreCase(FinacleFieldsUtils.DUEDATEINDICATORACCEPTANCEDATE) && lodgeExportBillsTradeFinancePage.getTextdueDateIndicator2TextField().equalsIgnoreCase(FinacleFieldsUtils.DUEDATEINDICATORACCEPTANCEDATE)) {
				lodgeExportBillsTradeFinancePage.sendKeysUtilizedAmount1TextField(data.getMixedBillAmount1())
				 								 .pressAcceptTenorDetailsButton()
				 								  .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
				 								   .selectBillTenorUsance()
				 								    .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths1())
				 								     .sendKeysTenorDaysTextField(data.getMixedBillTenorDays1())
				 								      .sendKeysBillDateTextField(data.getMixedBillDate1())
				 								       .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate1())
				 								        .pressTenorDetailsSaveAndPreviewButton()
				 								         .pressTenorDetailsAddButton()
				 								          .pressTenorDetailsButton()
				 								           .sendKeysUtilizedAmount2TextField(data.getMixedBillAmount2())
														    .pressAcceptTenorDetailsButton()
														     .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
														      .selectBillTenorUsance()
														       .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths2())
														        .sendKeysTenorDaysTextField(data.getMixedBillTenorDays2())
														         .sendKeysBillDateTextField(data.getMixedBillDate2())
														          .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate2())
														           .pressTenorDetailsSaveAndPreviewButton();
				} else if(lodgeExportBillsTradeFinancePage.getTextdueDateIndicator1TextField().equalsIgnoreCase(FinacleFieldsUtils.DUEDATEINDICATORSIGHT) && lodgeExportBillsTradeFinancePage.getTextdueDateIndicator2TextField().equalsIgnoreCase(FinacleFieldsUtils.DUEDATEINDICATORSIGHT)) {
					lodgeExportBillsTradeFinancePage.sendKeysUtilizedAmount1TextField(data.getMixedBillAmount1())
					 								 .pressAcceptTenorDetailsButton()
					 								  .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
					 								   .selectBillTenorSight()
					 								    .sendKeysBillDateTextField(data.getMixedBillDate1())
					 								     .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate1())
					 								      .sendKeysDueDateTextField(data.getMixedBillDueDate1())
					 								       .pressTenorDetailsSaveAndPreviewButton()
					 								        .pressTenorDetailsAddButton()
				 								             .pressTenorDetailsButton()
				 								              .sendKeysUtilizedAmount2TextField(data.getMixedBillAmount2())
							 								   .pressAcceptTenorDetailsButton()
							 								    .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
							 								     .selectBillTenorSight()
							 								      .sendKeysBillDateTextField(data.getMixedBillDate2())
							 								       .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate2())
							 								        .sendKeysDueDateTextField(data.getMixedBillDueDate2())
							 								         .pressTenorDetailsSaveAndPreviewButton();
					}
				else if(lodgeExportBillsTradeFinancePage.getTextdueDateIndicator1TextField().equalsIgnoreCase(FinacleFieldsUtils.DUEDATEINDICATORACCEPTANCEDATE) && lodgeExportBillsTradeFinancePage.getTextdueDateIndicator2TextField().equalsIgnoreCase(FinacleFieldsUtils.DUEDATEINDICATORSIGHT)) {
					if(data.getMixedBillTenor1().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE) && data.getMixedBillTenor2().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT)) {
						lodgeExportBillsTradeFinancePage.sendKeysUtilizedAmount1TextField(data.getMixedBillAmount1())
						 								 .pressAcceptTenorDetailsButton()
						 								  .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
						 								   .selectBillTenorUsance()
						 								    .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths1())
						 								     .sendKeysTenorDaysTextField(data.getMixedBillTenorDays1())
						 								      .sendKeysBillDateTextField(data.getMixedBillDate1())
						 								       .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate1())
						 								        .pressTenorDetailsSaveAndPreviewButton()
						 								         .pressTenorDetailsAddButton()
						 								          .pressTenorDetailsButton()
						 								           .sendKeysUtilizedAmount2TextField(data.getMixedBillAmount2())
								 								    .pressAcceptTenorDetailsButton()
								 								     .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
								 								      .selectBillTenorSight()
								 								       .sendKeysBillDateTextField(data.getMixedBillDate2())
								 								        .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate2())
								 								         .sendKeysDueDateTextField(data.getMixedBillDueDate2())
								 								          .pressTenorDetailsSaveAndPreviewButton();
						}
					else if(data.getMixedBillTenor1().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT) && data.getMixedBillTenor2().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) {
						lodgeExportBillsTradeFinancePage.sendKeysUtilizedAmount1TextField(data.getMixedBillAmount2())
					    								 .pressAcceptTenorDetailsButton()
					    								  .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
					    								   .selectBillTenorUsance()
					    								    .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths2())
					    								     .sendKeysTenorDaysTextField(data.getMixedBillTenorDays2())
					    								      .sendKeysBillDateTextField(data.getMixedBillDate2())
					    								       .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate2())
					    								        .pressTenorDetailsSaveAndPreviewButton()
					    								         .pressTenorDetailsAddButton()
						 								          .pressTenorDetailsButton()
						 								           .sendKeysUtilizedAmount2TextField(data.getMixedBillAmount1())
								 								    .pressAcceptTenorDetailsButton()
								 								     .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
								 								      .selectBillTenorSight()
								 								       .sendKeysBillDateTextField(data.getMixedBillDate1())
								 								        .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate1())
								 								         .sendKeysDueDateTextField(data.getMixedBillDueDate1())
								 								          .pressTenorDetailsSaveAndPreviewButton();
						}
					}
				else if(lodgeExportBillsTradeFinancePage.getTextdueDateIndicator1TextField().equalsIgnoreCase(FinacleFieldsUtils.DUEDATEINDICATORSIGHT) && lodgeExportBillsTradeFinancePage.getTextdueDateIndicator2TextField().equalsIgnoreCase(FinacleFieldsUtils.DUEDATEINDICATORACCEPTANCEDATE)) {
					if(data.getMixedBillTenor1().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT) && data.getMixedBillTenor2().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) {
						lodgeExportBillsTradeFinancePage.sendKeysUtilizedAmount1TextField(data.getMixedBillAmount1())
						 								 .pressAcceptTenorDetailsButton()
						 								  .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
						 								   .selectBillTenorSight()
						 								    .sendKeysBillDateTextField(data.getMixedBillDate1())
						 								     .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate1())
						 								      .sendKeysDueDateTextField(data.getMixedBillDueDate1())
						 								       .pressTenorDetailsSaveAndPreviewButton()
						 								        .pressTenorDetailsAddButton()
						 								         .pressTenorDetailsButton()
						 								          .sendKeysUtilizedAmount2TextField(data.getMixedBillAmount2())
						 								           .pressAcceptTenorDetailsButton()
						 								            .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
						 								             .selectBillTenorUsance()
						 								              .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths2())
						 								               .sendKeysTenorDaysTextField(data.getMixedBillTenorDays2())
						 								                .sendKeysBillDateTextField(data.getMixedBillDate2())
						 								                 .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate2())
						 								                  .pressTenorDetailsSaveAndPreviewButton();
					}
					else if(data.getMixedBillTenor1().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE) && data.getMixedBillTenor2().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT)) {
						lodgeExportBillsTradeFinancePage.sendKeysUtilizedAmount1TextField(data.getMixedBillAmount2())
						  								 .pressAcceptTenorDetailsButton()
						  								  .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
						  								   .selectBillTenorSight()
						  								    .sendKeysBillDateTextField(data.getMixedBillDate2())
						  								     .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate2())
						  								      .sendKeysDueDateTextField(data.getMixedBillDueDate2())
						  								       .pressTenorDetailsSaveAndPreviewButton()
						  								        .sendKeysUtilizedAmount2TextField(data.getMixedBillAmount1())
						  								         .pressAcceptTenorDetailsButton()
						  								          .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
						  								           .selectBillTenorUsance()
						  								            .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths1())
						  								             .sendKeysTenorDaysTextField(data.getMixedBillTenorDays1())
						  								              .sendKeysBillDateTextField(data.getMixedBillDate1())
						  								               .sendKeysOnboardDateTextField(data.getMixedBillOnboardDate1())
						  								                .pressTenorDetailsSaveAndPreviewButton();
						}
					}
			}
		lodgeExportBillsTradeFinancePage.pressContinue3Button()
										 .sendKeysInvoiceAmountTextField(data.getInvoiceAmount())
										  .sendKeysInvoiceNumberTextField(data.getInvoiceNumber())
										   .sendKeysInvoiceDateTextField(data.getInvoiceDate());
		if(data.getDocumentStatus() != null) {
			if(data.getDocumentStatus().equalsIgnoreCase(FinacleFieldsUtils.DOCUMENTSTATUSCLEAN)) {
				lodgeExportBillsTradeFinancePage.selectDocumentStatusClean();
			}
			else if(data.getDocumentStatus().equalsIgnoreCase(FinacleFieldsUtils.DOCUMENTSTATUSDISCREPANT)) {
				lodgeExportBillsTradeFinancePage.selectDocumentStatusDiscrepant();
			}
			else if(data.getDocumentStatus().equalsIgnoreCase(FinacleFieldsUtils.DOCUMENTSTATUSDISCREPANTANDACCEPTED)) {
				lodgeExportBillsTradeFinancePage.selectDocumentStatusDiscrepantAndAccepted();
			}
			else if(data.getDocumentStatus().equalsIgnoreCase(FinacleFieldsUtils.DOCUMENTSTATUSRETURNED)) {
				lodgeExportBillsTradeFinancePage.selectDocumentStatusReturned();
			}
		}
		lodgeExportBillsTradeFinancePage.sendKeysNotionalConversionRateTextField(data.getNotionalConversionRate())
										 .pressContinue4Button()
										  .navigateEventDetailsSideTabMenu()
										   .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
										    .pressContinue5Button()
										     .navigateTransactionDetailsSideTabMenu()
										      .pressSubmitButton()
										       .saveBillId(data.getLinkedTcid(), data.getAcceptLinkedTcid(), data.getVerifyAcceptLinkedTcid(), data.getPurchaseLinkedTcid(), data.getVerifyPurchaseLinkedTcid(), data.getRealizeLinkedTcid(), data.getVerifyRealizeLinkedTcid());
		}
	}