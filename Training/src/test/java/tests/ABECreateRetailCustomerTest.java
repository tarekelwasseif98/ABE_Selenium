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
import data.ABECreateRetailCustomerData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageobjects.FinacleLoginPage;
import procedures.ABECreateRetailCustomerProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test( groups = "ABECreateRetailCustomerTest")
@Listeners({AllureTestNg.class})

public class ABECreateRetailCustomerTest {

	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABECREATERETAILCUSTOMERCSV, "cif");
	}

	WebDriver driver = null;
	private String testCaseId;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECreateRetailCustomerData data = (ABECreateRetailCustomerData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		testCaseId = CSVUtils.getTestCaseId(Paths.ABECREATERETAILCUSTOMERCSV);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Create Retail Customer DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECREATERETAILCUSTOMERCSV);
		workbook.save(Paths.ABECREATERETAILCUSTOMERJSON);
        Class<ABECreateRetailCustomerData> targetClass = ABECreateRetailCustomerData.class;
        JsonReader<ABECreateRetailCustomerData> jsonReader = new JsonReader<>(targetClass);
        List<ABECreateRetailCustomerData> dataList = jsonReader.readJsonFile(Paths.ABECREATERETAILCUSTOMERJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Create Retail Customer DataProvider", dataProviderClass = ABECreateRetailCustomerTest.class)
	@Step("{testCaseId}")
	public void CreateAchOutward(ABECreateRetailCustomerData data) throws Exception {
//		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + testCaseId));
		Allure.parameter("Data: ", data.toString());		
		ABECreateRetailCustomerProcedures.CreateRetailCustomer(driver, data);
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
