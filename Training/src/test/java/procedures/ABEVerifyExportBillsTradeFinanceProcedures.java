package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyAcceptExportBillsTradeFinanceData;
import data.ABEVerifyLodgeExportBillsTradeFinanceData;
import data.ABEVerifyPurchaseExportBillsTradeFinanceData;
import data.ABEVerifyRealizeExportBillsTradeFinanceData;
import pageobjects.ABEVerifyExportBillsTradeFinancePage;

public class ABEVerifyExportBillsTradeFinanceProcedures {
	public static void verifyLodgeExportBillsTradeFinance(WebDriver driver, ABEVerifyLodgeExportBillsTradeFinanceData data) throws Exception {
		ABEVerifyExportBillsTradeFinancePage verifyExportBillsTradeFinancePage = new ABEVerifyExportBillsTradeFinancePage(driver);
		verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
				    					  .switchFormAreaFrame()
				    					   .sendKeysBillIdTextField(data.getBillId())
				    					    .pressGoButton()
				    					     .pressContinue1Button()
				    					      .pressContinue2Button()
				    					       .pressTenorDetailsViewButton1()
				    					        .pressTenorDetailsCloseButton()
				    					         .pressTenorDetailsViewButton2()
				    					          .pressTenorDetailsCloseButton()
				    					           .navigateEventDetailsSideTabMenu()
				    					            .pressContinue8Button()
				    					             .navigateTransactionDetailsSideTabMenu()
				    					              .pressSubmitButton()
				    					               .saveBillId(data.getAcceptLinkedTcid(), data.getVerifyAcceptLinkedTcid(), data.getPurchaseLinkedTcid(), data.getVerifyPurchaseLinkedTcid(), data.getRealizeLinkedTcid(), data.getVerifyRealizeLinkedTcid());
		}
	
	public static void verifyAcceptExportBillsTradeFinance(WebDriver driver, ABEVerifyAcceptExportBillsTradeFinanceData data) throws Exception {
		ABEVerifyExportBillsTradeFinancePage verifyExportBillsTradeFinancePage = new ABEVerifyExportBillsTradeFinancePage(driver);
		if(data.getMixedBillId1() != null && data.getMixedBillId2() != null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
					    					  .switchFormAreaFrame()
					    					   .sendKeysBillIdTextField(data.getBillId())
					    					    .sendKeysTenorBillIdTextField(data.getMixedBillId1())
					    					     .pressGoButton()
					    					      .navigateEventDetailsSideTabMenu()
					    					       .navigateTransactionDetailsSideTabMenu()
					    					        .pressSubmitButton()
					    					         .pressRepeatTaskButton()
													  .sendKeysBillIdTextField(data.getBillId())
													   .sendKeysTenorBillIdTextField(data.getMixedBillId2())
													    .pressGoButton()
													     .navigateEventDetailsSideTabMenu()
													      .navigateTransactionDetailsSideTabMenu()
													       .pressSubmitButton();
			}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() == null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId1())
											     .pressGoButton()
											      .navigateEventDetailsSideTabMenu()
											       .navigateTransactionDetailsSideTabMenu()
											        .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() != null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId2())
											     .pressGoButton()
											      .navigateEventDetailsSideTabMenu()
											       .navigateTransactionDetailsSideTabMenu()
											        .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() == null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .pressGoButton()
											     .navigateEventDetailsSideTabMenu()
											      .navigateTransactionDetailsSideTabMenu()
											       .pressSubmitButton();
			}
		}
	public static void verifyPurchaseExportBillsTradeFinance(WebDriver driver, ABEVerifyPurchaseExportBillsTradeFinanceData data) throws Exception {
		ABEVerifyExportBillsTradeFinancePage verifyExportBillsTradeFinancePage = new ABEVerifyExportBillsTradeFinancePage(driver);
		if(data.getMixedBillId1() != null && data.getMixedBillId2() != null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId1())
											     .pressGoButton()
											      .navigateLimitDetailsSideTabMenu()
											       .navigateEventDetailsSideTabMenu()
											        .navigateTransactionDetailsSideTabMenu()
											         .pressSubmitButton()
											          .pressRepeatTaskButton()
											           .sendKeysBillIdTextField(data.getBillId())
												        .sendKeysTenorBillIdTextField(data.getMixedBillId2())
												         .pressGoButton()
												          .navigateLimitDetailsSideTabMenu()
													       .navigateEventDetailsSideTabMenu()
													        .navigateTransactionDetailsSideTabMenu()
													         .pressSubmitButton();
			}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() == null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId1())
											     .pressGoButton()
											      .navigateLimitDetailsSideTabMenu()
											       .navigateEventDetailsSideTabMenu()
											        .navigateTransactionDetailsSideTabMenu()
											         .pressSubmitButton();
			
		}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() != null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId2())
											     .pressGoButton()
											      .navigateLimitDetailsSideTabMenu()
											       .navigateEventDetailsSideTabMenu()
											        .navigateTransactionDetailsSideTabMenu()
											         .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() == null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
					    					   .sendKeysBillIdTextField(data.getBillId())
					    					    .pressGoButton()
					    					     .navigateLimitDetailsSideTabMenu()
											      .navigateEventDetailsSideTabMenu()
											       .navigateTransactionDetailsSideTabMenu()
											        .pressSubmitButton();
			}
		}
	public static void verifyRealizeExportBillsTradeFinance(WebDriver driver, ABEVerifyRealizeExportBillsTradeFinanceData data) throws Exception {
		ABEVerifyExportBillsTradeFinancePage verifyExportBillsTradeFinancePage = new ABEVerifyExportBillsTradeFinancePage(driver);
		if(data.getMixedBillId1() != null && data.getMixedBillId2() != null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId1())
											     .pressGoButton()
											      .navigateEventDetailsSideTabMenu()
											       .navigateChargeDetailsSideTabMenu()
											        .navigateTransactionDetailsSideTabMenu()
					    					         .pressSubmitButton()
											          .pressRepeatTaskButton()
											           .sendKeysBillIdTextField(data.getBillId())
												        .sendKeysTenorBillIdTextField(data.getMixedBillId2())
												         .pressGoButton()
												          .navigateEventDetailsSideTabMenu()
													       .navigateChargeDetailsSideTabMenu()
													        .navigateTransactionDetailsSideTabMenu()
							    					         .pressSubmitButton();
			}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() == null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId1())
											     .pressGoButton()
											      .navigateEventDetailsSideTabMenu()
											       .navigateChargeDetailsSideTabMenu()
											        .navigateTransactionDetailsSideTabMenu()
					    					         .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() != null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId2())
											     .pressGoButton()
											      .navigateEventDetailsSideTabMenu()
											       .navigateChargeDetailsSideTabMenu()
											        .navigateTransactionDetailsSideTabMenu()
					    					         .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() == null) {
			verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
					    					   .sendKeysBillIdTextField(data.getBillId())
					    					    .pressGoButton()
					    					     .navigateEventDetailsSideTabMenu()
											      .navigateChargeDetailsSideTabMenu()
											       .navigateTransactionDetailsSideTabMenu()
					    					        .pressSubmitButton();
			}
		}
	}