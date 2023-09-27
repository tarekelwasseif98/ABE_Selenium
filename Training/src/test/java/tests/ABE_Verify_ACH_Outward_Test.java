//
//  package tests;
//  
//  import java.util.List;
//  import org.openqa.selenium.WebDriver; 
//  import org.testng.ITestResult; 
//  import org.testng.annotations.AfterMethod; 
//  import org.testng.annotations.BeforeMethod; 
//  import org.testng.annotations.DataProvider;
//  import org.testng.annotations.Listeners;
//  import org.testng.annotations.Test; 
//  import com.aspose.cells.Workbook; 
//  import data.JsonReader;
//  import data.VerifyACHOutwardData;
//  import data.VerifyIslamicCurrentAccountData; 
//  import io.qameta.allure.Allure; 
//  import io.qameta.allure.Attachment; 
//  import io.qameta.allure.testng.AllureTestNg; 
//  import pageobjects.FinacleLoginPage;
//  import procedures.VerifyIslamicCurrentAccountProcedures; 
//  import utils.AssertionFactory; 
//  import utils.Properties; 
//  import utils.ScreenshotHelper; 
//  import utils.WebdriverFactory; 
//  import utils.Paths;
//  
//  @Test(groups = "verify", dependsOnGroups = "createACH")
//  
//  @Listeners({ AllureTestNg.class }) public class ABE_Verify_ACH_Outward_Test {
//  
//  WebDriver driver = null;
//  
//  @BeforeMethod(description = "Initiating Browser") 
//  
//  public void beforeTest(Object[] testData) throws Exception {
//  VerifyACHOutwardData data = (VerifyACHOutwardData)
//  testData[0]; driver = WebdriverFactory.initiateWebDriver();
//  driver.get(Properties.FinacleUrl); 
//  FinacleLoginPage FinacleLoginPage = new FinacleLoginPage(driver);
//  FinacleLoginPage.sendKeysUserNameTextField(data.getUsername()).sendKeysPasswordTextField(data.getPassword()).clickOnLoginButton(data.getPassword()); 
//  
//  }
//  
//  
//   @dataprovider(name="verify ach outward dataprovider")
//   
//  public object[] dpmethod() throws exception { 
//workbook workbook = new workbook(Paths.VerifyIslamicSavingsAccountCsv); 
//  workbook.save(paths.verifyislamiccurrentaccountjson); 
//  class<verifyislamiccurrentaccountdata> targetclass = 
//  verifyislamiccurrentaccountdata.class; 
//  jsonreader<verifyislamiccurrentaccountdata> jsonreader = new // *
//  jsonreader<>(targetclass); list<verifyislamiccurrentaccountdata> datalist =
//  jsonreader.readjsonfile(paths.verifyislamiccurrentaccountjson); // *
//  datalist.toarray(); return datalist.toarray(); } // * // * <<<<<<<
//  head:training/src/test/java/tests/ // *
//  abe_verifyislamicsavingsaccount_mudarabahsba.java // * //
//  
//  @test(dataprovider = "verify islamic savings account dataprovider", // *
//  dataproviderclass = abe_verifyislamicsavingsaccount_mudarabahsba.class) // *
//  public void verifyislamicsavingsaccounttest(verifyislamicsavingsaccountdata
//  // * data) throws exception { //allure.getlifecycle().updatetestcase(tc -> //
//  tc.setname("test case id: " + testcaseid)); allure.parameter("tcid: ", // *
//  data.gettcid()); allure.parameter("summary: ", data.getsummary()); // *
//  allure.parameter("username: ", data.getusername()); // *
//  allure.parameter("menu: ", data.getmenu()); allure.parameter("account id: ",
//  // * data.getaccountid()); allure.parameter("expected result: ", // *
//  data.getexpectedresult()); // * // *
//  verifyislamicsavingsaccountprocedures.islamicsavingsaccountbychecker(driver,
//  // * data); ======= // * // * @test(dataprovider =
//  "verify islamic current account dataprovider", // * dataproviderclass =
//  abe_verifyislamiccurrentaccount_mudarabahcaa_test.class) // * public void
//  verifyislamiccurrentaccounttest(verifyislamiccurrentaccountdata // * data)
//  throws exception { allure.getlifecycle().updatetestcase(tc -> // *
//  tc.setname("test case id: " + data.gettcid())); allure.parameter("data: ", //
//  data.tostring()); // *
//  verifyislamiccurrentaccountprocedures.islamiccurrentaccountbychecker(driver,
//  data); assertionfactory.checkexpectedresult(driver.
//  data.getexpectedresult());
//  f326dc4bab08ab0450dc67107b6d076bdf5d2e19:training/src/test/java/tests
//  abe_verifyislamiccurrentaccount_mudarabahcaa_test.java }
//  
//  @Attachment(value = "Screenshot", type = "image/png")
//  
//  @AfterMethod public void after(ITestResult result) throws
//  InterruptedException { Thread.sleep(1000); if (result.getStatus() ==
//  ITestResult.SUCCESS) { ScreenshotHelper.captureScreenshot(driver); } if
//  (result.getStatus() == ITestResult.FAILURE) {
//  ScreenshotHelper.captureScreenshot(driver); } driver.quit(); } }
// 