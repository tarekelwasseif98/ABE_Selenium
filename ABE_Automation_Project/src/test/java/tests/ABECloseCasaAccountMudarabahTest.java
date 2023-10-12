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
import data.ABECloseCasaAccountMudarabahData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABECloseCasaAccountMudarabahProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "ABECloseCasaAccountMudarabahTest")
@Listeners({AllureTestNg.class})
public class ABECloseCasaAccountMudarabahTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABECloseCasaAccountMudarabahData data = (ABECloseCasaAccountMudarabahData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Close Casa Account Mudarabah DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.CloseIslamicCasaAccountCsv);
		workbook.save(Paths.CloseIslamicCasaAccountJson);
        Class<ABECloseCasaAccountMudarabahData> targetClass = ABECloseCasaAccountMudarabahData.class;
        JsonReader<ABECloseCasaAccountMudarabahData> jsonReader = new JsonReader<>(targetClass);
        List<ABECloseCasaAccountMudarabahData> dataList = jsonReader.readJsonFile(Paths.CloseIslamicCasaAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Close Casa Account Mudarabah DataProvider", dataProviderClass = ABECloseCasaAccountMudarabahTest.class)
	public void closeIslamicCasaAccountTest(ABECloseCasaAccountMudarabahData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		ABECloseCasaAccountMudarabahProcedures.closeCasaAccountMudarabah(driver, data);
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