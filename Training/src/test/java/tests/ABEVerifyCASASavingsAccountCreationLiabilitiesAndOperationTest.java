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
import data.ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test(groups = "VerifyCasaSavingsAc", dependsOnGroups = "OpenCasaSavingsAc")
@Listeners({AllureTestNg.class})
public class ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationTest {

	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
	//	CSVUtils.clearColumnByName(Paths.VerifyOfficeAccountCsv, "accountId");
	//	CSVUtils.clearColumnByName(Paths.VerifyIslamicSavingsAccountCsv, "accountId");
	}
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData data = (ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	

	@DataProvider(name="Verify Casa Savings Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYCASASAVINGSACCOUNTCREATIONLIABILITIESANDOPERATIONCSV);
		workbook.save(Paths.ABEVERIFYCASASAVINGSACCOUNTCREATIONLIABILITIESANDOPERATIONJSON);
        Class<ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData> targetClass = ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData.class;
        JsonReader<ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYCASASAVINGSACCOUNTCREATIONLIABILITIESANDOPERATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Casa Savings Account DataProvider", dataProviderClass = ABEVerifyCASASavingsAccountCreationLiabilitiesAndOperationTest.class)
	@Step("{testCaseId}")
	public void ABE_VerifyOfficeAccount(ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyCasaSavingsAccountCreationLiabilitiesAndOperationProcedures.Casa_VerifySavingsAccountByMaker(driver, data);
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
