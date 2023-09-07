package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utils.PageFunctionUtils;

public class FinacleLoginPage {
	
	private By loginIframe = By.xpath("//*[@id=\"SSODiv\"]/iframe");
	private By usernameTextfield = By.xpath("//*[@id=\"usertxt\"]");
	private By passwordTextfield = By.xpath("//*[@id=\"passtxt\"]");
	private By loginButton = By.xpath(String.format("//*[@id=\"Submit\"]"));
	private WebDriver driver;
	
	public FinacleLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Login with username: {0}")
	public FinacleLoginPage sendKeysUserNameTextfield(String keysToSend) throws Exception {

		driver.switchTo().frame(driver.findElement(loginIframe));
		PageFunctionUtils.enterDataInWebElement(driver, usernameTextfield, keysToSend);
		return this;
	}
	
	@Step("Login with password: {1}")
	public FinacleLoginPage sendKeysPasswordTextfield(String keysToSend) throws Exception {
		PageFunctionUtils.enterDataInWebElement(driver, passwordTextfield, keysToSend);
		return this;
	}
	
	@Step("Press Login Button")
	public FinacleLoginPage clickOnLoginButton(String keysToSend){
		PageFunctionUtils.clickOnElement(driver, loginButton);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		  try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	    		PageFunctionUtils.enterDataInWebElement(driver, passwordTextfield, keysToSend);
	    		PageFunctionUtils.clickOnElement(driver, loginButton);
	        } catch (Exception e) {
	        }
		return this;
	}
}