package procedures;

import org.openqa.selenium.WebDriver;
import data.ABERealizeExportBillsTradeFinanceData;
import pageobjects.ABERealizeExportBillsTradeFinancePage;
import utils.FinacleFieldsUtils;

public class ABERealizeExportBillsTradeFinanceProcedures {
	public static void realizeExportBillsTradeFinance(WebDriver driver, ABERealizeExportBillsTradeFinanceData data) throws Exception {
		ABERealizeExportBillsTradeFinancePage realizeExportBillsTradeFinancePage = new ABERealizeExportBillsTradeFinancePage(driver);
		if(data.getMixedBillId1() != null && data.getMixedBillId2() != null) {
			realizeExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
												.switchFormAreaFrame()
												 .sendKeysBillIdTextField(data.getBillId())
												  .sendKeysTenorBillIdTextField(data.getMixedBillId1())
												   .pressGoButton()
											        .sendKeysRealizationAccountIdTextField(data.getMixedBill1RealizationAccountId())
											         .sendKeysBillRealizationAmountTextField(data.getMixedBill1RealizationAmount())
											          .sendKeysValueDateTextField(data.getMixedBill1RealizationValueDate())
											           .pressContinue1Button()
											            .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											             .pressContinue2Button()
											              .pressContinue3Button()
											               .pressSubmitButton()
												            .pressRepeatTaskButton()
															 .sendKeysBillIdTextField(data.getBillId())
															  .sendKeysTenorBillIdTextField(data.getMixedBillId2())
														       .pressGoButton()
															    .sendKeysRealizationAccountIdTextField(data.getMixedBill2RealizationAccountId())
																 .sendKeysBillRealizationAmountTextField(data.getMixedBill2RealizationAmount())
																  .sendKeysValueDateTextField(data.getMixedBill2RealizationValueDate())
																   .pressContinue1Button()
																	.sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
																	 .pressContinue2Button()
																	  .pressContinue3Button()
																	   .pressSubmitButton();
			}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() == null) {
			realizeExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											    .switchFormAreaFrame()
											     .sendKeysBillIdTextField(data.getBillId())
											      .sendKeysTenorBillIdTextField(data.getMixedBillId1())
											       .pressGoButton()
											        .sendKeysRealizationAccountIdTextField(data.getMixedBill1RealizationAccountId())
											         .sendKeysBillRealizationAmountTextField(data.getMixedBill1RealizationAmount())
											          .sendKeysValueDateTextField(data.getMixedBill1RealizationValueDate())
											           .pressContinue1Button()
											            .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											             .pressContinue2Button()
											              .pressContinue3Button()
											               .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() != null) {
			realizeExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											    .switchFormAreaFrame()
											     .sendKeysBillIdTextField(data.getBillId())
											      .sendKeysTenorBillIdTextField(data.getMixedBillId2())
											       .pressGoButton()
											        .sendKeysRealizationAccountIdTextField(data.getMixedBill2RealizationAccountId())
											         .sendKeysBillRealizationAmountTextField(data.getMixedBill2RealizationAmount())
											          .sendKeysValueDateTextField(data.getMixedBill2RealizationValueDate())
											           .pressContinue1Button()
											            .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											             .pressContinue2Button()
											              .pressContinue3Button()
											               .pressSubmitButton();
			}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() == null) {
			realizeExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
											    .switchFormAreaFrame()
											     .sendKeysBillIdTextField(data.getBillId())
											      .pressGoButton()
											       .sendKeysRealizationAccountIdTextField(data.getRealizationAccountId())
											        .sendKeysBillRealizationAmountTextField(data.getBillRealizationAmount())
											         .sendKeysValueDateTextField(data.getRealizationValueDate())
											          .pressContinue1Button()
											           .sendKeysPaySysIdTextField(FinacleFieldsUtils.PAYSYSIDSWIFT)
											            .pressContinue2Button()
											             .pressContinue3Button()
											              .pressSubmitButton();
			}
		}
	}