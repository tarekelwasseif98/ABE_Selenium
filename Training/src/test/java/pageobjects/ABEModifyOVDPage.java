
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

public class ABEModifyOVDPage {

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
	private By expiryDateField = By.xpath("(//input[@id='_acLmtExpDte'])[1]");
    
	
	private By drawingPowerOptions = By.xpath("(//h2[normalize-space()='Drawing Power Details'])[1]");
	private By drawingPowerIdicatorMenu = By.xpath("(//select[@id='_drawinPwrInd_select'])[1]");
	private By drawingPowerField = By.xpath("(//input[@id='_drawPwrPcnt'])[1]");
	
	private By limitIdField1 = By.xpath("(//input[@id='_limitid$prefix'])[1]");
	private By limitIdField2 = By.xpath("(//input[@id='_limitid$suffix'])[1]");
	
	
	private By statementFrequencyRadioButton = By.xpath("(//input[@id='_pbPsFlg$minFreqReq1Radio3_radio'])[1]");
	private By statementFrequencyMonthField = By.xpath("(//input[@id='_pbPsFlg$minStatementFreq1$duration1'])[1]");
	private By statementFrequencyDayField = By.xpath("(//input[@id='_pbPsFlg$minStatementFreq1$duration2'])[1]");

	
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");	

	
	
			

	public ABEModifyOVDPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEModifyOVDPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEModifyOVDPage switchFormAreaFrame() throws Exception {
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
	public ABEModifyOVDPage sendKeysAccountIdTextField(String accountId) throws Exception {
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);
		PageFunctionUtils.waitOnElement(driver, accountIdTextField);	
	    PageFunctionUtils.enterDataInWebElement(driver, accountIdTextField, accountId.substring(1));
	    return this;
	}
		
	@Step("press on go button")
	public ABEModifyOVDPage pressGoButton() throws Exception {	
		PageFunctionUtils.clickOnElement(driver, goButton);	
			return this;
	}
	


	@Step("Modify ExpiryDate :{0}")
	public ABEModifyOVDPage modifyExpiryDateField(String expiryDate) throws Exception {
			    PageFunctionUtils.waitOnElement(driver, expiryDateField);		
			PageFunctionUtils.clearDataInWebElement(driver,expiryDateField );
			PageFunctionUtils.clickOnElement(driver, expiryDateField);
			PageFunctionUtils.enterDataInWebElement(driver, expiryDateField, expiryDate);
			return this;
	}
	
	
	@Step("press submit button")
	public ABEModifyOVDPage pressSubmitButton() throws Exception {
			PageFunctionUtils.clickOnElement(driver, submitButton);
			PageFunctionUtils.acceptWarning(driver);
	return this;		
	}
	
	

	@Step("press on Frequency button: {0}")
	public ABEModifyOVDPage pressFrequencyButton() throws Exception {
			    PageFunctionUtils.waitOnElement(driver, statementFrequencyRadioButton);		  
			    PageFunctionUtils.clickOnElement(driver,statementFrequencyRadioButton );
			    return this;
	}
			    
	@Step("Modify Frequency month: {0}")
	public ABEModifyOVDPage modifyFrequencyMonthField(String frequencyMonth) throws Exception {					    
			    PageFunctionUtils.waitOnElement(driver, statementFrequencyMonthField);		
				PageFunctionUtils.clickOnElement(driver, statementFrequencyMonthField);
				PageFunctionUtils.enterDataInWebElement(driver, statementFrequencyMonthField, frequencyMonth);
				return this;
	}  

	
	@Step("Modify Frequency day: {0}")
	public ABEModifyOVDPage modifyFrequencyDayField(String frequencyDay) throws Exception {						    
				PageFunctionUtils.waitOnElement(driver, statementFrequencyDayField);		
				PageFunctionUtils.clickOnElement(driver, statementFrequencyDayField);
				PageFunctionUtils.enterDataInWebElement(driver, statementFrequencyDayField, frequencyDay);				
				PageFunctionUtils.clickOnElement(driver, submitButton);
				 return this;				
		}
	
	
	@Step("select drawing power : {0}")
	public ABEModifyOVDPage selectFromDropdownMenu(String dropdownMenu) throws Exception {
        	PageFunctionUtils.waitOnElement(driver, drawingPowerOptions);
			PageFunctionUtils.clickOnElement(driver, drawingPowerOptions);			
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIdicatorMenu, dropdownMenu);
			return this;
        }
	
	@Step("enter drawing power details: {0}")
	public ABEModifyOVDPage sendkeysLimitFields(String limitId1, String limitId2) throws Exception {
			PageFunctionUtils.waitOnElement(driver, limitIdField1);
			PageFunctionUtils.clickOnElement(driver, limitIdField1);
			PageFunctionUtils.enterDataInWebElement(driver, limitIdField1, limitId1.substring(1));	
			PageFunctionUtils.waitOnElement(driver, limitIdField2);
			PageFunctionUtils.clickOnElement(driver, limitIdField2);
			PageFunctionUtils.enterDataInWebElement(driver, limitIdField2, limitId2);
	return this;		
	}	
	
	@Step("enter drawing power details: {0}")
	public ABEModifyOVDPage sendkeysDrawingPowerField(String drawingPowerPrecentage) throws Exception {
        	PageFunctionUtils.waitOnElement(driver, drawingPowerField);	
			PageFunctionUtils.clearDataInWebElement(driver,drawingPowerField);
			PageFunctionUtils.clickOnElement(driver, drawingPowerField);
			PageFunctionUtils.enterDataInWebElement(driver, drawingPowerField, drawingPowerPrecentage);
	return this;
	}
		
	@Step("press submit button: {0}")
	public ABEModifyOVDPage pressSubmitButton2() throws Exception {
			PageFunctionUtils.clickOnElement(driver, submitButton);
			PageFunctionUtils.acceptWarning(driver);
			return this;
	}	
        
        	
     @Step("select drawing power options: {0}")
      public ABEModifyOVDPage selectDrawingPowerOptions(String dropdownMenu) throws Exception {
 			PageFunctionUtils.waitOnElement(driver, drawingPowerOptions);
			PageFunctionUtils.clickOnElement(driver, drawingPowerOptions);
			PageFunctionUtils.selectDropDownListByVisibleText(driver, drawingPowerIdicatorMenu, dropdownMenu);
			PageFunctionUtils.clickOnElement(driver, submitButton);
			PageFunctionUtils.acceptWarning(driver);
			return this;
		}
        
            		

}