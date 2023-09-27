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
import data.ABE_OpenTUA_TUA_Data;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABE_OpenTUA_TUA_Procedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test( groups = "open")
@Listeners({AllureTestNg.class})
public class ABE_OpenTUA_TUA_Test {
	
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.OpenTUACsv, "reference");
		CSVUtils.clearColumnByName(Paths.VerifyTUAOpeningCsv, "accountId");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABE_OpenTUA_TUA_Data data = (ABE_OpenTUA_TUA_Data) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open TUA DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.OpenTUACsv);
		workbook.save(Paths.OpenTUAJson);
        Class<ABE_OpenTUA_TUA_Data> targetClass = ABE_OpenTUA_TUA_Data.class;
        JsonReader<ABE_OpenTUA_TUA_Data> jsonReader = new JsonReader<>(targetClass);
        List<ABE_OpenTUA_TUA_Data> dataList = jsonReader.readJsonFile(Paths.OpenTUAJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open TUA DataProvider", dataProviderClass = ABE_OpenTUA_TUA_Test.class)
	public void openTUA(ABE_OpenTUA_TUA_Data data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
        ABE_OpenTUA_TUA_Procedures.openTUA(driver, data);
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