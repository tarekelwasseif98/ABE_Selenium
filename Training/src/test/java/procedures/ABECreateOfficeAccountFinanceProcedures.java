package procedures;
import org.openqa.selenium.WebDriver;
import pageobjects.ABECreateOfficeAccountFinancePage;
import data.ABECreateOfficeAccountFinanceData;


public class ABECreateOfficeAccountFinanceProcedures {
	
	public static void OfficeAccountByMaker(WebDriver driver, ABECreateOfficeAccountFinanceData data) throws Exception {
		ABECreateOfficeAccountFinancePage OpenOfficeAccountPage = new ABECreateOfficeAccountFinancePage(driver);
		OpenOfficeAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeysGlSubHeadCode(data.getGeneralLedgerSubhead())
									  .sendKeysSchemeCode(data.getSchemeCode())
									  .sendKeysCcy(data.getCcy())
									  .pressGoButton()
									  .sendKeysAccountHeadName(data.getAccountHeadName())
									  .sendKeysEODMaxBalance(data.getEodMaxBalance())
									  .pressSubmitButton()
									  .saveAccountId(data.getLinkedTcId());
									
		}

}
