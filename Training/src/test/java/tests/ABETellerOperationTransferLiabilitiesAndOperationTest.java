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
import data.ABETellerOperationTransferLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABETellerOperationTransferLiabilitiesAndOperationProcedures;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
@Test( groups = "TellerTransfer")

@Listeners({AllureTestNg.class})
public class ABETellerOperationTransferLiabilitiesAndOperationTest {
	
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV, "reference");

	}
	

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABETellerOperationTransferLiabilitiesAndOperationData data = (ABETellerOperationTransferLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="teller Transfer DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONCSV);
		workbook.save(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONJSON);
        Class<ABETellerOperationTransferLiabilitiesAndOperationData> targetClass = ABETellerOperationTransferLiabilitiesAndOperationData.class;
        JsonReader<ABETellerOperationTransferLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABETellerOperationTransferLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABETELLEROPERATIONTRANSFERLIABILITIESANDOPERATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "teller Transfer DataProvider", dataProviderClass = ABETellerOperationTransferLiabilitiesAndOperationTest.class)
	public void ABE_tellerTransfer(ABETellerOperationTransferLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABETellerOperationTransferLiabilitiesAndOperationProcedures.tellerTransferByMaker(driver, data);
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
