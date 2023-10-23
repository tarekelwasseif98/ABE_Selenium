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

import data.ABEAuthorizeOutwardTransferPaymentData;
import data.JsonReader;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEAuthorizeOutwardTransferPaymentProcedures;

import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "AuthorizeACHUS",dependsOnGroups = "VerifyACHUS")
@Listeners({AllureTestNg.class})
public class ABEAuthorizeACHUSOutwardTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEAuthorizeOutwardTransferPaymentData data = (ABEAuthorizeOutwardTransferPaymentData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Authorize ACH Outward DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEAuthorizeACHUSOutwardCsv);
		workbook.save(Paths.ABEAuthorizeACHUSOutwardJson);
        Class<ABEAuthorizeOutwardTransferPaymentData> targetClass = ABEAuthorizeOutwardTransferPaymentData.class;
        JsonReader<ABEAuthorizeOutwardTransferPaymentData> jsonReader = new JsonReader<>(targetClass);
        List<ABEAuthorizeOutwardTransferPaymentData> dataList = jsonReader.readJsonFile(Paths.ABEAuthorizeACHUSOutwardJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Authorize ACH Outward DataProvider", dataProviderClass = ABEAuthorizeACHUSOutwardTest.class)
	public void authorizeACHOutward(ABEAuthorizeOutwardTransferPaymentData data) throws Exception {
//		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());
	    ABEAuthorizeOutwardTransferPaymentProcedures.AuthorizeAchOutwardBychecker(driver, data);
	   // AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
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