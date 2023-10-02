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
import data.ABE_VerifyCasaAccountClosure_Mudarabah_Data;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABE_VerifyCasaAccountClosure_Mudarabah_Procedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "ABE_VerifyCasaAccountClosure_Mudarabah_Test", dependsOnGroups = "ABE_CloseCasaAccount_Mudarabah_Test")
@Listeners({AllureTestNg.class})
public class ABE_VerifyCasaAccountClosure_Mudarabah_Test {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABE_VerifyCasaAccountClosure_Mudarabah_Data data = (ABE_VerifyCasaAccountClosure_Mudarabah_Data) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
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
        Class<ABE_VerifyCasaAccountClosure_Mudarabah_Data> targetClass = ABE_VerifyCasaAccountClosure_Mudarabah_Data.class;
        JsonReader<ABE_VerifyCasaAccountClosure_Mudarabah_Data> jsonReader = new JsonReader<>(targetClass);
        List<ABE_VerifyCasaAccountClosure_Mudarabah_Data> dataList = jsonReader.readJsonFile(Paths.VerifyCloseIslamicCasaAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Close Islamic Casa Account DataProvider", dataProviderClass = ABE_VerifyCasaAccountClosure_Mudarabah_Test.class)
	public void closeIslamicCasaAccountTest(ABE_VerifyCasaAccountClosure_Mudarabah_Data data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		ABE_VerifyCasaAccountClosure_Mudarabah_Procedures.verifyCasaAccountClosureMudarabah(driver, data);
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