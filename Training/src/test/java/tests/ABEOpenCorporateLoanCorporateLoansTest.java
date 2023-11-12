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
import data.ABEOpenCorporateLoanCorporateLoansData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEOpenCorporateLoanCorporateLoansProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEOpenCorporateLoanCorporateLoansTest")
@Listeners({AllureTestNg.class})
public class ABEOpenCorporateLoanCorporateLoansTest {
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABEOPENCORPORATELOANCORPORATELOANSCSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYCORPORATELOANCORPORATELOANSCSV, "accountId");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEOpenCorporateLoanCorporateLoansData data = (ABEOpenCorporateLoanCorporateLoansData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Corporate Loan Corporate Loans DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEOPENCORPORATELOANCORPORATELOANSCSV);
		workbook.save(Paths.ABEOPENCORPORATELOANCORPORATELOANSJSON);
        Class<ABEOpenCorporateLoanCorporateLoansData> targetClass = ABEOpenCorporateLoanCorporateLoansData.class;
        JsonReader<ABEOpenCorporateLoanCorporateLoansData> jsonReader = new JsonReader<>(targetClass);
        List<ABEOpenCorporateLoanCorporateLoansData> dataList = jsonReader.readJsonFile(Paths.ABEOPENCORPORATELOANCORPORATELOANSJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Corporate Loan Corporate Loans DataProvider", dataProviderClass = ABEOpenCorporateLoanCorporateLoansTest.class)
	public void openCorporateLoanCorporateLoansTest(ABEOpenCorporateLoanCorporateLoansData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());
        ABEOpenCorporateLoanCorporateLoansProcedures.openCorporateLoanCorporateLoans(driver, data);
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