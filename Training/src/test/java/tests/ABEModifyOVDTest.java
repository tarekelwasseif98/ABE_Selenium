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
import data.ABEModifyOVDData;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import pageobjects.FinacleLoginPage;
import procedures.ABEModifyOVDProcedures;
import utils.AssertionFactory;
import utils.CSVUtils;
import utils.Properties;
import utils.ScreenshotHelper;
import utils.WebdriverFactory;
import utils.Paths;

@Test(groups = "modify",dependsOnGroups = "open")
@Listeners({AllureTestNg.class})
public class ABEModifyOVDTest {


	
	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest(Object [] testData) throws Exception {
		ABEModifyOVDData data = (ABEModifyOVDData) testData[0];
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FINACLEURL);
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextField(data.getUsername())
		.sendKeysPasswordTextField(data.getPassword())
		.clickOnLoginButton(data.getPassword());
	}
	
	@DataProvider(name="Modify over draft Account DataProvider")
	public Object[] dpMethod() throws Exception {
    	Workbook workbook = new Workbook(Paths.MODIFYOVERDRAFTACCOUNTBEFOREVERIFICATIONCSV);
		workbook.save(Paths.MODIFYOVERDRAFTACCOUNTBEFOREVERIFICATIONJSON);
        Class<ABEModifyOVDData> targetClass = ABEModifyOVDData.class;
        JsonReader<ABEModifyOVDData> jsonReader = new JsonReader<>(targetClass);
        List<ABEModifyOVDData> dataList = jsonReader.readJsonFile(Paths.MODIFYOVERDRAFTACCOUNTBEFOREVERIFICATIONJSON);
        dataList.toArray();
        return dataList.toArray();
	}
	
	@Test(dataProvider = "Modify over draft Account DataProvider", dataProviderClass = ABEModifyOVDTest.class)
	public void modifyOverDraftAccount(ABEModifyOVDData data) throws Exception {
		//Allure.getLifecycle().updateTestCase(tc -> tc.setName("Test Case ID: " + data.getTCID()));
		Allure.parameter("Data: ", data.toString());
		ABEModifyOVDProcedures.ModifyOverDraftAccountByMaker(driver, data);
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