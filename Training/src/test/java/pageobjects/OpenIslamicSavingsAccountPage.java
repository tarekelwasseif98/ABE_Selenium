package pageobjects;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.PageFunctionUtils;
import utils.CSVPaths;

public class OpenIslamicSavingsAccountPage {
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private By cifIDTextField = By.xpath("(//input[@id='_critCif'])[1]");
	private By schemeCodeTextField = By.xpath("(//input[@id='_critSchmCode'])[1]");
	private By solIDTextField = By.xpath("(//input[@id='_solId'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By continueButton = By.xpath("(//button[@id='_acctDetCon'])[1]");
	private By taxDetailsMenu = By.xpath("(//a[@id='stepII10_anchor'])[1]");
	private By taxCategoryMenu = By.id("_wtaxFlg_select");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	public static String successMessage;
	public static String acid;
	
	public OpenIslamicSavingsAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Sending menu name")
	public OpenIslamicSavingsAccountPage sendKeysMenuName(String menu) throws Exception {
	     	driver.switchTo().parentFrame();
	     	PageFunctionUtils.sync2(driver, loginFrameIframeID);
			PageFunctionUtils.sync(driver, searchBarTextField);
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
	public OpenIslamicSavingsAccountPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.Sleep_5sec();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(("loginFrame"));
	    driver.switchTo().frame(("Core_ABE"));
	    driver.switchTo().frame(("UX"));
		PageFunctionUtils.sync2(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending Customer Details")
	public OpenIslamicSavingsAccountPage addAccountDetails(String cifid) throws Exception {
		PageFunctionUtils.sync(driver, cifIDTextField);
		driver.findElement(cifIDTextField);
		driver.findElement(cifIDTextField).click();
		driver.findElement(cifIDTextField).sendKeys(cifid);
		driver.findElement(cifIDTextField);
		driver.findElement(schemeCodeTextField).click();
		driver.findElement(schemeCodeTextField).sendKeys("1700");
		driver.findElement(solIDTextField);
		driver.findElement(solIDTextField).click();
		driver.findElement(solIDTextField).clear();
		driver.findElement(solIDTextField).sendKeys("2588");
		driver.findElement(goButton);
		driver.findElement(goButton).click();
		driver.findElement(continueButton);
		driver.findElement(continueButton).click();
		driver.findElement(taxDetailsMenu);
		driver.findElement(taxDetailsMenu).click();
		Select dropdown = new Select(driver.findElement(taxCategoryMenu));
		dropdown.selectByIndex(2);
		return this;
	}
	
	@Step("Press SUBMIT")
	public OpenIslamicSavingsAccountPage pressSubmit() throws Exception {
		driver.findElement(submitButton);
		driver.findElement(submitButton).click();
		Thread.sleep(3500);
		successMessage = driver.findElement(By.xpath("(//p[@id='_resMsg_paraMsg'])[1]")).getText().substring(0, 43);
		acid = driver.findElement(By.xpath("(//p[@id='_resMsg_paraMsg'])[1]")).getText().substring(53, 71);
		System.out.println("ACID : "+ acid);
		
		int columnIndex = 5;
		int columnIndex2 = 7;
		int oisacRowIndexToUpdate = CSVUtils.getNextEmptyCellIndex(CSVPaths.OISAC_CSV, 7);
		int visaoRowIndexToUpdate = CSVUtils.getNextEmptyCellIndex(CSVPaths.VISAO_CSV, 5);
		CSVReader oisacReader = new CSVReader(new FileReader(CSVPaths.OISAC_CSV));
		CSVReader visaoReader = new CSVReader(new FileReader(CSVPaths.VISAO_CSV));
		List<String[]> oisacLines = oisacReader.readAll();
		List<String[]> visaoLines = visaoReader.readAll();
		oisacReader.close();
		visaoReader.close();
		
		if(oisacRowIndexToUpdate < oisacLines.size()) {
		    String[] row = oisacLines.get(oisacRowIndexToUpdate);
		    row[columnIndex2] = "'" + acid;
		    oisacLines.set(oisacRowIndexToUpdate, row);
		}
		
		if(visaoRowIndexToUpdate < visaoLines.size()) {
		    String[] row = visaoLines.get(visaoRowIndexToUpdate);
		    row[columnIndex] = "'" + acid;
		    visaoLines.set(visaoRowIndexToUpdate, row);
		}
		
		CSVWriter oisacWriter = new CSVWriter(new FileWriter(CSVPaths.OISAC_CSV));
		CSVWriter visaoWriter = new CSVWriter(new FileWriter(CSVPaths.VISAO_CSV));
		oisacWriter.writeAll(oisacLines,false);
		visaoWriter.writeAll(visaoLines,false);
		oisacWriter.flush();
		visaoWriter.flush();
		oisacWriter.close();
		visaoWriter.close();
		return this;
	}
}