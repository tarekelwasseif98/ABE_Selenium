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
import data.ABEVerifyTdLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyTdLiabilitiesAndOperationProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test(groups = "verifyTd", dependsOnGroups = "OpenTd", alwaysRun = true)
@Listeners({AllureTestNg.class})

public class ABEVerifyTdLiabilitiesAndOperationTest {
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyTdLiabilitiesAndOperationData data = (ABEVerifyTdLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	
	}
	
	@DataProvider(name="Verify Td DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYTDLIABILITIESANDOPERATIONCSV);
		workbook.save(Paths.ABEVERIFYTDLIABILITIESANDOPERATIONJSON);
        Class<ABEVerifyTdLiabilitiesAndOperationData> targetClass = ABEVerifyTdLiabilitiesAndOperationData.class;
        JsonReader<ABEVerifyTdLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyTdLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYTDLIABILITIESANDOPERATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Td DataProvider", dataProviderClass = ABEVerifyTdLiabilitiesAndOperationTest.class)
	@Step("{testCaseId}")
	public void ABE_VerifyTDAccount(ABEVerifyTdLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyTdLiabilitiesAndOperationProcedures.ABEVerifyTdLiabilitiesAndOperationByChecker(driver, data);
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
