package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.PageFunctionUtils;

public class OpenSavingsAccountPage {
	private WebDriver driver;
	private By searchBar = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private String UX_iframeID = "UX";
	
	private By formArea_iframeID =By.xpath("//iframe[@name='formArea']"); 
	private By CIFID = By.xpath("(//input[@id='_critCif'])[1]");
	private By SchemeCode = By.xpath("(//input[@id='_critSchmCode'])[1]");
	private By SOLID = By.xpath("(//input[@id='_solId'])[1]");
	private By GO = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By Continue = By.xpath("(//button[@id='_acctDetCon'])[1]");
	private By TaxDetails = By.xpath("(//a[@id='stepII10_anchor'])[1]");
	private By TaxCategory = By.id("_wtaxFlg_select");
	private By SUBMIT = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By loginFrame_iframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By Core_ABE_iframeID = By.xpath("//iframe[@name='Core_ABE']");
	public OpenSavingsAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public OpenSavingsAccountPage sendKeysMenuName(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.sync2(driver, loginFrame_iframeID);
			PageFunctionUtils.sync(driver, searchBar);
	        PageFunctionUtils.enterDataInWebElement(driver, searchBar, menu);
	        PageFunctionUtils.clickOnElement(driver, searchButton);
	        
	        return this;
	}
	
	public OpenSavingsAccountPage addAccountDetails(String val) throws Exception {
		
		Thread.sleep(6000);
		driver.switchTo().parentFrame();
		PageFunctionUtils.sync2(driver, loginFrame_iframeID);
		PageFunctionUtils.sync2(driver, Core_ABE_iframeID);
		driver.switchTo().frame((UX_iframeID));
		PageFunctionUtils.sync2(driver, formArea_iframeID);
		PageFunctionUtils.sync(driver, CIFID);

		driver.findElement(CIFID);
		driver.findElement(CIFID).click();
		driver.findElement(CIFID).sendKeys(val);
		
		driver.findElement(CIFID);
		driver.findElement(SchemeCode).click();
		driver.findElement(SchemeCode).sendKeys("1700");
		
		driver.findElement(SOLID);
		driver.findElement(SOLID).click();
		driver.findElement(SOLID).clear();
		driver.findElement(SOLID).sendKeys("2588");
		
		driver.findElement(GO);
		driver.findElement(GO).click();
		
		driver.findElement(Continue);
		driver.findElement(Continue).click();
		
		driver.findElement(TaxDetails);
		driver.findElement(TaxDetails).click();
		
		Select dropdown = new Select(driver.findElement(TaxCategory));
		dropdown.selectByIndex(2);
		
		driver.findElement(SUBMIT);
		driver.findElement(SUBMIT).click();
	    
		Thread.sleep(3500);
		
		return this;
	}
}