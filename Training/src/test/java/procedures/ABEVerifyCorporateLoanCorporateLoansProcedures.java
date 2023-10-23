package procedures;

import org.openqa.selenium.WebDriver;

import data.ABEVerifyCorporateLoanCorporateLoansData;
import pageobjects.ABEVerifyCorporateLoanCorporateLoansPage;

public class ABEVerifyCorporateLoanCorporateLoansProcedures {
	
	public static void verifyCorporateLoanCorporateLoans(WebDriver driver, ABEVerifyCorporateLoanCorporateLoansData data) throws Exception {
		ABEVerifyCorporateLoanCorporateLoansPage verifyCorporateLoanCorporateLoansPage = new ABEVerifyCorporateLoanCorporateLoansPage(driver);
		verifyCorporateLoanCorporateLoansPage.sendKeysSearchBarTextField(data.getMenu())
								.switchFormAreaFrame()
								 .sendKeysAccountIdTextField(data.getAccountid())
								  .pressGoButton()
								   .pressContinue1Button()
								    .pressContinue2Button()
								     .pressContinue3Button()
								      .pressContinue4Button()
								       .pressContinue5Button()
								        .pressContinue6Button()
								         .pressContinue7Button()
								          .pressContinue8Button()
								           .pressContinue9Button()
								            .pressContinue10Button()
								             .pressContinue11Button()
								              .pressContinue12Button()
								               .pressContinue13Button()
								                .pressContinue14Button()
								                 .pressSubmitButton();
		}
	}