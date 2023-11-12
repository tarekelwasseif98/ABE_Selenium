package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyCurrentAccountOpeningMudarabahCAAPage {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId = By.xpath("//iframe[@name='formArea']");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_tempAcid'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By additionalDetailsSideTab = By.xpath("(//span[@id='stepII_textSpan'])[1]");
	private By profitDetailsSideTab = By.xpath("(//span[@id='stepII1_textSpan'])[1]");  
	private By taxDetailsSideTab = By.xpath("(//span[@id='stepII2_textSpan'])[1]");
	private By schemeDetailsSideTab = By.xpath("(//span[@id='stepII3_textSpan'])[1]");
	private By relatedPartyDetailsSideTab = By.xpath("(//span[@id='stepII5_textSpan'])[1]");
	private By generalDetailsSideTab = By.xpath("(//span[@id='stepII7_textSpan'])[1]");
	private By misDetailsSideTab = By.xpath("(//span[@id='stepII16_textSpan'])[1]");
	private By menuNameTextBox = By.xpath("(//h1[normalize-space()='Verify Islamic Current Account Opening'])[1]");

	public ABEVerifyCurrentAccountOpeningMudarabahCAAPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyCurrentAccountOpeningMudarabahCAAPage sendKeysSearchBarTextField(String menu) throws Exception {
		if(menu != null) {
			PageFunctionUtils.sleep();
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
			PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);	       
	        WebDriverWait wait = new WebDriverWait(driver, 45);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
		        }
	        catch (Exception e) {
	        }
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEVerifyCurrentAccountOpeningMudarabahCAAPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;	
	}
	
	@Step("Sending account id: {0}")
	public ABEVerifyCurrentAccountOpeningMudarabahCAAPage sendKeysAccountIdTextField(String accountId) throws Exception {
		if(accountId != null) {
			PageFunctionUtils.waitOnElement(driver, accountIdTextField);
			PageFunctionUtils.clickOnElement(driver, accountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEVerifyCurrentAccountOpeningMudarabahCAAPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Side tab navigation")
	public ABEVerifyCurrentAccountOpeningMudarabahCAAPage navigateSideTabMenu() throws Exception {
		PageFunctionUtils.clickOnElement(driver, additionalDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, profitDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, taxDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, schemeDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, relatedPartyDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, generalDetailsSideTab);
		PageFunctionUtils.clickOnElement(driver, misDetailsSideTab);
		return this;
	}
	
	@Step("Press submit button")
	public ABEVerifyCurrentAccountOpeningMudarabahCAAPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		PageFunctionUtils.scrollUpToElement(driver, menuNameTextBox);
		return this;
	}
}