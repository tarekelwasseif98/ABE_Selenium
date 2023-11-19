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
import data.ABECreateTdLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABECreateTdLiabilitiesAndOperationProcedures;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test( groups = "OpenTd")
@Listeners({AllureTestNg.class})
public class ABECreateTdLiabilitiesAndOperationTest {

	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABECREATETDLIABILITIESANDOPERATIONCSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYTDLIABILITIESANDOPERATIONCSV, "accountId");

	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECreateTdLiabilitiesAndOperationData data = (ABECreateTdLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Create Td DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECREATETDLIABILITIESANDOPERATIONCSV);
		workbook.save(Paths.ABECREATETDLIABILITIESANDOPERATIONJSON);
        Class<ABECreateTdLiabilitiesAndOperationData> targetClass = ABECreateTdLiabilitiesAndOperationData.class;
        JsonReader<ABECreateTdLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABECreateTdLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABECREATETDLIABILITIESANDOPERATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Create Td DataProvider", dataProviderClass = ABECreateTdLiabilitiesAndOperationTest.class)
	public void ABECreateTd(ABECreateTdLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		
		Allure.parameter("Data: ", data.toString());		
		ABECreateTdLiabilitiesAndOperationProcedures.CreateTdByMaker(driver, data);
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
		driver.quit();
	}

	
}
