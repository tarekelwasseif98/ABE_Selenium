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

public class ABEVerifyInwardGuaranteePage {


	

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
	
	
	
	
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	
	private By guranteeId = By.xpath("(//div[@id='_success_guarNo_text'])[1]");
	
	

	public static String acId;
	public static String  guaranteeInwardCsvColumnName = "guaranteeNumberReferenceId";
	public static String  guaranteeOutwardNumberIdCsvColumnName = "guaranteeNumberId";
	
	
	
	
	public static String  tcIdCsvColumnName = "tcId";
	public static String  linkedTcidInwardCsvColumnName = "linkedTcid2";  

	
	public ABEVerifyInwardGuaranteePage(WebDriver driver) {
		this.driver = driver;
	}
		
	

	@Step("Sending menu name: {0}")
	public ABEVerifyInwardGuaranteePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyInwardGuaranteePage switchFormAreaFrame() throws Exception {
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
	public ABEVerifyInwardGuaranteePage sendKeysAccountIdTextField(String guaranteeNumberId) throws Exception {		
		PageFunctionUtils.waitOnElement(driver, guaranteeIdTextField);
		PageFunctionUtils.waitOnElement(driver, guaranteeIdTextField);	
		PageFunctionUtils.enterDataInWebElement(driver, guaranteeIdTextField, guaranteeNumberId.substring(1));
				
		return this;
	}
	
	
	@Step("press on go button")
	public ABEVerifyInwardGuaranteePage pressGoButton() throws Exception {	
		PageFunctionUtils.clickOnElement(driver, goButton);	
			return this;
	}
	
	
	@Step("press on general details continue button")
	public ABEVerifyInwardGuaranteePage pressGeneralDetailsContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, generalDetailsContinueButton);
		PageFunctionUtils.clickOnElement(driver, generalDetailsContinueButton);
			return this;
	}
	
	
	@Step("press on party continue button")
	public ABEVerifyInwardGuaranteePage pressPartyContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, partyContinueButton);
		PageFunctionUtils.clickOnElement(driver, partyContinueButton);
		return this;
}

	
	@Step("press on Guarantee continue button")
	public ABEVerifyInwardGuaranteePage pressGuaranteeContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, guaranteeContinueButton);
		PageFunctionUtils.clickOnElement(driver, guaranteeContinueButton);
		return this;
}
	
	
	@Step("press on Limite continue button")
	public ABEVerifyInwardGuaranteePage pressLimitContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, limitContinueButton);
		PageFunctionUtils.clickOnElement(driver, limitContinueButton);
		return this;
}

	
	@Step("press on margin continue button")
	public ABEVerifyInwardGuaranteePage pressMarginContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, marginContinueButton);
		PageFunctionUtils.clickOnElement(driver, marginContinueButton);
		return this;
}

	
	@Step("press on charges continue button")
	public ABEVerifyInwardGuaranteePage pressChargesContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, chargesContinueButton);
		PageFunctionUtils.clickOnElement(driver, chargesContinueButton);
		return this;
}
	

	


	@Step("press on instruction continue button")
	public ABEVerifyInwardGuaranteePage pressInstructionContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, instructionContinueButton);
		PageFunctionUtils.clickOnElement(driver,instructionContinueButton);
		return this;
}
	
	
	

	@Step("press on Tracer continue button")
	public ABEVerifyInwardGuaranteePage pressTracerContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, tracerContinueButton);
		PageFunctionUtils.clickOnElement(driver, tracerContinueButton);
		return this;
}
	
	
	
	
	

	@Step("press on text continue button")
	public ABEVerifyInwardGuaranteePage pressTextContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, textContinueButton);
		PageFunctionUtils.clickOnElement(driver, textContinueButton);
		return this;
}
	
	
	
	

	@Step("press on message continue button")
	public ABEVerifyInwardGuaranteePage pressMessageContinueButton() throws Exception {	
		PageFunctionUtils.waitOnElement(driver, messageContinueButton);
		PageFunctionUtils.clickOnElement(driver, messageContinueButton);
		return this;
}
	

	
		
	
	
	
	@Step("Press submit button")
	public ABEVerifyInwardGuaranteePage pressSubmitButton() throws Exception {
		
	   PageFunctionUtils.waitOnElement(driver, submitButton);
	   PageFunctionUtils.clickOnElement(driver, submitButton);
	   PageFunctionUtils.acceptWarning(driver);
		Thread.sleep(3500);
		acId = driver.findElement(guranteeId).getText();
		System.out.println("Guarantee Number ID: "+ acId); 
		return this;
	}



	@Step("Save guarantee. id")
	public ABEVerifyInwardGuaranteePage saveGuaranteeId(String linkedTcid2) throws Exception {
	int rowByTcid1 = CSVUtils.getRowByTcid(Paths.VERIFYINWARDGUARANTEECSV, linkedTcidInwardCsvColumnName, linkedTcid2);
	int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.VERIFYINWARDGUARANTEECSV, guaranteeInwardCsvColumnName);


	int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, linkedTcidInwardCsvColumnName, linkedTcid2);
	int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, guaranteeOutwardNumberIdCsvColumnName);



	if(rowByTcid1 != -1 && rowByTcid2 != -1) {

		CSVUtils.insertValueInCsvCell(Paths.VERIFYINWARDGUARANTEECSV, rowByTcid1, columnByColumnName1, acId);
		CSVUtils.insertValueInCsvCell(Paths.ISSUEOUTWARDLGTRADEFINANCECSV, rowByTcid2, columnByColumnName2, acId);
		

	}
	return this;
	}

	
	
	
	
}
