/*
 * package procedures;
 * 
 * import org.openqa.selenium.WebDriver; import
 * data.OpenIslamicCurrentAccountData; import
 * pageobjects.OpenIslamicCurrentAccountPage;
 * 
 * public class OpenIslamicCurrentAccountProcedures { public static void
 * islamicCurrentAccountByMaker(WebDriver driver, OpenIslamicCurrentAccountData
 * data) throws Exception { OpenIslamicCurrentAccountPage
 * OpenIslamicCurrentAccountPage = new OpenIslamicCurrentAccountPage(driver);
 * OpenIslamicCurrentAccountPage.sendKeysSearchBarTextField(data.getMenu())
 * .switchFormAreaFrame() .sendKeysAccoundId(data.getCif(),
 * data.getSchemeCode(), data.getGeneralLedgerSubheadCode())
 * .pressSubmitButton() .saveAccountId(data.getLinkedTCID()); } }
 */