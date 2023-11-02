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
import data.ABELodgeExportBillsTradeFinanceData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABELodgeExportBillsTradeFinanceProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABELodgeExportBillsTradeFinanceTest")
@Listeners({AllureTestNg.class})
public class ABELodgeExportBillsTradeFinanceTest {
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.LodgeExportBillsCsv, "reference");
		CSVUtils.clearColumnByName(Paths.VerifyLodgeExportBillsCsv, "billId");
		CSVUtils.clearColumnByName(Paths.AcceptExportBillsCsv, "billId");
		CSVUtils.clearColumnByName(Paths.AcceptExportBillsCsv, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.AcceptExportBillsCsv, "mixedBillId2");
		CSVUtils.clearColumnByName(Paths.VerifyAcceptExportBillsCsv, "billId");
		CSVUtils.clearColumnByName(Paths.VerifyAcceptExportBillsCsv, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.VerifyAcceptExportBillsCsv, "mixedBillId2");
		CSVUtils.clearColumnByName(Paths.PurchaseExportBillsCsv, "billId");
		CSVUtils.clearColumnByName(Paths.PurchaseExportBillsCsv, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.PurchaseExportBillsCsv, "mixedBillId2");
		CSVUtils.clearColumnByName(Paths.VerifyPurchaseExportBillsCsv, "billId");
		CSVUtils.clearColumnByName(Paths.VerifyPurchaseExportBillsCsv, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.VerifyPurchaseExportBillsCsv, "mixedBillId2");
		CSVUtils.clearColumnByName(Paths.RealizeExportBillsCsv, "billId");
		CSVUtils.clearColumnByName(Paths.RealizeExportBillsCsv, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.RealizeExportBillsCsv, "mixedBillId2");
		CSVUtils.clearColumnByName(Paths.VerifyRealizeExportBillsCsv, "billId");
		CSVUtils.clearColumnByName(Paths.VerifyRealizeExportBillsCsv, "mixedBillId1");
		CSVUtils.clearColumnByName(Paths.VerifyRealizeExportBillsCsv, "mixedBillId2");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABELodgeExportBillsTradeFinanceData data = (ABELodgeExportBillsTradeFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Lodge Export Bills Trade Finance DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.LodgeExportBillsCsv);
		workbook.save(Paths.LodgeExportBillsJson);
        Class<ABELodgeExportBillsTradeFinanceData> targetClass = ABELodgeExportBillsTradeFinanceData.class;
        JsonReader<ABELodgeExportBillsTradeFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABELodgeExportBillsTradeFinanceData> dataList = jsonReader.readJsonFile(Paths.LodgeExportBillsJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Lodge Export Bills Trade Finance DataProvider", dataProviderClass = ABELodgeExportBillsTradeFinanceTest.class)
	public void lodgeExportBillsTradeFinanceTest(ABELodgeExportBillsTradeFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());
        ABELodgeExportBillsTradeFinanceProcedures.lodgeExportBillsTradeFinance(driver, data);
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