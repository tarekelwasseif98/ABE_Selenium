package procedures;
import org.openqa.selenium.WebDriver;
import data.ABECreateTdLiabilitiesAndOperationData;
import pageobjects.ABECreateTdLiabilitiesAndOperationPage;

public class ABECreateTdLiabilitiesAndOperationProcedures {

	public static void CreateTdByMaker(WebDriver driver, ABECreateTdLiabilitiesAndOperationData data) throws Exception {
		ABECreateTdLiabilitiesAndOperationPage OpenTdPage = new ABECreateTdLiabilitiesAndOperationPage(driver);
		OpenTdPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
									  .SelectFunctionCodeDropDown()
									  .sendKeysCif(data.getCif())
									  .sendKeysSchemeCode(data.getSchemeCode())
									  .sendKeysCcy(data.getCcy())
									  .PressGoButton()
									  .sendKeysInitialDepositAmmount(data.getInitialDepositAmmount())
									  .sendKeysDebitAcId(data.getDebitAcId())
									  .selectRenewalType();
									String  f1= OpenTdPage.getMonthPeriodValue();
									String f2= OpenTdPage.getDayPeriodValue();

									
		if(f1.equals("MMM")  && f2.equals("DDD") ||f1.equals("0")  && f2.equals("0") || f1.equals(null)  && f2.equals(null)) {
									  
		OpenTdPage.sendKeysTdPeriod(data.getMonthlyPeriod(), data.getDailyPeriod())
									  .pressSubmitButton();
		}else
		{
			OpenTdPage.pressSubmitButton();
		}
		
		OpenTdPage.saveTd(data.getLinkedTcid());

		}
}
