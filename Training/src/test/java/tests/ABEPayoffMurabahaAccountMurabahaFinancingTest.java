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
import data.ABEPayoffMurabahaAccountMurabahaFinancingData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEPayoffMurabahaAccountMurabahaFinancingProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEPayoffMurabahaAccountMurabahaFinancingTest")
@Listeners({AllureTestNg.class})
public class ABEPayoffMurabahaAccountMurabahaFinancingTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEPayoffMurabahaAccountMurabahaFinancingData data = (ABEPayoffMurabahaAccountMurabahaFinancingData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Payoff Murabaha Account Murabaha Financing DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEPAYOFFMURABAHAACCOUNTMURABAHAFINANCINGCSV);
		workbook.save(Paths.ABEPAYOFFMURABAHAACCOUNTMURABAHAFINANCINGJSON);
        Class<ABEPayoffMurabahaAccountMurabahaFinancingData> targetClass = ABEPayoffMurabahaAccountMurabahaFinancingData.class;
        JsonReader<ABEPayoffMurabahaAccountMurabahaFinancingData> jsonReader = new JsonReader<>(targetClass);
        List<ABEPayoffMurabahaAccountMurabahaFinancingData> dataList = jsonReader.readJsonFile(Paths.ABEPAYOFFMURABAHAACCOUNTMURABAHAFINANCINGJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Payoff Murabaha Account Murabaha Financing DataProvider", dataProviderClass = ABEPayoffMurabahaAccountMurabahaFinancingTest.class)
	public void payoffMurabahaAccountMurabahaFinancingTest(ABEPayoffMurabahaAccountMurabahaFinancingData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
        ABEPayoffMurabahaAccountMurabahaFinancingProcedures.payoffMurabahaAccountMurabahaFinancing(driver, data);
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