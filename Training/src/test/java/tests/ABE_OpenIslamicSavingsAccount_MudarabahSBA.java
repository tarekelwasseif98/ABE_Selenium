package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import com.opencsv.exceptions.CsvValidationException;
import data.OpenIslamicSavingsAccountData;
import pageobjects.FinacleLoginPage;
import pageobjects.OpenSavingsAccountPage;
import procedures.OpenIslamicSavingsAccountProcedures;
import utils.Properties;
import utils.WebdriverFactory;
import utils.csvPaths;
import utils.OpenIslamicSavingsAccountCSVReader;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.io.IOException;

public class ABE_OpenIslamicSavingsAccount_MudarabahSBA {
	
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
	
	@DataProvider(name="Open Islamic Savings Account DataProvider")
	public Object[] dpMethod() throws CsvValidationException, IOException {
		return OpenIslamicSavingsAccountCSVReader.csvReader(csvPaths.OISAC_CSV).toArray();
	}
	
	@Test(dataProvider = "Open Islamic Savings Account DataProvider", dataProviderClass = ABE_OpenIslamicSavingsAccount_MudarabahSBA.class)
	public void test(OpenIslamicSavingsAccountData data) throws Exception {
		
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextfield(data.getUsername())
		.sendKeysPasswordTextfield(data.getPassword())
		.clickOnLoginButton(data.getPassword());
        OpenIslamicSavingsAccountProcedures.IslamicSavingsAccount_Maker(driver, data);
        AssertJUnit.assertEquals("The savings account is opened successfully.", driver.findElement(By.xpath("(//p[@id='_resMsg_paraMsg'])[1]")).getText().substring(0, 43));
	}
	
	@AfterMethod
	public void after() {
		driver.quit();
	}
}