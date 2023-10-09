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
import data.ABECreateCASASavingsAccountLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABECreateCASASavingsAccountLiabilitiesAndOperationProcedures;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test( groups = "OpenCasaSavingsAc")
@Listeners({AllureTestNg.class})
public class ABECreateCASASavingsAccountLiabilitiesAndOperationTest {

	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABECreateCASASavingsAccountLiabilitiesAndOperationCsv, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationCsv, "accountId");

	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECreateCASASavingsAccountLiabilitiesAndOperationData data = (ABECreateCASASavingsAccountLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Create CASA Savings Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECreateCASASavingsAccountLiabilitiesAndOperationCsv);
		workbook.save(Paths.ABECreateCASASavingsAccountLiabilitiesAndOperationJson);
        Class<ABECreateCASASavingsAccountLiabilitiesAndOperationData> targetClass = ABECreateCASASavingsAccountLiabilitiesAndOperationData.class;
        JsonReader<ABECreateCASASavingsAccountLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABECreateCASASavingsAccountLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABECreateCASASavingsAccountLiabilitiesAndOperationJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Create CASA Savings Account DataProvider", dataProviderClass = ABECreateCASASavingsAccountLiabilitiesAndOperationTest.class)
	public void ABE_OpenSavingsAccount(ABECreateCASASavingsAccountLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABECreateCASASavingsAccountLiabilitiesAndOperationProcedures.Casa_CreateSavingsAccountByMaker(driver, data);

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
