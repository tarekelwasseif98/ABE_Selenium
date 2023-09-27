package tests;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import data.JsonReader;
import data.VerifyIslamicCurrentAccountData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.VerifyIslamicCurrentAccountProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "verify",dependsOnGroups = "open")
@Listeners({AllureTestNg.class})
public class ABE_VerifyIslamicCurrentAccount_MudarabahCAA_Test {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		VerifyIslamicCurrentAccountData data = (VerifyIslamicCurrentAccountData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	/*
	 * @DataProvider(name="Verify Islamic Current Account DataProvider") public
	 * Object[] dpMethod() throws Exception { Workbook workbook = new
	 * Workbook(Paths.VerifyIslamicCurrentAccountCsv);
	 * workbook.save(Paths.VerifyIslamicCurrentAccountJson);
	 * Class<VerifyIslamicCurrentAccountData> targetClass =
	 * VerifyIslamicCurrentAccountData.class;
	 * JsonReader<VerifyIslamicCurrentAccountData> jsonReader = new
	 * JsonReader<>(targetClass); List<VerifyIslamicCurrentAccountData> dataList =
	 * jsonReader.readJsonFile(Paths.VerifyIslamicCurrentAccountJson);
	 * dataList.toArray(); return dataList.toArray(); }
	 * 
	 * <<<<<<< HEAD:Training/src/test/java/tests/
	 * ABE_VerifyIslamicSavingsAccount_MudarabahSBA.java
	 * 
	 * @Test(dataProvider = "Verify Islamic Savings Account DataProvider",
	 * dataProviderClass = ABE_VerifyIslamicSavingsAccount_MudarabahSBA.class)
	 * public void verifyIslamicSavingsAccountTest(VerifyIslamicSavingsAccountData
	 * data) throws Exception { //Allure.getLifecycle().updateTestCase(tc ->
	 * tc.setName("Test Case ID: " + testCaseId)); Allure.parameter("TCID: ",
	 * data.getTCID()); Allure.parameter("Summary: ", data.getSummary());
	 * Allure.parameter("Username: ", data.getUsername());
	 * Allure.parameter("Menu: ", data.getMenu()); Allure.parameter("Account ID: ",
	 * data.getAccountid()); Allure.parameter("Expected Result: ",
	 * data.getExpectedResult());
	 * 
	 * VerifyIslamicSavingsAccountProcedures.islamicSavingsAccountByChecker(driver,
	 * data); =======
	 * 
	 * @Test(dataProvider = "Verify Islamic Current Account DataProvider",
	 * dataProviderClass = ABE_VerifyIslamicCurrentAccount_MudarabahCAA_Test.class)
	 * public void verifyIslamicCurrentAccountTest(VerifyIslamicCurrentAccountData
	 * data) throws Exception { Allure.getLifecycle().updateTestCase(tc ->
	 * tc.setName("Test Case ID: " + data.getTCID())); Allure.parameter("Data: ",
	 * data.toString());
	 * VerifyIslamicCurrentAccountProcedures.islamicCurrentAccountByChecker(driver,
	 * data); AssertionFactory.checkExpectedResult(driver,
	 * data.getExpectedResult()); >>>>>>>
	 * f326dc4bab08ab0450dc67107b6d076bdf5d2e19:Training/src/test/java/tests/
	 * ABE_VerifyIslamicCurrentAccount_MudarabahCAA_Test.java }
	 */

	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) throws InterruptedException {
		Thread.sleep(1000);
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
            }
		 if (result.getStatus() == ITestResult.FAILURE) {
			 ScreenshotHelper.captureScreenshot(driver);
			 }
		driver.quit();
	}
}