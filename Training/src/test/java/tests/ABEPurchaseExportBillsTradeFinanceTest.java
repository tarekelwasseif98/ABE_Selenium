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
import data.ABEPurchaseExportBillsTradeFinanceData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEPurchaseExportBillsTradeFinanceProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEPurchaseExportBillsTradeFinanceTest")
@Listeners({AllureTestNg.class})
public class ABEPurchaseExportBillsTradeFinanceTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEPurchaseExportBillsTradeFinanceData data = (ABEPurchaseExportBillsTradeFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Purchase Export Bills Trade Finance DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEPURCHASEEXPORTBILLSTRADEFINANCECSV);
		workbook.save(Paths.ABEPURCHASEEXPORTBILLSTRADEFINANCEJSON);
        Class<ABEPurchaseExportBillsTradeFinanceData> targetClass = ABEPurchaseExportBillsTradeFinanceData.class;
        JsonReader<ABEPurchaseExportBillsTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABEPurchaseExportBillsTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.ABEPURCHASEEXPORTBILLSTRADEFINANCEJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Purchase Export Bills Trade Finance DataProvider", dataProviderClass = ABEPurchaseExportBillsTradeFinanceTest.class)
	public void purchaseExportBillsTradeFinanceTest(ABEPurchaseExportBillsTradeFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());
        ABEPurchaseExportBillsTradeFinanceProcedures.purchaseExportBillsTradeFinance(driver, data);
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