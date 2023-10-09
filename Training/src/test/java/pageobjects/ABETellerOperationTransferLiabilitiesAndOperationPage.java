package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.Paths;


public class ABETellerOperationTransferLiabilitiesAndOperationPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private String type = "Customer Induced";
	public static String  referenceCsvColumnName = "reference";
	private By transactionIdMessage = By.xpath("(//div[@id='_tranIDRes_text'])[1]");
	private By transactionTypeDropDown = By.xpath("//*[@id=\"_trantype_subtype_select\"]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By addButton = By.xpath("(//span[@id='_tranSummary_AddRecBtn_label'])[1]");
	private By AccountIdTextField = By.xpath("(//input[@id='_df_acctId'])[1]");
	private By debitRadioButton = By.xpath("(//input[@id='_parttranpmr_rbDebit_radio'])[1]");
	private By creditRadioButton = By.xpath("(//input[@id='_parttranpmr_rbCredit_radio'])[1]");
	private By transactionAmmountTextField = By.xpath("(//input[@id='_df_txnAmt$amt'])[1]");
	private By transactionCTextField = By.xpath("(//input[@id='_txnCurrency'])[1]");
	private By saveAndAddNewButton = By.xpath("(//button[@id='_parttranpmr_addCreateNew'])[1]");
	private By saveAndPreview = By.xpath("(//button[@id='_parttranpmr_addViewSummary'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By AcceptButton = By.xpath("(//button[normalize-space()='Accept'])[1]");
	public static String transactionId;
	public static String TcidCsvColumnName = "tcId";

	
	
	
	public ABETellerOperationTransferLiabilitiesAndOperationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABETellerOperationTransferLiabilitiesAndOperationPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending Transaction Type: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendTransactionType() throws Exception {
		
		PageFunctionUtils.clickAction(driver,transactionTypeDropDown);
		Select transactionTypeDropDownSelector = new Select(driver.findElement(transactionTypeDropDown));
		transactionTypeDropDownSelector.selectByVisibleText(type);
		PageFunctionUtils.clickAction(driver,GoButton);
		PageFunctionUtils.clickAction(driver,addButton);

		return this;
	}
	

	@Step("Sending Debitor Details: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendDebitorDetails(String accountIdDr, String ccyDr, String transactionAmount ) throws Exception {
	
		PageFunctionUtils.waitOnElement(driver, AccountIdTextField);
		PageFunctionUtils.clickAction(driver,debitRadioButton);
		PageFunctionUtils.clickAction(driver,AccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, AccountIdTextField, accountIdDr.substring(1));
		PageFunctionUtils.clickAction(driver,transactionAmmountTextField);
		driver.findElement(transactionAmmountTextField).clear();

		PageFunctionUtils.enterDataInWebElement(driver, transactionAmmountTextField, transactionAmount);		
		PageFunctionUtils.clickAction(driver,transactionCTextField);
		PageFunctionUtils.enterDataInWebElement(driver, transactionCTextField, ccyDr);
		PageFunctionUtils.clickAction(driver,saveAndAddNewButton);


		return this;
	}
	
	@Step("Sending Creditor Details: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage sendCreditorDetails(String accountIdCr, String ccyCr, String transactionAmount ) throws Exception {
	
		PageFunctionUtils.waitOnElement(driver, AccountIdTextField);
		PageFunctionUtils.clickAction(driver,creditRadioButton);
		PageFunctionUtils.clickAction(driver,AccountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, AccountIdTextField, accountIdCr.substring(1));
		PageFunctionUtils.clickAction(driver,transactionAmmountTextField);
		driver.findElement(transactionAmmountTextField).clear();
		PageFunctionUtils.enterDataInWebElement(driver, transactionAmmountTextField, transactionAmount);		
		PageFunctionUtils.clickAction(driver,transactionCTextField);
		PageFunctionUtils.enterDataInWebElement(driver, transactionCTextField, ccyCr);
		PageFunctionUtils.clickAction(driver,saveAndPreview);


		return this;
	}
	
	@Step("Press Submit Button: {0}")
	public ABETellerOperationTransferLiabilitiesAndOperationPage saveTransactionId(String linkedId) throws Exception {
	
		
		PageFunctionUtils.clickAction(driver,submitButton);
		driver.switchTo().parentFrame();
		PageFunctionUtils.clickAction(driver,AcceptButton);
		PageFunctionUtils.scrollUp(driver);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		transactionId = driver.findElement(transactionIdMessage).getText();
		System.out.println("transaction id: "+ transactionId);
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABETellerOperationTransferLiabilitiesAndOperationCsv, TcidCsvColumnName, linkedId);
		int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABETellerOperationTransferLiabilitiesAndOperationCsv, referenceCsvColumnName);
		CSVUtils.insertValueInCsvCell(Paths.ABETellerOperationTransferLiabilitiesAndOperationCsv, rowByTcid1, columnByColumnName1, transactionId);

		return this;
	}

}
