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
import data.ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyMurabahaAccountDisbursementMurabahaFinancingProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEVerifyMurabahaAccountDisbursementMurabahaFinancingTest", dependsOnGroups = "ABEDisburseMurabahaAccountMurabahaFinancingTest")
@Listeners({AllureTestNg.class})
public class ABEVerifyMurabahaAccountDisbursementMurabahaFinancingTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData data = (ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Murabaha Account Disbursement Murabaha Financing DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYMURABAHAACCOUNTDISBURSEMENTMURABAHAFINANCINGCSV);
		workbook.save(Paths.ABEVERIFYMURABAHAACCOUNTDISBURSEMENTMURABAHAFINANCINGJSON);
        Class<ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData> targetClass = ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData.class;
        JsonReader<ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYMURABAHAACCOUNTDISBURSEMENTMURABAHAFINANCINGJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Murabaha Account Disbursement Murabaha Financing DataProvider", dataProviderClass = ABEVerifyMurabahaAccountDisbursementMurabahaFinancingTest.class)
	public void verifyMurabahaAccountDisbursementMurabahaFinancingTest(ABEVerifyMurabahaAccountDisbursementMurabahaFinancingData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
        ABEVerifyMurabahaAccountDisbursementMurabahaFinancingProcedures.verifyMurabahaAccountDisbursementMurabahaFinancing(driver, data);
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