
package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyOVDPage {

	private WebDriver driver;
	private String loginFrameIframeId = "loginFrame";
	private String coreAbeIframeId = "Core_ABE";
	private String uxIframeId = "UX";
	private By formAreaIframeID = By.xpath("//iframe[@name='formArea']");
	private String loginFrameIframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	
	private By accountIdTextField = By.xpath("(//input[@id='_tempAcid'])[1]");	
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");				
	private By additionalContinueButton = By.xpath("(//button[@id='_acctDetCon'])[1]");

	private By generalContinueButton = By.xpath("(//button[@id='_genContinue'])[1]");	
	private By signatureContinueButton = By.xpath("(//button[@id='_sigMandCon'])[1]");	
	private By accountContinueButton = By.xpath("(//button[@id='_actLmtCont'])[1]");	
	private By interestContinueButton = By.xpath("(//button[@id='_intcontinue'])[1]");		
	private By schemeContinueButton = By.xpath("(//button[@id='_schmCont'])[1]");	
	private By revolvingContinueButton = By.xpath("(//button[@id='_revolODCont'])[1]");	
	private By relatedContinueButton = By.xpath("(//button[@id='_relcontinue'])[1]");
	private By collateralContinueButton = By.xpath("(//button[@id='_linkCont'])[1]");
	
	private By documentContinueButton = By.xpath("(//button[@id='_docDtlCont1'])[1]");
	private By taxContinueButton = By.xpath("(//button[@id='_taxCont'])[1]");
	private By taxcontinueButton2 = By.xpath("(//button[@id='_nomCont'])[1]");
	
	private By exceptionContinueButton = By.xpath("(//button[@id='_execContinue'])[1]");
	private By bankEmployeeContinueButton = By.xpath("(//button[@id='_staffCont1'])[1]");
	private By flexifixedContinueButton = By.xpath("(//button[@id='_ffd_ButtCon'])[1]");
	private By paymentContinueButton = By.xpath("(//button[@id='_payICont'])[1]");
	private By chargeContinueButton = By.xpath("(//button[@id='_feeDetCont'])[1]");
	private By baseContinueButton = By.xpath("(//button[@id='_baselCont'])[1]");	
	private By missContinueButton = By.xpath("(//button[@id='_misContinue'])[1]");

	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");	

	
	
		
	

	public ABEVerifyOVDPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@Step("Sending menu name: {0}")
	public ABEVerifyOVDPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyOVDPage switchFormAreaFrame() throws Exception {
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
	public ABEVerifyOVDPage sendKeysAccountIdTextField(String accountId) throws Exception {		
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);	
		PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
				
		return this;
	}
	
	
	@Step("press on go button")
	public ABEVerifyOVDPage pressGoButton() throws Exception {	
		PageFunctionUtils.clickOnElement(driver, goButton);	
			return this;
	}
	
	
	@Step("press on Additional continue button ")
	public ABEVerifyOVDPage pressAdditionalContinueButton() throws Exception {		
	     PageFunctionUtils.waitOnElement(driver, additionalContinueButton);
	     PageFunctionUtils.clickOnElement(driver, additionalContinueButton);
	   return this;
	}
	     
	
	@Step("press on general continue button ")
	public ABEVerifyOVDPage pressGeneralContinueButton() throws Exception {		
	     PageFunctionUtils.waitOnElement(driver, generalContinueButton);
	     PageFunctionUtils.clickOnElement(driver, generalContinueButton);
	     return this;
	}   
	
	
	@Step("press on signature continue button ")
	public ABEVerifyOVDPage pressSignatureContinueButton() throws Exception {				     
	     PageFunctionUtils.waitOnElement(driver, signatureContinueButton);
	     PageFunctionUtils.clickOnElement(driver, signatureContinueButton);
	   return this;
	}
	   
	@Step("press on Account continue button ")
	public ABEVerifyOVDPage pressAccountContinueButton() throws Exception {				     		
	     PageFunctionUtils.waitOnElement(driver, accountContinueButton);
	     PageFunctionUtils.clickOnElement(driver, accountContinueButton);
	    return this; 
	} 
	
	@Step("press on Interest continue button ")
	public ABEVerifyOVDPage pressInterestContinueButton() throws Exception {				     		
	     PageFunctionUtils.waitOnElement(driver, interestContinueButton);
	     PageFunctionUtils.clickOnElement(driver, interestContinueButton);
	    return this; 
	}  
	
	@Step("press on scheme continue button ")
	public ABEVerifyOVDPage pressSchemeContinueButton() throws Exception {				     		
	     PageFunctionUtils.waitOnElement(driver, schemeContinueButton);
	     PageFunctionUtils.clickOnElement(driver, schemeContinueButton);
	     return this;
	}   
	
	@Step("press on revolving continue button ")
	public ABEVerifyOVDPage pressRevolvingContinueButton() throws Exception {				     		
	     PageFunctionUtils.waitOnElement(driver, revolvingContinueButton);
	     PageFunctionUtils.clickOnElement(driver, revolvingContinueButton);
	    return this; 
	}	
	
	@Step("press on related continue button ")
	public ABEVerifyOVDPage pressRelatedContinueButton() throws Exception {				     		
	     PageFunctionUtils.waitOnElement(driver, relatedContinueButton);
	     PageFunctionUtils.clickOnElement(driver, relatedContinueButton);
	     return this;	     
	}     
	
	@Step("press on collateral continue button ")
	public ABEVerifyOVDPage pressCollateralContinueButton() throws Exception {				     		
	     PageFunctionUtils.waitOnElement(driver, collateralContinueButton);
	     PageFunctionUtils.clickOnElement(driver, collateralContinueButton);    
	     return this;
	}

	
	
	
	
	
	@Step("press on document continue button ")
 	public ABEVerifyOVDPage pressDocumentContinueButton() throws Exception {
			 PageFunctionUtils.waitOnElement(driver, documentContinueButton);
		     PageFunctionUtils.clickOnElement(driver, documentContinueButton);
	        
	 return this;       
	}
	
	@Step("press on tax continue button ")
 	public ABEVerifyOVDPage pressTaxContinueButton() throws Exception {
	         PageFunctionUtils.waitOnElement(driver, taxContinueButton);
		     PageFunctionUtils.clickOnElement(driver, taxContinueButton);
		     PageFunctionUtils.waitOnElement(driver, taxcontinueButton2);
		     PageFunctionUtils.clickOnElement(driver, taxcontinueButton2);
		 
	return this;	     
	}
	
	
	@Step("press on exception continue button ")
 	public ABEVerifyOVDPage pressExceptionContinueButton() throws Exception {	        
		     PageFunctionUtils.waitOnElement(driver, exceptionContinueButton);
		     PageFunctionUtils.clickOnElement(driver, exceptionContinueButton);
	return this;	
	}
	
	@Step("press on bank continue button ")
 	public ABEVerifyOVDPage pressBankContinueButton() throws Exception {	        	
		     PageFunctionUtils.waitOnElement(driver, bankEmployeeContinueButton);
		     PageFunctionUtils.clickOnElement(driver, bankEmployeeContinueButton);
		     return this;
	}    
	
	@Step("press on flexi continue button ")
 	public ABEVerifyOVDPage pressFlexiContinueButton() throws Exception {	        	
		     PageFunctionUtils.waitOnElement(driver, flexifixedContinueButton);
		     PageFunctionUtils.clickOnElement(driver, flexifixedContinueButton);
		     return this;
	}  
	
	@Step("press on bank continue button ")
 	public ABEVerifyOVDPage pressPaymentContinueButton() throws Exception {	        	
		     PageFunctionUtils.waitOnElement(driver, paymentContinueButton);
		     PageFunctionUtils.clickOnElement(driver, paymentContinueButton);
		return this;
	}
	
	@Step("press on charge continue button ")
 	public ABEVerifyOVDPage pressChargeContinueButton() throws Exception {	        	
		     PageFunctionUtils.waitOnElement(driver, chargeContinueButton);
		     PageFunctionUtils.clickOnElement(driver, chargeContinueButton);
	 return this;
	}
	
	@Step("press on base continue button ")
 	public ABEVerifyOVDPage pressBaseContinueButton() throws Exception {	        	
		     PageFunctionUtils.waitOnElement(driver, baseContinueButton);
		     PageFunctionUtils.clickOnElement(driver, baseContinueButton);
		     return this;
	}    
	
	@Step("press on base continue button ")
 	public ABEVerifyOVDPage pressMissContinueButton() throws Exception {	        	
		     PageFunctionUtils.waitOnElement(driver, missContinueButton);
		     PageFunctionUtils.clickOnElement(driver, missContinueButton);		                                       
	return this;
}


	
	@Step("Press submit button")
	public ABEVerifyOVDPage pressSubmitButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver, submitButton);	
		PageFunctionUtils.acceptWarning(driver);
		
		return this;
	}
}