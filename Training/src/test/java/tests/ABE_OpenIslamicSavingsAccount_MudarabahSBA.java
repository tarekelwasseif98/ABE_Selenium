package tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import com.opencsv.exceptions.CsvException;
import data.JsonReader;
import data.OpenIslamicSavingsAccountData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageobjects.FinacleLoginPage;
import procedures.OpenIslamicSavingsAccountProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test( groups = "open")
@Listeners({AllureTestNg.class})
public class ABE_OpenIslamicSavingsAccount_MudarabahSBA {
	
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.OpenIslamicSavingsAccountCsv, "reference");
		CSVUtils.clearColumnByName(Paths.VerifyIslamicSavingsAccountCsv, "accountId");
	}

	WebDriver driver = null;
	private String testCaseId;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		OpenIslamicSavingsAccountData data = (OpenIslamicSavingsAccountData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		testCaseId = CSVUtils.getTestCaseId(Paths.OpenIslamicSavingsAccountCsv);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Islamic Savings Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.OpenIslamicSavingsAccountCsv);
		workbook.save(Paths.OpenIslamicSavingsAccountJson);
        Class<OpenIslamicSavingsAccountData> targetClass = OpenIslamicSavingsAccountData.class;
        JsonReader<OpenIslamicSavingsAccountData> jsonReader = new JsonReader<>(targetClass);
        List<OpenIslamicSavingsAccountData> dataList = jsonReader.readJsonFile(Paths.OpenIslamicSavingsAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Islamic Savings Account DataProvider", dataProviderClass = ABE_OpenIslamicSavingsAccount_MudarabahSBA.class)
	@Step("{testCaseId}")
	public void openIslamicSavingsAccount(OpenIslamicSavingsAccountData data) throws Exception {
//		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + testCaseId));
		Allure.parameter("Data: ", data.toString());		
        OpenIslamicSavingsAccountProcedures.islamicSavingsAccountByMaker(driver, data);
        AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}

	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
        }
		 if (result.getStatus() == ITestResult.FAILURE) {
	            ScreenshotHelper.captureScreenshot(driver);
	        }
		driver.quit();
	}
}