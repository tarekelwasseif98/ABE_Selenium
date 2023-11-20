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
import data.ABEVerifyMudarabahTUAClosureData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyMudarabahTUAClosureProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEVerifyMudarabahTUAClosureTest", dependsOnGroups = "ABECloseMudarabahTUATest")
@Listeners({AllureTestNg.class})
public class ABEVerifyMudarabahTUAClosureTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyMudarabahTUAClosureData data = (ABEVerifyMudarabahTUAClosureData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Mudarabah TUA Closure DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYMUDARABAHTUACLOSURECSV);
		workbook.save(Paths.ABEVERIFYMUDARABAHTUACLOSUREJSON);
        Class<ABEVerifyMudarabahTUAClosureData> targetClass = ABEVerifyMudarabahTUAClosureData.class;
        JsonReader<ABEVerifyMudarabahTUAClosureData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyMudarabahTUAClosureData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYMUDARABAHTUACLOSUREJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Mudarabah TUA Closure DataProvider", dataProviderClass = ABEVerifyMudarabahTUAClosureTest.class)
	public void verifyMudarabahTUAClosureTest(ABEVerifyMudarabahTUAClosureData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());		
        ABEVerifyMudarabahTUAClosureProcedures.verifyMudarabahTUAClosure(driver, data);
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