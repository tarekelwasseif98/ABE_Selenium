package utils;

import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;

public class AssertionFactory {
	public static void checkExpectedResult(WebDriver driver, String expectedResult) {
		AssertJUnit.assertTrue(driver.getPageSource().contains(expectedResult));
	}
	
	public static void assertionFailWithMessage(String message) {
		AssertJUnit.fail(message);
	}
	
	public static void assertionFail() {
		AssertJUnit.fail();
	}
}