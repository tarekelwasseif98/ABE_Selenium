package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.FinacleFieldsUtils;
import utils.PageFunctionUtils;

public class ABEVerifyExportBillsTradeFinancePage {
	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeId =By.xpath("//iframe[@name='formArea']"); 
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By billIdTextField = By.xpath("(//input[@id='_billIdOthers'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By continue1Button = By.xpath("(//button[@id='_meobgen_meobgen_FinButton1'])[1]");
	private By continue2Button = By.xpath("(//button[@id='_meobparty_meobparty_FinButton1'])[1]");
	private By continue3Button = By.xpath("(//button[@id='_meobtenor_continue'])[1]");
	private By tenorDetailsViewButton1 = By.xpath("(//span[@class='viewcontent'])[1]");
	private By tenorDetailsViewButton2 = By.xpath("(//span[@class='viewcontent'])[2]");
	private By billTenorDropDownList = By.xpath("//*[@id=\"_billTenor_select\"]");
	private By tenorDetailsBillIdTextField = By.xpath("//*[@id=\"_tenor_BillId\"]");
	private By tenorDetailsCloseButton = By.xpath("(//button[@id='_tenordetails_closeBtn'])[1]");
	private By continue4Button = By.xpath("(//button[@id='_meobbill_meobbill_FinButton1'])[1]");
	private By continue5Button = By.xpath("(//button[@id='_meobassign_FinButton1'])[1]");
	private By continue6Button = By.xpath("(//button[@id='_margin_margin_Continue'])[1]");
	private By continue7Button = By.xpath("(//button[@id='_meoblimit_meoblimit_FinButton1'])[1]");
	private By continue8Button = By.xpath("(//button[@id='_meobevent_eventdet_FinButton1'])[1]");
	private By continue9Button = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
	private By continue10Button = By.xpath("(//button[@id='_dclatercharge_charge_Continue'])[1]");
	private By continue11Button = By.xpath("(//button[@id='_meobtran_meobtran_FinButton1'])[1]");
	private By continue12Button = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
	private By continue13Button = By.xpath("(//button[@id='_meobtracer_tracerdet_FinButton1'])[1]");
	private By continue14Button = By.xpath("(//button[@id='_meobmisc_meobmisc_FinButton1'])[1]");
	private By continue15Button = By.xpath("(//button[@id='_meobaddn_meobaddn_FinButton1'])[1]");
	private By continue16Button = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
	private By continue17Button = By.xpath("(//button[@id='_meobpur_meobpur_FinButton1'])[1]");
	private By continue18Button = By.xpath("(//button[@id='_meobhistory_his_Continue'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	public static String mixedBillAccountId1;
	public static String mixedBillAccountId2;
	public static String mixedBillTenor1;
	public static String mixedBillTenor2;
	
	public ABEVerifyExportBillsTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyExportBillsTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyExportBillsTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeId);
		return this;		
	}
	
	@Step("Sending bill id: {0}")
	public ABEVerifyExportBillsTradeFinancePage sendKeysBillIdTextField(String billId) throws Exception {
		if(billId != null) {
			PageFunctionUtils.waitOnElement(driver, billIdTextField);
			PageFunctionUtils.clickOnElement(driver, billIdTextField);
			PageFunctionUtils.enterDataInWebElement(driver, billIdTextField, billId.substring(1));
		}
		return this;
	}
	
	@Step("Press go button")
	public ABEVerifyExportBillsTradeFinancePage pressGoButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver, goButton);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue1Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue1Button);
		PageFunctionUtils.clickOnElement(driver, continue1Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue2Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue2Button);
		PageFunctionUtils.clickOnElement(driver, continue2Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue3Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue3Button);
		PageFunctionUtils.clickOnElement(driver, continue3Button);
		return this;
	}
	
	@Step("Press tenor details view button")
	public ABEVerifyExportBillsTradeFinancePage pressTenorDetailsViewButton1() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsViewButton1);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsViewButton1);
		mixedBillTenor1 = driver.findElement(billTenorDropDownList).getAttribute(FinacleFieldsUtils.ATTRIBUTETITLE);
		mixedBillAccountId1 = driver.findElement(tenorDetailsBillIdTextField).getAttribute(FinacleFieldsUtils.ATTRIBUTEVALUE);
		System.out.println(mixedBillTenor1 + " " + mixedBillAccountId1);
		return this;
	}
	
	@Step("Press tenor details view button")
	public ABEVerifyExportBillsTradeFinancePage pressTenorDetailsViewButton2() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsViewButton2);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsViewButton2);
		mixedBillTenor2 = driver.findElement(billTenorDropDownList).getAttribute(FinacleFieldsUtils.ATTRIBUTETITLE);
		mixedBillAccountId2 = driver.findElement(tenorDetailsBillIdTextField).getAttribute(FinacleFieldsUtils.ATTRIBUTEVALUE);
		System.out.println(mixedBillTenor2 + " " + mixedBillAccountId2);
		return this;
	}
	
	@Step("Press tenor details close button")
	public ABEVerifyExportBillsTradeFinancePage pressTenorDetailsCloseButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, tenorDetailsCloseButton);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsCloseButton);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue4Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue4Button);
		PageFunctionUtils.clickOnElement(driver, continue4Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue5Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue5Button);
		PageFunctionUtils.clickOnElement(driver, continue5Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue6Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue6Button);
		PageFunctionUtils.clickOnElement(driver, continue6Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue7Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue7Button);
		PageFunctionUtils.clickOnElement(driver, continue7Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue8Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue8Button);
		PageFunctionUtils.clickOnElement(driver, continue8Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue9Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue9Button);
		PageFunctionUtils.clickOnElement(driver, continue9Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue10Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue10Button);
		PageFunctionUtils.clickOnElement(driver, continue10Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue11Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue11Button);
		PageFunctionUtils.clickOnElement(driver, continue11Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue12Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue12Button);
		PageFunctionUtils.clickOnElement(driver, continue12Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue13Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue13Button);
		PageFunctionUtils.clickOnElement(driver, continue13Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue14Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue14Button);
		PageFunctionUtils.clickOnElement(driver, continue14Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue15Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue15Button);
		PageFunctionUtils.clickOnElement(driver, continue15Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue16Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue16Button);
		PageFunctionUtils.clickOnElement(driver, continue16Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue17Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue17Button);
		PageFunctionUtils.clickOnElement(driver, continue17Button);
		return this;
	}
	
	@Step("Press continue button")
	public ABEVerifyExportBillsTradeFinancePage pressContinue18Button() throws Exception {
		PageFunctionUtils.waitOnElement(driver, continue18Button);
		PageFunctionUtils.clickOnElement(driver, continue18Button);
		return this;
	}
	
	@Step("Press submit button")
	public ABEVerifyExportBillsTradeFinancePage pressSubmitButton() throws Exception {
		PageFunctionUtils.waitOnElement(driver, submitButton);
		PageFunctionUtils.clickOnElement(driver, submitButton);
		return this;
	}
}