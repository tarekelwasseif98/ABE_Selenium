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
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyMurabahaAccountOpeningMurabahaFinancingProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "ABEVerifyMurabahaAccountOpeningMurabahaFinancingTest", dependsOnGroups = "ABEOpenMurabahaAccountMurabahaFinancingTest")
@Listeners({AllureTestNg.class})
public class ABEVerifyMurabahaAccountOpeningMurabahaFinancingTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyMurabahaAccountOpeningMurabahaFinancingData data = (ABEVerifyMurabahaAccountOpeningMurabahaFinancingData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Murabaha Account Opening Murabaha Financing DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYMURABAHAACCOUNTOPENINGMURABAHAFINANCINGCSV);
		workbook.save(Paths.ABEVERIFYMURABAHAACCOUNTOPENINGMURABAHAFINANCINGJSON);
        Class<ABEVerifyMurabahaAccountOpeningMurabahaFinancingData> targetClass = ABEVerifyMurabahaAccountOpeningMurabahaFinancingData.class;
        JsonReader<ABEVerifyMurabahaAccountOpeningMurabahaFinancingData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyMurabahaAccountOpeningMurabahaFinancingData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYMURABAHAACCOUNTOPENINGMURABAHAFINANCINGJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Murabaha Account Opening Murabaha Financing DataProvider", dataProviderClass = ABEVerifyMurabahaAccountOpeningMurabahaFinancingTest.class)
	public void verifyMurabahaAccountOpeningMurabahaFinancingTest(ABEVerifyMurabahaAccountOpeningMurabahaFinancingData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		ABEVerifyMurabahaAccountOpeningMurabahaFinancingProcedures.verifyMurabahaAccountOpeningMurabahaFinancing(driver, data);
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