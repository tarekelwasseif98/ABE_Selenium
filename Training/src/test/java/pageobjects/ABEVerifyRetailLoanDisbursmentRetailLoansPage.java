package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class ABEVerifyRetailLoanDisbursmentRetailLoansPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By acidTextField = By.xpath("(//input[@id='_acctNum'])[1]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By DisbursmentDetailscontinueButton= By.xpath("(//button[@id='_disbursedet_BContinue'])[1]");
	private By disbursmentModeContinueButton= By.xpath("(//button[@id='_disbmoddet_continue'])[1]");
	private By additionalDetailsContinueButton= By.xpath("(//button[@id='_adddet_continueBt'])[1]");

	public static String transactionId;
	private By transactionIdSuccessMessage = By.xpath("(//div[@id='_disbresult_tranId_text'])[1]");
	public static String  TcidCsvColumnName = "tcId";
	public static String  referenceCsvColumnName = "transactionId";


	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending a/c. id: {0}")
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage sendKeysAcidTextField(String acId) throws Exception {
		acId = acId.substring(1);
		PageFunctionUtils.waitOnElement(driver, acidTextField);
		driver.findElement(acidTextField).click();
		driver.findElement(acidTextField).sendKeys(acId);
		driver.findElement(GoButton).click();
		return this;
	}
	
	@Step("press Disbursment details Continue Button")
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage PressDisbursmentDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, DisbursmentDetailscontinueButton);
		return this;
	}
	
	@Step("Press disbursment Mode Continue Button")
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage PressDisbursmentModeContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentModeContinueButton);
		return this;
	}
	@Step("Press additional details Continue Button")
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage additionalDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, additionalDetailsContinueButton);
		return this;
	}
	
	
	@Step("Press submit Button")
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage PressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		transactionId = driver.findElement(transactionIdSuccessMessage).getText();
		System.out.println("transaction id: "+ transactionId);
		return this;
	}
	
	@Step("Save transaction id")
	public ABEVerifyRetailLoanDisbursmentRetailLoansPage saveTransactionId(String tcId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSCSV, TcidCsvColumnName, tcId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSCSV, referenceCsvColumnName);
		CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYRETAILLOANDISBURSMENTRETAILLOANSCSV, rowByTcid1, columnByColumnName1, transactionId);

		return this;
	}		
	

}
