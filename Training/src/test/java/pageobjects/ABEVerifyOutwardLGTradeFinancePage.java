package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyOutwardLGTradeFinancePage {

	

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']");
	private String loginFrameIframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	
	private By guaranteeIdTextField = By.xpath("(//input[@id='_guarno_fetch'])[1]");	
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");			

	
	private By generalDetailsContinueButton = By.xpath("(//button[@id='_ogmgendtls_gendet_Continue'])[1]");
	private By partyContinueButton = By.xpath("(//button[@id='_ogmpartydtls_partydet_Continue'])[1]");
	private By guaranteeContinueButton = By.xpath("(//button[@id='_ogmguarntee_guarentedet_Continue'])[1]");
	private By limitContinueButton = By.xpath("(//button[@id='_limit_limit_Continue'])[1]");
	private By marginContinueButton = By.xpath("(//button[@id='_margin_margin_Continue'])[1]");
	private By chargesContinueButton = By.xpath("(//button[@id='_charge_charge_Continue'])[1]");
	private By instructionContinueButton = By.xpath("(//button[@id='_meobinstr_instructContineBtn'])[1]");
	private By tracerContinueButton = By.xpath("(//button[@id='_ogmtracer_tracerdet_FinButton1'])[1]");
	private By textContinueButton = By.xpath("(//button[@id='_textdet_textdet_Continue'])[1]");
	
	private By messageContinueButton = By.xpath("(//button[@id='_messagedetails_msgdet_Continue'])[1]");
	
	
	private By viewFirstMessageButton = By.xpath("(//span[@class='viewcontent'])[4]");
	private By viewSecondMessageButton = By.xpath("(//span[@class='viewcontent'])[5]");
	
	private By acceptFirstMessageButton   = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By closeFirstMessageButton = By.xpath("(//button[@id='_messagedetails_messagedet_closeBtn'])[1]");
	
	private By acceptSecondMessageButton = By.xpath("(//button[@id='_messagedetails_messageContinue'])[1]");
	private By closeSecondMessageButton = By.xpath("(//button[@id='_messagedetails_messagedet_closeBtn'])[1]");
	
	private By paymentStatusDropdown = By.xpath("(//select[@id='_messagedetails_hid_mesdet_payStat_select'])[1]");
	
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	
	

	
	public ABEVerifyOutwardLGTradeFinancePage(WebDriver driver) {
		this.driver = driver;
	}
		
	

	@Step("Sending menu name: {0}")
	public ABEVerifyOutwardLGTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyOutwardLGTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		PageFunctionUtils.switchToParentFrame(driver);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameIframeId);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeIframeId);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxIframeId);
		PageFunctionUtils.waitOnElement(driver, but);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending a/c. id: {0}")
	public ABEVerifyOutwardLGTradeFinancePage sendKeysAccountIdTextField(String guaranteeId) throws Exception {		
		PageFunctionUtils.waitOnElement(driver, guaranteeIdTextField);
		PageFunctionUtils.waitOnElement(driver, guaranteeIdTextField);	
		PageFunctionUtils.enterDataInWebElement(driver, guaranteeIdTextField, guaranteeId.substring(1));
				
		return this;
	}
	
	
	@Step("press on go button")
	public ABEVerifyOutwardLGTradeFinancePage pressGoButton() throws Exception {	
		PageFunctionUtils.clickOnElement(driver, goButton);	
			return this;
	}
	
	
	@Step("press on general details continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressGeneralDetailsContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, generalDetailsContinueButton);
		PageFunctionUtils.clickOnElement(driver, generalDetailsContinueButton);
			return this;
	}
	
	
	@Step("press on party continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressPartyContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, partyContinueButton);
		PageFunctionUtils.clickOnElement(driver, partyContinueButton);
		return this;
}

	
	@Step("press on Guarantee continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressGuaranteeContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, guaranteeContinueButton);
		PageFunctionUtils.clickOnElement(driver, guaranteeContinueButton);
		return this;
}
	
	
	@Step("press on Limite continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressLimitContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, limitContinueButton);
		PageFunctionUtils.clickOnElement(driver, limitContinueButton);
		return this;
}

	
	@Step("press on margin continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressMarginContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, marginContinueButton);
		PageFunctionUtils.clickOnElement(driver, marginContinueButton);
		return this;
}

	
	@Step("press on charges continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressChargesContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, chargesContinueButton);
		PageFunctionUtils.clickOnElement(driver, chargesContinueButton);
		return this;
}
	

	


	@Step("press on instruction continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressInstructionContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, instructionContinueButton);
		PageFunctionUtils.clickOnElement(driver,instructionContinueButton);
		return this;
}
	
	
	

	@Step("press on Tracer continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressTracerContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, tracerContinueButton);
		PageFunctionUtils.clickOnElement(driver, tracerContinueButton);
		return this;
}
	
	
	
	
	

	@Step("press on text continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressTextContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, textContinueButton);
		PageFunctionUtils.clickOnElement(driver, textContinueButton);
		return this;
}
	
	
	@Step("press on first view message button")
	public ABEVerifyOutwardLGTradeFinancePage pressFirstViewMessageButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, viewFirstMessageButton);
		PageFunctionUtils.clickOnElement(driver, viewFirstMessageButton);
		return this;
}
	
	
	
	@Step("Select payment status: {0}")
	public ABEVerifyOutwardLGTradeFinancePage selectPaymentStatus(String paymentStatus) throws Exception {	
		PageFunctionUtils.waitOnElement(driver, paymentStatusDropdown);
		PageFunctionUtils.clickOnElement(driver, paymentStatusDropdown);
		return this;
}	
	
	
	@Step("press on accept button for first message")
	public ABEVerifyOutwardLGTradeFinancePage pressAcceptFirstMessageButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, acceptFirstMessageButton);
		PageFunctionUtils.clickOnElement(driver, acceptFirstMessageButton);
		return this;
}	
	
	
	@Step("press on close button for first message")
	public ABEVerifyOutwardLGTradeFinancePage pressCloseFirstMessageButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, closeFirstMessageButton);
		PageFunctionUtils.clickOnElement(driver, closeFirstMessageButton);
		return this;
}		
	
	
	
	
	
	@Step("press on second view message button")
	public ABEVerifyOutwardLGTradeFinancePage pressSecondViewMessageButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, viewSecondMessageButton);
		PageFunctionUtils.clickOnElement(driver, viewSecondMessageButton);
		return this;
}	
	
	
	
	@Step("Select payment status 2: {0}")
	public ABEVerifyOutwardLGTradeFinancePage select2PaymentStatus(String paymentStatus) throws Exception {	
		PageFunctionUtils.waitOnElement(driver, paymentStatusDropdown);
		PageFunctionUtils.clickOnElement(driver, paymentStatusDropdown);
		return this;
}	
	
	@Step("press on accept button for second message")
	public ABEVerifyOutwardLGTradeFinancePage pressAcceptSecondMessageButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, acceptSecondMessageButton);
		PageFunctionUtils.clickOnElement(driver, acceptSecondMessageButton);
		return this;
}	
	
	

	@Step("press on close button for second message")
	public ABEVerifyOutwardLGTradeFinancePage pressCloseSecondMessageButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, closeSecondMessageButton);
		PageFunctionUtils.clickOnElement(driver, closeSecondMessageButton);
		return this;
}	
	

	@Step("press on message continue button")
	public ABEVerifyOutwardLGTradeFinancePage pressMessageContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, messageContinueButton);
		PageFunctionUtils.clickOnElement(driver, messageContinueButton);
		return this;
}
	

	
		
	
	
	@Step("Press submit button")
	public ABEVerifyOutwardLGTradeFinancePage pressSubmitButton() throws Exception {		
		PageFunctionUtils.clickOnElement(driver, submitButton);
		PageFunctionUtils.closeWarning(driver);
		PageFunctionUtils.acceptWarning(driver);
		
		return this;
	}
	
	
	
	
	
	
	
	
}
