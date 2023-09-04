package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageFunctionUtils;

public class VerifyIslamicSavingsAccountPage {

	private WebDriver driver;
	private By searchBar = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By AC_ID = By.xpath("(//input[@id='_tempAcid'])[1]");
	private By Go_Button= By.xpath("(//button[normalize-space()='Go'])[1]");
	private By Submit_Button= By.xpath("(//button[normalize-space()='Submit'])[1]");
	private String loginFrame_iframeID = "loginFrame";
	private By but = By.xpath("(//a[@id='GlobalbgMenu_anchor'])[1]");
	private By formArea_iframeID =By.xpath("//iframe[@name='formArea']"); 

	
	public VerifyIslamicSavingsAccountPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public VerifyIslamicSavingsAccountPage sendKeysMenuName(String menu) throws Exception {
        Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame((loginFrame_iframeID));
		PageFunctionUtils.sync(driver, searchBar);
		PageFunctionUtils.enterDataInWebElement(driver, searchBar, menu);
        PageFunctionUtils.clickOnElement(driver, searchButton);	       
        
	return this;
}
	
	
public VerifyIslamicSavingsAccountPage addAccountDetails(String val) throws Exception {
	Thread.sleep(2000);
	driver.switchTo().parentFrame();
    driver.switchTo().frame(("loginFrame"));
    driver.switchTo().frame(("Core_ABE"));
    driver.switchTo().frame(("UX"));
	PageFunctionUtils.sync(driver, but);
	PageFunctionUtils.sync2(driver, formArea_iframeID);
	
	PageFunctionUtils.sync(driver, AC_ID);
	driver.findElement(AC_ID).click();
	driver.findElement(AC_ID).sendKeys(val);
	driver.findElement(Go_Button).click();
	driver.findElement(By.xpath("(//a[@id='stepII_anchor'])[1]")).click();
	driver.findElement(By.xpath("(//a[@id='stepII4_anchor'])[1]")).click();
	driver.findElement(By.xpath("(//a[@id='stepII10_anchor'])[1]")).click();
	driver.findElement(By.xpath("(//a[@id='stepII5_anchor'])[1]")).click();
	driver.findElement(By.xpath("(//a[@id='stepII7_anchor'])[1]")).click();
	driver.findElement(By.xpath("(//a[@id='stepII3_anchor'])[1]")).click();
	driver.findElement(By.xpath("(//a[@id='stepII1_anchor'])[1]")).click();
	driver.findElement(By.xpath("(//a[@id='stepII19_anchor'])[1]")).click();
	driver.findElement(Submit_Button).click();
    driver.switchTo().parentFrame();
	driver.findElement(By.xpath("(//button[normalize-space()='Accept'])[1]")).click();
	
	return this;
		
	}
}