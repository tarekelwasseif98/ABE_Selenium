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
import data.ABEVerifyRetailLoanRetailLoansData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyRetailLoanRetailLoansProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test(groups = "verifyRetailLoan", dependsOnGroups = "openRetailLoan", alwaysRun = true)
@Listeners({AllureTestNg.class})
public class ABEVerifyRetailLoanRetailLoansTest {
	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyRetailLoanRetailLoansData data = (ABEVerifyRetailLoanRetailLoansData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify loan DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYRETAILLOANRETAILLOANSCSV);
		workbook.save(Paths.ABEVERIFYRETAILLOANRETAILLOANSJSON);
        Class<ABEVerifyRetailLoanRetailLoansData> targetClass = ABEVerifyRetailLoanRetailLoansData.class;
        JsonReader<ABEVerifyRetailLoanRetailLoansData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyRetailLoanRetailLoansData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYRETAILLOANRETAILLOANSJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify loan DataProvider", dataProviderClass = ABEVerifyRetailLoanRetailLoansTest.class)
	@Step("{testCaseId}")
	public void ABEVerifyRetailLoanRetailLoans(ABEVerifyRetailLoanRetailLoansData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEVerifyRetailLoanRetailLoansProcedures.ABEVerifyRetailLoanRetailLoans(driver, data);
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
