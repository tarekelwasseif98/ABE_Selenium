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
import data.ABEVerifyRetailLoanDisbursmentRetailLoansData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyRetailLoanDisbursmentRetailLoansProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
//, dependsOnGroups = "ABEDisburseRetailLoan"
@Test(groups = "verifyRetailLoanDisbursment", dependsOnGroups = "ABEDisburseRetailLoan")
@Listeners({AllureTestNg.class})
public class ABEVerifyRetailLoanDisbursmentRetailLoansTest {
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyRetailLoanDisbursmentRetailLoansData data = (ABEVerifyRetailLoanDisbursmentRetailLoansData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify loan Disbursment DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSCSV);
		workbook.save(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSJSON);
        Class<ABEVerifyRetailLoanDisbursmentRetailLoansData> targetClass = ABEVerifyRetailLoanDisbursmentRetailLoansData.class;
        JsonReader<ABEVerifyRetailLoanDisbursmentRetailLoansData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyRetailLoanDisbursmentRetailLoansData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify loan Disbursment DataProvider", dataProviderClass = ABEVerifyRetailLoanDisbursmentRetailLoansTest.class)
	@Step("{testCaseId}")
	public void ABEVerifyRetailLoanDisbursmentRetailLoans(ABEVerifyRetailLoanDisbursmentRetailLoansData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyRetailLoanDisbursmentRetailLoansProcedures.ABEVerifyRetailLoanDisbursmentRetailLoans(driver, data);
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
