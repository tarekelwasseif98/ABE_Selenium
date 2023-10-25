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

import data.AuthorizeACHOutwardData;
import data.JsonReader;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.AuthorizeAchOutwardProcedures;

import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "AuthorizeACH",dependsOnGroups = "VerifyACH")
@Listeners({AllureTestNg.class})
public class ABE_Authorize_ACH_Outward_Test {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		AuthorizeACHOutwardData data = (AuthorizeACHOutwardData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Authorize ACH Outward DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.Authorize_ACH_Outwardcsv);
		workbook.save(Paths.Authorize_ACH_OutwardJson);
        Class<AuthorizeACHOutwardData> targetClass = AuthorizeACHOutwardData.class;
        JsonReader<AuthorizeACHOutwardData> jsonReader = new JsonReader<>(targetClass);
        List<AuthorizeACHOutwardData> dataList = jsonReader.readJsonFile(Paths.Authorize_ACH_OutwardJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Authorize ACH Outward DataProvider", dataProviderClass = ABE_Authorize_ACH_Outward_Test.class)
	public void authorizeACHOutward(AuthorizeACHOutwardData data) throws Exception {
//		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());
	    AuthorizeAchOutwardProcedures.AuthorizeAchOutwardBychecker(driver, data);
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