package tests;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import com.opencsv.exceptions.CsvValidationException;
import data.VerifyIslamicSavingsAccountData;
import pageobjects.FinacleLoginPage;
import procedures.VerifyIslamicSavingsAccountProcedures;
import utils.Properties;
import utils.VerifyIslamicSavingsAccountCSVReader;
import utils.WebdriverFactory;
import utils.csvPaths;

public class ABE_VerifyIslamicSavingsAccount_MudarabahSBA {
	
    @BeforeSuite
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser Version", "90.0.4430.72")
                        .put("URL", "https://newwebuat.abe.com.eg:1443/fininfra/ui/SSOLogin.jsp")
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }

	WebDriver driver = null;
	@BeforeMethod(description= "Initiating Browser")
	public void beforeTest() throws Exception {
		driver = WebdriverFactory.initiateWebDriver();
		driver.get(Properties.FinacleURL);
	}
	
	@DataProvider(name="Verify Islamic Savings Account DataProvider")
	public Object[] dpMethod() throws CsvValidationException, IOException {
		return VerifyIslamicSavingsAccountCSVReader.csvReader(csvPaths.VISAO_CSV).toArray();
	}
	
	@Test(dataProvider = "Verify Islamic Savings Account DataProvider", dataProviderClass = ABE_VerifyIslamicSavingsAccount_MudarabahSBA.class)
	public void test(VerifyIslamicSavingsAccountData data) throws Exception {

		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextfield(data.getUsername())
		.sendKeysPasswordTextfield(data.getPassword())
		.clickOnLoginButton(data.getPassword());
		VerifyIslamicSavingsAccountProcedures.IslamicSavingsAccount_Checker(driver, data.getMenu(), data.getAccountid());
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}
}