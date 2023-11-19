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
import data.ABEDisburseCorporateLoanCorporateLoansData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEDisburseCorporateLoanCorporateLoansProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test(groups = "ABEDisburseCorporateLoan", dependsOnGroups = "verifyCorporateLoan", alwaysRun = true)
@Listeners({AllureTestNg.class})
public class ABEDisburseCorporateLoanCorporateLoansTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEDisburseCorporateLoanCorporateLoansData data = (ABEDisburseCorporateLoanCorporateLoansData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Disburse Corporate Loan DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEDISBURSECORPORATELOANCORPORATELOANSCSV);
		workbook.save(Paths.ABEDISBURSECORPORATELOANCORPORATELOANSJSON);
        Class<ABEDisburseCorporateLoanCorporateLoansData> targetClass = ABEDisburseCorporateLoanCorporateLoansData.class;
        JsonReader<ABEDisburseCorporateLoanCorporateLoansData> jsonReader = new JsonReader<>(targetClass);
        List<ABEDisburseCorporateLoanCorporateLoansData> dataList = jsonReader.readJsonFile(Paths.ABEDISBURSECORPORATELOANCORPORATELOANSJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Disburse Corporate Loan DataProvider", dataProviderClass = ABEDisburseCorporateLoanCorporateLoansTest.class)
	public void disburseRetailLoan(ABEDisburseCorporateLoanCorporateLoansData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEDisburseCorporateLoanCorporateLoansProcedures.ABEDisburseCorporateLoanCorporateLoans(driver, data);
      //  AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}
	
	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
        }
		 if (result.getStatus() == ITestResult.FAILURE) {
	            ScreenshotHelper.captureScreenshot(driver);
	        }
		driver.quit();
	}
	
}
