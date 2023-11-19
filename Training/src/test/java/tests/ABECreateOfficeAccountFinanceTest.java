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
import data.ABECreateOfficeAccountFinanceData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABECreateOfficeAccountFinanceProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test( groups = "OpenOfficeAccount")
@Listeners({AllureTestNg.class})
public class ABECreateOfficeAccountFinanceTest {
			 
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABECREATEOFFICEACCOUNTFINANCECSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYOFFICEACCOUNTFINANCECSV, "accountId");

	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECreateOfficeAccountFinanceData data = (ABECreateOfficeAccountFinanceData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}

	@DataProvider(name="Open Office Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECREATEOFFICEACCOUNTFINANCECSV);
		workbook.save(Paths.ABECREATEOFFICEACCOUNTFINANCEJSON);
        Class<ABECreateOfficeAccountFinanceData> targetClass = ABECreateOfficeAccountFinanceData.class;
        JsonReader<ABECreateOfficeAccountFinanceData> jsonReader = new JsonReader<>(targetClass);
        List<ABECreateOfficeAccountFinanceData> dataList = jsonReader.readJsonFile(Paths.ABECREATEOFFICEACCOUNTFINANCEJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Office Account DataProvider", dataProviderClass = ABECreateOfficeAccountFinanceTest.class)
	public void ABE_OpenOfficeAccount(ABECreateOfficeAccountFinanceData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		
		Allure.parameter("Data: ", data.toString());		
        ABECreateOfficeAccountFinanceProcedures.OfficeAccountByMaker(driver, data);
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