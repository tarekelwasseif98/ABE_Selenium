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
import data.ABEDisburseRetailLoanRetailLoansData;
import data.JsonReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEDisburseRetailLoanRetailLoansProcedures;
import utils.AssertionFactory;
import utils.Paths;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;

@Test(groups = "ABEDisburseRetailLoan", dependsOnGroups = "verifyRetailLoan", alwaysRun = true)
@Listeners({AllureTestNg.class})
public class ABEDisburseRetailLoanRetailLoansTest {

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEDisburseRetailLoanRetailLoansData data = (ABEDisburseRetailLoanRetailLoansData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Disburse Retail Loan DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEDISBURSERETAILLOANRETAILLOANSCSV);
		workbook.save(Paths.ABEDISBURSERETAILLOANRETAILLOANSJSON);
        Class<ABEDisburseRetailLoanRetailLoansData> targetClass = ABEDisburseRetailLoanRetailLoansData.class;
        JsonReader<ABEDisburseRetailLoanRetailLoansData> jsonReader = new JsonReader<>(targetClass);
        List<ABEDisburseRetailLoanRetailLoansData> dataList = jsonReader.readJsonFile(Paths.ABEDISBURSERETAILLOANRETAILLOANSJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Disburse Retail Loan DataProvider", dataProviderClass = ABEDisburseRetailLoanRetailLoansTest.class)
	public void disburseRetailLoan(ABEDisburseRetailLoanRetailLoansData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
		ABEDisburseRetailLoanRetailLoansProcedures.ABEDisburseRetailLoanRetailLoans(driver, data);
        AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
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
