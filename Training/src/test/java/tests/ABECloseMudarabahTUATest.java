package tests;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aspose.cells.Workbook;
import data.JsonReader;
import data.ABECloseMudarabahTUAData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABECloseMudarabahTUAProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABECloseMudarabahTUATest")
@Listeners({AllureTestNg.class})
public class ABECloseMudarabahTUATest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECloseMudarabahTUAData data = (ABECloseMudarabahTUAData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Close Mudarabah TUA DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABECLOSEMUDARABAHTUACSV);
		workbook.save(Paths.ABECLOSEMUDARABAHTUAJSON);
        Class<ABECloseMudarabahTUAData> targetClass = ABECloseMudarabahTUAData.class;
        JsonReader<ABECloseMudarabahTUAData> jsonReader = new JsonReader<>(targetClass);
        List<ABECloseMudarabahTUAData> dataList = jsonReader.readJsonFile(Paths.ABECLOSEMUDARABAHTUAJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Close Mudarabah TUA DataProvider", dataProviderClass = ABECloseMudarabahTUATest.class)
	public void closeMudarabahTUATest(ABECloseMudarabahTUAData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
        ABECloseMudarabahTUAProcedures.closeMudarabahTUA(driver, data);
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