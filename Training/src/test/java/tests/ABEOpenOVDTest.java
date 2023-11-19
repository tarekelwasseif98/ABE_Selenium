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
import data.ABEOpenOVDData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pageobjects.FinacleLoginPage;
import procedures.ABEOpenOVDProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test( groups = "open")
@Listeners({AllureTestNg.class})

public class ABEOpenOVDTest {
	
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.OPENOVERDRAFTACCOUNTCSV, "reference");
		CSVUtils.clearColumnByName(Paths.MODIFYOVERDRAFTACCOUNTBEFOREVERIFICATIONCSV, "modifyAccountId");
		CSVUtils.clearColumnByName(Paths.VERIFYOVERDRAFTACCOUNTCSV, "accountId");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEOpenOVDData data = (ABEOpenOVDData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Over Draft Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.OPENOVERDRAFTACCOUNTCSV);
		workbook.save(Paths.OPENOVERDRAFTACCOUNTJSON);
        Class<ABEOpenOVDData> targetClass = ABEOpenOVDData.class;
        JsonReader<ABEOpenOVDData> jsonReader = new JsonReader<>(targetClass);
        List<ABEOpenOVDData> dataList = jsonReader.readJsonFile(Paths.OPENOVERDRAFTACCOUNTJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Over Draft Account DataProvider", dataProviderClass = ABEOpenOVDTest.class)
	@Step("{testCaseId}")
	public void openOverDraftAccount(ABEOpenOVDData data) throws Exception {
		//Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());		
        ABEOpenOVDProcedures.overDraftAccountByMaker(driver, data);
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