package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class VerifyIslamicSavingsAccountPage {

	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_tempAcid'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By acceptAlertButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private String loginFrameIframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String sideTab1 = "//a[@id='stepII_anchor']";
	private String sideTab2 = "(//a[@id='stepII4_anchor'])[1]";  
	private String sideTab3 = "(//a[@id='stepII10_anchor'])[1]";
	private String sideTab4 = "(//a[@id='stepII5_anchor'])[1]";
	private String sideTab5 = "(//a[@id='stepII7_anchor'])[1]";
	private String sideTab6 = "(//a[@id='stepII3_anchor'])[1]";
	private String sideTab7 = "(//a[@id='stepII1_anchor'])[1]";
	private String sideTab8 = "(//a[@id='stepII19_anchor'])[1]";

	public VerifyIslamicSavingsAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public VerifyIslamicSavingsAccountPage sendKeysMenuName(String menu) throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
		driver.switchTo().frame((loginFrameIframeID));
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
	public VerifyIslamicSavingsAccountPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnElement(driver, but);
		PageFunctionUtils.waitOnFrameAndSwitch(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending a/c. id: {0}")
	public VerifyIslamicSavingsAccountPage sendKeysAccountIdTextField(String accountId) throws Exception {
		accountId = accountId.substring(1, 19);
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		driver.findElement(accountIdTextField).click();
		driver.findElement(accountIdTextField).sendKeys(accountId);
		driver.findElement(goButton).click();
		return this;
	}
	
	@Step("Side tab navigation")
	public VerifyIslamicSavingsAccountPage navigateSideMenuTab() throws Exception {
		driver.findElement(By.xpath(sideTab1)).click();
		driver.findElement(By.xpath(sideTab2)).click();
		driver.findElement(By.xpath(sideTab3)).click();
		driver.findElement(By.xpath(sideTab4)).click();
		driver.findElement(By.xpath(sideTab5)).click();
		driver.findElement(By.xpath(sideTab6)).click();
		driver.findElement(By.xpath(sideTab7)).click();
		driver.findElement(By.xpath(sideTab8)).click();
		return this;
	}
	
	@Step("Press submit button")
	public VerifyIslamicSavingsAccountPage pressSubmitButton() throws Exception {
		driver.findElement(submitButton).click();
	    driver.switchTo().parentFrame();
		driver.findElement(acceptAlertButton).click();
		return this;
	}
}