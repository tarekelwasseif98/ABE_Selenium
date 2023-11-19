package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEAcceptExportBillsTradeFinanceData;
import pageobjects.ABEAcceptExportBillsTradeFinancePage;
import utils.FinacleFieldsUtils;

public class ABEAcceptExportBillsTradeFinanceProcedures {
	public static void acceptExportBillsTradeFinance(WebDriver driver, ABEAcceptExportBillsTradeFinanceData data) throws Exception {
		ABEAcceptExportBillsTradeFinancePage acceptExportBillsTradeFinancePage = new ABEAcceptExportBillsTradeFinancePage(driver);
		if(data.getMixedBillId1() != null && data.getMixedBillId2() != null) {
			acceptExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
			  								  .switchFormAreaFrame()
			  								   .sendKeysBillIdTextField(data.getBillId())
			  								    .sendKeysTenorBillIdTextField(data.getMixedBillId1())
			  								     .pressGoButton()
			  								      .navigateGeneralDetailsSideTabMenu()
			  								       .pressContinue1Button()
											        .pressContinue2Button()
											         .pressTenorDetailsEditButton1()
											          .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
											           .pressTenorDetailsUpdateButton()
											            .navigateEventDetailsSideTabMenu()
											             .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											              .navigateTransactionDetailsSideTabMenu()
											               .pressSubmitButton()
											                .pressRepeatTaskButton()
												             .sendKeysBillIdTextField(data.getBillId())
												              .sendKeysTenorBillIdTextField(data.getMixedBillId2())
												               .pressGoButton()
												            	.navigateGeneralDetailsSideTabMenu()
												            	 .pressContinue1Button()
												            	  .pressContinue2Button()
												            	   .pressTenorDetailsEditButton2()
												            		.sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
												            		 .pressTenorDetailsUpdateButton()
												            		  .navigateEventDetailsSideTabMenu()
														               .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
														                .navigateTransactionDetailsSideTabMenu()
														                 .pressSubmitButton();
			}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() == null) {
			acceptExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId1())
											     .pressGoButton()
											      .navigateGeneralDetailsSideTabMenu()
											       .pressContinue1Button()
											        .pressContinue2Button()
											         .pressTenorDetailsEditButton1()
											          .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
											           .pressTenorDetailsUpdateButton()
											            .navigateEventDetailsSideTabMenu()
										                 .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
										                  .navigateTransactionDetailsSideTabMenu()
										                   .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() != null) {
			acceptExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
			  								  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .sendKeysTenorBillIdTextField(data.getMixedBillId2())
											     .pressGoButton()
											      .navigateGeneralDetailsSideTabMenu()
											       .pressContinue1Button()
											        .pressContinue2Button()
											         .pressTenorDetailsEditButton2()
											          .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
											           .pressTenorDetailsUpdateButton()
											            .navigateEventDetailsSideTabMenu()
										                 .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
										                  .navigateTransactionDetailsSideTabMenu()
										                   .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() == null) {
			acceptExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
			  								  .switchFormAreaFrame()
											   .sendKeysBillIdTextField(data.getBillId())
											    .pressGoButton()
											     .navigateGeneralDetailsSideTabMenu()
											      .pressContinue1Button()
											       .pressContinue2Button()
											        .pressTenorDetailsEditButton1()
											         .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
											          .pressTenorDetailsUpdateButton()
											           .navigateEventDetailsSideTabMenu()
										                .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
										                 .navigateTransactionDetailsSideTabMenu()
										                  .pressSubmitButton();
			}
		}
	}