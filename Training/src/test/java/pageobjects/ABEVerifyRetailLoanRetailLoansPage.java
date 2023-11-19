package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class ABEVerifyRetailLoanRetailLoansPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By acidTextField = By.xpath("(//input[@id='_tempForacid'])[1]");
	private By GoButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By continueButtonBasic = By.xpath("(//button[@id='_btn_continueBasic'])[1]");
	private By continueButtonDetails = By.xpath("(//button[@id='_btn_continueLoandet'])[1]");
	private By continueButtonRelatedParty = By.xpath("(//button[@id='_btn_continueRelP'])[1]");
	private By continueButtoninterest = By.xpath("(//button[@id='_btn_continueint'])[1]");
	private By continueButtonFees = By.xpath("(//button[@id='_btn_continueFee'])[1]");
	private By continueButtonRepayment = By.xpath("(//button[@id='_btn_continueRepayParm'])[1]");
	private By continueButtonSched = By.xpath("(//button[@id='_btn_continueRepaySchdet'])[1]");												
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");

	
	
	public ABEVerifyRetailLoanRetailLoansPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name: {0}")
	public ABEVerifyRetailLoanRetailLoansPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public ABEVerifyRetailLoanRetailLoansPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}

	@Step("Sending a/c. id: {0}")
	public ABEVerifyRetailLoanRetailLoansPage sendKeysAcidTextField(String ACID) throws Exception {
		ACID = ACID.substring(1);
		PageFunctionUtils.waitOnElement(driver, acidTextField);
		driver.findElement(acidTextField).click();
		driver.findElement(acidTextField).sendKeys(ACID);
		driver.findElement(GoButton).click();
		return this;
	}
	
	@Step("Sending a/c. id: {0}")
	public ABEVerifyRetailLoanRetailLoansPage PressGoButton() throws Exception {
		driver.findElement(GoButton).click();
		return this;
	}
	
	@Step("Pressing basic Continue buttons:")
	public ABEVerifyRetailLoanRetailLoansPage PressContinueButtonBasic() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continueButtonBasic);


		return this;
	}
	
	@Step("Pressing details Continue buttons:")
	public ABEVerifyRetailLoanRetailLoansPage PressContinueButtonDetails() throws Exception {
		PageFunctionUtils.clickOnElement(driver,continueButtonDetails );
		
		return this;
	}

	@Step("Pressing related party Continue buttons:")
	public ABEVerifyRetailLoanRetailLoansPage PressContinueButtonRelatedParty() throws Exception {
		PageFunctionUtils.clickOnElement(driver,continueButtonRelatedParty );
		return this;
	}
	
	@Step("Pressing interest Continue buttons:")
	public ABEVerifyRetailLoanRetailLoansPage PressContinueButtoninterest() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver, continueButtoninterest);
		return this;
	}
	
	@Step("Pressing fees Continue buttons:")
	public ABEVerifyRetailLoanRetailLoansPage PressContinueButtonFees() throws Exception {
		PageFunctionUtils.clickOnElement(driver,continueButtonFees );
		
		return this;
	}
	
	@Step("Pressing repayment Continue buttons:")
	public ABEVerifyRetailLoanRetailLoansPage PressContinueButtonRepayment() throws Exception {
		PageFunctionUtils.clickOnElement(driver, continueButtonRepayment);
		return this;
	}
	
	@Step("Pressing interest Continue buttons:")
	public ABEVerifyRetailLoanRetailLoansPage PressContinueButtonSched() throws Exception {
	
		PageFunctionUtils.clickOnElement(driver, continueButtonSched);
		return this;
	}
	
	
	@Step("Pressing Submit button:")
	public ABEVerifyRetailLoanRetailLoansPage PressSubmitButton() throws Exception {
		
		PageFunctionUtils.clickOnElement(driver, submitButton);

		return this;
	}
	

}
