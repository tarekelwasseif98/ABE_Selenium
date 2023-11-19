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
	import data.ABEVerifyOutwardLGTradeFinanceData;

import io.qameta.allure.Allure;
	import io.qameta.allure.Attachment;
	import io.qameta.allure.Step;
	import pageobjects.FinacleLoginPage;
	
import procedures.ABEVerifyOutwardLGTradeFinanceProcedures;
import utils.Properties;
	import utils.ScreenshotHelper;
	import utils.WebdriverFactory;
	import utils.Paths;
	import utils.AssertionFactory;
	import utils.CSVUtils;
	import io.qameta.allure.testng.AllureTestNg;

	@Test(groups = "verify",dependsOnGroups = "open")
	@Listeners({AllureTestNg.class})
	
public class ABEVerifyOutwardLGTradeFinanceTest { 
		
		WebDriver driver = null;
		@BeforeMethod(description= "Initiating Browser")
		public void beforeTest(Object [] testData) throws Exception {
			ABEVerifyOutwardLGTradeFinanceData data = (ABEVerifyOutwardLGTradeFinanceData) testData[0];
			driver = WebdriverFactory.initiateWebDriver();
			driver.get(Properties.FINACLEURL);
			FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
			FinacleLoginPage
			.sendKeysUserNameTextField(data.getUsername())
			.sendKeysPasswordTextField(data.getPassword())
			.clickOnLoginButton(data.getPassword());
		}
		
		@DataProvider(name="Verify outward LG trade finance DataProvider")
		public Object[] dpMethod() throws Exception {
	    	Workbook workbook = new Workbook(Paths.VERIFYOUTWARDLGTRADEFINANCECSV);
			workbook.save(Paths.VERIFYOUTWARDLGTRADEFINANCEJSON);
	        Class<ABEVerifyOutwardLGTradeFinanceData> targetClass = ABEVerifyOutwardLGTradeFinanceData.class;
	        JsonReader<ABEVerifyOutwardLGTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
	        List<ABEVerifyOutwardLGTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.VERIFYOUTWARDLGTRADEFINANCEJSON);
	        dataList.toArray();
	        return dataList.toArray();
		}
		
		@Test(dataProvider = "Verify outward LG trade finance DataProvider", dataProviderClass = ABEVerifyOutwardLGTradeFinanceTest.class)
		@Step("{testCaseId}")
		public void verifyOutwardLGTradeFinance(ABEVerifyOutwardLGTradeFinanceData data) throws Exception {
			//Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
			Allure.parameter("Data: ", data.toString());		
			ABEVerifyOutwardLGTradeFinanceProcedures.outwardLGTradeFinanceByChecker(driver, data);
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
