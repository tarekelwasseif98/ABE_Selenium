package procedures;
import org.openqa.selenium.WebDriver;
import data.OpenOfficeAccountData;
import pageobjects.OpenOfficeAccountPage;


public class OpenOfficeAccountProcedures {
	
	public static void OfficeAccountByMaker(WebDriver driver, OpenOfficeAccountData data) throws Exception {
		OpenOfficeAccountPage OpenOfficeAccountPage = new OpenOfficeAccountPage(driver);
		OpenOfficeAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeysAccoundType(data.getSchemeCode(), data.getGeneralLedgerSubhead())
									  .sendKeysOfficeAccoundDetails(data.getAccountHeadName(), data.getEodMaxBalance())
									  .saveAccountId(data.getLinkedTcId());
									
		}

}
