package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEAcceptImportBillTradeFinancePage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By billIdTextField = By.xpath("(//input[@id='_billIdOthers'])[1]");
	private By tenorBillIdTextField = By.xpath("(//input[@id='_tenorBillId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By tenorEditButton = By.xpath("(//span[@class='editcontent'])[1]");
	private By acceptanceDateField = By.xpath("(//input[@id='_acceptDate'])[1]");
	private By updateButton = By.xpath("(//button[@id='_tenordetails_updateSummary'])[1]");
	private By billDetailsTab = By.xpath("(//span[@id='fbmbill_textSpan'])[1]");
	private By eventDetailsTab = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By chargeDetailsTab = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By transactionDetailsTab = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
			
	
	
	@Step("Sending menu name: {0}")
	public ABEAcceptImportBillTradeFinancePage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEAcceptImportBillTradeFinancePage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
//	
//	@Step("Sending Gl subhead code: {0}")
//	public ABECreateOfficeAccountFinancePage sendKeysGlSubHeadCode(String GeneralLedgerSubhead) throws Exception {
//		
//		PageFunctionUtils.waitOnElement(driver, );
//		PageFunctionUtils.clickOnElement(driver,);
//		PageFunctionUtils.enterDataInWebElement(driver,,GeneralLedgerSubhead);
//		
//
//		return this;
//	}
}
