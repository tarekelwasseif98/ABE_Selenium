package procedures;

import org.openqa.selenium.WebDriver;

import data.TradeFinanceImportBillsLodgeData;
import pageobjects.TradeFinanceImportBillsLodgePage;
import utils.FinacleFieldsUtils;
import utils.PageFunctionUtils;

public class TradeFinanceImportBillsLodgeProcedures {

	public static void TradeFinanceImportBillsLodge(WebDriver driver, TradeFinanceImportBillsLodgeData data) throws Exception {
		TradeFinanceImportBillsLodgePage lodgeImportBills = new TradeFinanceImportBillsLodgePage(driver);
		lodgeImportBills.sendKeysSearchBarTextField(data.getMenu())
									   .switchFormAreaFrame()
									   .sendKeysBillType(data.getBillType());
									   
									   
		if(data.getUnderDocumentaryCredit().equals("no"))
		{
			lodgeImportBills.PressunderDocumentryCreditNoRadioButton();
		}							   
		else {
			lodgeImportBills.PressunderDocumentryCreditYesRadioButton()
			.sendKeysDocumentCreditNum(data.getDocumentryCreditNo());
			

		}
									   
									   lodgeImportBills.sendKeysCif(data.getCifId())
									   .sendKeysBillCcy(data.getBillCcy())
									   .PressGoButton()
									   .sendKeysOperativeAcId(data.getOperativeAccountId())
									   .sendKeysBillAmount(data.getBillAmt())
									   .sendKeysBillCountry(data.getBillCountry())
									   .sendKeysOtherBankRefNum(data.getBankRef())
									   .PressGeneralDetailsContinueButton()
									   .sendKeysName(data.getName())
									   .sendKeysAdress1(data.getAddress1())
									   .PressPartyDetailsContinueButton();
									   
									   
									   if(data.getType().equals(FinacleFieldsUtils.BILLTYPESIGHT))
									   {
										   lodgeImportBills.PressEditButton()
										   .sendKeysOnboardDate(data.getOnboardDate())
										   .sendKeysBillDate(data.getBillDate())
										   .PressUpdateButton();
									   }
									   else if(data.getType().equals(FinacleFieldsUtils.BILLTYPEUSANCE))
									   {
										   lodgeImportBills.PressEditButton()
										   .sendKeysTenor(data.getMonth(), data.getDay())
										   .sendKeysOnboardDate(data.getOnboardDate())
										   .sendKeysBillDate(data.getBillDate())
										   .PressUpdateButton();
									   }
									   else if(data.getType().equals(FinacleFieldsUtils.tradeFinanceBillType3))
									   {
										   lodgeImportBills.PressTenorAddButton()
										   .addBill1Tenor(data.getBill1Amount(), data.getBillType(), data.getOnboardDate(), data.getBillDate())
										   .addBill2Tenor(data.getBill2Amount(), data.getBillType(), data.getMonth(), data.getDay(), data.getOnboardDate(), data.getBillDate());
									   }
									   
									 
									   lodgeImportBills.PressTenorDetailsContinueButton()
									   .sendKeysinvoiceAmtTextField(data.getInvoiceAmt());
									   
									   if(data.getRateCode() != null) {
										   lodgeImportBills.sendKeysRate(data.getRateCode());
										   }
									   
									   lodgeImportBills.PressSideTabs()
									  
									   .PressSubmitButton()
									   .saveAccountId(data.getLinkedTcid(), data.getAcceptLinkedTcid(), data.getVerifyAcceptLinkedTcid(), data.getRealizeLinkedTcid(), data.getVerifyRealizeLinkedTcid());
									   
							
		}
}
