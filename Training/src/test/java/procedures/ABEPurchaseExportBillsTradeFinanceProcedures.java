package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEPurchaseExportBillsTradeFinanceData;
import pageobjects.ABEPurchaseExportBillsTradeFinancePage;
import utils.FinacleFieldsUtils;

public class ABEPurchaseExportBillsTradeFinanceProcedures {
	public static void purchaseExportBillsTradeFinance(WebDriver driver, ABEPurchaseExportBillsTradeFinanceData data) throws Exception {
		ABEPurchaseExportBillsTradeFinancePage purchaseExportBillsTradeFinancePage = new ABEPurchaseExportBillsTradeFinancePage(driver);
		if(data.getMixedBillId1() != null && data.getMixedBillId2() != null) {
			purchaseExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
												.switchFormAreaFrame()
												 .sendKeysBillIdTextField(data.getBillId())
												  .sendKeysTenorBillIdTextField(data.getMixedBillId1())
												   .pressGoButton()
												    .navigateLimitDetailsSideTabMenu()
												     .sendKeysLimitIdTextField(data.getMixedBill1LimitIdPrefix(), data.getMixedBill1LimitIdSuffix())
												      .pressContinue1Button()
												       .sendKeysBillPurchaseAccountIdTextField(data.getMixedBill1PurchaseAccountId())
												        .sendKeysBillPurchaseAmountTextField(data.getMixedBill1PurchaseAmount())
												         .sendKeysValueDateTextField(data.getMixedBill1ValueDate())
												          .navigateEventDetailsSideTabMenu()
											               .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											                .navigateTransactionDetailsSideTabMenu()
											                 .pressSubmitButton()
												              .pressRepeatTaskButton()
															   .sendKeysBillIdTextField(data.getBillId())
																.sendKeysTenorBillIdTextField(data.getMixedBillId2())
																 .pressGoButton()
																  .navigateLimitDetailsSideTabMenu()
																   .sendKeysLimitIdTextField(data.getMixedBill2LimitIdPrefix(), data.getMixedBill2LimitIdSuffix())
																	.pressContinue1Button()
																	 .sendKeysBillPurchaseAccountIdTextField(data.getMixedBill2PurchaseAccountId())
																	  .sendKeysBillPurchaseAmountTextField(data.getMixedBill2PurchaseAmount())
																	   .sendKeysValueDateTextField(data.getMixedBill2ValueDate())
																	    .navigateEventDetailsSideTabMenu()
															             .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
															              .navigateTransactionDetailsSideTabMenu()
															               .pressSubmitButton();
			}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() == null) {
			purchaseExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											    .switchFormAreaFrame()
											     .sendKeysBillIdTextField(data.getBillId())
											      .sendKeysTenorBillIdTextField(data.getMixedBillId1())
											       .pressGoButton()
											        .navigateLimitDetailsSideTabMenu()
											         .sendKeysLimitIdTextField(data.getMixedBill1LimitIdPrefix(), data.getMixedBill1LimitIdSuffix())
											          .pressContinue1Button()
											           .sendKeysBillPurchaseAccountIdTextField(data.getMixedBill1PurchaseAccountId())
											            .sendKeysBillPurchaseAmountTextField(data.getMixedBill1PurchaseAmount())
											             .sendKeysValueDateTextField(data.getMixedBill1ValueDate())
											              .navigateEventDetailsSideTabMenu()
											               .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											                .navigateTransactionDetailsSideTabMenu()
											                 .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() != null) {
			purchaseExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											    .switchFormAreaFrame()
											     .sendKeysBillIdTextField(data.getBillId())
											      .sendKeysTenorBillIdTextField(data.getMixedBillId2())
											       .pressGoButton()
											        .navigateLimitDetailsSideTabMenu()
											         .sendKeysLimitIdTextField(data.getMixedBill2LimitIdPrefix(), data.getMixedBill2LimitIdSuffix())
											          .pressContinue1Button()
											           .sendKeysBillPurchaseAccountIdTextField(data.getMixedBill2PurchaseAccountId())
											            .sendKeysBillPurchaseAmountTextField(data.getMixedBill2PurchaseAmount())
											             .sendKeysValueDateTextField(data.getMixedBill2ValueDate())
											              .navigateEventDetailsSideTabMenu()
											               .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											                .navigateTransactionDetailsSideTabMenu()
											                 .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() == null) {
			purchaseExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											    .switchFormAreaFrame()
											     .sendKeysBillIdTextField(data.getBillId())
											      .pressGoButton()
											       .navigateLimitDetailsSideTabMenu()
											        .sendKeysLimitIdTextField(data.getLimitIdPrefix(), data.getLimitIdSuffix())
											         .pressContinue1Button()
											          .sendKeysBillPurchaseAccountIdTextField(data.getBillPurchaseAccountId())
											           .sendKeysBillPurchaseAmountTextField(data.getBillPurchaseAmount())
											            .sendKeysValueDateTextField(data.getValueDate())
											             .navigateEventDetailsSideTabMenu()
											              .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											               .navigateTransactionDetailsSideTabMenu()
											                .pressSubmitButton();
			}
		}
	}