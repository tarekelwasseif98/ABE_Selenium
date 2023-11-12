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
import data.ABEVerifyCorporateLoanCorporateLoansData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEVerifyCorporateLoanCorporateLoansProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "ABEVerifyCorporateLoanCorporateLoansTest", dependsOnGroups = "ABEOpenCorporateLoanCorporateLoansTest")
@Listeners({AllureTestNg.class})
public class ABEVerifyCorporateLoanCorporateLoansTest {
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEVerifyCorporateLoanCorporateLoansData data = (ABEVerifyCorporateLoanCorporateLoansData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Verify Corporate Loan Corporate Loans DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEVERIFYCORPORATELOANCORPORATELOANSCSV);
		workbook.save(Paths.ABEVERIFYCORPORATELOANCORPORATELOANSJSON);
        Class<ABEVerifyCorporateLoanCorporateLoansData> targetClass = ABEVerifyCorporateLoanCorporateLoansData.class;
        JsonReader<ABEVerifyCorporateLoanCorporateLoansData> jsonReader = new JsonReader<>(targetClass);
        List<ABEVerifyCorporateLoanCorporateLoansData> dataList = jsonReader.readJsonFile(Paths.ABEVERIFYCORPORATELOANCORPORATELOANSJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Verify Corporate Loan Corporate Loans DataProvider", dataProviderClass = ABEVerifyCorporateLoanCorporateLoansTest.class)
	public void verifyCorporateLoanCorporateLoansTest(ABEVerifyCorporateLoanCorporateLoansData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		ABEVerifyCorporateLoanCorporateLoansProcedures.verifyCorporateLoanCorporateLoans(driver, data);
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