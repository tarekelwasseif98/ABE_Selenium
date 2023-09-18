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
import data.VerifyIslamicSavingsAccountData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.VerifyIslamicSavingsAccountProcedures;
import utils.CSVUtils;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "verify",dependsOnGroups = "open")
@Listeners({AllureTestNg.class})
public class ABE_VerifyIslamicSavingsAccount_MudarabahSBA {

	WebDriver driver = null;
	private String testCaseId;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		VerifyIslamicSavingsAccountData data = (VerifyIslamicSavingsAccountData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		testCaseId = CSVUtils.getTestCaseId(Paths.VerifyIslamicSavingsAccountCsv);

		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Islamic Savings Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.VerifyIslamicSavingsAccountCsv);
		workbook.save(Paths.VerifyIslamicSavingsAccountJson);
        Class<VerifyIslamicSavingsAccountData> targetClass = VerifyIslamicSavingsAccountData.class;
        JsonReader<VerifyIslamicSavingsAccountData> jsonReader = new JsonReader<>(targetClass);
        List<VerifyIslamicSavingsAccountData> dataList = jsonReader.readJsonFile(Paths.VerifyIslamicSavingsAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Islamic Savings Account DataProvider", dataProviderClass = ABE_VerifyIslamicSavingsAccount_MudarabahSBA.class)
	public void verifyIslamicSavingsAccountTest(VerifyIslamicSavingsAccountData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + testCaseId));
		Allure.parameter("TCID: ", data.getTCID());
		Allure.parameter("Summary: ", data.getSummary());
		Allure.parameter("Username: ", data.getUsername());
		Allure.parameter("Menu: ", data.getMenu());
		Allure.parameter("Account ID: ", data.getAccountid());
		Allure.parameter("Expected Result: ", data.getExpectedResult());
		
		VerifyIslamicSavingsAccountProcedures.islamicSavingsAccountByChecker(driver, data);
	}

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