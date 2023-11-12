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
import data.ABEOpenMurabahaAccountMurabahaFinancingData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABEOpenMurabahaAccountMurabahaFinancingProcedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test(groups = "ABEOpenMurabahaAccountMurabahaFinancingTest")
@Listeners({AllureTestNg.class})
public class ABEOpenMurabahaAccountMurabahaFinancingTest {
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGCSV, "reference");
		CSVUtils.clearColumnByName(Paths.ABEVERIFYMURABAHAACCOUNTOPENINGMURABAHAFINANCINGCSV, "accountId");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEOpenMurabahaAccountMurabahaFinancingData data = (ABEOpenMurabahaAccountMurabahaFinancingData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Murabaha Account Murabaha Financing DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGCSV);
		workbook.save(Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGJSON);
        Class<ABEOpenMurabahaAccountMurabahaFinancingData> targetClass = ABEOpenMurabahaAccountMurabahaFinancingData.class;
        JsonReader<ABEOpenMurabahaAccountMurabahaFinancingData> jsonReader = new JsonReader<>(targetClass);
        List<ABEOpenMurabahaAccountMurabahaFinancingData> dataList = jsonReader.readJsonFile(Paths.ABEOPENMURABAHAACCOUNTMURABAHAFINANCINGJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Murabaha Account Murabaha Financing DataProvider", dataProviderClass = ABEOpenMurabahaAccountMurabahaFinancingTest.class)
	public void openMurabahaAccountMurabahaFinancingTest(ABEOpenMurabahaAccountMurabahaFinancingData data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTcId()));
		Allure.parameter("Data: ", data.toString());		
        ABEOpenMurabahaAccountMurabahaFinancingProcedures.openMurabahaAccountMurabahaFinancing(driver, data);
        AssertionFactory.checkExpectedResult(driver, data.getExpectedResult());
	}

	@Attachment(value = "Screenshot", type = "image/png")
	@AfterMethod
	public void after(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotHelper.captureScreenshot(driver);
            System.out.println("success");
        }
		 if (result.getStatus() == ITestResult.FAILURE) {
	            ScreenshotHelper.captureScreenshot(driver);
	            System.out.println("fail");

	        }
		 
		driver.quit();
	}
}