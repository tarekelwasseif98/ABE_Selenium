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
import data.CloseIslamicCasaAccountData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.CloseIslamicCasaAccountProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "close")
@Listeners({AllureTestNg.class})
public class ABE_CloseIslamicCasaAccount_MudarabahCasa_Test {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		CloseIslamicCasaAccountData data = (CloseIslamicCasaAccountData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Close Islamic Casa Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.CloseIslamicCasaAccountCsv);
		workbook.save(Paths.CloseIslamicCasaAccountJson);
        Class<CloseIslamicCasaAccountData> targetClass = CloseIslamicCasaAccountData.class;
        JsonReader<CloseIslamicCasaAccountData> jsonReader = new JsonReader<>(targetClass);
        List<CloseIslamicCasaAccountData> dataList = jsonReader.readJsonFile(Paths.CloseIslamicCasaAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Close Islamic Casa Account DataProvider", dataProviderClass = ABE_CloseIslamicCasaAccount_MudarabahCasa_Test.class)
	public void closeIslamicCasaAccountTest(CloseIslamicCasaAccountData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		CloseIslamicCasaAccountProcedures.closeIslamicCasaAccountByMaker(driver, data);
		AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}

	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) throws InterruptedException {
		Thread.sleep(1000);
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
            }
		 if (result.getStatus() == ITestResult.FAILURE) {
			 ScreenshotHelper.captureScreenshot(driver);
			 }
		driver.quit();
	}
}