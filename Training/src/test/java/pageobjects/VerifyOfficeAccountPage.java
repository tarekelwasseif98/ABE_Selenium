package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class VerifyOfficeAccountPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By acidTextField = By.xpath("(//input[@id='_acctId'])[1]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");

	public VerifyOfficeAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public VerifyOfficeAccountPage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, loginFrameIframeID);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
	        PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
	        } catch (Exception e) {
	        }
	        return this;        
	}
	
	@Step("Frame switching")
	public VerifyOfficeAccountPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}

	@Step("Sending a/c. id: {0}")
	public VerifyOfficeAccountPage sendKeysAcidTextField(String ACID) throws Exception {
		ACID = ACID.substring(1);
		PageFunctionUtils.waitOnElement(driver, acidTextField);
		driver.findElement(acidTextField).click();
		driver.findElement(acidTextField).sendKeys(ACID);
		driver.findElement(GoButton).click();
		Thread.sleep(3000);
		return this;
	}
	
	@Step("Press submit button")
	public VerifyOfficeAccountPage pressSubmitButton() throws Exception {
		driver.findElement(submitButton).click();
		return this;
	}
	
	


}
