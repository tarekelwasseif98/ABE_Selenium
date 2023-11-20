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
import data.ABEOpenMudarabahTUAData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEOpenMudarabahTUAProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEOpenMudarabahTUATest")
@Listeners({AllureTestNg.class})
public class ABEOpenMudarabahTUATest {
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABEOPENMUDARABAHTUACSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYMUDARABAHTUAOPENINGCSV, "accountId");
		CSVUtils.clearColumnByName(Paths.ABECLOSEMUDARABAHTUACSV, "accountId");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYMUDARABAHTUACLOSURECSV, "accountId");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEOpenMudarabahTUAData data = (ABEOpenMudarabahTUAData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Mudarabah TUA DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEOPENMUDARABAHTUACSV);
		workbook.save(Paths.ABEOPENMUDARABAHTUAJSON);
        Class<ABEOpenMudarabahTUAData> targetClass = ABEOpenMudarabahTUAData.class;
        JsonReader<ABEOpenMudarabahTUAData> jsonReader = new JsonReader<>(targetClass);
        List<ABEOpenMudarabahTUAData> dataList = jsonReader.readJsonFile(Paths.ABEOPENMUDARABAHTUAJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Mudarabah TUA DataProvider", dataProviderClass = ABEOpenMudarabahTUATest.class)
	public void openMudarabahTUATest(ABEOpenMudarabahTUAData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
        ABEOpenMudarabahTUAProcedures.openMudarabahTUA(driver, data);
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