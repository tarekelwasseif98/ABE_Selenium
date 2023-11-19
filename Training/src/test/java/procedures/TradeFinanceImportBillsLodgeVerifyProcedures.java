package procedures;

import org.openqa.selenium.WebDriver;

import data.TradeFinanceImportBillsLodgeVerifyData;
import pageobjects.TradeFinanceImportBillsLodgeVerifyPage;


public class TradeFinanceImportBillsLodgeVerifyProcedures {
	public static void TradeFinanceImportBillsVerifyLodge(WebDriver driver, TradeFinanceImportBillsLodgeVerifyData data) throws Exception {
		TradeFinanceImportBillsLodgeVerifyPage lodgeImportBills = new TradeFinanceImportBillsLodgeVerifyPage(driver);
		lodgeImportBills.sendKeysSearchBarTextField(data.getMenu())
									   .switchFormAreaFrame()
									   .sendKeysBillId(data.getBillId())
									   .pressGoButton()
									   .pressSideTab1()
									   .pressSideTab2()
									   .pressTenorDetailsViewButton1()
									   .pressTenorDetailsCloseButton()
									   .pressTenorDetailsViewButton2()
									   .pressTenorDetailsCloseButton()
									   .pressSideTab3()
									   .pressSideTab4()
									   .pressSideTab5()
									   .pressSideTab6()
									   .pressSideTab7()
									   .pressSubmitButton()
									   .saveBillId(data.getAcceptLinkedTcid(),data.getVerifyAcceptLinkedTcid(), data.getRealizeLinkedTcid(), data.getVerifyRealizeLinkedTcid());
	}

}
