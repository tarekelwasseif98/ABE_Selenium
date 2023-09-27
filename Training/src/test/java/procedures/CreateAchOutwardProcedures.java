package procedures;

import org.openqa.selenium.WebDriver;
import data.CreateAchOutwardData;
import pageobjects.CreateAchOutwardPage;

public class CreateAchOutwardProcedures {

	public static void AchOutwardByMaker(WebDriver driver, CreateAchOutwardData data) throws Exception {
		CreateAchOutwardPage CreateAchOutwardPage = new CreateAchOutwardPage(driver);
		CreateAchOutwardPage.sendKeysSearchBarTextField(data.getMenu())
									  .switchFormAreaFrame()
		                                .sendKeysPaymentType(data.getPaysysID())
		                                .pressSubmitButton()
		                                .sendKeysAchOutwardPayment(data.getAccount(), data.getCCY(), data.getAmount(), data.getDate(), data.getLine1(), data.getAccount_ben(), data.getName_ben(),  data.getBic_ben(), data.getNetwork_ben(), data.getBank_ben(), data.getBranch_ben())
		                                .savePO(data.getLinkedTcid());
	}
	
}
