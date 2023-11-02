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
import data.ABEVerifyOutwardTransferPaymentData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyOutwardTransferPaymentProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

//@Test(groups = "VerifyACH",dependsOnGroups = "CreateACH")
@Listeners({AllureTestNg.class})
public class ABEVerifyACHOutwardTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyOutwardTransferPaymentData data = (ABEVerifyOutwardTransferPaymentData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify ACH Outward DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.Verify_ACH_Outwardcsv);
		workbook.save(Paths.Verify_ACH_OutwardJson);
        Class<ABEVerifyOutwardTransferPaymentData> targetClass = ABEVerifyOutwardTransferPaymentData.class;
        JsonReader<ABEVerifyOutwardTransferPaymentData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyOutwardTransferPaymentData> dataList = jsonReader.readJsonFile(Paths.Verify_ACH_OutwardJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify ACH Outward DataProvider", dataProviderClass = ABEVerifyACHOutwardTest.class)
	public void verifyACHOutwardTest(ABEVerifyOutwardTransferPaymentData data) throws Exception {
	   // Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());
        ABEVerifyOutwardTransferPaymentProcedures.verifyAchOutwardBychecker(driver, data);
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