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
		                                .pressSubmitButton();
	}
	
}
