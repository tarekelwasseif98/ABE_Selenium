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
import data.ABECreateCASACurrentAccountLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABECreateCASACurrentAccountLiabilitiesAndOperationProcedures;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
//
@Test( groups = "OpenCasaCurrentAc")
@Listeners({AllureTestNg.class})
public class ABECreateCASACurrentAccountLiabilitiesAndOperationTest {

	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABECREATECASACURRENTACCOUNTLIABILITIESANDOPERATIONCSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYCASACURRENTACCOUNTCREATIONLIABILITIESANDOPERATIONCSV, "accountId");

	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECreateCASACurrentAccountLiabilitiesAndOperationData data = (ABECreateCASACurrentAccountLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Create CASA Current Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECREATECASACURRENTACCOUNTLIABILITIESANDOPERATIONCSV);
		workbook.save(Paths.ABECREATECASACURRENTACCOUNTLIABILITIESANDOPERATIONJSON);
        Class<ABECreateCASACurrentAccountLiabilitiesAndOperationData> targetClass = ABECreateCASACurrentAccountLiabilitiesAndOperationData.class;
        JsonReader<ABECreateCASACurrentAccountLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABECreateCASACurrentAccountLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABECREATECASACURRENTACCOUNTLIABILITIESANDOPERATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Create CASA Current Account DataProvider", dataProviderClass = ABECreateCASACurrentAccountLiabilitiesAndOperationTest.class)
	public void ABE_OpenCurrentAccount(ABECreateCASACurrentAccountLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABECreateCASACurrentAccountLiabilitiesAndOperationProcedures.Casa_CreateCurrentAccountByMaker(driver, data);
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
