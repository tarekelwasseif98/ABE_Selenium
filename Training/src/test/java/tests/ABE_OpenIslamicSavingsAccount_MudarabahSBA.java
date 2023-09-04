package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import data.OpenIslamicSavingsAccountData;
import pageobjects.FinacleLoginPage;
import procedures.OpenSavingsAccountProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.WebdriverFactory;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

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

	@Test(dataProvider = "OpenIslamicSavingsAccountDataProvider", description="FCB-9792", dataProviderClass = OpenIslamicSavingsAccountData.class)
	public void test(String menu, String username, String password, String val) throws Exception {
		
		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextfield(username)
		.sendKeysPasswordTextfield(password)
		.clickOnLoginButton(password);
		
		AssertionFactory.assertTrue(driver, true, this.getClass().getCanonicalName());
        OpenSavingsAccountProcedures OSAP = new OpenSavingsAccountProcedures();
        OSAP.IslamicSavingsAccount_Maker(driver, menu, val);
		AssertionFactory.assertTrue(driver, true, this.getClass().getCanonicalName());		
	}
	
	@AfterMethod
	public void after() {
		driver.quit();
	}
}