package procedures;
import org.openqa.selenium.WebDriver;
import data.ABECreateOfficeAccountFinanceData;
import pageobjects.ABECreateOfficeAccountFinancePage;


public class ABECreateOfficeAccountFinanceProcedures {
	
	public static void OfficeAccountByMaker(WebDriver driver, ABECreateOfficeAccountFinanceData data) throws Exception {
		ABECreateOfficeAccountFinancePage OpenOfficeAccountPage = new ABECreateOfficeAccountFinancePage(driver);
		OpenOfficeAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeysAccoundType(data.getSchemeCode(), data.getGeneralLedgerSubhead(), data.getCcy())
									  .sendKeysOfficeAccoundDetails(data.getAccountHeadName(), data.getEodMaxBalance())
									  .saveAccountId(data.getLinkedTcId());
									
		}

}
