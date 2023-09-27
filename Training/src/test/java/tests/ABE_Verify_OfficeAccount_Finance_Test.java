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
import data.JsonReader;
import data.ABE_Verify_OfficeAccount_Finance_Data;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.VerifyOfficeAccountProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "verifyOfficeAccount", dependsOnGroups = "OpenOfficeAccount")
@Listeners({AllureTestNg.class})
public class ABE_Verify_OfficeAccount_Finance_Test {
	 
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
	//	CSVUtils.clearColumnByName(Paths.VerifyOfficeAccountCsv, "accountId");
	//	CSVUtils.clearColumnByName(Paths.VerifyIslamicSavingsAccountCsv, "accountId");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABE_Verify_OfficeAccount_Finance_Data data = (ABE_Verify_OfficeAccount_Finance_Data) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Office Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.VerifyOfficeAccountCsv);
		workbook.save(Paths.VerifyOfficeAccountJson);
        Class<ABE_Verify_OfficeAccount_Finance_Data> targetClass = ABE_Verify_OfficeAccount_Finance_Data.class;
        JsonReader<ABE_Verify_OfficeAccount_Finance_Data> jsonReader = new JsonReader<>(targetClass);
        List<ABE_Verify_OfficeAccount_Finance_Data> dataList = jsonReader.readJsonFile(Paths.VerifyOfficeAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Office Account DataProvider", dataProviderClass = ABE_Verify_OfficeAccount_Finance_Test.class)
	@Step("{testCaseId}")
	public void ABE_VerifyOfficeAccount(ABE_Verify_OfficeAccount_Finance_Data data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		VerifyOfficeAccountProcedures.OfficeAccountByChecker(driver, data);
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