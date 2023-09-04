package tests;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import data.VerifyIslamicSavingsAccountData;
import pageobjects.FinacleLoginPage;
import procedures.VerifyIslamicsavingsAccountProcedures;
import utils.AssertionFactory;
import utils.Properties;
import utils.WebdriverFactory;

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
	
	@Test(dataProvider = "VerifyIslamicSavingsAccountDataProvider", description="FCB-9792", dataProviderClass = VerifyIslamicSavingsAccountData.class)
	public void test(String menu, String username, String password, String val) throws Exception {

		FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
		FinacleLoginPage
		.sendKeysUserNameTextfield(username)
		.sendKeysPasswordTextfield(password)
		.clickOnLoginButton(password);
		
		AssertionFactory.assertTrue(driver, true, this.getClass().getCanonicalName());
		VerifyIslamicsavingsAccountProcedures VISAO = new VerifyIslamicsavingsAccountProcedures();
		VISAO.navigateToVerifyIslamicSavingsAccountPage(driver, menu, val);
		AssertionFactory.assertTrue(driver, true, this.getClass().getCanonicalName());
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}
}