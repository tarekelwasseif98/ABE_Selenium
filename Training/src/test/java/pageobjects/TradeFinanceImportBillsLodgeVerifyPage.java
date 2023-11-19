package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.CSVUtils;
import utils.FinacleFieldsUtils;
import utils.PageFunctionUtils;
import utils.Paths;

public class TradeFinanceImportBillsLodgeVerifyPage {
	
	private WebDriver driver;
	private By searchBarTextField = By.id("menuSelect");
	private By searchButton = By.id("menuSearcherGo");
	private By loginFrameIframeID = By.xpath("(//iframe[@name='loginFrame'])[1]");
	private By formAreaIframeID =By.xpath("//iframe[@name='formArea']"); 
	private String loginFrameById= "loginFrame";
	private String coreAbeFrameById= "Core_ABE";
	private String uxFrameById= "UX";
	private By billIdTextField = By.xpath("(//input[@id='_billIdOthers'])[1]");
	private By goButton = By.xpath("(//button[normalize-space()='Go'])[1]");
	private By submitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
	private By tab1 = By.xpath("(//span[@id='fbmparty_textSpan'])[1]");
	private By tab2 = By.xpath("(//span[@id='fbmtenor_textSpan'])[1]");
	private By tab3 = By.xpath("(//span[@id='fbmbill_textSpan'])[1]");
	private By tab4 = By.xpath("(//span[@id='fbmreal_textSpan'])[1]");
	private By tab5 = By.xpath("(//span[@id='fbmevent_textSpan'])[1]");
	private By tab6 = By.xpath("(//span[@id='tfccharge_textSpan'])[1]");
	private By tab7 = By.xpath("(//span[@id='fbmtran_textSpan'])[1]");
	private By id1 = By.xpath("(//tr)[2]");
	private By id2 = By.xpath("(//tr)[3]");
	private By tenorDetailsViewButton1 = By.xpath("(//span[@class='viewcontent'])[1]");
	private By tenorDetailsViewButton2 = By.xpath("(//span[@class='viewcontent'])[2]");
	private By billTenorDropDownList = By.xpath("(//select[@id='_billTenor_select'])[1]");
	private By tenorDetailsBillIdTextField = By.xpath("(//input[@id='_tenor_BillId'])[1]");
	private By tenorDetailsCloseButton = By.xpath("(//button[@id='_tenordetails_closeBtn'])[1]");
	public static String tcIdCsvColumnName = "tcId";
	public static String  acceptLinkedTcidCsvColumnName = "acceptLinkedTcid";
	public static String  verifyAcceptLinkedTcidCsvColumnName = "verifyAcceptLinkedTcid";
	public static String  purchaseLinkedTcidCsvColumnName = "purchaseLinkedTcid";
	public static String  verifyPurchaseLinkedTcidCsvColumnName = "verifyPurchaseLinkedTcid";
	public static String  realizeLinkedTcidCsvColumnName = "realizeLinkedTcid";
	public static String  verifyRealizeLinkedTcidCsvColumnName = "verifyRealizeLinkedTcid";
	public static String  mixedBillId1CsvColumnName = "mixedBillId1";
	public static String  mixedBillId2CsvColumnName = "mixedBillId2";
	public static String mixedBillAccountId1;
	public static String mixedBillAccountId2;
	public static boolean mixedBillTenor2IsDisplayedAccept;
	public static boolean mixedBillTenor2IsDisplayedVerifyAccept;
	public static boolean mixedBillTenor2IsDisplayedPurchase;
	public static boolean mixedBillTenor2IsDisplayedVerifyPurchase;
	public static boolean mixedBillTenor2IsDisplayedRealize;
	public static boolean mixedBillTenor2IsDisplayedVerifyRealize;
	public static String mixedBillTenor1 = null;
	public static String mixedBillTenor2 = null;

	public TradeFinanceImportBillsLodgeVerifyPage(WebDriver driver) {
		this.driver = driver;
	}
	

	@Step("Sending menu name: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage sendKeysSearchBarTextField(String menu) throws Exception {
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
	public TradeFinanceImportBillsLodgeVerifyPage switchFormAreaFrame() throws Exception {
		PageFunctionUtils.sleep();
		driver.switchTo().parentFrame();
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, loginFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, coreAbeFrameById);
	    PageFunctionUtils.waitOnFrameAndSwitchId(driver, uxFrameById);
		PageFunctionUtils.waitOnFrameAndSwitchXpath(driver, formAreaIframeID);
		return this;	
	}
	
	@Step("Sending bill id: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage sendKeysBillId(String billId) throws Exception {

		PageFunctionUtils.waitOnElement(driver, billIdTextField);
		PageFunctionUtils.clickOnElement(driver,billIdTextField);
		PageFunctionUtils.enterDataInWebElement(driver,billIdTextField,billId.substring(1));
		return this;
	}
	
	@Step("press go button: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressGoButton() throws Exception {

		PageFunctionUtils.clickOnElement(driver,goButton);
		return this;
	}
	
