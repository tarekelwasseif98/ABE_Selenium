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
import utils.CSVUtils;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "verify",dependsOnGroups = "open")
@Listeners({AllureTestNg.class})
public class ABE_VerifyIslamicCurrentAccount_MudarabahCAA {

	WebDriver driver = null;
	private String testCaseId;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		VerifyIslamicCurrentAccountData data = (VerifyIslamicCurrentAccountData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		testCaseId = CSVUtils.getTestCaseId(Paths.VerifyIslamicCurrentAccountCsv);

		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Islamic Current Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.VerifyIslamicCurrentAccountCsv);
		workbook.save(Paths.VerifyIslamicCurrentAccountJson);
        Class<VerifyIslamicCurrentAccountData> targetClass = VerifyIslamicCurrentAccountData.class;
        JsonReader<VerifyIslamicCurrentAccountData> jsonReader = new JsonReader<>(targetClass);
        List<VerifyIslamicCurrentAccountData> dataList = jsonReader.readJsonFile(Paths.VerifyIslamicCurrentAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Islamic Current Account DataProvider", dataProviderClass = ABE_VerifyIslamicCurrentAccount_MudarabahCAA.class)
	public void verifyIslamicCurrentAccountTest(VerifyIslamicCurrentAccountData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + testCaseId));
		Allure.parameter("Data: ", data.toString());
		VerifyIslamicCurrentAccountProcedures.islamicCurrentAccountByChecker(driver, data);
		AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
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