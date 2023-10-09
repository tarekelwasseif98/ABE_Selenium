package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class VerifyCloseIslamicCasaAccountPage {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_acctId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");	
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");


	public VerifyCloseIslamicCasaAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public VerifyCloseIslamicCasaAccountPage sendKeysSearchBarTextField(String menu) throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
		driver.switchTo().frame((loginFrameIframeId));
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
	public VerifyCloseIslamicCasaAccountPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame((loginFrameIframeId));
	    driver.switchTo().frame((coreAbeIframeId));
	    driver.switchTo().frame((uxIframeId));
		PageFunctionUtils.waitOnElement(driver, but);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;
	}
	
	@Step("Sending a/c. id: {0}")
	public VerifyCloseIslamicCasaAccountPage sendKeysAccountIdTextField(String accountId) throws Exception {
		accountId = accountId.substring(1);
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		driver.findElement(accountIdTextField).click();
		driver.findElement(accountIdTextField).sendKeys(accountId);
		driver.findElement(goButton).click();		
		return this;
	}
	
	@Step("Press submit button")
	public VerifyCloseIslamicCasaAccountPage pressSubmitButton() throws Exception {
		driver.findElement(submitButton).click();
		return this;
	}
}