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
import data.ABEVerifyCorporateLoanDisbursmentCorporateLoansData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyCorporateLoanDisbursmentCorporateLoansProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test(groups = "ABEVerifyCorporateLoanDisbursmentCorporateLoansTest", dependsOnGroups = "ABEDisburseCorporateLoanCorporateLoansTest")
@Listeners({AllureTestNg.class})
public class ABEVerifyCorporateLoanDisbursmentCorporateLoansTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyCorporateLoanDisbursmentCorporateLoansData data = (ABEVerifyCorporateLoanDisbursmentCorporateLoansData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Corporate Loan Disbursment Corporate Loans Test")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYCORPORATELOANDISBURSMENTCORPORATELOANSCSV);
		workbook.save(Paths.ABEVERIFYCORPORATELOANDISBURSMENTCORPORATELOANSJSON);
        Class<ABEVerifyCorporateLoanDisbursmentCorporateLoansData> targetClass = ABEVerifyCorporateLoanDisbursmentCorporateLoansData.class;
        JsonReader<ABEVerifyCorporateLoanDisbursmentCorporateLoansData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyCorporateLoanDisbursmentCorporateLoansData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYCORPORATELOANDISBURSMENTCORPORATELOANSJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Corporate Loan Disbursment Corporate Loans Test", dataProviderClass = ABEVerifyCorporateLoanDisbursmentCorporateLoansTest.class)
	public void verifyCorporateLoanDisbursmentCorporateLoansTest(ABEVerifyCorporateLoanDisbursmentCorporateLoansData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyCorporateLoanDisbursmentCorporateLoansProcedures.verifyCorporateLoanDisbursmentCorporateLoans(driver, data);
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