	@Step("press submit button: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressSubmitButton() throws Exception {
		PageFunctionUtils.clickOnElement(driver,submitButton);
		PageFunctionUtils.acceptWarning(driver);
			
			
		return this;
	}
	
	@Step("press side tabs: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressSideTab1() throws Exception {

		PageFunctionUtils.clickOnElement(driver,tab1);


		return this;
	}
	
	@Step("press side tabs: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressSideTab2() throws Exception {

		PageFunctionUtils.clickOnElement(driver,tab2);

		return this;
	}
	
	@Step("press side tabs: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressSideTab3() throws Exception {

	
		PageFunctionUtils.clickOnElement(driver,tab3);
	

		return this;
	}
	
	@Step("press side tabs: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressSideTab4() throws Exception {

	
		PageFunctionUtils.clickOnElement(driver,tab4);

		return this;
	}
	
	@Step("press side tabs: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressSideTab5() throws Exception {

		
		PageFunctionUtils.clickOnElement(driver,tab5);
	

		return this;
	}
	
	@Step("press side tabs: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressSideTab6() throws Exception {

		
		PageFunctionUtils.clickOnElement(driver,tab6);

		return this;
	}
	
	@Step("press side tabs: {0}")
	public TradeFinanceImportBillsLodgeVerifyPage pressSideTab7() throws Exception {

		
		PageFunctionUtils.clickOnElement(driver,tab7);

		return this;
	}
	
	
	@Step("get id1 attribute:")
	public TradeFinanceImportBillsLodgeVerifyPage id1Attribute() throws Exception {
		driver.findElement(id1).getText();
			
			
		return this;
	}
	
	@Step("get id2 attribute:")
	public TradeFinanceImportBillsLodgeVerifyPage id2Attribute() throws Exception {
		driver.findElement(id2).getText();
			
			
		return this;
	}
	
	@Step("Press tenor details view button")
	public TradeFinanceImportBillsLodgeVerifyPage pressTenorDetailsViewButton1() throws Exception {
		mixedBillAccountId1 = null;
		PageFunctionUtils.waitOnElement(driver, tenorDetailsViewButton1);
		PageFunctionUtils.clickOnElement(driver, tenorDetailsViewButton1);
		mixedBillTenor1 = driver.findElement(billTenorDropDownList).getAttribute(FinacleFieldsUtils.ATTRIBUTETITLE);
		mixedBillAccountId1 = driver.findElement(tenorDetailsBillIdTextField).getAttribute(FinacleFieldsUtils.ATTRIBUTEVALUE);
		System.out.println( mixedBillTenor1+" "+mixedBillAccountId1);

		return this;
	}
	
	@Step("Press tenor details view button")
	public TradeFinanceImportBillsLodgeVerifyPage pressTenorDetailsViewButton2() throws Exception {
		try {
			mixedBillAccountId2 = null;
			mixedBillTenor2IsDisplayedAccept = false;
			mixedBillTenor2IsDisplayedVerifyAccept = false;
			mixedBillTenor2IsDisplayedPurchase = false;
			mixedBillTenor2IsDisplayedVerifyPurchase = false;
			mixedBillTenor2IsDisplayedRealize = false;
			mixedBillTenor2IsDisplayedVerifyRealize = false;
			PageFunctionUtils.waitOnElement(driver, tenorDetailsViewButton2);
			mixedBillTenor2IsDisplayedAccept = PageFunctionUtils.elementIsDisplayed(driver, tenorDetailsViewButton2);
			mixedBillTenor2IsDisplayedVerifyAccept = PageFunctionUtils.elementIsDisplayed(driver, tenorDetailsViewButton2);
			mixedBillTenor2IsDisplayedPurchase = PageFunctionUtils.elementIsDisplayed(driver, tenorDetailsViewButton2);
			mixedBillTenor2IsDisplayedVerifyPurchase = PageFunctionUtils.elementIsDisplayed(driver, tenorDetailsViewButton2);
			mixedBillTenor2IsDisplayedRealize = PageFunctionUtils.elementIsDisplayed(driver, tenorDetailsViewButton2);
			mixedBillTenor2IsDisplayedVerifyRealize = PageFunctionUtils.elementIsDisplayed(driver, tenorDetailsViewButton2);
			PageFunctionUtils.clickOnElement(driver, tenorDetailsViewButton2);
			mixedBillTenor2 = driver.findElement(billTenorDropDownList).getAttribute(FinacleFieldsUtils.ATTRIBUTETITLE);
			mixedBillAccountId2 = driver.findElement(tenorDetailsBillIdTextField).getAttribute(FinacleFieldsUtils.ATTRIBUTEVALUE);
			System.out.println( mixedBillTenor2 + " "+mixedBillAccountId2);
		} catch(Exception e) {
			
		}
		return this;
	}
	
	@Step("Press tenor details close button")
	public TradeFinanceImportBillsLodgeVerifyPage pressTenorDetailsCloseButton() throws Exception {
		try {
			PageFunctionUtils.waitOnElement(driver, tenorDetailsCloseButton);
			PageFunctionUtils.clickOnElement(driver, tenorDetailsCloseButton);
		} catch(Exception e) {
			
		}
		return this;
	}
	
