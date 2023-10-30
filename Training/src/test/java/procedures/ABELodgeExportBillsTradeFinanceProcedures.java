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
		lodgeExportBillsTradeFinancePage.pressContinue2Button()
										 .pressTenorDetailsEditButton()
										  .sendKeysTenorMonthsTextField(data.getTenorMonths())
										   .sendKeysTenorDaysTextField(data.getTenorDays())
										    .sendKeysBillDateTextField(data.getBillDate())
										     .sendKeysOnboardDateTextField(data.getOnboardDate())
										      .pressTenorDetailsUpdateButton()
										       .pressContinue3Button()
										        .sendKeysInvoiceAmountTextField(data.getInvoiceAmount())
										         .sendKeysInvoiceNumberTextField(data.getInvoiceNumber())
										          .sendKeysInvoiceDateTextField(data.getInvoiceDate())
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
										                              .saveBillId(data.getLinkedTcid());
		}
	}