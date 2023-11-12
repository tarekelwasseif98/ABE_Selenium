package procedures;

import org.openqa.selenium.WebDriver;
import data.ABEPurchaseExportBillsTradeFinanceData;
import pageobjects.ABEPurchaseExportBillsTradeFinancePage;

public class ABEPurchaseExportBillsTradeFinanceProcedures {
	public static void purchaseExportBillsTradeFinance(WebDriver driver, ABEPurchaseExportBillsTradeFinanceData data) throws Exception {
		ABEPurchaseExportBillsTradeFinancePage purchaseExportBillsTradeFinancePage = new ABEPurchaseExportBillsTradeFinancePage(driver);
		if(data.getMixedBillId1() != null && data.getMixedBillId2() != null) {
			
		}
		else if(data.getMixedBillId1() != null && data.getMixedBillId2() == null) {
			
		}
		else if(data.getMixedBillId1() == null && data.getMixedBillId2() != null) {
			
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
											                        .pressSubmitButton();
			}
		}
	}