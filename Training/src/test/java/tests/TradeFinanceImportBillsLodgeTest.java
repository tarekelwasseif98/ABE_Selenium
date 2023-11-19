package tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import com.opencsv.exceptions.CsvException;
import data.JsonReader;
import data.TradeFinanceImportBillsLodgeData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.TradeFinanceImportBillsLodgeProcedures;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test(groups = "TradeFinanceImportBillsLodgeTest")

public class TradeFinanceImportBillsLodgeTest {


	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, "billId");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, "billId");
	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		TradeFinanceImportBillsLodgeData data = (TradeFinanceImportBillsLodgeData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Create Trade Finance DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABETRADEFINANCEIMPORTBILLSLODGECSV);
		workbook.save(Paths.ABEETRADEFINANCEIMPORTBILLSLODGEJSON);
        Class<TradeFinanceImportBillsLodgeData> targetClass = TradeFinanceImportBillsLodgeData.class;
        JsonReader<TradeFinanceImportBillsLodgeData> jsonReader = new JsonReader<>(targetClass);
        List<TradeFinanceImportBillsLodgeData> dataList = jsonReader.readJsonFile(Paths.ABEETRADEFINANCEIMPORTBILLSLODGEJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Create Trade Finance DataProvider", dataProviderClass = TradeFinanceImportBillsLodgeTest.class)
	public void ABE_Lodge(TradeFinanceImportBillsLodgeData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		TradeFinanceImportBillsLodgeProcedures.TradeFinanceImportBillsLodge(driver, data);
        AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}
	
	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) throws InterruptedException {
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
        }
		 if (result.getStatus() == ITestResult.FAILURE) {
	            ScreenshotHelper.captureScreenshot(driver);
	        }
		Thread.sleep(2000);
		driver.quit();
	}
}
