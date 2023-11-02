package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEAcceptExportBillsTradeFinanceData;
import pageobjects.ABEAcceptExportBillsTradeFinancePage;

public class ABEAcceptExportBillsTradeFinanceProcedures {
	public static void acceptExportBillsTradeFinance(WebDriver driver, ABEAcceptExportBillsTradeFinanceData data) throws Exception {
		ABEAcceptExportBillsTradeFinancePage acceptExportBillsTradeFinancePage = new ABEAcceptExportBillsTradeFinancePage(driver);
		acceptExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
				    					  .switchFormAreaFrame()
				    					   .sendKeysBillIdTextField(data.getBillId())
				    					    .pressGoButton()
				    					     .navigateGeneralDetailsSideTabMenu()
				    					      .pressContinue1Button()
				    					       .pressContinue2Button()
				    					        .pressTenorDetailsEditButton()
				    					         .sendKeysAcceptanceDateTextField(data.getAcceptanceDate())
				    					          .pressTenorDetailsUpdateButton()
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
				    					                         .pressSubmitButton()
				    					                          .saveBillId(data.getLinkedTcid());
		}
	}