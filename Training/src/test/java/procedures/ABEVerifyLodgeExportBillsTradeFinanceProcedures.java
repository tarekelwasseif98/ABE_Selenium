package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEVerifyLodgeExportBillsTradeFinanceData;
import pageobjects.ABEVerifyLodgeExportBillsTradeFinancePage;

public class ABEVerifyLodgeExportBillsTradeFinanceProcedures {
	public static void verifyLodgeExportBillsTradeFinance(WebDriver driver, ABEVerifyLodgeExportBillsTradeFinanceData data) throws Exception {
		ABEVerifyLodgeExportBillsTradeFinancePage verifyLodgeExportBillsTradeFinancePage = new ABEVerifyLodgeExportBillsTradeFinancePage(driver);
		verifyLodgeExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
				    					       .switchFormAreaFrame()
				    					        .sendKeysBillIdTextField(data.getBillId())
				    					         .pressGoButton()
				    					          .pressContinue1Button()
				    					           .pressContinue2Button()
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
	}