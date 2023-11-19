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
import data.ABEVerifyMurabahaAccountOpeningMurabahaFinancingData;
import data.ABEVerifyOfficeAccountFinanceData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyMurabahaAccountOpeningMurabahaFinancingProcedures;
import procedures.ABEVerifyOfficeAccountFinanceProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "verifyOfficeAccount", dependsOnGroups = "OpenOfficeAccount", alwaysRun = true)
@Listeners({AllureTestNg.class})
public class ABEVerifyOfficeAccountFinanceTest {
	 

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyOfficeAccountFinanceData data = (ABEVerifyOfficeAccountFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Office Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYOFFICEACCOUNTFINANCECSV);
		workbook.save(Paths.ABEVERIFYOFFICEACCOUNTFINANCEJSON);
        Class<ABEVerifyOfficeAccountFinanceData> targetClass = ABEVerifyOfficeAccountFinanceData.class;
        JsonReader<ABEVerifyOfficeAccountFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyOfficeAccountFinanceData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYOFFICEACCOUNTFINANCEJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Office Account DataProvider", dataProviderClass = ABEVerifyOfficeAccountFinanceTest.class)
	@Step("{testCaseId}")
	public void ABE_VerifyOfficeAccount(ABEVerifyOfficeAccountFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyOfficeAccountFinanceProcedures.OfficeAccountByChecker(driver, data);
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