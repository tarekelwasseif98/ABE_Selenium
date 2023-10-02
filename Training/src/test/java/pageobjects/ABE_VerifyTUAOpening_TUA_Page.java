package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABE_VerifyTUAOpening_TUA_Page {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_modacctid'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By warningAcceptButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	private String loginFrameIframeID = "loginFrame";
	private By backgroundMenuButton = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private String additionalDetailsSideTab = "(//span[@id='stepIII_textSpan'])[1]";
	private String generalDetailsSideTab = "(//span[@id='stepIV_textSpan'])[1]";
	private String schemeDetailsSideTab = "(//span[@id='stepV_textSpan'])[1]";
	private String profitAndTaxDetailsSideTab = "(//span[@id='stepVI_textSpan'])[1]";
	private String relatedPartyDetailsSideTab = "(//span[@id='stepVII_textSpan'])[1]";
	private String renewalAndClosureDetailsSideTab = "(//span[@id='stepVIII_textSpan'])[1]";	
	private String paymentInstructionsDetailsSideTab = "(//span[@id='stepIX_textSpan'])[1]";
	private String flowDetailsSideTab = "(//span[@id='stepX_textSpan'])[1]";
	private String documentDetailsSideTab = "(//span[@id='stepXII_textSpan'])[1]";
	private String misCodeDetailsSideTab = "(//span[@id='stepXIII_textSpan'])[1]";
	private String otherDetailsSideTab = "(//span[@id='stepXIV_textSpan'])[1]";

	public ABE_VerifyTUAOpening_TUA_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABE_VerifyTUAOpening_TUA_Page sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABE_VerifyTUAOpening_TUA_Page switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame((loginFrameIframeId));
	    driver.switchTo().frame((coreAbeIframeId));
	    driver.switchTo().frame((uxIframeId));
		PageFunctionUtils.waitOnElement(driver, backgroundMenuButton);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending a/c. id: {0}")
	public ABE_VerifyTUAOpening_TUA_Page sendKeysAccountIdTextField(String accountId) throws Exception {
		accountId = accountId.substring(1);
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		driver.findElement(accountIdTextField).click();
		driver.findElement(accountIdTextField).sendKeys(accountId);
		driver.findElement(goButton).click();
		return this;
	}
	
	@Step("Side tab navigation")
	public ABE_VerifyTUAOpening_TUA_Page navigateSideMenuTab() throws Exception {
		driver.findElement(By.xpath(additionalDetailsSideTab)).click();
		driver.findElement(By.xpath(generalDetailsSideTab)).click();
		driver.findElement(By.xpath(schemeDetailsSideTab)).click();
		driver.findElement(By.xpath(profitAndTaxDetailsSideTab)).click();
		driver.findElement(By.xpath(relatedPartyDetailsSideTab)).click();
		driver.findElement(By.xpath(renewalAndClosureDetailsSideTab)).click();
		driver.findElement(By.xpath(paymentInstructionsDetailsSideTab)).click();
		driver.findElement(By.xpath(flowDetailsSideTab)).click();
		driver.findElement(By.xpath(documentDetailsSideTab)).click();
		driver.findElement(By.xpath(misCodeDetailsSideTab)).click();
		driver.findElement(By.xpath(otherDetailsSideTab)).click();
		return this;
	}
	
	@Step("Press submit button")
	public ABE_VerifyTUAOpening_TUA_Page pressSubmitButton() throws Exception {
		driver.findElement(submitButton).click();
		driver.switchTo().parentFrame();
		Boolean isPresent1 = driver.findElements(warningAcceptButton).size() > 0;
		if(isPresent1) {
			driver.findElement(warningAcceptButton).click();
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			driver.switchTo().parentFrame();
			Boolean isPresent2 = driver.findElements(warningAcceptButton).size() > 0;
			if(isPresent2) {
				driver.findElement(warningAcceptButton).click();
				PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			}
			else {
				PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
			}
		}
		else {
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		}
		PageFunctionUtils.sleep();
		return this;
	}
}