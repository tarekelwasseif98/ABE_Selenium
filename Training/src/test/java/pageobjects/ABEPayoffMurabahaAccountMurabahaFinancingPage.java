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

public class ABEPayoffMurabahaAccountMurabahaFinancingPage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId = By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By accountIdTextField = By.xpath("(//input[@id='_laAcct'])[1]");
	private By payoffValueDateTextField = By.xpath("(//input[@id='_payOffValueDate'])[1]");
	private By transactionTypeDropDownList = By.xpath("(//select[@id='_tranType_select'])[1]");
	private By refundAccountIdTextField = By.xpath("(//input[@id='_collAcct'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_cont_fee'])[1]");
	private By closeButton = By.xpath("(//span[@id='modalCloseIcon'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_cont'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	public static String acId;
	public static String  murabahaAccountId = "murabahaAccountId";
	public static String  accountIdCsvColumnName = "accountId";
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidCsvColumnName = "linkedTcid";
	
	public ABEPayoffMurabahaAccountMurabahaFinancingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage sendKeysSearchBarTextField(String menu) throws Exception {
		if(menu != null) {
			PageFunctionUtils.sleep();
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
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
        }
	return this;
	}
	
	@Step("Frame switching")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending account id: {0}")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage sendKeysAccountIdTextField(String accountId) throws Exception {
		if(accountId != null) {
			PageFunctionUtils.waitOnElement(driver, accountIdTextField);
			PageFunctionUtils.clickOnElement(driver, accountIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
		}
		return this;
	}
	
	@Step("Sending payoff value date: {0}")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage sendKeysPayoffValueDateTextField(String payoffValueDate) throws Exception {
		if(payoffValueDate != null) {
			PageFunctionUtils.clearDataInWebElement(driver, payoffValueDateTextField);
			PageFunctionUtils.clickOnElement(driver, payoffValueDateTextField);
			PageFunctionUtils.enterDataInWebElement(driver, payoffValueDateTextField, payoffValueDate.substring(1));
		}
		return this;
	}
	
	@Step("Select transaction type")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage selectTransactionType() throws Exception {
		PageFunctionUtils.selectDropDownListByIndex(driver, transactionTypeDropDownList, 2);
		return this;
	}
	
	@Step("Sending refund account id: {0}")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage sendKeysRefundAccountIdTextField(String refundAccountId) throws Exception {
		if(refundAccountId != null) {
			PageFunctionUtils.enterDataInWebElement(driver, refundAccountIdTextField, refundAccountId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		try {
			PageFunctionUtils.clickOnElement(driver, goButton);
		} catch (Exception e) {
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage pressContinue1Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		return this;
	}
	
	@Step("Press continue button")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage pressContinue2Button() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	
	@Step("Press submit button")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		return this;
	}
	
	@Step("Save account id")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage saveAccountId(String accountId, String linkedId) throws Exception {
		int rowByTcid1 = CSVUtils.getRowByTcid(Paths.PayoffMurabahaAccountCsv, linkedTcidCsvColumnName, linkedId);
		int rowByTcid2 = CSVUtils.getRowByTcid(Paths.VerifyMurabahaAccountPayoffCsv, tcIdCsvColumnName, linkedId);
		int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.VerifyMurabahaAccountPayoffCsv, accountIdCsvColumnName);
		if(rowByTcid1 != -1 && rowByTcid2 != -1) {
			CSVUtils.insertValueInCsvCell(Paths.VerifyMurabahaAccountPayoffCsv, rowByTcid2, columnByColumnName2, accountId);
		}
		return this;
	}												
}