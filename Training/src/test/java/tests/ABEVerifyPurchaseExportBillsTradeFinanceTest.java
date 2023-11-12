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
import data.ABEVerifyPurchaseExportBillsTradeFinanceData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyExportBillsTradeFinanceProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import io.qameta.allure.testng.AllureTestNg;
@Test(groups = "ABEVerifyPurchaseExportBillsTradeFinanceTest", dependsOnGroups = "ABEPurchaseExportBillsTradeFinanceTest")
@Listeners({AllureTestNg.class})
public class ABEVerifyPurchaseExportBillsTradeFinanceTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyPurchaseExportBillsTradeFinanceData data = (ABEVerifyPurchaseExportBillsTradeFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Purchase Export Bills Trade Finance DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYPURCHASEEXPORTBILLSTRADEFINANCECSV);
		workbook.save(Paths.ABEVERIFYPURCHASEEXPORTBILLSTRADEFINANCEJSON);
        Class<ABEVerifyPurchaseExportBillsTradeFinanceData> targetClass = ABEVerifyPurchaseExportBillsTradeFinanceData.class;
        JsonReader<ABEVerifyPurchaseExportBillsTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyPurchaseExportBillsTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYPURCHASEEXPORTBILLSTRADEFINANCEJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Purchase Export Bills Trade Finance DataProvider", dataProviderClass = ABEVerifyPurchaseExportBillsTradeFinanceTest.class)
	public void verifyPurchaseExportBillsTradeFinanceTest(ABEVerifyPurchaseExportBillsTradeFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());
        ABEVerifyExportBillsTradeFinanceProcedures.verifyPurchaseExportBillsTradeFinance(driver, data);
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