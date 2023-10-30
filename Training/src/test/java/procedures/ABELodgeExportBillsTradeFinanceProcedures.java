package procedures;

import org.openqa.selenium.WebDriver;
import data.ABELodgeExportBillsTradeFinanceData;
import pageobjects.ABELodgeExportBillsTradeFinancePage;

public class ABELodgeExportBillsTradeFinanceProcedures {
	public static void lodgeExportBillsTradeFinance(WebDriver driver, ABELodgeExportBillsTradeFinanceData data) throws Exception {
		ABELodgeExportBillsTradeFinancePage lodgeExportBillsTradeFinancePage = new ABELodgeExportBillsTradeFinancePage(driver);
		lodgeExportBillsTradeFinancePage.sendKeysSearchBarTextField(data.getMenu())
				    					    .switchFormAreaFrame();			    							                    
		}
	}