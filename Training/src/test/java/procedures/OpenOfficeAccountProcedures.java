package procedures;
import org.openqa.selenium.WebDriver;
import data.ABE_Create_OfficeAccount_Finance_Data;
import pageobjects.ABE_Create_OfficeAccount_Finance_Page;


public class OpenOfficeAccountProcedures {
	
	public static void OfficeAccountByMaker(WebDriver driver, ABE_Create_OfficeAccount_Finance_Data data) throws Exception {
		ABE_Create_OfficeAccount_Finance_Page OpenOfficeAccountPage = new ABE_Create_OfficeAccount_Finance_Page(driver);
		OpenOfficeAccountPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .sendKeysAccoundType(data.getSchemeCode(), data.getGeneralLedgerSubhead())
									  .sendKeysOfficeAccoundDetails(data.getAccountHeadName(), data.getEodMaxBalance())
									  .saveAccountId(data.getLinkedTcId());
									
		}

}
