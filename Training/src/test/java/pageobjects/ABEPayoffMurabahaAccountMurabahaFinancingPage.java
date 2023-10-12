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
	
	@Step("Sending payoff details: {0}")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage sendKeysPayoffDetails(String accountId, String payoffValueDate, String refundAccountId) throws Exception {
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		PageFunctionUtils.clickOnElement(driver, accountIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
		PageFunctionUtils.clearDataInWebElement(driver, payoffValueDateTextField);
		PageFunctionUtils.clickOnElement(driver, payoffValueDateTextField);
		PageFunctionUtils.enterDataInWebElement(driver, payoffValueDateTextField, payoffValueDate.substring(1));
		PageFunctionUtils.selectDropDownListByIndex(driver, transactionTypeDropDownList, 2);
		PageFunctionUtils.enterDataInWebElement(driver, refundAccountIdTextField, refundAccountId.substring(1));
		PageFunctionUtils.clickOnElement(driver, goButton);
		try {
			PageFunctionUtils.clickOnElement(driver, goButton);
		} catch (Exception e) {
		}
		return this;
	}
	
	@Step("Side tab navigation")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage navigateSideMenuTab() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		try {
			PageFunctionUtils.switchToParentFrame(driver);
			PageFunctionUtils.clickOnElement(driver, closeButton);
			PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
        } catch (Exception e) {
        	PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		}
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	
	@Step("Press submit button")
	public ABEPayoffMurabahaAccountMurabahaFinancingPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.acceptWarning(driver);
		return this;
	}
	
	@Step("Save a/c. id")
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