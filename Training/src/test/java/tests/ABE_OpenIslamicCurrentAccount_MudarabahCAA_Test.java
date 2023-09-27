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
import data.ABE_OpenCurrentAccount_MudarabahCAA_Data;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import pageobjects.FinacleLoginPage;
import procedures.ABE_OpenCurrentAccount_MudarabahCAA_Procedures;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;
import utils.AssertionFactory;
import utils.CSVUtils;
import io.qameta.allure.testng.AllureTestNg;

@Test( groups = "open")
@Listeners({AllureTestNg.class})
public class ABE_OpenIslamicCurrentAccount_MudarabahCAA_Test {
	
	@BeforeClass
	public void oneTimeSetUp() throws IOException, CsvException {
		CSVUtils.clearColumnByName(Paths.OpenIslamicCurrentAccountCsv, "reference");
		CSVUtils.clearColumnByName(Paths.VerifyIslamicCurrentAccountCsv, "accountId");
	}

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABE_OpenCurrentAccount_MudarabahCAA_Data data = (ABE_OpenCurrentAccount_MudarabahCAA_Data) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleUrl);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Open Islamic Current Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.OpenIslamicCurrentAccountCsv);
		workbook.save(Paths.OpenIslamicCurrentAccountJson);
        Class<ABE_OpenCurrentAccount_MudarabahCAA_Data> targetClass = ABE_OpenCurrentAccount_MudarabahCAA_Data.class;
        JsonReader<ABE_OpenCurrentAccount_MudarabahCAA_Data> jsonReader = new JsonReader<>(targetClass);
        List<ABE_OpenCurrentAccount_MudarabahCAA_Data> dataList = jsonReader.readJsonFile(Paths.OpenIslamicCurrentAccountJson);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Open Islamic Current Account DataProvider", dataProviderClass = ABE_OpenIslamicCurrentAccount_MudarabahCAA_Test.class)
	public void openIslamicCurrentAccount(ABE_OpenCurrentAccount_MudarabahCAA_Data data) throws Exception {
		Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());		
        ABE_OpenCurrentAccount_MudarabahCAA_Procedures.openIslamicCurrentAccountByMaker(driver, data);
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