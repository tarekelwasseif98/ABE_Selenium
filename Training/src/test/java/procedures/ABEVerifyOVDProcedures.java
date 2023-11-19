package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyOVDData;
import pageobjects.ABEVerifyOVDPage;

public class ABEVerifyOVDProcedures {
	public static void overDraftAccountByChecker(WebDriver driver, ABEVerifyOVDData data) throws Exception {
		ABEVerifyOVDPage VerifyOverDraftAccountPage = new ABEVerifyOVDPage(driver);
		VerifyOverDraftAccountPage.sendKeysSearchBarTextField(data.getMenu())
										 .switchFormAreaFrame()
										 .sendKeysAccountIdTextField(data.getAccountid())
										 .pressGoButton()
		                                 .pressAdditionalContinueButton()
		                                 .pressGeneralContinueButton()
		                                 .pressSignatureContinueButton()
		                                 .pressAccountContinueButton()
		                                 .pressInterestContinueButton()
		                                 .pressSchemeContinueButton()
		                                 .pressRevolvingContinueButton()
		                                 .pressRelatedContinueButton()
		                                 .pressCollateralContinueButton()
										 .pressDocumentContinueButton()
										 .pressTaxContinueButton()
										 .pressExceptionContinueButton()
										 .pressBankContinueButton()
										 .pressFlexiContinueButton()
										 .pressPaymentContinueButton()
										 .pressChargeContinueButton()
										 .pressBaseContinueButton()
										 .pressMissContinueButton()								
										 .pressSubmitButton();
		}
}
