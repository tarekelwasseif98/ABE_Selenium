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
import data.ABEOpenCurrentAccountMudarabahCAAData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEOpenCurrentAccountMudarabahCAAProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEOpenCurrentAccountMudarabahCAATest")
@Listeners({AllureTestNg.class})
public class ABEOpenCurrentAccountMudarabahCAATest {
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABEOPENCURRENTACCOUNTMUDARABAHCAACSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYCURRENTACCOUNTOPENINGCSV, "accountId");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEOpenCurrentAccountMudarabahCAAData data = (ABEOpenCurrentAccountMudarabahCAAData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Current Account Mudarabah CAA DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEOPENCURRENTACCOUNTMUDARABAHCAACSV);
		workbook.save(Paths.ABEOPENCURRENTACCOUNTMUDARABAHJSON);
        Class<ABEOpenCurrentAccountMudarabahCAAData> targetClass = ABEOpenCurrentAccountMudarabahCAAData.class;
        JsonReader<ABEOpenCurrentAccountMudarabahCAAData> jsonReader = new JsonReader<>(targetClass);
        List<ABEOpenCurrentAccountMudarabahCAAData> dataList = jsonReader.readJsonFile(Paths.ABEOPENCURRENTACCOUNTMUDARABAHJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Current Account Mudarabah CAA DataProvider", dataProviderClass = ABEOpenCurrentAccountMudarabahCAATest.class)
	public void openCurrentAccountMudarabahCAATest(ABEOpenCurrentAccountMudarabahCAAData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());		
        ABEOpenCurrentAccountMudarabahCAAProcedures.openCurrentAccountMudarabahCAA(driver, data);
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