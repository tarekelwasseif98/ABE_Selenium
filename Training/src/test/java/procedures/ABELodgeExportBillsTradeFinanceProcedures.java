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
		else if(data.getType().equalsIgnoreCase(FinacleFieldsUtils.BILLTYPEMIXEDTENOR)) {
			if(data.getMixedBillTenor1().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT)) {
				lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
												 .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
												  .selectBillTenorSight()
												   .sendKeysBillDateTextField(data.getMixedBillDate1())
												    .sendKeysOnboardDateTextField(data.getMixedOnboardDate1())
												     .pressTenorDetailsSaveAndPreviewButton();
				}
			else if(data.getMixedBillTenor1().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) {
				lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
												 .sendKeysMixedBillAmountTextField(data.getMixedBillAmount1())
												  .selectBillTenorUsance()
												   .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths1())
												    .sendKeysTenorDaysTextField(data.getMixedBillTenorDays1())
												     .sendKeysBillDateTextField(data.getMixedBillDate1())
												      .sendKeysOnboardDateTextField(data.getMixedOnboardDate1())
												       .pressTenorDetailsSaveAndPreviewButton();
				}
		if(data.getMixedBillTenor2().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT)) {
			lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
											 .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
											  .selectBillTenorSight()
											   .sendKeysBillDateTextField(data.getMixedBillDate2())
											    .sendKeysOnboardDateTextField(data.getMixedOnboardDate2())
											     .pressTenorDetailsSaveAndPreviewButton();
			}
		else if(data.getMixedBillTenor2().equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) {
				lodgeExportBillsTradeFinancePage.pressTenorDetailsAddButton()
												 .sendKeysMixedBillAmountTextField(data.getMixedBillAmount2())
												  .selectBillTenorUsance()
												   .sendKeysTenorMonthsTextField(data.getMixedBillTenorMonths2())
												    .sendKeysTenorDaysTextField(data.getMixedBillTenorDays2())
												     .sendKeysBillDateTextField(data.getMixedBillDate2())
												      .sendKeysOnboardDateTextField(data.getMixedOnboardDate2())
												       .pressTenorDetailsSaveAndPreviewButton();
				}
		}
		lodgeExportBillsTradeFinancePage.pressContinue3Button()
										 .sendKeysInvoiceAmountTextField(data.getInvoiceAmount())
										  .sendKeysInvoiceNumberTextField(data.getInvoiceNumber())
										   .sendKeysInvoiceDateTextField(data.getInvoiceDate())
										    .sendKeysNotionalConversionRateTextField(data.getNotionalConversionRate())
										     .pressContinue4Button()
										      .pressContinue5Button()
										       .pressContinue6Button()
										        .pressContinue7Button()
										         .pressContinue8Button()
										          .pressContinue9Button()
										           .pressContinue10Button()
										            .pressContinue11Button()
										             .sendKeysPaySysIdTextField(data.getPaySysId())
										              .pressContinue12Button()
										               .pressContinue13Button()
										                .pressContinue14Button()
										                 .pressContinue15Button()
										                  .pressContinue16Button()
										                   .pressContinue17Button()
										                    .pressContinue18Button()
										                     .pressContinue19Button()
										                      .pressContinue20Button()
										                       .pressSubmitButton()
										                        .saveBillId(data.getLinkedTcid(), data.getAcceptLinkedTcid(), data.getVerifyAcceptLinkedTcid(), data.getPurchaseLinkedTcid(), data.getVerifyPurchaseLinkedTcid(), data.getRealizeLinkedTcid(), data.getVerifyRealizeLinkedTcid());
		}
	}