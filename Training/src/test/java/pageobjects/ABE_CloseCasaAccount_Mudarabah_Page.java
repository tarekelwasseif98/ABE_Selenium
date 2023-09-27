package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABE_CloseCasaAccount_Mudarabah_Page {

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
	private By transferBalanceRadioButton = By.xpath("(//input[@id='_trfrYes_radio'])[1]");
	private By transactionTypeMenu = By.id("_tranType_select");
	private By transferAccountIdTextField = By.xpath("(//input[@id='_trfrActId'])[1]");
	public static By acId = By.xpath("(//div[@id='_resActId1_text'])[1]");
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";

	public ABE_CloseCasaAccount_Mudarabah_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABE_CloseCasaAccount_Mudarabah_Page sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABE_CloseCasaAccount_Mudarabah_Page switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame((loginFrameIframeId));
	    driver.switchTo().frame((coreAbeIframeId));
	    driver.switchTo().frame((uxIframeId));
		PageFunctionUtils.waitOnElement(driver, but);
		PageFunctionUtils.waitOnFrameAndSwitch(driver, formAreaIframeID);
		return this;
	}
	
	@Step("Sending a/c. id: {0}")
	public ABE_CloseCasaAccount_Mudarabah_Page sendKeysAccountIdTextField(String accountId) throws Exception {
		accountId = accountId.substring(1);
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		driver.findElement(accountIdTextField).click();
		driver.findElement(accountIdTextField).sendKeys(accountId);
		driver.findElement(goButton).click();		
		return this;
	}
	
	@Step("Sending trasfer a/c. id: {0}")
	public ABE_CloseCasaAccount_Mudarabah_Page sendKeystransferAccountIdTextField(String transferAccountId) throws Exception {
		transferAccountId = transferAccountId.substring(1);
		driver.findElement(transferBalanceRadioButton).click();
		Select dropdown = new Select(driver.findElement(transactionTypeMenu));
		dropdown.selectByIndex(2);
		driver.findElement(transferAccountIdTextField).click();
		driver.findElement(transferAccountIdTextField).sendKeys(transferAccountId);
		return this;
	}
	
	@Step("Press submit button")
	public ABE_CloseCasaAccount_Mudarabah_Page pressSubmitButton() throws Exception {
		driver.findElement(submitButton).click();
		return this;
	}
	
	@Step("Save a/c. id")
	public ABE_CloseCasaAccount_Mudarabah_Page saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.CloseIslamicCasaAccountCsv, linkedTcidCsvColumnName, linkedId);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyCloseIslamicCasaAccountCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyCloseIslamicCasaAccountCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.VerifyCloseIslamicCasaAccountCsv, rowByTcid2, columnByColumnName2, driver.findElement(acId).getText().substring(1));
		}
		return this;
	}
}