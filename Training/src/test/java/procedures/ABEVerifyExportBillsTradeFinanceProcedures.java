package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyAcceptExportBillsTradeFinanceData;
import data.ABEVerifyLodgeExportBillsTradeFinanceData;
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
				    					            .pressContinue3Button()
				    					             .pressContinue4Button()
				    					              .pressContinue5Button()
				    					               .pressContinue6Button()
				    					                .pressContinue7Button()
				    					                 .pressContinue8Button()
				    					                  .pressContinue9Button()
				    					                   .pressContinue10Button()
				    					                    .pressContinue11Button()
				    					                     .pressContinue12Button()
				    					                      .pressContinue13Button()
				    					                       .pressContinue14Button()
				    					                        .pressContinue15Button()
				    					                         .pressContinue16Button()
				    					                          .pressSubmitButton();
		}
	
	public static void verifyAcceptExportBillsTradeFinance(WebDriver driver, ABEVerifyAcceptExportBillsTradeFinanceData data) throws Exception {
		ABEVerifyExportBillsTradeFinancePage verifyExportBillsTradeFinancePage = new ABEVerifyExportBillsTradeFinancePage(driver);
		verifyExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
				    					       .switchFormAreaFrame()
				    					        .sendKeysBillIdTextField(data.getBillId())
				    					         .pressGoButton()
				    					          .pressContinue3Button()
				    					           .pressContinue4Button()
				    					            .pressContinue5Button()
				    					             .pressContinue7Button()
				    					              .pressContinue17Button()
				    					               .pressContinue8Button()
				    					                .pressContinue9Button()
				    					                 .pressContinue11Button()
				    					                  .pressContinue12Button()
				    					                   .pressContinue13Button()
				    					                    .pressContinue14Button()
				    					                     .pressContinue15Button()
				    					                      .pressContinue18Button()
				    					                       .pressContinue16Button()
				    					                        .pressSubmitButton();
		}
	}