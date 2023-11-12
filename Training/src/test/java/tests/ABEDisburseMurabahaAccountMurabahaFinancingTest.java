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
import data.ABEDisburseMurabahaAccountMurabahaFinancingData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEDisburseMurabahaAccountMurabahaFinancingProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEDisburseMurabahaAccountMurabahaFinancingTest")
@Listeners({AllureTestNg.class})
public class ABEDisburseMurabahaAccountMurabahaFinancingTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEDisburseMurabahaAccountMurabahaFinancingData data = (ABEDisburseMurabahaAccountMurabahaFinancingData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Disburse Murabaha Account Murabaha Financing DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEDISBURSEMURABAHAACCOUNTMURABAHAFINANCINGCSV);
		workbook.save(Paths.ABEDISBURSEMURABAHAACCOUNTMURABAHAFINANCINGJSON);
        Class<ABEDisburseMurabahaAccountMurabahaFinancingData> targetClass = ABEDisburseMurabahaAccountMurabahaFinancingData.class;
        JsonReader<ABEDisburseMurabahaAccountMurabahaFinancingData> jsonReader = new JsonReader<>(targetClass);
        List<ABEDisburseMurabahaAccountMurabahaFinancingData> dataList = jsonReader.readJsonFile(Paths.ABEDISBURSEMURABAHAACCOUNTMURABAHAFINANCINGJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Disburse Murabaha Account Murabaha Financing DataProvider", dataProviderClass = ABEDisburseMurabahaAccountMurabahaFinancingTest.class)
	public void disburseMurabahaAccountMurabahaFinancingTest(ABEDisburseMurabahaAccountMurabahaFinancingData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
        ABEDisburseMurabahaAccountMurabahaFinancingProcedures.disburseMurabahaAccountMurabahaFinancing(driver, data);
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