package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyCorporateLoanCorporateLoansPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_tempForacid'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By backgroundMenuButton = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_btn_continueBasic'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_btn_continueLoandet'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_btn_continueRelP'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_btn_continueint'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_btn_continueFee'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_btn_continueRepayParm'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_btn_continueRepaySchdet'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_btn_continueRepIns'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_btn_continuedisb'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_btn_continueloanaddnl'])[1]");
	private By continue11Button = By.xpath("(//button[@id='_btn_continueDoc'])[1]");
	private By continue12Button = By.xpath("(//button[@id='_btn_continueMisc'])[1]");
	private By continue13Button = By.xpath("(//button[@id='_btn_continueacctlmts'])[1]");
	private By continue14Button = By.xpath("(//button[@id='_btn_continueIntNot'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");

	public ABEVerifyCorporateLoanCorporateLoansPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyCorporateLoanCorporateLoansPage sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnElement(driver, searchBarTextField);
		PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
        PageFunctionUtils.clickOnElement(driver, searchButton);	       
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        }
        catch (Exception e) {
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEVerifyCorporateLoanCorporateLoansPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnElement(driver, backgroundMenuButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;	
	}
	
	@Step("Sending a/c. id: {0}")
	public ABEVerifyCorporateLoanCorporateLoansPage sendKeysAccountIdTextField(String accountId) throws Exception {
		accountId = accountId.substring(1);
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		PageFunctionUtils.clickOnElement(driver, accountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId);
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Side tab navigation")
	public ABEVerifyCorporateLoanCorporateLoansPage navigateSideMenuTab() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		PageFunctionUtils.clickOnElement(driver, continue11Button);
		PageFunctionUtils.clickOnElement(driver, continue12Button);
		PageFunctionUtils.clickOnElement(driver, continue13Button);
		PageFunctionUtils.clickOnElement(driver, continue14Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABEVerifyCorporateLoanCorporateLoansPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.sleep();
		return this;
	}
}