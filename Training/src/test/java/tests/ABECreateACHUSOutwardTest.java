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
import data.ABECreateOutwardTransferPaymentData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageobjects.FinacleLoginPage;
import procedures.ABECreateOutwardTransferPaymentProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test( groups = "CreateACHUS")
@Listeners({AllureTestNg.class})

public class ABECreateACHUSOutwardTest {

	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABECREATEACHUSOUTWARDCSV, "Pos");
	}

	WebDriver driver = null;
	private String testCaseId;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECreateOutwardTransferPaymentData data = (ABECreateOutwardTransferPaymentData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		testCaseId = CSVUtils.getTestCaseId(Paths.ABECREATEACHUSOUTWARDCSV);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Create ACHUS Outwrad DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECREATEACHUSOUTWARDCSV);
		workbook.save(Paths.ABECREATEACHUSOUTWARDJSON);
        Class<ABECreateOutwardTransferPaymentData> targetClass = ABECreateOutwardTransferPaymentData.class;
        JsonReader<ABECreateOutwardTransferPaymentData> jsonReader = new JsonReader<>(targetClass);
        List<ABECreateOutwardTransferPaymentData> dataList = jsonReader.readJsonFile(Paths.ABECREATEACHUSOUTWARDJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Create ACHUS Outwrad DataProvider", dataProviderClass = ABECreateACHUSOutwardTest.class)
	@Step("{testCaseId}")
	public void CreateAchOutward(ABECreateOutwardTransferPaymentData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + testCaseId));
		Allure.parameter("Data: ", data.toString());		
		ABECreateOutwardTransferPaymentProcedures.AchOutwardByMaker(driver, data);
//        AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
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
		PageFunctionUtils.sleep();
		driver.quit();
	}
	
}
