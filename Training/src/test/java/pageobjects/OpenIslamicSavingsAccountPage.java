package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class OpenIslamicSavingsAccountPage {
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By cifIdTextField = By.xpath("(//input[@id='_critCif'])[1]");
	private By schemeCodeTextField = By.xpath("(//input[@id='_critSchmCode'])[1]");
	private By solIdTextField = By.xpath("(//input[@id='_solId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By continueButton = By.xpath("(//button[@id='_acctDetCon'])[1]");
	private By taxDetailsMenu = By.xpath("(//a[@id='stepII10_anchor'])[1]");
	private By taxCategoryMenu = By.id("_wtaxFlg_select");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By accountIdSuccessMessage = By.xpath("(//p[@id='_resMsg_paraMsg'])[1]");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	public static String acid;
	public static String  referenceCsvColumnName = "reference";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public OpenIslamicSavingsAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public OpenIslamicSavingsAccountPage sendKeysSearchBarTextField(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.waitOnFrameAndSwitch(driver, loginFrameIframeID);
			PageFunctionUtils.waitOnElement(driver, searchBarTextField);
	        PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            PageFunctionUtils.enterDataInWebElement(driver, searchBarTextField, menu);
		        PageFunctionUtils.clickOnElement(driver, searchButton);
	        } catch (NoAlertPresentException e) {
	        }
	        return this;        
	}
	
	@Step("Frame switching")
	public OpenIslamicSavingsAccountPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitch(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending customer details: {0}")
	public OpenIslamicSavingsAccountPage sendKeysAccoundID(String cifid) throws Exception {
		PageFunctionUtils.waitOnElement(driver, cifIdTextField);
		driver.findElement(cifIdTextField);
		driver.findElement(cifIdTextField).click();
		driver.findElement(cifIdTextField).sendKeys(cifid);
		driver.findElement(cifIdTextField);
		driver.findElement(schemeCodeTextField).click();
		driver.findElement(schemeCodeTextField).sendKeys("1700");
		driver.findElement(solIdTextField);
		driver.findElement(solIdTextField).click();
		driver.findElement(solIdTextField).clear();
		driver.findElement(solIdTextField).sendKeys("2588");
		driver.findElement(goButton);
		driver.findElement(goButton).click();
		driver.findElement(continueButton);
		driver.findElement(continueButton).click();
		driver.findElement(taxDetailsMenu);
		driver.findElement(taxDetailsMenu).click();
		Select dropdown = new Select(driver.findElement(taxCategoryMenu));
		dropdown.selectByIndex(2);
		return this;
	}
	
	@Step("Press submit button")
	public OpenIslamicSavingsAccountPage pressSubmitButton() throws Exception {
		driver.findElement(submitButton);
		driver.findElement(submitButton).click();
		Thread.sleep(3500);
		acid = driver.findElement(accountIdSuccessMessage).getText().substring(53, 71);
		System.out.println("ACID: "+ acid);
		return this;
	}
	
	@Step("Save a/c. id")
	public OpenIslamicSavingsAccountPage saveAccountId(String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.OpenIslamicSavingsAccountCsv, linkedTcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.OpenIslamicSavingsAccountCsv, referenceCsvColumnName);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyIslamicSavingsAccountCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyIslamicSavingsAccountCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.OpenIslamicSavingsAccountCsv, rowByTcid1, columnByColumnName1, acid);
			CSVUtils.insertValueInCsvCell(Paths.VerifyIslamicSavingsAccountCsv, rowByTcid2, columnByColumnName2, acid);
		}
		return this;
	}												
}