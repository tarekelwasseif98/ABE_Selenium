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
import data.ABEVerifyCurrentAccountOpeningMudarabahCAAData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyCurrentAccountOpeningMudarabahCAAProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "ABEVerifyCurrentAccountOpeningMudarabahCAATest", dependsOnGroups = "ABEOpenCurrentAccountMudarabahCAATest")
@Listeners({AllureTestNg.class})
public class ABEVerifyCurrentAccountOpeningMudarabahCAATest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyCurrentAccountOpeningMudarabahCAAData data = (ABEVerifyCurrentAccountOpeningMudarabahCAAData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Current Account Opening Mudarabah CAA DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.VerifyIslamicCurrentAccountCsv);
		workbook.save(Paths.VerifyIslamicCurrentAccountJson);
        Class<ABEVerifyCurrentAccountOpeningMudarabahCAAData> targetClass = ABEVerifyCurrentAccountOpeningMudarabahCAAData.class;
        JsonReader<ABEVerifyCurrentAccountOpeningMudarabahCAAData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyCurrentAccountOpeningMudarabahCAAData> dataList = jsonReader.readJsonFile(Paths.VerifyIslamicCurrentAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Current Account Opening Mudarabah CAA DataProvider", dataProviderClass = ABEVerifyCurrentAccountOpeningMudarabahCAATest.class)
	public void verifyIslamicCurrentAccountTest(ABEVerifyCurrentAccountOpeningMudarabahCAAData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		ABEVerifyCurrentAccountOpeningMudarabahCAAProcedures.verifyCurrentAccountOpeningMudarabahCAA(driver, data);
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