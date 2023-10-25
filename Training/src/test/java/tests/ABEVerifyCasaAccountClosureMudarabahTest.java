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
import data.ABEVerifyCasaAccountClosureMudarabahData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyCasaAccountClosureMudarabahProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "ABEVerifyCasaAccountClosureMudarabahTest", dependsOnGroups = "ABECloseCasaAccountMudarabahTest")
@Listeners({AllureTestNg.class})
public class ABEVerifyCasaAccountClosureMudarabahTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyCasaAccountClosureMudarabahData data = (ABEVerifyCasaAccountClosureMudarabahData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Close Islamic Casa Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.VerifyCloseIslamicCasaAccountCsv);
		workbook.save(Paths.VerifyCloseIslamicCasaAccountJson);
        Class<ABEVerifyCasaAccountClosureMudarabahData> targetClass = ABEVerifyCasaAccountClosureMudarabahData.class;
        JsonReader<ABEVerifyCasaAccountClosureMudarabahData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyCasaAccountClosureMudarabahData> dataList = jsonReader.readJsonFile(Paths.VerifyCloseIslamicCasaAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Close Islamic Casa Account DataProvider", dataProviderClass = ABEVerifyCasaAccountClosureMudarabahTest.class)
	public void closeIslamicCasaAccountTest(ABEVerifyCasaAccountClosureMudarabahData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		ABEVerifyCasaAccountClosureMudarabahProcedures.verifyCasaAccountClosureMudarabah(driver, data);
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