		@Step("Save bill id")
	public TradeFinanceImportBillsLodgeVerifyPage saveBillId(String acceptLinkedTcid, String verifyAcceptLinkedTcid, String realizeLinkedTcid, String verifyRealizeLinkedTcid) throws Exception {
			if(acceptLinkedTcid != null) {
				int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, acceptLinkedTcidCsvColumnName, acceptLinkedTcid);
				int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, acceptLinkedTcid);
				int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, mixedBillId1CsvColumnName);
				int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, mixedBillId2CsvColumnName);
				if(rowByTcid1 != -1 && rowByTcid2 != -1) {
					if(mixedBillTenor2IsDisplayedAccept) {
						if((mixedBillTenor1.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) && (mixedBillTenor2.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE))) {
							CSVUtils.insertValueInCsvCell(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid2, columnByColumnName1, mixedBillAccountId1);
							CSVUtils.insertValueInCsvCell(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid2, columnByColumnName2, mixedBillAccountId2);
						}
						else if((mixedBillTenor1.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) && (mixedBillTenor2.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT))) {
							CSVUtils.insertValueInCsvCell(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid2, columnByColumnName1, mixedBillAccountId1);
						}
						else if((mixedBillTenor1.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT)) && (mixedBillTenor2.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE))) {
							CSVUtils.insertValueInCsvCell(Paths.ABEACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid2, columnByColumnName2, mixedBillAccountId2);
						}
						mixedBillTenor2IsDisplayedAccept = false;
					}
				}
				if(verifyAcceptLinkedTcid != null) {
					int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, verifyAcceptLinkedTcidCsvColumnName, verifyAcceptLinkedTcid);
					int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyAcceptLinkedTcid);
					int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, mixedBillId1CsvColumnName);
					int columnByColumnName4 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, mixedBillId2CsvColumnName);
					if(rowByTcid3 != -1 && rowByTcid4 != -1) {
						if(mixedBillTenor2IsDisplayedVerifyAccept) {
							if((mixedBillTenor1.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)) && (mixedBillTenor2.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE))) {
								CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, mixedBillAccountId1);
							CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName4, mixedBillAccountId2);
								}
							else if(((mixedBillTenor1 != null) && (mixedBillTenor1.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE))) && ((mixedBillTenor2 != null) && (mixedBillTenor2.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT)))) {
								CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, mixedBillAccountId1);
								}
							else if(((mixedBillTenor1 != null) && (mixedBillTenor1.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORSIGHT))) && ((mixedBillTenor2 != null) && (mixedBillTenor2.equalsIgnoreCase(FinacleFieldsUtils.BILLTENORUSANCE)))) {
								CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYACCEPTIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName4, mixedBillAccountId2);
								}
							mixedBillTenor2IsDisplayedVerifyAccept = false;
							}
						}
					}
				}
			
			if(realizeLinkedTcid != null) {
				int rowByTcid1 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, realizeLinkedTcidCsvColumnName, realizeLinkedTcid);
				int rowByTcid2 = CSVUtils.getRowByTcid(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, realizeLinkedTcid);
				int columnByColumnName1 = CSVUtils.getColumnByColumnName(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, mixedBillId1CsvColumnName);
				int columnByColumnName2 = CSVUtils.getColumnByColumnName(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, mixedBillId2CsvColumnName);
				if(rowByTcid1 != -1 && rowByTcid2 != -1) {
					if(mixedBillTenor2IsDisplayedRealize) {
						CSVUtils.insertValueInCsvCell(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, rowByTcid2, columnByColumnName1, mixedBillAccountId1);
						CSVUtils.insertValueInCsvCell(Paths.ABEREALIZEIMPORTBILLSTRADEFINANCECSV, rowByTcid2, columnByColumnName2, mixedBillAccountId2);
						}
					mixedBillTenor2IsDisplayedRealize = false;
					}
				if(verifyRealizeLinkedTcid != null) {
					int rowByTcid3 = CSVUtils.getRowByTcid(Paths.ABETRADEFINANCEIMPORTBILLSLODGEVERIFYCSV, verifyRealizeLinkedTcidCsvColumnName, verifyRealizeLinkedTcid);
					int rowByTcid4 = CSVUtils.getRowByTcid(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, tcIdCsvColumnName, verifyRealizeLinkedTcid);
					int columnByColumnName3 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, mixedBillId1CsvColumnName);
					int columnByColumnName4 = CSVUtils.getColumnByColumnName(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, mixedBillId2CsvColumnName);
					if(rowByTcid3 != -1 && rowByTcid4 != -1) {
						if(mixedBillTenor2IsDisplayedVerifyRealize) {
							CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName3, mixedBillAccountId1);
							CSVUtils.insertValueInCsvCell(Paths.ABEVERIFYREALIZEIMPORTBILLSTRADEFINANCECSV, rowByTcid4, columnByColumnName4, mixedBillAccountId2);
							}
						mixedBillTenor2IsDisplayedVerifyRealize = false;
						}
					}
				}
			return this;
			}
	
}
