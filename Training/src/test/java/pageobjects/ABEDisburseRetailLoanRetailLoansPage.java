package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEDisburseRetailLoanRetailLoansPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By accountIdTextField= By.xpath("(//input[@id='_acctNum'])[1]");
	private By goButton= By.xpath("(//button[normalize-space()='Go'])[1]");
	private By transferRadioButton= By.xpath("(//input[@id='_tranTypetransfer_radio'])[1]");
	private By grossDisbursmentRadioButton= By.xpath("(//input[@id='_grossDisb_radio'])[1]");
	private By netDisbursmentRadioButton= By.xpath("(//input[@id='_netDisb_radio'])[1]");
	private By FullDisbursmentRadioButton= By.xpath("(//input[@id='_finalDisbFlgYes_radio'])[1]");
	private By PartialDisbursmentRadioButton= By.xpath("(//input[@id='_finalDisbFlgNo_radio'])[1]");
	private By DisbursmentDetailscontinueButton= By.xpath("(//button[@id='_disbursedet_BContinue'])[1]");
	private By additionalDetailscontinueButton= By.xpath("(//button[@id='_adddet_continueBt'])[1]");
	private By addButton= By.xpath("(//span[@id='_dg_trdisbmoddet_AddRecBtn_label'])[1]");
	private By disbursmentAccountTextField= By.xpath("(//input[@id='_trdisbmode_extAccountId'])[1]");
	private By saveAndPreviewButton= By.xpath("(//button[normalize-space()='Save and Preview'])[1]");
	public static String SuccessMessages;
	private By SuccessMessage = By.xpath("(//p[@id='_disbresult_resultmsg_paraMsg'])[1]");
	private By disbursmentModeContinueButton= By.xpath("(//button[@id='_disbmoddet_continue'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");

	public ABEDisburseRetailLoanRetailLoansPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEDisburseRetailLoanRetailLoansPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEDisburseRetailLoanRetailLoansPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending Loan id: {0}")
	public ABEDisburseRetailLoanRetailLoansPage sendKeysAccoundId(String accountId ) throws Exception {
		
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		PageFunctionUtils.clickOnElement(driver,accountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,accountIdTextField,accountId.substring(1));
		PageFunctionUtils.clickOnElement(driver,goButton);

		return this;
	}
	
	@Step("Select Transfer Radio Button")
	public ABEDisburseRetailLoanRetailLoansPage SelectTransferRadioButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, transferRadioButton);
		return this;
	}
	
	@Step("Select Gross Disbursment Radio Button")
	public ABEDisburseRetailLoanRetailLoansPage SelectGrossDisbursmentRadioButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, grossDisbursmentRadioButton);
		return this;
	}
	
	@Step("Select Net Disbursment Radio Button")
	public ABEDisburseRetailLoanRetailLoansPage SelectNetDisbursmentRadioButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, netDisbursmentRadioButton);
		return this;
	}
	
	@Step("Select Full Disbursment Radio Button")
	public ABEDisburseRetailLoanRetailLoansPage SelectFullDisbursmentRadioButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, FullDisbursmentRadioButton);
		return this;
	}
	
	@Step("Select partial Disbursment Radio Button")
	public ABEDisburseRetailLoanRetailLoansPage SelectPartialDisbursmentRadioButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, PartialDisbursmentRadioButton);
		return this;
	}
	
	@Step("press Disbursment details Continue Button")
	public ABEDisburseRetailLoanRetailLoansPage PressDisbursmentDetailsContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, DisbursmentDetailscontinueButton);
		return this;
	}
	
	@Step("Select additional details Radio Button")
	public ABEDisburseRetailLoanRetailLoansPage pressAdditionalDetailsButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, additionalDetailscontinueButton);
		return this;
	}
	
	@Step("Press add Button")
	public ABEDisburseRetailLoanRetailLoansPage PressAddButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, addButton);
		return this;
	}
	
	@Step("Send keys disbursment Account")
	public ABEDisburseRetailLoanRetailLoansPage sendKeysDisbursmentAccount(String disbursmentAccount) throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentAccountTextField);
		PageFunctionUtils.enterDataInWebElement(driver, disbursmentAccountTextField,disbursmentAccount.substring(1));
		return this;
	}
	
	@Step("Press save And Preview Button")
	public ABEDisburseRetailLoanRetailLoansPage PressSaveAndPreviewButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, saveAndPreviewButton);
		return this;
	}
	
	@Step("Press disbursment Mode Continue Button")
	public ABEDisburseRetailLoanRetailLoansPage PressDisbursmentModeContinueButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, disbursmentModeContinueButton);
		return this;
	}
	
	@Step("Press submit Button")
	public ABEDisburseRetailLoanRetailLoansPage PressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		SuccessMessages = driver.findElement(SuccessMessage).getText();
		System.out.println( SuccessMessages);
		return this;
	}
	
	
	
}
